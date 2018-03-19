package com.example.mms.controller;

import com.example.mms.dao.AddressDao;
import com.example.mms.dao.ClientDao;
import com.example.mms.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private AddressDao addressDao;
    private ClientDao clientDao;

    @Autowired
    public AddressController(AddressDao addressDao, ClientDao clientDao) {
        this.addressDao = addressDao;
        this.clientDao = clientDao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public void getAddress(@PathVariable Integer id) {
        System.out.println(addressDao.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create/{city}")
    public void createAddress(@PathVariable String city) {
        Address address = new Address("1", city, 1, "1", 1, 1, clientDao.findOne(1));
        addressDao.save(address);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "index"; //TODO это не работает!
    }
}
