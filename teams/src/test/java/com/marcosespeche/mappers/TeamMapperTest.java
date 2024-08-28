package com.marcosespeche.mappers;

import com.marcosespeche.dtos.MemberDTO;
import com.marcosespeche.dtos.RoleDTO;
import com.marcosespeche.dtos.TeamDTO;
import com.marcosespeche.dtos.TeamMemberDTO;
import com.marcosespeche.entities.Member;
import com.marcosespeche.entities.Role;
import com.marcosespeche.entities.Team;
import com.marcosespeche.entities.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TeamMapperImpl.class)
class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @Test
    void toTeamDTO() {

        List<TeamMember> memberList = new ArrayList<>();

        Member member1 = Member.builder()
                .memberName("Marcos Espeche")
                .memberNum(123L)
                .memberSoftDeleteDate(null)
                .build();
        member1.setId(1L);

        Member member2 = Member.builder()
                .memberName("Steve Adams")
                .memberNum(124L)
                .memberSoftDeleteDate(null)
                .build();
        member1.setId(1L);

        Role role1 = Role.builder()
                .roleName("Backend developer")
                .roleSoftDeleteDate(null)
                .roleDesc("This is a description")
                .build();
        role1.setId(1L);

        memberList.add(
                TeamMember.builder()
                        .member(member1)
                        .role(role1)
                        .teamMemberEndDate(new Date())
                        .teamMemberStartDate(new Date())
                        .teamMemberCounter(1L)
                        .build());

        memberList.add(
                TeamMember.builder()
                        .member(member2)
                        .role(role1)
                        .teamMemberEndDate(new Date())
                        .teamMemberStartDate(new Date())
                        .teamMemberCounter(2L)
                        .build());

        memberList.add(
                TeamMember.builder()
                        .member(member2)
                        .role(role1)
                        .teamMemberEndDate(null)
                        .teamMemberStartDate(new Date())
                        .teamMemberCounter(3L)
                        .build());

        Team team = Team.builder()
                .teamCode(1L)
                .teamName("Springboot Enjoyers")
                .teamSoftDeleteDate(null)
                .projectCapacity(10)
                .memberList(memberList)
                .build();
        team.setId(1L);

        TeamDTO mappedTeamDTO = teamMapper.toTeamDTO(team);

        assertEquals(mappedTeamDTO.getId(), team.getId());
        assertEquals(mappedTeamDTO.getTeamName(), team.getTeamName());
        assertEquals(mappedTeamDTO.getTeamCode(), team.getTeamCode());
        assertEquals(mappedTeamDTO.getProjectCapacity(), team.getProjectCapacity());
        assertEquals(mappedTeamDTO.getMemberList().get(0).getMember().getMemberName(),
                      team.getMemberList().get(0).getMember().getMemberName());
        assertEquals(mappedTeamDTO.getMemberList().get(0).getRole().getRoleCode(),
                team.getMemberList().get(0).getRole().getRoleCode());
    }

    @Test
    void toTeam() {

        List<TeamMemberDTO> memberList = new ArrayList<>();

        MemberDTO member1 = MemberDTO.builder()
                .memberName("Marcos Espeche")
                .memberNum(123L)
                .memberSoftDeleteDate(null)
                .build();
        member1.setId(1L);

        MemberDTO member2 = MemberDTO.builder()
                .memberName("Steve Adams")
                .memberNum(124L)
                .memberSoftDeleteDate(null)
                .build();
        member1.setId(1L);

        RoleDTO role1 = RoleDTO.builder()
                .roleName("Backend developer")
                .roleSoftDeleteDate(null)
                .roleDesc("This is a description")
                .build();
        role1.setId(1L);

        memberList.add(
                TeamMemberDTO.builder()
                        .member(member1)
                        .role(role1)
                        .teamMemberEndDate(new Date())
                        .teamMemberStartDate(new Date())
                        .teamMemberCounter(1L)
                        .build());

        memberList.add(
                TeamMemberDTO.builder()
                        .member(member2)
                        .role(role1)
                        .teamMemberEndDate(new Date())
                        .teamMemberStartDate(new Date())
                        .teamMemberCounter(2L)
                        .build());

        memberList.add(
                TeamMemberDTO.builder()
                        .member(member2)
                        .role(role1)
                        .teamMemberEndDate(null)
                        .teamMemberStartDate(new Date())
                        .teamMemberCounter(3L)
                        .build());

        TeamDTO teamDTO = TeamDTO.builder()
                .teamCode(1L)
                .teamName("Springboot Enjoyers")
                .teamSoftDeleteDate(null)
                .projectCapacity(10)
                .memberList(memberList)
                .build();
        teamDTO.setId(1L);

        Team mappedTeam = teamMapper.toTeam(teamDTO);

        assertEquals(mappedTeam.getTeamName(), teamDTO.getTeamName());
        assertEquals(mappedTeam.getTeamCode(), teamDTO.getTeamCode());
        assertEquals(mappedTeam.getProjectCapacity(), teamDTO.getProjectCapacity());
        assertEquals(mappedTeam.getMemberList().get(0).getMember().getMemberName(),
                teamDTO.getMemberList().get(0).getMember().getMemberName());
        assertEquals(mappedTeam.getMemberList().get(0).getRole().getRoleCode(),
                teamDTO.getMemberList().get(0).getRole().getRoleCode());
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