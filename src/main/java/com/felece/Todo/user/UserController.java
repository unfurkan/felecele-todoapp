package com.felece.Todo.user;

import com.felece.Todo.todo.Todo;
import com.felece.Todo.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    TodoRepository todoRepository;

    @GetMapping(path ="/users")
    public String
    loadUsersPage(Model model){
        List<UserModel> userList =new ArrayList();
        userRepository.findAll().forEach(userList::add);
        model.addAttribute("userList",userList);
        return "users";
    }
    @GetMapping(path="users/{id}/todos")
    public String loadUserTodos(@PathVariable("id") Integer id,Model model){
        List<Todo> todoList=todoRepository.findByTodoUserUserId(id);
        model.addAttribute("todoList",todoList);
        return "userTodos";
    }
    @GetMapping(path ="/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping(path ="/")
    public
    String homeRegisterPAGE(Model model){
        return "homepage";
    }
    @GetMapping(path ="/users/newUser")
    public
    String loadNewUserPage(Model model){
        UserModel user =new UserModel();
        model.addAttribute("userModel",user);
       return "newUser";
    }


    @GetMapping(path ="/users/saveUser")
    public String saveUser(UserModel user){
        userRepository.save(user);
        return "redirect:/users";
    }


}
