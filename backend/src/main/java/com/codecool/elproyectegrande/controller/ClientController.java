package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.controller.dto.ClientDTO;
import com.codecool.elproyectegrande.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class ClientController {

        private ClientService clientService;

        @Autowired
        public ClientController(ClientService clientService) {
            this.clientService = clientService;
        }

        /*@GetMapping
        public List<ClientDTO> getAllUsers(){return clientService.getAllUsers();
        @GetMapping("/{id}")
        public ClientDTO getUserByID(@PathVariable String id){
            return clientService.getUserByID(Integer.parseInt(id));
        }
        @PostMapping
        public void addNewProduct(@RequestBody NewUserDTO userDTO){
            clientService.addNewUser(userDTO);
        }*/
}