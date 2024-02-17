package com.cfp.service;

import com.cfp.entity.User;

public interface UserService {
    public void registerUser(User user);

    User save(User user);

    User getUserByUsername(String username);
}
