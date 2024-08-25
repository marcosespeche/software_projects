package com.marcosespeche.events;

import com.marcosespeche.entities.Member;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class MemberEvent extends Event<Member>{
}
