package com.members.members.services;

import com.members.members.dtos.RoleDTO;
import com.members.members.entities.Role;
import com.members.members.mappers.RoleMapper;
import com.members.members.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper mapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Transactional
    public Page<RoleDTO> findAll(Pageable pageable) throws Exception {
        try {
            Page<Role> entities = this.roleRepository.findAll(pageable);
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            List<RoleDTO> dtoList = entities.stream()
                    .map(mapper::roleToRoleDTO)
                    .toList();
            return new PageImpl<RoleDTO>(dtoList, pageable, entities.getTotalElements());
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public List<RoleDTO> findAll() throws Exception {
        try {
            List<Role> entities = this.roleRepository.findAll();
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities.stream()
                    .map(mapper::roleToRoleDTO)
                    .toList();
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public RoleDTO findById(Long id) throws Exception {
        try {
            Optional<Role> entity = this.roleRepository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            return mapper.roleToRoleDTO(entity.get());
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public RoleDTO save(Role entity) throws Exception {
        try {
            Role entitySaved = this.roleRepository.save(entity);
            return mapper.roleToRoleDTO(entitySaved);
        } catch (Exception e) {
            throw new Exception("Error saving entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public RoleDTO update(Long id, Role entity) throws Exception {
        try {
            Optional<Role> entityOptional = this.roleRepository.findById(id);
            if (entityOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            Role entityUpdate = entityOptional.get();
            entityUpdate = this.roleRepository.save(entity);
            return mapper.roleToRoleDTO(entityUpdate);
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
