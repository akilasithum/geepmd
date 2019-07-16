package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ4;
import com.geepmd.entity.BaselineQ8;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class Tab8 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q8Map;
    Map<String,String> fields;
    String language;
    VerticalLayout questionLayout;
    Survey survey;

    public Tab8(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q8Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ7AnswerList();
            q8Map = SinhalaMap.getQ8Map();
            fields = SinhalaMap.getQ8Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        Label q1Header = new Label(q8Map.get("8.1"));
        q1Header.setSizeFull();
        addComponent(q1Header);

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
            survey.SelectTab(8);
        });
        addComponent(nextBtn);
    }

    private void setYesNoQuestions(VerticalLayout layout,String question){

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        layout.addComponent(horizontalLayout);
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(getYesNoAnswer(language));
        horizontalLayout.addComponents(questionLabel,yesNoCombo);
    }

    public BaselineQ8 getAnswers(int motherId) {

        BaselineQ8 answer = new BaselineQ8();
        answer.setMotherId(motherId);
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
}
