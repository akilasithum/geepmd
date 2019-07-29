package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ4;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab4 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q4Map;
    String language;
    ComboBox preConceptionCombo;
    ComboBox screenCombo;
    ComboBox heartCheckCombo;
    ComboBox pregnancyPlannedCombo;
    ComboBox lmpCombo;
    ComboBox folicAcidMonthCombo;
    DateField mensesDate;
    ComboBox pregConfirmCombo;
    ComboBox deliveryPreferCombo;
    ComboBox delPlaceCombo;
    ComboBox folicAcidNowCombo;
    ComboBox folicWeekCombo;
    Survey survey;

    public Tab4(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q4Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ4AnswerList();
            q4Map = SinhalaMap.getQ4Map();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){

        pregnancyPlannedCombo = new ComboBox();
        pregnancyPlannedCombo.setItems(getYesNoAnswer(language));
        pregnancyPlannedCombo.setTextInputAllowed(false);
        addComponent(setTabData(q4Map.get("4.1"),pregnancyPlannedCombo));

        preConceptionCombo = new ComboBox();

        preConceptionCombo.setItems(getAnwerObj(answerMap.get("4.2")));
        HorizontalLayout preConceptionLayout = setTabData(q4Map.get("4.2"),preConceptionCombo);
        preConceptionCombo.setTextInputAllowed(false);
        addComponent(preConceptionLayout);
        preConceptionLayout.setVisible(false);

        HorizontalLayout screenLayout = new HorizontalLayout();
        screenLayout.setSizeFull();
        Label q42Label = new Label(q4Map.get("4.3"));
        q42Label.setSizeFull();
        screenCombo = new ComboBox();
        screenCombo.setItems(getYesNoAnswer(language));
        screenCombo.setSizeFull();
        screenCombo.setTextInputAllowed(false);
        screenLayout.addComponents(q42Label,screenCombo);
        screenLayout.setExpandRatio(q42Label,3);
        screenLayout.setExpandRatio(screenCombo,1);
        addComponent(screenLayout);
        screenLayout.setVisible(false);

        HorizontalLayout heartChecked = new HorizontalLayout();
        heartChecked.setSizeFull();
        Label q43Label = new Label(q4Map.get("4.4"));
        q43Label.setSizeFull();
        heartCheckCombo = new ComboBox();
        heartCheckCombo.setItems(getYesNoAnswer(language));
        heartCheckCombo.setSizeFull();
        heartCheckCombo.setTextInputAllowed(false);
        heartChecked.addComponents(q43Label,heartCheckCombo);
        heartChecked.setExpandRatio(q43Label,3);
        heartChecked.setExpandRatio(heartCheckCombo,1);
        addComponent(heartChecked);
        heartChecked.setVisible(false);
        preConceptionCombo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && (answer.getId() == 1 || answer.getId() == 2)){
                screenLayout.setVisible(true);
                heartChecked.setVisible(true);
            }
            else{
                screenLayout.setVisible(false);
                heartChecked.setVisible(false);
            }
        });

        lmpCombo = new ComboBox();
        lmpCombo.setItems(getYesNoAnswer(language));
        lmpCombo.setTextInputAllowed(false);
        HorizontalLayout lmpLayout = setTabData(q4Map.get("4.5"),lmpCombo);
        addComponent(lmpLayout);
        lmpLayout.setVisible(false);

        folicAcidMonthCombo = new ComboBox();
        folicAcidMonthCombo.setItems(getAnwerObj(answerMap.get("4.6")));
        folicAcidMonthCombo.setTextInputAllowed(false);
        dependentLayoutAdd(lmpCombo,folicAcidMonthCombo,q4Map.get("4.6"));

        pregnancyPlannedCombo.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer != null && (answer.getId() == 1)){
                preConceptionLayout.setVisible(true);
                lmpLayout.setVisible(true);
            }
            else{
                preConceptionLayout.setVisible(false);
                lmpLayout.setVisible(false);
            }
        });

        mensesDate = new DateField();
        addComponent(setTabData(q4Map.get("4.7"),mensesDate));

        pregConfirmCombo = new ComboBox();
        pregConfirmCombo.setItems(getAnwerObj(answerMap.get("4.8")));
        pregConfirmCombo.setTextInputAllowed(false);
        addComponent(setTabData(q4Map.get("4.8"),pregConfirmCombo));

        deliveryPreferCombo = new ComboBox();
        deliveryPreferCombo.setItems(getAnwerObj(answerMap.get("4.9")));
        deliveryPreferCombo.setTextInputAllowed(false);
        addComponent(setTabData(q4Map.get("4.9"),deliveryPreferCombo));

        delPlaceCombo = new ComboBox();
        delPlaceCombo.setItems(getAnwerObj(answerMap.get("4.10")));
        delPlaceCombo.setTextInputAllowed(false);
        addComponent(setTabData(q4Map.get("4.10"),delPlaceCombo));


        folicAcidNowCombo = new ComboBox();
        folicAcidNowCombo.setItems(getYesNoAnswer(language));
        folicAcidNowCombo.setTextInputAllowed(false);
        addComponent(setTabData(q4Map.get("4.11"),folicAcidNowCombo));

        folicWeekCombo = new ComboBox();
        folicWeekCombo.setItems(getStringList(1,30));
        folicWeekCombo.setTextInputAllowed(false);
        dependentLayoutAdd(folicAcidNowCombo,folicWeekCombo,q4Map.get("4.12"));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(4);
        });
        addComponent(nextBtn);
    }

    private void dependentLayoutAdd(ComboBox mainComb,ComboBox dependentCombo,String labelVal){
        HorizontalLayout screenLayout = new HorizontalLayout();
        screenLayout.setSizeFull();
        Label q42Label = new Label(labelVal);
        q42Label.setSizeFull();
        dependentCombo.setSizeFull();
        screenLayout.addComponents(q42Label,dependentCombo);
        screenLayout.setExpandRatio(q42Label,3);
        screenLayout.setExpandRatio(dependentCombo,1);
        addComponent(screenLayout);
        screenLayout.setVisible(false);
        mainComb.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                screenLayout.setVisible(true);
            }
            else{
                screenLayout.setVisible(false);
            }
        });
    }

    public BaselineQ4 getAnswers(int motherId) {

        BaselineQ4 answer = new BaselineQ4();
        answer.setSurveyId(motherId);
        if(preConceptionCombo.getValue() != null) answer.setM1(getId((Answer)preConceptionCombo.getValue()));
        if(screenCombo.getValue() != null) answer.setM2(getId((Answer)screenCombo.getValue()));
        if(heartCheckCombo.getValue() != null) answer.setM3(getId((Answer)heartCheckCombo.getValue()));
        if(pregnancyPlannedCombo.getValue() != null) answer.setM4(getId((Answer)pregnancyPlannedCombo.getValue()));
        if(lmpCombo.getValue() != null) answer.setM5(getId((Answer)lmpCombo.getValue()));
        if(folicAcidMonthCombo.getValue() != null) answer.setM6(getId((Answer)folicAcidMonthCombo.getValue()));
        if(mensesDate.getValue() != null) answer.setM7(getDateStr(mensesDate.getValue()));
        if(pregConfirmCombo.getValue() != null) answer.setM8(getId((Answer)pregConfirmCombo.getValue()));
        if(deliveryPreferCombo.getValue() != null) answer.setM9(getId((Answer)deliveryPreferCombo.getValue()));
        if(delPlaceCombo.getValue() != null) answer.setM10(getId((Answer)delPlaceCombo.getValue()));
        if(folicAcidNowCombo.getValue() != null) answer.setM11(getId((Answer)folicAcidNowCombo.getValue()));
        if(folicWeekCombo.getValue() != null) answer.setM12(Integer.parseInt(folicWeekCombo.getValue().toString()));
        return answer;
    }

    private String getDateStr(LocalDate date){
        Date dateVal = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(dateVal);
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
