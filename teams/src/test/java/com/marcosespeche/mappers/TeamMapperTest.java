package com.marcosespeche.mappers;

import com.marcosespeche.dtos.MemberDTO;
import com.marcosespeche.dtos.RoleDTO;
import com.marcosespeche.dtos.TeamMemberDTO;
import com.marcosespeche.entities.Member;
import com.marcosespeche.entities.Role;
import com.marcosespeche.entities.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TeamMapperImpl.class)
class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @Test
    void toTeamDTO() {
    }

    @Test
    void toTeam() {
    }

    @Test
    void toTeamMembers() {

        RoleDTO roleDTO = RoleDTO.builder()
                .id(null)
                .roleCode(1L)
                .roleDesc("This is a desc")
                .roleName("Backend developer")
                .roleSoftDeleteDate(null)
                .build();


        MemberDTO memberDTO = MemberDTO.builder()
                .id(null)
                .memberName("Marcos Espeche")
                .memberNum(123L)
                .memberSoftDeleteDate(null)
                .build();

        TeamMemberDTO teamMemberDTO = TeamMemberDTO.builder()
                .member(memberDTO)
                .id(null)
                .role(roleDTO)
                .teamMemberCounter(1L)
                .teamMemberStartDate(new Date())
                .teamMemberEndDate(new Date())
                .build();

        TeamMember teamMemberMapped = teamMapper.toTeamMember(teamMemberDTO);


        assertEquals(teamMemberMapped.getId(), teamMemberDTO.getId());
        assertEquals(teamMemberMapped.getMember().getMemberName(), teamMemberDTO.getMember().getMemberName());
        assertEquals(teamMemberMapped.getRole().getRoleName(), teamMemberDTO.getRole().getRoleName());
        assertEquals(teamMemberMapped.getTeamMemberCounter(), teamMemberDTO.getTeamMemberCounter());
        assertEquals(teamMemberMapped.getTeamMemberStartDate(), teamMemberDTO.getTeamMemberStartDate());
        assertEquals(teamMemberMapped.getTeamMemberEndDate(), teamMemberDTO.getTeamMemberEndDate());

    }

    @Test
    void toTeamMemberDTOs() {

        Role role = Role.builder()
                .roleCode(1L)
                .roleDesc("This is a desc")
                .roleName("Backend developer")
                .roleSoftDeleteDate(null)
                .build();
        role.setId(null);

        Member member = Member.builder()
                .memberName("Marcos Espeche")
                .memberNum(123L)
                .memberSoftDeleteDate(null)
                .build();
        member.setId(null);

        TeamMember teamMember = TeamMember.builder()
                .member(member)
                .role(role)
                .teamMemberCounter(1L)
                .teamMemberStartDate(new Date())
                .teamMemberEndDate(new Date())
                .build();
        teamMember.setId(null);

        TeamMemberDTO teamMemberMapped = teamMapper.toTeamMemberDTO(teamMember);


        assertEquals(teamMemberMapped.getId(), teamMember.getId());
        assertEquals(teamMemberMapped.getMember().getMemberName(), teamMember.getMember().getMemberName());
        assertEquals(teamMemberMapped.getRole().getRoleName(), teamMember.getRole().getRoleName());
        assertEquals(teamMemberMapped.getTeamMemberCounter(), teamMember.getTeamMemberCounter());
        assertEquals(teamMemberMapped.getTeamMemberStartDate(), teamMember.getTeamMemberStartDate());
        assertEquals(teamMemberMapped.getTeamMemberEndDate(), teamMember.getTeamMemberEndDate());
    }
}