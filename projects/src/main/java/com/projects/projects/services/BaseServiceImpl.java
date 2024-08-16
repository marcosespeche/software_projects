package com.projects.projects.services;

import com.projects.projects.entities.BaseEntity;
import com.projects.projects.repositories.BaseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID> {

    @Autowired
    protected BaseRepository<E, ID> baseRepository;

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entity = this.baseRepository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID " + id + " not found");
            return entity.get();
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> page = this.baseRepository.findAll(pageable);
            if (page.isEmpty()) throw new EntityNotFoundException("Instances not found");
            return page;
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
}

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entityList = this.baseRepository.findAll();
            if (entityList.isEmpty()) throw new EntityNotFoundException("Instances not found");
            return entityList;
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = this.baseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception("Error saving the instance: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = this.baseRepository.findById(id);
            if (entityOptional.isEmpty()) throw new Exception("Entity with ID " + id + " not found");
            E entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception("Error updating the instance: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            Optional<E> entityOptional = this.baseRepository.findById(id);
            if (entityOptional.isEmpty()) throw new Exception("Entity with ID " + id + " not found");
            baseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
