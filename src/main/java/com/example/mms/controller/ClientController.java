package com.example.mms.controller;

import com.example.mms.dao.ClientDao;
import com.example.mms.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Controller
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

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String registerNewClient(@ModelAttribute("client") Client client) {
        client.setName("123");
        client.setSurname("123");
        client.setEmail("123");
        client.setBirthday(Timestamp.valueOf(LocalDate.of(1990, 1, 1).atStartOfDay()));
        System.out.println(client);
        clientDao.save(client);
        return "redirect:/client/register";
    }
}
