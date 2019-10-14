package com.geepmd.utils;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.SocialCapitalCommonDetails;
import com.geepmd.entity.SocialCapitalQ1;
import com.geepmd.entity.SocialCapitalQ2;
import com.vaadin.ui.Notification;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.hibernate.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownloadSocialCapitalExcelFile extends DownloadFile {

    public DownloadSocialCapitalExcelFile(ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener) {
        super(excelDownloadServiceListener);
    }

    public void download() {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("Social Capital Survey");
        createHeaderRow(workbook, sheet);
        connection = DBConnection.getInstance();
        letterIntMap = SurveyUtils.getLetterIntMap();
        Session session = connection.getSession();
        List<SocialCapitalCommonDetails> commonList = (List<SocialCapitalCommonDetails>)connection.getAllValues(session,
                "com.geepmd.entity.SocialCapitalCommonDetails", "surveyId");
        if(commonList == null || commonList.size() == 0){
            Notification.show("No survey available for download", Notification.Type.WARNING_MESSAGE);
            return;
        }
        List<SocialCapitalQ1> q1List = (List<SocialCapitalQ1>)connection.getAllValues(session,"com.geepmd.entity.SocialCapitalQ1","socialCapitalQ1ID");
        Map<Integer,SocialCapitalQ1> q1Map = q1List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<SocialCapitalQ2> q2List = (List<SocialCapitalQ2>)connection.getAllValues(session,"com.geepmd.entity.SocialCapitalQ2","socialCapitalQ2Id");
        Map<Integer,SocialCapitalQ2> q2Map = q2List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));

        connection.closeSession(session);

        int rowCount = 1;
        for(SocialCapitalCommonDetails common : commonList) {
            Row row = sheet.createRow(rowCount);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(common.getSurveyId());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(common.getMotherId());
            valColumnCount = 2;
            SocialCapitalQ1 socialCapitalQ1 = q1Map.get(common.getSurveyId());
            createObjCells(socialCapitalQ1,"getM1",1,5,row);
            createObjCells(socialCapitalQ1,"getM2",1,6,row);
            createObjCells(socialCapitalQ1,"getM3",row);
            createObjCells(socialCapitalQ1,"getM4",1,4,row);
            createObjCells(socialCapitalQ1,"getM5",row);
            createObjCells(socialCapitalQ1,"getM6",row);
            createObjCells(socialCapitalQ1,"getM7",1,6,row);

            SocialCapitalQ2 socialCapitalQ2 = q2Map.get(common.getSurveyId());
            createObjCells(socialCapitalQ2,"getM1",1,2,row);
            createObjCells(socialCapitalQ2,"getM2",2,3,row);
            createObjCells(socialCapitalQ2,"getM3",row);
            createObjCells(socialCapitalQ2,"getM4",1,7,row);
            createObjCells(socialCapitalQ2,"getM6",1,3,row);
            createObjCells(socialCapitalQ2,"getM64",1,2,row);
            createObjCells(socialCapitalQ2,"getM65",row);
            createObjCells(socialCapitalQ2,"getM78a",row);
            createObjCells(socialCapitalQ2,"getM78b",row);
            createObjCells(socialCapitalQ2,"getM710a",row);
            createObjCells(socialCapitalQ2,"getM710b",row);
            createObjCells(socialCapitalQ2,"getM711a",row);
            createObjCells(socialCapitalQ2,"getM711b",row);
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
        columnCount = 2;
        createCells("A1",1,5);
        createCells("A2",1,6);
        createCells("A3");
        createCells("A4",1,4);
        createCells("A5");
        createCells("A6");
        createCells("A7",1,6);
        createCells("B1",1,2);
        createCells("B2",2,3);
        createCells("B3");
        createCells("B4",1,7);
        createCells("B6.1",1,3);
        createCells("B6.1.4",1,2);
        createCells("B6.1.5");
        createCells("B7.8a");
        createCells("B7.8b");
        createCells("B7.10a");
        createCells("B7.10b");
        createCells("B7.11");
        createCells("B7.11b");
    }
}
