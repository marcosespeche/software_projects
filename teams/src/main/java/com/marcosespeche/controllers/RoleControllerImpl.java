package com.marcosespeche.controllers;

import com.marcosespeche.entities.Role;
import com.marcosespeche.services.RoleServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleControllerImpl extends BaseControllerImpl<Role, RoleServiceImpl> implements RoleController {
}
