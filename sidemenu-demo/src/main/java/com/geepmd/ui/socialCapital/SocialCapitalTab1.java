package com.geepmd.ui.socialCapital;

import com.geepmd.entity.SocialCapitalQ1;
import com.geepmd.ui.SocialCapitalSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getAnswerObj;

public class SocialCapitalTab1 extends VerticalLayout {

    Map<String,String> questionMap;
    Map<String,String> headerMap;
    Map<String, List<String>> answerMap;
    String language;
    SocialCapitalSurvey survey;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    VerticalLayout q1Layout;

    public SocialCapitalTab1(String language, SocialCapitalSurvey survey){
        this.language = language;
        if(language.equals("EN")){
            //questionMap = EnglishMap.getquestion1Map();

        }
        else{
            questionMap = SinhalaMap.getSocialCapitalQ1();
            headerMap = SinhalaMap.getSocialCapitalTab1Map();
            answerMap = SinhalaMap.getSocialCapitalAAnswerList();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout() {
        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        q1Layout.setMargin(false);

        Label qALabel = new Label(headerMap.get("1"));
        qALabel.setStyleName("padHeader");
        qALabel.setSizeFull();
        addComponent(qALabel);
        Label q1Label = new Label(questionMap.get("1"));
        q1Label.setSizeFull();
        addComponent(q1Label);
        addComponent(q1Layout);
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.1"),questionMap.get("1.1"))); //0
        Label q1AgreeLabel = new Label("ඔබ පහත ප\u200D්\u200Dරකාශය සමග කෙතරම් දුරට එකඟවන්නේද?");
        q1Layout.addComponent(q1AgreeLabel); //1
        q1AgreeLabel.setSizeFull();
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("1.2"))); //2
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("1.3"))); //3
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("1.4"))); //4
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("1.5"))); //5

        Label q2HeaderLabel = new Label(headerMap.get("2"));
        q2HeaderLabel.setStyleName("padHeader");
        q2HeaderLabel.setSizeFull();
        q1Layout.addComponent(q2HeaderLabel); //6
        Label q2Label = new Label(questionMap.get("2"));
        q2Label.setSizeFull();
        q1Layout.addComponent(q2Label); //7
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("2.1"))); //8
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("2.2"))); //9
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("2.3"))); //10
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("2.4"))); //11
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.2"),questionMap.get("2.5"))); //12
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("2.5"),questionMap.get("2.6"))); //13

        Label q3Label = new Label(headerMap.get("3"));
        q3Label.setStyleName("padHeader");
        q3Label.setSizeFull();
        q1Layout.addComponent(q3Label); //14
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("3"))); //15
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.1"))); //16
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.2"))); //17
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.3"))); //18
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.4"))); //19
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("5"))); //20
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("6"))); //21

        Label q4Label = new Label(headerMap.get("4"));
        q4Label.setStyleName("padHeader");
        q4Label.setSizeFull();
        q1Layout.addComponent(q4Label); //22
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("7.1"))); //23
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("7.2"))); //24
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("7.3"))); //25
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("7.4"))); //26
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("7.5"))); //27
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("7.6"))); //28

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(1);
        });
        addComponent(nextBtn);
    }

    public SocialCapitalQ1 getAnswers(int surveyId) {
        SocialCapitalQ1 answer = new SocialCapitalQ1();
        answer.setSurveyId(surveyId);
        for(int i = 0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                ComboBox comboBox = (ComboBox)((HorizontalLayout)component).getComponent(1);
                if(comboBox.getValue() != null){
                    int val = ((Answer)comboBox.getValue()).getId();
                    if(i==0) answer.setM11(val);
                    if(i==2) answer.setM12(val);
                    if(i==3) answer.setM13(val);
                    if(i==4) answer.setM14(val);
                    if(i==5) answer.setM15(val);
                    if(i==8) answer.setM21(val);
                    if(i==9) answer.setM22(val);
                    if(i==10) answer.setM23(val);
                    if(i==11) answer.setM24(val);
                    if(i==12) answer.setM25(val);
                    if(i==13) answer.setM26(val);
                    if(i==15) answer.setM3(val);
                    if(i==16) answer.setM41(val);
                    if(i==17) answer.setM42(val);
                    if(i==18) answer.setM43(val);
                    if(i==19) answer.setM44(val);
                    if(i==20) answer.setM5(val);
                    if(i==21) answer.setM6(val);
                    if(i==23) answer.setM71(val);
                    if(i==24) answer.setM72(val);
                    if(i==25) answer.setM73(val);
                    if(i==26) answer.setM74(val);
                    if(i==27) answer.setM75(val);
                    if(i==28) answer.setM76(val);
                }
            }
        }
        return answer;
    }

    public void setEditData(SocialCapitalQ1 answer) {
        for(int i = 0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                ComboBox comboBox = (ComboBox)((HorizontalLayout)component).getComponent(1);
                    if(i==0 && answer.getM11() != 0) comboBox.setValue(getAnswerObj(answer.getM11(), answerMap.get("1.1")));
                    if(i==2 && answer.getM12() != 0) comboBox.setValue(getAnswerObj(answer.getM12(), answerMap.get("1.2")));
                    if(i==3 && answer.getM13() != 0) comboBox.setValue(getAnswerObj(answer.getM13(), answerMap.get("1.2")));
                    if(i==4 && answer.getM14() != 0) comboBox.setValue(getAnswerObj(answer.getM14(), answerMap.get("1.2")));
                    if(i==5 && answer.getM15() != 0) comboBox.setValue(getAnswerObj(answer.getM15(), answerMap.get("1.2")));
                    if(i==8 && answer.getM21() != 0) comboBox.setValue(getAnswerObj(answer.getM21(), answerMap.get("1.2")));
                    if(i==9 && answer.getM22() != 0) comboBox.setValue(getAnswerObj(answer.getM22(), answerMap.get("1.2")));
                    if(i==10 && answer.getM23() != 0) comboBox.setValue(getAnswerObj(answer.getM23(), answerMap.get("1.2")));
                    if(i==11 && answer.getM24() != 0) comboBox.setValue(getAnswerObj(answer.getM24(), answerMap.get("1.2")));
                    if(i==12 && answer.getM25() != 0) comboBox.setValue(getAnswerObj(answer.getM25(), answerMap.get("1.2")));
                    if(i==13 && answer.getM26() != 0) comboBox.setValue(getAnswerObj(answer.getM26(), answerMap.get("2.5")));
                    if(i==15 && answer.getM3() != 0) comboBox.setValue(getAnswerObj(answer.getM3(), answerMap.get("3")));
                    if(i==16 && answer.getM41() != 0) comboBox.setValue(getAnswerObj(answer.getM41(), answerMap.get("3")));
                    if(i==17 && answer.getM42() != 0) comboBox.setValue(getAnswerObj(answer.getM42(), answerMap.get("3")));
                    if(i==18 && answer.getM43() != 0) comboBox.setValue(getAnswerObj(answer.getM43(), answerMap.get("3")));
                    if(i==19 && answer.getM44() != 0) comboBox.setValue(getAnswerObj(answer.getM44(), answerMap.get("3")));
                    if(i==20 && answer.getM5() != 0) comboBox.setValue(getAnswerObj(answer.getM5(), answerMap.get("3")));
                    if(i==21 && answer.getM6() != 0) comboBox.setValue(getAnswerObj(answer.getM6(), answerMap.get("3")));
                    if(i==23 && answer.getM71() != 0) comboBox.setValue(getAnswerObj(answer.getM71(), answerMap.get("3")));
                    if(i==24 && answer.getM72() != 0) comboBox.setValue(getAnswerObj(answer.getM72(), answerMap.get("3")));
                    if(i==25 && answer.getM73() != 0) comboBox.setValue(getAnswerObj(answer.getM73(), answerMap.get("3")));
                    if(i==26 && answer.getM74() != 0) comboBox.setValue(getAnswerObj(answer.getM74(), answerMap.get("3")));
                    if(i==27 && answer.getM75() != 0) comboBox.setValue(getAnswerObj(answer.getM75(), answerMap.get("3")));
                    if(i==28 && answer.getM76() != 0) comboBox.setValue(getAnswerObj(answer.getM76(), answerMap.get("3")));
            }
        }
    }

    public void clearFields() {
        for(int i = 0;i<q1Layout.getComponentCount();i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                comboBox.clear();
            }
        }
    }
}
