package com.trainWise.app.controller;

import com.trainWise.app.model.Client;
import com.trainWise.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping()
    public Client createClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }


}
