package app.springboot.service;

import app.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
    void saveUser(User user);
    User findUserByEmail(String email);
}