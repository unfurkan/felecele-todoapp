package com.felece.Todo.todo;

import com.felece.Todo.security.MyUserDetail;
import com.felece.Todo.todoStatus.Status;
import com.felece.Todo.todoStatus.StatusRepository;
import com.felece.Todo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(path ="/todos")
    public String
    getUserTodo(@AuthenticationPrincipal MyUserDetail user, Model model){
        List<Todo> todoList =new ArrayList();
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")))
            todoRepository.findByTodoUserUserId(user.getUserId()).forEach(todoList::add);
        else{
            todoRepository.findAll().forEach(todoList::add);
        }
        model.addAttribute("todoList",todoList);
        return "todos";
    }
    @GetMapping(path ="/todos/edit/{todoId}")
    public String showEditPage(@PathVariable("todoId") Integer todoId,Model model){
        Todo todo = todoRepository.findById(todoId).get();
        List<Status> statusList =new ArrayList<>();
        statusRepository.findAll().forEach(statusList::add);
        model.addAttribute("todo",todo);
        model.addAttribute("statusList",statusList);
        return "editTodo";
    }


    @GetMapping(path ="/todos/newTodo")
    public String showNewTodoPage(Model model,@AuthenticationPrincipal MyUserDetail principal){
        Todo todo =new Todo();
        todo.setTodoUser(userRepository.findById(principal.getUserId()).get());

        List<Status> statusList =new ArrayList<>();
        statusRepository.findAll().forEach(statusList::add);

        model.addAttribute("todoModel",todo);
        model.addAttribute("statusList",statusList);

        return "todoForm";
    }
    @PostMapping(path="/todos/saveTodo")
    public String  saveTodo(@ModelAttribute("todoModel") Todo todo){
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @GetMapping(path ="todos/delete/{todoId}")
    public String deleteTodo(@PathVariable("todoId") Integer todoId) throws Exception {
        todoRepository.deleteById(todoId);
        return "redirect:/todos";
    }
}
