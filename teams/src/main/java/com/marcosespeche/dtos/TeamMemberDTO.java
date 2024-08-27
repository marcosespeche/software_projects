package com.marcosespeche.dtos;

import com.marcosespeche.entities.Member;
import com.marcosespeche.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMemberDTO {

    private Long id;

    private Long teamMemberCounter;

    private Date teamMemberStartDate;

    private Date teamMemberEndDate;

    private MemberDTO member;

    private RoleDTO role;
}
