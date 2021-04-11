package com.janosSuli.barberShop.dao.dataImplementations.database;

import com.janosSuli.barberShop.dao.BookedTimeDao;
import com.janosSuli.barberShop.model.BookedTimeModel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookedTimeDaoDatabase implements BookedTimeDao {

    private final DataSource dataSource;

    public BookedTimeDaoDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(BookedTimeModel booking) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "INSERT INTO bookeddates (userid, barber, bookeddate, bookedtime) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, booking.getUserId());
            preparedStatement.setString(2, booking.getBarber());
            preparedStatement.setString(3, booking.getBookedDate());
            preparedStatement.setString(4, booking.getBookedTime());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void delete(int bookingId) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "DELETE FROM bookeddates WHERE bookingId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bookingId);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public List<BookedTimeModel> getAll() {

        List<BookedTimeModel> bookedList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = ("SELECT bookingId, userFullName, userEmail, userPhoneNumber, barber, bookedDate, bookedTime " +
                    "FROM bookedDates INNER JOIN users ON users.userId = bookedDates.userID");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookedTimeModel bookedDate = new BookedTimeModel(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
                bookedDate.setId(resultSet.getInt(1));
                bookedList.add(bookedDate);
            }

            return bookedList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }
}
