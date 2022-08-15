package com.trackingsys.stocktrackingsystem.repository;

import com.trackingsys.stocktrackingsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
