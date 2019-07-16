package com.geepmd.ui.baseLineSurvey;

import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab9 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q9Map;
    Map<String,String> fields;
    String language;
    VerticalLayout questionLayout;

    public Tab9(String language){
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
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        Label q1Label = new Label(q9Map.get("9.1"));
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
    }

    private void createTab8Questions(VerticalLayout tab,String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo =new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(getYesNoAnswer(language));
        yesNoCombo.setWidth("70%");
        HorizontalLayout dependentQLayout = new HorizontalLayout();
        dependentQLayout.setSizeFull();
        ComboBox documentCombo = new ComboBox();
        documentCombo.setSizeFull();
        documentCombo.setItems(getAnwerObj(answerMap.get("9.1")));
        documentCombo.setDescription(getAnswerDesc(answerMap.get("9.1")));
        documentCombo.setWidth("70%");
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
        layout.setExpandRatio(dependentQLayout,3);
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
        yearMonthLayout.setMargin(new MarginInfo(false,false,false,true));
        return yearMonthLayout;
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
}
