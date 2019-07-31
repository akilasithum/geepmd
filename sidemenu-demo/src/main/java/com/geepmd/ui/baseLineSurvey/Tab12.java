package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ11;
import com.geepmd.entity.BaselineQ12;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.beans.PropertyDescriptor;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class Tab12 extends VerticalLayout {

    Map<String,String> q12Map;
    String language;
    Survey survey;
    VerticalLayout mainLayout;

    public Tab12(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            q12Map = EnglishMap.getquestion1Map();

        }
        else{

            q12Map = SinhalaMap.getQ12Map();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        Label label = new Label("Cardiovascular diseases – Screening checklist - History");
        label.setStyleName("padHeader");
        addComponent(label);
        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setWidth("70%");
        addComponent(mainLayout);
        mainLayout.setMargin(false);
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.1")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.2")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.3")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.4")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.5")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.6")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.7")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.8")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.9")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.10")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.11")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.12")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.13")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.14")));

    }

    private HorizontalLayout getQ12Questions(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setItems(getYesNoAnswer("EN"));
        layout.addComponents(label,yesNoCombo);
        layout.setExpandRatio(label,3);
        layout.setExpandRatio(yesNoCombo,1);
        return layout;
    }

    public BaselineQ12 getAnswerQ12(int surveyId) {
        BaselineQ12 answer = new BaselineQ12();
        answer.setSurveyId(surveyId);
        for (int i = 0; i < mainLayout.getComponentCount(); i++) {
            HorizontalLayout layout = (HorizontalLayout) mainLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            String prefix = (i + 1) + "";
            if (comboBox.getValue() != null) callSetter(answer, "m" + prefix, getId((Answer) comboBox.getValue()));
        }

        return answer;
    }

    private void callSetter(Object obj, String fieldName, Object value){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            pd.getWriteMethod().invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getId(Answer answer){
        return answer.getId();
    }

}
