package com.yahoo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompanyTaxServiceImpl implements TaxService{

    private static final double BUSINESS_RATE = 0.05;

    @Override
    public BigDecimal countHealthInsurance(BigDecimal amount) {
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal countIncomeTax(BigDecimal amount) {
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal countBusinessTax(BigDecimal amount) {
        return amount.multiply(new BigDecimal(BUSINESS_RATE)).setScale(0, RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal countActualPaymentAmount(BigDecimal incomeTax, BigDecimal businessTax, BigDecimal healthInsurance, BigDecimal amount) {
        return amount.subtract(incomeTax).subtract(businessTax).subtract(healthInsurance);
    }
}
