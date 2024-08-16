package com.teams.teams.repositories;

import com.teams.teams.entities.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends BaseRepository<Member, Long> {
}
