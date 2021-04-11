package com.janosSuli.barberShop.controller;

import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.dao.dataSourceUtils.DataSourceManager;
import com.janosSuli.barberShop.model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataSourceManager.getUserDao();
        String userName = request.getParameter("registerUserName");
        String userEmail = request.getParameter("registerEmail");
        String userPassword = request.getParameter("registerPassword");
        String userConfirmPassword = request.getParameter("registerConfirmPassword");

        String registrationError = "Password does not match the confirm password. Please try again!";
        String userNameExistError = "This Username is occupied. Please try another one!";
        String blankFieldError = "Please fill all the fields!";

        if (userName.equals("") || userEmail.equals("") || userPassword.equals("") || userConfirmPassword.equals("")) {
            request.setAttribute("error", blankFieldError);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }

        if (userDao.find(userName).getId() != 0) {
            request.setAttribute("error", userNameExistError);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }

        if (!userPassword.equals(userConfirmPassword)) {
            request.setAttribute("error", registrationError);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            userDao.add(new UserModel(userName, userEmail, userPassword));
            response.sendRedirect("/login");
        }

    }

}
