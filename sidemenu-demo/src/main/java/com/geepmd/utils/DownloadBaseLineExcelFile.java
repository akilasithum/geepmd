package com.geepmd.utils;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.*;
import com.vaadin.ui.Notification;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.Session;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownloadBaseLineExcelFile implements Runnable{

    ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener;
    int columnCount = 0;
    int valColumnCount = 0;
    Row headerRow;
    CellStyle headerCellStyle;
    DBConnection connection;
    Map<Integer,String> letterIntMap;

    public DownloadBaseLineExcelFile(ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener) {
        this.excelDownloadServiceListener = excelDownloadServiceListener;
    }

    @Override
    public void run() {
        download();
    }

    private void download(){
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("Baseline survey");
        createHeaderRow(workbook,sheet);
        connection = DBConnection.getInstance();
        letterIntMap = SurveyUtils.getLetterIntMap();
        Session session = connection.getSession();
        List<CommonDetails> commonList = (List<CommonDetails>)connection.getAllValues(session,"com.geepmd.entity.CommonDetails",
                "surveyId");
        if(commonList == null || commonList.size() == 0){
            Notification.show("No survey available for download", Notification.Type.WARNING_MESSAGE);
            return;
        }
        List<BaselineQ1> q1List = (List<BaselineQ1>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ1","baselineQ1Id");
        Map<Integer,BaselineQ1> q1Map = q1List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ2> q2List = (List<BaselineQ2>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ2","baselineQ2Id");
        Map<Integer,BaselineQ2> q2Map = q2List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ3> q3List = (List<BaselineQ3>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ3","baselineQ3Id");
        Map<Integer,BaselineQ3> q3Map = q3List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ4> q4List = (List<BaselineQ4>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ4","baselineQ4Id");
        Map<Integer,BaselineQ4> q4Map = q4List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ5> q5List = (List<BaselineQ5>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ5","baselineQ5Id");
        Map<Integer,BaselineQ5> q5Map = q5List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ6> q6List = (List<BaselineQ6>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ6","baselineQ6Id");
        Map<Integer,BaselineQ6> q6Map = q6List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ7> q7List = (List<BaselineQ7>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ7","baselineQ7Id");
        Map<Integer, BaselineQ7> q7Map = q7List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ8> q8List = (List<BaselineQ8>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ8","baselineQ8Id");
        Map<Integer, BaselineQ8> q8Map = q8List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ9> q9List = (List<BaselineQ9>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ9","baselineQ9Id");
        Map<Integer, BaselineQ9> q9Map = q9List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ10> q10List = (List<BaselineQ10>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ10","baselineQ10Id");
        Map<Integer,List<BaselineQ10>> q10Map = new HashMap<>();
        for(BaselineQ10 base : q10List){
            if(q10Map.containsKey(base.getSurveyId())){
                q10Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<BaselineQ10> list = new ArrayList<>();
                list.add(base);
                q10Map.put(base.getSurveyId(),list);
            }
        }
        List<BaselineQ11> q11List = (List<BaselineQ11>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ11","baselineQ11Id");
        Map<Integer, BaselineQ11> q11Map = new HashMap<>();
        if(q11List != null){
            q11Map = q11List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        }
        List<BaselineQ12> q12List = (List<BaselineQ12>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ12","baselineQ12Id");
        Map<Integer, BaselineQ12> q12Map = new HashMap<>();
        if(q12List != null){
            q12Map = q12List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        }



        List<BaselineQ26> q26List = (List<BaselineQ26>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ26","baselineQ26Id");
        Map<Integer,BaselineQ26> q26Map = q26List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));

        List<BaselineQ28> q28List = (List<BaselineQ28>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ28","baselineQ28Id");
        Map<Integer,List<BaselineQ28>> q28Map = new HashMap<>();
        for(BaselineQ28 base : q28List){
            if(q28Map.containsKey(base.getSurveyId())){
                q28Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<BaselineQ28> list = new ArrayList<>();
                list.add(base);
                q28Map.put(base.getSurveyId(),list);
            }
        }

        List<BaselineQ32> q32List = (List<BaselineQ32>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ32","baselineQ32Id");
        Map<Integer,List<BaselineQ32>> q32Map = new HashMap<>();
        for(BaselineQ32 base : q32List){
            if(q32Map.containsKey(base.getSurveyId())){
                q32Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<BaselineQ32> list = new ArrayList<>();
                list.add(base);
                q32Map.put(base.getSurveyId(),list);
            }
        }
        List<BaselineQ51> q51List = (List<BaselineQ51>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ51","baselineQ51Id");
        Map<Integer,List<BaselineQ51>> q51Map = new HashMap<>();
        for(BaselineQ51 base : q51List){
            if(q51Map.containsKey(base.getSurveyId())){
                q51Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<BaselineQ51> list = new ArrayList<>();
                list.add(base);
                q51Map.put(base.getSurveyId(),list);
            }
        }
        List<BaselineQ62> q62List = (List<BaselineQ62>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ62","baselineQ62Id");
        Map<Integer,List<BaselineQ62>> q62Map = new HashMap<>();
        for(BaselineQ62 base : q62List){
            if(q62Map.containsKey(base.getSurveyId())){
                q62Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<BaselineQ62> list = new ArrayList<>();
                list.add(base);
                q62Map.put(base.getSurveyId(),list);
            }
        }

        List<BaselineQ84> q84List = (List<BaselineQ84>)connection.getAllValues(session,"com.geepmd.entity.BaselineQ84","baselineQ84Id");
        Map<Integer,List<BaselineQ84>> q84Map = new HashMap<>();
        for(BaselineQ84 base : q84List){
            if(q84Map.containsKey(base.getSurveyId())){
                q84Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<BaselineQ84> list = new ArrayList<>();
                list.add(base);
                q84Map.put(base.getSurveyId(),list);
            }
        }
        connection.closeSession(session);

        int rowCount = 1;
        for(CommonDetails common : commonList){
            Row row = sheet.createRow(rowCount);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(common.getSurveyId());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(common.getMotherId());
            valColumnCount = 2;
            BaselineQ1 baselineQ1 = q1Map.get(common.getSurveyId());
            createObjCells(baselineQ1,"getM",1,9,row);
            createObjCells(baselineQ1,"getF",1,5,row);
            BaselineQ2 baselineQ2 = q2Map.get(common.getSurveyId());
            BaselineQ26 baselineQ26 = q26Map.get(common.getSurveyId());
            createObjCells(baselineQ2,"getM",1,5,row);
            createObjCells(baselineQ26,"getD",1,9,row);
            createObjCells(baselineQ2,"getM",7,7,row);
            List<BaselineQ28> baselineQ28List = q28Map.get(common.getSurveyId());
            if(baselineQ28List == null || baselineQ28List.size() == 0){
                createEmptyCells(20);
            }
            else if(baselineQ28List.size() == 1){
                createObjCells(baselineQ28List.get(0),"getM",1,4,row);
                createEmptyCells(16);
            }
            else if(baselineQ28List.size() == 2){
                createObjCells(baselineQ28List.get(0),"getM",1,4,row);
                createObjCells(baselineQ28List.get(1),"getM",1,4,row);
                createEmptyCells(12);
            }
            else if(baselineQ28List.size() == 3){
                createObjCells(baselineQ28List.get(0),"getM",1,4,row);
                createObjCells(baselineQ28List.get(1),"getM",1,4,row);
                createObjCells(baselineQ28List.get(2),"getM",1,4,row);
                createEmptyCells(8);
            }
            else if(baselineQ28List.size() == 4){
                createObjCells(baselineQ28List.get(0),"getM",1,4,row);
                createObjCells(baselineQ28List.get(1),"getM",1,4,row);
                createObjCells(baselineQ28List.get(2),"getM",1,4,row);
                createObjCells(baselineQ28List.get(3),"getM",1,4,row);
                createEmptyCells(4);
            }
            else if(baselineQ28List.size() == 5){
                createObjCells(baselineQ28List.get(0),"getM",1,4,row);
                createObjCells(baselineQ28List.get(1),"getM",1,4,row);
                createObjCells(baselineQ28List.get(2),"getM",1,4,row);
                createObjCells(baselineQ28List.get(3),"getM",1,4,row);
                createObjCells(baselineQ28List.get(4),"getM",1,4,row);
            }
            createObjCells(baselineQ2,"getM",9,10,row);

            BaselineQ3 baselineQ3 = q3Map.get(common.getSurveyId());
            List<BaselineQ32> baselineQ32List = q32Map.get(common.getSurveyId());
            createObjCells(baselineQ3,"getM",1,1,row);

            if(baselineQ32List == null || baselineQ32List.size() == 0){
                createEmptyCells(64);
            }
            else if(baselineQ32List.size() == 1){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createEmptyCells(56);
            }
            else if(baselineQ32List.size() == 2){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createEmptyCells(48);
            }
            else if(baselineQ32List.size() == 3){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
                createEmptyCells(40);
            }
            else if(baselineQ32List.size() == 4){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
                createObjCells(baselineQ32List.get(3),"getM",1,8,row);
                createEmptyCells(32);
            }
            else if(baselineQ32List.size() == 5){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
                createObjCells(baselineQ32List.get(3),"getM",1,8,row);
                createObjCells(baselineQ32List.get(4),"getM",1,8,row);
                createEmptyCells(24);
            }

            else if(baselineQ32List.size() == 6){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
                createObjCells(baselineQ32List.get(3),"getM",1,8,row);
                createObjCells(baselineQ32List.get(4),"getM",1,8,row);
                createObjCells(baselineQ32List.get(5),"getM",1,8,row);
                createEmptyCells(16);
            }
            else if(baselineQ32List.size() == 7){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
                createObjCells(baselineQ32List.get(3),"getM",1,8,row);
                createObjCells(baselineQ32List.get(4),"getM",1,8,row);
                createObjCells(baselineQ32List.get(5),"getM",1,8,row);
                createObjCells(baselineQ32List.get(6),"getM",1,8,row);
                createEmptyCells(8);
            }
            else if(baselineQ32List.size() == 8){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
                createObjCells(baselineQ32List.get(3),"getM",1,8,row);
                createObjCells(baselineQ32List.get(4),"getM",1,8,row);
                createObjCells(baselineQ32List.get(5),"getM",1,8,row);
                createObjCells(baselineQ32List.get(6),"getM",1,8,row);
                createObjCells(baselineQ32List.get(7),"getM",1,8,row);
            }
            else{
                createEmptyCells(64);
            }

            createObjCells(baselineQ3,"getM",3,7,row);
            BaselineQ4 baselineQ4 = q4Map.get(common.getSurveyId());
            createObjCells(baselineQ4,"getM",1,12,row);
            List<BaselineQ51> baselineQ51List = q51Map.get(common.getSurveyId());
            BaselineQ5 baselineQ5 = q5Map.get(common.getSurveyId());
            if(baselineQ51List != null) {
                for (BaselineQ51 baselineQ51 : baselineQ51List) {
                    createObjCells(baselineQ51, "getB", 1, 4, row);
                    createObjCells(baselineQ51, "getA", 1, 4, row);
                }
            }else{
                createEmptyCells(88);
            }
            createObjCells(baselineQ5,"getM",2,3,row);

            BaselineQ6 baselineQ6 = q6Map.get(common.getSurveyId());
            List<BaselineQ62> baselineQ62List = q62Map.get(common.getSurveyId());
            createObjCells(baselineQ6,"getM1a",row);
            createObjCells(baselineQ6,"getM1b",row);
            createObjCells(baselineQ6,"getM1c",row);
            createObjCells(baselineQ6,"getM1d",row);
            if(baselineQ62List != null) {
                for (BaselineQ62 baselineQ62 : baselineQ62List) {
                    createObjCells(baselineQ62, "getM", 1, 5, row);
                }
            }
            else{
                createEmptyCells(105);
            }
            createObjCells(baselineQ6,"getM",3,12,row);

            BaselineQ7 baselineQ7 = q7Map.get(common.getSurveyId());
            createObjCells(baselineQ7,"getM81",9,row);

            BaselineQ8 baselineQ8 = q8Map.get(common.getSurveyId());
            createObjCells(baselineQ8,"getM",1,3,row);
            List<BaselineQ84> baselineQ84List = q84Map.get(common.getSurveyId());
            if(baselineQ84List== null || baselineQ84List.size() == 0){
                createEmptyCells(21);
            }
            else if(baselineQ84List.size() == 1){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createEmptyCells(18);
            }
            else if(baselineQ84List.size() == 2){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createObjCells(baselineQ84List.get(1),"getM",1,3,row);
                createEmptyCells(15);
            }
            else if(baselineQ84List.size() == 3){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createObjCells(baselineQ84List.get(1),"getM",1,3,row);
                createObjCells(baselineQ84List.get(2),"getM",1,3,row);
                createEmptyCells(12);
            }
            else if(baselineQ84List.size() == 4){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createObjCells(baselineQ84List.get(1),"getM",1,3,row);
                createObjCells(baselineQ84List.get(2),"getM",1,3,row);
                createObjCells(baselineQ84List.get(3),"getM",1,3,row);
                createEmptyCells(9);
            }
            else if(baselineQ84List.size() == 5){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createObjCells(baselineQ84List.get(1),"getM",1,3,row);
                createObjCells(baselineQ84List.get(2),"getM",1,3,row);
                createObjCells(baselineQ84List.get(3),"getM",1,3,row);
                createObjCells(baselineQ84List.get(4),"getM",1,3,row);
                createEmptyCells(6);
            }
            else if(baselineQ84List.size() == 6){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createObjCells(baselineQ84List.get(1),"getM",1,3,row);
                createObjCells(baselineQ84List.get(2),"getM",1,3,row);
                createObjCells(baselineQ84List.get(3),"getM",1,3,row);
                createObjCells(baselineQ84List.get(4),"getM",1,3,row);
                createObjCells(baselineQ84List.get(5),"getM",1,3,row);
                createEmptyCells(3);
            }
            else if(baselineQ84List.size() == 7){
                createObjCells(baselineQ84List.get(0),"getM",1,3,row);
                createObjCells(baselineQ84List.get(1),"getM",1,3,row);
                createObjCells(baselineQ84List.get(2),"getM",1,3,row);
                createObjCells(baselineQ84List.get(3),"getM",1,3,row);
                createObjCells(baselineQ84List.get(4),"getM",1,3,row);
                createObjCells(baselineQ84List.get(5),"getM",1,3,row);
                createObjCells(baselineQ84List.get(6),"getM",1,3,row);
            }
            createObjCells(baselineQ8,"getM5",1,17,row);

            BaselineQ9 baselineQ9 = q9Map.get(common.getSurveyId());
            createObjCells(baselineQ9,"getM",1,4,row);
            createObjCells(baselineQ9,"getM5",1,4,row);

            List<BaselineQ10> baselineQ10List = q10Map.get(common.getSurveyId());
            if(baselineQ10List != null) {
                for (BaselineQ10 baselineQ10 : baselineQ10List) {
                    createObjCells(baselineQ10, "getM", 1, 5, row);
                }
            }
            else {
                createEmptyCells(65);
            }

            BaselineQ11 baselineQ11 = q11Map.get(common.getSurveyId());
            if(baselineQ11 != null) {
                createObjCells(baselineQ11, "getM1", 1, 12, row);
                createObjCells(baselineQ11, "getM2", 1, 7, row);
                createObjCells(baselineQ11, "getM281", 1, 2, row);
                createObjCells(baselineQ11, "getM282", 1, 2, row);
                createObjCells(baselineQ11, "getM3", 1, 5, row);
                createObjCells(baselineQ11, "getM36", 1, 2, row);
                createObjCells(baselineQ11, "getM37", 1, 2, row);
            }
            else {
                createEmptyCells(32);
            }

            BaselineQ12 baselineQ12 = q12Map.get(common.getSurveyId());
            if(baselineQ12 != null) {
                createObjCells(baselineQ12,"getM",1,14,row);
                Cell specialNotes = row.createCell(valColumnCount);
                specialNotes.setCellValue(baselineQ12.getSpecialNotes());
            }
            rowCount++;
        }

        //downloadFile(workbook);
        File tempFile = null;
        try {
            tempFile = File.createTempFile("tmp", ".xlsx");

        FileOutputStream fileOut = new FileOutputStream(tempFile);
        workbook.write(fileOut);
        fileOut.close();
        workbook.dispose();
        excelDownloadServiceListener.onComplete(tempFile.getPath());
        } catch (Exception e) {
            excelDownloadServiceListener.onFail();
        }
    }

    private void createObjCells(Object obj,String methodPrefix,int startIndex,int endIndex,Row row){
        try {
            if(obj == null){
                for(int i = startIndex;i<endIndex+1;i++){
                    valColumnCount++;
                }
                return;
            }
            for(int i = startIndex;i<endIndex+1;i++){
                Method getNameMethod = obj.getClass().getMethod(methodPrefix+i);
                String name = String.valueOf(getNameMethod.invoke(obj));
                Object object = getNameMethod.invoke(obj);
                if(object instanceof Integer){
                    int val = Integer.parseInt(object.toString());
                    if(val != 0) {
                        row.createCell(valColumnCount).setCellValue(val);
                    }
                }
                else {
                    if(name != null && !name.equalsIgnoreCase("null"))
                        row.createCell(valColumnCount).setCellValue(name);
                }
                valColumnCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createObjCells(Object obj,String methodPrefix,int endIndex,Row row){
        try {
            if(obj == null){
                for(int i = 1;i<endIndex+1;i++){
                    valColumnCount++;
                }
                return;
            }
            for(int i = 1;i<endIndex+1;i++){
                Method getNameMethod = obj.getClass().getMethod(methodPrefix+letterIntMap.get(i));
                String name = String.valueOf(getNameMethod.invoke(obj));
                Object object = getNameMethod.invoke(obj);
                if(object instanceof Integer){
                    int val = Integer.parseInt(object.toString());
                    if(val != 0) {
                        row.createCell(valColumnCount).setCellValue(val);
                    }
                }
                else {
                    if(name != null && !name.equalsIgnoreCase("null"))
                        row.createCell(valColumnCount).setCellValue(name);
                }
                valColumnCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createObjCells(Object obj,String methodPrefix,Row row){
        if(obj == null){
            valColumnCount++;
            return;
        }
        try {
            Method getNameMethod = obj.getClass().getMethod(methodPrefix);
            String name = String.valueOf(getNameMethod.invoke(obj));
            Object object = getNameMethod.invoke(obj);
            if(object instanceof Integer){
                int val = Integer.parseInt(object.toString());
                if(val != 0) {
                    row.createCell(valColumnCount).setCellValue(val);
                }
            }
            else {
                if(name != null && !name.equalsIgnoreCase("null"))
                    row.createCell(valColumnCount).setCellValue(name);
            }
            valColumnCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createEmptyCells(int count){
        for(int i = 0;i<count;i++){
            valColumnCount++;
        }
    }

    private void createHeaderRow(Workbook workbook,Sheet sheet){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setWrapText(true);

        headerRow = sheet.createRow(0);

        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("UniqueKey");
        cell1.setCellStyle(headerCellStyle);

        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("motherId");
        cell2.setCellStyle(headerCellStyle);
        columnCount = 2;
        createCells("AM1",1,9);
        createCells("AF1",1,5);
        createCells("B2",1,5);
        createCells("B2.6",1,9);
        createCells("B2",7,7);
        createCells("B2.8.1",1,4);
        createCells("B2.8.2",1,4);
        createCells("B2.8.3",1,4);
        createCells("B2.8.4",1,4);
        createCells("B2.8.5",1,4);
        createCells("B2",9,10);
        createCells("C3",1,1);
        createCells("C3.2.1",1,8);
        createCells("C3.2.2",1,8);
        createCells("C3.2.3",1,8);
        createCells("C3.2.4",1,8);
        createCells("C3.2.5",1,8);
        createCells("C3.2.6",1,8);
        createCells("C3.2.7",1,8);
        createCells("C3.2.8",1,8);
        createCells("C3",3,7);
        createCells("D4",1,12);
        createCells("E5.1.a",1,8);
        createCells("E5.1.b",1,8);
        createCells("E5.1.c",1,8);
        createCells("E5.1.d",1,8);
        createCells("E5.1.e",1,8);
        createCells("E5.1.f",1,8);
        createCells("E5.1.g",1,8);
        createCells("E5.1.h",1,8);
        createCells("E5.1.i",1,8);
        createCells("E5.1.j",1,8);
        createCells("E5.1.k",1,8);
        createCells("D5",2,3);
        createCells("F6.1.a");
        createCells("F6.1.b");
        createCells("F6.1.c");
        createCells("F6.1.d");
        createCells("F6.2.a",1,5);
        createCells("F6.2.b",1,5);
        createCells("F6.2.c",1,5);
        createCells("F6.2.d",1,5);
        createCells("F6.2.e",1,5);
        createCells("F6.2.f",1,5);
        createCells("F6.2.g",1,5);
        createCells("F6.2.h",1,5);
        createCells("F6.2.i",1,5);
        createCells("F6.2.j",1,5);
        createCells("F6.2.k",1,5);
        createCells("F6.2.l",1,5);
        createCells("F6.2.m",1,5);
        createCells("F6.2.n",1,5);
        createCells("F6.2.o",1,5);
        createCells("F6.2.p",1,5);
        createCells("F6.2.q",1,5);
        createCells("F6.2.r",1,5);
        createCells("F6.2.s",1,5);
        createCells("F6.2.t",1,5);
        createCells("F6.2.u",1,5);
        createCells("F6",3,12);
        createCells("G7.1.a");
        createCells("G7.1.b");
        createCells("G7.1.c");
        createCells("G7.1.d");
        createCells("G7.1.e");
        createCells("G7.1.f");
        createCells("G7.1.g");
        createCells("G7.1.h");
        createCells("G7.1.i");
        createCells("H8",1,3);
        createCells("H8.4.1",1,3);
        createCells("H8.4.2",1,3);
        createCells("H8.4.3",1,3);
        createCells("H8.4.4",1,3);
        createCells("H8.4.5",1,3);
        createCells("H8.4.6",1,3);
        createCells("H8.4.7",1,3);
        createCells("H8.5",1,17);
        createCells("I9",1,4);
        createCells("I9.5",1,4);
        createCells("J10.1.1",1,5);
        createCells("J10.1.2",1,5);
        createCells("J10.1.3",1,5);
        createCells("J10.1.4",1,5);
        createCells("J10.1.5",1,5);
        createCells("J10.1.6",1,5);
        createCells("J10.1.7",1,5);
        createCells("J10.1.8",1,5);
        createCells("J10.1.9",1,5);
        createCells("J10.1.10",1,5);
        createCells("J10.1.11",1,5);
        createCells("J10.1.12",1,5);
        createCells("J10.1.13",1,5);
        createCells("k11.1",1,12);
        createCells("k11.2",1,7);
        createCells("k11.281",1,2);
        createCells("k11.282",1,2);
        createCells("k11.3",1,5);
        createCells("k11.36",1,2);
        createCells("k11.37",1,2);
        createCells("L12",1,14);
        Cell specialNotes = headerRow.createCell(columnCount);
        specialNotes.setCellValue("Special Notes");
        specialNotes.setCellStyle(headerCellStyle);
    }

    private void createCells(String headerPrefix,int startIndex,int count){
        for(int i = startIndex; i<count+1;i++){
            Cell cell = headerRow.createCell(columnCount);
            cell.setCellValue(headerPrefix+"."+i);
            cell.setCellStyle(headerCellStyle);
            columnCount++;
        }
    }

    private void createCells(String headerPrefix){

        Cell cell = headerRow.createCell(columnCount);
        cell.setCellValue(headerPrefix);
        cell.setCellStyle(headerCellStyle);
        columnCount++;
    }
}
