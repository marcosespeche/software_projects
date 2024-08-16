package com.projects.projects.repositories;

import com.projects.projects.entities.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectRepository extends BaseRepository<Project, Long> {
}
