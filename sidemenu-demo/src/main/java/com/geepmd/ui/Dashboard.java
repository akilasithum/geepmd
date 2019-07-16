package com.geepmd.ui;

import com.geepmd.entity.User;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

public class Dashboard extends VerticalLayout implements View {
        Object user;
        public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
                user = UI.getCurrent().getSession().getAttribute("userName");
                if (user == null || user.toString().isEmpty()) {
                        getUI().getNavigator().navigateTo("Login");
                }
        }
        public Dashboard(){

                VerticalLayout mainLayout = new VerticalLayout();
                mainLayout.setSizeFull();
                mainLayout.setMargin(false);
                addComponent(mainLayout);

                HorizontalLayout headerLayout = new HorizontalLayout();
                headerLayout.setSizeFull();
                Image logo = new Image();
                logo.setSource(new ThemeResource("images/uni_logo.png"));
                Label label = new Label("Rajarata University of Sri Lanka");
                label.setStyleName("padHeader");
                Label faculty = new Label("Faculty of Medicine and Allied Science");
                faculty.setStyleName("padHeader");
                VerticalLayout headerTextLayout = new VerticalLayout();
                headerTextLayout.addComponents(label,faculty);

                HorizontalLayout logoLayout = new HorizontalLayout();
                logoLayout.addComponents(logo,headerTextLayout);

                Label topic = new Label("Generating Evidence for");
                topic.setStyleName("btnAlignment");
                Label topic1 = new Label("Ending Preventable Maternal Deaths");
                topic1.setStyleName("btnAlignment");
                Label topic2 = new Label("Rajarata Pregnancy Cohort");
                topic2.setStyleName("textAlignWithBold");
                VerticalLayout topicLayout = new VerticalLayout();
                topicLayout.addComponents(topic,topic1,topic2);
                topicLayout.setMargin(false);
                topicLayout.setStyleName("textAlignWithBold");
                headerLayout.addComponents(logoLayout,topicLayout);
                user = UI.getCurrent().getSession().getAttribute("userName");
                Label welcomeLabel = new Label("Welcome " + ((User)user).getFullName());


                Image pregImage = new Image();
                pregImage.setSource(new ThemeResource("images/pregnency.png"));
                pregImage.setWidth("100%");
                mainLayout.addComponent(headerLayout);
                mainLayout.addComponent(welcomeLabel);
                mainLayout.addComponent(pregImage);

        }


}
