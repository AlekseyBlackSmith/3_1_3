package app.springboot.service;

import app.springboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUserById(Long id);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByEmailWithRoles(String email);
    List<User> getAllUsers();
    User getUserByIdWithRoles(Long id);
}