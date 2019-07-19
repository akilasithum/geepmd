package com.geepmd.ui.baseLineSurvey;

import com.geepmd.ui.Survey;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab8 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q8Map;
    Map<String,String> fields;
    String language;
    Survey survey;
    ComboBox noOfMembers;
    TextField houseLeaderFld;
    ComboBox medicalPref;
    VerticalLayout q84Layout;


    public Tab8(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q8Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ8AnswerList();
            q8Map = SinhalaMap.getQ8Map();
            fields = SinhalaMap.getQ8Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){

        noOfMembers = new ComboBox();
        noOfMembers.setItems(SurveyUtils.getStringList(1,7));
        noOfMembers.setSizeFull();
        noOfMembers.setTextInputAllowed(false);
        addComponent(setTabData(q8Map.get("8.1"),noOfMembers));

        houseLeaderFld = new TextField();
        houseLeaderFld.setSizeFull();
        addComponent(setTabData(q8Map.get("8.2"),houseLeaderFld));

        medicalPref = new ComboBox();
        medicalPref.setSizeFull();
        medicalPref.setTextInputAllowed(false);
        medicalPref.setItems(getAnwerObj(answerMap.get("8.3")));
        addComponent(setTabData(q8Map.get("8.3"),medicalPref));

        q84Layout = new VerticalLayout();
        q84Layout.setSizeFull();
        q84Layout.setVisible(false);
        q84Layout.setWidth("70%");
        addComponent(q84Layout);
        noOfMembers.addValueChangeListener(event -> {
            if(event.getValue() != null){
                q84Layout.removeAllComponents();
                q84Layout.addComponent(new Label(q8Map.get("8.4")));
                q84Layout.setVisible(true);
                q84Layout.setMargin(false);
                int memberCount = Integer.valueOf(event.getValue().toString());
                HorizontalLayout headerLayout = new HorizontalLayout();
                headerLayout.setSizeFull();
                Label memberLabel = new Label(fields.get("8.4.1"));
                memberLabel.setSizeFull();
                memberLabel.setStyleName("padHeader");
                Label relationshipLabel = new Label(fields.get("8.4.2"));
                relationshipLabel.setSizeFull();
                relationshipLabel.setStyleName("padHeader");
                Label ageLabel = new Label(fields.get("8.4.3"));
                ageLabel.setSizeFull();
                ageLabel.setStyleName("padHeader");
                headerLayout.addComponents(memberLabel,relationshipLabel,ageLabel);
                headerLayout.setExpandRatio(memberLabel,1);
                headerLayout.setExpandRatio(relationshipLabel,4);
                headerLayout.setExpandRatio(ageLabel,2);
                q84Layout.addComponent(headerLayout);
                for(int i = 0;i<memberCount;i++){
                    HorizontalLayout layout = new HorizontalLayout();
                    layout.setSizeFull();
                    Label member = new Label(i+"");
                    TextField relationship = new TextField();
                    relationship.setSizeFull();
                    ComboBox ageCombo = new ComboBox();
                    ageCombo.setSizeFull();
                    ageCombo.setItems(getStringList(1,100));
                    layout.addComponents(member,relationship,ageCombo);
                    layout.setComponentAlignment(member,Alignment.MIDDLE_CENTER);
                    layout.setExpandRatio(member,1);
                    layout.setExpandRatio(relationship,4);
                    layout.setExpandRatio(ageCombo,2);
                    q84Layout.addComponent(layout);
                }
            }
            else{
                q84Layout.setVisible(false);
            }
        });

        Label q15Label = new Label(q8Map.get("8.5"));
        q15Label.setSizeFull();
        addComponent(q15Label);
        VerticalLayout q85Layout = new VerticalLayout();
        q85Layout.setSizeFull();
        q85Layout.setMargin(true);
        addComponent(q85Layout);
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.1")));
        q85Layout.addComponent(get85Combo(getStringList(1,10),fields.get("8.5.2")));
        q85Layout.addComponent(get85Combo(getStringList(1,6),fields.get("8.5.3")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.4")),fields.get("8.5.4")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.5")),fields.get("8.5.5")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.6")),fields.get("8.5.6")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.7")),fields.get("8.5.7")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.8")),fields.get("8.5.8")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.9")),fields.get("8.5.9")));
        q85Layout.addComponent(get85Combo(getAnwerObj(answerMap.get("8.5.10")),fields.get("8.5.10")));
        Label q15MiddleLabel = new Label(fields.get("8.5.middle"));
        q15MiddleLabel.setStyleName("padHeader");
        q85Layout.addComponent(q15MiddleLabel);
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.11")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.12")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.13")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.14")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.15")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.16")));
        q85Layout.addComponent(get85Combo(null,fields.get("8.5.17")));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(8);
        });
        addComponent(nextBtn);
    }

    public HorizontalLayout get85Combo(List<?> list,String label){
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        if(list == null){
            comboBox.setItems(getYesNoAnswer(language));
        }
        else {
            comboBox.setItems(list);
        }
        return setTabData(label,comboBox);
    }
}
