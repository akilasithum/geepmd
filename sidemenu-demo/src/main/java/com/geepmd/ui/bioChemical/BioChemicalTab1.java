package com.geepmd.ui.bioChemical;

import com.geepmd.entity.BioChemicalQ1;
import com.geepmd.ui.BioChemicalProfileSurvey;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.Map;

public class BioChemicalTab1 extends VerticalLayout {

    Map<Integer,String> q1Map;
    Map<Integer,String> unitsMap;
    BioChemicalProfileSurvey survey;
    VerticalLayout q1Layout;

    public BioChemicalTab1(BioChemicalProfileSurvey survey){

        q1Map = SinhalaMap.getBioChemicalQ1();
        unitsMap = SinhalaMap.getSBioChemicalTab1UnitMap();
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
            survey.SelectTab(1);
        });
        addComponent(nextBtn);
    }

    public BioChemicalQ1 getAnswers(int surveyId) {
        BioChemicalQ1 answer = new BioChemicalQ1();
        answer.setSurveyId(surveyId);
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
                HorizontalLayout fieldLayout = (HorizontalLayout) layout.getComponent(1);
                TextField textField = (TextField) fieldLayout.getComponent(0);
                if(i==0)answer.setM1(textField.getValue());
                if(i==1)answer.setM2(textField.getValue());
                if(i==2)answer.setM3(textField.getValue());
                if(i==3)answer.setM4(textField.getValue());
                if(i==4)answer.setM5(textField.getValue());
                if(i==5)answer.setM6(textField.getValue());
                if(i==6)answer.setM7(textField.getValue());
                if(i==7)answer.setM8(textField.getValue());
                if(i==8)answer.setM9(textField.getValue());
                if(i==9)answer.setM10(textField.getValue());
                if(i==10)answer.setM11(textField.getValue());
                if(i==11)answer.setM12(textField.getValue());
                if(i==12)answer.setM13(textField.getValue());
                if(i==13)answer.setM14(textField.getValue());
            }
        }
        return answer;
    }

    public void setEditData(BioChemicalQ1 answer) {
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
                HorizontalLayout fieldLayout = (HorizontalLayout) layout.getComponent(1);
                TextField textField = (TextField) fieldLayout.getComponent(0);
                if(i == 0 && answer.getM1() != null && !answer.getM1().isEmpty())textField.setValue(answer.getM1());
                if(i == 1 && answer.getM2() != null && !answer.getM2().isEmpty())textField.setValue(answer.getM2());
                if(i == 2 && answer.getM3() != null && !answer.getM3().isEmpty())textField.setValue(answer.getM3());
                if(i == 3 && answer.getM4() != null && !answer.getM4().isEmpty())textField.setValue(answer.getM4());
                if(i == 4 && answer.getM5() != null && !answer.getM5().isEmpty())textField.setValue(answer.getM5());
                if(i == 5 && answer.getM6() != null && !answer.getM6().isEmpty())textField.setValue(answer.getM6());
                if(i == 6 && answer.getM7() != null && !answer.getM7().isEmpty())textField.setValue(answer.getM7());
                if(i == 7 && answer.getM8() != null && !answer.getM8().isEmpty())textField.setValue(answer.getM8());
                if(i == 8 && answer.getM9() != null && !answer.getM9().isEmpty())textField.setValue(answer.getM9());
                if(i == 9 && answer.getM10() != null && !answer.getM10().isEmpty())textField.setValue(answer.getM10());
                if(i == 10 && answer.getM11() != null && !answer.getM11().isEmpty())textField.setValue(answer.getM11());
                if(i == 11 && answer.getM12() != null && !answer.getM12().isEmpty())textField.setValue(answer.getM12());
                if(i == 12 && answer.getM13() != null && !answer.getM13().isEmpty())textField.setValue(answer.getM13());
                if(i == 13 && answer.getM14() != null && !answer.getM14().isEmpty())textField.setValue(answer.getM14());
            }
        }
    }

    public void clearFields() {
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
                HorizontalLayout fieldLayout = (HorizontalLayout) layout.getComponent(1);
                TextField textField = (TextField) fieldLayout.getComponent(0);
                textField.clear();
            }
        }
    }
}
