package com.marcosespeche.mappers;

import com.marcosespeche.dtos.RoleDTO;
import com.marcosespeche.entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RoleMapperImpl.class)
class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void roleToRoleDTO() {
        Role role = Role.builder()
                .roleCode(1L)
                .roleDesc("This is a desc")
                .roleName("Backend developer")
                .roleSoftDeleteDate(null)
                .build();
        role.setId(0L);

        RoleDTO mappedDTO = roleMapper.roleToRoleDTO(role);

        assertEquals(role.getId(), mappedDTO.getId());
        assertEquals(role.getRoleCode(), mappedDTO.getRoleCode());
        assertEquals(role.getRoleName(), mappedDTO.getRoleName());
        assertEquals(role.getRoleDesc(), mappedDTO.getRoleDesc());
        assertEquals(role.getRoleSoftDeleteDate(), mappedDTO.getRoleSoftDeleteDate());
    }

    @Test
    void roleDTOToRole() {
        RoleDTO roleDTO = RoleDTO.builder()
                .roleCode(1L)
                .roleDesc("This is a desc")
                .roleName("Backend developer")
                .roleSoftDeleteDate(null)
                .build();
        roleDTO.setId(null);

        Role mappedRole = roleMapper.roleDTOToRole(roleDTO);

        assertEquals(roleDTO.getId(), mappedRole.getId());
        assertEquals(roleDTO.getRoleCode(), mappedRole.getRoleCode());
        assertEquals(roleDTO.getRoleName(), mappedRole.getRoleName());
        assertEquals(roleDTO.getRoleDesc(), mappedRole.getRoleDesc());
        assertEquals(roleDTO.getRoleSoftDeleteDate(), mappedRole.getRoleSoftDeleteDate());
    }
}