package com.felece.Todo.user;

import com.felece.Todo.todo.Todo;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String role;


    @OneToMany(mappedBy ="todoUser",cascade = ALL)
    private List<Todo> todoList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
