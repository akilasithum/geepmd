package com.geepmd.entity;

import java.util.Date;

public class CommonDetails {

    private int surveyId;
    private int motherId;
    private int examinorId;
    private Date addedDate;
    private String surveyType;

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getMotherId() {
        return motherId;
    }

    public void setMotherId(int motherId) {
        this.motherId = motherId;
    }

    public int getExaminorId() {
        return examinorId;
    }

    public void setExaminorId(int examinorId) {
        this.examinorId = examinorId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }
}
