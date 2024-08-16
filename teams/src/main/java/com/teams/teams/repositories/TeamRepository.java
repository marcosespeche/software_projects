package com.teams.teams.repositories;

import com.teams.teams.entities.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends BaseRepository<Team, Long> {
}
