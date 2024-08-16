package com.projects.projects.entities;

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
@Table(name = "clients")
public class Client extends BaseEntity {

    @Column(name = "client_address")
    private String clientAddress;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_num")
    private Long clientNum;

    @Column(name = "client_soft_delete_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientSoftDeleteDate;

}
