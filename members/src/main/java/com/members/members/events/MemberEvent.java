package com.members.members.events;

import com.members.members.entities.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(callSuper = true)
public class MemberEvent extends Event<Member> {
}
