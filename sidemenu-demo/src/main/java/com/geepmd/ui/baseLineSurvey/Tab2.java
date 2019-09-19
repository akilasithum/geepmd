package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ1;
import com.geepmd.entity.BaselineQ2;
import com.geepmd.entity.BaselineQ26;
import com.geepmd.entity.BaselineQ28;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.addons.ComboBoxMultiselect;

import java.util.*;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab2 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    String language;
    Map<String,String> fields;
    ComboBox mesTypeCombo;
    ComboBox mensDaysCombo;
    ComboBox daysCombo23;
    ComboBox yesNoCombo24;
    ComboBox sanitaryCombo;
    ComboBox contraceptiveCombo;
    ComboBox diagnosedCombo;
    ComboBox yesNoCombo210;
    TextField questionDBUniqueIdField;
    HorizontalLayout padSmallLayout;
    HorizontalLayout padMediumLayout;
    HorizontalLayout padLargeLayout;
    VerticalLayout q28Layout;
    Survey survey;
    List<Answer> q28AnswerSet;

    public Tab2(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
        }
        else{
            answerMap = SinhalaMap.getQ2AnswerList();
            fields = SinhalaMap.getQ2Fields();
        }
        this.survey = survey;
        createLayout(language);
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(String language){
        q28AnswerSet = getAnwerObj(answerMap.get("2.8"));
        Map<String,String> q2Map;
        if(language.equals("EN")){
            q2Map = EnglishMap.getquestion1Map();
        }
        else{
            q2Map = SinhalaMap.getQ2Map();
        }
        questionDBUniqueIdField = new TextField();
        questionDBUniqueIdField.setVisible(false);
        addComponent(questionDBUniqueIdField);

        mesTypeCombo = new ComboBox();
        mesTypeCombo.setItems(getYesNoAnswer(language));
        mesTypeCombo.setTextInputAllowed(false);
        addComponent(setTabData(q2Map.get("2.1"),mesTypeCombo));

        mensDaysCombo = new ComboBox();
        mensDaysCombo.setItems(getStringList(20,45));
        addComponent(setTabData(q2Map.get("2.2"),mensDaysCombo));

        daysCombo23 = new ComboBox();
        daysCombo23.setItems(getStringList(1,8));
        daysCombo23.setTextInputAllowed(false);
        addComponent(setTabData(q2Map.get("2.3"), daysCombo23));

        yesNoCombo24 = new ComboBox();
        yesNoCombo24.setItems(getYesNoAnswer(language));
        yesNoCombo24.setTextInputAllowed(false);
        addComponent(setTabData(q2Map.get("2.4"),yesNoCombo24));

        sanitaryCombo = new ComboBox();
        sanitaryCombo.setItems(getAnwerObj(answerMap.get("2.5")));
        sanitaryCombo.setTextInputAllowed(false);
        addComponent(setTabData(q2Map.get("2.5"),sanitaryCombo));

        Label label26 = new Label(q2Map.get("2.6"));
        label26.setSizeFull();
        addComponent(label26);
        addComponent(setQ26Layout());

        contraceptiveCombo = new ComboBox();
        contraceptiveCombo.setItems(getYesNoAnswer(language));
        contraceptiveCombo.setTextInputAllowed(false);
        HorizontalLayout q27Layout = setTabData(q2Map.get("2.7"),contraceptiveCombo);
        addComponent(q27Layout);

        Label q28Label = new Label(q2Map.get("2.8"));
        q28Label.setSizeFull();
        q28Layout = new VerticalLayout();
        q28Layout.setSizeFull();
        q28Layout.addComponent(get28Header());
        q28Layout.addComponent(addActivitiesTable("1"));
        q28Layout.addComponent(addActivitiesTable("2"));
        q28Layout.addComponent(addActivitiesTable("3"));
        q28Layout.addComponent(addActivitiesTable("4"));
        q28Layout.addComponent(addActivitiesTable("5"));

        contraceptiveCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {

            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                int layoutIndex = getComponentIndex(q27Layout);
                addComponent(q28Label,layoutIndex+1);
                addComponent(q28Layout,layoutIndex+2);
            }
            else if(answer != null && answer.getId() == 2){
                removeComponent(q28Label);
                removeComponent(q28Layout);
            }
            else{
                removeComponent(q28Label);
                removeComponent(q28Layout);
            }
        });

        diagnosedCombo = new ComboBox();
        diagnosedCombo.setItems(getYesNoAnswer(language));
        diagnosedCombo.setTextInputAllowed(false);
        HorizontalLayout q29Layout = setTabData(q2Map.get("2.9"),diagnosedCombo);
        addComponent(q29Layout);

        HorizontalLayout q210Layout = new HorizontalLayout();
        q210Layout.setSizeFull();
        Label q210Label = new Label(q2Map.get("2.10"));
        q210Label.setSizeFull();
        yesNoCombo210 = new ComboBox();
        yesNoCombo210.setItems(getStringList(1,15));
        yesNoCombo210.setSizeFull();
        yesNoCombo210.setTextInputAllowed(false);
        q210Layout.addComponents(q210Label, yesNoCombo210);
        q210Layout.setExpandRatio(q210Label,3);
        q210Layout.setExpandRatio(yesNoCombo210,1);

        diagnosedCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                int index = getComponentIndex(q29Layout);
                addComponent(q210Layout,index+1);
            }
            else{
                removeComponent(q210Layout);
            }
        });
        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(2);
        });
        addComponent(nextBtn);
    }

    private HorizontalLayout setQ26Layout(){
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label1 = new Label(fields.get("2.61"));
        label1.setSizeFull();
        label1.setStyleName("padSection");
        HorizontalLayout layout1 = new HorizontalLayout();
        layout1.setSizeFull();
        Label wetCountLabel = new Label(fields.get("2.62"));
        wetCountLabel.setSizeFull();
        VerticalLayout countLayout = new VerticalLayout();
        Label countLabel = new Label(fields.get("2.63"));
        countLabel.setStyleName("padHeader");
        countLabel.setSizeFull();
        HorizontalLayout daysLayout = new HorizontalLayout();
        daysLayout.setSizeFull();
        for(int i = 1;i<10;i++){
            String labelStr;
            if(i!= 9) labelStr = i +" "+ fields.get("2.64");
            else labelStr = fields.get("2.65");

            Label label = new Label(labelStr);
            label.setSizeFull();
            daysLayout.addComponent(label);
        }
        countLayout.addComponents(countLabel,daysLayout);
        layout1.addComponents(wetCountLabel,countLayout);
        countLayout.setMargin(false);
        layout1.setExpandRatio(wetCountLabel,1);
        layout1.setExpandRatio(countLayout,9);

        VerticalLayout padLayout = new VerticalLayout();
        padLayout.setSizeFull();
        padLayout.setMargin(false);
        padSmallLayout = new HorizontalLayout();
        padSmallLayout.setSizeFull();
        padSmallLayout = getPadLayout("images/small_pad.png");

        padMediumLayout = new HorizontalLayout();
        padMediumLayout.setSizeFull();
        padMediumLayout = getPadLayout("images/medium_pad.png");

        padLargeLayout = new HorizontalLayout();
        padLargeLayout.setSizeFull();
        padLargeLayout = getPadLayout("images/large_pad.png");

        padLayout.addComponents(layout1,padSmallLayout,padMediumLayout,padLargeLayout);
        mainLayout.addComponents(label1,padLayout);
        mainLayout.setExpandRatio(label1,1);
        mainLayout.setExpandRatio(padLayout,9);
        return mainLayout;
    }

    private HorizontalLayout getPadLayout(String imageName){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Image logo = new Image();
        logo.setSource(new ThemeResource(imageName));
        logo.setSizeFull();
        layout.addComponent(logo);
        HorizontalLayout fieldLayout = new HorizontalLayout();
        fieldLayout.setSizeFull();
        for(int i = 1;i<10;i++){
            TextField label = new TextField();
            label.setSizeFull();
            fieldLayout.addComponent(label);
            label.addValueChangeListener(event -> {
                if(event.getValue() != null && !event.getValue().isEmpty() && !isInteger(event.getValue())){
                    label.setValue("");
                    Notification.show("Enter numeric value between 1 and 9", Notification.Type.WARNING_MESSAGE);
                }
            });
        }
        layout.addComponent(fieldLayout);
        layout.setExpandRatio(logo,1);
        layout.setExpandRatio(fieldLayout,9);
        return layout;
    }

    private boolean isInteger(String value){
        try{
            int val = Integer.parseInt(value);
            return val >= 0 && val <=9;
        }
        catch (Exception e){
            return false;
        }
    }

    private HorizontalLayout addActivitiesTable(String labelVal){
        ComboBoxMultiselect sideEffects = new ComboBoxMultiselect();
        sideEffects.setSizeFull();
        sideEffects.setItems(q28AnswerSet);
        sideEffects.setDescription(getAnswerDesc(answerMap.get("2.8")));
        sideEffects.setTextInputAllowed(false);
        TextField method = new TextField();
        method.setSizeFull();
        TextField usedTime = new TextField();
        usedTime.setSizeFull();
        TextField recentToStop = new TextField();
        recentToStop.setSizeFull();
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(labelVal);
        label.setSizeFull();
        layout.addComponents(label,method,usedTime,sideEffects,recentToStop);
        layout.setExpandRatio(label,1);
        layout.setExpandRatio(method,15);
        layout.setExpandRatio(usedTime,10);
        layout.setExpandRatio(sideEffects,10);
        layout.setExpandRatio(recentToStop,10);
        return layout;
    }

    private HorizontalLayout get28Header(){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label methodLabel = new Label(fields.get("2.8.1"));
        methodLabel.setSizeFull();
        methodLabel.setStyleName("padHeader");
        Label timeLabel = new Label(fields.get("2.8.2"));
        timeLabel.setSizeFull();
        timeLabel.setStyleName("padHeader");
        Label sideEffectLabel = new Label(fields.get("2.8.3"));
        sideEffectLabel.setSizeFull();
        sideEffectLabel.setStyleName("padHeader");
        Label reasonLabel = new Label(fields.get("2.8.4"));
        reasonLabel.setSizeFull();
        reasonLabel.setStyleName("padHeader");
        layout.addComponents(methodLabel,timeLabel,sideEffectLabel,reasonLabel);
        layout.setExpandRatio(methodLabel,8);
        layout.setExpandRatio(timeLabel,5);
        layout.setExpandRatio(sideEffectLabel,5);
        layout.setExpandRatio(reasonLabel,5);
        return layout;
    }

    public BaselineQ2 getAnswers(int surveyId) {

        BaselineQ2 answer = new BaselineQ2();
        /*if(questionDBUniqueIdField.getValue() != null && !questionDBUniqueIdField.getValue().isEmpty()){
            answer.setBaselineQ2Id(Integer.parseInt(questionDBUniqueIdField.getValue()));
        }*/
        answer.setSurveyId(surveyId);
        if(mesTypeCombo.getValue() != null) answer.setM1(getId((Answer)mesTypeCombo.getValue()));
        if(mensDaysCombo.getValue() != null) answer.setM2(Integer.parseInt(mensDaysCombo.getValue().toString()));
        if(daysCombo23.getValue() != null) answer.setM3(Integer.parseInt(daysCombo23.getValue().toString()));
        if(yesNoCombo24.getValue() != null) answer.setM4(getId((Answer)yesNoCombo24.getValue()));
        if(sanitaryCombo.getValue() != null) answer.setM5(getId((Answer)sanitaryCombo.getValue()));
        if(contraceptiveCombo.getValue() != null) answer.setM7(getId((Answer)contraceptiveCombo.getValue()));
        if(diagnosedCombo.getValue() != null) {
            answer.setM9(getId((Answer)diagnosedCombo.getValue()));
            if(getId((Answer)diagnosedCombo.getValue()) == 1){
                if(yesNoCombo210.getValue() != null) answer.setM10(Integer.parseInt(yesNoCombo210.getValue().toString()));
            }
            else{
                answer.setM10(8888);
            }
        }
        return answer;
    }

    public List<BaselineQ28> get28Answers(int surveyId){
        List<BaselineQ28> answerList = new ArrayList<>();
        for(int i = 1;i<q28Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q28Layout.getComponent(i);
            TextField method = (TextField) layout.getComponent(1);
            TextField timePeriod = (TextField) layout.getComponent(2);
            ComboBoxMultiselect sideEffects = (ComboBoxMultiselect) layout.getComponent(3);
            TextField reason = (TextField) layout.getComponent(4);
            if((method.getValue() != null && !method.getValue().isEmpty()) || (timePeriod.getValue() != null && !timePeriod.getValue().isEmpty())
                    || (sideEffects.getValue() != null && !sideEffects.getValue().isEmpty())|| (reason.getValue() != null && !reason.getValue().isEmpty())) {
                BaselineQ28 answer = new BaselineQ28();
                answer.setSurveyId(surveyId);
                if (method.getValue() != null) answer.setM1(method.getValue());
                if (timePeriod.getValue() != null) answer.setM2(timePeriod.getValue());
                if (sideEffects.getValue() != null) answer.setM3(getStringFromSet(sideEffects.getValue()));
                if (reason.getValue() != null) answer.setM4(reason.getValue());
                answerList.add(answer);
            }
        }
        return answerList;
    }

    private String getStringFromSet(Set<Answer> set){
        if(set != null && set.size() != 0) {
            String val = "";
            for (Answer answer : set) {
                val += answer.getId() + ",";
            }
            return val.substring(0, val.length() - 1);
        }
        return "";
    }

    public BaselineQ26 get26Answer(int surveyId){
        BaselineQ26 answer = new BaselineQ26();
        answer.setSurveyId(surveyId);
        HorizontalLayout smallPad = (HorizontalLayout)padSmallLayout.getComponent(1);
        HorizontalLayout mediumPad = (HorizontalLayout)padMediumLayout.getComponent(1);
        HorizontalLayout largePad = (HorizontalLayout)padLargeLayout.getComponent(1);
        for(int i = 0;i<9;i++){
            TextField field1 = (TextField)smallPad.getComponent(i);
            TextField field2 = (TextField)mediumPad.getComponent(i);
            TextField field3 = (TextField)largePad.getComponent(i);

            String c1 = field1.getValue() != null && !field1.getValue().isEmpty() ? field1.getValue() : "0";
            String c2 = field2.getValue() != null && !field2.getValue().isEmpty() ? field2.getValue() : "0";
            String c3 = field3.getValue() != null && !field3.getValue().isEmpty() ? field3.getValue() : "0";
            String answerStr = c1+","+c2+","+c3;

            if(i==0) answer.setD1(answerStr);
            if(i==1) answer.setD2(answerStr);
            if(i==2) answer.setD3(answerStr);
            if(i==3) answer.setD4(answerStr);
            if(i==4) answer.setD5(answerStr);
            if(i==5) answer.setD6(answerStr);
            if(i==6) answer.setD7(answerStr);
            if(i==7) answer.setD8(answerStr);
            if(i==8) answer.setD9(answerStr);
        }
        return answer;
    }

    public void setEditData(BaselineQ2 answer,BaselineQ26 answer26,List<BaselineQ28> answer28){
        questionDBUniqueIdField.setValue(String.valueOf(answer.getBaselineQ2Id()));
        mesTypeCombo.setValue(getYesNoObject("SN",answer.getM1()));
        if(answer.getM2() != 0) mensDaysCombo.setValue(answer.getM2());
        if(answer.getM3() != 0) daysCombo23.setValue(answer.getM3());
        yesNoCombo24.setValue(getYesNoObject("SN",answer.getM4()));
        sanitaryCombo.setValue(getAnswerObj("2.5",answer.getM5()));
        contraceptiveCombo.setValue(getYesNoObject("SN",answer.getM7()));
        diagnosedCombo.setValue(getYesNoObject("SN",answer.getM9()));
        if(answer.getM10() != 0) yesNoCombo210.setValue(answer.getM10());

        if(answer26 != null) {
            if (!answer26.getD1().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD1(), 0);
            if (!answer26.getD2().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD2(), 1);
            if (!answer26.getD3().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD3(), 2);
            if (!answer26.getD4().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD4(), 3);
            if (!answer26.getD5().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD5(), 4);
            if (!answer26.getD6().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD6(), 5);
            if (!answer26.getD7().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD7(), 6);
            if (!answer26.getD8().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD8(), 7);
            if (!answer26.getD9().equalsIgnoreCase("0,0,0")) setPadValue(answer26.getD9(), 8);
        }
        for(int i = 0;i<answer28.size();i++){

            HorizontalLayout layout = (HorizontalLayout) q28Layout.getComponent(i+1);
            TextField method = (TextField) layout.getComponent(1);
            TextField timePeriod = (TextField) layout.getComponent(2);
            ComboBoxMultiselect<Answer> sideEffects = (ComboBoxMultiselect) layout.getComponent(3);
            TextField reason = (TextField) layout.getComponent(4);

            BaselineQ28 baselineQ28 = answer28.get(i);
            method.setValue(baselineQ28.getM1());
            timePeriod.setValue(baselineQ28.getM2());
            Set<Answer> selectedAnswers = new HashSet<>();
            String str = baselineQ28.getM3();
            if(str != null && !str.isEmpty() && !str.trim().equals("") && !str.equals("8888")){
                String[] arr = str.split(",");
                for(String ans : Arrays.asList(arr)){
                    int id = Integer.parseInt(ans);
                    if(id != 0) {
                        selectedAnswers.add(q28AnswerSet.get(id-1));
                    }
                }
            }
            sideEffects.setValue(selectedAnswers);
            reason.setValue(baselineQ28.getM4());
        }
    }

    private void setPadValue(String value,int index){
        HorizontalLayout smallPad = (HorizontalLayout)padSmallLayout.getComponent(1);
        HorizontalLayout mediumPad = (HorizontalLayout)padMediumLayout.getComponent(1);
        HorizontalLayout largePad = (HorizontalLayout)padLargeLayout.getComponent(1);

        TextField field1 = (TextField)smallPad.getComponent(index);
        TextField field2 = (TextField)mediumPad.getComponent(index);
        TextField field3 = (TextField)largePad.getComponent(index);
        String[] val = value.split(",");
        if(val.length == 3){
            if(!val[0].equalsIgnoreCase("0")) field1.setValue(val[0]);
            if(!val[1].equalsIgnoreCase("0")) field2.setValue(val[1]);
            if(!val[2].equalsIgnoreCase("0")) field3.setValue(val[2]);
        }
    }

    private void clearPadValues(int index){
        HorizontalLayout smallPad = (HorizontalLayout)padSmallLayout.getComponent(1);
        HorizontalLayout mediumPad = (HorizontalLayout)padMediumLayout.getComponent(1);
        HorizontalLayout largePad = (HorizontalLayout)padLargeLayout.getComponent(1);

        TextField field1 = (TextField)smallPad.getComponent(index);
        TextField field2 = (TextField)mediumPad.getComponent(index);
        TextField field3 = (TextField)largePad.getComponent(index);
        field1.clear();
        field2.clear();
        field3.clear();
    }

    public void clearFields(){
        questionDBUniqueIdField.clear();
        mesTypeCombo.clear();
        mensDaysCombo.clear();
        daysCombo23.clear();
        yesNoCombo24.clear();
        sanitaryCombo.clear();
        contraceptiveCombo.clear();
        diagnosedCombo.clear();
        yesNoCombo210.clear();
        for (int i = 0;i<9;i++){
            clearPadValues(i);
        }
        for(int i = 1;i<q28Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q28Layout.getComponent(i);
            TextField method = (TextField) layout.getComponent(1);
            TextField timePeriod = (TextField) layout.getComponent(2);
            ComboBoxMultiselect sideEffects = (ComboBoxMultiselect) layout.getComponent(3);
            TextField reason = (TextField) layout.getComponent(4);
            method.clear();
            timePeriod.clear();
            sideEffects.clear();
            reason.clear();
        }
    }

    private int getId(Answer answer){
        return answer.getId();
    }

    private Answer getAnswerObj(String question, int answer){
        if(answer != 0) {
            try {
                List<String> qList = answerMap.get(question);
                Answer answerObj = new Answer();
                answerObj.setId(answer);
                answerObj.setDescription(qList.get(answer-1));
                return answerObj;
            }catch (Exception e){
                return null;
            }
        }
        else return null;
    }


}
