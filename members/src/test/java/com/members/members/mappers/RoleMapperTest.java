package com.members.members.mappers;

import com.members.members.dtos.RoleDTO;
import com.members.members.entities.Role;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RoleMapperImpl.class)
public class RoleMapperTest {

    @Autowired
    private RoleMapper mapper;

    @Test
    public void mapToDtoTest() {

        Role role = Role.builder()
                .id(0L)
                .roleCode(1L)
                .roleDesc("This is a role description")
                .roleName("Java Developer")
                .roleSoftDeleteDate(null)
                .build();

        RoleDTO dto = mapper.roleToRoleDTO(role);

        assertEquals(dto.getId(), role.getId());
        assertEquals(dto.getRoleCode(), role.getRoleCode());
        assertEquals(dto.getRoleName(), role.getRoleName());
        assertEquals(dto.getRoleDesc(), role.getRoleDesc());
        assertEquals(dto.getRoleSoftDeleteDate(), role.getRoleSoftDeleteDate());
    }

    @Test
    public void mapToRole() {

        RoleDTO dto = RoleDTO.builder()
                .id(0L)
                .roleCode(1L)
                .roleDesc("This is a role description")
                .roleName("Java Developer")
                .roleSoftDeleteDate(null)
                .build();

        Role role = mapper.roleDTOToRole(dto);

        assertEquals(dto.getId(), role.getId());
        assertEquals(dto.getRoleCode(), role.getRoleCode());
        assertEquals(dto.getRoleName(), role.getRoleName());
        assertEquals(dto.getRoleDesc(), role.getRoleDesc());
        assertEquals(dto.getRoleSoftDeleteDate(), role.getRoleSoftDeleteDate());
    }
}
