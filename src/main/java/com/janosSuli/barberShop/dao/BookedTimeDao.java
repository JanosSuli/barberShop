package com.janosSuli.barberShop.dao;

import com.janosSuli.barberShop.model.BookedTimeModel;

import java.util.List;

public interface BookedTimeDao {

    void add(BookedTimeModel booking);
    void delete(int bookingId);
    List<BookedTimeModel> getAll();

}
