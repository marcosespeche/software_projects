package com.projects.projects.controllers;

import com.projects.projects.entities.Product;
import com.projects.projects.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductControllerImpl extends BaseControllerImpl<Product, ProductServiceImpl> implements ProductController{

}
