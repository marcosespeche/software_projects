package com.marcosespeche.controllers;

import com.marcosespeche.entities.Member;
import com.marcosespeche.services.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/members")
public class MemberController extends BaseController<Member, MemberService> {
}
