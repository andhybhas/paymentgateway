package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.CcAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcAccountRepository extends JpaRepository<CcAccount, Integer> {
}
