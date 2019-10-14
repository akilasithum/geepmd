package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.MotherDetails;
import com.geepmd.utils.SinhalaMap;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ComponentRenderer;
import org.hibernate.Session;

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
    TextField mSerialNo;
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
    TextField idField;
    //TextField dsDivisionFld;
    List<MotherDetails> list;
    ComboBox hourCombo;
    ComboBox minuteCombo;
    ComboBox ampmCombo;
    MotherDetails editMother;
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
        header.addStyleName("surveyHeader");
        MarginInfo rightMargin = new MarginInfo(false,true,false,false);;
        addComponent(header);
        FormLayout formLayout1 = new FormLayout();
        FormLayout formLayout2 = new FormLayout();
        formLayout1.setMargin(new MarginInfo(false,true,false,false));
        formLayout2.setMargin(new MarginInfo(false,false,false,true));
        idField = new TextField();
        idField.setVisible(false);
        mNameFld = new TextField(questionMap.get("1"));
        mNameFld.setRequiredIndicatorVisible(true);
        mSerialNo = new TextField(questionMap.get("13"));
        mSerialNo.setRequiredIndicatorVisible(true);
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
        //dsDivisionFld = new TextField(questionMap.get("12"));

        Button submitBtn = new Button("Submit");
        Button clearBtn = new Button("Clear");

        submitBtn.addClickListener(event -> {insertMotherDetails();});
        clearBtn.addClickListener(event -> {clearForm();});

        formLayout1.addComponents(idField,mSerialNo,mNameFld,mAgeFld,dateFld,examinorId,mNicNo);
        formLayout2.addComponents(motherRegNo,startTime,familyMedicalArea,medicalArea,villageArea,antenatalClinicFld);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addComponents(submitBtn,clearBtn);

        HorizontalLayout formMainLayout = new HorizontalLayout();
        formMainLayout.addComponents(formLayout1,formLayout2);
        formMainLayout.setMargin(rightMargin);

        addComponent(formMainLayout);
        addComponent(buttonLayout);
        showGridData();
    }

    private void fillEditDetails(MotherDetails mother){
        editMother = mother;
        idField.setValue(String.valueOf(mother.getMotherRegNo()));
        if(mother.getMotherSerialNumber() != null )mSerialNo.setValue(mother.getMotherSerialNumber());
        if(mother.getMotherName() != null )mNameFld.setValue(mother.getMotherName());
        if(mother.getAge() != 0 )mAgeFld.setValue(String.valueOf(mother.getAge()));
        if(mother.getDate() != null){
            LocalDate date = mother.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dateFld.setValue(date);
        }
        if(mother.getExaminerRegNo() != null )examinorId.setValue(mother.getExaminerRegNo());
        if(mother.getNicNo() != null )mNicNo.setValue(mother.getNicNo());
        if(mother.getMotherRegNo() != 0 )motherRegNo.setValue(String.valueOf(mother.getMotherDocumentRegNo()));
        if(mother.getStartTime() != null )startTime.setValue(mother.getStartTime());
        if(mother.getMohDivision() != null )familyMedicalArea.setValue(mother.getMohDivision());
        if(mother.getPhmDivision() != null )medicalArea.setValue(mother.getPhmDivision());
        if(mother.getGnDivision() != null )villageArea.setValue(mother.getGnDivision());
        if(mother.getAntenatalClinic() != null )antenatalClinicFld.setValue(mother.getAntenatalClinic());
    }

    private void insertMotherDetails(){

        String motherName = mNameFld.getValue();
        String motherAge = mAgeFld.getValue();
        String nic = mNicNo.getValue();
        String serialNo = mSerialNo.getValue();
        boolean ageValidated = validateAge(motherAge);
        boolean nicValidated = validateNIC(nic);
        if(ageValidated && nicValidated) {
            if (motherName != null && !motherName.isEmpty() && serialNo != null && !serialNo.isEmpty()) {
                if((idField.getValue() == null && idField.getValue().isEmpty()) && connection.isMotherIdAvailable(serialNo)){
                    Notification.show("Mother serial number already exists.", Notification.Type.WARNING_MESSAGE);
                    return;
                }
                MotherDetails mother = new MotherDetails();
                mother.setMotherSerialNumber(mSerialNo.getValue());
                mother.setMotherName(motherName);
                mother.setAge(Integer.parseInt(motherAge));
                if (dateFld.getValue() != null)
                    mother.setDate(Date.from(dateFld.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                mother.setExaminerRegNo(examinorId.getValue());
                mother.setNicNo(mNicNo.getValue());
                mother.setMotherDocumentRegNo(motherRegNo.getValue());
                mother.setStartTime(startTime.getValue());
                mother.setMohDivision(familyMedicalArea.getValue());
                mother.setPhmDivision(medicalArea.getValue());
                mother.setGnDivision(villageArea.getValue());
                mother.setAntenatalClinic(antenatalClinicFld.getValue());
                Session session = connection.getSession();
                int motherId = 0;
                if(idField.getValue() != null && !idField.getValue().isEmpty()){
                    mother.setMotherRegNo(Integer.parseInt(idField.getValue()));
                    connection.saveOrUpdateHBM(mother,session);
                    int index = list.indexOf(editMother);
                    list.remove(editMother);
                    if(index == list.size()){
                        list.add(mother);
                    }
                    else {
                        list.add(index,mother);
                    }
                    motherDetailsGrid.setItems(list);
                    clearForm();
                    Notification.show("Mother details updated successfully");
                }
                else{
                    motherId = connection.saveObjectHBM(mother,session);
                    if (motherId != 0) {
                        Notification.show("Mother's serial number is " + motherName);
                        mother.setMotherRegNo(motherId);
                        list.add(mother);
                        motherDetailsGrid.setItems(list);
                        clearForm();
                    } else {
                        Notification.show("Something went wrong", Notification.Type.WARNING_MESSAGE);
                    }
                }
                connection.closeSession(session);

            } else {
                Notification.show("Please fill all required fields", Notification.Type.WARNING_MESSAGE);
            }
        }
    }

    private boolean validateAge(String age){
        try {
           int ageInt = Integer.parseInt(age);
           if(ageInt >= 12 && ageInt <= 50){
               return true;
           }
           else {
               Notification.show("Age should be in between 12 and 50", Notification.Type.WARNING_MESSAGE);
               return false;
           }
        }
        catch (Exception e){
            Notification.show("Age should be in between 12 and 50", Notification.Type.WARNING_MESSAGE);
            return false;
        }
    }

    public static boolean validateNIC(String nic){
        if(nic != null && (nic.length() == 10 || nic.length() == 12)){

            return true;
        }
        else{
            Notification.show("NIC text length should be 10 letters.", Notification.Type.WARNING_MESSAGE);
            return false;
        }

    }


    private void clearForm(){
        idField.clear();
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
        editMother = null;
    }

    private Button addEditBtn(MotherDetails mother){
        Button btn = new Button();
        btn.setSizeFull();
        btn.setIcon(VaadinIcons.EDIT);
        btn.addClickListener(event -> {fillEditDetails(mother);});
        return btn;
    }

    private void showGridData(){
        motherDetailsGrid.setWidth("80%");
        motherDetailsGrid.setSizeFull();
        addComponent(motherDetailsGrid);

        motherDetailsGrid.addColumn(
        person -> addEditBtn(person),
                new ComponentRenderer()
        );
        motherDetailsGrid.addColumn(MotherDetails::getMotherSerialNumber).setCaption(questionMap.get("13"));
        motherDetailsGrid.addColumn(MotherDetails::getMotherName).setCaption(questionMap.get("1"));
        motherDetailsGrid.addColumn(MotherDetails::getAge).setCaption(questionMap.get("2"));
        motherDetailsGrid.addColumn(bean-> SurveyUtils.getDateStringFromDate(bean.getDate())).setCaption(questionMap.get("3"));
        motherDetailsGrid.addColumn(MotherDetails::getExaminerRegNo).setCaption(questionMap.get("4"));
        motherDetailsGrid.addColumn(MotherDetails::getNicNo).setCaption(questionMap.get("5"));
        motherDetailsGrid.addColumn(MotherDetails::getMotherDocumentRegNo).setCaption(questionMap.get("6"));
        motherDetailsGrid.addColumn(MotherDetails::getStartTime).setCaption(questionMap.get("7"));
        motherDetailsGrid.addColumn(MotherDetails::getMohDivision).setCaption(questionMap.get("8"));
        motherDetailsGrid.addColumn(MotherDetails::getPhmDivision).setCaption(questionMap.get("9"));
        motherDetailsGrid.addColumn(MotherDetails::getGnDivision).setCaption(questionMap.get("10"));
        motherDetailsGrid.addColumn(MotherDetails::getAntenatalClinic).setCaption(questionMap.get("11"));
        motherDetailsGrid.addColumn(MotherDetails::getEdd).setCaption(questionMap.get("14"));
        list = connection.getMotherDetails();
        motherDetailsGrid.setItems(list);
    }
}
