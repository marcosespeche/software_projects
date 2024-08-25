package com.marcosespeche.events;

import com.marcosespeche.entities.Role;
import lombok.*;

@Builder
@EqualsAndHashCode(callSuper = true)
public class RoleEvent extends Event<Role>{
}
