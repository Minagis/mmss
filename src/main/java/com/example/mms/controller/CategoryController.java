package com.example.mms.controller;

import com.example.mms.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping (method = RequestMethod.GET,value = "/category/{id}")
    public void getCategory(@PathVariable Integer id) {
        System.out.println(categoryDao.findOne(id));
    }

}
