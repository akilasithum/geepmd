package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ1;
import com.geepmd.entity.BaselineQ7;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;
import static com.geepmd.utils.SurveyUtils.getYesNoObject;

public class Tab7 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q7Map;
    Map<String,String> fields;
    String language;
    VerticalLayout questionLayout;
    Survey survey;
    CheckBox noToAll;
    TextField questionDBUniqueIdField;

    public Tab7(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q7Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ7AnswerList();
            q7Map = SinhalaMap.getQ7Map();
            fields = SinhalaMap.getQ7Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        questionDBUniqueIdField = new TextField();
        questionDBUniqueIdField.setVisible(false);
        addComponent(questionDBUniqueIdField);
        Label q1Header = new Label(q7Map.get("7.1"));
        q1Header.setSizeFull();
        addComponent(q1Header);

        noToAll = new CheckBox(fields.get("7.1"));
        addComponent(noToAll);
        noToAll.setStyleName("checkBoxMargin");
        noToAll.addValueChangeListener(event -> {
            setNoToAllCombo(event.getValue());
        });

        questionLayout = new VerticalLayout();
        questionLayout.setSizeFull();
        questionLayout.setMargin(true);
        addComponent(questionLayout);
        questionLayout.setWidth("60%");
        setYesNoQuestions(questionLayout,fields.get("a"));
        setYesNoQuestions(questionLayout,fields.get("b"));
        setYesNoQuestions(questionLayout,fields.get("c"));
        setYesNoQuestions(questionLayout,fields.get("d"));
        setYesNoQuestions(questionLayout,fields.get("e"));
        setYesNoQuestions(questionLayout,fields.get("f"));
        setYesNoQuestions(questionLayout,fields.get("g"));
        setYesNoQuestions(questionLayout,fields.get("h"));
        setYesNoQuestions(questionLayout,fields.get("i"));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(7);
        });
        addComponent(nextBtn);
    }

    private void setNoToAllCombo(boolean isNo){
        if(isNo){
            for(int i = 0;i< questionLayout.getComponentCount();i++){
                HorizontalLayout layout = (HorizontalLayout)questionLayout.getComponent(i);
                ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
                yesNoCombo.setValue(getYesNoObject("SN",2));
            }
        }
    }

    private void setYesNoQuestions(VerticalLayout layout,String question){

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        layout.addComponent(horizontalLayout);
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(getYesNoAnswer(language));
        horizontalLayout.addComponents(questionLabel,yesNoCombo);
    }

    public BaselineQ7 getAnswers(int motherId) {

        BaselineQ7 answer = new BaselineQ7();
        /*if(questionDBUniqueIdField.getValue() != null && !questionDBUniqueIdField.getValue().isEmpty()){
            answer.setBaselineQ7Id(Integer.parseInt(questionDBUniqueIdField.getValue()));
        }*/
        answer.setSurveyId(motherId);
        for(int i = 0;i< questionLayout.getComponentCount();i++){

            HorizontalLayout layout = (HorizontalLayout)questionLayout.getComponent(i);
            Label questionLabel = (Label)layout.getComponent(0);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            String question = questionLabel.getCaption();
            if(i == 0 && yesNoCombo.getValue() != null) answer.setM81a(((Answer) yesNoCombo.getValue()).getId());
            if(i == 1 && yesNoCombo.getValue() != null) answer.setM81b(((Answer) yesNoCombo.getValue()).getId());
            if(i == 2 && yesNoCombo.getValue() != null) answer.setM81c(((Answer) yesNoCombo.getValue()).getId());
            if(i == 3 && yesNoCombo.getValue() != null) answer.setM81d(((Answer) yesNoCombo.getValue()).getId());
            if(i == 4 && yesNoCombo.getValue() != null) answer.setM81e(((Answer) yesNoCombo.getValue()).getId());
            if(i == 5 && yesNoCombo.getValue() != null) answer.setM81f(((Answer) yesNoCombo.getValue()).getId());
            if(i == 6 && yesNoCombo.getValue() != null) answer.setM81g(((Answer) yesNoCombo.getValue()).getId());
            if(i == 7 && yesNoCombo.getValue() != null) answer.setM81h(((Answer) yesNoCombo.getValue()).getId());
            if(i == 8 && yesNoCombo.getValue() != null) answer.setM81i(((Answer) yesNoCombo.getValue()).getId());
        }

        return answer;
    }

    public void setEditData(BaselineQ7 answer){
        questionDBUniqueIdField.setValue(String.valueOf(answer.getBaselineQ7Id()));
        for(int i = 0;i< questionLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)questionLayout.getComponent(i);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            if(i == 0 && answer.getM81a() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81a()));
            if(i == 1 && answer.getM81b() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81b()));
            if(i == 2 && answer.getM81c() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81c()));
            if(i == 3 && answer.getM81d() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81d()));
            if(i == 4 && answer.getM81e() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81e()));
            if(i == 5 && answer.getM81f() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81f()));
            if(i == 6 && answer.getM81g() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81g()));
            if(i == 7 && answer.getM81h() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81h()));
            if(i == 8 && answer.getM81i() != 0) yesNoCombo.setValue(getYesNoObject("SN",answer.getM81i()));
        }
    }

    public void clearFields() {
        questionDBUniqueIdField.clear();
        noToAll.clear();
        for(int i = 0;i< questionLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)questionLayout.getComponent(i);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            yesNoCombo.clear();
        }
    }
}
