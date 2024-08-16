package com.members.members.services;

import com.members.members.entities.Role;
import com.members.members.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Page<Role> findAll(Pageable pageable) throws Exception {
        try {
            Page<Role> entities = this.roleRepository.findAll(pageable);
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public List<Role> findAll() throws Exception {
        try {
            List<Role> entities = this.roleRepository.findAll();
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Role findById(Long id) throws Exception {
        try {
            Optional<Role> entity = this.roleRepository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            return entity.get();
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Role save(Role entity) throws Exception {
        try {
            return this.roleRepository.save(entity);
        } catch (Exception e) {
            throw new Exception("Error saving entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Role update(Long id, Role entity) throws Exception {
        try {
            Optional<Role> entityOptional = this.roleRepository.findById(id);
            if (entityOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            Role entityUpdate = entityOptional.get();
            entityUpdate = this.roleRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception("Error updating entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Role entityOptional = this.roleRepository.findById(id).orElseThrow(() -> new Exception("Entity with ID " + id + " not found"));
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
