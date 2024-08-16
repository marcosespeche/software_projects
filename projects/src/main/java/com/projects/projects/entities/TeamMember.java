package com.projects.projects.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "team_members")
public class TeamMember extends BaseEntity {

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;
}
