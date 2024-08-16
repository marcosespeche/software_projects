package com.projects.projects.entities;


import com.projects.projects.enums.StateProyect;
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
@Table(name = "projects")
public class Project extends BaseEntity {

    @Column(name = "project_description", nullable = false, length = 512)
    private String projectDescription;

    @Column(name = "project_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projectEndDate;

    @Column(name = "project_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projectStartDate;

    @Column(name = "project_name", nullable = false, unique = true)
    private String projectName;

    @Column(name = "project_num", nullable = false, unique = true)
    private Long projectNum;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_client_id")
    private Client projectClient;

    @Column(name = "project_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateProyect projectState;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_product_id")
    private Product projectProduct;

}
