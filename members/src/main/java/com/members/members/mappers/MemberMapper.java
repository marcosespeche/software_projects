package com.members.members.mappers;

import com.members.members.dtos.MemberDTO;
import com.members.members.entities.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberDTO memberToMemberDTO(Member member);

    Member memberDTOToMember(MemberDTO memberDTO);
}
