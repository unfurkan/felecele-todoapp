package com.felece.Todo.todo;


import com.felece.Todo.todoStatus.Status;
import com.felece.Todo.user.UserModel;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoId;
    private String title;
    private String dueDate;

    @ManyToOne
    @JoinColumn(name="userID", nullable=false)
    private UserModel todoUser;


    @ManyToOne
    @JoinColumn(name="status_id", nullable=false)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public Todo() {
    }


    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public UserModel getTodoUser() {
        return todoUser;
    }

    public void setTodoUser(UserModel todoUser) {
        this.todoUser = todoUser;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
