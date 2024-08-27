package com.marcosespeche.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {

    private Long id;

    private Long roleCode;

    private String roleName;

    private String roleDesc;

    private Date roleSoftDeleteDate;
}
