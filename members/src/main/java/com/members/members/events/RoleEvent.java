package com.members.members.events;

import com.members.members.entities.Role;
import lombok.*;

@Builder
@EqualsAndHashCode(callSuper = true)
public class RoleEvent extends Event<Role>{
}
