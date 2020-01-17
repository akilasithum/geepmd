package com.geepmd.ui.bioChemical;

import com.geepmd.entity.BioChemicalQ1;
import com.geepmd.entity.BioChemicalQ2;
import com.geepmd.ui.BioChemicalProfileSurvey;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.Map;

public class BioChemicalTab2 extends VerticalLayout {

    Map<Integer,String> q1Map;
    Map<Integer,String> unitsMap;
    BioChemicalProfileSurvey survey;
    VerticalLayout q1Layout;

    public BioChemicalTab2(BioChemicalProfileSurvey survey){

        q1Map = SinhalaMap.getBioChemicalQ2();
        unitsMap = SinhalaMap.getSBioChemicalTab2UnitMap();
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

        for(Map.Entry<Integer,String> map : q1Map.entrySet()){
            HorizontalLayout layout = new HorizontalLayout();
            layout.setSizeFull();
            Label qLabel = new Label(map.getKey() + ". " + map.getValue());
            TextField textField = new TextField();
            Label unitLabel = new Label(unitsMap.get(map.getKey()));
            HorizontalLayout answerLayout = new HorizontalLayout();
            answerLayout.addComponents(textField,unitLabel);
            layout.addComponents(qLabel,answerLayout);
            q1Layout.addComponent(layout);
            q1Layout.setStyleName("bioChemicalMainLayout");
        }

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(2);
        });
        addComponent(nextBtn);
    }

    public BioChemicalQ2 getAnswers(int surveyId) {
        BioChemicalQ2 answer = new BioChemicalQ2();
        answer.setSurveyId(surveyId);
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
                HorizontalLayout fieldLayout = (HorizontalLayout) layout.getComponent(1);
                TextField textField = (TextField) fieldLayout.getComponent(0);
                if (i == 0) answer.setM1(textField.getValue());
                if (i == 1) answer.setM2(textField.getValue());
                if (i == 2) answer.setM3(textField.getValue());
                if (i == 3) answer.setM4(textField.getValue());
            }
        }
        return answer;
    }

    public void setEditData(BioChemicalQ2 answer) {
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
                HorizontalLayout fieldLayout = (HorizontalLayout) layout.getComponent(1);
                TextField textField = (TextField) fieldLayout.getComponent(0);
                if (i == 0 && answer.getM1() != null && !answer.getM1().isEmpty()) textField.setValue(answer.getM1());
                if (i == 1 && answer.getM2() != null && !answer.getM2().isEmpty()) textField.setValue(answer.getM2());
                if (i == 2 && answer.getM3() != null && !answer.getM3().isEmpty()) textField.setValue(answer.getM3());
                if (i == 3 && answer.getM4() != null && !answer.getM4().isEmpty()) textField.setValue(answer.getM4());
            }
        }
    }

    public void clearFields() {
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
                HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
                HorizontalLayout fieldLayout = (HorizontalLayout) layout.getComponent(1);
                TextField textField = (TextField) fieldLayout.getComponent(0);
                textField.clear();
        }
    }
}
