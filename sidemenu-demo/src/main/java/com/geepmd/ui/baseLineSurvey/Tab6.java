package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ6;
import com.geepmd.entity.BaselineQ62;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.addons.ComboBoxMultiselect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab6 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q6Map;
    Map<String,String> fields;
    String language;
    VerticalLayout firstQAnswerLayout;
    VerticalLayout secondQAnswerLayout;
    ComboBox q63Combo;
    ComboBoxMultiselect<Answer> anemiaCombo;
    ComboBox monthsCombo65;
    ComboBox yearCombo;
    ComboBox monthCombo;
    ComboBox investigationCombo;
    ComboBox thalassemiaCombo;
    ComboBox thalassemiaYesCombo;
    ComboBox bleedingCombo;
    ComboBox blackCombo;
    ComboBox wormCombo;
    Survey survey;

    public Tab6(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q6Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ6AnswerList();
            q6Map = SinhalaMap.getQ6Map();
            fields = SinhalaMap.getQ6Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        Label firstQ = new Label(q6Map.get("6.1"));
        firstQ.setSizeFull();
        addComponent(firstQ);
        firstQAnswerLayout = new VerticalLayout();
        firstQAnswerLayout.setSizeFull();
        firstQAnswerLayout.setMargin(new MarginInfo(false,true));
        firstQAnswerLayout.addComponents(getQ61Questions(fields.get("6.11")),getQ61Questions(fields.get("6.12")),
                getQ61Questions(fields.get("6.13")),getQ61Questions(fields.get("6.14")));
        addComponent(firstQAnswerLayout);

        Label secondQ = new Label(q6Map.get("6.2"));
        addComponent(secondQ);

        setQ62Header();
        secondQAnswerLayout = new VerticalLayout();
        secondQAnswerLayout.setSizeFull();
        secondQAnswerLayout.setMargin(new MarginInfo(false,true));
        addComponent(secondQAnswerLayout);
        secondQAnswerLayout.addComponent(setQ62(fields.get("a")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("b")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("c")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("d")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("e")));
        secondQAnswerLayout.addComponent( setQ62(fields.get("f")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("g")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("h")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("i")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("j")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("k")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("l")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("m")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("n")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("o")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("p")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("q")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("r")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("s")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("t")));
        secondQAnswerLayout.addComponent(setQ62(fields.get("u")));

        HorizontalLayout q63Layout = new HorizontalLayout();
        q63Layout.setSizeFull();
        Label q63Label = new Label(q6Map.get("6.3"));
        q63Label.setSizeFull();
        q63Combo = new ComboBox();
        q63Combo.setSizeFull();
        q63Combo.setItems(getAnwerObj(answerMap.get("6.3")));
        q63Combo.setDescription(getAnswerDesc(answerMap.get("6.3")));
        q63Combo.setTextInputAllowed(false);
        q63Layout.addComponents(q63Label,q63Combo);
        q63Layout.setExpandRatio(q63Label,3);
        q63Layout.setExpandRatio(q63Combo,1);
        addComponent(q63Layout);

        VerticalLayout dependentLayout = new VerticalLayout();
        dependentLayout.setSizeFull();
        addComponent(dependentLayout);
        dependentLayout.setMargin(false);
        anemiaCombo =new ComboBoxMultiselect();
        anemiaCombo.setItems(getAnwerObj(answerMap.get("6.4")));
        anemiaCombo.setDescription(getAnswerDesc(answerMap.get("6.4")));
        anemiaCombo.setTextInputAllowed(false);
        dependentLayout.addComponent(setTabData(q6Map.get("6.4"),anemiaCombo));
        dependentLayout.setVisible(false);
        q63Combo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer == null || answer.getId() == 1 ){
                dependentLayout.setVisible(false);
            }
            else{
                dependentLayout.setVisible(true);
            }
        });

        monthsCombo65 = new ComboBox();
        monthsCombo65.setSizeFull();
        monthsCombo65.setItems(getStringList(0,24));
        monthsCombo65.setTextInputAllowed(false);
        dependentLayout.addComponent(setTabData(q6Map.get("6.5"), monthsCombo65));

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        yearCombo = new ComboBox(fields.get("years"));
        yearCombo.setSizeFull();
        yearCombo.setItems(getStringList(0,20));
        monthCombo = new ComboBox(fields.get("month"));
        monthCombo.setItems(getStringList(0,12));
        monthCombo.setSizeFull();
        layout.addComponents(yearCombo,monthCombo);
        dependentLayout.addComponent(setTabData(q6Map.get("6.6"),layout));

        investigationCombo = new ComboBox();
        investigationCombo.setSizeFull();
        investigationCombo.setItems(getYesNoAnswer(language));
        investigationCombo.setTextInputAllowed(false);
        dependentLayout.addComponent(setTabData(q6Map.get("6.7"),investigationCombo));

        HorizontalLayout thalassemiaLayout = new HorizontalLayout();
        thalassemiaLayout.setSizeFull();
        Label thalLabel = new Label(q6Map.get("6.8"));
        thalLabel.setSizeFull();
        thalassemiaCombo = new ComboBox();
        thalassemiaCombo.setSizeFull();
        thalassemiaCombo.setItems(getYesNoAnswer(language));
        thalassemiaCombo.setTextInputAllowed(false);
        thalassemiaLayout.addComponents(thalLabel,thalassemiaCombo);
        thalassemiaLayout.setExpandRatio(thalLabel,3);
        thalassemiaLayout.setExpandRatio(thalassemiaCombo,1);
        addComponent(thalassemiaLayout);

        VerticalLayout thalDependLayout = new VerticalLayout();
        thalDependLayout.setSizeFull();
        addComponent(thalDependLayout);
        thalDependLayout.setMargin(false);
        thalDependLayout.setVisible(false);
        thalassemiaCombo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer == null  || answer.getId() == 2){
                thalDependLayout.setVisible(false);
            }
            else {
                thalDependLayout.setVisible(true);
            }
        });

        thalassemiaYesCombo = new ComboBox();
        thalassemiaYesCombo.setSizeFull();
        thalassemiaYesCombo.setItems(answerMap.get("6.9"));
        thalassemiaYesCombo.setDescription(getAnswerDesc(answerMap.get("6.9")));
        thalassemiaYesCombo.setTextInputAllowed(false);
        thalDependLayout.addComponent(setTabData(q6Map.get("6.9"),thalassemiaYesCombo));

        bleedingCombo = new ComboBox();
        bleedingCombo.setSizeFull();
        bleedingCombo.setItems(getYesNoAnswer(language));
        bleedingCombo.setTextInputAllowed(false);
        addComponent(setTabData(q6Map.get("6.10"),bleedingCombo));

        blackCombo = new ComboBox();
        blackCombo.setSizeFull();
        blackCombo.setItems(getYesNoAnswer(language));
        blackCombo.setTextInputAllowed(false);
        addComponent(setTabData(q6Map.get("6.11"),blackCombo));

        wormCombo = new ComboBox();
        wormCombo.setSizeFull();
        wormCombo.setItems(getYesNoAnswer(language));
        wormCombo.setTextInputAllowed(false);
        addComponent(setTabData(q6Map.get("6.12"),wormCombo));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(6);
        });
        addComponent(nextBtn);
    }

    private void setQ62Header(){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();

        Label label = new Label(fields.get("6.21"));
        label.setSizeFull();
        Label label1 = new Label(fields.get("6.22"));
        label1.setSizeFull();
        Label label2 = new Label(fields.get("6.23"));
        label2.setSizeFull();
        Label label3 = new Label(fields.get("6.24"));
        label3.setSizeFull();
        Label label4 = new Label(fields.get("6.25"));
        label4.setSizeFull();
        Label label5 = new Label(" ");
        label5.setSizeFull();
        layout.addComponents(label5,label,label1,label2,label3,label4);
        layout.setExpandRatio(label5,2);
        layout.setExpandRatio(label,1);
        layout.setExpandRatio(label1,1);
        layout.setExpandRatio(label2,1);
        layout.setExpandRatio(label3,1);
        layout.setExpandRatio(label4,1);
        addComponent(layout);
    }

    private HorizontalLayout setQ62(String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();

        List<Answer> yesNoList = getYesNoAnswer(language);
        ComboBox diagnosedCombo = new ComboBox();
        diagnosedCombo.setItems(yesNoList);
        diagnosedCombo.setTextInputAllowed(false);
        diagnosedCombo.setSizeFull();

        ComboBox documentaryCombo = new ComboBox();
        documentaryCombo.setItems(yesNoList);
        documentaryCombo.setTextInputAllowed(false);
        documentaryCombo.setSizeFull();

        ComboBox yearCombo = new ComboBox();
        yearCombo.setItems(getStringList(2000,2019));
        yearCombo.setTextInputAllowed(false);
        yearCombo.setSizeFull();

        ComboBox medicationsCombo = new ComboBox();
        medicationsCombo.setItems(yesNoList);
        medicationsCombo.setTextInputAllowed(false);
        medicationsCombo.setSizeFull();

        ComboBox placeCombo = new ComboBox();
        placeCombo.setItems(getAnwerObj(answerMap.get("6.2")));
        placeCombo.setDescription(getAnswerDesc(answerMap.get("6.2")));
        placeCombo.setSizeFull();
        placeCombo.setTextInputAllowed(false);

        HorizontalLayout dependentLayout = new HorizontalLayout();
        dependentLayout.setSizeFull();
        dependentLayout.addComponents(documentaryCombo,yearCombo,medicationsCombo,placeCombo);
        dependentLayout.setEnabled(false);
        diagnosedCombo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer == null || answer.getId() != 1){
                dependentLayout.setEnabled(false);
            }
            else{
                dependentLayout.setEnabled(true);
            }
        });

        layout.addComponents(label,diagnosedCombo,dependentLayout);
        layout.setExpandRatio(label,2);
        layout.setExpandRatio(diagnosedCombo,1);
        layout.setExpandRatio(dependentLayout,4);
        return  layout;
    }

    private HorizontalLayout getQ61Questions(String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(getYesNoAnswer(language));
        layout.addComponents(label,yesNoCombo);
        layout.setExpandRatio(label,2);
        layout.setExpandRatio(yesNoCombo,1);
        return layout;
    }
    public BaselineQ6 getAnswers(int motherId) {

        BaselineQ6 answer = new BaselineQ6();
        answer.setSurveyId(motherId);
        for(int i = 0;i<firstQAnswerLayout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)firstQAnswerLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            if(i == 0 && comboBox.getValue() != null){
                answer.setM1a(((Answer) comboBox.getValue()).getId());
            }
            if(i == 1 && comboBox.getValue() != null){
                answer.setM1b(((Answer) comboBox.getValue()).getId());
            }
            if(i == 2 && comboBox.getValue() != null){
                answer.setM1c(((Answer) comboBox.getValue()).getId());
            }
            if(i == 3 && comboBox.getValue() != null){
                answer.setM1d(((Answer) comboBox.getValue()).getId());
            }
        }

        if(q63Combo.getValue() != null) answer.setM3(getId((Answer)q63Combo.getValue()));
        if(anemiaCombo.getValue() != null && anemiaCombo.getValue().size() != 0){
            String val="";
            for(Answer answer1 : anemiaCombo.getValue()){
                val += answer1.getId()+",";
            }
            answer.setM4(val.substring(0,val.length()-1));
        }
        if(monthsCombo65.getValue() != null) answer.setM3(Integer.parseInt(monthsCombo65.getValue().toString()));
        if(yearCombo.getValue() != null || monthCombo.getValue() != null){
            answer.setM6(yearCombo.getValue() + "years " +monthCombo.getValue()+"months");
        }
        if(investigationCombo.getValue() != null) answer.setM7(getId((Answer)investigationCombo.getValue()));
        if(thalassemiaCombo.getValue() != null) answer.setM8(getId((Answer)thalassemiaCombo.getValue()));
        if(thalassemiaYesCombo.getValue() != null) answer.setM9(getId((Answer)thalassemiaYesCombo.getValue()));
        if(bleedingCombo.getValue() != null) answer.setM10(getId((Answer)bleedingCombo.getValue()));
        if(blackCombo.getValue() != null) answer.setM11(getId((Answer)blackCombo.getValue()));
        if(wormCombo.getValue() != null) answer.setM12(getId((Answer)wormCombo.getValue()));

        return answer;
    }

    public List<BaselineQ62> getAnswer62(int motherId){

        List<BaselineQ62> list = new ArrayList<>();
        for(int i = 0 ;i<secondQAnswerLayout.getComponentCount();i++){
            HorizontalLayout horizontalLayout = (HorizontalLayout)secondQAnswerLayout.getComponent(i);
            String label = ((Label)horizontalLayout.getComponent(0)).getValue();
            ComboBox fCombo = (ComboBox) horizontalLayout.getComponent(1);
            HorizontalLayout dependentLayout = (HorizontalLayout) horizontalLayout.getComponent(2);
            ComboBox writtenCombo = (ComboBox)dependentLayout.getComponent(0);
            ComboBox yearCombo = (ComboBox)dependentLayout.getComponent(1);
            ComboBox medicalCombo = (ComboBox)dependentLayout.getComponent(2);
            ComboBox sectorCombo = (ComboBox)dependentLayout.getComponent(3);
            BaselineQ62 answer = new BaselineQ62();
            answer.setSurveyId(motherId);
            answer.setQuestion(label.substring(0,1));
            if(fCombo.getValue() != null) answer.setM1(getId((Answer)fCombo.getValue()));
            if(writtenCombo.getValue() != null) answer.setM2(getId((Answer)writtenCombo.getValue()));
            if(yearCombo.getValue() != null) answer.setM3(Integer.parseInt(yearCombo.getValue().toString()));
            if(medicalCombo.getValue() != null) answer.setM4(getId((Answer)medicalCombo.getValue()));
            if(sectorCombo.getValue() != null) answer.setM5(getId((Answer)sectorCombo.getValue()));

            list.add(answer);
        }
        return list;
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
