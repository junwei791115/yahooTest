package com.yahoo;

import com.yahoo.vo.Contractor;

import java.util.List;

public class ConsoleServiceImpl implements OutputService{
    @Override
    public void output(List<Contractor> contractors) {
        System.out.println("案件編號,付款對象,付款對象種類,金額,所得稅,營業稅,二代健保,實際支付額");
        contractors.forEach(contractor -> {
            StringBuilder builder = new StringBuilder();
            builder.append(contractor.getNo()).append(",")
                    .append(contractor.getName()).append(",")
                    .append(contractor.getType().getName()).append(",")
                    .append(contractor.getAmount()).append(",")
                    .append(contractor.getIncomeTax()).append(",")
                    .append(contractor.getBusinessTax()).append(",")
                    .append(contractor.getHealthInsuranceTax()).append(",")
                    .append(contractor.getActualAmount()).append(",");
            System.out.println(builder);
        });
    }
}
