package com.geepmd.ui;

import com.geepmd.dbConnection.DBConnection;
import com.geepmd.entity.User;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.teemusa.sidemenu.demo.DemoUI;

import java.util.Arrays;

public class LoginPage extends VerticalLayout implements View {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "";
    DBConnection connection;
    private VerticalLayout logoLayout = new VerticalLayout();
    public static final MarginInfo noMargin = new MarginInfo(false,false,false,false);
    public static final MarginInfo leftMargin = new MarginInfo(false,false,false,true);

    public LoginPage(){
        connection = new DBConnection();
        VerticalLayout mainLayout = new VerticalLayout();
        setStyleName("bgimg");
        setSizeFull();
        mainLayout.setSizeUndefined();
        mainLayout.setStyleName("centerdiv");
        setSpacing(true);
        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(leftMargin);
        addComponent(layout);
        addComponent(mainLayout);
        layout.addComponent(logoLayout);
        logoLayout.setMargin(noMargin);
        setMargin(noMargin);

        Image logo = new Image();
        logo.setSource(new ThemeResource("images/logo.jpg"));

        VerticalLayout content = new VerticalLayout();
        logo.setStyleName("profilepic");
        mainLayout.addComponent(logo);
        TextField username = new TextField();
        username.setSizeFull();
        username.setPlaceholder("User Name");
        content.addComponent(username);
        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");
        password.setSizeFull();
        content.addComponent(password);
        Button send = new Button("Sign In");
        send.setSizeFull();
        send.setStyleName("myButton");
        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setSizeFull();
        signUpBtn.setStyleName("myButton");
        send.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        send.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if(username.getValue() != null && !username.getValue().isEmpty()
                        && password.getValue() != null && !password.getValue().isEmpty()) {
                     if(connection.isLoginSuccessful(username.getValue(), password.getValue())){
                         User user = connection.getUser(username.getValue());
                         UI.getCurrent().getSession().setAttribute("userName", user);
                         UI.getCurrent().getSession().setAttribute("dbConnection",connection);
                    ((DemoUI) getUI()).navigateToDashboard();
                     }else{
                          Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
                      }
                }
                else {
                    Notification.show("Enter user name and password", Notification.Type.ERROR_MESSAGE);
                }

            }

        });

        signUpBtn.addClickListener(clickEvent -> {showSignUpContent();});
        HorizontalLayout forgotBtnLayout = new HorizontalLayout();
        forgotBtnLayout.setSizeFull();

        Button link = new Button("Reset Password");
        link.setStyleName("myButton");
        forgotBtnLayout.addComponents(link,signUpBtn);
        link.addClickListener(event -> {
            Notification.show("Please contact administrator");
        });
        content.addComponents(send,forgotBtnLayout);
        content.setSizeFull();
        content.setWidth("80%");
        content.setMargin(false);
        mainLayout.addComponent(content);
        content.setStyleName("");
        mainLayout.setMargin(false);
        mainLayout.setComponentAlignment(content,Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private void showSignUpContent(){

        Window signUpContentWindow=new Window("User creation");
        signUpContentWindow.setWidth("400px");
        signUpContentWindow.center();
        FormLayout formLayout = new FormLayout();
        formLayout.setSizeFull();
        TextField userName = new TextField("User Name");
        ComboBox designation = new ComboBox("Designation");
        designation.setItems(Arrays.asList("Dr","Nurse"));
        TextField fullName = new TextField("Full Name");
        PasswordField password = new PasswordField("Password");
        PasswordField reEnterPassword = new PasswordField("Re-enter Password");
        HorizontalLayout btnLayout = new HorizontalLayout();
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        btnLayout.addComponents(submitButton,cancelButton);
        formLayout.addComponents(userName,designation,fullName,password,reEnterPassword,btnLayout);
        signUpContentWindow.setContent(formLayout);
        formLayout.setMargin(true);
        signUpContentWindow.setHeight("500px");
        cancelButton.addClickListener((Button.ClickListener) clickEvent->signUpContentWindow.close());
        submitButton.addClickListener(event -> {
            String userNameVal = userName.getValue();
            String designationVal = String.valueOf(designation.getValue());
            String fullNameVal = fullName.getValue();
            String passwordVal = password.getValue();
            String reEnterPasswordVal = reEnterPassword.getValue();
            if(userNameVal != null && !userNameVal.isEmpty() && designationVal != null && !designationVal.isEmpty() &&
            fullNameVal != null && !fullNameVal.isEmpty() && passwordVal != null && !passwordVal.isEmpty() &&
            reEnterPasswordVal != null && !reEnterPasswordVal.isEmpty()){
                if(connection.isUserNameExists(userNameVal)){
                    Notification.show("Username already exists. Please choose another username", Notification.Type.WARNING_MESSAGE);
                    userName.focus();
                    return;
                }
                if(passwordVal.equals(reEnterPasswordVal)){
                    User user = new User();
                    user.setUserName(userNameVal);
                    user.setDesignation(designationVal);
                    user.setFullName(fullNameVal);
                    user.setPassword(passwordVal);
                    int id = connection.insertUser(user);
                    if(id != 0){
                        signUpContentWindow.close();
                        Notification.show("User creation successfully. You can logged in now");
                    }
                    else{
                        Notification.show("something went wrong", Notification.Type.WARNING_MESSAGE);
                    }
                }
                else{
                    Notification.show("Passwords did not matched. Enter same password", Notification.Type.WARNING_MESSAGE);
                }
            }
            else{
                Notification.show("Fill all the fields", Notification.Type.WARNING_MESSAGE);
            }
        });
        getUI().addWindow(signUpContentWindow);
    }

}
