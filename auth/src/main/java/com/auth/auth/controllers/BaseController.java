package com.auth.auth.controllers;

import com.auth.auth.entities.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;

public interface BaseController <E extends BaseEntity, ID extends Serializable> {

    public ResponseEntity<?> findById(@PathVariable Long id);

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findAll(@RequestBody Pageable pageable);

    public ResponseEntity<?> save(@RequestBody E entity);

    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity);

    public ResponseEntity<?> delete(@PathVariable Long id);

}
