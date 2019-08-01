package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.MoneyDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyDistributionRepository extends JpaRepository<MoneyDistribution, Integer> {
}
