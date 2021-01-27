package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.entity.FirstFollowupQ3;
import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getAnswerObj;
import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class FirstFollowUpTab3 extends VerticalLayout {

    Map<Integer,String> questionMap;
    String language;
    FirstFollowUpSurvey survey;
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

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(3);
        });
        addComponent(nextBtn);
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

    public FirstFollowupQ3 getAnswers(int surveyId) {
        FirstFollowupQ3 answer = new FirstFollowupQ3();
        for(int i=0;i<qLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) qLayout.getComponent(i);
            ComboBox comboBox = (ComboBox)layout.getComponent(1);
            if(comboBox.getValue() != null){
                int val = ((Answer)comboBox.getValue()).getId();
                if(i == 0) answer.setM1(val);
                if(i == 1) answer.setM2(val);
                if(i == 2) answer.setM3(val);
            }
        }
        answer.setSurveyId(surveyId);
        return answer;
    }

    public void setEditData(FirstFollowupQ3 answer) {
        for(int i=0;i<qLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) qLayout.getComponent(i);
            ComboBox comboBox = (ComboBox)layout.getComponent(1);
            if(i==0 && answer.getM1() != 0) comboBox.setValue(getAnswerObj(answer.getM1(), Arrays.asList("1.ඔව්", "2.නැත")));
            if(i==1 && answer.getM2() != 0) comboBox.setValue(getAnswerObj(answer.getM2(), Arrays.asList("1.ඔව්", "2.නැත")));
            if(i==2 && answer.getM3() != 0) comboBox.setValue(getAnswerObj(answer.getM3(), Arrays.asList("1.ඔව්", "2.නැත")));
        }
    }

    public void clearFields() {
        for(int i=0;i<qLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) qLayout.getComponent(i);
            ComboBox comboBox = (ComboBox)layout.getComponent(1);
            comboBox.clear();
        }
    }
}
