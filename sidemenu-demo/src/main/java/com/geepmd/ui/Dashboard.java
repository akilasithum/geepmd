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
                logo.setStyleName("unilogo");
                label.setStyleName("padHeader");
                Label faculty = new Label("Faculty of Medicine and Allied Science");
                faculty.setStyleName("padHeader");
                VerticalLayout headerTextLayout = new VerticalLayout();
                headerTextLayout.addComponents(label,faculty);
                headerTextLayout.setMargin(false);
                headerTextLayout.setSpacing(false);

                HorizontalLayout logoLayout = new HorizontalLayout();
                logoLayout.addComponents(logo,headerTextLayout);

                Label topic = new Label("Generating Evidence for");
                topic.setStyleName("textAlignWithBold");
                Label topic1 = new Label("Ending Preventable Maternal Deaths");
                topic1.setStyleName("textAlignWithBold");
                Label topic2 = new Label("Rajarata Pregnancy Cohort");
                topic2.setStyleName("textAlignWithBold");
                VerticalLayout topicLayout = new VerticalLayout();
                topicLayout.addComponents(topic,topic1,topic2);
                topicLayout.setStyleName("hideWhenSmall");
                topicLayout.setMargin(false);
                headerLayout.addComponents(logoLayout,topicLayout);
                user = UI.getCurrent().getSession().getAttribute("userName");
                Label welcomeLabel = new Label("Welcome " + ((User)user).getFullName());
                Image pregImage = new Image();
                pregImage.setSource(new ThemeResource("images/pregnency.png"));
                pregImage.setWidth("100%");
                VerticalLayout smallSizeLayout = new VerticalLayout();
                Label smallLabel1 = new Label("Generating Evidence for Ending Preventable Maternal Deaths");
                Label smallLabel2 = new Label("Rajarata Pregnancy Cohort");
                smallLabel1.setStyleName("padHeader");
                smallLabel2.setStyleName("padHeader");
                smallSizeLayout.addComponents(smallLabel1,smallLabel2);
                smallSizeLayout.setStyleName("mobileSmallHeader");
                mainLayout.addComponent(headerLayout);
                mainLayout.addComponent(welcomeLabel);
                mainLayout.addComponent(pregImage);
                mainLayout.addComponent(smallSizeLayout);

        }


}
