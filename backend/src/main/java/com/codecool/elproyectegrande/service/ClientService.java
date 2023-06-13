package com.codecool.elproyectegrande.service;


import com.codecool.elproyectegrande.controller.dto.NewClientDTO;
import com.codecool.elproyectegrande.dao.model.Product;
import com.codecool.elproyectegrande.dao.user.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codecool.elproyectegrande.dao.model.Client;

import java.util.List;

@Service
public class ClientService{

    private ClientDAO clientDAO;

    @Autowired
    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }


    public List<Client> getAllClients() {
        return clientDAO.findAll();
    }


    public Client getClientByID(Long id) {
        return clientDAO.getById(id);
    }



    public void addNewClient(NewClientDTO client) {
        Client newClient = Client.builder()
                .clientName(client.clientName())
                .password(client.password())
                .build();
        clientDAO.save(newClient);
    }

    public void updateClientByID(Long id, Client updateClient){
        Client currentClient = getClientByID(id);
        if (updateClient.getClientName() != null) currentClient.setClientName(updateClient.getClientName());
        if (updateClient.getPassword() != null) currentClient.setPassword(updateClient.getPassword());
    }

    public void deleteClientByID(Long id){
        clientDAO.deleteById(id);
    }

}
