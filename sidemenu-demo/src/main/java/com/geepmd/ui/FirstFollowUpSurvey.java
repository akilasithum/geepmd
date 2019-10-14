package com.geepmd.ui;

import com.geepmd.entity.*;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab1;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab2;
import com.geepmd.ui.firstFollowupSurvey.FirstFollowUpTab3;
import com.vaadin.ui.*;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class FirstFollowUpSurvey extends CommonSurvey{

    FirstFollowUpTab1 tab1;
    FirstFollowUpTab2 tab2;
    FirstFollowUpTab3 tab3;
    Window window = new Window("Mother Details");
    public FirstFollowUpSurvey(){
        createLayout();
    }

    @Override
    protected void createLayout() {
        super.createLayout();
        header.setValue("First Follow Up Questionnaire");

        tab1 = new FirstFollowUpTab1(language,this);
        tab2 = new FirstFollowUpTab2(language,this);
        tab3 = new FirstFollowUpTab3(language,this);

        tabsheet.addTab(tab1,"1. වර්තමාන ගර්භණී තත්ත්වය");
        tabsheet.addTab(tab2,"2. ගර්භණී සමයේ රෝග ලක්ෂණ");
        tabsheet.addTab(tab3,"3. විවාහ ජීවිතය පිළිබඳ");
    }

    @Override
    public void updateDetailsIfAdded(String motherId) {
        clearAllFields();
        Session session = connection.getSession();
        SpecialFollowUp specialFollowUp = (SpecialFollowUp)connection.getSpecialFollowup(motherId,session);
        if(specialFollowUp != null) {
            showSpecialFollowUpDetails(specialFollowUp);
        }
        else {
            errorLayout.setVisible(false);
        }
        MotherDetails mother = (MotherDetails)connection.getMotherDetailsByMotherID(motherId,session);
        openMotherDetailsPopUp(mother);
        FirstFollowUpCommonDetails common = (FirstFollowUpCommonDetails)connection.isMotherDetailsAdded("com.geepmd.entity.FirstFollowUpCommonDetails",motherId);

        if(common != null) {
            isEdit = true;
            int surveyId = common.getSurveyId();
            editSurveyId = surveyId;

            FirstFollowUpQ1 q1List = (FirstFollowUpQ1)connection.getPageValue("com.geepmd.entity.FirstFollowUpQ1",surveyId,session);
            List<FirstFollowUpQ13> q13List = (List<FirstFollowUpQ13>) connection.getAllValues("com.geepmd.entity.FirstFollowUpQ13",surveyId,session);
            List<FirstFollowUpQ125> q125List = (List<FirstFollowUpQ125>) connection.getAllValues("com.geepmd.entity.FirstFollowUpQ125",surveyId,session);
            FirstFollowUpQ126 q126List = (FirstFollowUpQ126)connection.getPageValue("com.geepmd.entity.FirstFollowUpQ126",surveyId,session);
            FirstFollowupQ2 q2Answer = (FirstFollowupQ2)connection.getPageValue("com.geepmd.entity.FirstFollowupQ2",surveyId,session);
            List<FirstFollowupQ21> q21List = (List<FirstFollowupQ21>) connection.getAllValues("com.geepmd.entity.FirstFollowupQ21",surveyId,session);
            FirstFollowupQ3 q3Answer = (FirstFollowupQ3)connection.getPageValue("com.geepmd.entity.FirstFollowupQ3",surveyId,session);

            if(q1List != null) tab1.setEditData(q1List);
            if(q13List != null) tab1.setEditData13(q13List);
            if(q125List != null) tab1.setEditData125(q125List);
            if(q126List != null) tab1.setEditData126(q126List);
            if(q21List != null) tab2.setEditDataQ21(q21List);
            if(q2Answer != null) tab2.setEditData(q2Answer);
            if(q3Answer != null) tab3.setEditData(q3Answer);
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

    public void openMotherDetailsPopUp(MotherDetails mother){
        if(!window.isAttached()) {
            window.setWidth("550px");
            window.center();
            window.setModal(true);
            FormLayout layout = new FormLayout();

            TextField nicNoFld = new TextField("ජා.හැ.අංකය");
            TextField mohFld = new TextField("සෞ.වෛ.නි. කොට්ඨාශය");
            TextField pregRegNo = new TextField("ගර්භණී මව්වරුන්ගේ ලේඛනයේ ලියාපදිංචි අංකය");
            TextField eddNoFld = new TextField("EDD (USS)(ගර්භණී පතෙහි සඳහන් පරිදි)");
            TextField examinorNoFld = new TextField("සමීක්ෂකවරයාගේ අංකය");
            TextField startTime = new TextField("ආරම්භක වේලාව");
            nicNoFld.setValue(mother.getNicNo());
            mohFld.setValue(mother.getMohDivision());
            pregRegNo.setValue(mother.getMotherDocumentRegNo());
            examinorNoFld.setValue(mother.getExaminerRegNo());
            startTime.setValue(mother.getStartTime());

            layout.addComponents(nicNoFld, mohFld, pregRegNo, eddNoFld, examinorNoFld, startTime);
            Button okBtn = new Button("Save");
            Button cancelBtn = new Button("Cancel");
            okBtn.setStyleName("myButton");
            cancelBtn.setStyleName("myButton");
            okBtn.addClickListener(event -> {
                if(MotherRegistration.validateNIC(nicNoFld.getValue())){
                    if(nicNoFld.getValue() != null && !nicNoFld.getValue().isEmpty()){
                        mother.setNicNo(nicNoFld.getValue());
                    }
                    if(mohFld.getValue() != null && !mohFld.getValue().isEmpty()) mother.setMohDivision(mohFld.getValue());
                    if(pregRegNo.getValue() != null && !pregRegNo.getValue().isEmpty()) mother.setMotherDocumentRegNo(pregRegNo.getValue());
                    if(examinorNoFld.getValue() != null && !examinorNoFld.getValue().isEmpty()) mother.setExaminerRegNo(examinorNoFld.getValue());
                    if(startTime.getValue() != null && !startTime.getValue().isEmpty()) mother.setStartTime(startTime.getValue());
                    if(eddNoFld.getValue() != null && !eddNoFld.getValue().isEmpty()) mother.setEdd(eddNoFld.getValue());
                    Session session = connection.getSession();
                    connection.saveOrUpdateHBM(mother,session);
                    Notification.show("Mother details successfully updated.", Notification.Type.HUMANIZED_MESSAGE);
                    window.close();
                }

            });
            cancelBtn.addClickListener(event -> {
                window.close();
            });
            layout.setMargin(true);
            HorizontalLayout btnLayout = new HorizontalLayout();
            btnLayout.addComponents(okBtn, cancelBtn);
            layout.addComponents(btnLayout);
            layout.setComponentAlignment(btnLayout,Alignment.MIDDLE_CENTER);
            window.setContent(layout);
            window.setResizable(false);
            getUI().addWindow(window);
        }
    }

    @Override
    public void insertData() {
        if (motherSerialIdComboBox.getValue() == null) {
            Notification.show("Please select mother serial number", Notification.Type.WARNING_MESSAGE);
            return;
        }
        String motherId = motherSerialIdComboBox.getValue().toString();
        User user = (User) UI.getCurrent().getSession().getAttribute("userName");

        FirstFollowUpCommonDetails common = (FirstFollowUpCommonDetails)connection.isMotherDetailsAdded
                ("com.geepmd.entity.FirstFollowUpCommonDetails",motherId);
        int surveyId;
        if (common != null) {
            editSurveyId = common.getSurveyId();
            isEdit = true;
        }

        common = new FirstFollowUpCommonDetails();
        common.setMotherId(motherId);
        common.setAddedDate(new Date());
        common.setExaminorId(user.getUserId());
        Session session = connection.getSession();

        if (isEdit) {
            surveyId = editSurveyId;
            common.setSurveyId(surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowUpQ1",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowUpQ13",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowUpQ125",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowUpQ126",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowupQ2",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowupQ21",surveyId,session);
            connection.deleteBySurveyId("com.geepmd.entity.FirstFollowupQ3",surveyId,session);
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
            List<FirstFollowUpQ13> answer13 = tab1.getQ13AnswerList(surveyId);
            answer13.stream().forEach(obj -> connection.saveOrUpdateHBM(obj,session));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            List<FirstFollowUpQ125> answer25 = tab1.getQ125List(surveyId);
            answer25.stream().forEach(obj -> connection.saveOrUpdateHBM(obj,session));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            FirstFollowUpQ126 answer26 = tab1.getQ126Answer(surveyId);
            connection.saveOrUpdateHBM(answer26,session);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            List<FirstFollowupQ21> answer21 = tab2.getAnswers21(surveyId);
            answer21.stream().forEach(obj -> connection.saveOrUpdateHBM(obj,session));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            FirstFollowupQ2 answer2 = tab2.getAnswer2(surveyId);
            connection.saveOrUpdateHBM(answer2,session);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            FirstFollowupQ3 answer3 = tab3.getAnswers(surveyId);
            connection.saveOrUpdateHBM(answer3,session);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        connection.closeSession(session);
        saveBtn.setEnabled(true);
        saveBtn.setCaption("Save Survey");
        getUI().getNavigator().navigateTo("FirstFollowUp");
        Notification.show("Survey added successfully");
    }
}
