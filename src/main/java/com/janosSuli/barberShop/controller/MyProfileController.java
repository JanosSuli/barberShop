package com.janosSuli.barberShop.controller;

import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.dao.dataSourceUtils.DataSourceManager;
import com.janosSuli.barberShop.model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyProfileServlet", value = "/myProfile")
public class MyProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataSourceManager.getUserDao();
        UserModel editedUser = userDao.find((String) request.getSession().getAttribute("userName"));

        request.setAttribute("userFullName", editedUser.getFullName());
        request.setAttribute("userEmail", editedUser.getEmail());
        request.setAttribute("userPhoneNumber", editedUser.getPhoneNumber());
        getServletContext().getRequestDispatcher("/myProfile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        UserDao userDao = DataSourceManager.getUserDao();
        UserModel editedUser = userDao.find((String) request.getSession().getAttribute("userName"));
        String blankFieldError = "Please fill all the fields!";
        String completeMessage = "Your profile saved!";

        if (request.getParameter("modifyFullName").equals("") ||
                request.getParameter("modifyEmail").equals("") ||
                request.getParameter("modifyPhoneNumber").equals("")) {

            request.setAttribute("error", blankFieldError);
            getServletContext().getRequestDispatcher("/myProfile.jsp").forward(request, response);
        }

        editedUser.setFullName(request.getParameter("modifyFullName"));
        editedUser.setEmail(request.getParameter("modifyEmail"));
        editedUser.setPhoneNumber(request.getParameter("modifyPhoneNumber"));
        userDao.modify(editedUser);

        request.setAttribute("completeMessage", completeMessage);
        request.setAttribute("userFullName", editedUser.getFullName());
        request.setAttribute("userEmail", editedUser.getEmail());
        request.setAttribute("userPhoneNumber", editedUser.getPhoneNumber());
        getServletContext().getRequestDispatcher("/myProfile.jsp").forward(request ,response);
    }

}
