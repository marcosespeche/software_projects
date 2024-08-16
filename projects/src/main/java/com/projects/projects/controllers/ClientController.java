package com.projects.projects.controllers;

import com.projects.projects.entities.Client;
import org.springframework.http.ResponseEntity;

public interface ClientController extends BaseController<Client, Long> {

    public ResponseEntity<?> softDelete(Long id);
}
