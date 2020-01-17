package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.MotherDetails;
import com.geepmd.entity.SpecialFollowUp;
import com.geepmd.ui.baseLineSurvey.Tab1;
import com.geepmd.ui.baseLineSurvey.Tab2;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.dialogs.ConfirmDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonSurvey extends VerticalLayout implements View {

    String language;
    DBConnection connection;
    TabSheet tabsheet;
    Tab1 tab1;
    Tab2 tab2;
    ComboBox motherSerialIdComboBox;
    Button saveBtn;
    boolean isEdit = false;
    int editSurveyId;
    HorizontalLayout errorLayout;
    Window window = new Window("Special Follow Up");
    Label header;


    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Object userName = UI.getCurrent().getSession().getAttribute("userName");
        if (userName == null || userName.toString().isEmpty()) {
            getUI().getNavigator().navigateTo("Login");
        }
    }

    protected void createLayout() {
        connection = DBConnection.getInstance();
        tabsheet = new TabSheet();
        header = new Label();
        header.setStyleName("surveyHeader");
        addComponent(header);
        language = "SN";

        List<MotherDetails> motherDetails = connection.getMotherDetails();
        List<String> motherIdsList = new ArrayList<>();
        //List<String> mothersNameList = new ArrayList<>();
        Map<String,String> idNameMap = new HashMap<>();
        Map<String,String> nameIdMap = new HashMap<>();
        for(MotherDetails mother : motherDetails){
            motherIdsList.add(mother.getMotherSerialNumber());
            //mothersNameList.add(mother.getMotherName());
            idNameMap.put(mother.getMotherSerialNumber(),mother.getMotherName());
            nameIdMap.put(mother.getMotherName(),mother.getMotherSerialNumber());
        }

        TextField motherNameComboBox = new TextField("Mother Name");
        //motherNameComboBox.setItems(mothersNameList);
        motherNameComboBox.setEnabled(false);
        motherSerialIdComboBox = new ComboBox("Select Mother serial ID");
        motherSerialIdComboBox.setItems(motherIdsList);
        HorizontalLayout motherBtnLayout = new HorizontalLayout();
        motherBtnLayout.addComponents(motherSerialIdComboBox,motherNameComboBox);

        /*motherNameComboBox.addValueChangeListener(event -> {
            if(event.getValue() != null && !String.valueOf(event.getValue()).isEmpty()){
                motherSerialIdComboBox.setValue(nameIdMap.get(event.getValue()));
                tabsheet.setEnabled(true);
                updateDetailsIfAdded(nameIdMap.get(event.getValue()));
            }
        });*/

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

        errorLayout = new HorizontalLayout();
        errorLayout.setSizeFull();
        errorLayout.setWidth("470px");
        errorLayout.setStyleName("warning");
        Label specialCareLabel = new Label("This mother needs special Follow Up. Click to see the reason.");
        errorLayout.addComponent(specialCareLabel);
        errorLayout.setVisible(false);

        mainHeaderLayout.addComponents(motherBtnLayout,btnLayout);
        addComponent(mainHeaderLayout);
        addComponent(errorLayout);
        setComponentAlignment(errorLayout,Alignment.MIDDLE_CENTER);

        addComponent(tabsheet);
        tabsheet.setSizeFull();

        tabsheet.setEnabled(false);

    }

    public void showSpecialFollowUpDetails(SpecialFollowUp specialFollowUp){
        errorLayout.setVisible(true);
        errorLayout.addLayoutClickListener(event -> {
            if(!window.isAttached()){
                window.setWidth("600px");
                window.center();
                window.setModal(true);
                VerticalLayout layout = new VerticalLayout();
                Label followUpMsg = new Label();
                followUpMsg.setSizeFull();
                followUpMsg.setValue(specialFollowUp.getFollowUpMessage());
                Button okBtn = new Button("Ok");
                okBtn.setStyleName("myButton");
                okBtn.addClickListener(event1 -> {
                    window.close();
                });
                layout.addComponents(followUpMsg,okBtn);
                layout.setComponentAlignment(okBtn,Alignment.MIDDLE_CENTER);
                window.setContent(layout);
                window.setResizable(false);
                getUI().addWindow(window);
            }

        });
    }

    public void SelectTab(int index){
        tabsheet.setSelectedTab(index);
    }

    public abstract void updateDetailsIfAdded(String motherId);

    public abstract void insertData();

}
