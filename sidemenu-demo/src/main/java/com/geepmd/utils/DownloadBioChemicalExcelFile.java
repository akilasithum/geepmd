package com.geepmd.utils;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.*;
import com.vaadin.ui.Notification;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.hibernate.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownloadBioChemicalExcelFile extends DownloadFile {

    public DownloadBioChemicalExcelFile(ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener) {
        super(excelDownloadServiceListener);
    }
    @Override
    public void download() {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("Social Capital Survey");
        createHeaderRow(workbook, sheet);
        connection = DBConnection.getInstance();
        letterIntMap = SurveyUtils.getLetterIntMap();
        Session session = connection.getSession();
        List<BioChemicalCommon> commonList = (List<BioChemicalCommon>)connection.getAllValues(session,
                "com.geepmd.entity.BioChemicalCommon", "surveyId");
        if(commonList == null || commonList.size() == 0){
            Notification.show("No survey available for download", Notification.Type.WARNING_MESSAGE);
            return;
        }

        List<BioChemicalQ1> q1List = (List<BioChemicalQ1>)connection.getAllValues(session,"com.geepmd.entity.BioChemicalQ1","bioChemicalQId");
        Map<Integer,BioChemicalQ1> q1Map = q1List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BioChemicalQ2> q2List = (List<BioChemicalQ2>)connection.getAllValues(session,"com.geepmd.entity.BioChemicalQ2","bioChemicalQ2Id");
        Map<Integer,BioChemicalQ2> q2Map = q2List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BioChemicalQ3> q3List = (List<BioChemicalQ3>)connection.getAllValues(session,"com.geepmd.entity.BioChemicalQ3","bioChemicalQ3Id");
        Map<Integer,BioChemicalQ3> q3Map = q3List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));

        int rowCount = 1;
        for(BioChemicalCommon common : commonList) {
            Row row = sheet.createRow(rowCount);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(common.getSurveyId());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(common.getMotherId());
            valColumnCount = 2;

            BioChemicalQ1 socialCapitalQ1 = q1Map.get(common.getSurveyId());
            createObjCells(socialCapitalQ1,"getM",1,14,row);

            BioChemicalQ2 socialCapitalQ2= q2Map.get(common.getSurveyId());
            createObjCells(socialCapitalQ2,"getM",1,3,row);

            BioChemicalQ3 socialCapitalQ3 = q3Map.get(common.getSurveyId());
            createObjCells(socialCapitalQ3,"getM",1,1,row);
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
        createCells("A",1,14);
        createCells("B",1,3);
        createCells("C1");
    }
}
