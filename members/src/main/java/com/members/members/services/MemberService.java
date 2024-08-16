package com.members.members.services;

import com.members.members.entities.Member;
import com.members.members.repositories.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Page<Member> findAll(Pageable pageable) throws Exception {
        try {
            Page<Member> entities = this.memberRepository.findAll(pageable);
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public List<Member> findAll() throws Exception {
        try {
            List<Member> entities = this.memberRepository.findAll();
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities;
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Member findById(Long id) throws Exception {
        try {
            Optional<Member> entity = this.memberRepository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            return entity.get();
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Member save(Member entity) throws Exception {
        try {
            return this.memberRepository.save(entity);
        } catch (Exception e) {
            throw new Exception("Error saving entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public Member update(Long id, Member entity) throws Exception {
        try {
            Optional<Member> entityOptional = this.memberRepository.findById(id);
            if (entityOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            Member entityUpdate = entityOptional.get();
            entityUpdate = this.memberRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception("Error updating entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Member entityOptional = this.memberRepository.findById(id).orElseThrow(() -> new Exception("Entity with ID " + id + " not found"));
            memberRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
