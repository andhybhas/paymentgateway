package com.api.paymentgateway.repository;

import com.api.paymentgateway.dto.VaInquiryResponseDTO;
import com.api.paymentgateway.entity.VaTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VaTransactionRepository extends JpaRepository<VaTransaction, Integer> {

//    @Query(value = "select t.amount, c.email, c.name, c.id, t.transaction_timestamp, acc.va_number from va_transaction t join customer c on t.customer_id = c.id join va_account acc on t.va_id = acc.id where acc.va_number = ?1 ",
//            nativeQuery = true )
//    VaInquiryResponseDTO getDetailVaNumber(Integer vaNumber);
}
