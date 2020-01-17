package com.geepmd.utils;

public class ExcelDownloadServiceImpl implements ExcelDownloadService {

    @Override
    public void createExcelFile(ExcelDownloadServiceListener excelDownloadServiceListener,String type) {
        Thread thread = null;
        switch (type){
            case  "Baseline Questionnaire":
                DownloadBaseLineExcelFile downloadBaseLineExcelFile = new DownloadBaseLineExcelFile(excelDownloadServiceListener);
                thread = new Thread(downloadBaseLineExcelFile);
                break;
            case  "First Follow Up Questionnaire":
                DownloadFirstFollowUpExcel downloadFirstFollowUpExcel = new DownloadFirstFollowUpExcel(excelDownloadServiceListener);
                thread = new Thread(downloadFirstFollowUpExcel);

                break;
            case  "Social Capital Questionnaire":
                DownloadSocialCapitalExcelFile instrumentFile = new DownloadSocialCapitalExcelFile(excelDownloadServiceListener);
                thread = new Thread(instrumentFile);
                break;
            case  "Mother Details":
                DownloadMotherDetails instrumentFile1 = new DownloadMotherDetails(excelDownloadServiceListener);
                thread = new Thread(instrumentFile1);
                break;
            case  "Bio Chemical Profile":
                DownloadBioChemicalExcelFile downloadBioChemicalExcelFile = new DownloadBioChemicalExcelFile(excelDownloadServiceListener);
                thread = new Thread(downloadBioChemicalExcelFile);
                break;
        }
        thread.run();

    }
}
