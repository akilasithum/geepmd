package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ11;
import com.geepmd.entity.BaselineQ12;
import com.geepmd.entity.SpecialFollowUp;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.ui.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;
import static com.geepmd.utils.SurveyUtils.getYesNoObject;

public class Tab12 extends VerticalLayout {

    Map<String,String> q12Map;
    String language;
    Survey survey;
    VerticalLayout mainLayout;
    TextField questionDBUniqueIdField;
    TextArea specialNotesTextArea;
    CheckBox noToAll;
    ComboBox specialFollowUpCombo;
    TextArea specialFollowUpTextArea;

    public Tab12(String language, Survey survey){
        this.language = language;
        if(language.equals("EN")){
            q12Map = EnglishMap.getquestion1Map();

        }
        else{

            q12Map = SinhalaMap.getQ12Map();
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
        Label label = new Label("Cardiovascular diseases – Screening checklist - History");
        label.setStyleName("padHeader");
        addComponent(label);

        noToAll = new CheckBox(q12Map.get("12"));
        addComponent(noToAll);
        noToAll.setStyleName("checkBoxMargin");
        noToAll.addValueChangeListener(event -> {
            setNoToAllCombo(event.getValue());
        });

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setWidth("70%");
        addComponent(mainLayout);
        mainLayout.setMargin(false);
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.1")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.2")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.3")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.4")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.5")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.6")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.7")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.8")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.9")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.10")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.11")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.12")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.13")));
        mainLayout.addComponent(getQ12Questions(q12Map.get("12.14")));
        specialNotesTextArea = new TextArea("Special Notes - 0/500");
        specialNotesTextArea.setSizeFull();
        specialNotesTextArea.addValueChangeListener(event -> {specialNotesLimit(event.getValue());});
        mainLayout.addComponent(specialNotesTextArea);
        specialFollowUpCombo = new ComboBox("Need of special follow up?");
        specialFollowUpCombo.setItems(getYesNoAnswer("EN"));
        specialFollowUpTextArea = new TextArea("If yes reason for special follow up?");
        specialFollowUpTextArea.setSizeFull();
        specialFollowUpTextArea.setVisible(false);
        mainLayout.addComponents(specialFollowUpCombo,specialFollowUpTextArea);
        specialFollowUpCombo.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer == null || answer.getId() == 2 ){
                specialFollowUpTextArea.setVisible(false);
                specialFollowUpTextArea.clear();
            }
            else{
                specialFollowUpTextArea.setVisible(true);
            }
        });

    }

    private void setNoToAllCombo(boolean isNo) {
        if(isNo) {
            for (int i = 0; i < mainLayout.getComponentCount() - 1; i++) {
                HorizontalLayout layout = (HorizontalLayout) mainLayout.getComponent(i);
                ComboBox comboBox = (ComboBox) layout.getComponent(1);
                comboBox.setValue(getYesNoObject("EN", 2));
            }
        }
    }

    private void specialNotesLimit(String val){
        int count = val.length();
        if(count <= 500){
            specialNotesTextArea.setCaption("Special Notes - " + count +"/500");
        }
        else{
            specialNotesTextArea.setValue(val.substring(0,500));
        }

    }

    private HorizontalLayout getQ12Questions(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setItems(getYesNoAnswer("EN"));
        layout.addComponents(label,yesNoCombo);
        layout.setExpandRatio(label,3);
        layout.setExpandRatio(yesNoCombo,1);
        return layout;
    }

    public BaselineQ12 getAnswerQ12(int surveyId) {
        BaselineQ12 answer = new BaselineQ12();
        answer.setSurveyId(surveyId);
        for (int i = 0; i < mainLayout.getComponentCount()-3; i++) {
            HorizontalLayout layout = (HorizontalLayout) mainLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            String prefix = (i + 1) + "";
            if (comboBox.getValue() != null) callSetter(answer, "m" + prefix, getId((Answer) comboBox.getValue()));
        }
        if(specialNotesTextArea.getValue() != null){
            answer.setSpecialNotes(specialNotesTextArea.getValue());
        }
        return answer;
    }

    public SpecialFollowUp getSpecialFollowUp(String motherId){
        SpecialFollowUp specialFollowUp = new SpecialFollowUp();
        if(specialFollowUpTextArea.getValue() != null && !specialFollowUpTextArea.getValue().isEmpty()){
            specialFollowUp.setMotherId(motherId);
            specialFollowUp.setFollowUpMessage(specialFollowUpTextArea.getValue());
            return specialFollowUp;
        }
        return null;
    }

    public void setEditData(BaselineQ12 answer) {
        questionDBUniqueIdField.setValue(String.valueOf(answer.getBaselineQ12Id()));
        for (int i = 0; i < mainLayout.getComponentCount()-3; i++) {
            HorizontalLayout layout = (HorizontalLayout) mainLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            String prefix = (i + 1) + "";
            comboBox.setValue(getYesNoObject("EN", callGetter(answer, "m"+prefix)));
        }
        if(answer.getSpecialNotes() != null )specialNotesTextArea.setValue(answer.getSpecialNotes());
    }

    public void setFollowUpDetails(SpecialFollowUp followUp){
        if(followUp != null){
            specialFollowUpCombo.setValue(getYesNoObject("EN",1));
            specialFollowUpTextArea.setValue(followUp.getFollowUpMessage());
        }
    }

    public void clearFields() {
        questionDBUniqueIdField.clear();
        noToAll.clear();
        for (int i = 0; i < mainLayout.getComponentCount()-3; i++) {
            HorizontalLayout layout = (HorizontalLayout) mainLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            comboBox.clear();
        }
        specialNotesTextArea.clear();
        specialFollowUpCombo.clear();
        specialFollowUpTextArea.clear();
    }

    private int callGetter(Object obj, String fieldName){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            Method getter = pd.getReadMethod();
            return Integer.parseInt(getter.invoke(obj).toString());

        } catch (Exception e) {
            return 0;
        }
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
