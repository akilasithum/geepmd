package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ32;
import com.geepmd.entity.BaselineQ8;
import com.geepmd.entity.BaselineQ84;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab8 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q8Map;
    Map<String,String> fields;
    String language;
    Survey survey;
    ComboBox noOfMembers;
    TextField houseLeaderFld;
    ComboBox medicalPref;
    VerticalLayout q84Layout;
    VerticalLayout q85Layout;
    TextField questionDBUniqueIdField;

    public Tab8(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q8Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ8AnswerList();
            q8Map = SinhalaMap.getQ8Map();
            fields = SinhalaMap.getQ8Fields();
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
        noOfMembers = new ComboBox();
        noOfMembers.setItems(SurveyUtils.getStringList(1,7));
        noOfMembers.setSizeFull();
        noOfMembers.setTextInputAllowed(false);
        addComponent(setTabData(q8Map.get("8.1"),noOfMembers));

        houseLeaderFld = new TextField();
        houseLeaderFld.setSizeFull();
        addComponent(setTabData(q8Map.get("8.2"),houseLeaderFld));

        medicalPref = new ComboBox();
        medicalPref.setSizeFull();
        medicalPref.setTextInputAllowed(false);
        medicalPref.setItems(getAnwerObj(answerMap.get("8.3")));
        addComponent(setTabData(q8Map.get("8.3"),medicalPref));

        q84Layout = new VerticalLayout();
        q84Layout.setSizeFull();
        q84Layout.setVisible(false);
        q84Layout.setWidth("70%");
        addComponent(q84Layout);
        noOfMembers.addValueChangeListener(event -> {
            if(event.getValue() != null){
                q84Layout.removeAllComponents();
                q84Layout.addComponent(new Label(q8Map.get("8.4")));
                q84Layout.setVisible(true);
                q84Layout.setMargin(false);
                int memberCount = Integer.valueOf(event.getValue().toString());
                HorizontalLayout headerLayout = new HorizontalLayout();
                headerLayout.setSizeFull();
                Label memberLabel = new Label(fields.get("8.4.1"));
                memberLabel.setSizeFull();
                memberLabel.setStyleName("padHeader");
                Label relationshipLabel = new Label(fields.get("8.4.2"));
                relationshipLabel.setSizeFull();
                relationshipLabel.setStyleName("padHeader");
                Label ageLabel = new Label(fields.get("8.4.3"));
                ageLabel.setSizeFull();
                ageLabel.setStyleName("padHeader");
                headerLayout.addComponents(memberLabel,relationshipLabel,ageLabel);
                headerLayout.setExpandRatio(memberLabel,1);
                headerLayout.setExpandRatio(relationshipLabel,4);
                headerLayout.setExpandRatio(ageLabel,2);
                q84Layout.addComponent(headerLayout);
                for(int i = 0;i<memberCount;i++){
                    HorizontalLayout layout = new HorizontalLayout();
                    layout.setSizeFull();
                    Label member = new Label((i+1)+"");
                    TextField relationship = new TextField();
                    relationship.setSizeFull();
                    ComboBox ageCombo = new ComboBox();
                    ageCombo.setSizeFull();
                    ageCombo.setItems(getStringList(1,100));
                    layout.addComponents(member,relationship,ageCombo);
                    layout.setComponentAlignment(member,Alignment.MIDDLE_CENTER);
                    layout.setExpandRatio(member,1);
                    layout.setExpandRatio(relationship,4);
                    layout.setExpandRatio(ageCombo,2);
                    q84Layout.addComponent(layout);
                }
            }
            else{
                q84Layout.setVisible(false);
            }
        });

        Label q15Label = new Label(q8Map.get("8.5"));
        q15Label.setSizeFull();
        addComponent(q15Label);
        q85Layout = new VerticalLayout();
        q85Layout.setSizeFull();
        q85Layout.setMargin(true);
        addComponent(q85Layout);
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.1")));
        q85Layout.addComponent(get85Combo(getStringList(1,10),fields.get("8.5.2")));
        q85Layout.addComponent(get85Combo(getStringList(1,6),fields.get("8.5.3")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.4")),fields.get("8.5.4")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.5")),fields.get("8.5.5")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.6")),fields.get("8.5.6")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.7")),fields.get("8.5.7")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.8")),fields.get("8.5.8")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.9")),fields.get("8.5.9")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.10")),fields.get("8.5.10")));
        Label q15MiddleLabel = new Label(fields.get("8.5.middle"));
        q15MiddleLabel.setStyleName("padHeader");
        q85Layout.addComponent(q15MiddleLabel);
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.11")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.12")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.13")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.14")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.15")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.16")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.17")));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(8);
        });
        addComponent(nextBtn);
    }

    public HorizontalLayout get85Combo(List<?> list,String label){
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        if(list == null){
            comboBox.setItems(getYesNoAnswer(language));
        }
        else {
            comboBox.setItems(list);
        }
        return setTabData(label,comboBox);
    }

    public List<BaselineQ84> get84Answers(int surveyId){
        List<BaselineQ84> answerList = new ArrayList<>();
        for (int i=2;i<q84Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)q84Layout.getComponent(i);
            Label memberNo = (Label) layout.getComponent(0);
            TextField relationship = (TextField) layout.getComponent(1);
            ComboBox age = (ComboBox) layout.getComponent(2);
            BaselineQ84 answer = new BaselineQ84();
            answer.setSurveyId(surveyId);
            if(memberNo.getValue() != null) answer.setM1(Integer.parseInt(memberNo.getValue()));
            if(relationship.getValue() != null) answer.setM2(relationship.getValue());
            if(age.getValue() != null) answer.setM3(Integer.parseInt(age.getValue().toString()));
            answerList.add(answer);
        }
        return answerList;
    }

    public BaselineQ8 getQ8Answers(int surveyId) {
        BaselineQ8 answer = new BaselineQ8();
        answer.setSurveyId(surveyId);
        if(questionDBUniqueIdField.getValue() != null && !questionDBUniqueIdField.getValue().isEmpty()){
            answer.setBaselineQ8Id(Integer.parseInt(questionDBUniqueIdField.getValue()));
        }
        if(noOfMembers.getValue() != null) answer.setM1(Integer.parseInt(noOfMembers.getValue().toString()));
        if(houseLeaderFld.getValue() != null) answer.setM2(houseLeaderFld.getValue());
        if(medicalPref.getValue() != null) answer.setM3(getId((Answer)medicalPref.getValue()));

        for(int i=0;i<q85Layout.getComponentCount();i++){
            if(i != 10) {
                HorizontalLayout layout = (HorizontalLayout) q85Layout.getComponent(i);
                ComboBox comboBox = (ComboBox) layout.getComponent(1);
                if (i == 0 && comboBox.getValue() != null) answer.setM51(getId((Answer) comboBox.getValue()));
                if (i == 1 && comboBox.getValue() != null)
                    answer.setM52(Integer.parseInt(comboBox.getValue().toString()));
                if (i == 2 && comboBox.getValue() != null)
                    answer.setM53(Integer.parseInt(comboBox.getValue().toString()));
                if (i == 3 && comboBox.getValue() != null) answer.setM54(getId((Answer) comboBox.getValue()));
                if (i == 4 && comboBox.getValue() != null) answer.setM55(getId((Answer) comboBox.getValue()));
                if (i == 5 && comboBox.getValue() != null) answer.setM56(getId((Answer) comboBox.getValue()));
                if (i == 6 && comboBox.getValue() != null) answer.setM57(getId((Answer) comboBox.getValue()));
                if (i == 7 && comboBox.getValue() != null) answer.setM58(getId((Answer) comboBox.getValue()));
                if (i == 8 && comboBox.getValue() != null) answer.setM59(getId((Answer) comboBox.getValue()));
                if (i == 9 && comboBox.getValue() != null) answer.setM510(getId((Answer) comboBox.getValue()));
                if (i == 11 && comboBox.getValue() != null) answer.setM511(getId((Answer) comboBox.getValue()));
                if (i == 12 && comboBox.getValue() != null) answer.setM512(getId((Answer) comboBox.getValue()));
                if (i == 13 && comboBox.getValue() != null) answer.setM513(getId((Answer) comboBox.getValue()));
                if (i == 14 && comboBox.getValue() != null) answer.setM514(getId((Answer) comboBox.getValue()));
                if (i == 15 && comboBox.getValue() != null) answer.setM515(getId((Answer) comboBox.getValue()));
                if (i == 16 && comboBox.getValue() != null) answer.setM516(getId((Answer) comboBox.getValue()));
                if (i == 17 && comboBox.getValue() != null) answer.setM517(getId((Answer) comboBox.getValue()));
            }
        }
        return answer;
    }

    public void setEditData(BaselineQ8 answer,List<BaselineQ84> answer84) {
        questionDBUniqueIdField.setValue(String.valueOf(answer.getBaselineQ8Id()));
        if(answer.getM1() != 0) noOfMembers.setValue(String.valueOf(answer.getM1()));
        houseLeaderFld.setValue(String.valueOf(answer.getM2()));
        medicalPref.setValue(getAnswerObj(answer.getM3(),answerMap.get("8.3")));
        for(int i=0;i<q85Layout.getComponentCount();i++) {
            if (i != 10) {
                HorizontalLayout layout = (HorizontalLayout) q85Layout.getComponent(i);
                ComboBox comboBox = (ComboBox) layout.getComponent(1);
                if(i == 0) comboBox.setValue(getYesNoObject("SN",answer.getM51()));
                if(i == 1 && answer.getM52() != 0) comboBox.setValue(String.valueOf(answer.getM52()));
                if(i == 2 && answer.getM53() != 0) comboBox.setValue(String.valueOf(answer.getM53()));
                if(i == 3) comboBox.setValue(getAnswerObj(answer.getM54(),answerMap.get("8.5.4")));
                if(i == 4) comboBox.setValue(getAnswerObj(answer.getM55(),answerMap.get("8.5.5")));
                if(i == 5) comboBox.setValue(getAnswerObj(answer.getM56(),answerMap.get("8.5.6")));
                if(i == 6) comboBox.setValue(getAnswerObj(answer.getM57(),answerMap.get("8.5.7")));
                if(i == 7) comboBox.setValue(getAnswerObj(answer.getM58(),answerMap.get("8.5.8")));
                if(i == 8) comboBox.setValue(getAnswerObj(answer.getM59(),answerMap.get("8.5.9")));
                if(i == 9) comboBox.setValue(getAnswerObj(answer.getM510(),answerMap.get("8.5.10")));
                if(i == 11) comboBox.setValue(getYesNoObject("SN",answer.getM511()));
                if(i == 12) comboBox.setValue(getYesNoObject("SN",answer.getM512()));
                if(i == 13) comboBox.setValue(getYesNoObject("SN",answer.getM513()));
                if(i == 14) comboBox.setValue(getYesNoObject("SN",answer.getM514()));
                if(i == 15) comboBox.setValue(getYesNoObject("SN",answer.getM515()));
                if(i == 16) comboBox.setValue(getYesNoObject("SN",answer.getM516()));
                if(i == 17) comboBox.setValue(getYesNoObject("SN",answer.getM517()));
            }
        }

        for (int i=0;i<answer84.size();i++){
            HorizontalLayout layout = (HorizontalLayout)q84Layout.getComponent(i+2);
            TextField relationship = (TextField) layout.getComponent(1);
            ComboBox age = (ComboBox) layout.getComponent(2);
            BaselineQ84 baselineQ84 = answer84.get(i);
            relationship.setValue(baselineQ84.getM2());
            age.setValue(String.valueOf(baselineQ84.getM3()));
        }
    }

    private int getId(Answer answer){
        return answer.getId();
    }

}
