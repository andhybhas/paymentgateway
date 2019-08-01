package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.VaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaAccountRepository extends JpaRepository<VaAccount, Integer> {
}
