package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.controller.dto.NewUserDTO;
import com.codecool.elproyectegrande.controller.dto.UserDTO;
import com.codecool.elproyectegrande.dao.model.User;
import com.codecool.elproyectegrande.dao.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserDAO {
    private final List<User> users;

    @Autowired
    public UserService() {
        this.users = List.of(
                new User(0, "username0", "password0"),
                new User(1, "username1", "password1"),
                new User(2, "username2", "password2"),
                new User(3, "username3", "password3"),
                new User(4, "username4", "password4"),
                new User(5, "username5", "password5"),
                new User(6, "username6", "password6"),
                new User(7, "username7", "password7"),
                new User(8, "username8", "password8"),
                new User(9, "username9", "password9"),
                new User(10, "username10", "password10"),
                new User(11, "username11", "password11"),
                new User(12, "username12", "password12"),
                new User(13, "username13", "password13"),
                new User(14, "username14", "password14"),
                new User(15, "username15", "password15"),
                new User(16, "username16", "password16"),
                new User(17, "username17", "password17"),
                new User(18, "username18", "password18"),
                new User(19, "username19", "password19"),
                new User(20, "username20", "password20")
        );
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return users.stream().map(this::convertUserToDTO).toList();
    }

    @Override
    public UserDTO getUserByID(int id) {
        return convertUserToDTO(users.stream().filter(user -> user.getUserID() == id).findFirst().orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void addNewUser(NewUserDTO user) {
        users.add(convertDTOtoUser(user));
    }

    private User convertDTOtoUser(NewUserDTO userDTO) {
        return new User(users.size(), userDTO.username(), userDTO.password());
    }

    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(user.getUserID(), user.getUsername(), user.getPassword());
    }
}
