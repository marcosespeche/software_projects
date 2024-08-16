package com.projects.projects.services;

import com.projects.projects.entities.Client;

public interface ClientService extends BaseService<Client, Long> {

    public boolean softDelete(Long id) throws Exception;
}
