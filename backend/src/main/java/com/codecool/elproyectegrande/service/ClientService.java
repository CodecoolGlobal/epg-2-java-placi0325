package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.dao.user.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientDAO {

    @Autowired
    public ClientService() {
        
    }

    /*@Override
    public List<UserDTO> getAllUsers() {
        return cli.stream().map(this::convertUserToDTO).toList();
    }

    @Override
    public UserDTO getUserByID(int id) {
        return convertUserToDTO(users.stream().filter(user -> user.getUserID() == id).findFirst().orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void addNewUser(NewUserDTO user) {
        users.add(convertDTOtoUser(user));
    }

    private Client convertDTOtoUser(NewUserDTO userDTO) {
        return new Client(users.size(), userDTO.username(), userDTO.password());
    }

    private UserDTO convertUserToDTO(Client user) {
        return new UserDTO(user.getUserID(), user.getUsername(), user.getPassword());
    }*/
}
