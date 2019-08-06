package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.User;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.Arrays;

public class EditProfile extends VerticalLayout implements View {

    DBConnection connection;
    ComboBox designationCombo;
    TextField userNameFld;
    TextField fullNameFld;
    PasswordField oldPassword;
    PasswordField newPassword;
    PasswordField confirmPassword;
    User user;

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Object userName = UI.getCurrent().getSession().getAttribute("userName");
        if (userName == null || userName.toString().isEmpty()) {
            getUI().getNavigator().navigateTo("Login");
        }
    }

    public EditProfile(){
        connection = (DBConnection) UI.getCurrent().getSession().getAttribute("dbConnection");
        createMainLayout();
    }

    private void createMainLayout(){
        Label header = new Label("Edit Profile");
        header.addStyleName("surveyHeader");
        addComponent(header);

        FormLayout formLayout = new FormLayout();
        formLayout.setMargin(new MarginInfo(false,true,false,false));

        user =  (User)UI.getCurrent().getSession().getAttribute("userName");
        designationCombo = new ComboBox("Designation");
        designationCombo.setItems(Arrays.asList("Dr","Nurse"));
        designationCombo.setValue(user.getDesignation());
        userNameFld = new TextField("User Name");
        userNameFld.setValue(user.getUserName());
        fullNameFld = new TextField("Full Name");
        fullNameFld.setValue(user.getFullName());
        oldPassword = new PasswordField("Old Password");
        newPassword = new PasswordField("New Password");
        confirmPassword = new PasswordField("Confirm Password");
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        HorizontalLayout btnLayout = new HorizontalLayout();
        btnLayout.addComponents(saveButton,cancelButton);
        formLayout.addComponents(designationCombo,userNameFld,fullNameFld,oldPassword,newPassword,confirmPassword,btnLayout);
        addComponent(formLayout);
        saveButton.addClickListener(event -> {
            clickSaveBtn();
        });
    }

    private void clickSaveBtn(){

        if(!user.getUserName().equals(userNameFld.getValue())) user.setUserName(userNameFld.getValue());
        if(!user.getFullName().equals(fullNameFld.getValue())) user.setFullName(fullNameFld.getValue());
        if(!user.getDesignation().equals(designationCombo.getValue().toString())) user.setDesignation(designationCombo.getValue().toString());
        if((oldPassword.getValue() != null && !oldPassword.getValue().isEmpty()) ||
                (newPassword.getValue() != null && !newPassword.getValue().isEmpty()) ||
                (confirmPassword.getValue() != null && !confirmPassword.getValue().isEmpty())){
            if(user.getPassword().equals(oldPassword.getValue())){
                if(newPassword.getValue().equals(confirmPassword.getValue())){
                    user.setPassword(newPassword.getValue());
                }
                else{
                    Notification.show("New password did not match.", Notification.Type.WARNING_MESSAGE);
                    return;
                }
            }
            else{
                Notification.show("Old password did not match.", Notification.Type.WARNING_MESSAGE);
                return;
            }
        }
        connection.saveOrUpdateHBM(user);
        Notification.show("Profile updated.");
    }
}
