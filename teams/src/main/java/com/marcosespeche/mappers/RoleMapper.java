package com.marcosespeche.mappers;

import com.marcosespeche.dtos.RoleDTO;
import com.marcosespeche.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(Role role);

    Role roleDTOToRole(RoleDTO roleDTO);
}
