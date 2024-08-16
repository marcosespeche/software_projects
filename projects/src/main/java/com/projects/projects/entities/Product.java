package com.projects.projects.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "product_code", unique = true, nullable = false)
    private Long productCode;

    @Column(name = "product_name", unique = true, nullable = false)
    private String productName;

}
