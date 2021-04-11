package com.janosSuli.barberShop.dao.dataImplementations.inMemory;

import com.janosSuli.barberShop.dao.BookedTimeDao;
import com.janosSuli.barberShop.model.BookedTimeModel;

import java.util.ArrayList;
import java.util.List;

public class BookedTimeDaoInMemory implements BookedTimeDao {

    private List<BookedTimeModel> bookedTimeList = new ArrayList<>();
    private int Id = 1;

    @Override
    public void add(BookedTimeModel booking) {

        booking.setId(Id);
        Id += 1;
        bookedTimeList.add(booking);

    }

    @Override
    public void delete(int bookingId) {

        bookedTimeList.removeIf(bookedTimeModel -> bookedTimeModel.getId() == bookingId);

    }

    @Override
    public List<BookedTimeModel> getAll() {

        return bookedTimeList;

    }


}
