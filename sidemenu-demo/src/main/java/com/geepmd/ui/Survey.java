package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.*;
import com.geepmd.ui.baseLineSurvey.*;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.hibernate.Session;
import org.vaadin.dialogs.ConfirmDialog;

import java.util.*;

public class Survey extends VerticalLayout implements View {

    String language;
    DBConnection connection;
    TabSheet tabsheet;
    Tab1 tab1;
    Tab2 tab2;
    Tab3 tab3;
    Tab4 tab4;
    Tab5 tab5;
    Tab6 tab6;
    Tab7 tab7;
    Tab8 tab8;
    Tab9 tab9;
    Tab10 tab10;
    Tab11 tab11;
    Tab12 tab12;
    ComboBox motherSerialIdComboBox;
    Button saveBtn;
    boolean isEdit = false;
    int editSurveyId;

    public Survey(){
        createLayout();
    }


    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Object userName = UI.getCurrent().getSession().getAttribute("userName");
        if (userName == null || userName.toString().isEmpty()) {
            getUI().getNavigator().navigateTo("Login");
        }
    }

    private void createLayout(){
        connection = (DBConnection) UI.getCurrent().getSession().getAttribute("dbConnection");
        tabsheet = new TabSheet();
        Label header = new Label("Baseline Survey");
        header.setStyleName("surveyHeader");
        addComponent(header);
        language = "SN";

        List<MotherDetails> motherDetails = connection.getMotherDetails();
        List<String> motherIdsList = new ArrayList<>();
        List<String> mothersNameList = new ArrayList<>();
        Map<String,String> idNameMap = new HashMap<>();
        Map<String,String> nameIdMap = new HashMap<>();
        for(MotherDetails mother : motherDetails){
            motherIdsList.add(mother.getMotherSerialNumber());
            mothersNameList.add(mother.getMotherName());
            idNameMap.put(mother.getMotherSerialNumber(),mother.getMotherName());
            nameIdMap.put(mother.getMotherName(),mother.getMotherSerialNumber());
        }

        ComboBox motherNameComboBox = new ComboBox("Select Mother Name");
        motherNameComboBox.setItems(mothersNameList);
        motherSerialIdComboBox = new ComboBox("Select Mother serial ID");
        motherSerialIdComboBox.setItems(motherIdsList);
        HorizontalLayout motherBtnLayout = new HorizontalLayout();
        motherBtnLayout.addComponents(motherSerialIdComboBox,motherNameComboBox);

        motherNameComboBox.addValueChangeListener(event -> {
           if(event.getValue() != null && !String.valueOf(event.getValue()).isEmpty()){
               motherSerialIdComboBox.setValue(nameIdMap.get(event.getValue()));
               tabsheet.setEnabled(true);
               updateDetailsIfAdded(nameIdMap.get(event.getValue()));
           }
        });

        motherSerialIdComboBox.addValueChangeListener(event -> {
            if(event.getValue() != null){
                motherNameComboBox.setValue(idNameMap.get(event.getValue()));
                tabsheet.setEnabled(true);
                updateDetailsIfAdded(String.valueOf(event.getValue()));
            }
        });

        HorizontalLayout btnLayout = new HorizontalLayout();
        saveBtn = new Button("Save Survey");
        saveBtn.setSizeFull();
        saveBtn.addClickListener(event -> {

            ConfirmDialog.show(getUI(), "Save Survey", "Are you sure you want to save this survey?",
                    "Yes", "No", (ConfirmDialog.Listener) dialog -> {
                        if (dialog.isConfirmed()) {
                            insertData();
                        }
                    });

        });
        saveBtn.setStyleName("myButton");
        Button startAgain = new Button("Start Again");
        startAgain.setSizeFull();
        startAgain.setStyleName("myButton");
        startAgain.addClickListener(event -> getUI().getNavigator().navigateTo("BaselineSurvey"));
        btnLayout.addComponents(saveBtn,startAgain);
        btnLayout.setStyleName("btnAlignment");

        HorizontalLayout mainHeaderLayout = new HorizontalLayout();
        mainHeaderLayout.setSizeFull();
        mainHeaderLayout.addComponents(motherBtnLayout,btnLayout);
        addComponent(mainHeaderLayout);


        addComponent(tabsheet);
        tabsheet.setSizeFull();
        tabsheet.setStyleName("tabStyle");

        tabsheet.setEnabled(false);

        tab1 = new Tab1(language,this);
        tab1.setStyleName("subTabSmallStyle");
        tab2 = new Tab2(language,this);
        tab2.setStyleName("subTabStyle");
        tab3 = new Tab3(language,this);
        tab4 = new Tab4(language,this);
        tab4.setStyleName("subTabSmallStyle");
        tab5 = new Tab5(language,this);
        tab6 = new Tab6(language,this);
        tab7 = new Tab7(language,this);
        tab8 = new Tab8(language,this);
        tab8.setStyleName("subTabSmallStyle");
        tab9 = new Tab9(language,this);
        tab9.setStyleName("subTabSmallStyle");
        tab10 = new Tab10(language,this);
        tab11 = new Tab11(language,this);
        tab12 = new Tab12(language,this);
        tab12.setStyleName("subTabSmallStyle");

        Map<String,String> headerMap;
        if(language.equals("EN")){
            headerMap = EnglishMap.getTabHeaderMap();
        }
        else {
            headerMap = SinhalaMap.getTabHeaderMap();
        }

        tabsheet.addTab(tab1,headerMap.get("1"));
        tabsheet.addTab(tab2,headerMap.get("2"));
        tabsheet.addTab(tab3,headerMap.get("3"));
        tabsheet.addTab(tab4,headerMap.get("4"));
        tabsheet.addTab(tab5,headerMap.get("5"));
        tabsheet.addTab(tab6,headerMap.get("6"));
        tabsheet.addTab(tab7,headerMap.get("7"));
        tabsheet.addTab(tab7,headerMap.get("7"));
        tabsheet.addTab(tab8,headerMap.get("8"));
        tabsheet.addTab(tab9,headerMap.get("9"));
        tabsheet.addTab(tab10,headerMap.get("10"));
        tabsheet.addTab(tab11,headerMap.get("11"));
        tabsheet.addTab(tab12,headerMap.get("12"));
    }

    public void updateDetailsIfAdded(String motherId){
        CommonDetails common = connection.isMotherDetailsAdded(motherId);
        if(common != null){
            isEdit = true;
            int surveyId = common.getSurveyId();
            editSurveyId = surveyId;
            BaselineQ1 q1List = (BaselineQ1)connection.getPageValue("com.geepmd.entity.BaselineQ1",surveyId);
            BaselineQ2 q2List = (BaselineQ2)connection.getPageValue("com.geepmd.entity.BaselineQ2",surveyId);
            BaselineQ3 q3List = (BaselineQ3)connection.getPageValue("com.geepmd.entity.BaselineQ3",surveyId);
            BaselineQ4 q4List = (BaselineQ4)connection.getPageValue("com.geepmd.entity.BaselineQ4",surveyId);
            BaselineQ5 q5List = (BaselineQ5)connection.getPageValue("com.geepmd.entity.BaselineQ5",surveyId);
            BaselineQ6 q6List = (BaselineQ6)connection.getPageValue("com.geepmd.entity.BaselineQ6",surveyId);
            BaselineQ7 q7List = (BaselineQ7)connection.getPageValue("com.geepmd.entity.BaselineQ7",surveyId);
            BaselineQ8 q8List = (BaselineQ8)connection.getPageValue("com.geepmd.entity.BaselineQ8",surveyId);
            BaselineQ9 q9List = (BaselineQ9)connection.getPageValue("com.geepmd.entity.BaselineQ9",surveyId);
            List<BaselineQ10> q10List = (List<BaselineQ10>)connection.getAllValues("com.geepmd.entity.BaselineQ10",surveyId);
            BaselineQ11 q11List = (BaselineQ11)connection.getPageValue("com.geepmd.entity.BaselineQ11",surveyId);
            BaselineQ12 q12List = (BaselineQ12)connection.getPageValue("com.geepmd.entity.BaselineQ12",surveyId);
            BaselineQ26 q26List = (BaselineQ26) connection.getPageValue("com.geepmd.entity.BaselineQ26",surveyId);
            List<BaselineQ28> q28List = (List<BaselineQ28>) connection.getAllValues("com.geepmd.entity.BaselineQ28",surveyId);
            List<BaselineQ32> q32List = (List<BaselineQ32>) connection.getAllValues("com.geepmd.entity.BaselineQ32",surveyId);
            List<BaselineQ51> q51List = (List<BaselineQ51>) connection.getAllValues("com.geepmd.entity.BaselineQ51",surveyId);
            List<BaselineQ62> q62List = (List<BaselineQ62>) connection.getAllValues("com.geepmd.entity.BaselineQ62",surveyId);
            List<BaselineQ84> q84List = (List<BaselineQ84>) connection.getAllValues("com.geepmd.entity.BaselineQ84",surveyId);
            if(q1List != null) tab1.setEditData(q1List);
            if(q2List != null) tab2.setEditData(q2List,q26List,q28List);
            if(q3List != null) tab3.setEditData(q3List,q32List);
            if(q4List != null) tab4.setEditData(q4List);
            if(q5List != null) tab5.setEditData(q5List,q51List);
            if(q6List != null) tab6.setEditData(q6List,q62List);
            if(q7List != null) tab7.setEditData(q7List);
            if(q8List != null) tab8.setEditData(q8List,q84List);
            if(q9List != null) tab9.setEditData(q9List);
            if(q10List != null) tab10.setEditData(q10List);
            if(q11List != null) tab11.setEditData(q11List);
            if(q12List != null) tab12.setEditData(q12List);
          }
          else {
            editSurveyId = 0;
            isEdit = false;
        }
    }

    public void SelectTab(int index){
        tabsheet.setSelectedTab(index);
    }

    public void insertData(){
        String motherId = motherSerialIdComboBox.getValue().toString();
        User user = (User)UI.getCurrent().getSession().getAttribute("userName");
        CommonDetails common = new CommonDetails();
        common.setMotherId(motherId);
        common.setSurveyType("Baseline");
        common.setAddedDate(new Date());
        common.setExaminorId(user.getUserId());
        int surveyId;
        if(isEdit){
            surveyId = editSurveyId;
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ26",surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ28",surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ32",surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ51",surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ62",surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ84",surveyId);
            connection.deleteBySurveyId("com.geepmd.entity.BaselineQ10",surveyId);
        }
        else {
            surveyId = connection.saveObjectHBM(common);
        }

        connection.saveOrUpdateHBM(tab1.getAnswers(surveyId));
        connection.saveOrUpdateHBM(tab2.getAnswers(surveyId));
        connection.saveOrUpdateHBM(tab2.get26Answer(surveyId));
        List<BaselineQ28> answer28 = tab2.get28Answers(surveyId);
        answer28.stream().forEach(obj -> connection.saveOrUpdateHBM(obj));
        connection.saveOrUpdateHBM(tab3.getAnswer(surveyId));
        List<BaselineQ32> answer32 = tab3.getQ32Answers(surveyId);
        answer32.stream().forEach(obj -> connection.saveOrUpdateHBM(obj));
        connection.saveOrUpdateHBM(tab4.getAnswers(surveyId));
        connection.saveOrUpdateHBM(tab5.getAnswer(surveyId));
        List<BaselineQ51> answer51 = tab5.getAnswer51(surveyId);
        answer51.stream().forEach(obj -> connection.saveOrUpdateHBM(obj));
        connection.saveOrUpdateHBM(tab6.getAnswers(surveyId));
        List<BaselineQ62> answer62 = tab6.getAnswer62(surveyId);
        answer62.stream().forEach(obj -> connection.saveOrUpdateHBM(obj));
        connection.saveOrUpdateHBM(tab7.getAnswers(surveyId));
        connection.saveOrUpdateHBM(tab8.getQ8Answers(surveyId));
        List<BaselineQ84> answer84 = tab8.get84Answers(surveyId);
        answer84.stream().forEach(obj -> connection.saveOrUpdateHBM(obj));
        connection.saveOrUpdateHBM(tab9.getQ9Answers(surveyId));
        List<BaselineQ10> answer10 = tab10.getAnswerQ10(surveyId);
        answer10.stream().forEach(obj -> connection.saveOrUpdateHBM(obj));
        connection.saveOrUpdateHBM(tab11.getAnswerQ11(surveyId));
        connection.saveOrUpdateHBM(tab12.getAnswerQ12(surveyId));
        saveBtn.setEnabled(true);
        saveBtn.setCaption("Save Survey");
        getUI().getNavigator().navigateTo("BaselineSurvey");
        Notification.show("Survey added successfully");
    }
}