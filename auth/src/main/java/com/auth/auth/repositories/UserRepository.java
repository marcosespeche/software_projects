package com.auth.auth.repositories;

import com.auth.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value =  "SELECT u from User u " +
                    "WHERE u.username = :username")
    Optional<User> findByUsername(@Param(value = ":username") String username);
}
