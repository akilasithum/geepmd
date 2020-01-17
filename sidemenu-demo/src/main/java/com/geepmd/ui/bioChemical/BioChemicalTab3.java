package com.geepmd.ui.bioChemical;

import com.geepmd.entity.BioChemicalQ2;
import com.geepmd.entity.BioChemicalQ3;
import com.geepmd.ui.BioChemicalProfileSurvey;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.Map;

public class BioChemicalTab3 extends VerticalLayout {

    BioChemicalProfileSurvey survey;
    VerticalLayout q1Layout;
    TextField textField;

    public BioChemicalTab3(BioChemicalProfileSurvey survey) {

        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout() {
        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        addComponent(q1Layout);
        q1Layout.setMargin(false);
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label qLabel = new Label("1. HB");
        textField = new TextField();
        Label unitLabel = new Label("g/dL");
        HorizontalLayout answerLayout = new HorizontalLayout();
        answerLayout.addComponents(textField, unitLabel);
        layout.addComponents(qLabel, answerLayout);
        q1Layout.addComponent(layout);
        q1Layout.setStyleName("bioChemicalMainLayout");
    }

    public BioChemicalQ3 getAnswers(int surveyId) {
        BioChemicalQ3 answer = new BioChemicalQ3();
        answer.setSurveyId(surveyId);
        if(textField.getValue() != null && !textField.getValue().isEmpty()) answer.setM1(textField.getValue());
        return answer;
    }

    public void setEditData(BioChemicalQ3 answer) {
        if(answer.getM1() != null && !answer.getM1().isEmpty()) textField.setValue(answer.getM1());
    }

    public void clearFields() {
        textField.clear();
    }
}
