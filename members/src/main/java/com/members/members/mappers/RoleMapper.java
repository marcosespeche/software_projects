package com.members.members.mappers;

import com.members.members.dtos.RoleDTO;
import com.members.members.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    public Role roleDTOToRole(RoleDTO roleDTO);

    public RoleDTO roleToRoleDTO(Role role);


}
