package com.geepmd.utils;

public class ExcelDownloadServiceImpl implements ExcelDownloadService {

    @Override
    public void createExcelFile(ExcelDownloadServiceListener excelDownloadServiceListener) {

        DownloadExcelFile instrumentFile = new DownloadExcelFile(excelDownloadServiceListener);
        Thread thread = new Thread(instrumentFile);
        thread.run();
    }
}
