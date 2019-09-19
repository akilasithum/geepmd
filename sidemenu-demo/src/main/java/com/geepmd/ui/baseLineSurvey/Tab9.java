package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ9;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab9 extends VerticalLayout{

    Map<String,List<String>> answerMap;
    Map<String,String> q9Map;
    Map<String,String> fields;
    String language;
    Survey survey;
    ComboBox privateTransportCombo;
    ComboBox ctbCombo;
    ComboBox privateBusCombo;
    ComboBox threeWheelCombo;
    VerticalLayout firstSetLayout;
    TextField questionDBUniqueIdField;

    public Tab9(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q9Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ9AnswerList();
            q9Map = SinhalaMap.getQ9Map();
            fields = SinhalaMap.getQ9Fields();
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
        Label timeLabel = new Label(fields.get("9"));
        addComponent(timeLabel);
        timeLabel.setStyleName("padHeader");
        setComponentAlignment(timeLabel,Alignment.MIDDLE_RIGHT);
        firstSetLayout = new VerticalLayout();
        firstSetLayout.setSizeFull();
        firstSetLayout.setMargin(false);
        addComponent(firstSetLayout);
        firstSetLayout.addComponent(setTabData(q9Map.get("9.1"),getTimeMap()));
        firstSetLayout.addComponent(setTabData(q9Map.get("9.2"),getTimeMap()));
        firstSetLayout.addComponent(setTabData(q9Map.get("9.3"),getTimeMap()));
        firstSetLayout.addComponent(setTabData(q9Map.get("9.4"),getTimeMap()));
        addComponent(new Label(q9Map.get("9.5")));
        privateTransportCombo = new ComboBox();
        privateTransportCombo.setSizeFull();
        privateTransportCombo.setTextInputAllowed(false);
        privateTransportCombo.setItems(getYesNoAnswer(language));
        addComponent(setTabData(q9Map.get("9.5.1"),privateTransportCombo));
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setVisible(false);
        layout.setMargin(false);
        addComponent(layout);
        ctbCombo = new ComboBox();
        ctbCombo.setSizeFull();
        ctbCombo.setItems(SurveyUtils.getAnwerObj(answerMap.get("9.5.1")));
        ctbCombo.setDescription(SurveyUtils.getAnswerDesc(answerMap.get("9.5.1")));
        ctbCombo.setTextInputAllowed(false);
        layout.addComponent(setTabData(q9Map.get("9.5.2"),ctbCombo));

        privateBusCombo = new ComboBox();
        privateBusCombo.setSizeFull();
        privateBusCombo.setItems(SurveyUtils.getAnwerObj(answerMap.get("9.5.1")));
        privateBusCombo.setDescription(SurveyUtils.getAnswerDesc(answerMap.get("9.5.1")));
        privateBusCombo.setTextInputAllowed(false);
        layout.addComponent(setTabData(q9Map.get("9.5.3"),privateBusCombo));

        threeWheelCombo = new ComboBox();
        threeWheelCombo.setSizeFull();
        threeWheelCombo.setItems(SurveyUtils.getAnwerObj(answerMap.get("9.5.1")));
        threeWheelCombo.setDescription(SurveyUtils.getAnswerDesc(answerMap.get("9.5.1")));
        threeWheelCombo.setTextInputAllowed(false);
        layout.addComponent(setTabData(q9Map.get("9.5.4"),threeWheelCombo));

        privateTransportCombo.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer != null && answer.getId() == 1){
                layout.setVisible(true);
            }
            else{
                layout.setVisible(false);
            }
        });
        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(9);
        });
        addComponent(nextBtn);
    }

    private HorizontalLayout getTimeMap(){
        HorizontalLayout yearMonthLayout = new HorizontalLayout();
        yearMonthLayout.setSizeFull();
        TextField hourCombo = new TextField();
        hourCombo.setSizeFull();
        hourCombo.addValueChangeListener(event -> {
            if (event.getValue() != null && !event.getValue().isEmpty()) {
                if (!isInteger(event.getValue())) {
                    Notification.show("Value should be between 0 and 10");
                    hourCombo.clear();
                }
                else if (Integer.parseInt(event.getValue()) < 0 || Integer.parseInt(event.getValue()) > 10) {
                    Notification.show("Value should be between 0 and 10");
                    hourCombo.clear();
                }
            }
        });
        //hourCombo.setItems(getStringList(0,10));
        TextField minuteCombo = new TextField();
        minuteCombo.setSizeFull();
        minuteCombo.addValueChangeListener(event -> {
            if (event.getValue() != null && !event.getValue().isEmpty()) {
                if (!isInteger(event.getValue())) {
                    Notification.show("Value should be between 0 and 59");
                    minuteCombo.clear();
                }
                else if (Integer.parseInt(event.getValue()) < 0 || Integer.parseInt(event.getValue()) > 59) {
                    Notification.show("Value should be between 0 and 59");
                    minuteCombo.clear();
                }
            }
        });
        //minuteCombo.setItems(getStringList(0,60));
        yearMonthLayout.addComponents(hourCombo,minuteCombo);
        // yearMonthLayout.setMargin(new MarginInfo(false,false,false,true));
        return yearMonthLayout;
    }

    private boolean isInteger(String val){
        try{
            int intVal = Integer.parseInt(val);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public BaselineQ9 getQ9Answers(int surveyId) {
        BaselineQ9 answer = new BaselineQ9();
        answer.setSurveyId(surveyId);
        /*if(questionDBUniqueIdField.getValue() != null && !questionDBUniqueIdField.getValue().isEmpty()){
            answer.setBaselineQ9Id(Integer.parseInt(questionDBUniqueIdField.getValue()));
        }*/
        for(int i = 0;i<firstSetLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)((HorizontalLayout)firstSetLayout.getComponent(i)).getComponent(1);
            TextField hourCombo = (TextField) layout.getComponent(0);
            TextField minuteCombo = (TextField) layout.getComponent(1);
            String time = "";
            if(hourCombo.getValue() != null && !hourCombo.getValue().isEmpty()) time = String.valueOf(hourCombo.getValue()) + "Hr";
            time += (minuteCombo.getValue() != null && !minuteCombo.getValue().isEmpty()) ?
                    (String.valueOf(minuteCombo.getValue()) + "Min") : ("00 Min");
            if(i == 0) answer.setM1(time);
            if(i == 1) answer.setM2(time);
            if(i == 2) answer.setM3(time);
            if(i == 3) answer.setM4(time);
        }
        if(privateTransportCombo.getValue() != null) {
            answer.setM51(getId((Answer) privateTransportCombo.getValue(),false));
            if(getId((Answer) privateTransportCombo.getValue(),false) == 1){
                if(ctbCombo.getValue() != null) answer.setM52(getId((Answer) ctbCombo.getValue(),true));
                if(privateBusCombo.getValue() != null) answer.setM53(getId((Answer) privateBusCombo.getValue(),true));
                if(threeWheelCombo.getValue() != null) answer.setM54(getId((Answer) threeWheelCombo.getValue(),true));
            }
            else{
                answer.setM52(8888);
                answer.setM53(8888);
                answer.setM54(8888);
            }
        }

        return answer;
    }
    private int getId(Answer answer,boolean isReverse){
        if(isReverse)
            return answerReverse(answer.getId());
        else return answer.getId();
    }

    public void setEditData(BaselineQ9 answer) {
        questionDBUniqueIdField.setValue(String.valueOf(answer.getBaselineQ9Id()));
        for(int i = 0;i<firstSetLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)((HorizontalLayout)firstSetLayout.getComponent(i)).getComponent(1);
            TextField hourCombo = (TextField) layout.getComponent(0);
            TextField minuteCombo = (TextField) layout.getComponent(1);
            String time = "";
            if(i == 0 && answer.getM1() != null) time = answer.getM1();
            if(i == 1 && answer.getM2() != null) time = answer.getM2();
            if(i == 2 && answer.getM3() != null) time = answer.getM3();
            if(i == 3 && answer.getM4() != null) time = answer.getM4();

            if(!time.isEmpty()){
                if(time.contains("Hr")) {
                    String[] timeArr = time.split("Hr");
                    hourCombo.setValue(timeArr[0]);
                    String[] minute = timeArr[1].split("Min");
                    if(!minute[0].trim().equals("00"))
                        minuteCombo.setValue(minute[0]);

                }
                else{
                    String[] minute = time.split("Min");
                    if(!minute[0].trim().equals("00"))
                        minuteCombo.setValue(minute[0]);
                }
            }
        }
        privateTransportCombo.setValue(getYesNoObject("SN",answer.getM51()));
        if(answer.getM51() == 1){
            // List<String> answerList = answerMap.get("9.5.1");
            //Collections.reverse(answerList);
            ctbCombo.setValue(getAnswerObj(answerReverse(answer.getM52()),answerMap.get("9.5.1")));
            privateBusCombo.setValue(getAnswerObj(answerReverse(answer.getM53()),answerMap.get("9.5.1")));
            threeWheelCombo.setValue(getAnswerObj(answerReverse(answer.getM54()),answerMap.get("9.5.1")));
        }

    }

    public void clearFields() {
        questionDBUniqueIdField.clear();
        for(int i = 0;i<firstSetLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)((HorizontalLayout)firstSetLayout.getComponent(i)).getComponent(1);
            TextField hourCombo = (TextField) layout.getComponent(0);
            TextField minuteCombo = (TextField) layout.getComponent(1);
            hourCombo.clear();
            minuteCombo.clear();
        }
        privateTransportCombo.clear();
        ctbCombo.clear();
        privateBusCombo.clear();
        threeWheelCombo.clear();
    }

    private int answerReverse(int answer){
        switch (answer){
            case 1 : return 5;
            case 2: return 4;
            case 3: return 3;
            case 4: return 2;
            case 5 : return 1;
            default: return 0;
        }

    }
}
