package com.janosSuli.barberShop.controller;

import com.janosSuli.barberShop.dao.BookedTimeDao;
import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.dao.dataSourceUtils.DataSourceManager;
import com.janosSuli.barberShop.model.BookedTimeModel;
import com.janosSuli.barberShop.model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookingController", value = "/booking")
public class BookingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataSourceManager.getUserDao();
        UserModel bookingUser = userDao.find((String) request.getSession().getAttribute("userName"));

        String inCompleteProfile = "Please complete your profile for booking!";

        if (bookingUser.getFullName().equals("") || bookingUser.getPhoneNumber().equals("")) {
            request.setAttribute("error", inCompleteProfile);
            request.setAttribute("userFullName", bookingUser.getFullName());
            request.setAttribute("userEmail", bookingUser.getEmail());
            request.setAttribute("userPhoneNumber", bookingUser.getPhoneNumber());
            getServletContext().getRequestDispatcher("/myProfile.jsp").forward(request, response);
        }

        request.setAttribute("userFullName", bookingUser.getFullName());
        getServletContext().getRequestDispatcher("/booking.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        BookedTimeDao bookedTimeDao = DataSourceManager.getBookedTimeDao();
        UserDao userDao = DataSourceManager.getUserDao();
        String completeBooking = "Your booking saved!";

        int userId = userDao.find((String) request.getSession().getAttribute("userName")).getId();
        String barber = request.getParameter("bookingBarber");
        String date = request.getParameter("years") + "." + request.getParameter("months") + "." + request.getParameter("days");
        String time = request.getParameter("hours") + ":" + request.getParameter("minutes") + " " + request.getParameter("ampm");

        bookedTimeDao.add(new BookedTimeModel(userId, barber, date, time));
        request.setAttribute("completeBooking", completeBooking);
        getServletContext().getRequestDispatcher("/booking.jsp").forward(request, response);

    }
}
