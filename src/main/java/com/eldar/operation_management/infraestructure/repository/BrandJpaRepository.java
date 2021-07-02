package com.eldar.operation_management.infraestructure.repository;

import com.eldar.operation_management.domain.model.brand.Brand;
import com.eldar.operation_management.domain.repository.BrandRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpaRepository extends JpaRepository<Brand, String>, BrandRepository {
}
