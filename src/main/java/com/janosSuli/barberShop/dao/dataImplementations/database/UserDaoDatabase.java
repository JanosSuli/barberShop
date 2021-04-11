package com.janosSuli.barberShop.dao.dataImplementations.database;

import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.model.UserModel;

import javax.sql.DataSource;
import java.sql.*;

public class UserDaoDatabase implements UserDao {

    private final DataSource dataSource;

    public UserDaoDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(UserModel user) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "INSERT INTO users (username, userfullname, useremail, userphonenumber, userpassword, isadmin) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, "");
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, "");
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setBoolean(6, user.isAdmin());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void modify(UserModel editedUser) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "UPDATE users SET userfullname = ?, useremail = ?, userphonenumber = ? WHERE userid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, editedUser.getFullName());
            preparedStatement.setString(2, editedUser.getEmail());
            preparedStatement.setString(3, editedUser.getPhoneNumber());
            preparedStatement.setInt(4, editedUser.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public UserModel find(String userName) {
        try (Connection connection = dataSource.getConnection()) {

            UserModel user = new UserModel();
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setFullName(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPhoneNumber(resultSet.getString(5));
            user.setPassword(resultSet.getString(6));
            user.setAdmin(resultSet.getBoolean(7));

            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return new UserModel();
    }

}
