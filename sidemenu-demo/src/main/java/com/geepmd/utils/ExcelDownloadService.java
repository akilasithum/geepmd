package com.geepmd.utils;

public interface ExcelDownloadService {

    public void createExcelFile(ExcelDownloadServiceListener excelDownloadServiceListener);

    public interface ExcelDownloadServiceListener {
        /**
         * On complete.
         *
         * @param filePath the response
         */
        public void onComplete(String filePath);

        /**
         * On file download fail.
         */
        default public void  onFail(){

        }
    }
}
