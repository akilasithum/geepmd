package com.geepmd.ui;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.teemusa.sidemenu.demo.DemoUI;

public class LoginPage extends VerticalLayout implements View {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "";
    //DBConnection connection;
    private VerticalLayout logoLayout = new VerticalLayout();
    public static final MarginInfo noMargin = new MarginInfo(false,false,false,false);
    public static final MarginInfo leftMargin = new MarginInfo(false,false,false,true);

    public LoginPage(){

        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.setSizeUndefined();
        mainLayout.setMargin(true);
        setSpacing(true);
        VerticalLayout panel = new VerticalLayout();
        panel.setSizeUndefined();
        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(leftMargin);
        addComponent(layout);
        addComponent(mainLayout);
        layout.addComponent(logoLayout);
        logoLayout.setMargin(noMargin);
        setMargin(noMargin);

        Image logo = new Image();
        logo.setSource(new ThemeResource("images/logo.png"));
        //logoLayout.addComponent(logo);


        mainLayout.setSpacing(true);
        panel.setSizeUndefined();
        mainLayout.addComponent(panel);
        //connection = DBConnection.getInstance();

        FormLayout content = new FormLayout();
        content.addComponent(logo);
        TextField username = new TextField("Username");
        content.addComponent(username);
        PasswordField password = new PasswordField("Password");
        content.addComponent(password);
        Button send = new Button("Sign In");
        Button signUpBtn = new Button("Sign Up");
        send.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        send.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                   // if(connection.isLoginSuccessful(username.getValue(), password.getValue())){
                        VaadinSession.getCurrent().setAttribute("user", username.getValue());
                        getSession().setAttribute("userName",username.getValue());
                        ((DemoUI)getUI()).navigateToDashboard();
                   // }else{
                  //      Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
                  //  }

            }

        });
        HorizontalLayout btnLayout = new HorizontalLayout();
        btnLayout.addComponents(send,signUpBtn);
        content.addComponent(btnLayout);
        content.setSizeUndefined();
        content.setMargin(true);
        panel.addComponent(content);
        //mainLayout.setComponentAlignment(logo,Alignment.MIDDLE_CENTER);
        mainLayout.setComponentAlignment(panel,Alignment.MIDDLE_CENTER);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private void clickSignUpBtn(){

    }

}
