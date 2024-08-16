package com.projects.projects.repositories;

import com.projects.projects.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
}
