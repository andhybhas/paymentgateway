package com.api.paymentgateway.repository;

import com.api.paymentgateway.entity.Acquirer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquirerRepository extends JpaRepository<Acquirer, Integer> {
}
