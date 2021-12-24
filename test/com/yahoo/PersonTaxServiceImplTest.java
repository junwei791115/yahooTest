package com.yahoo;

import com.yahoo.service.PersonTaxServiceImpl;
import com.yahoo.service.TaxService;
import com.yahoo.vo.Contractor;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class PersonTaxServiceImplTest {
    Contractor contractor = new Contractor();
    TaxService taxService = new PersonTaxServiceImpl();

    @BeforeEach
    void setUp() {
        contractor.setNo("case-1");
        contractor.setName("陳小明");
        contractor.setType(ContractorType.PERSON);

    }

    @Test
    void countHealthInsurance_less_than_20000() {
        contractor.setAmount(new BigDecimal(10000));
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result = this.taxService.countHealthInsurance(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countHealthInsurance_greater_than_20000() {
        contractor.setAmount(new BigDecimal(25000));
        BigDecimal expected = new BigDecimal(528);
        BigDecimal result = this.taxService.countHealthInsurance(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countHealthInsurance_equal_20000() {
        contractor.setAmount(new BigDecimal(20000));
        BigDecimal expected = new BigDecimal(422);
        BigDecimal result = this.taxService.countHealthInsurance(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countIncomeTax_less_than_20000() {
        contractor.setAmount(new BigDecimal(10000));
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result = this.taxService.countIncomeTax(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countIncomeTax_greater_than_20000() {
        contractor.setAmount(new BigDecimal(25000));
        BigDecimal expected = new BigDecimal(2500);
        BigDecimal result = this.taxService.countIncomeTax(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countIncomeTax_equal_20000() {
        contractor.setAmount(new BigDecimal(20000));
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result = this.taxService.countIncomeTax(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countBusinessTax() {
        contractor.setAmount(new BigDecimal(20000));
        BigDecimal expected = new BigDecimal(0);
        BigDecimal result = this.taxService.countBusinessTax(contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countActualPaymentAmount_less_than_20000() {
        BigDecimal expected = new BigDecimal(10000);
        contractor.setAmount(new BigDecimal(10000));
        BigDecimal incomeTax = new BigDecimal(0);
        BigDecimal businessTax = new BigDecimal(0);
        BigDecimal healthInsurance = new BigDecimal(0);
        BigDecimal result = this.taxService.countActualPaymentAmount(incomeTax, businessTax, healthInsurance, contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countActualPaymentAmount_greater_than_20000() {
        BigDecimal expected = new BigDecimal(21972);
        contractor.setAmount(new BigDecimal(25000));
        BigDecimal incomeTax = new BigDecimal(2500);
        BigDecimal businessTax = new BigDecimal(0);
        BigDecimal healthInsurance = new BigDecimal(528);
        BigDecimal result = this.taxService.countActualPaymentAmount(incomeTax, businessTax, healthInsurance, contractor.getAmount());
        Assert.assertEquals(expected, result);
    }

    @Test
    void countActualPaymentAmount_equal_than_20000() {
        BigDecimal expected = new BigDecimal(19578);
        contractor.setAmount(new BigDecimal(20000));
        BigDecimal incomeTax = new BigDecimal(0);
        BigDecimal businessTax = new BigDecimal(0);
        BigDecimal healthInsurance = new BigDecimal(422);
        BigDecimal result = this.taxService.countActualPaymentAmount(incomeTax, businessTax, healthInsurance, contractor.getAmount());
        Assert.assertEquals(expected, result);
    }
}