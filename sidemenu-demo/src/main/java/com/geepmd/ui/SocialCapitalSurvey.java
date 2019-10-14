package com.geepmd.ui;

import com.geepmd.entity.*;
import com.geepmd.ui.CommonSurvey;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab1;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab2;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab3;
import com.geepmd.ui.socialCapital.SocialCapitalTab1;
import com.geepmd.ui.socialCapital.SocialCapitalTab2;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.hibernate.Session;

import java.util.Date;

public class SocialCapitalSurvey extends CommonSurvey {

    SocialCapitalTab1 tab1;
    SocialCapitalTab2 tab2;

    public SocialCapitalSurvey(){
        createLayout();
    }

    @Override
    protected void createLayout() {
        super.createLayout();
        header.setValue("Social Capital Questionnaire");
        tab1 = new SocialCapitalTab1(language,this);
        tab2 = new SocialCapitalTab2(language,this);


        tabsheet.addTab(tab1,"1. ඥානාත්මක (Cognitive)");
        tabsheet.addTab(tab2,"2. ව්\u200Dයුහගත (Structural)");
    }

    @Override
    public void updateDetailsIfAdded(String motherId) {
        clearAllFields();
        Session session = connection.getSession();
        SocialCapitalCommonDetails common = (SocialCapitalCommonDetails)connection.isMotherDetailsAdded("com.geepmd.entity.SocialCapitalCommonDetails",motherId);
        SpecialFollowUp specialFollowUp = (SpecialFollowUp)connection.getSpecialFollowup(motherId,session);
        if(specialFollowUp != null) {
            showSpecialFollowUpDetails(specialFollowUp);
        }
        else {
            errorLayout.setVisible(false);
        }
        if(common != null) {
            isEdit = true;
            int surveyId = common.getSurveyId();
            editSurveyId = surveyId;

            SocialCapitalQ1 q1List = (SocialCapitalQ1)connection.getPageValue("com.geepmd.entity.SocialCapitalQ1",surveyId,session);
            SocialCapitalQ2 q2List = (SocialCapitalQ2)connection.getPageValue("com.geepmd.entity.SocialCapitalQ2",surveyId,session);
            if(q1List != null) tab1.setEditData(q1List);
            if(q2List != null) tab2.setEditData(q2List);
            connection.closeSession(session);
        }
        else {
            editSurveyId = 0;
            isEdit = false;
            connection.closeSession(session);
        }
    }

    private void clearAllFields() {
        tab1.clearFields();
        tab2.clearFields();
    }

    @Override
    public void insertData() {
        if (motherSerialIdComboBox.getValue() == null) {
            Notification.show("Please select mother serial number", Notification.Type.WARNING_MESSAGE);
            return;
        }
        String motherId = motherSerialIdComboBox.getValue().toString();
        User user = (User) UI.getCurrent().getSession().getAttribute("userName");

        SocialCapitalCommonDetails common = (SocialCapitalCommonDetails)connection.isMotherDetailsAdded
                ("com.geepmd.entity.SocialCapitalCommonDetails",motherId);
        int surveyId;
        if (common != null) {
            editSurveyId = common.getSurveyId();
            isEdit = true;
        }

        common = new SocialCapitalCommonDetails();
        common.setMotherId(motherId);
        common.setAddedDate(new Date());
        common.setExaminorId(user.getUserId());
        Session session = connection.getSession();

        if (isEdit) {
            surveyId = editSurveyId;
            common.setSurveyId(surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.SocialCapitalQ1",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.SocialCapitalQ2",surveyId,session);
        }
        else {
            surveyId = connection.saveObjectHBM(common,session);
        }

        try{
            connection.saveOrUpdateHBM(tab1.getAnswers(surveyId),session);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            connection.saveOrUpdateHBM(tab2.getAnswers(surveyId),session);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        connection.closeSession(session);
        saveBtn.setEnabled(true);
        saveBtn.setCaption("Save Survey");
        getUI().getNavigator().navigateTo("SocialCapital");
        Notification.show("Survey added successfully");
    }
}
