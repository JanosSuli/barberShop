package com.janosSuli.barberShop.controller;

import com.janosSuli.barberShop.dao.BookedTimeDao;
import com.janosSuli.barberShop.dao.dataSourceUtils.DataSourceManager;
import com.janosSuli.barberShop.model.BookedTimeModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminBookingInformationController", value = "/adminBookingInformation")
public class AdminBookingInformationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookedTimeDao bookedTimeDao = DataSourceManager.getBookedTimeDao();
        List<BookedTimeModel> bookedTimeList = bookedTimeDao.getAll();

        request.setAttribute("bookedDates", bookedTimeList);
        getServletContext().getRequestDispatcher("/adminBookingInformation.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookedTimeDao bookedTimeDao = DataSourceManager.getBookedTimeDao();
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));

        bookedTimeDao.delete(bookingId);
        response.sendRedirect("/adminBookingInformation");

    }

}
