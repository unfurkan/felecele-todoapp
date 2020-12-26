package com.felece.Todo.todoStatus;

import com.felece.Todo.todo.Todo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer statusId;
    private String description;

    @OneToMany(mappedBy = "status")
    private List<Todo> todos;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
