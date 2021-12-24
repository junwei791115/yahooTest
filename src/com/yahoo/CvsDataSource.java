package com.yahoo;

import com.yahoo.vo.Contractor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CvsDataSource implements DataSource {

    public static final String RESOURCES_DATA_CVS = "resources//data.cvs";

    @Override
    public List<Contractor> getData() {
        List<Contractor> contractors = new ArrayList<>();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(RESOURCES_DATA_CVS));//檔案讀取路徑
            BufferedReader reader = new BufferedReader(isr);
            String line ;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                Contractor contractor = new Contractor();
                contractor.setNo(item[0].trim());
                contractor.setName(item[1].trim());
                contractor.setType(ContractorType.getByName(item[2].trim()));
                contractor.setAmount(new BigDecimal(item[3].trim()));
                contractors.add(contractor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contractors;
    }
}
