package com.marcosespeche.repositories;

import com.marcosespeche.entities.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends BaseRepository<Team, Long> {
}
