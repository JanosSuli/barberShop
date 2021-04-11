package com.janosSuli.barberShop.dao;

import com.janosSuli.barberShop.model.UserModel;

public interface UserDao {

    void add(UserModel user);
    void modify(UserModel editedUser);
    UserModel find(String userName);

}
