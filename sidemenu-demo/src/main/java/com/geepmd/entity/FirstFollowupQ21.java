package com.geepmd.entity;

public class FirstFollowupQ21 {

    private int firstFollowupQ21Id;
    private int surveyId;
    private String question;
    private int yesNo;
    private int times;
    private int increaseWhenTired;
    private int medicalTaken;

    public int getFirstFollowupQ21Id() {
        return firstFollowupQ21Id;
    }

    public void setFirstFollowupQ21Id(int firstFollowupQ21Id) {
        this.firstFollowupQ21Id = firstFollowupQ21Id;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getYesNo() {
        return yesNo;
    }

    public void setYesNo(int yesNo) {
        this.yesNo = yesNo;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getIncreaseWhenTired() {
        return increaseWhenTired;
    }

    public void setIncreaseWhenTired(int increaseWhenTired) {
        this.increaseWhenTired = increaseWhenTired;
    }

    public int getMedicalTaken() {
        return medicalTaken;
    }

    public void setMedicalTaken(int medicalTaken) {
        this.medicalTaken = medicalTaken;
    }
}
