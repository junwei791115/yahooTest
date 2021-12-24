package com.yahoo;

import com.yahoo.service.*;
import com.yahoo.vo.Contractor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        //Get data
        DataSource dataSource = new CvsDataSource();
        List<Contractor> contractors = dataSource.getData();
        //validate data
        List<String> errorMsgs = contractors.stream().map(Contractor::validate).filter(errorMsg -> errorMsg != null).collect(Collectors.toList());
        if (errorMsgs.size() != 0) {
            errorMsgs.forEach(System.out::println);
        }else{
            Solution solution = new Solution();
            solution.processData(contractors);
            //Output data
            OutputService outputService = new ConsoleServiceImpl();
            outputService.output(contractors);
        }
    }

    void processData( List<Contractor> contractors){
        TaxService taxService;
        for (Contractor contractor:contractors) {
            switch (contractor.getType()){
                case PERSON:
                    taxService = new PersonTaxServiceImpl();
                    this.countAmount(taxService, contractor);
                    break;
                case COMPANY:
                    taxService = new CompanyTaxServiceImpl();
                    this.countAmount(taxService, contractor);
                    break;
                default:
            }
        }
    }
     void countAmount(TaxService taxService, Contractor contractor) {
        BigDecimal amount = contractor.getAmount();

        BigDecimal incomeTax = taxService.countIncomeTax(amount);
        contractor.setIncomeTax(incomeTax.toPlainString());

        BigDecimal businessTax = taxService.countBusinessTax(amount);
        contractor.setBusinessTax(businessTax.toPlainString());

        BigDecimal healthInsurance = taxService.countHealthInsurance(amount);
        contractor.setHealthInsuranceTax(healthInsurance.toPlainString());

        BigDecimal actualAmount = taxService.countActualPaymentAmount(incomeTax, businessTax, healthInsurance, amount);
        contractor.setActualAmount(actualAmount.toPlainString());
    }
}



