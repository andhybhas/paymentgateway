package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.CcTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcTransactionRepository extends JpaRepository<CcTransaction, Integer> {
}
