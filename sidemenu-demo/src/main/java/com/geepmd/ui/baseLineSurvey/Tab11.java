package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ11;
import com.geepmd.entity.CommonDetails;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class Tab11 extends VerticalLayout {

    Map<String,String> q11Map;
    Map<String,String> fields;
    String language;
    Survey survey;
    VerticalLayout q1Layout;
    VerticalLayout q2Layout;
    VerticalLayout q3Layout;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    TextField rightOption1Label;
    TextField leftOption1Label;
    TextField rightOption2Label;
    TextField leftOption2Label;

    public Tab11(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            q11Map = EnglishMap.getquestion1Map();

        }
        else{

            q11Map = SinhalaMap.getQ11Map();
            fields = SinhalaMap.getQ11Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){

        Label examinationHeader = new Label(q11Map.get("11.1"));
        addComponent(examinationHeader);
        examinationHeader.setStyleName("padHeader");
        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        addComponent(q1Layout);
        q1Layout.setMargin(leftMargin);
        q1Layout.setWidth("60%");
        Map<String,String> q1Map = SinhalaMap.getQ111Fields();
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("a")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("b")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("c")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("d")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("e")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("f")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("g")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("h")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("i")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("j")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("k")));
        q1Layout.addComponent(addHorizontalLayout(q1Map.get("h")));

        Label precordialHeader = new Label(q11Map.get("11.2"));
        addComponent(precordialHeader);
        precordialHeader.setStyleName("padHeader");
        q2Layout = new VerticalLayout();
        q2Layout.setSizeFull();
        addComponent(q2Layout);
        q2Layout.setMargin(leftMargin);
        q2Layout.setWidth("60%");
        Map<String,String> q2Map = SinhalaMap.getQ112Fields();
        q2Layout.addComponent(addHorizontalLayout(q2Map.get("a")));
        q2Layout.addComponent(addHorizontalLayout(q2Map.get("b")));
        q2Layout.addComponent(addHorizontalLayout(q2Map.get("c")));
        q2Layout.addComponent(addHorizontalLayout(q2Map.get("d")));
        q2Layout.addComponent(addHorizontalLayout(q2Map.get("e")));
        q2Layout.addComponent(addHorizontalLayoutWithTextField(q2Map.get("f")));
        q2Layout.addComponent(addHorizontalLayout(q2Map.get("g")));
        q2Layout.addComponent(getQ2MultipleAnswerLayout(q2Map.get("h")));


        Label auscultationHeader = new Label(q11Map.get("11.3"));
        addComponent(auscultationHeader);
        auscultationHeader.setStyleName("padHeader");
        q3Layout = new VerticalLayout();
        q3Layout.setSizeFull();
        addComponent(q3Layout);
        q3Layout.setMargin(leftMargin);
        q3Layout.setWidth("60%");
        Map<String,String> q3Map = SinhalaMap.getQ113Fields();
        q3Layout.addComponent(addHorizontalLayout(q3Map.get("a")));
        q3Layout.addComponent(addHorizontalLayout(q3Map.get("b")));
        q3Layout.addComponent(addHorizontalLayout(q3Map.get("c")));
        Label middleHeader = new Label(q3Map.get("middleHeader"));
        middleHeader.setStyleName("padHeader");
        q3Layout.addComponent(middleHeader);
        q3Layout.addComponent(addHorizontalLayoutWithTextField(q3Map.get("d")));
        q3Layout.addComponent(addHorizontalLayoutWithTextField(q3Map.get("e")));
        q3Layout.addComponent(getMultipleAnswerLayout(q3Map.get("f"),"1st reading","2nd reading"));
        q3Layout.addComponent(getMultipleAnswerLayout(q3Map.get("g"),"1st reading","2nd reading"));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(11);
        });
        addComponent(nextBtn);
    }

    private HorizontalLayout addHorizontalLayout(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getYesNoAnswer("EN"));
        layout.addComponents(label,comboBox);
        return layout;
    }

    private HorizontalLayout addHorizontalLayoutWithTextField(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        TextField textField = new TextField();
        textField.setSizeFull();
        layout.addComponents(label,textField);
        return layout;
    }

    private HorizontalLayout getMultipleAnswerLayout(String question,String option1,String option2){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label qLabel = new Label(question);
        TextField option1Label = new TextField(option1);
        option1Label.setSizeFull();
        TextField option2Label = new TextField(option2);
        option2Label.setSizeFull();
        layout.addComponents(qLabel,option1Label,option2Label);
        return layout;
    }

    private VerticalLayout getQ2MultipleAnswerLayout(String question){
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(false);
        mainLayout.setSizeFull();
        HorizontalLayout layout1 = new HorizontalLayout();
        layout1.setSizeFull();
        layout1.setMargin(false);
        HorizontalLayout layout2 = new HorizontalLayout();
        layout2.setSizeFull();
        layout2.setMargin(false);
        Label qLabel = new Label(question);
        Label rightLabel = new Label("Right");
        Label leftLabel = new Label("Left");
        Label emptyLabel = new Label("");
        rightOption1Label = new TextField("Systolic");
        rightOption1Label.setSizeFull();
        rightOption2Label = new TextField("Diastolic");
        rightOption2Label.setSizeFull();
        layout1.addComponents(qLabel, rightLabel,rightOption1Label,rightOption2Label);
        layout1.setExpandRatio(qLabel,2);
        layout1.setExpandRatio(rightLabel,2);
        layout1.setExpandRatio(rightOption1Label,1);
        layout1.setExpandRatio(rightOption2Label,1);
        leftOption1Label = new TextField("Systolic");
        leftOption1Label.setSizeFull();
        leftOption2Label = new TextField("Diastolic");
        leftOption2Label.setSizeFull();
        layout2.addComponents(emptyLabel, leftLabel,leftOption1Label,leftOption2Label);
        layout2.setExpandRatio(emptyLabel,2);
        layout2.setExpandRatio(leftLabel,2);
        layout2.setExpandRatio(leftOption1Label,1);
        layout2.setExpandRatio(leftOption2Label,1);
        mainLayout.addComponents(layout1,layout2);
        return mainLayout;
    }

    public BaselineQ11 getAnswerQ11(int surveyId) {
        BaselineQ11 answer = new BaselineQ11();
        answer.setSurveyId(surveyId);
        for(int i = 0 ;i<q1Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q1Layout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            String prefix = (i+1)+"";
            if(comboBox.getValue() != null) callSetter(answer,"m1"+prefix,getId((Answer)comboBox.getValue()));
        }


        for(int i = 0 ;i<7 ;i++){
            HorizontalLayout layout = (HorizontalLayout) q2Layout.getComponent(i);
            String prefix = (i+1)+"";
            if(i != 5){
                ComboBox comboBox = (ComboBox) layout.getComponent(1);
                if(comboBox.getValue() != null) callSetter(answer,"m2"+prefix,getId((Answer)comboBox.getValue()));
            }
            else{
                TextField textField = (TextField) layout.getComponent(1);
                if(textField.getValue() != null) callSetter(answer,"m2"+prefix,textField.getValue());
            }
        }
        if(leftOption1Label.getValue() != null) answer.setM2821(leftOption1Label.getValue());
        if(leftOption2Label.getValue() != null) answer.setM2822(leftOption2Label.getValue());
        if(rightOption1Label.getValue() != null) answer.setM2811(rightOption1Label.getValue());
        if(rightOption2Label.getValue() != null) answer.setM2812(rightOption2Label.getValue());

        for(int i = 0 ;i<8 ;i++) {
            if (i != 3) {
                HorizontalLayout layout = (HorizontalLayout) q3Layout.getComponent(i);

                if (i == 0 || i == 1 || i == 2) {
                    String prefix = (i + 1) + "";
                    ComboBox comboBox = (ComboBox) layout.getComponent(1);
                    if (comboBox.getValue() != null)
                        callSetter(answer, "m3" + prefix, getId((Answer) comboBox.getValue()));
                } else if(i == 4 || i == 5) {
                    String prefix = i + "";
                    TextField textField = (TextField) layout.getComponent(1);
                    if (textField.getValue() != null) callSetter(answer, "m3" + prefix, textField.getValue());
                }
                else{
                    TextField option1 = (TextField) layout.getComponent(1);
                    TextField option2 = (TextField) layout.getComponent(2);
                    if(i == 6){
                        if(option1.getValue() != null) answer.setM361(option1.getValue());
                        if(option2.getValue() != null) answer.setM362(option2.getValue());
                    }
                    if(i == 7){
                        if(option1.getValue() != null) answer.setM371(option1.getValue());
                        if(option2.getValue() != null) answer.setM372(option2.getValue());
                    }
                }
            }
        }

        return answer;
    }

    private void callSetter(Object obj, String fieldName, Object value){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            pd.getWriteMethod().invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
