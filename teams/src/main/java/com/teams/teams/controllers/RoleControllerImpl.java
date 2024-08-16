package com.teams.teams.controllers;

import com.teams.teams.entities.Role;
import com.teams.teams.services.RoleServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleControllerImpl extends BaseControllerImpl<Role, RoleServiceImpl> implements RoleController {
}
