package com.marcosespeche.services;

import com.marcosespeche.entities.BaseEntity;
import com.marcosespeche.repositories.BaseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class BaseService<E extends BaseEntity, ID extends Serializable>{

    @Autowired
    protected BaseRepository<E, ID> repository;


    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = this.repository.findAll(pageable);
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }


    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = this.repository.findAll();
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }


    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entity = this.repository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            return entity.get();
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }


    @Transactional
    public E save(E entity) throws Exception {
        try {
            E entityPersisted = this.repository.save(entity);
            log.info("Entity persisted, data={}",
                    entityPersisted);
            return entityPersisted;
        } catch (Exception e) {
            throw new Exception("Error saving entity: " + e.getMessage(), e);
        }
    }


    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = this.repository.findById(id);
            if (entityOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            E entityUpdate = entityOptional.get();
            entityUpdate = this.repository.save(entity);
            log.info("Entity updated, data={}",
                    entityUpdate);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception("Error updating entity: " + e.getMessage(), e);
        }
    }


    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            Optional<E> entityOptional = this.repository.findById(id);
            if (entityOptional.isEmpty()) throw new Exception("Entity with ID " + id + " not found");
            repository.deleteById(id);
            log.info("Entity deleted, data={}",
                    entityOptional.get());
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
