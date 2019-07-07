package com.geepmd.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class Dashboard extends VerticalLayout implements View {

        public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
                Object userName = UI.getCurrent().getSession().getAttribute("userName");
                if (userName == null || userName.toString().isEmpty()) {
                        getUI().getNavigator().navigateTo("Login");
                }
        }

        public Dashboard(){

        }


}
