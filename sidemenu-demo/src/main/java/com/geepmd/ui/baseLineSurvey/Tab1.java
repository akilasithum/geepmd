package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ1;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getStringList;

public class Tab1 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> fields;
    DateField motherBDayFld;
    DateField fatherBDayFld;
    ComboBox ethnicityComboBoxMother;
    ComboBox ethnicityComboBoxFather;
    ComboBox understandingLevelComboMother;
    ComboBox understandingLevelComboFather;
    ComboBox religionMotherCombo;
    ComboBox religionFatherCombo;
    ComboBox schoolGradeMother;
    ComboBox schoolGradeFather;
    ComboBox afterALMother;
    ComboBox afterALFather;
    ComboBox sexualEduLMother;
    ComboBox sexualEduFather;
    ComboBox maritualStatusCombo;
    ComboBox marriedYearCombo;
    ComboBox marriedMonthCombo;
    Survey survey;

    public Tab1(String language,Survey survey){
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
        }
        else{
            answerMap = SinhalaMap.getQ1AnswerList();
            fields = SinhalaMap.getQ1Fields();
        }
        this.survey = survey;
        createLayout(language);
        setSizeFull();
    }

    private void createLayout(String language){
        Label motherLabel = new Label(fields.get("1"));
        motherLabel.setSizeFull();
        Label fatherLabel = new Label(fields.get("2"));
        fatherLabel.setSizeFull();
        Map<String,String> languangeMap;
        if(language.equals("EN")){
            languangeMap = EnglishMap.getquestion1Map();
        }
        else{
            languangeMap = SinhalaMap.getquestion1Map();
        }

        setTabData(" ",motherLabel,fatherLabel);
        motherBDayFld = new DateField();
        fatherBDayFld = new DateField();
        setTabData(languangeMap.get("1.1"),motherBDayFld,fatherBDayFld);

        ethnicityComboBoxMother = new ComboBox();
        ethnicityComboBoxFather = new ComboBox();
        ethnicityComboBoxMother.setItems(getQ2Answer("1.2"));
        ethnicityComboBoxMother.setDescription(getAnswerDesc("1.2"));
        ethnicityComboBoxFather.setItems(getQ2Answer("1.2"));
        ethnicityComboBoxFather.setDescription(getAnswerDesc("1.2"));
        ethnicityComboBoxMother.setTextInputAllowed(false);
        ethnicityComboBoxFather.setTextInputAllowed(false);
        setTabData(languangeMap.get("1.2"),ethnicityComboBoxMother,ethnicityComboBoxFather);

        understandingLevelComboMother = new ComboBox();
        understandingLevelComboMother.setEnabled(false);
        understandingLevelComboFather = new ComboBox();
        understandingLevelComboFather.setEnabled(false);
        understandingLevelComboMother.setItems(getQ2Answer("1.3"));
        understandingLevelComboFather.setItems(getQ2Answer("1.3"));
        understandingLevelComboMother.setDescription(getAnswerDesc("1.3"));
        understandingLevelComboFather.setDescription(getAnswerDesc("1.3"));
        understandingLevelComboMother.setTextInputAllowed(false);
        understandingLevelComboFather.setTextInputAllowed(false);
        setTabData(languangeMap.get("1.3"),
                understandingLevelComboMother,understandingLevelComboFather);

        ethnicityComboBoxMother.addValueChangeListener(event -> {
            Answer answer = (Answer)event.getValue();
            if(answer == null || answer.getId() == 1){
                understandingLevelComboMother.setEnabled(false);
            }
            else{
                understandingLevelComboMother.setEnabled(true);
            }
        });

        ethnicityComboBoxFather.addValueChangeListener(event -> {
            Answer answer = (Answer)event.getValue();
            if(answer == null || answer.getId() == 1){
                understandingLevelComboFather.setEnabled(false);
            }
            else{
                understandingLevelComboFather.setEnabled(true);
            }
        });

        religionMotherCombo = new ComboBox();
        religionFatherCombo = new ComboBox();
        religionMotherCombo.setItems(getQ2Answer("1.4"));
        religionFatherCombo.setItems(getQ2Answer("1.4"));
        setTabData(languangeMap.get("1.4"),religionMotherCombo,religionFatherCombo);
        religionMotherCombo.setTextInputAllowed(false);
        religionFatherCombo.setTextInputAllowed(false);

        schoolGradeMother = new ComboBox();
        schoolGradeFather = new ComboBox();
        schoolGradeMother.setItems(getStringList(0,13));
        schoolGradeFather.setItems(getStringList(0,13));
        setTabData(languangeMap.get("1.5"),schoolGradeMother,schoolGradeFather);
        schoolGradeMother.setTextInputAllowed(false);
        schoolGradeFather.setTextInputAllowed(false);

        afterALMother = new ComboBox();
        afterALFather = new ComboBox();
        afterALMother.setItems(getQ2Answer("1.6"));
        afterALFather.setItems(getQ2Answer("1.6"));
        afterALMother.setDescription(getAnswerDesc("1.6"));
        afterALFather.setDescription(getAnswerDesc("1.6"));
        setTabData(languangeMap.get("1.6"),afterALMother,afterALFather);
        //setTabData(tab1,"1.6 If you passed A/L, what is the education level obtained after A/L s?",afterALMother,afterALFather);
        afterALMother.setTextInputAllowed(false);
        afterALFather.setTextInputAllowed(false);

        List<Answer> yesNoList = new ArrayList<>();
        yesNoList.addAll(getQ2Answer("1.7"));
        sexualEduLMother = new ComboBox();
        sexualEduFather = new ComboBox();
        sexualEduLMother.setItems(yesNoList);
        sexualEduFather.setItems(yesNoList);
        setTabData(languangeMap.get("1.7"),sexualEduLMother,sexualEduFather);
        sexualEduLMother.setTextInputAllowed(false);
        sexualEduFather.setTextInputAllowed(false);

        maritualStatusCombo = new ComboBox();
        maritualStatusCombo.setItems(getQ2Answer("1.8"));
        setTabData(languangeMap.get("1.8"),maritualStatusCombo,null);
        maritualStatusCombo.setTextInputAllowed(false);

        marriedYearCombo = new ComboBox("Years");
        marriedYearCombo.setSizeFull();
        marriedYearCombo.setItems(getStringList(0,30));
        marriedMonthCombo = new ComboBox("Months");
        marriedMonthCombo.setSizeFull();
        marriedMonthCombo.setItems(getStringList(1,12));
        Label label = new Label(languangeMap.get("1.9"));
        label.setSizeFull();
        HorizontalLayout marriedAgeLayout = new HorizontalLayout();
        marriedAgeLayout.setSizeFull();
        marriedAgeLayout.addComponents(label,marriedYearCombo,marriedMonthCombo);
        marriedAgeLayout.setExpandRatio(label,3);
        marriedAgeLayout.setExpandRatio(marriedYearCombo,1);
        marriedAgeLayout.setExpandRatio(marriedMonthCombo,1);
        maritualStatusCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {
            Answer answer = (Answer)valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                marriedAgeLayout.setVisible(true);
            }
            else{
                marriedAgeLayout.setVisible(false);
            }
        });
        addComponent(marriedAgeLayout);
        marriedAgeLayout.setVisible(false);

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(1);
        });
        addComponent(nextBtn);
    }


    private List<Answer> getQ2Answer(String question){
        List<Answer> answerList = new ArrayList<>();
        int i = 1;
        for(String str : answerMap.get(question)){
            Answer answer = new Answer();
            answer.setId(i);
            answer.setDescription(str);
            answerList.add(answer);
            i++;
        }
        return answerList;
    }

    private String getAnswerDesc(String question){
        String desc = "";
        for(String str : answerMap.get(question)){
            desc += str + "\n";
        }
        return desc;
    }

    private HorizontalLayout setTabData(String question, Component comp1,Component comp2){
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLable = new Label(question);
        emptyLable.setSizeFull();
        comp1.setSizeFull();

        if(comp2 != null){
            comp2.setSizeFull();
            headerLayout.addComponents(emptyLable,comp1,comp2);
            headerLayout.setExpandRatio(emptyLable,3);
            headerLayout.setExpandRatio(comp1,1);
            headerLayout.setExpandRatio(comp2,1);
        }
        else{
            headerLayout.addComponents(emptyLable,comp1);
            headerLayout.setExpandRatio(emptyLable,3);
            headerLayout.setExpandRatio(comp1,2);
        }
        addComponent(headerLayout);
        return headerLayout;
    }

    public BaselineQ1 getAnswers(int motherId){

        BaselineQ1 answer = new BaselineQ1();
        answer.setMotherId(motherId);
        if(motherBDayFld.getValue() != null)answer.setM1(Date.from(motherBDayFld.getValue().
                atStartOfDay(ZoneId.systemDefault()).toInstant()));
        if(fatherBDayFld.getValue() != null)answer.setF1(Date.from(fatherBDayFld.getValue().
                atStartOfDay(ZoneId.systemDefault()).toInstant()));
        if(ethnicityComboBoxMother.getValue() != null) answer.setM2(((Answer) ethnicityComboBoxMother.getValue()).getId());
        if(ethnicityComboBoxFather.getValue() != null) answer.setF2(((Answer) ethnicityComboBoxFather.getValue()).getId());
        if(understandingLevelComboMother.getValue() != null) answer.setM3(((Answer) understandingLevelComboMother.getValue()).getId());
        if(understandingLevelComboFather.getValue() != null) answer.setF3(((Answer) understandingLevelComboFather.getValue()).getId());
        if(religionMotherCombo.getValue() != null) answer.setM4(((Answer) religionMotherCombo.getValue()).getId());
        if(religionFatherCombo.getValue() != null) answer.setF4(((Answer) religionFatherCombo.getValue()).getId());
        if(schoolGradeMother.getValue() != null) answer.setM5(Integer.parseInt(schoolGradeMother.getValue().toString()));
        if(schoolGradeFather.getValue() != null) answer.setF5(Integer.parseInt(schoolGradeFather.getValue().toString()));
        if(afterALMother.getValue() != null) answer.setM6(((Answer) afterALMother.getValue()).getId());
        if(sexualEduLMother.getValue() != null) answer.setM7(((Answer) sexualEduLMother.getValue()).getId());
        if(maritualStatusCombo.getValue() != null) answer.setM8(((Answer) maritualStatusCombo.getValue()).getId());
        String marriedYear = marriedYearCombo.getValue() != null ? String.valueOf(marriedYearCombo.getValue()) : "";
        String marriedMonth = marriedMonthCombo.getValue() != null ? String.valueOf(marriedMonthCombo.getValue()) : "";
        if(schoolGradeMother.getValue() != null) answer.setM9(marriedYear +" " + marriedMonth);
        return answer;
    }
}
