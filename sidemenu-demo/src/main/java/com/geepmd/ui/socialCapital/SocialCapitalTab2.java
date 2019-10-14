package com.geepmd.ui.socialCapital;

import com.geepmd.entity.SocialCapitalQ1;
import com.geepmd.entity.SocialCapitalQ2;
import com.geepmd.ui.SocialCapitalSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.geepmd.utils.SurveyUtils;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getAnswerDesc;
import static com.geepmd.utils.SurveyUtils.getAnswerObj;
import static com.geepmd.utils.SurveyUtils.getAnwerObj;

public class SocialCapitalTab2 extends VerticalLayout {

    Map<String,String> questionMap;
    Map<String,String> headerMap;
    Map<String, List<String>> answerMap;
    String language;
    SocialCapitalSurvey survey;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    VerticalLayout q1Layout;

    public SocialCapitalTab2(String language, SocialCapitalSurvey survey){
        this.language = language;
        if(language.equals("EN")){
            //questionMap = EnglishMap.getquestion1Map();

        }
        else{
            questionMap = SinhalaMap.getSocialCapitalQ2();
            headerMap = SinhalaMap.getSocialCapitalTab1Map();
            answerMap = SinhalaMap.getSocialCapitalBAnswerList();
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
        addComponent(q1Layout);

        q1Layout.addComponent(new Label(questionMap.get("1"))); //0
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.1"),questionMap.get("1.1"))); //1
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.1"),questionMap.get("1.2"))); //2
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.1"),questionMap.get("2.2"))); //3
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("1.1"),questionMap.get("2.3"))); //4
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("3"))); //5
        q1Layout.addComponent(new Label(questionMap.get("4"))); //6
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.1"))); //7
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.2"))); //8
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.3"))); //9
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.4"))); //10
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.5"))); //11
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.6"))); //12
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("3"),questionMap.get("4.7"))); //13
        q1Layout.addComponent(new Label(questionMap.get("6"))); //14
        Label q2Label = new Label("සෞඛ්\u200Dය සේවා.");
        q2Label.setStyleName("padHeader");
        q1Layout.addComponent(q2Label); //15
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("6"),questionMap.get("6.1.1"))); //16
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("6"),questionMap.get("6.1.2"))); //17
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("6"),questionMap.get("6.1.3"))); //18
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("6"),questionMap.get("6.1.4.1"))); //19
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("6"),questionMap.get("6.1.4.2"))); //20
        q1Layout.addComponent(SurveyUtils.addQuestionWithAnswerObjCombo(answerMap.get("6"),questionMap.get("6.1.5"))); //21
        q1Layout.addComponent(new Label(questionMap.get("7"))); //22
        Label descriptionLayout = new Label("පහත ලැයිස්තුව කියවන්න.\n" +
                "ඔබ පහත සදහන්  ඕනෑම කණ්ඩායමක සාමාජිකත්වය දරන්නේ නම් ”ඔව්” ලෙසද නැති නම් ”නැත” ලෙසදල එක් කාණ්ඩයකට අයත් කණ්ඩායම් කිහිපයක සාමාජිකත්වය දරන්නේනම් ”එකකට වැඩි” යන්නද, සළකුණු කරන්න. මේ එක් එක් සංවිධානයෙහි ඔබේ කි\u200D්\u200Dරයාකාරීත්වය කොපමණ දැයි 1-5 දක්වා අංකනය කොට දක්වන්න\n" +
                "5 = ඉතාම කි\u200D්\u200Dරයාකාරී 1 = කිසිසේතම කි\u200D්\u200Dරයාකරී නොවන");
        descriptionLayout.setSizeFull();
        q1Layout.addComponent(descriptionLayout); //23
        List<String> numberList = Arrays.asList("1","2","3","4","5");
        q1Layout.addComponent(addQuestionWithTwoCombo(answerMap.get("7"),numberList,questionMap.get("7.8"))); //24
        q1Layout.addComponent(addQuestionWithTwoCombo(answerMap.get("7"),numberList,questionMap.get("7.10"))); //25
        q1Layout.addComponent(addQuestionWithTwoCombo(answerMap.get("7"),numberList,questionMap.get("7.11"))); //26
    }

    public SocialCapitalQ2 getAnswers(int surveyId) {
        SocialCapitalQ2 answer = new SocialCapitalQ2();
        answer.setSurveyId(surveyId);
        for(int i = 0;i<q1Layout.getComponentCount();i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                if(i < 22){
                    ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                    if (comboBox.getValue() != null) {
                        int val = ((Answer) comboBox.getValue()).getId();
                        if (i == 1) answer.setM11(val);
                        if (i == 2) answer.setM12(val);
                        if (i == 3) answer.setM22(val);
                        if (i == 4) answer.setM23(val);
                        if (i == 5) answer.setM3(val);
                        if (i == 7) answer.setM41(val);
                        if (i == 8) answer.setM42(val);
                        if (i == 9) answer.setM43(val);
                        if (i == 10) answer.setM44(val);
                        if (i == 11) answer.setM45(val);
                        if (i == 12) answer.setM46(val);
                        if (i == 13) answer.setM47(val);
                        if (i == 16) answer.setM61(val);
                        if (i == 17) answer.setM62(val);
                        if (i == 18) answer.setM63(val);
                        if (i == 19) answer.setM641(val);
                        if (i == 20) answer.setM642(val);
                        if (i == 21) answer.setM65(val);
                    }
                }
                else{
                    ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                    ComboBox activeCombo = (ComboBox) ((HorizontalLayout) component).getComponent(2);
                    if (comboBox.getValue() != null) {
                        int val = ((Answer) comboBox.getValue()).getId();
                        if(i == 24) answer.setM78a(val);
                        if(i == 25) answer.setM710a(val);
                        if(i == 26) answer.setM711a(val);
                    }
                    if (activeCombo.getValue() != null) {
                        int val = Integer.parseInt(activeCombo.getValue().toString());
                        if(i == 24) answer.setM78b(val);
                        if(i == 25) answer.setM710b(val);
                        if(i == 26) answer.setM711b(val);
                    }
                }
            }
        }
        return answer;
    }

    public void setEditData(SocialCapitalQ2 answer) {
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                if(i < 22){
                    ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                    if (i == 1 && answer.getM11() != 0) comboBox.setValue(getAnswerObj(answer.getM11(), answerMap.get("1.1")));
                    if (i == 2 && answer.getM12() != 0) comboBox.setValue(getAnswerObj(answer.getM12(), answerMap.get("1.1")));
                    if (i == 3 && answer.getM22() != 0) comboBox.setValue(getAnswerObj(answer.getM22(), answerMap.get("1.1")));
                    if (i == 4 && answer.getM23() != 0) comboBox.setValue(getAnswerObj(answer.getM23(), answerMap.get("1.1")));
                    if (i == 5 && answer.getM3() != 0) comboBox.setValue(getAnswerObj(answer.getM3(), answerMap.get("3")));
                    if (i == 7 && answer.getM41() != 0) comboBox.setValue(getAnswerObj(answer.getM41(), answerMap.get("3")));
                    if (i == 8 && answer.getM42() != 0) comboBox.setValue(getAnswerObj(answer.getM42(), answerMap.get("3")));
                    if (i == 9 && answer.getM43() != 0) comboBox.setValue(getAnswerObj(answer.getM43(), answerMap.get("3")));
                    if (i == 10 && answer.getM44() != 0) comboBox.setValue(getAnswerObj(answer.getM44(), answerMap.get("3")));
                    if (i == 11 && answer.getM45() != 0) comboBox.setValue(getAnswerObj(answer.getM45(), answerMap.get("3")));
                    if (i == 12 && answer.getM46() != 0) comboBox.setValue(getAnswerObj(answer.getM46(), answerMap.get("3")));
                    if (i == 13 && answer.getM47() != 0) comboBox.setValue(getAnswerObj(answer.getM47(), answerMap.get("3")));
                    if (i == 16 && answer.getM61() != 0) comboBox.setValue(getAnswerObj(answer.getM61(), answerMap.get("6")));
                    if (i == 17 && answer.getM62() != 0) comboBox.setValue(getAnswerObj(answer.getM62(), answerMap.get("6")));
                    if (i == 18 && answer.getM63() != 0) comboBox.setValue(getAnswerObj(answer.getM63(), answerMap.get("6")));
                    if (i == 19 && answer.getM641() != 0) comboBox.setValue(getAnswerObj(answer.getM641(), answerMap.get("6")));
                    if (i == 20 && answer.getM642() != 0) comboBox.setValue(getAnswerObj(answer.getM642(), answerMap.get("6")));
                    if (i == 21 && answer.getM65() != 0) comboBox.setValue(getAnswerObj(answer.getM65(), answerMap.get("6")));
                }
                else{
                    ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                    ComboBox activeCombo = (ComboBox) ((HorizontalLayout) component).getComponent(2);

                        if(i == 24 && answer.getM78a() != 0) comboBox.setValue(getAnswerObj(answer.getM78a(), answerMap.get("7")));
                        if(i == 25 && answer.getM710a() != 0) comboBox.setValue(getAnswerObj(answer.getM710a(), answerMap.get("7")));
                        if(i == 26 && answer.getM711a() != 0) comboBox.setValue(getAnswerObj(answer.getM711a(), answerMap.get("7")));

                        if(i == 24 && answer.getM78b() != 0) activeCombo.setValue(answer.getM78b());
                        if(i == 25&& answer.getM710b() != 0) activeCombo.setValue(answer.getM710b());
                        if(i == 26&& answer.getM711b() != 0) activeCombo.setValue(answer.getM711b());
                }
            }
        }
    }

    public static HorizontalLayout addQuestionWithTwoCombo(List<String> answerList1,List<String> answerList2, String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();

        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getAnwerObj(answerList1));
        comboBox.setDescription(getAnswerDesc(answerList1));

        ComboBox comboBox1 = new ComboBox();
        comboBox1.setSizeFull();
        comboBox1.setTextInputAllowed(false);
        comboBox1.setItems(getAnwerObj(answerList2));
        comboBox1.setDescription(getAnswerDesc(answerList2));

        layout.addComponents(label,comboBox,comboBox1);
        layout.setExpandRatio(label,6);
        layout.setExpandRatio(comboBox,2);
        layout.setExpandRatio(comboBox1,2);
        return layout;
    }

    public void clearFields() {
        for (int i = 0; i < q1Layout.getComponentCount(); i++) {
            Component component = q1Layout.getComponent(i);
            if (component instanceof HorizontalLayout) {
                if(i < 22){
                    ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                    comboBox.clear();
                }
                else{
                    ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                    ComboBox activeCombo = (ComboBox) ((HorizontalLayout) component).getComponent(2);
                    comboBox.clear();
                    activeCombo.clear();
                }
            }
        }
    }
}
