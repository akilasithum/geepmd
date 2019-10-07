package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class FirstFollowUpTab3 extends VerticalLayout {

    Map<Integer,String> questionMap;
    String language;
    FirstFollowUpSurvey survey;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    VerticalLayout qLayout;

    public FirstFollowUpTab3(String language, FirstFollowUpSurvey survey){
        this.language = language;
        if(language.equals("EN")){

        }
        else{
            questionMap = SinhalaMap.getFirstFollowUpQ3();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){

        qLayout = new VerticalLayout();
        qLayout.setSizeFull();
        qLayout.setMargin(false);
        qLayout.addComponent(addHorizontalLayout(questionMap.get(1)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(2)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(3)));
        addComponent(qLayout);
    }

    private HorizontalLayout addHorizontalLayout(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getYesNoAnswer("SN"));
        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        return layout;
    }
}
