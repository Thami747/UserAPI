package com.thamiprojects.userapi.repository;

import com.thamiprojects.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Client Repo is not used this time as we're not persisting to any database
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
