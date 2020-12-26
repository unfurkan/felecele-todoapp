package com.felece.Todo.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<UserModel,Integer> {

    public List<UserModel> findByUsername(String username);


}
