package com.geepmd.entity;

import java.util.Date;

public class FirstFollowUpCommonDetails {

    private int surveyId;
    private String motherId;
    private int examinorId;
    private Date addedDate;

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
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
}
