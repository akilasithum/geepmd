package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.*;
import com.geepmd.entity.CommonDetails;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownloadExcel extends VerticalLayout implements View {

    private Button downloadBtn;
    int columnCount = 0;
    int valColumnCount = 0;
    Row headerRow;
    CellStyle headerCellStyle;
    DBConnection connection;
    Image logo;
    Map<Integer,String> letterIntMap;


    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Object userName = UI.getCurrent().getSession().getAttribute("userName");
        if (userName == null || userName.toString().isEmpty()) {
            getUI().getNavigator().navigateTo("Login");
        }
    }

    public DownloadExcel(){
        connection = DBConnection.getInstance();
        letterIntMap = SurveyUtils.getLetterIntMap();
        createLayout();
    }

    private void createLayout(){

        downloadBtn = new Button("Download Excel");
        downloadBtn.setIcon(VaadinIcons.DOWNLOAD);
        //downloadBtn.addClickListener(event -> download());
        addComponent(downloadBtn);
        logo = new Image();
        logo.setSource(new ThemeResource("images/tenor.png"));
        addComponent(logo);
        logo.setVisible(false);
        download();
    }

    private void download(){
        logo.setVisible(true);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Baseline survey");
        createHeaderRow(workbook,sheet);
        FileOutputStream fileOut = null;

        List<CommonDetails> commonList = (List<CommonDetails>)connection.getAllValues("com.geepmd.entity.CommonDetails",
                "surveyId");
        List<BaselineQ1> q1List = (List<BaselineQ1>)connection.getAllValues("com.geepmd.entity.BaselineQ1","baselineQ1Id");
        Map<Integer,BaselineQ1> q1Map = q1List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));
        List<BaselineQ2> q2List = (List<BaselineQ2>)connection.getAllValues("com.geepmd.entity.BaselineQ2","baselineQ2Id");
        Map<Integer,BaselineQ2> q2Map = q2List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));
        List<BaselineQ3> q3List = (List<BaselineQ3>)connection.getAllValues("com.geepmd.entity.BaselineQ3","baselineQ3Id");
        Map<Integer,BaselineQ3> q3Map = q3List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));
        List<BaselineQ4> q4List = (List<BaselineQ4>)connection.getAllValues("com.geepmd.entity.BaselineQ4","baselineQ4Id");
        Map<Integer,BaselineQ4> q4Map = q4List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));
        List<BaselineQ5> q5List = (List<BaselineQ5>)connection.getAllValues("com.geepmd.entity.BaselineQ5","baselineQ5Id");
        Map<Integer,BaselineQ5> q5Map = q5List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));
        List<BaselineQ6> q6List = (List<BaselineQ6>)connection.getAllValues("com.geepmd.entity.BaselineQ6","baselineQ6Id");
        Map<Integer,BaselineQ6> q6Map = q6List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));
        List<BaselineQ7> q7List = (List<BaselineQ7>)connection.getAllValues("com.geepmd.entity.BaselineQ7","baselineQ7Id");
        Map<Integer,BaselineQ7> q7Map = q7List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));
        List<BaselineQ8> q8List = (List<BaselineQ8>)connection.getAllValues("com.geepmd.entity.BaselineQ8","baselineQ8Id");
        Map<Integer,BaselineQ8> q8Map = q8List.stream().collect(Collectors.toMap(x -> x.getMotherId(), x -> x));

        List<BaselineQ26> q26List = (List<BaselineQ26>)connection.getAllValues("com.geepmd.entity.BaselineQ26","baselineQ26Id");
        Map<Integer,BaselineQ26> q26Map = q26List.stream().collect(Collectors.toMap(x -> x.getSurveyId(), x -> x));

        List<BaselineQ32> q32List = (List<BaselineQ32>)connection.getAllValues("com.geepmd.entity.BaselineQ32","baselineQ32Id");
        Map<Integer,List<BaselineQ32>> q32Map = new HashMap<>();
        for(BaselineQ32 base : q32List){
            if(q32Map.containsKey(base.getMotherId())){
                q32Map.get(base.getMotherId()).add(base);
            }
            else{
                List<BaselineQ32> list = new ArrayList<>();
                list.add(base);
                q32Map.put(base.getMotherId(),list);
            }
        }
        List<BaselineQ51> q51List = (List<BaselineQ51>)connection.getAllValues("com.geepmd.entity.BaselineQ51","baselineQ51Id");
        Map<Integer,List<BaselineQ51>> q51Map = new HashMap<>();
        for(BaselineQ51 base : q51List){
            if(q51Map.containsKey(base.getMotherId())){
                q51Map.get(base.getMotherId()).add(base);
            }
            else{
                List<BaselineQ51> list = new ArrayList<>();
                list.add(base);
                q51Map.put(base.getMotherId(),list);
            }
        }
        List<BaselineQ62> q62List = (List<BaselineQ62>)connection.getAllValues("com.geepmd.entity.BaselineQ62","baselineQ62Id");
        Map<Integer,List<BaselineQ62>> q62Map = new HashMap<>();
        for(BaselineQ62 base : q62List){
            if(q62Map.containsKey(base.getMotherId())){
                q62Map.get(base.getMotherId()).add(base);
            }
            else{
                List<BaselineQ62> list = new ArrayList<>();
                list.add(base);
                q62Map.put(base.getMotherId(),list);
            }
        }
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
            valColumnCount++;
            createObjCells(baselineQ2,"getM",9,13,row);
            BaselineQ3 baselineQ3 = q3Map.get(common.getSurveyId());
            List<BaselineQ32> baselineQ32List = q32Map.get(common.getSurveyId());
            createObjCells(baselineQ3,"getM",1,1,row);

            if(baselineQ32List == null || baselineQ32List.size() == 0){
                createEmptyCells(24);
            }
            else if(baselineQ32List.size() == 1){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createEmptyCells(16);
            }
            else if(baselineQ32List.size() == 2){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createEmptyCells(8);
            }
            else if(baselineQ32List.size() == 3){
                createObjCells(baselineQ32List.get(0),"getM",1,8,row);
                createObjCells(baselineQ32List.get(1),"getM",1,8,row);
                createObjCells(baselineQ32List.get(2),"getM",1,8,row);
            }
            createObjCells(baselineQ3,"getM",3,7,row);
            BaselineQ4 baselineQ4 = q4Map.get(common.getSurveyId());
            createObjCells(baselineQ4,"getM",1,12,row);
            List<BaselineQ51> baselineQ51List = q51Map.get(common.getSurveyId());
            BaselineQ5 baselineQ5 = q5Map.get(common.getSurveyId());
            for(BaselineQ51 baselineQ51 : baselineQ51List){
                createObjCells(baselineQ51,"getB",1,4,row);
                createObjCells(baselineQ51,"getA",1,4,row);
            }
            createObjCells(baselineQ5,"getM",2,3,row);

            BaselineQ6 baselineQ6 = q6Map.get(common.getSurveyId());
            List<BaselineQ62> baselineQ62List = q62Map.get(common.getSurveyId());
            createObjCells(baselineQ6,"getM1a",row);
            createObjCells(baselineQ6,"getM1b",row);
            createObjCells(baselineQ6,"getM1c",row);
            createObjCells(baselineQ6,"getM1d",row);
            for(BaselineQ62 baselineQ62 : baselineQ62List){
                createObjCells(baselineQ62,"getM",1,5,row);
            }
            createObjCells(baselineQ6,"getM",3,12,row);

            BaselineQ7 baselineQ7 = q7Map.get(common.getSurveyId());
            createObjCells(baselineQ7,"getM",1,1,row);
            createObjCells(baselineQ7,"getM2aQ",row);
            createObjCells(baselineQ7,"getM2a",row);
            createObjCells(baselineQ7,"getM2bQ",row);
            createObjCells(baselineQ7,"getM2b",row);
            createObjCells(baselineQ7,"getM2cQ",row);
            createObjCells(baselineQ7,"getM2c",row);
            createObjCells(baselineQ7,"getM2dQ",row);
            createObjCells(baselineQ7,"getM2d",row);
            createObjCells(baselineQ7,"getM2eQ",row);
            createObjCells(baselineQ7,"getM2e",row);
            createObjCells(baselineQ7,"getM3a",row);
            createObjCells(baselineQ7,"getM3b",row);
            createObjCells(baselineQ7,"getM3c",row);

            BaselineQ8 baselineQ8 = q8Map.get(common.getSurveyId());
            createObjCells(baselineQ8,"getM81",9,row);
            rowCount++;
        }

        try {
            //fileOut = new FileOutputStream("E:\\baseline_survey.xlsx");
            //File pdfFile = new File("baseline_survey.pdf");
            File file=new File("baseline_survey.xlsx");
            FileResource fir=new FileResource(file);
            FileDownloader fileDownloader = new FileDownloader(fir);
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            workbook.close();
            fileDownloader.extend(downloadBtn);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        logo.setVisible(false);
    }

    private void createObjCells(Object obj,String methodPrefix,int startIndex,int endIndex,Row row){
        try {

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
        createCells("B2",7,13);
        createCells("C3",1,1);
        createCells("C3.2.1",1,8);
        createCells("C3.2.2",1,8);
        createCells("C3.2.3",1,8);
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
        createCells("F6",3,12);
        createCells("G7.1");
        createCells("G7.2.a",1,2);
        createCells("G7.2.b",1,2);
        createCells("G7.2.c",1,2);
        createCells("G7.2.d",1,2);
        createCells("G7.2.e",1,2);
        createCells("G7.3.a");
        createCells("G7.3.b");
        createCells("G7.3.c");
        createCells("F8.1.a");
        createCells("F8.1.b");
        createCells("F8.1.c");
        createCells("F8.1.d");
        createCells("F8.1.e");
        createCells("F8.1.f");
        createCells("F8.1.g");
        createCells("F8.1.h");
        createCells("F8.1.i");
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
