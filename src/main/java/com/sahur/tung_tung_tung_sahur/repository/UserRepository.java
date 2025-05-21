package com.sahur.tung_tung_tung_sahur.repository;

import com.sahur.tung_tung_tung_sahur.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
