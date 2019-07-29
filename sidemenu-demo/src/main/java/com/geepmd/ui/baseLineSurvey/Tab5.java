package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ5;
import com.geepmd.entity.BaselineQ51;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getAnswerDesc;
import static com.geepmd.utils.SurveyUtils.getAnwerObj;
import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class Tab5 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q5Map;
    Map<String,String> fields;
    String language;
    VerticalLayout q1Layout;
    ComboBox q52ComboBox;
    ComboBox q53ComboBox;
    Survey survey;
    HorizontalLayout q52Layout;
    HorizontalLayout q53Layout;

    public Tab5(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q5Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ5AnswerList();
            q5Map = SinhalaMap.getQ5Map();
            fields = SinhalaMap.getQ5Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        Label firstQLabel = new Label(q5Map.get("5.1"));
        firstQLabel.setSizeFull();
        addComponent(firstQLabel);

        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLabel = new Label(" ");
        emptyLabel.setSizeFull();
        Label priorConception = new Label(fields.get("5.11"));
        priorConception.setSizeFull();
        priorConception.setStyleName("padHeader");
        Label afterConception = new Label(fields.get("5.16"));
        afterConception.setSizeFull();
        afterConception.setStyleName("padHeader");
        headerLayout.addComponents(emptyLabel,priorConception,afterConception);
        headerLayout.setExpandRatio(emptyLabel,1);
        headerLayout.setExpandRatio(priorConception,2);
        headerLayout.setExpandRatio(afterConception,2);
        addComponent(headerLayout);

        Label emptyLabel1 = new Label(" ");
        emptyLabel1.setSizeFull();

        HorizontalLayout priorConceptionLayout = new HorizontalLayout();
        priorConceptionLayout.setSizeFull();
        Label yesNoLabel = new Label(fields.get("5.12"));
        yesNoLabel.setSizeFull();
        Label frequencyLabel = new Label(fields.get("5.13"));
        frequencyLabel.setSizeFull();
        Label worsenLabel = new Label(fields.get("5.14"));
        worsenLabel.setSizeFull();
        Label adviceLabel = new Label(fields.get("5.15"));
        adviceLabel.setSizeFull();
        priorConceptionLayout.setMargin(new MarginInfo(false,true,false,false));
        priorConceptionLayout.addComponents(yesNoLabel,frequencyLabel,worsenLabel,adviceLabel);

        HorizontalLayout afterConceptionLayout = new HorizontalLayout();
        afterConceptionLayout.setSizeFull();
        Label yesNoLabelAfter = new Label(fields.get("5.12"));
        yesNoLabelAfter.setSizeFull();
        Label frequencyLabelAfter = new Label(fields.get("5.13"));
        frequencyLabelAfter.setSizeFull();
        Label worsenLabelAfter = new Label(fields.get("5.14"));
        worsenLabelAfter.setSizeFull();
        Label adviceLabelAfter = new Label(fields.get("5.15"));
        adviceLabelAfter.setSizeFull();
        afterConceptionLayout.addComponents(yesNoLabelAfter,frequencyLabelAfter,worsenLabelAfter,adviceLabelAfter);

        HorizontalLayout headerTextLayout = new HorizontalLayout();
        headerTextLayout.setSizeFull();
        headerTextLayout.addComponents(emptyLabel1,priorConceptionLayout,afterConceptionLayout);
        headerTextLayout.setExpandRatio(emptyLabel1,1);
        headerTextLayout.setExpandRatio(priorConceptionLayout,2);
        headerTextLayout.setExpandRatio(afterConceptionLayout,2);
        addComponent(headerTextLayout);
        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        addComponent(q1Layout);
        q1Layout.addComponent(addQ5Questions(fields.get("a"),"a"));
        q1Layout.addComponent(addQ5Questions(fields.get("b"),"b"));
        q1Layout.addComponent(addQ5Questions(fields.get("c"),"c"));
        q1Layout.addComponent(addQ5Questions(fields.get("d"),"d"));
        q1Layout.addComponent(addQ5Questions(fields.get("e"),"e"));
        q1Layout.addComponent(addQ5Questions(fields.get("f"),"f"));
        q1Layout.addComponent(addQ5Questions(fields.get("g"),"g"));
        q1Layout.addComponent(addQ5Questions(fields.get("h"),"h"));
        q1Layout.addComponent(addQ5Questions(fields.get("i"),"i"));
        q1Layout.addComponent(addQ5Questions(fields.get("j"),"j"));
        q1Layout.addComponent(addQ5Questions(fields.get("k"),"k"));

        q52ComboBox = new ComboBox<>();
        q52ComboBox.setItems(getAnwerObj(answerMap.get("5.2")));
        q52ComboBox.setDescription(getAnswerDesc(answerMap.get("5.2")));
        q52Layout = addQ52and3Questions(q52ComboBox,q5Map.get("5.2"));
        q52ComboBox.setTextInputAllowed(false);
        addComponent(q52Layout);
        q52Layout.setVisible(false);

        q53ComboBox = new ComboBox<>();
        q53ComboBox.setItems(getAnwerObj(answerMap.get("5.3")));
        q53ComboBox.setDescription(getAnswerDesc(answerMap.get("5.3")));
        q53Layout = addQ52and3Questions(q53ComboBox,q5Map.get("5.3"));
        q53ComboBox.setTextInputAllowed(false);
        addComponent(q53Layout);
        q53Layout.setVisible(false);

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(5);
        });
        addComponent(nextBtn);
    }

    private HorizontalLayout addQ52and3Questions(ComboBox multi,String questionStr){
        HorizontalLayout q52Layout = new HorizontalLayout();
        q52Layout.setSizeFull();
        q52Layout.setMargin(new MarginInfo(true,false,false,false));

        Label question = new Label(questionStr);
        question.setSizeFull();

        multi.setSizeFull();
        q52Layout.addComponents(question,multi);
        q52Layout.setExpandRatio(question,1);
        q52Layout.setExpandRatio(multi,2);
        return q52Layout;
    }

    private HorizontalLayout addQ5Questions(String question,String qNumber){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        HorizontalLayout symptomsBefore = getSymptomsLayouts(true,qNumber);
        HorizontalLayout symptomsAfter = getSymptomsLayouts(false,qNumber);
        layout.addComponents(questionLabel,symptomsBefore,symptomsAfter);
        layout.setExpandRatio(questionLabel,1);
        layout.setExpandRatio(symptomsBefore,2);
        layout.setExpandRatio(symptomsAfter,2);
        return layout;
    }

    private HorizontalLayout getSymptomsLayouts(boolean marginRequired,String qNumber){
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setItems(getYesNoAnswer(language));

        ComboBox frequencyCombo = new ComboBox();
        frequencyCombo.setSizeFull();
        frequencyCombo.setTextInputAllowed(false);
        frequencyCombo.setItems(getAnwerObj(answerMap.get("5.1")));
        frequencyCombo.setDescription(getAnswerDesc(answerMap.get("5.1")));

        ComboBox worsenYesNoCombo = new ComboBox();
        worsenYesNoCombo.setSizeFull();
        worsenYesNoCombo.setTextInputAllowed(false);
        worsenYesNoCombo.setItems(getYesNoAnswer(language));

        ComboBox adviceCombo = new ComboBox();
        adviceCombo.setSizeFull();
        adviceCombo.setTextInputAllowed(false);
        adviceCombo.setItems(getYesNoAnswer(language));

        HorizontalLayout dependentLayout = new HorizontalLayout();
        dependentLayout.setSizeFull();
        dependentLayout.addComponents(frequencyCombo,worsenYesNoCombo,adviceCombo);
        dependentLayout.setEnabled(false);

        yesNoCombo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer == null || answer.getId() != 1){
                dependentLayout.setEnabled(false);

            }
            else{
                dependentLayout.setEnabled(true);
                if(qNumber.equalsIgnoreCase("c")){
                    q52Layout.setVisible(true);
                }
                if(qNumber.equalsIgnoreCase("d")){
                    q53Layout.setVisible(true);
                }
            }
        });

        HorizontalLayout beforeConceptionLayout = new HorizontalLayout();
        beforeConceptionLayout.setSizeFull();
        beforeConceptionLayout.addComponents(yesNoCombo,dependentLayout);
        beforeConceptionLayout.setExpandRatio(yesNoCombo,1);
        beforeConceptionLayout.setExpandRatio(dependentLayout,3);
        if(marginRequired) {
            beforeConceptionLayout.setMargin(new MarginInfo(false, true, false, false));
        }
        return beforeConceptionLayout;
    }

    public BaselineQ5 getAnswer(int motherId){
        BaselineQ5 answer = new BaselineQ5();
        answer.setSurveyId(motherId);
        if(q52ComboBox.getValue() != null) answer.setM2(getId((Answer)q52ComboBox.getValue()));
        if(q53ComboBox.getValue() != null) answer.setM3(getId((Answer)q53ComboBox.getValue()));
        return answer;
    }

    public List<BaselineQ51> getAnswer51(int motherId) {

        List<BaselineQ51> list = new ArrayList<>();
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            HorizontalLayout horizontalLayout = (HorizontalLayout) q1Layout.getComponent(i);
            String label = ((Label) horizontalLayout.getComponent(0)).getValue();
            HorizontalLayout beforeLayout = (HorizontalLayout) horizontalLayout.getComponent(1);
            HorizontalLayout beforeDependentLayout = (HorizontalLayout) beforeLayout.getComponent(1);
            HorizontalLayout afterLayout = (HorizontalLayout) horizontalLayout.getComponent(2);
            HorizontalLayout afterDependentLayout = (HorizontalLayout) afterLayout.getComponent(1);
            ComboBox b1Combo = (ComboBox) beforeLayout.getComponent(0);
            ComboBox b2Combo = (ComboBox) beforeDependentLayout.getComponent(0);
            ComboBox b3Combo = (ComboBox) beforeDependentLayout.getComponent(1);
            ComboBox b4Combo = (ComboBox) beforeDependentLayout.getComponent(2);
            ComboBox a1Combo = (ComboBox) afterLayout.getComponent(0);
            ComboBox a2Combo = (ComboBox) afterDependentLayout.getComponent(0);
            ComboBox a3Combo = (ComboBox) afterDependentLayout.getComponent(1);
            ComboBox a4Combo = (ComboBox) afterDependentLayout.getComponent(2);
            BaselineQ51 answer = new BaselineQ51();
            answer.setSurveyId(motherId);
            answer.setQuestion(label.substring(0,1));
            if(b1Combo.getValue() != null) answer.setB1(getId((Answer)b1Combo.getValue()));
            if(b2Combo.getValue() != null) answer.setB2(getId((Answer)b2Combo.getValue()));
            if(b3Combo.getValue() != null) answer.setB3(getId((Answer)b3Combo.getValue()));
            if(b4Combo.getValue() != null) answer.setB4(getId((Answer)b4Combo.getValue()));
            if(a1Combo.getValue() != null) answer.setA1(getId((Answer)a1Combo.getValue()));
            if(a2Combo.getValue() != null) answer.setA2(getId((Answer)a2Combo.getValue()));
            if(a3Combo.getValue() != null) answer.setA3(getId((Answer)a3Combo.getValue()));
            if(a4Combo.getValue() != null) answer.setA4(getId((Answer)a4Combo.getValue()));
            list.add(answer);
        }

        return list;
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
