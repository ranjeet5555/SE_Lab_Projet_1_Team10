package com.cfp.service;

import com.cfp.entity.User;
import com.cfp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    @Override
    public void registerUser(User user) {
        repo.save(user);
    }


    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
