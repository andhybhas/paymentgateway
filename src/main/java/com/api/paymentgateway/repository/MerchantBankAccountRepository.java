package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.MercBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantBankAccountRepository extends JpaRepository<MercBankAccount, Integer> {
}
