package com.marcosespeche.dtos;

import com.marcosespeche.entities.TeamMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    private Long id;

    private Long teamCode;

    private String teamName;

    private Date teamSoftDeleteDate;

    private int projectCapacity;

    private List<TeamMemberDTO> memberList = new ArrayList<>();
}
