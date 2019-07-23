package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.*;
import com.geepmd.ui.baseLineSurvey.*;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
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
    ComboBox motherSerialIdComboBox;
    Button saveBtn;

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
        connection = DBConnection.getInstance();
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
           }
        });

        motherSerialIdComboBox.addValueChangeListener(event -> {
            if(event.getValue() != null){
                motherNameComboBox.setValue(idNameMap.get(event.getValue()));
                tabsheet.setEnabled(true);
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

        tabsheet.setEnabled(false);

        tab1 = new Tab1(language,this);
        tab2 = new Tab2(language,this);
        tab3 = new Tab3(language,this);
        tab4 = new Tab4(language,this);
        tab5 = new Tab5(language,this);
        tab6 = new Tab6(language,this);
        tab7 = new Tab7(language,this);
        tab8 = new Tab8(language,this);
        tab9 = new Tab9(language,this);
       // tab10 = new Tab11(language,this);

        tab10 = new Tab10(language);

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

    }

    public void SelectTab(int index){
        tabsheet.setSelectedTab(index);
    }

    public void insertData(){

        //saveBtn.setEnabled(false);


        //saveBtn.setCaption("Survey data saving");
        String motherId = motherSerialIdComboBox.getValue().toString();
        User user = (User)UI.getCurrent().getSession().getAttribute("userName");
        CommonDetails common = new CommonDetails();
        common.setMotherId(motherId);
        common.setSurveyType("Baseline");
        common.setAddedDate(new Date());
        common.setExaminorId(user.getUserId());
        int surveyId = connection.insertObjectHBM(common);
        connection.insertObjectHBM(tab1.getAnswers(surveyId));
        connection.insertObjectHBM(tab2.getAnswers(surveyId));
        connection.insertObjectHBM(tab2.get26Answer(surveyId));
        List<BaselineQ28> answer28 = tab2.get28Answers(surveyId);
        answer28.stream().forEach(obj -> connection.insertObjectHBM(obj));
        connection.insertObjectHBM(tab3.getAnswer(surveyId));
        List<BaselineQ32> answer32 = tab3.getQ32Answers(surveyId);
        answer32.stream().forEach(obj -> connection.insertObjectHBM(obj));
        connection.insertObjectHBM(tab4.getAnswers(surveyId));
        connection.insertObjectHBM(tab5.getAnswer(surveyId));
        List<BaselineQ51> answer51 = tab5.getAnswer51(surveyId);
        answer51.stream().forEach(obj -> connection.insertObjectHBM(obj));
        connection.insertObjectHBM(tab6.getAnswers(surveyId));
        List<BaselineQ62> answer62 = tab6.getAnswer62(surveyId);
        answer62.stream().forEach(obj -> connection.insertObjectHBM(obj));
        connection.insertObjectHBM(tab7.getAnswers(surveyId));
        connection.insertObjectHBM(tab8.getQ8Answers(surveyId));
        List<BaselineQ84> answer84 = tab8.get84Answers(surveyId);
        answer84.stream().forEach(obj -> connection.insertObjectHBM(obj));
        connection.insertObjectHBM(tab9.getQ9Answers(surveyId));
        List<BaselineQ10> answer10 = tab10.getAnswerQ10(surveyId);
        answer10.stream().forEach(obj -> connection.insertObjectHBM(obj));
        saveBtn.setEnabled(true);
        saveBtn.setCaption("Save Survey");
        getUI().getNavigator().navigateTo("BaselineSurvey");
        Notification.show("Survey added successfully");
    }
}