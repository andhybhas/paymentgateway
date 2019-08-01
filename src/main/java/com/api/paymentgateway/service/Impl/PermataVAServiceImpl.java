package com.api.paymentgateway.service.Impl;

import com.api.paymentgateway.dto.*;
import com.api.paymentgateway.entity.*;
import com.api.paymentgateway.repository.*;
import com.api.paymentgateway.service.IPayVaService;
import com.api.paymentgateway.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Service
@Repository("IPayVaService")
public class PermataVAServiceImpl implements IPayVaService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    VaTransactionRepository vaTransactionRepository;

    @Autowired
    PercentageRepository percentageRepository;

    @Autowired
    MoneyDistributionRepository moneyDistributionRepository;

    @Autowired
    VaAccountRepository vaAccountRepository;

    @Autowired
    AcquirerRepository acquirerRepository;

    @Autowired
    MerchantRepository merchantRepository;

    public Response<VaCheckoutResponseDTO> checkOut (VaCheckoutRequestDTO vaCheckoutRequestDTO) {

        //    Generate VA Number
        long unique = (long) (Math.random() * 10000L);
        long newVaNumber = 3150000000000000L + unique;

        //    Generate Date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        Customer customer = new Customer();
        customer.setIdCustomer(customer.getIdCustomer());
        customer.setCustomerName(vaCheckoutRequestDTO.getCustomerName());
        customer.setCustomerEmail(vaCheckoutRequestDTO.getCustomerEmail());
        customerRepository.save(customer);

        Acquirer acquirer = new Acquirer();
        acquirer.setAcquirerId(acquirer.getAcquirerId());
        acquirer.setAcquirerName(vaCheckoutRequestDTO.getAcquirerName());
        acquirerRepository.save(acquirer);

        Merchant merchant = new Merchant();
        merchant.setMerchantId(merchant.getMerchantId());
        merchant.setMerchantName(vaCheckoutRequestDTO.getMerchantName());
        merchantRepository.save(merchant);

        VaAccount vaAccount = new VaAccount();
        vaAccount.setVaNumber(newVaNumber);
        vaAccountRepository.save(vaAccount);

        Percentage percentage = new Percentage();
        percentage.setIdCustomer(customer.getIdCustomer());
        percentage.setAcquirerId(acquirer.getAcquirerId());
        percentage.setAcquirerPercent(BigDecimal.valueOf(0.01));
        percentage.setMerchantId(merchant.getMerchantId());
        percentage.setMerchantPercent(BigDecimal.valueOf(0.03));
        percentageRepository.save(percentage);

        VaTransaction vaTransaction = new VaTransaction();
        vaTransaction.setVaId(vaTransaction.getVaId());
        vaTransaction.setCustomerId(customer.getIdCustomer());
        vaTransaction.setAcquirerId(acquirer.getAcquirerId());
        vaTransaction.setMerchantId(merchant.getMerchantId());
        vaTransaction.setAmount(vaCheckoutRequestDTO.getAmount());
        vaTransaction.setTransactionTime(dtf.format(localDate));
        vaTransactionRepository.save(vaTransaction);
//        log.info("===== INI CHECKOUT =====");
//        log.info("Customer Name = " + checkOutRequestDTO.getCustomerName());
//        log.info("Customer Email = " + checkOutRequestDTO.getCustomerEmail());
//        log.info("Transaction Amount = " + checkOutRequestDTO.getAmount());
//        log.info("VA Number = " + newVaNumber);
//        log.info("Transaction Date = " + dtf.format(localDate));

        VaCheckoutResponseDTO vaCheckoutResponseDTO = VaCheckoutResponseDTO.builder()
                .customerName(customer.getCustomerName())
                .idCustomer(customer.getIdCustomer())
                .customerEmail(customer.getCustomerEmail())
                .amount(vaTransaction.getAmount())
                .trxCreate(vaTransaction.getTransactionTime())
                .vanumber(newVaNumber)
                .build();

        return Response.<VaCheckoutResponseDTO>builder()
                .message("Checkout Success")
                .data(vaCheckoutResponseDTO)
                .build();
    }

    public Response<VaInquiryResponseDTO> doInquiry (VaInquiryRequestDTO vaInquiryRequestDTO) {

        VaAccount vaAccount = new VaAccount();
       vaAccount.setVaNumber(vaInquiryRequestDTO.getVaNUmber());

       Optional<Customer> customer = customerRepository.findById(vaInquiryRequestDTO.getIdCustomer());
       Customer customers = customer.get();

       Optional<VaTransaction> vaTransaction = vaTransactionRepository.findById(vaInquiryRequestDTO.getIdCustomer());
       VaTransaction vaTransactions = vaTransaction.get();

       Optional<Percentage> percentage = percentageRepository.findById(vaInquiryRequestDTO.getIdCustomer());
       Percentage percentages = percentage.get();

       VaInquiryResponseDTO vaInquiryResponseDTO = VaInquiryResponseDTO.builder()
               .vaNUmber(vaAccount.getVaNumber())
               .idCustomer(customers.getIdCustomer())
               .customerName(customers.getCustomerName())
               .customerEmail(customers.getCustomerEmail())
               .amount(vaTransactions.getAmount())
               .transactionTime(vaTransactions.getTransactionTime())
               .idTransaction(vaTransactions.getVaId())
               .idPercentage(percentages.getIdCustomer())
               .build();

       return Response.<VaInquiryResponseDTO>builder()
               .message("Inquiry Success")
               .data(vaInquiryResponseDTO)
               .build();
    }

    public Response<VaPaymentResponseDTO> doPayment (VaInquiryResponseDTO vaInquiryResponseDTO) {

        VaPaymentResponseDTO vaPaymentResponseDTO = VaPaymentResponseDTO.builder()
            .vaNUmber(vaInquiryResponseDTO.getVaNUmber())
            .customerName(vaInquiryResponseDTO.getCustomerName())
            .amount(vaInquiryResponseDTO.getAmount())
            .build();

        Optional<VaTransaction> vaTransaction = vaTransactionRepository.findById(vaInquiryResponseDTO.getIdTransaction());
        VaTransaction vaTransactions = vaTransaction.get();

        Optional<Percentage> percentage = percentageRepository.findById(vaInquiryResponseDTO.getIdPercentage());
        Percentage percentages = percentage.get();

        BigDecimal acquirerPercentage = percentages.getAcquirerPercent();
        BigDecimal amount = vaTransactions.getAmount();
        BigDecimal acquirerMoney = acquirerPercentage.multiply(amount);

        BigDecimal merchantPercentage = percentages.getMerchantPercent();
        BigDecimal pgMoney = merchantPercentage.multiply(amount);

        BigDecimal merchantMoney = amount.subtract((acquirerMoney.add(pgMoney)));

        MoneyDistribution moneyDistribution = new MoneyDistribution();
        moneyDistribution.setAcquirerMoney(acquirerMoney);
        moneyDistribution.setPgMoney(pgMoney);
        moneyDistribution.setMerchantMoney(merchantMoney);

        moneyDistributionRepository.save(moneyDistribution);

        return Response.<VaPaymentResponseDTO>builder()
            .message("Status Payment Success")
            .data(vaPaymentResponseDTO)
            .build();
    }
}
