package com.trackingsys.stocktrackingsystem.repository;

import com.trackingsys.stocktrackingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
