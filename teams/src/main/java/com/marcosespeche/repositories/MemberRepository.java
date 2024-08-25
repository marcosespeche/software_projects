package com.marcosespeche.repositories;

import com.marcosespeche.entities.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends BaseRepository<Member, Long> {
}
