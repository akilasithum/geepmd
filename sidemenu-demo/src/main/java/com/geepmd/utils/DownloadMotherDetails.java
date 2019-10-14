package com.geepmd.utils;


import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.MotherDetails;
import com.geepmd.entity.SocialCapitalCommonDetails;
import com.geepmd.entity.SocialCapitalQ1;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.hibernate.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class DownloadMotherDetails extends DownloadFile {

    public DownloadMotherDetails(ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener) {
        super(excelDownloadServiceListener);
    }

    public void download() {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("Mother Details");
        connection = DBConnection.getInstance();
        letterIntMap = SurveyUtils.getLetterIntMap();
        Session session = connection.getSession();
        List<MotherDetails> commonList = (List<MotherDetails>)connection.getAllValues(session,
                "com.geepmd.entity.MotherDetails", "motherRegNo");
        createHeaderRow(workbook, sheet);

        connection.closeSession(session);

        int rowCount = 1;
        for(MotherDetails common : commonList) {
            Row row = sheet.createRow(rowCount);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(common.getMotherSerialNumber());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(common.getMotherName());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(common.getAge());
            Cell cell4 = row.createCell(3);
            String dateStr = SurveyUtils.getDateStringFromDate(common.getDate());
            cell4.setCellValue(dateStr);
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(common.getExaminerRegNo());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(common.getNicNo());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(common.getMotherDocumentRegNo());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(common.getStartTime());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(common.getMohDivision());
            Cell cell10 = row.createCell(9);
            cell10.setCellValue(common.getPhmDivision());
            Cell cell11 = row.createCell(10);
            cell11.setCellValue(common.getAntenatalClinic());
            Cell cell12 = row.createCell(11);
            cell12.setCellValue(common.getEdd());
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
        cell1.setCellValue("Mother Serial No");
        cell1.setCellStyle(headerCellStyle);

        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Mother Name");
        cell2.setCellStyle(headerCellStyle);
        columnCount = 2;
        createCells("age");
        createCells("Date");
        createCells("Examiner Reg No");
        createCells("NIC No");
        createCells("Mother Document Reg No");
        createCells("Start Time");
        createCells("MOH Division");
        createCells("PHM Division");
        createCells("Antenatal Clinic");
        createCells("EDD");
    }
}
