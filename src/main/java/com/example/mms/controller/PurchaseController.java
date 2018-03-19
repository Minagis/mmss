package com.example.mms.controller;

import com.example.mms.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Purchase")
public class PurchaseController {

    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseController(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public void getPurchaseDao(@PathVariable Integer id) {
        System.out.println(purchaseDao.findOne(id));
    }
}
