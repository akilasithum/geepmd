package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.entity.FirstFollowUpQ4;
import com.geepmd.entity.FirstFollowUpQ46;
import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class FirstFollowUpTab4 extends VerticalLayout {

    Map<String,String> questionMap;
    Map<Integer, List<String>> answerMap;
    String language;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    MarginInfo bottomMargin = new MarginInfo(true,false,true,false);
    MarginInfo noMargin = new MarginInfo(false);
    FirstFollowUpSurvey survey;
    VerticalLayout q1Layout;
    VerticalLayout q2Layout;
    VerticalLayout q3Layout;
    VerticalLayout q4Layout;
    VerticalLayout q5Layout;
    VerticalLayout q6Layout;

    public FirstFollowUpTab4(String language, FirstFollowUpSurvey survey){
        this.language = language;
        questionMap = SinhalaMap.getFirstFollowUpQ4();
        answerMap = SinhalaMap.getFirstFollowUpTab4LongAAnswerList();
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(bottomMargin);
    }

    private void createLayout(){
        Label q1Header = new Label("4.1 Examination");
        Label q2Header = new Label("4.2 Pre-cordial Examination");
        Label q3Header = new Label("4.3 Auscultation");
        Label q4Header = new Label("4.4 Anthropometric measurements");
        Label q5Header = new Label("4.5 CARDIOVASCULAR DISEASE – SCREENING CHECKLIST - DURING PAST 6 WEEKS");
        Label q6Header = new Label("4.6 CHECK LIST OF PREGNANCY COMPLICATIONS");

        q1Layout = new VerticalLayout();
        q1Layout.setMargin(leftMargin);
        addComponent(q1Header);
        addComponent(q1Layout);
        q2Layout = new VerticalLayout();
        q2Layout.setMargin(leftMargin);
        addComponent(q2Header);
        addComponent(q2Layout);
        q3Layout = new VerticalLayout();
        q3Layout.setMargin(leftMargin);
        addComponent(q3Header);
        addComponent(q3Layout);
        q4Layout = new VerticalLayout();
        q4Layout.setMargin(leftMargin);
        addComponent(q4Header);
        addComponent(q4Layout);
        q5Layout = new VerticalLayout();
        q5Layout.setMargin(leftMargin);
        addComponent(q5Header);
        addComponent(q5Layout);
        q6Layout = new VerticalLayout();
        q6Layout.setMargin(leftMargin);
        addComponent(q6Header);
        addComponent(q6Layout);

        Label q411Header = new Label("4.1.1 Pulse");
        q1Layout.addComponent(q411Header);
        q1Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.1.1.1"),leftMargin));
        q1Layout.addComponent(getYesNoAnswerLayout(questionMap.get("4.1.1.2"),leftMargin,"EN"));
        q1Layout.addComponent(getYesNoAnswerLayout(questionMap.get("4.1.1.3"),leftMargin,"EN"));
        Label q412Header = new Label("4.1.2 Blood pressure (in mmHg)");
        q1Layout.addComponent(q412Header);
        q1Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.1.2.1"),leftMargin));
        q1Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.1.2.2"),leftMargin));
        q1Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.1.2.3"),leftMargin));
        q1Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.1.2.4"),leftMargin));
        q1Layout.addComponent(getYesNoAnswerLayout(questionMap.get("4.1.2.5"),leftMargin,"EN"));

        for(int i = 1 ;i<6;i++){
            q2Layout.addComponent(getYesNoAnswerLayout(questionMap.get("4.2."+i),leftMargin,"EN"));
        }
        for(int i = 1 ;i<4;i++){
            q3Layout.addComponent(getYesNoAnswerLayout(questionMap.get("4.3."+i),leftMargin,"EN"));
        }
        q4Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.4.1"),leftMargin));

        ComboBox q51ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.5.1"),q5Layout);
        HorizontalLayout q52Layout = addQuestionWithAnswerObjCombo(answerMap.get(1),questionMap.get("4.5.2"));
        q52Layout.setVisible(false);
        q5Layout.addComponent(q52Layout);
        setDependentLayout(q51ComboBox,q52Layout,1);

        ComboBox q53ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.5.3"),q5Layout);
        HorizontalLayout q54Layout = addQuestionWithAnswerObjCombo(answerMap.get(2),questionMap.get("4.5.4"));
        q54Layout.setVisible(false);
        q5Layout.addComponent(q54Layout);
        setDependentLayout(q53ComboBox,q54Layout,1);
        for(int i = 5 ;i<11;i++){
            q5Layout.addComponent(getYesNoAnswerLayout(questionMap.get("4.5."+i),noMargin,"EN"));
        }

        ComboBox q61ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.6.1"),q6Layout);
        VerticalLayout q61DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q61DependentLayout);
        q61DependentLayout.setMargin(false);
        q61DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.1.1"),leftMargin));
        q61DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.1.2"),leftMargin));
        q61DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.1.3"),leftMargin));
        q61DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.1.4"),leftMargin));
        q61DependentLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(3),questionMap.get("4.6.1.5")));
        q61DependentLayout.setVisible(false);
        setDependentLayout(q61ComboBox,q61DependentLayout,1);

        ComboBox q62ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.6.2"),q6Layout);
        VerticalLayout q62DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q62DependentLayout);
        q62DependentLayout.setMargin(false);
        q62DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.2.1"),leftMargin));
        Label q622Label = new Label(questionMap.get("4.6.2.2"));
        VerticalLayout q622labelLayout = new VerticalLayout();
        q622labelLayout.setMargin(leftMargin);
        q622labelLayout.addComponent(q622Label);
        q622labelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.2.2.1"),leftMargin));
        q622labelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.2.2.2"),leftMargin));
        q62DependentLayout.addComponent(q622labelLayout);

        q62DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.2.3"),leftMargin));
        q62DependentLayout.setVisible(false);
        setDependentLayout(q62ComboBox,q62DependentLayout,1);

        ComboBox q63ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.6.3"),q6Layout);
        VerticalLayout q63DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q63DependentLayout);
        q63DependentLayout.setMargin(false);
        q63DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.1"),leftMargin));

        Label q632Label = new Label(questionMap.get("4.6.3.2"));
        VerticalLayout q632labelLayout = new VerticalLayout();
        q632labelLayout.setMargin(leftMargin);
        q632labelLayout.addComponent(q632Label);
        q632labelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.2.1"),leftMargin));
        q632labelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.2.2"),leftMargin));
        q63DependentLayout.addComponent(q632labelLayout);

        Label q633Label = new Label(questionMap.get("4.6.3.3"));
        VerticalLayout q633labelLayout = new VerticalLayout();
        q633labelLayout.setMargin(leftMargin);
        q633labelLayout.addComponent(q633Label);
        q633labelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.3.1"),leftMargin));
        q633labelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.3.2"),leftMargin));
        q63DependentLayout.addComponent(q633labelLayout);

        Label q634Label = new Label(questionMap.get("4.6.3.4"));
        VerticalLayout q634abelLayout = new VerticalLayout();
        q634abelLayout.setMargin(leftMargin);
        q634abelLayout.addComponent(q634Label);
        q634abelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.4.1"),leftMargin));
        q634abelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.4.2"),leftMargin));
        q634abelLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.4.3"),leftMargin));
        q63DependentLayout.addComponent(q634abelLayout);

        q63DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.3.5"),leftMargin));
        q63DependentLayout.setVisible(false);
        setDependentLayout(q63ComboBox,q63DependentLayout,1);


        ComboBox q64ComboBox = getComboBoxForDependentLayout(answerMap.get(4),questionMap.get("4.6.4"),q6Layout);
        VerticalLayout q64DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q64DependentLayout);
        q64DependentLayout.setMargin(false);
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.1"),leftMargin));
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.2"),leftMargin));
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.3"),leftMargin));
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.4"),leftMargin));
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.5"),leftMargin));
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.6"),leftMargin));
        q64DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.4.7"),leftMargin));
        q64DependentLayout.setVisible(false);
        setDependentLayout(q64ComboBox,q64DependentLayout);

        ComboBox q65ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.6.5"),q6Layout);
        VerticalLayout q65DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q65DependentLayout);
        q65DependentLayout.setMargin(false);
        q65DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.5.1"),leftMargin));
        q65DependentLayout.setVisible(false);
        setDependentLayout(q65ComboBox,q65DependentLayout,1);

        q6Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.6"),noMargin));
        q6Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.7"),noMargin));

        ComboBox q68ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.6.8"),q6Layout);
        VerticalLayout q68DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q68DependentLayout);
        q68DependentLayout.setMargin(false);
        q68DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.8.1"),leftMargin));
        q68DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.8.2"),leftMargin));
        q68DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.8.3"),leftMargin));
        q68DependentLayout.setVisible(false);
        setDependentLayout(q68ComboBox,q68DependentLayout,1);

        ComboBox q69ComboBox = getComboBoxForDependentLayout(Arrays.asList("1.Yes","2.No"),questionMap.get("4.6.9"),q6Layout);
        VerticalLayout q69DependentLayout = new VerticalLayout();
        q6Layout.addComponent(q69DependentLayout);
        q69DependentLayout.setMargin(false);
        q69DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.9.1"),leftMargin));
        q69DependentLayout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.9.2"),leftMargin));
        q69DependentLayout.setVisible(false);
        setDependentLayout(q69ComboBox,q69DependentLayout,1);

        q6Layout.addComponent(getTextBoxAnswerLayout(questionMap.get("4.6.10"),noMargin));
    }

    public FirstFollowUpQ46 getAnswersQ46(int surveyId){
        FirstFollowUpQ46 answer = new FirstFollowUpQ46();
        answer.setSurveyId(surveyId);
        for(int i = 0 ;i<q6Layout.getComponentCount();i++){
            Component component = q6Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                Component innerComponent = ((HorizontalLayout) component).getComponent(1);
                if(innerComponent instanceof ComboBox){
                    ComboBox comboBox = (ComboBox) innerComponent;
                    Answer answerObj = (Answer)comboBox.getValue();
                    int val = (answerObj != null) ? answerObj.getId() : 0;
                    if(i == 0) answer.setM1(val);
                    if(i == 2) answer.setM2(val);
                    if(i == 4) answer.setM3(val);
                    if(i == 6) answer.setM4(val);
                    if(i == 8) answer.setM5(val);
                    if(i == 12) answer.setM8(val);
                    if(i == 14) answer.setM9(val);
                }
                else if(innerComponent instanceof TextField){
                    String val = ((TextField) innerComponent).getValue();
                    if(i == 10) answer.setM6(val);
                    if(i == 11) answer.setM7(val);
                    if(i == 16) answer.setM10(val);
                }
            }
        }

        VerticalLayout q1Layout = (VerticalLayout)q6Layout.getComponent(1);
        boolean isLayoutVisibleQ1 = q1Layout.isVisible();
        for(int i = 0 ;i<4;i++){
            TextField textField = (TextField)((HorizontalLayout)q1Layout.getComponent(i)).getComponent(1);
            callSetter(answer,"m1"+(i+1),isLayoutVisibleQ1 ?textField.getValue() : "8888");
        }
        ComboBox q15Combo = (ComboBox)((HorizontalLayout)q1Layout.getComponent(4)).getComponent(1);
        Answer answerObj = (Answer)q15Combo.getValue();
        int val = answerObj != null ? answerObj.getId() : 0;
        answer.setM15(isLayoutVisibleQ1 ? val : 8888);

        VerticalLayout q2Layout = (VerticalLayout)q6Layout.getComponent(3);
        boolean isLayoutVisibleQ2 = q2Layout.isVisible();
        TextField q21Fld = (TextField) ((HorizontalLayout)q2Layout.getComponent(0)).getComponent(1);
        TextField q23Fld = (TextField) ((HorizontalLayout)q2Layout.getComponent(2)).getComponent(1);
        VerticalLayout q22Layout = (VerticalLayout) q2Layout.getComponent(1);
        TextField q221Fld = (TextField) ((HorizontalLayout)q22Layout.getComponent(1)).getComponent(1);
        TextField q222Fld = (TextField) ((HorizontalLayout)q22Layout.getComponent(2)).getComponent(1);
        answer.setM21(isLayoutVisibleQ2 ? q21Fld.getValue() : "8888");
        answer.setM221(isLayoutVisibleQ2 ? q221Fld.getValue() : "8888");
        answer.setM222(isLayoutVisibleQ2 ? q222Fld.getValue() : "8888");
        answer.setM23(isLayoutVisibleQ2 ? q23Fld.getValue() : "8888");

        VerticalLayout q3Layout = (VerticalLayout)q6Layout.getComponent(5);
        boolean isLayoutVisibleQ3 = q3Layout.isVisible();
        for(int i = 0 ;i < q3Layout.getComponentCount();i++){
            if(i == 0 || i == 4){
                TextField textField = (TextField)((HorizontalLayout)q3Layout.getComponent(i)).getComponent(1);
                callSetter(answer,"m3"+(i+1),isLayoutVisibleQ3 ?textField.getValue() : "8888");
            }
            else{
                int count = i == 3 ? 4 : 3;
                VerticalLayout layout = (VerticalLayout) q3Layout.getComponent(i);
                for(int j = 1 ;  j< count ;j++ ){
                    TextField textField = (TextField)((HorizontalLayout)layout.getComponent(j)).getComponent(1);
                    callSetter(answer,"m3"+(i+1)+""+j,isLayoutVisibleQ3 ?textField.getValue() : "8888");
                }
            }
        }
        VerticalLayout q4Layout = (VerticalLayout)q6Layout.getComponent(7);
        boolean isLayoutVisibleQ4 = q4Layout.isVisible();
        for(int i = 0 ;i < q4Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q4Layout.getComponent(i)).getComponent(1);
            callSetter(answer,"m4"+(i+1),isLayoutVisibleQ4 ?textField.getValue() : "8888");
        }

        VerticalLayout q5Layout = (VerticalLayout)q6Layout.getComponent(9);
        boolean isLayoutVisibleQ5 = q5Layout.isVisible();
        for(int i = 0 ;i < q5Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q5Layout.getComponent(i)).getComponent(1);
            callSetter(answer,"m5"+(i+1),isLayoutVisibleQ5 ?textField.getValue() : "8888");
        }

        VerticalLayout q8Layout = (VerticalLayout)q6Layout.getComponent(13);
        boolean isLayoutVisibleQ8 = q8Layout.isVisible();
        for(int i = 0 ;i < q8Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q8Layout.getComponent(i)).getComponent(1);
            callSetter(answer,"m8"+(i+1),isLayoutVisibleQ8 ?textField.getValue() : "8888");
        }
        VerticalLayout q9Layout = (VerticalLayout)q6Layout.getComponent(15);
        boolean isLayoutVisibleQ9 = q9Layout.isVisible();
        for(int i = 0 ;i < q9Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q9Layout.getComponent(i)).getComponent(1);
            callSetter(answer,"m9"+(i+1),isLayoutVisibleQ9 ?textField.getValue() : "8888");
        }
        return answer;
    }

    public void setEditData(FirstFollowUpQ46 answer){
        for(int i = 0 ;i<q6Layout.getComponentCount();i++){
            Component component = q6Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                Component innerComponent = ((HorizontalLayout) component).getComponent(1);
                if(innerComponent instanceof ComboBox){
                    ComboBox comboBox = (ComboBox) innerComponent;
                    if(i == 0 && answer.getM1() != 0) comboBox.setValue(getAnswerObj(answer.getM1(),Arrays.asList("1.Yes","2.No")));
                    if(i == 2 && answer.getM2() != 0) comboBox.setValue(getAnswerObj(answer.getM2(),Arrays.asList("1.Yes","2.No")));
                    if(i == 4 && answer.getM3() != 0) comboBox.setValue(getAnswerObj(answer.getM3(),Arrays.asList("1.Yes","2.No")));
                    if(i == 6 && answer.getM4() != 0) comboBox.setValue(getAnswerObj(answer.getM4(),Arrays.asList("1.Yes","2.No")));
                    if(i == 8 && answer.getM5() != 0) comboBox.setValue(getAnswerObj(answer.getM5(),Arrays.asList("1.Yes","2.No")));
                    if(i == 12 && answer.getM8() != 0) comboBox.setValue(getAnswerObj(answer.getM8(),Arrays.asList("1.Yes","2.No")));
                    if(i == 14 && answer.getM9() != 0) comboBox.setValue(getAnswerObj(answer.getM9(),Arrays.asList("1.Yes","2.No")));
                }
                else if(innerComponent instanceof TextField){
                    TextField textField = (TextField) innerComponent;
                    if(i == 10 && answer.getM6() != null && !answer.getM6().isEmpty()) textField.setValue(answer.getM6());
                    if(i == 11 && answer.getM7() != null && !answer.getM7().isEmpty()) textField.setValue(answer.getM7());
                    if(i == 16 && answer.getM10() != null && !answer.getM10().isEmpty()) textField.setValue(answer.getM10());
                }
            }
        }

        VerticalLayout q1Layout = (VerticalLayout)q6Layout.getComponent(1);
        for(int i = 0 ;i<4;i++){
            TextField textField = (TextField)((HorizontalLayout)q1Layout.getComponent(i)).getComponent(1);
            String val = callGetterStr(answer,"m1"+(i+1));
            if(val != null && !val.equals("8888"))textField.setValue(val);
        }
        ComboBox q15Combo = (ComboBox)((HorizontalLayout)q1Layout.getComponent(4)).getComponent(1);
        q15Combo.setValue(getAnswerObj(answer.getM15(),answerMap.get(3)));

        VerticalLayout q2Layout = (VerticalLayout)q6Layout.getComponent(3);
        TextField q21Fld = (TextField) ((HorizontalLayout)q2Layout.getComponent(0)).getComponent(1);
        TextField q23Fld = (TextField) ((HorizontalLayout)q2Layout.getComponent(2)).getComponent(1);
        VerticalLayout q22Layout = (VerticalLayout) q2Layout.getComponent(1);
        TextField q221Fld = (TextField) ((HorizontalLayout)q22Layout.getComponent(1)).getComponent(1);
        TextField q222Fld = (TextField) ((HorizontalLayout)q22Layout.getComponent(2)).getComponent(1);

        if(answer.getM21() != null && !answer.getM21().equals("8888"))q21Fld.setValue(answer.getM21());
        if(answer.getM221() != null && !answer.getM221().equals("8888"))q221Fld.setValue(answer.getM221());
        if(answer.getM222() != null && !answer.getM222().equals("8888"))q222Fld.setValue(answer.getM222());
        if(answer.getM23() != null && !answer.getM23().equals("8888"))q23Fld.setValue(answer.getM23());

        VerticalLayout q3Layout = (VerticalLayout)q6Layout.getComponent(5);
        for(int i = 0 ;i < q3Layout.getComponentCount();i++){
            if(i == 0 || i == 4){
                TextField textField = (TextField)((HorizontalLayout)q3Layout.getComponent(i)).getComponent(1);
                String val = callGetterStr(answer,"m3"+(i+1));
                if(val != null && !val.equals("8888")) textField.setValue(val);
            }
            else{
                int count = i == 3 ? 4 : 3;
                VerticalLayout layout = (VerticalLayout) q3Layout.getComponent(i);
                for(int j = 1 ;  j< count ;j++ ){
                    TextField textField = (TextField)((HorizontalLayout)layout.getComponent(j)).getComponent(1);
                    String val = callGetterStr(answer,"m3"+(i+1)+""+j);
                    if(val != null && !val.equals("8888")) textField.setValue(val);
                }
            }
        }

        VerticalLayout q4Layout = (VerticalLayout)q6Layout.getComponent(7);
        for(int i = 0 ;i < q4Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q4Layout.getComponent(i)).getComponent(1);
            String val = callGetterStr(answer,"m4"+(i+1));
            if(val != null && !val.equals("8888")) textField.setValue(val);
        }

        VerticalLayout q5Layout = (VerticalLayout)q6Layout.getComponent(9);
        for(int i = 0 ;i < q5Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q5Layout.getComponent(i)).getComponent(1);
            String val = callGetterStr(answer,"m5"+(i+1));
            if(val != null && !val.equals("8888")) textField.setValue(val);
        }

        VerticalLayout q8Layout = (VerticalLayout)q6Layout.getComponent(13);
        for(int i = 0 ;i < q8Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q8Layout.getComponent(i)).getComponent(1);
            String val = callGetterStr(answer,"m8"+(i+1));
            if(val != null && !val.equals("8888")) textField.setValue(val);
        }
        VerticalLayout q9Layout = (VerticalLayout)q6Layout.getComponent(15);
        for(int i = 0 ;i < q9Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q9Layout.getComponent(i)).getComponent(1);
            String val = callGetterStr(answer,"m9"+(i+1));
            if(val != null && !val.equals("8888")) textField.setValue(val);
        }
    }

    public FirstFollowUpQ4 getAnswers(int surveyId) {

        FirstFollowUpQ4 answer = new FirstFollowUpQ4();
        answer.setSurveyId(surveyId);
        int j = 1;
        for(int i=0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                Component fieldComp = ((HorizontalLayout)component).getComponent(1);
                if(j == 2 || j == 3 || j == 8){
                    ComboBox comboBox = (ComboBox) fieldComp;
                    Answer answerObj = (Answer)comboBox.getValue();
                    int val = answerObj != null ? answerObj.getId() : 0;
                    if(j == 2) answer.setM112(val);
                    if(j == 3) answer.setM113(val);
                    if(j == 8) answer.setM125(val);
                }
                else{
                    TextField textField = (TextField) fieldComp;
                    String val = textField.getValue();
                    if(j == 1) answer.setM111(val);
                    if(j == 4) answer.setM121(val);
                    if(j == 5) answer.setM122(val);
                    if(j == 6) answer.setM123(val);
                    if(j == 7) answer.setM124(val);
                }
                j++;
            }
        }

        for(int i = 0 ;i<5;i++){
            ComboBox comboBox = (ComboBox)((HorizontalLayout)q2Layout.getComponent(i)).getComponent(1);
            Answer answerObj = (Answer)comboBox.getValue();
            int val = answerObj != null ? answerObj.getId() : 0;
            callSetter(answer,"m2"+(i+1),val);
        }

        for(int i = 0 ;i<3;i++){
            ComboBox comboBox = (ComboBox)((HorizontalLayout)q3Layout.getComponent(i)).getComponent(1);
            Answer answerObj = (Answer)comboBox.getValue();
            int val = answerObj != null ? answerObj.getId() : 0;
            callSetter(answer,"m3"+(i+1),val);
        }
        TextField answer4TextFld = (TextField)((HorizontalLayout)q4Layout.getComponent(0)).getComponent(1);
        answer.setM41(answer4TextFld.getValue());

        for( int i = 0;i<q5Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)q5Layout.getComponent(i);
            ComboBox comboBox = (ComboBox)layout.getComponent(1);
            Answer answerObj = (Answer)comboBox.getValue();
            int val = answerObj != null ? answerObj.getId() : 0;
            if(i != 1 || i != 3){
                callSetter(answer,"m5"+(i+1),val);
            }
            else{
                if(layout.isVisible()){
                    if(i == 1 || i == 3) answer.setM51(val);
                }
            }
        }
        return answer;
    }

    public void setEditData(FirstFollowUpQ4 answer) {
        int j = 1;
        for(int i=0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                Component fieldComp = ((HorizontalLayout)component).getComponent(1);
                if(j == 2 || j == 3 || j == 8){
                    ComboBox comboBox = (ComboBox) fieldComp;
                    if(j == 2 && answer.getM112() != 0) comboBox.setValue(getAnswerObj(answer.getM112(),Arrays.asList("1.Yes","2.No")));
                    if(j == 3 && answer.getM113() != 0) comboBox.setValue(getAnswerObj(answer.getM113(),Arrays.asList("1.Yes","2.No")));
                    if(j == 8 && answer.getM125() != 0) comboBox.setValue(getAnswerObj(answer.getM125(),Arrays.asList("1.Yes","2.No")));
                }
                else{
                    TextField textField = (TextField) fieldComp;
                    if(j == 1 && answer.getM111() != null && !answer.getM111().isEmpty()) textField.setValue(answer.getM111());
                    if(j == 4 && answer.getM121() != null && !answer.getM121().isEmpty()) textField.setValue(answer.getM121());
                    if(j == 5 && answer.getM122() != null && !answer.getM122().isEmpty()) textField.setValue(answer.getM122());
                    if(j == 6 && answer.getM123() != null && !answer.getM123().isEmpty()) textField.setValue(answer.getM123());
                    if(j == 7 && answer.getM124() != null && !answer.getM124().isEmpty()) textField.setValue(answer.getM124());
                }
                j++;
            }
        }

        for(int i = 0 ;i<5;i++){
            ComboBox comboBox = (ComboBox)((HorizontalLayout)q2Layout.getComponent(i)).getComponent(1);
            int val = callGetter(answer,"m2"+(i+1));
            if(val != 0){
                comboBox.setValue(getAnswerObj(val,Arrays.asList("1.Yes","2.No")));
            }
        }

        for(int i = 0 ;i<3;i++){
            ComboBox comboBox = (ComboBox)((HorizontalLayout)q3Layout.getComponent(i)).getComponent(1);
            int val = callGetter(answer,"m3"+(i+1));
            if(val != 0){
                comboBox.setValue(getAnswerObj(val,Arrays.asList("1.Yes","2.No")));
            }
        }
        TextField answer4TextFld = (TextField)((HorizontalLayout)q4Layout.getComponent(0)).getComponent(1);
        answer4TextFld.setValue(answer.getM41());

        for( int i = 0;i<q5Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)q5Layout.getComponent(i);
            ComboBox comboBox = (ComboBox)layout.getComponent(1);
            int val = callGetter(answer,"m5"+(i+1));
            if(val != 0){
                if(i == 1){
                    comboBox.setValue(getAnswerObj(val,answerMap.get(1)));
                }
                else if(i == 3){
                    comboBox.setValue(getAnswerObj(val,answerMap.get(2)));
                }
                else{
                    comboBox.setValue(getAnswerObj(val,Arrays.asList("1.Yes","2.No")));
                }

            }
        }
    }

    public void clearFields() {
        int j = 1;
        for(int i=0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                Component fieldComp = ((HorizontalLayout)component).getComponent(1);
                if(j == 2 || j == 3 || j == 8){
                    ComboBox comboBox = (ComboBox) fieldComp;
                    comboBox.clear();
                }
                else{
                    TextField textField = (TextField) fieldComp;
                    textField.clear();
                }
                j++;
            }
        }

        for(int i = 0 ;i<5;i++){
            ComboBox comboBox = (ComboBox)((HorizontalLayout)q2Layout.getComponent(i)).getComponent(1);
            comboBox.clear();
        }

        for(int i = 0 ;i<3;i++){
            ComboBox comboBox = (ComboBox)((HorizontalLayout)q3Layout.getComponent(i)).getComponent(1);
            comboBox.clear();
        }
        TextField answer4TextFld = (TextField)((HorizontalLayout)q4Layout.getComponent(0)).getComponent(1);
        answer4TextFld.clear();

        for( int i = 0;i<q5Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout)q5Layout.getComponent(i);
            ComboBox comboBox = (ComboBox)layout.getComponent(1);
            comboBox.clear();
        }



        for(int i = 0 ;i<q6Layout.getComponentCount();i++){
            Component component = q6Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                Component innerComponent = ((HorizontalLayout) component).getComponent(1);
                if(innerComponent instanceof ComboBox){
                    ComboBox comboBox = (ComboBox) innerComponent;
                    comboBox.clear();
                }
                else if(innerComponent instanceof TextField){
                    TextField textField = (TextField) innerComponent;
                    textField.clear();
                }
            }
        }

        VerticalLayout q1Layout = (VerticalLayout)q6Layout.getComponent(1);
        for(int i = 0 ;i<4;i++){
            TextField textField = (TextField)((HorizontalLayout)q1Layout.getComponent(i)).getComponent(1);
            textField.clear();
        }
        ComboBox q15Combo = (ComboBox)((HorizontalLayout)q1Layout.getComponent(4)).getComponent(1);
        q15Combo.clear();

        VerticalLayout q2Layout = (VerticalLayout)q6Layout.getComponent(3);
        TextField q21Fld = (TextField) ((HorizontalLayout)q2Layout.getComponent(0)).getComponent(1);
        TextField q23Fld = (TextField) ((HorizontalLayout)q2Layout.getComponent(2)).getComponent(1);
        VerticalLayout q22Layout = (VerticalLayout) q2Layout.getComponent(1);
        TextField q221Fld = (TextField) ((HorizontalLayout)q22Layout.getComponent(1)).getComponent(1);
        TextField q222Fld = (TextField) ((HorizontalLayout)q22Layout.getComponent(2)).getComponent(1);

        q21Fld.clear();
        q221Fld.clear();
        q222Fld.clear();
        q23Fld.clear();

        VerticalLayout q3Layout = (VerticalLayout)q6Layout.getComponent(5);
        for(int i = 0 ;i < q3Layout.getComponentCount();i++){
            if(i == 0 || i == 4){
                TextField textField = (TextField)((HorizontalLayout)q3Layout.getComponent(i)).getComponent(1);
                textField.clear();
            }
            else{
                int count = i == 3 ? 4 : 3;
                VerticalLayout layout = (VerticalLayout) q3Layout.getComponent(i);
                for(int z = 1 ;  z< count ;z++ ){
                    TextField textField = (TextField)((HorizontalLayout)layout.getComponent(z)).getComponent(1);
                    textField.clear();
                }
            }
        }

        VerticalLayout q4Layout = (VerticalLayout)q6Layout.getComponent(7);
        for(int i = 0 ;i < q4Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q4Layout.getComponent(i)).getComponent(1);
            textField.clear();
        }

        VerticalLayout q5Layout = (VerticalLayout)q6Layout.getComponent(9);
        for(int i = 0 ;i < q5Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q5Layout.getComponent(i)).getComponent(1);
            textField.clear();
        }

        VerticalLayout q8Layout = (VerticalLayout)q6Layout.getComponent(13);
        for(int i = 0 ;i < q8Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q8Layout.getComponent(i)).getComponent(1);
            textField.clear();
        }
        VerticalLayout q9Layout = (VerticalLayout)q6Layout.getComponent(15);
        for(int i = 0 ;i < q9Layout.getComponentCount();i++){
            TextField textField = (TextField)((HorizontalLayout)q9Layout.getComponent(i)).getComponent(1);
            textField.clear();
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

    private String callGetterStr(Object obj, String fieldName){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            Method getter = pd.getReadMethod();
            return getter.invoke(obj).toString();

        } catch (Exception e) {
            return "";
        }
    }
}
