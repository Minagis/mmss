package com.example.mms.controller;

import com.example.mms.dao.AddressDao;
import com.example.mms.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private AddressDao addressDao;

    @Autowired
    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Address getAddress(@PathVariable String id) {
        Integer addressId = Integer.valueOf(id);
        return addressDao.findAddressById(addressId);
    }
}
