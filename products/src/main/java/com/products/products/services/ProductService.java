package com.products.products.services;

import com.products.products.entities.Product;
import com.products.products.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Page<Product> findAll(Pageable pageable) throws Exception {
        try {
            Page<Product> entities = this.productRepository.findAll(pageable);
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public List<Product> findAll() throws Exception {
        try {
            List<Product> entities = this.productRepository.findAll();
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Product findById(Long id) throws Exception {
        try {
            Optional<Product> entity = this.productRepository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            return entity.get();
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Product save(Product entity) throws Exception {
        try {
            return this.productRepository.save(entity);
        } catch (Exception e) {
            throw new Exception("Error saving entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Product update(Long id, Product entity) throws Exception {
        try {
            Optional<Product> entityOptional = this.productRepository.findById(id);
            if (entityOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            Product entityUpdate = entityOptional.get();
            entityUpdate = this.productRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception("Error updating entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Product entityOptional = this.productRepository.findById(id).orElseThrow(() -> new Exception("Entity with ID " + id + " not found"));
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
