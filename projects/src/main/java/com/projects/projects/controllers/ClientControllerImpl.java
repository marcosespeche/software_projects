package com.projects.projects.controllers;

import com.projects.projects.entities.Client;
import com.projects.projects.services.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientControllerImpl extends BaseControllerImpl<Client, ClientServiceImpl> implements ClientController{

    @Override
    @DeleteMapping(path = "/soft-delete/{id}")
    public ResponseEntity<?> softDelete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.service.softDelete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
