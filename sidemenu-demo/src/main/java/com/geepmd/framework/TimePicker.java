package com.geepmd.framework;

import com.geepmd.utils.SurveyUtils;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import java.util.Arrays;

public class TimePicker extends CustomComponent {

    public TimePicker(String text){
        HorizontalLayout timeLayout = new HorizontalLayout();
        timeLayout.setSpacing(false);
        timeLayout.setMargin(false);
        ComboBox hourCombo = new ComboBox();
        hourCombo.setItems(SurveyUtils.getStringList(3,12));
        ComboBox minuteCombo = new ComboBox();
        minuteCombo.setItems(SurveyUtils.getStringList(0,60));
        ComboBox ampmCombo = new ComboBox();
        ampmCombo.setItems(Arrays.asList("AM","PM"));
        timeLayout.addComponents(hourCombo,minuteCombo,ampmCombo);
        setCompositionRoot(timeLayout);
        setCaption(text);
    }

    public String getValue(){

        return "";
    }
}
