package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.IbTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IbTransactionRepository extends JpaRepository<IbTransaction, Integer> {
}
