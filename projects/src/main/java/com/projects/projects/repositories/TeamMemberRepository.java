package com.projects.projects.repositories;

import com.projects.projects.entities.TeamMember;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends BaseRepository<TeamMember, Long> {
}
