package com.marcosespeche.mappers;

import com.marcosespeche.dtos.RoleDTO;
import com.marcosespeche.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    public Role roleDTOToRole(RoleDTO roleDTO);

    public RoleDTO roleToRoleDTO(Role role);


}
