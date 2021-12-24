package com.yahoo.service;

import java.math.BigDecimal;

public interface TaxService {
    public BigDecimal countHealthInsurance(BigDecimal amount);

    public BigDecimal countIncomeTax(BigDecimal amount);

    public BigDecimal countBusinessTax(BigDecimal amount);

    public BigDecimal countActualPaymentAmount(BigDecimal incomeTax, BigDecimal businessTax, BigDecimal healthInsurance, BigDecimal amount);
}
