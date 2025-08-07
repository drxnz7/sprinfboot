package com.example.corporateapp.repository;

import com.example.corporateapp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
