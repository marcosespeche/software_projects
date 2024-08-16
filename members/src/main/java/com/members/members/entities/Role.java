package com.members.members.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false, length = 255)
    private String roleName;

    @Column(name = "role_desc", nullable = false, length = 1020)
    private String roleDesc;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "role_soft_delete_date")
    private Date roleSoftDeleteDate;
}
