package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ10;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab10 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q10Map;
    Map<String,String> fields;
    String language;
    VerticalLayout questionLayout;
    Survey survey;

    public Tab10(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q10Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ10AnswerList();
            q10Map = SinhalaMap.getQ10Map();
            fields = SinhalaMap.getQ10Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        Label q1Label = new Label(q10Map.get("10.1"));
        q1Label.setSizeFull();
        addComponents(q1Label);
        CheckBox noToAll = new CheckBox(fields.get("9.1"));
        addComponent(noToAll);
        noToAll.setStyleName("checkBoxMargin");
        noToAll.addValueChangeListener(event -> {
            setNoToAllCombo(event.getValue());
        });

        HorizontalLayout qHeaderLayout = new HorizontalLayout();
        qHeaderLayout.setSizeFull();
        Label tabletLabel = new Label(fields.get("a"));
        tabletLabel.setSizeFull();
        Label yesNoLabel = new Label(fields.get("b"));
        yesNoLabel.setSizeFull();
        Label startLabel = new Label(fields.get("c"));
        startLabel.setSizeFull();
        Label stopLabel = new Label(fields.get("d"));
        stopLabel.setSizeFull();
        Label documentLabel = new Label(fields.get("e"));
        documentLabel.setSizeFull();
        qHeaderLayout.addComponents(tabletLabel,yesNoLabel,startLabel,stopLabel,documentLabel);
        questionLayout = new VerticalLayout();
        questionLayout.setSizeFull();
        questionLayout.setMargin(new MarginInfo(false,false,false,true));
        addComponent(questionLayout);
        questionLayout.addComponent(qHeaderLayout);
        createTab8Questions(questionLayout,"Aspirin");
        createTab8Questions(questionLayout,"Statin");
        createTab8Questions(questionLayout,"Warfarin");
        createTab8Questions(questionLayout,"Enoxaparin");
        createTab8Questions(questionLayout,"Hormonal therapy");
        createTab8Questions(questionLayout,"Steroids");
        createTab8Questions(questionLayout,"Sodium valproate");
        createTab8Questions(questionLayout,"Amiodarone");
        createTab8Questions(questionLayout,"Tamoxifen");
        createTab8Questions(questionLayout,"Antipsychotics");
        createTab8Questions(questionLayout,"ACE Inhibitors");
        createTab8Questions(questionLayout,"Angiotensin receptor blockers");
        createTab8Questions(questionLayout,"Clomiphene Citrate");

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(10);
        });
        addComponent(nextBtn);
    }

    private void createTab8Questions(VerticalLayout tab,String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo =new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setItems(getYesNoAnswer(language));
        yesNoCombo.setWidth("90%");
        HorizontalLayout dependentQLayout = new HorizontalLayout();
        dependentQLayout.setSizeFull();
        ComboBox documentCombo = new ComboBox();
        documentCombo.setSizeFull();
        documentCombo.setItems(getAnwerObj(answerMap.get("9.1")));
        documentCombo.setDescription(getAnswerDesc(answerMap.get("9.1")));
        documentCombo.setTextInputAllowed(false);
        documentCombo.setWidth("90%");
        dependentQLayout.addComponents(documentCombo,getYearMonthComboLayout(),getYearMonthComboLayout());
        dependentQLayout.setEnabled(false);
        yesNoCombo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer == null || answer.getId() == 2){
                dependentQLayout.setEnabled(false);
            }
            else{
                dependentQLayout.setEnabled(true);
            }
        });
        layout.addComponents(questionLabel,yesNoCombo,dependentQLayout);
        layout.setExpandRatio(questionLabel,1);
        layout.setExpandRatio(yesNoCombo,1);
        layout.setExpandRatio(dependentQLayout,4);
        tab.addComponent(layout);
    }

    private HorizontalLayout getYearMonthComboLayout(){
        HorizontalLayout yearMonthLayout = new HorizontalLayout();
        yearMonthLayout.setSizeFull();
        ComboBox yearCombo = new ComboBox();
        yearCombo.setSizeFull();
        yearCombo.setItems(getStringList(1990,2019));
        ComboBox monthCombo = new ComboBox();
        monthCombo.setSizeFull();
        monthCombo.setItems(getStringList(1,12));
        yearMonthLayout.addComponents(yearCombo,monthCombo);
        //yearMonthLayout.setMargin(new MarginInfo(false,false,false,true));
        yearMonthLayout.setWidth("90%");
        return yearMonthLayout;
    }

    private String getYearMonthComboValue(HorizontalLayout layout){
        ComboBox hourCombo = (ComboBox) layout.getComponent(0);
        ComboBox minuteCombo = (ComboBox) layout.getComponent(1);
        String time = "";
        if(hourCombo.getValue() != null) time = String.valueOf(hourCombo.getValue()) + " ";
        time += minuteCombo.getValue() != null ? getMothFromIndex(Integer.parseInt(minuteCombo.getValue().toString())) : "";
        return time;
    }

    private void setNoToAllCombo(boolean isNo){

        for(int i = 1;i<questionLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)questionLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            Answer no = new Answer();
            no.setId(2);
            no.setDescription("2.නැත");
            if(isNo) {
                comboBox.setValue(no);
            }
            else {
                comboBox.clear();
            }
        }
    }

    public List<BaselineQ10> getAnswerQ10(int surveyId){
        List<BaselineQ10> answerList = new ArrayList<>();
        for(int i = 1;i<questionLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) questionLayout.getComponent(i);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            BaselineQ10 answer = new BaselineQ10();
            answer.setM1(i);
            answer.setSurveyId(surveyId);
            if(yesNoCombo != null && yesNoCombo.getValue() != null){
               int choice = getId((Answer)yesNoCombo.getValue());
               answer.setM2(choice);
               if(choice == 1){
                   HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
                   ComboBox docCombo = (ComboBox) dependentLayout.getComponent(0);
                   String start = getYearMonthComboValue((HorizontalLayout) dependentLayout.getComponent(1));
                   String end = getYearMonthComboValue((HorizontalLayout) dependentLayout.getComponent(2));
                   if(docCombo.getValue() != null )answer.setM3(getId((Answer)docCombo.getValue()));
                   if(!start.isEmpty() ) answer.setM4(start);
                   if(!end.isEmpty()) answer.setM5(end);
               }
            }
            answerList.add(answer);
        }
        return answerList;
    }

    private int getId(Answer answer){
        return answer.getId();
    }

    private String getMothFromIndex(int id){
        return Month.of(id).name();
    }
}
