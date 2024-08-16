package com.teams.teams.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_members")
public class TeamMember extends BaseEntity{

    @Column(name = "team_member_counter", nullable = false)
    private Long teamMemberCounter;

    @Column(name = "team_member_start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date teamMemberStartDate;

    @Column(name = "team_member_end_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date teamMemberEndDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}
