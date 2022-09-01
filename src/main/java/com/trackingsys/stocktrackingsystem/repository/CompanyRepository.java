package com.trackingsys.stocktrackingsystem.repository;

import com.trackingsys.stocktrackingsystem.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
