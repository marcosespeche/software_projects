package com.projects.projects.services;

import com.projects.projects.entities.Client;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, Long> implements ClientService {

    @Override
    @Transactional
    public boolean softDelete(Long id) throws Exception {
        try {
            Optional<Client> clientOptional = this.baseRepository.findById(id);
            if (clientOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            Client client = clientOptional.get();

            if (client.getClientSoftDeleteDate() == null) client.setClientSoftDeleteDate(new Date());
            else client.setClientSoftDeleteDate(null);

            this.baseRepository.save(client);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
