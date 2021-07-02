package com.eldar.operation_management.infraestructure;

import com.eldar.operation_management.domain.model.Card;
import com.eldar.operation_management.domain.repository.CardRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardJpaRepository extends JpaRepository<Card, Long>, CardRepository {
}
