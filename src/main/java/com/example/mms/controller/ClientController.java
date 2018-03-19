package com.example.mms.controller;


import com.example.mms.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private ClientDao clientDao;

    @Autowired
    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public void getClient(@PathVariable Integer id) {
        System.out.println(clientDao.findOne(id));
    }
}
