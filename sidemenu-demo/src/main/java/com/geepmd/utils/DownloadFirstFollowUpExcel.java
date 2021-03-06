package com.geepmd.utils;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.*;
import com.vaadin.ui.Notification;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.hibernate.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class DownloadFirstFollowUpExcel extends DownloadFile {

    public DownloadFirstFollowUpExcel(ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener) {
        super(excelDownloadServiceListener);
    }

    public void download() {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("First Follow up Survey");
        letterIntMap = SurveyUtils.getLetterIntMap();
        createHeaderRow(workbook, sheet);
        connection = DBConnection.getInstance();
        Session session = connection.getSession();
        List<FirstFollowUpCommonDetails> commonList = (List<FirstFollowUpCommonDetails>)connection.getAllValues(session,
                "com.geepmd.entity.FirstFollowUpCommonDetails", "surveyId");
        List<MotherDetails> motherDetails = connection.getMotherDetails();
        if(commonList == null || commonList.size() == 0){
            Notification.show("No survey available for download", Notification.Type.WARNING_MESSAGE);
            return;
        }
        Map<String,MotherDetails> motherDetailsMap = new HashMap<>();
        for(MotherDetails mother : motherDetails){
            motherDetailsMap.put(mother.getMotherSerialNumber(),mother);
        }
        List<FirstFollowUpQ1> q1List = (List<FirstFollowUpQ1>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowUpQ1","firstFollowUpQ1Id");
        Map<Integer,FirstFollowUpQ1> q1Map = q1List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<FirstFollowupQ2> q2List = (List<FirstFollowupQ2>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowupQ2","firstFollowupQ2Id");
        Map<Integer,FirstFollowupQ2> q2Map = q2List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<FirstFollowupQ3> q3List = (List<FirstFollowupQ3>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowupQ3","firstFollowupQ3Id");
        Map<Integer,FirstFollowupQ3> q3Map = q3List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<FirstFollowUpQ4> q4List = (List<FirstFollowUpQ4>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowUpQ4","firstFollowUpQ4Id");
        Map<Integer,FirstFollowUpQ4> q4Map = q4List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<FirstFollowUpQ46> q46List = (List<FirstFollowUpQ46>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowUpQ46","firstFollowUpQ46Id");
        Map<Integer,FirstFollowUpQ46> q46Map = q46List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));

        List<FirstFollowUpQ13> q13List = (List<FirstFollowUpQ13>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowUpQ13","firstFollowUpQ13Id");
        Map<Integer,List<FirstFollowUpQ13>> q13Map = new HashMap<>();
        for(FirstFollowUpQ13 base : q13List){
            if(q13Map.containsKey(base.getSurveyId())){
                q13Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<FirstFollowUpQ13> list = new ArrayList<>();
                list.add(base);
                q13Map.put(base.getSurveyId(),list);
            }
        }

        List<FirstFollowupQ21> q21List = (List<FirstFollowupQ21>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowupQ21","firstFollowupQ21Id");
        Map<Integer,List<FirstFollowupQ21>> q21Map = new HashMap<>();
        for(FirstFollowupQ21 base : q21List){
            if(q21Map.containsKey(base.getSurveyId())){
                q21Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<FirstFollowupQ21> list = new ArrayList<>();
                list.add(base);
                q21Map.put(base.getSurveyId(),list);
            }
        }

        List<FirstFollowUpQ125> q25List = (List<FirstFollowUpQ125>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowUpQ125","firstFollowUpQ125Id");
        Map<Integer,List<FirstFollowUpQ125>> q25Map = new HashMap<>();
        for(FirstFollowUpQ125 base : q25List){
            if(q25Map.containsKey(base.getSurveyId())){
                q25Map.get(base.getSurveyId()).add(base);
            }
            else{
                List<FirstFollowUpQ125> list = new ArrayList<>();
                list.add(base);
                q25Map.put(base.getSurveyId(),list);
            }
        }

        List<FirstFollowUpQ126> q26ist = (List<FirstFollowUpQ126>)connection.getAllValues(session,"com.geepmd.entity.FirstFollowUpQ126","firstFollowUpQ126Id");
        Map<Integer,FirstFollowUpQ126> q26Map = q26ist.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        connection.closeSession(session);
        int rowCount = 1;
        for(FirstFollowUpCommonDetails common : commonList) {
            Row row = sheet.createRow(rowCount);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(common.getSurveyId());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(common.getMotherId());

            FirstFollowUpQ1 firstFollowUpQ1 = q1Map.get(common.getSurveyId());
            if(firstFollowUpQ1.getSurveyDate() != null){
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(firstFollowUpQ1.getSurveyDate());
            }
            else{
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(getDateStr(common.getAddedDate()));
            }

            MotherDetails mother = motherDetailsMap.get(common.getMotherId());

            Cell cell4 = row.createCell(3);
            cell4.setCellValue(mother.getNicNo());

            Cell cell5 = row.createCell(4);
            cell5.setCellValue(mother.getMotherDocumentRegNo());

            Cell cell6 = row.createCell(5);
            cell6.setCellValue(mother.getEdd());

            valColumnCount = 6;
            createObjCells(firstFollowUpQ1,"getM",1,2,row);
            List<FirstFollowUpQ13> firstFollowUpQ13s = q13Map.get(common.getSurveyId());

            Map<String,FirstFollowUpQ13> q13OrderedMap = firstFollowUpQ13s.stream().collect(Collectors.toMap(x -> x.getQuestion(), x -> x));

            for(int i = 1;i<12;i++){
                createObjCells(q13OrderedMap.get(letterIntMap.get(i)),"getMedical",row);
                createObjCells(q13OrderedMap.get(letterIntMap.get(i)),"getTimes",row);
            }
            createObjCells(firstFollowUpQ1,"getM",4,24,row);
            List<FirstFollowUpQ125> firstFollowUpQ125s = q25Map.get(common.getSurveyId());
            Map<String,FirstFollowUpQ125> q125OrderedMap = firstFollowUpQ125s.stream().collect(Collectors.toMap(x -> x.getDateFld(), x -> x));
            createObjCells(q125OrderedMap.get("yesterday"),"getBreakfast",row);
            createObjCells(q125OrderedMap.get("yesterday"),"getLunch",row);
            createObjCells(q125OrderedMap.get("yesterday"),"getDinner",row);
            createObjCells(q125OrderedMap.get("day before yesterday"),"getBreakfast",row);
            createObjCells(q125OrderedMap.get("day before yesterday"),"getLunch",row);
            createObjCells(q125OrderedMap.get("day before yesterday"),"getDinner",row);
            FirstFollowUpQ126 firstFollowUpQ126s = q26Map.get(common.getSurveyId());
            createObjCells(firstFollowUpQ126s,"getMa",row);
            createObjCells(firstFollowUpQ126s,"getMb",row);
            createObjCells(firstFollowUpQ126s,"getMc",row);
            createObjCells(firstFollowUpQ126s,"getMd",row);
            createObjCells(firstFollowUpQ126s,"getMe",row);
            createObjCells(firstFollowUpQ126s,"getMf",row);
            createObjCells(firstFollowUpQ126s,"getMg",row);
            createObjCells(firstFollowUpQ126s,"getMh",row);
            createObjCells(firstFollowUpQ126s,"getMi",row);
            createObjCells(firstFollowUpQ126s,"getMj",row);
            createObjCells(firstFollowUpQ126s,"getMk",row);
            createObjCells(firstFollowUpQ126s,"getMl",row);
            Map<String,FirstFollowupQ21> q21OrderMap = q21Map.get(common.getSurveyId()).stream().collect(Collectors.toMap(x -> x.getQuestion(), x -> x));
            for(int i = 1;i<11;i++){
                createObjCells(q21OrderMap.get(letterIntMap.get(i)),"getYesNo",row);
                createObjCells(q21OrderMap.get(letterIntMap.get(i)),"getTimes",row);
                createObjCells(q21OrderMap.get(letterIntMap.get(i)),"getIncreaseWhenTired",row);
                createObjCells(q21OrderMap.get(letterIntMap.get(i)),"getMedicalTaken",row);
            }
            FirstFollowupQ2 firstFollowupQ2 = q2Map.get(common.getSurveyId());
            createObjCells(firstFollowupQ2,"getM",2,14,row);
            FirstFollowupQ3 firstFollowupQ3 = q3Map.get(common.getSurveyId());
            createObjCells(firstFollowupQ3,"getM",1,3,row);

            FirstFollowUpQ4 firstFollowUpQ4 = q4Map.get(common.getSurveyId());
            createObjCells(firstFollowUpQ4,"getM11",1,3,row);
            createObjCells(firstFollowUpQ4,"getM12",1,5,row);
            createObjCells(firstFollowUpQ4,"getM2",1,5,row);
            createObjCells(firstFollowUpQ4,"getM3",1,3,row);
            createObjCells(firstFollowUpQ4,"getM4",1,1,row);
            createObjCells(firstFollowUpQ4,"getM5",1,10,row);

            FirstFollowUpQ46 firstFollowUpQ46 = q46Map.get(common.getSurveyId());
            createObjCells(firstFollowUpQ46,"getM1",row);
            createObjCells(firstFollowUpQ46,"getM1",1,5,row);
            createObjCells(firstFollowUpQ46,"getM2",row);
            createObjCells(firstFollowUpQ46,"getM21",row);
            createObjCells(firstFollowUpQ46,"getM22",1,2,row);
            createObjCells(firstFollowUpQ46,"getM23",row);
            createObjCells(firstFollowUpQ46,"getM3",row);
            createObjCells(firstFollowUpQ46,"getM31",row);
            createObjCells(firstFollowUpQ46,"getM32",1,2,row);
            createObjCells(firstFollowUpQ46,"getM33",1,2,row);
            createObjCells(firstFollowUpQ46,"getM34",1,3,row);
            createObjCells(firstFollowUpQ46,"getM35",row);
            createObjCells(firstFollowUpQ46,"getM4",row);
            createObjCells(firstFollowUpQ46,"getM4",1,7,row);
            createObjCells(firstFollowUpQ46,"getM5",row);
            createObjCells(firstFollowUpQ46,"getM51",row);
            createObjCells(firstFollowUpQ46,"getM",6,8,row);
            createObjCells(firstFollowUpQ46,"getM8",1,3,row);
            createObjCells(firstFollowUpQ46,"getM9",row);
            createObjCells(firstFollowUpQ46,"getM9",1,2,row);
            createObjCells(firstFollowUpQ46,"getM10",row);
            rowCount++;
        }
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

    private String getDateStr(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    private void createHeaderRow(Workbook workbook, Sheet sheet) {
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

        Cell cell3 = headerRow.createCell(2);
        cell3.setCellValue("Survey Date");
        cell3.setCellStyle(headerCellStyle);

        Cell cell4 = headerRow.createCell(3);
        cell4.setCellValue("NIC No");
        cell4.setCellStyle(headerCellStyle);

        Cell cell5 = headerRow.createCell(4);
        cell5.setCellValue("Mother Document Reg No");
        cell5.setCellStyle(headerCellStyle);

        Cell cell6 = headerRow.createCell(5);
        cell6.setCellValue("EDD(USS)");
        cell6.setCellStyle(headerCellStyle);

        columnCount = 6;
        createCells("1",1,2);
        createCells("1.3",11,letterIntMap,2);
        createCells("1",4,24);
        createCells("1.25.a.breakfast");
        createCells("1.25.a.lunch");
        createCells("1.25.a.dinner");
        createCells("1.25.b.breakfast");
        createCells("1.25.b.lunch");
        createCells("1.25.b.dinner");
        createCells("1.26",12,letterIntMap,0);
        createCells("2.1",10,letterIntMap,4);
        createCells("2",2,14);
        createCells("3",1,3);
        createCells("4.1.1",1,3);
        createCells("4.1.2",1,5);
        createCells("4.2",1,5);
        createCells("4.3",1,3);
        createCells("4.4",1,1);
        createCells("4.5",1,10);
        createCells("4.6",1,1);
        createCells("4.6.1",1,5);
        createCells("4.6",2,2);
        createCells("4.6.2",1,1);
        createCells("4.6.2.2",1,2);
        createCells("4.6.2",3,3);
        createCells("4.6",3,3);
        createCells("4.6.3",1,1);
        createCells("4.6.3.2",1,2);
        createCells("4.6.3.3",1,2);
        createCells("4.6.3.4",1,3);
        createCells("4.6.3",5,5);
        createCells("4.6",4,4);
        createCells("4.6.4",1,7);
        createCells("4.6",5,5);
        createCells("4.6.5",1,1);
        createCells("4.6",6,8);
        createCells("4.6.8",1,3);
        createCells("4.6",9,9);
        createCells("4.6.9",1,2);
        createCells("4.6",10,10);
    }
}
