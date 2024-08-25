package com.marcosespeche.controllers;

import com.marcosespeche.entities.BaseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface BaseController <E extends BaseEntity, ID extends Serializable> {

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findAll(Pageable pageable);

    public ResponseEntity<?> findById(ID id);

    public ResponseEntity<?> save(E entity);

    public ResponseEntity<?> update(ID id, E entity);

    public ResponseEntity<?> delete(ID id);
}
