package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.Percentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentageRepository extends JpaRepository<Percentage, Integer> {
}
