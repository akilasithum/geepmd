package com.geepmd.utils;

import com.geepmd.dbConnection.DBConnection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Method;
import java.util.Map;

public abstract class DownloadFile implements Runnable{

    ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener;
    int columnCount = 0;
    int valColumnCount = 0;
    Row headerRow;
    CellStyle headerCellStyle;
    DBConnection connection;
    Map<Integer,String> letterIntMap;

    public DownloadFile(ExcelDownloadService.ExcelDownloadServiceListener excelDownloadServiceListener) {
        this.excelDownloadServiceListener = excelDownloadServiceListener;
    }

    @Override
    public void run() {
        download();
    }

    public abstract void download();

    public void createObjCells(Object obj,String methodPrefix,Row row){
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

    public void createObjCells(Object obj,String methodPrefix,int startIndex,int endIndex,Row row){
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

    public void createObjCells(Object obj,String methodPrefix,int endIndex,Row row){
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

    public void createCells(String headerPrefix,int startIndex,int count){
        for(int i = startIndex; i<count+1;i++){
            Cell cell = headerRow.createCell(columnCount);
            cell.setCellValue(headerPrefix+"."+i);
            cell.setCellStyle(headerCellStyle);
            columnCount++;
        }
    }

    public void createCells(String headerPrefix,int count,Map<Integer,String> letterIntMap,int column){
        if(column == 0){
            for(int i = 1; i<count+1;i++){
                    Cell cell = headerRow.createCell(columnCount);
                    cell.setCellValue(headerPrefix+"."+letterIntMap.get(i));
                    cell.setCellStyle(headerCellStyle);
                    columnCount++;
            }
        }
        else{
            for(int i = 1; i<count+1;i++){
                for(int j=1;j<column+1;j++){
                    Cell cell = headerRow.createCell(columnCount);
                    cell.setCellValue(headerPrefix+"."+letterIntMap.get(i)+"." + j);
                    cell.setCellStyle(headerCellStyle);
                    columnCount++;
                }
            }
        }

    }

    public void createCells(String headerPrefix){

        Cell cell = headerRow.createCell(columnCount);
        cell.setCellValue(headerPrefix);
        cell.setCellStyle(headerCellStyle);
        columnCount++;
    }
}
