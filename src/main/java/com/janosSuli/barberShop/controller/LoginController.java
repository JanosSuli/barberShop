package com.janosSuli.barberShop.controller;

import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.dao.dataSourceUtils.DataSourceManager;
import com.janosSuli.barberShop.model.UserModel;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataSourceManager.getUserDao();
        if (userDao.find("Admin").getId() == 0) {
            adminInit();
        }
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataSourceManager.getUserDao();
        UserModel user;

        String userName = request.getParameter("loginUserName");
        String password = request.getParameter("loginPassword");

        String loginError = "Username or Password is incorrect. Please try again.";

        if (userName.equals("") || password.equals("")) {
            request.setAttribute("error", loginError);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

        user = userDao.find(userName);

        if (user.getId() == 0) {
            request.setAttribute("error", loginError);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

        if (BCrypt.checkpw(password, user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getUserName());
            if (user.isAdmin()) {
                session.setAttribute("userRights", "Admin");
            } else
                session.setAttribute("userRights", "Customer");
        }

        response.sendRedirect("/dashboard");

    }

    private void adminInit() {

        UserDao userDao = DataSourceManager.getUserDao();
        UserModel admin = new UserModel("Admin", "admin@gmail.com", "admin");
        admin.setAdmin(true);
        userDao.add(admin);

    }

}
