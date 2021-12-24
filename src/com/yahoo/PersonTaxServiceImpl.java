package com.yahoo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PersonTaxServiceImpl implements TaxService {

    private static final int AMOUNT_RANGE = 20000;
    private static final double HEALTH_INSURANCE_RATE = 0.0211;
    private static final double INCOME_RATE = 0.1;

    @Override
    public BigDecimal countHealthInsurance(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal(AMOUNT_RANGE)) != -1){
            return amount.multiply(new BigDecimal(HEALTH_INSURANCE_RATE)).setScale(0, RoundingMode.HALF_EVEN);
        }else{
            return new BigDecimal(0);
        }
    }

    @Override
    public BigDecimal countIncomeTax(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal(AMOUNT_RANGE)) == 1){
            return amount.multiply(new BigDecimal(INCOME_RATE)).setScale(0, RoundingMode.HALF_DOWN);
        }else{
            return new BigDecimal(0);
        }
    }

    @Override
    public BigDecimal countBusinessTax(BigDecimal amount) {
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal countActualPaymentAmount(BigDecimal incomeTax, BigDecimal businessTax, BigDecimal healthInsurance, BigDecimal amount) {
        return amount.subtract(incomeTax).subtract(businessTax).subtract(healthInsurance);
    }

}
