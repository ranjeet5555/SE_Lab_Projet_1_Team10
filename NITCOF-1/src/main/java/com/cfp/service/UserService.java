package com.cfp.service;

import com.cfp.entity.User;

public interface UserService {
    public void registerUser(User user);

    User getuserById(int id);

    User save(User user);
}
