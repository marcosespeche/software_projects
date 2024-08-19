package com.members.members.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class RoleDTO {

    private Long id;

    private Long roleCode;

    private String roleName;

    private Date roleSoftDeleteDate;

    private String roleDesc;
}
