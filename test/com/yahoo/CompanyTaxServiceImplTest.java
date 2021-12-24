package com.yahoo;

import com.yahoo.service.CompanyTaxServiceImpl;
import com.yahoo.service.TaxService;
import com.yahoo.vo.Contractor;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CompanyTaxServiceImplTest {
    Contractor contractor = new Contractor();
    TaxService taxService = new CompanyTaxServiceImpl();

    @BeforeEach
    void setUp() {
        contractor.setNo("case-1");
        contractor.setName("yahoo");
        contractor.setType(ContractorType.COMPANY);
    }

    @Test
    void countHealthInsurance() {
        contractor.setAmount(new BigDecimal(10000));
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result = this.taxService.countHealthInsurance(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countIncomeTax() {
        contractor.setAmount(new BigDecimal(10000));
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result = this.taxService.countIncomeTax(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countBusinessTax() {
        contractor.setAmount(new BigDecimal(30000));
        BigDecimal expected = new BigDecimal(1500);
        BigDecimal result = this.taxService.countBusinessTax(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countActualPaymentAmount() {
        BigDecimal expected = new BigDecimal(28500);
        contractor.setAmount(new BigDecimal(30000));
        BigDecimal incomeTax = new BigDecimal(0);
        BigDecimal businessTax = new BigDecimal(1500);
        BigDecimal healthInsurance = new BigDecimal(0);
        BigDecimal result = this.taxService.countActualPaymentAmount(incomeTax, businessTax, healthInsurance, contractor.getAmount());
        Assert.assertEquals(expected, result);
    }
}