package day12;

import org.junit.jupiter.api.Test;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void test1(){
        // how to use ExcelUtil
        //it accepts two arguments
        //Arg1:location of the file(path)
        //Arg2: worksheet that we want to open
        ExcelUtil vytrackFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","Q3-short");

        List<Map<String,String>> dataList = vytrackFile.getDataList();
        // use getDataList method to get the information of whole table

        for (Map<String, String> rowMap : dataList) {
            System.out.println(rowMap);
        }
    }

}
