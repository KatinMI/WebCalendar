package com.web.WebCalendar.service;

import com.web.WebCalendar.model.User;
import com.web.WebCalendar.util.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserService {
    void create(User user);
    List<User> getAllUser();
    User getUser(Long id);
    User getUserByLogin(String login);
    boolean update(User user, Long id);
    boolean delete(Long id);
}
