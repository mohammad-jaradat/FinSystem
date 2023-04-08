package com.qou.edu.finsys.repositories;

import com.qou.edu.finsys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //User findByEmail(String email);

    Optional<User> findByEmail(String email);

    @Override
    void delete(User user);

}