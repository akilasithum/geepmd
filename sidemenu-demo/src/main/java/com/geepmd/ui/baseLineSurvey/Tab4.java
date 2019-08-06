package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ4;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.text.ParseException;
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
    TextField questionDBUniqueIdField;

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
        questionDBUniqueIdField = new TextField();
        questionDBUniqueIdField.setVisible(false);
        addComponent(questionDBUniqueIdField);

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
        if(questionDBUniqueIdField.getValue() != null && !questionDBUniqueIdField.getValue().isEmpty()){
            answer.setBaselineQ4Id(Integer.parseInt(questionDBUniqueIdField.getValue()));
        }
        if(pregnancyPlannedCombo.getValue() != null) {
            answer.setM1(getId((Answer)pregnancyPlannedCombo.getValue()));
            if(getId((Answer)pregnancyPlannedCombo.getValue()) == 1){
                if(preConceptionCombo.getValue() != null) {
                    answer.setM2(getId((Answer)preConceptionCombo.getValue()));
                    if(getId((Answer)preConceptionCombo.getValue()) == 1){
                        if(screenCombo.getValue() != null) answer.setM3(getId((Answer)screenCombo.getValue()));
                        if(heartCheckCombo.getValue() != null) answer.setM4(getId((Answer)heartCheckCombo.getValue()));
                    }
                    else{
                        answer.setM3(8888);
                        answer.setM4(8888);
                    }
                }
                if(lmpCombo.getValue() != null){
                    answer.setM5(getId((Answer)lmpCombo.getValue()));
                    if(getId((Answer)lmpCombo.getValue()) == 1){
                        if(folicAcidMonthCombo.getValue() != null) answer.setM6(getId((Answer)folicAcidMonthCombo.getValue()));
                    }
                    else {
                        answer.setM6(8888);
                    }
                }
            }
            else {
                answer.setM2(8888);
                answer.setM3(8888);
                answer.setM4(8888);
                answer.setM5(8888);
                answer.setM6(8888);
            }
        }

        if(mensesDate.getValue() != null) answer.setM7(getDateStr(mensesDate.getValue()));
        if(pregConfirmCombo.getValue() != null) answer.setM8(getId((Answer)pregConfirmCombo.getValue()));
        if(deliveryPreferCombo.getValue() != null) answer.setM9(getId((Answer)deliveryPreferCombo.getValue()));
        if(delPlaceCombo.getValue() != null) answer.setM10(getId((Answer)delPlaceCombo.getValue()));
        if(folicAcidNowCombo.getValue() != null) {
            answer.setM11(getId((Answer)folicAcidNowCombo.getValue()));
            if(getId((Answer)folicAcidNowCombo.getValue()) == 1){
                if(folicWeekCombo.getValue() != null) answer.setM12(Integer.parseInt(folicWeekCombo.getValue().toString()));
            }
            else {
                answer.setM12(8888);
            }
        }

        return answer;
    }

    private String getDateStr(LocalDate date){
        Date dateVal = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(dateVal);
    }

    public void setEditData(BaselineQ4 answer){
        questionDBUniqueIdField.setValue(String.valueOf(answer.getBaselineQ4Id()));
        pregnancyPlannedCombo.setValue(getYesNoObject("SN",answer.getM1()));
        preConceptionCombo.setValue(getAnswerObj(answer.getM2(),answerMap.get("4.2")));
        screenCombo.setValue(getYesNoObject("SN",answer.getM3()));
        heartCheckCombo.setValue(getYesNoObject("SN",answer.getM4()));
        lmpCombo.setValue(getYesNoObject("SN",answer.getM5()));
        folicAcidMonthCombo.setValue(getAnswerObj(answer.getM6(),answerMap.get("4.6")));
        if(answer.getM7() != null && !answer.getM7().trim().isEmpty()) {
            Date mensesDateVal = getDateFromStr(answer.getM7());
            if (mensesDateVal != null) {
                LocalDate motherBday = mensesDateVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                mensesDate.setValue(motherBday);
            }
        }
        pregConfirmCombo.setValue(getAnswerObj(answer.getM8(),answerMap.get("4.8")));
        deliveryPreferCombo.setValue(getAnswerObj(answer.getM9(),answerMap.get("4.9")));
        delPlaceCombo.setValue(getAnswerObj(answer.getM10(),answerMap.get("4.10")));
        folicAcidNowCombo.setValue(getYesNoObject("SN",answer.getM11()));
        if(answer.getM12() != 0) folicWeekCombo.setValue(String.valueOf(answer.getM12()));

    }

    private Date getDateFromStr(String str){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
