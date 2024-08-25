package com.marcosespeche.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_num", unique = true, nullable = false)
    private Long memberNum;

    @Column(name = "member_name", nullable = false, length = 255)
    private String memberName;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "member_soft_delete_date")
    private Date memberSoftDeleteDate;
}
