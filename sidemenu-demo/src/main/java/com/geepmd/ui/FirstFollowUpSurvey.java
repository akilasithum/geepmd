package com.geepmd.ui;

import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab1;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab2;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab3;

public class FirstFollowUpSurvey extends CommonSurvey{

    FirstFollowUpTab1 tab1;
    FirstFollowUpTab2 tab2;
    FirstFollowUpTab3 tab3;
    public FirstFollowUpSurvey(){
        createLayout();
    }

    @Override
    protected void createLayout() {
        super.createLayout();
        header.setValue("First Follow Up Questionnaire");

        tab1 = new FirstFollowUpTab1(language,this);
        //tab1.setStyleName("subTabStyle");
        tab2 = new FirstFollowUpTab2(language,this);
        //tab2.setStyleName("subTabStyle");
        tab3 = new FirstFollowUpTab3(language,this);
       // tab3.setStyleName("subTabStyle");

        tabsheet.addTab(tab1,"1. වර්තමාන ගර්භණී තත්ත්වය");
        tabsheet.addTab(tab2,"2. ගර්භණී සමයේ රෝග ලක්ෂණ");
        tabsheet.addTab(tab3,"3. විවාහ ජීවිතය පිළිබඳ");
    }

    @Override
    public void updateDetailsIfAdded(String motherId) {

    }

    @Override
    public void insertData() {

    }
}
