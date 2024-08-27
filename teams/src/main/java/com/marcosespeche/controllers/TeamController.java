package com.marcosespeche.controllers;

import com.marcosespeche.entities.Team;
import com.marcosespeche.services.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/teams")
public class TeamController extends BaseController<Team, TeamService> {


}
