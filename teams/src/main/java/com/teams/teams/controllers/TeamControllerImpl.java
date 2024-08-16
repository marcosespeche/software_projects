package com.teams.teams.controllers;

import com.teams.teams.entities.Team;
import com.teams.teams.services.TeamServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/teams")
public class TeamControllerImpl extends BaseControllerImpl<Team, TeamServiceImpl> implements TeamController {


}
