package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.MerchVaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchVaAccountRepository extends JpaRepository<MerchVaAccount, Integer> {
}
