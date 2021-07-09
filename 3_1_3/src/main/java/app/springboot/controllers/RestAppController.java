package app.springboot.controllers;

import app.springboot.dto.UserDto;
import app.springboot.model.Role;
import app.springboot.service.RoleService;
import app.springboot.service.UserService;
import app.springboot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class RestAppController {
    private final UserService userService;
    private final RoleService roleService;

    public RestAppController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<User>> showAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> showUserInfo(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto) {
        Set<Role> roles = new HashSet<>();
        for (Long id : userDto.getRoles()) {
            roles.add(roleService.getRoleById(id));
        }
        User user = UserDto.toUserFromDto(userDto);
        user.setRoles(roles);
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
        Set<Role> roles = new HashSet<>();
        for (Long id : userDto.getRoles()) {
            roles.add(roleService.getRoleById(id));
        }
        User user = UserDto.toUserFromDto(userDto);
        user.setRoles(roles);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("current")
    public ResponseEntity<User> getCurrentUser(Principal principal){
        return new ResponseEntity<>(userService.getUserByEmailWithRoles(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("roles")
    public ResponseEntity<List<Role>> getPossibleRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

}
