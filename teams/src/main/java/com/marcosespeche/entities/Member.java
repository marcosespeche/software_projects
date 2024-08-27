package com.marcosespeche.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member extends BaseEntity{

    @Column(name = "member_name", nullable = false, length = 50)
    private String memberName;

    @Column(name = "member_num", nullable = false, unique = true)
    private Long memberNum;

    @Column(name = "member_soft_delete_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date memberSoftDeleteDate;

}
