package com.marcosespeche.services;

import com.marcosespeche.events.EventType;
import com.marcosespeche.dtos.MemberDTO;
import com.marcosespeche.entities.Member;
import com.marcosespeche.mappers.MemberMapper;
import com.marcosespeche.repositories.MemberRepository;
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
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper mapper;

    private final MemberEventsService eventsService;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberMapper mapper, MemberEventsService eventsService) {
        this.memberRepository = memberRepository;
        this.mapper = mapper;
        this.eventsService = eventsService;
    }

    @Transactional
    public Page<MemberDTO> findAll(Pageable pageable) throws Exception {
        try {

            Page<Member> entities = this.memberRepository.findAll(pageable);
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");

            List<MemberDTO> dtoList = entities.stream()
                                                .map(mapper::memberToMemberDTO)
                                                .toList();

            return new PageImpl<MemberDTO>(dtoList, pageable, entities.getTotalElements());
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public List<MemberDTO> findAll() throws Exception {
        try {
            List<Member> entities = this.memberRepository.findAll();
            if (entities.isEmpty()) throw new EntityNotFoundException("Entities not found");
            return entities.stream()
                    .map(mapper::memberToMemberDTO)
                    .toList();
        } catch (Exception e) {
            throw new Exception("Error finding entities: " + e.getMessage(), e);
        }
    }

    @Transactional
    public MemberDTO findById(Long id) throws Exception {
        try {
            Optional<Member> entity = this.memberRepository.findById(id);
            if (entity.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            return mapper.memberToMemberDTO(entity.get());
        } catch (Exception e) {
            throw new Exception("Error finding entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public MemberDTO save(Member entity) throws Exception {
        try {
            Member entitySaved = this.memberRepository.save(entity);
            this.eventsService.publish(entitySaved, EventType.CREATED);
            return mapper.memberToMemberDTO(entitySaved);
        } catch (Exception e) {
            throw new Exception("Error saving entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public MemberDTO update(Long id, Member entity) throws Exception {
        try {
            Optional<Member> entityOptional = this.memberRepository.findById(id);
            if (entityOptional.isEmpty()) throw new EntityNotFoundException("Entity with ID: " + id + " not found");
            Member entityUpdate = entityOptional.get();
            entityUpdate = this.memberRepository.save(entity);
            this.eventsService.publish(entityUpdate, EventType.UPDATED);
            return mapper.memberToMemberDTO(entityUpdate);
        } catch (Exception e) {
            throw new Exception("Error updating entity: " + e.getMessage(), e);
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Member entityOptional = this.memberRepository.findById(id).orElseThrow(() -> new Exception("Entity with ID " + id + " not found"));
            memberRepository.deleteById(id);
            eventsService.publish(entityOptional, EventType.DELETED);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting entity: " + e.getMessage(), e);
        }
    }
}
