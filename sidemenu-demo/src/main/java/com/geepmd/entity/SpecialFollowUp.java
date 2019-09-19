package com.geepmd.entity;

public class SpecialFollowUp {

    private int followUpId;
    private String motherId;
    private String followUpMessage;

    public int getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(int followUpId) {
        this.followUpId = followUpId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getFollowUpMessage() {
        return followUpMessage;
    }

    public void setFollowUpMessage(String followUpMessage) {
        this.followUpMessage = followUpMessage;
    }
}
