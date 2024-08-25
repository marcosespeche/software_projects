package com.marcosespeche.events;

import com.marcosespeche.entities.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(callSuper = true)
public class MemberEvent extends Event<Member> {
}
