package com.yahoo.vo;

import com.yahoo.ContractorType;

import java.math.BigDecimal;

public class Contractor {

    private String no;

    private String name;

    private ContractorType type;

    private BigDecimal amount;

    private String incomeTax;

    private String businessTax;

    private String healthInsuranceTax;

    private String actualAmount;

    private String errorMsg;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContractorType getType() {
        return type;
    }

    public void setType(ContractorType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(String incomeTax) {
        this.incomeTax = incomeTax;
    }

    public String getBusinessTax() {
        return businessTax;
    }

    public void setBusinessTax(String businessTax) {
        this.businessTax = businessTax;
    }

    public String getHealthInsuranceTax() {
        return healthInsuranceTax;
    }

    public void setHealthInsuranceTax(String healthInsuranceTax) {
        this.healthInsuranceTax = healthInsuranceTax;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String validate() {
        StringBuilder errorMsg = new StringBuilder();
        if (this.amount.compareTo(new BigDecimal(0)) == -1) {
            errorMsg.append(", Amount must be greater than 0");
        }
        if (this.type == null) {
            errorMsg.append(", Type must be '個人' or '公司'");
        }
        if (errorMsg.length() != 0) {
            return "No " + this.no + " is error. Reason : [" + errorMsg.substring(1).toString() + "]";
        } else {
            return null;
        }
    }
}
