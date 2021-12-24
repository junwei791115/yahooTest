package com.yahoo;

import java.util.Arrays;

public enum ContractorType {
    COMPANY("公司","company"), PERSON("個人","person");

   private String name;

   private String value;

    ContractorType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static ContractorType getByName(String name){
        for(ContractorType contractorType : values()){
            if(contractorType.name.equals(name)){
                return contractorType;
            }
        }
        return null;
    }
}
