package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.controller.dto.NewUserDTO;
import com.codecool.elproyectegrande.controller.dto.UserDTO;
import com.codecool.elproyectegrande.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

        private UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public List<UserDTO> getAllUsers(){return userService.getAllUsers();}

        @GetMapping("/{id}")
        public UserDTO getUserByID(@PathVariable String id){
            return userService.getUserByID(Integer.parseInt(id));
        }
        @PostMapping
        public void addNewProduct(@RequestBody NewUserDTO userDTO){
            userService.addNewUser(userDTO);
        }
}