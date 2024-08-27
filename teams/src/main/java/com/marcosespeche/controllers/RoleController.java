package com.marcosespeche.controllers;

import com.marcosespeche.entities.Role;
import com.marcosespeche.services.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleController extends BaseController<Role, RoleService> {
}
