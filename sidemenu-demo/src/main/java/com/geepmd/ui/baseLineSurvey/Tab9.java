package com.geepmd.ui.baseLineSurvey;

import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

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

        Label timeLabel = new Label(fields.get("9"));
        addComponent(timeLabel);
        timeLabel.setStyleName("padHeader");
        setComponentAlignment(timeLabel,Alignment.MIDDLE_RIGHT);
        addComponent(setTabData(q9Map.get("9.1"),getTimeMap()));
        addComponent(setTabData(q9Map.get("9.2"),getTimeMap()));
        addComponent(setTabData(q9Map.get("9.3"),getTimeMap()));
        addComponent(setTabData(q9Map.get("9.4"),getTimeMap()));
        addComponent(new Label(q9Map.get("9.5")));
        privateTransportCombo = new ComboBox();
        privateTransportCombo.setSizeFull();
        privateTransportCombo.setItems(getYesNoAnswer(language));
        addComponent(setTabData(q9Map.get("9.5.1"),privateTransportCombo));
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setVisible(false);
        layout.setMargin(false);
        addComponent(layout);
        ctbCombo = new ComboBox();
        ctbCombo.setSizeFull();
        ctbCombo.setItems(answerMap.get("9.5.1"));
        layout.addComponent(setTabData(q9Map.get("9.5.2"),ctbCombo));

        privateBusCombo = new ComboBox();
        privateBusCombo.setSizeFull();
        privateBusCombo.setItems(answerMap.get("9.5.1"));
        layout.addComponent(setTabData(q9Map.get("9.5.3"),privateBusCombo));

        threeWheelCombo = new ComboBox();
        threeWheelCombo.setSizeFull();
        threeWheelCombo.setItems(answerMap.get("9.5.1"));
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
        ComboBox hourCombo = new ComboBox();
        hourCombo.setSizeFull();
        hourCombo.setItems(getStringList(0,10));
        ComboBox minuteCombo = new ComboBox();
        minuteCombo.setSizeFull();
        minuteCombo.setItems(getStringList(0,60));
        yearMonthLayout.addComponents(hourCombo,minuteCombo);
        yearMonthLayout.setMargin(new MarginInfo(false,false,false,true));
        return yearMonthLayout;
    }
}
