package com.web.WebCalendar.service.impl;

import com.web.WebCalendar.model.User;
import com.web.WebCalendar.service.UserService;
import com.web.WebCalendar.util.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepositiry;
    @Override
    public void create(User user) {
    userRepositiry.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepositiry.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepositiry.getReferenceById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepositiry.findByLogin(login);
    }

    @Override
    public boolean update(User user, Long id) {
        if(userRepositiry.existsById(id)){
            user.setId(id);
            userRepositiry.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(userRepositiry.existsById(id)){
            userRepositiry.deleteById(id);
            return true;
        }
        return false;
    }
}
