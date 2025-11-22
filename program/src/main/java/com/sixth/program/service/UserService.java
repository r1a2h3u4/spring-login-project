package com.sixth.program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sixth.program.model.User;
import com.sixth.program.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User save(User user) {
        return repo.save(user);
    }

    public User getByEmail(String email) {
        return repo.findByEmail(email);
    }
}

