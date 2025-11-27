package com.rehancode.phase5concepts.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rehancode.phase5concepts.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByName(String name);

}
