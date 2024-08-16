package com.products.products.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", nullable = false, unique = true)
    private Long productCode;

    @Column(name = "product_name", nullable = false, unique = true, length = 255)
    private String productName;

    @Column(name = "product_desc", nullable = false, length = 510)
    private String productDesc;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "product_soft_delete_date")
    private Date productSoftDelete;
}
