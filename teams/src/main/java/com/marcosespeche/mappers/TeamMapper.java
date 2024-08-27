package com.marcosespeche.mappers;

import com.marcosespeche.dtos.MemberDTO;
import com.marcosespeche.dtos.RoleDTO;
import com.marcosespeche.dtos.TeamDTO;
import com.marcosespeche.dtos.TeamMemberDTO;
import com.marcosespeche.entities.Member;
import com.marcosespeche.entities.Role;
import com.marcosespeche.entities.Team;
import com.marcosespeche.entities.TeamMember;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(source = "memberList", target = "memberList")
    TeamDTO toTeamDTO(Team team);

    @InheritInverseConfiguration
    Team toTeam(TeamDTO teamDTO);

    @Mapping(source = "role", target = "role")
    @Mapping(source = "member", target = "member")
    TeamMemberDTO toTeamMemberDTO(TeamMemberDTO teamMemberDTO);

    @InheritInverseConfiguration
    TeamMember toTeamMember(TeamMemberDTO teamMemberDTO);

    RoleDTO roleToRoleDTO(Role role);

    Role roleDTOToRole(RoleDTO roleDTO);

    MemberDTO memberToMemberDTO(Member member);

    Member memberDTOToMember(MemberDTO memberDTO);

    List<TeamMember> toTeamMembers(List<TeamMemberDTO> memberList);

    List<TeamMemberDTO> toTeamMemberDTOs(List<TeamMember> memberList);
}
