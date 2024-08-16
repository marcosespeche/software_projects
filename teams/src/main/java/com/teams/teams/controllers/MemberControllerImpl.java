package com.teams.teams.controllers;

import com.teams.teams.entities.Member;
import com.teams.teams.services.MemberServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/members")
public class MemberControllerImpl extends BaseControllerImpl<Member, MemberServiceImpl> implements MemberController{
}
