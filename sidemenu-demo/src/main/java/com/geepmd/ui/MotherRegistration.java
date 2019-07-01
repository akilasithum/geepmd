package com.geepmd.ui;

import com.vaadin.navigator.View;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class MotherRegistration extends VerticalLayout implements View {

    public MotherRegistration(){
        createMainLayout();
    }

    private void createMainLayout(){

        Label header = new Label("Mother Registration");
        header.addStyleName(ValoTheme.LABEL_H1);
        MarginInfo noMargin = new MarginInfo(false,false,false,false);;
        addComponent(header);

        FormLayout formLayout = new FormLayout();
        formLayout.setMargin(noMargin);
        TextField mNameFld = new TextField("Mother Name");
        TextField mAgeFld = new TextField("Age");
        DateField date = new DateField("Date");
        TextField mNicNo = new TextField("NIC No");
        TextField mohAreaFld = new TextField("MOH area");
        TextField phmAreaFld = new TextField("PHM area");
        TextField gnDivisionFld = new TextField("GN division");
        TextField antenatalClinicFld = new TextField("Antenatal clinic");
        TextField dsDivisionFld = new TextField("DS division");

        Button submitBtn = new Button("Submit");
        Button clearBtn = new Button("Clear");

        formLayout.addComponents(mNameFld,mAgeFld,date,mNicNo,mohAreaFld,phmAreaFld,gnDivisionFld,antenatalClinicFld,dsDivisionFld);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addComponents(submitBtn,clearBtn);
        addComponent(formLayout);
        addComponent(buttonLayout);

    }
}
