package com.geepmd.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnglishMap {

    static List<String> yesNoList = Arrays.asList("1.Yes","2.No");

    public static Map<String,String> getTabHeaderMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1. SOCIO – DEMOGRAPHIC DATA");
        map.put("2","2. GYNECOLOGICAL HISTORY");
        map.put("3","3. OBSTETRIC HISTORY");
        map.put("4","4. CURRENT PREGNANCY");
        map.put("5","5. SYMPTOMS");
        map.put("6","6. PAST MEDICAL HISTORY");
        map.put("7","7. FAMILY HISTORY");
        map.put("8","8. ANNEX");
        return map;
    }

    public static Map<String,String> getquestion1Map(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1. SOCIO – DEMOGRAPHIC DATA");
        map.put("1.1","1.1 What is your birthday?");
        map.put("1.2","1.2 What is your ethnicity?");
        map.put("1.3","1.3 Are you confident in understanding health related messages in Sinhala?");
        map.put("1.4","1.4 What is your religion?");
        map.put("1.5","1.5 What is the last grade that you completed at school?");
        map.put("1.6","1.6 If you passed A/L, what is the education level obtained after A/L s?");
        map.put("1.7","1.7 Do you feel that you have been given adequate education on sexual and reproductive health " +
                "by school or an institute?");
        map.put("1.8","1.8 What is your marital status?");
        map.put("1.9","1.9 If married, how long have you been married?");
        return map;
    }

    public static Map<String,List<String>> getq1AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("1.2",Arrays.asList("1.Sinhala","2.Tamil","3.Moor","4.Malay","5.Burger","6.Other"));
        map.put("1.3",Arrays.asList("1.Yes both written and speech","2.Yes only speech","3.No"));
        map.put("1.4",Arrays.asList("1.Buddhist","2.Catholic/ Christian","3.Hindu","4.Islam","5.Other"));
        map.put("1.6",Arrays.asList("1.Certificate/ Diploma","2.Degree","3.not passed A/L","4.No Education after A/L"));
        map.put("1.7",yesNoList);
        map.put("1.8",yesNoList);
        return map;
    }
}
