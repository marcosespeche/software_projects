package com.projects.projects.controllers;

import com.projects.projects.entities.Project;
import com.projects.projects.services.ProjectServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/projects")
public class ProjectControllerImpl extends BaseControllerImpl<Project, ProjectServiceImpl> implements ProjectController {
}
