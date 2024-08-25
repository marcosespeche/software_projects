package com.marcosespeche.mappers;

import com.marcosespeche.dtos.MemberDTO;
import com.marcosespeche.entities.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberDTO memberToMemberDTO(Member member);

    Member memberDTOToMember(MemberDTO memberDTO);
}
