package com.janosSuli.barberShop.dao.dataImplementations.inMemory;

import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.model.UserModel;
import java.util.ArrayList;
import java.util.List;

public class UserDaoInMemory implements UserDao {

    private List<UserModel> userList = new ArrayList<>();
    private int userID = 1;

    {
        UserModel admin = new UserModel("Admin", "admin@gmail.com", "admin");
        admin.setId(userID);
        admin.setFullName("");
        admin.setPhoneNumber("");
        admin.setAdmin(true);
        userList.add(admin);
        userID += 1;

        UserModel guest = new UserModel("Guest", "guest@gmail.com", "guest");
        guest.setId(userID);
        guest.setFullName("");
        guest.setPhoneNumber("");
        userList.add(guest);
        userID += 1;
    }

    public UserDaoInMemory() {

    }

    @Override
    public void add(UserModel user) {

        user.setId(userID);
        user.setFullName("");
        user.setPhoneNumber("");
        userID += 1;
        userList.add(user);

    }

    @Override
    public void modify(UserModel editedUser) {

        for (UserModel user : userList) {
            if (user.getId() == editedUser.getId()) {
                user.setUserName(editedUser.getUserName());
                user.setFullName(editedUser.getFullName());
                user.setEmail(editedUser.getEmail());
                user.setPhoneNumber(editedUser.getPhoneNumber());
            }
        }

    }

    @Override
    public UserModel find(String userName) {

        for (UserModel user : userList) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return new UserModel();

    }
}
