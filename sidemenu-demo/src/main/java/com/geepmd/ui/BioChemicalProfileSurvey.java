package com.geepmd.ui;

import com.geepmd.entity.*;
import com.geepmd.ui.bioChemical.BioChemicalTab1;
import com.geepmd.ui.bioChemical.BioChemicalTab2;
import com.geepmd.ui.bioChemical.BioChemicalTab3;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.hibernate.Session;

import java.util.Date;

public class BioChemicalProfileSurvey extends CommonSurvey {

    BioChemicalTab1 tab1;
    BioChemicalTab2 tab2;
    BioChemicalTab3 tab3;
    public BioChemicalProfileSurvey(){
        createLayout();
    }

    @Override
    protected void createLayout() {
        super.createLayout();
        header.setValue("Bio Chemical Profile");

        tab1 = new BioChemicalTab1(this);
        tab2 = new BioChemicalTab2(this);
        tab3 = new BioChemicalTab3(this);

        tabsheet.addTab(tab1,"1. 1st TM \t");
        tabsheet.addTab(tab2,"2. 2nd TM \t");
        tabsheet.addTab(tab3,"3. 3rd TM \t");
    }

    @Override
    public void updateDetailsIfAdded(String motherId) {
        clearAllFields();
        Session session = connection.getSession();
        BioChemicalCommon common = (BioChemicalCommon)connection.isMotherDetailsAdded("com.geepmd.entity.BioChemicalCommon",motherId);
        if(common != null) {
            isEdit = true;
            int surveyId = common.getSurveyId();
            editSurveyId = surveyId;

            BioChemicalQ1 q1List = (BioChemicalQ1)connection.getPageValue("com.geepmd.entity.BioChemicalQ1",surveyId,session);
            BioChemicalQ2 q2List = (BioChemicalQ2)connection.getPageValue("com.geepmd.entity.BioChemicalQ2",surveyId,session);
            BioChemicalQ3 q3List = (BioChemicalQ3)connection.getPageValue("com.geepmd.entity.BioChemicalQ3",surveyId,session);
            if(q1List != null) tab1.setEditData(q1List);
            if(q2List != null) tab2.setEditData(q2List);
            if(q3List != null) tab3.setEditData(q3List);
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
        tab3.clearFields();
    }

    @Override
    public void insertData() {
        if (motherSerialIdComboBox.getValue() == null) {
            Notification.show("Please select mother serial number", Notification.Type.WARNING_MESSAGE);
            return;
        }
        String motherId = motherSerialIdComboBox.getValue().toString();
        User user = (User) UI.getCurrent().getSession().getAttribute("userName");

        BioChemicalCommon common = (BioChemicalCommon)connection.isMotherDetailsAdded
                ("com.geepmd.entity.BioChemicalCommon",motherId);
        int surveyId;
        if (common != null) {
            editSurveyId = common.getSurveyId();
            isEdit = true;
        }

        common = new BioChemicalCommon();
        common.setMotherId(motherId);
        common.setAddedDate(new Date());
        common.setExaminorId(user.getUserId());
        Session session = connection.getSession();

        if (isEdit) {
            surveyId = editSurveyId;
            common.setSurveyId(surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BioChemicalQ1",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.BioChemicalQ2",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.BioChemicalQ3",surveyId,session);
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
        try{
            connection.saveOrUpdateHBM(tab3.getAnswers(surveyId),session);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        connection.closeSession(session);
        saveBtn.setEnabled(true);
        saveBtn.setCaption("Save Survey");
        getUI().getNavigator().navigateTo("BioChemicalProfile");
        Notification.show("Survey added successfully");
    }
}
