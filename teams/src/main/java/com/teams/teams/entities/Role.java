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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(name = "role_code", unique = true, nullable = false)
    private Long rolCode;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "role_desc", nullable = false, length = 512)
    private String roleDesc;

    @Column(name = "role_soft_delete_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date roleSoftDeleteDate;
}
