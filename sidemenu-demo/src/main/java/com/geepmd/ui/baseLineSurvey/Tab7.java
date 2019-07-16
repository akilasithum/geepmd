package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ7;
import com.geepmd.entity.BaselineQ8;
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

public class Tab7 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q7Map;
    Map<String,String> fields;
    String language;
    ComboBox mesTypeCombo;
    VerticalLayout layout72;
    VerticalLayout layout73;
    Survey survey;

    public Tab7(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q7Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ7AnswerList();
            q7Map = SinhalaMap.getQ7Map();
            fields = SinhalaMap.getQ7Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        mesTypeCombo = new ComboBox();
        mesTypeCombo.setItems(getYesNoAnswer(language));
        addComponent(setTabData(q7Map.get("7.1"),mesTypeCombo));

        Label q72Label = new Label(q7Map.get("7.2"));
        q72Label.setSizeFull();
        addComponent(q72Label);
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        headerLayout.setMargin(new MarginInfo(false,false,false,true));
        Label q72Header = new Label(fields.get("7.11"));
        q72Header.setSizeFull();
        headerLayout.addComponent(q72Header);
        addComponent(headerLayout);
        layout72 = new VerticalLayout();
        layout72.setSizeFull();
        addComponent(layout72);
        layout72.addComponent(addActivitiesTable("A"));
        layout72.addComponent(addActivitiesTable("B"));
        layout72.addComponent(addActivitiesTable("C"));
        layout72.addComponent(addActivitiesTable("D"));
        layout72.addComponent(addActivitiesTable("E"));

        Label q73Label = new Label(q7Map.get("7.3"));
        q73Label.setSizeFull();
        addComponent(q73Label);

        HorizontalLayout q73HeaderLayout = new HorizontalLayout();
        q73HeaderLayout.setSizeFull();
        q73HeaderLayout.addComponents(new Label(fields.get("7.31")));
        q73HeaderLayout.setMargin(new MarginInfo(false,false,false,true));
        addComponent(q73HeaderLayout);
        layout73 = new VerticalLayout();
        layout73.setSizeFull();
        addComponent(layout73);
        layout73.addComponent(addQ73Layout(fields.get("7.32")));
        layout73.addComponent(addQ73Layout(fields.get("7.33")));
        layout73.addComponent(addQ73Layout(fields.get("7.34")));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(7);
        });
        addComponent(nextBtn);
    }

    private HorizontalLayout addActivitiesTable(String letter){
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setItems(getAnwerObj(answerMap.get("7.2")));
        comboBox.setDescription(getAnswerDesc(answerMap.get("7.2")));
        TextField textField = new TextField();
        textField.setSizeFull();
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setWidth("70%");
        Label letterLabel = new Label(letter);
        letterLabel.setSizeFull();
        layout.addComponents(letterLabel,textField,comboBox);
        layout.setExpandRatio(letterLabel,1);
        layout.setExpandRatio(textField,15);
        layout.setExpandRatio(comboBox,10);
        layout.setMargin(new MarginInfo(false,false,false,true));
        return layout;
    }

    private HorizontalLayout addQ73Layout(String place){
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(getYesNoAnswer(language));

        Label label = new Label(place);
        label.setSizeFull();
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setWidth("50%");
        layout.addComponents(label,yesNoCombo);
        layout.setMargin(new MarginInfo(false,false,false,true));
        return layout;
    }

    public BaselineQ7 getAnswers(int motherId) {

        BaselineQ7 answer = new BaselineQ7();
        answer.setMotherId(motherId);
        if(mesTypeCombo.getValue() != null) answer.setM1(((Answer) mesTypeCombo.getValue()).getId());

        for(int i = 0;i < layout72.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)layout72.getComponent(i);
            String letter = ((Label)layout.getComponent(0)).getValue();
            TextField answerVal = (TextField)layout.getComponent(1);
            ComboBox comboBox = (ComboBox) layout.getComponent(2);
            if(letter.equalsIgnoreCase("a") && answerVal.getValue() != null && comboBox.getValue() != null){
                answer.setM2a(((Answer) comboBox.getValue()).getId());
                answer.setM2aQ(answerVal.getValue());
            }
            else if(letter.equalsIgnoreCase("b") && answerVal.getValue() != null && comboBox.getValue() != null){
                answer.setM2b(((Answer) comboBox.getValue()).getId());
                answer.setM2bQ(answerVal.getValue());
            }
            else if(letter.equalsIgnoreCase("c") && answerVal.getValue() != null && comboBox.getValue() != null){
                answer.setM2c(((Answer) comboBox.getValue()).getId());
                answer.setM2cQ(answerVal.getValue());
            }
            else if(letter.equalsIgnoreCase("d") && answerVal.getValue() != null && comboBox.getValue() != null){
                answer.setM2d(((Answer) comboBox.getValue()).getId());
                answer.setM2dQ(answerVal.getValue());
            }
            else if(letter.equalsIgnoreCase("e") && answerVal.getValue() != null && comboBox.getValue() != null){
                answer.setM2e(((Answer) comboBox.getValue()).getId());
                answer.setM2eQ(answerVal.getValue());
            }
        }

        for(int i = 0;i<layout73.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)layout73.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            if(i == 0 && comboBox.getValue() != null){
                answer.setM3a(((Answer) comboBox.getValue()).getId());
            }
            if(i == 1 && comboBox.getValue() != null){
                answer.setM3b(((Answer) comboBox.getValue()).getId());
            }
            if(i == 2 && comboBox.getValue() != null){
                answer.setM3c(((Answer) comboBox.getValue()).getId());
            }
        }
        return answer;
    }
}
