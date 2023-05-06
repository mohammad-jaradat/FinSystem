package com.qu.finsys.repositories;

import com.qu.finsys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, RevisionRepository<User, Long, Integer> {
    //User findByEmail(String email);

    Optional<User> findByEmail(String email);

    @Override
    void delete(User user);

}