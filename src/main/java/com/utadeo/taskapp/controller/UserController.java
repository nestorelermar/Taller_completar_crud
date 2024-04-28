package com.utadeo.taskapp.controller;

import org.springframework.web.bind.annotation.*;

import com.utadeo.taskapp.dto.ApiResponse;
import com.utadeo.taskapp.model.User;
import com.utadeo.taskapp.service.IUserService;

import java.util.List;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("user")
public class UserController {

    private IUserService userService;

    UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse store(@RequestBody User user){
        
        User userStore = this.userService.createUser(user);
        return new ApiResponse(
            HttpStatus.CREATED.value(),
            "EL usuario ha sido creado",
            userStore
        );
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ApiResponse updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "El usuario se ha actualizado correctamente",
                null
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "El usuario se ha eliminado correctamente",
                null
        );
    }

}
