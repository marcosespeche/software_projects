package com.marcosespeche.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(name = "team_code", unique = true, nullable = false)
    private Long teamCode;

    @Column(name = "team_name", unique = true, nullable = false, length = 50)
    private String teamName;

    @Column(name = "team_soft_delete_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date teamSoftDeleteDate;

    @Column(name = "project_capacity", nullable = false)
    private int projectCapacity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private List<TeamMember> memberList = new ArrayList<TeamMember>();

}
