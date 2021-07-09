package app.springboot.dto;

import app.springboot.model.User;

import java.util.Set;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String firstName;
    private String lastName;
    Set<Long> roles;

    public UserDto(Long id, String username, String password, Integer age, String firstName, String lastName, Long... roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = Set.of(roles);
    }

    public UserDto() {
    }

    public static User toUserFromDto(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAge(userDto.getAge());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Long> getRoles() {
        return roles;
    }

    public void setRoles(Set<Long> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listOfRolesId=" + roles +
                '}';
    }
}
