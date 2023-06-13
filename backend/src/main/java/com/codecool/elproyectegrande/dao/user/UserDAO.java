package com.codecool.elproyectegrande.dao.user;

import com.codecool.elproyectegrande.controller.dto.NewUserDTO;
import com.codecool.elproyectegrande.controller.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    void addNewUser(NewUserDTO newUser);
    List<UserDTO> getAllUsers();
    UserDTO getUserByID(int id);
}
