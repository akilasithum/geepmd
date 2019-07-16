package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.MotherDetails;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MotherRegistration extends VerticalLayout implements View {

    String language = "SN";
    Map<String,String> questionMap;
    Grid<MotherDetails> motherDetailsGrid;
    DBConnection connection;
    TextField mNameFld;
    TextField mAgeFld;
    DateField dateFld;
    TextField examinorId;
    TextField mNicNo;
    TextField motherRegNo;
    TextField startTime;
    TextField familyMedicalArea;
    TextField medicalArea;
    TextField villageArea;
    TextField antenatalClinicFld;
    TextField dsDivisionFld;
    List<MotherDetails> list;
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Object userName = UI.getCurrent().getSession().getAttribute("userName");
        if (userName == null || userName.toString().isEmpty()) {
            getUI().getNavigator().navigateTo("Login");
        }
    }

    public MotherRegistration(){
        if(language.equals("EN")){

        }
        else{
            questionMap = SinhalaMap.getMotherData();
        }
        motherDetailsGrid = new Grid<>();
        connection = DBConnection.getInstance();
        createMainLayout();
    }

    private void createMainLayout(){

        Label header = new Label(questionMap.get("0"));
        header.addStyleName(ValoTheme.LABEL_H1);
        MarginInfo noMargin = new MarginInfo(false,false,false,false);;
        addComponent(header);

        DBConnection connection = DBConnection.getInstance();
        connection.isLoginSuccessful("","");

        FormLayout formLayout1 = new FormLayout();
        FormLayout formLayout2 = new FormLayout();
        formLayout1.setMargin(new MarginInfo(false,true,false,false));
        formLayout2.setMargin(new MarginInfo(false,false,false,true));
        mNameFld = new TextField(questionMap.get("1"));
        mNameFld.setRequiredIndicatorVisible(true);
        mAgeFld = new TextField(questionMap.get("2"));
        mAgeFld.setRequiredIndicatorVisible(true);
        dateFld = new DateField(questionMap.get("3"));
        Date date = new Date();
        LocalDate today = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dateFld.setValue(today);
        examinorId = new TextField(questionMap.get("4"));
        mNicNo = new TextField(questionMap.get("5"));
        motherRegNo = new TextField(questionMap.get("6"));
        startTime = new TextField(questionMap.get("7"));
        familyMedicalArea = new TextField(questionMap.get("8"));
        medicalArea = new TextField(questionMap.get("9"));
        villageArea = new TextField(questionMap.get("10"));
        antenatalClinicFld = new TextField(questionMap.get("11"));
        dsDivisionFld = new TextField(questionMap.get("12"));

        Button submitBtn = new Button("Submit");
        Button clearBtn = new Button("Clear");

        submitBtn.addClickListener(event -> {insertMotherDetails();});
        clearBtn.addClickListener(event -> {clearForm();});

        formLayout1.addComponents(mNameFld,mAgeFld,dateFld,examinorId,mNicNo,motherRegNo);
        formLayout2.addComponents(startTime,familyMedicalArea,medicalArea,villageArea,antenatalClinicFld,dsDivisionFld);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addComponents(submitBtn,clearBtn);

        HorizontalLayout formMainLayout = new HorizontalLayout();
        formMainLayout.addComponents(formLayout1,formLayout2);

        addComponent(formMainLayout);
        addComponent(buttonLayout);
        showGridData();
    }

    private void insertMotherDetails(){

        String motherName = mNameFld.getValue();
        String motherAge = mAgeFld.getValue();
        if(motherName != null && !motherName.isEmpty() && motherAge != null && !motherAge.isEmpty()){
            MotherDetails mother = new MotherDetails();
            mother.setMotherName(motherName);
            mother.setAge(Integer.parseInt(motherAge));
            if(dateFld.getValue() != null)mother.setDate(Date.from(dateFld.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            mother.setExaminerRegNo(examinorId.getValue());
            mother.setNicNo(mNicNo.getValue());
            mother.setMotherDocumentRegNo(motherRegNo.getValue());
            mother.setStartTime(startTime.getValue());
            mother.setMohDivision(familyMedicalArea.getValue());
            mother.setPhmDivision(medicalArea.getValue());
            mother.setGnDivision(villageArea.getValue());
            mother.setAntenatalClinic(antenatalClinicFld.getValue());
            mother.setDsDivision(dsDivisionFld.getValue());

            int motherId = connection.insertObjectHBM(mother);
            if(motherId != 0){
                Notification.show("Mother's serial number is " + motherName);
                mother.setMotherRegNo(motherId);
                list.add(mother);
                motherDetailsGrid.setItems(list);
                clearForm();
            }
            else{
                Notification.show("Something went wrong", Notification.Type.WARNING_MESSAGE);
            }
        }
        else {
            Notification.show("Please enter mother name and mother age", Notification.Type.WARNING_MESSAGE);
        }
    }

    private void clearForm(){
        mNameFld.clear();
        mAgeFld.clear();
        examinorId.clear();
        mNicNo.clear();
        motherRegNo.clear();
        startTime.clear();
        familyMedicalArea.clear();
        medicalArea.clear();
        villageArea.clear();
        antenatalClinicFld.clear();
        dsDivisionFld.clear();
    }

    private void showGridData(){
        motherDetailsGrid.setWidth("80%");
        motherDetailsGrid.setSizeFull();
        addComponent(motherDetailsGrid);

        motherDetailsGrid.addColumn(MotherDetails::getMotherRegNo).setCaption(questionMap.get("13"));
        motherDetailsGrid.addColumn(MotherDetails::getMotherName).setCaption(questionMap.get("1"));
        motherDetailsGrid.addColumn(MotherDetails::getAge).setCaption(questionMap.get("2"));
        motherDetailsGrid.addColumn(MotherDetails::getDate).setCaption(questionMap.get("3"));
        motherDetailsGrid.addColumn(MotherDetails::getExaminerRegNo).setCaption(questionMap.get("4"));
        motherDetailsGrid.addColumn(MotherDetails::getNicNo).setCaption(questionMap.get("5"));
        motherDetailsGrid.addColumn(MotherDetails::getMotherDocumentRegNo).setCaption(questionMap.get("6"));
        motherDetailsGrid.addColumn(MotherDetails::getStartTime).setCaption(questionMap.get("7"));
        motherDetailsGrid.addColumn(MotherDetails::getMohDivision).setCaption(questionMap.get("8"));
        motherDetailsGrid.addColumn(MotherDetails::getPhmDivision).setCaption(questionMap.get("9"));
        motherDetailsGrid.addColumn(MotherDetails::getGnDivision).setCaption(questionMap.get("10"));
        motherDetailsGrid.addColumn(MotherDetails::getAntenatalClinic).setCaption(questionMap.get("11"));
        motherDetailsGrid.addColumn(MotherDetails::getDsDivision).setCaption(questionMap.get("12"));

        list = connection.getMotherDetails();
        motherDetailsGrid.setItems(list);
    }
}
