package com.example.mms.controller;


import com.example.mms.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (method = RequestMethod.GET, value = "/product")
public class ProductController {

    private ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping (method = RequestMethod.GET,value = "/{id}")
    public void getProductDao(@PathVariable Integer id){System.out.println(productDao.findOne(id));}
}

