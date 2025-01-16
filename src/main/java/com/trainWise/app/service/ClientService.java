package com.trainWise.app.service;

import com.trainWise.app.model.Client;
import com.trainWise.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client update(Client client){
        return clientRepository.save(client);
    }


}
