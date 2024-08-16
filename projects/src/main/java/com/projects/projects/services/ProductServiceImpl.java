package com.projects.projects.services;

import com.projects.projects.entities.Product;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

}
