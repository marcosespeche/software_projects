package com.marcosespeche.controllers;

import com.marcosespeche.entities.Team;
import com.marcosespeche.services.TeamServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/teams")
public class TeamControllerImpl extends BaseControllerImpl<Team, TeamServiceImpl> implements TeamController {


}
