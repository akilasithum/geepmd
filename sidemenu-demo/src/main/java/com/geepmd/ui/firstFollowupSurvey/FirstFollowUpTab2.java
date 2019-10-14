package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.entity.FirstFollowUpQ1;
import com.geepmd.entity.FirstFollowUpQ13;
import com.geepmd.entity.FirstFollowupQ2;
import com.geepmd.entity.FirstFollowupQ21;
import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.geepmd.utils.SurveyUtils.*;

public class FirstFollowUpTab2 extends VerticalLayout {

    Map<Integer,String> questionMap;
    Map<Integer,String> q1Map;
    Map<Integer, List<String>> answerMap;
    String language;
    FirstFollowUpSurvey survey;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    VerticalLayout q1Layout;
    VerticalLayout qLayout;
    HorizontalLayout q2Layout;
    HorizontalLayout q3Layout;

    public FirstFollowUpTab2(String language, FirstFollowUpSurvey survey){
        this.language = language;
        if(language.equals("EN")){
            //questionMap = EnglishMap.getquestion1Map();

        }
        else{
            questionMap = SinhalaMap.getFirstFollowUpQ2();
            q1Map = SinhalaMap.getFirstFollowTab2UpQ1Map();
            answerMap = SinhalaMap.getFirstFollowUpTab2LongAAnswerList();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){

        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        qLayout = new VerticalLayout();
        qLayout.setSizeFull();
        Label q1Header = new Label(questionMap.get(1));
        q1Header.setSizeFull();
        addComponent(q1Header);
        addComponent(q1Layout);
        addComponent(qLayout);
        qLayout.setMargin(false);
        createQ1Layout();
        q2Layout = addQuestionWithAnswerObjCombo(answerMap.get(2),questionMap.get(2));
        q3Layout = addQuestionWithAnswerObjCombo(answerMap.get(3),questionMap.get(3));
        qLayout.addComponent(q2Layout);
        qLayout.addComponent(q3Layout);
        q2Layout.setVisible(false);
        q3Layout.setVisible(false);

        Label pregnancyHeader = new Label("පහත ප\u200D්\u200Dරශ්න මෙම ගර්භණී කාලය සඳහා පමණි.");
        pregnancyHeader.setStyleName("padHeader");
        qLayout.addComponent(pregnancyHeader);


        ComboBox q4Combo = getComboBoxForDependentLayout(null,questionMap.get(4),qLayout);
        HorizontalLayout q5Layout = addHorizontalLayout(questionMap.get(5));
        qLayout.addComponent(q5Layout);
        q5Layout.setVisible(false);
        setDependentLayout(q4Combo,q5Layout,1);
        qLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(6),questionMap.get(6)));
        qLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(7),questionMap.get(7)));
        qLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(8),questionMap.get(8)));
        qLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(9),questionMap.get(9)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(10)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(11)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(12)));

        Label lifeTimeHeader = new Label("ඔබගේ ජීවිතකාලය තුළ");
        lifeTimeHeader.setStyleName("padHeader");
        qLayout.addComponent(lifeTimeHeader);
        qLayout.addComponent(addHorizontalLayout(questionMap.get(13)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(14)));

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(2);
        });
        addComponent(nextBtn);
    }

    public FirstFollowupQ2 getAnswer2(int surveyId){

        FirstFollowupQ2 answer = new FirstFollowupQ2();
        answer.setSurveyId(surveyId);
        if(q2Layout.isVisible()) {
            ComboBox comboBox = (ComboBox)(q2Layout.getComponent(1));
            answer.setM2(comboBox.getValue() != null ? ((Answer)comboBox.getValue()).getId() : 0);
        }else answer.setM2(8888);
        if(q3Layout.isVisible()) {
            ComboBox comboBox = (ComboBox)(q3Layout.getComponent(1));
            answer.setM3(comboBox.getValue() != null ? ((Answer)comboBox.getValue()).getId() : 0);
        }else answer.setM3(8888);
        for(int i = 3;i<qLayout.getComponentCount();i++){
            Component component = qLayout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout) qLayout.getComponent(i);

                String prefix = (i+1)+"";
                if(i> 12) prefix = i+"";
                    ComboBox comboBox = (ComboBox) layout.getComponent(1);
                    if(comboBox.getValue() != null) {
                        callSetter(answer,"m"+prefix,getId((Answer)comboBox.getValue()));
                    }
                    else if(!layout.isVisible()) callSetter(answer,"m"+prefix,8888);
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
    public List<FirstFollowupQ21> getAnswers21(int surveyId) {
        List<FirstFollowupQ21> answerList = new ArrayList<>();
        for(int i=1;i<11;i++){
            HorizontalLayout layout = (HorizontalLayout)q1Layout.getComponent(i);
            Label questionLabel = (Label) layout.getComponent(0);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
            ComboBox comboBox = (ComboBox) dependentLayout.getComponent(0);
            ComboBox increaseCombo = (ComboBox) dependentLayout.getComponent(1);
            ComboBox medicalCombo = (ComboBox) dependentLayout.getComponent(2);
            FirstFollowupQ21 answer = new FirstFollowupQ21();
            answer.setQuestion(questionLabel.getValue().substring(0,1));
            int yesNoVal = yesNoCombo.getValue() != null ? ((Answer)yesNoCombo.getValue()).getId() : 0;
            if(yesNoVal != 0){
                answer.setYesNo(yesNoVal);
                if(yesNoVal == 2){
                    answer.setTimes(8888);
                    answer.setIncreaseWhenTired(8888);
                    answer.setMedicalTaken(8888);
                }
                else{
                    answer.setTimes(comboBox.getValue() != null ? ((Answer)comboBox.getValue()).getId() : 0);
                    answer.setIncreaseWhenTired(increaseCombo.getValue() != null ? ((Answer)increaseCombo.getValue()).getId() : 0);
                    answer.setMedicalTaken(medicalCombo.getValue() != null ? ((Answer)medicalCombo.getValue()).getId() : 0);
                }
            }
            answer.setSurveyId(surveyId);
            answerList.add(answer);
        }
        return answerList;
    }

    public void setEditData(FirstFollowupQ2 answer){

        if(answer.getM2() != 0 && answer.getM2() != 8888) {
            ComboBox comboBox = (ComboBox)(q2Layout.getComponent(1));
            comboBox.setValue(getAnswerObj(answer.getM2(), answerMap.get(2)));
        }
        if(answer.getM3() != 0 && answer.getM3() != 8888) {
            ComboBox comboBox = (ComboBox)(q3Layout.getComponent(1));
            comboBox.setValue(getAnswerObj(answer.getM3(), answerMap.get(3)));
        }
        for(int i = 3;i<qLayout.getComponentCount();i++){
            Component component = qLayout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout) qLayout.getComponent(i);

                String prefix = (i+1)+"";
                if(i> 12) prefix = i+"";
                int val = callGetter(answer,"m"+prefix);
                ComboBox comboBox = (ComboBox) layout.getComponent(1);
                if(val != 0 && val != 8888) {
                    if (prefix.equals("4"))comboBox.setValue(getAnswerObj(answer.getM4(), Arrays.asList("1.ඔව්", "2.නැත")));
                    if (prefix.equals("5"))comboBox.setValue(getAnswerObj(answer.getM5(), Arrays.asList("1.ඔව්", "2.නැත")));
                    if (prefix.equals("6"))comboBox.setValue(getAnswerObj(answer.getM6(), answerMap.get(6)));
                    if (prefix.equals("7"))comboBox.setValue(getAnswerObj(answer.getM7(), answerMap.get(7)));
                    if (prefix.equals("8"))comboBox.setValue(getAnswerObj(answer.getM8(), answerMap.get(8)));
                    if (prefix.equals("9"))comboBox.setValue(getAnswerObj(answer.getM9(), answerMap.get(9)));
                    if (prefix.equals("10"))comboBox.setValue(getAnswerObj(answer.getM10(), Arrays.asList("1.ඔව්", "2.නැත")));
                    if (prefix.equals("11"))comboBox.setValue(getAnswerObj(answer.getM11(), Arrays.asList("1.ඔව්", "2.නැත")));
                    if (prefix.equals("12"))comboBox.setValue(getAnswerObj(answer.getM12(), Arrays.asList("1.ඔව්", "2.නැත")));
                    if (prefix.equals("13"))comboBox.setValue(getAnswerObj(answer.getM13(), Arrays.asList("1.ඔව්", "2.නැත")));
                    if (prefix.equals("14"))comboBox.setValue(getAnswerObj(answer.getM14(), Arrays.asList("1.ඔව්", "2.නැත")));
                }
            }
        }
    }

    public void setEditDataQ21(List<FirstFollowupQ21> answerList){
        Map<String, FirstFollowupQ21> map = answerList.stream().collect(Collectors.toMap(x->x.getQuestion(), x->x));
        for(int i = 1;i<11;i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout)component;
                Label label = ( Label) layout.getComponent(0);
                ComboBox yesNoCombo = (ComboBox)layout.getComponent(1);
                HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
                ComboBox comboBox = (ComboBox) dependentLayout.getComponent(0);
                ComboBox increaseCombo = (ComboBox) dependentLayout.getComponent(1);
                ComboBox medicalCombo = (ComboBox) dependentLayout.getComponent(2);
                String question = label.getValue().substring(0,1);
                FirstFollowupQ21 answer = map.get(question);
                if(answer != null){
                    int times = answer.getYesNo();
                    if(times == 1){
                        yesNoCombo.setValue(getAnswerObj(answer.getYesNo(), Arrays.asList("1.ඔව්","2.නැත")));
                        if(answer.getTimes() != 0)comboBox.setValue(getAnswerObj(answer.getTimes(), answerMap.get(1)));
                        if(answer.getIncreaseWhenTired() != 0) increaseCombo.setValue(getAnswerObj(answer.getIncreaseWhenTired(), Arrays.asList("1.ඔව්","2.නැත")));
                        if(answer.getMedicalTaken() != 0) medicalCombo.setValue(getAnswerObj(answer.getMedicalTaken(), Arrays.asList("1.ඔව්","2.නැත")));
                    }
                    else if(times == 2){
                        yesNoCombo.setValue(getAnswerObj(answer.getYesNo(), Arrays.asList("1.ඔව්","2.නැත")));
                    }
                }
            }
        }
    }

    private HorizontalLayout addHorizontalLayout(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getYesNoAnswer("SN"));
        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        return layout;
    }

    private void setDependentLayout(ComboBox comboBox,HorizontalLayout layout,int val){
        comboBox.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer != null && (answer.getId() == val)){
                layout.setVisible(true);
            }
            else{
                layout.setVisible(false);
            }
        });
    }

    private ComboBox getComboBoxForDependentLayout(List<String> answerList, String question, VerticalLayout mainLayout){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        if(answerList != null){
            comboBox.setItems(getAnwerObj(answerList));
            comboBox.setDescription(getAnswerDesc(answerList));
        }
        else{
            comboBox.setItems(getYesNoAnswer("SN"));
        }

        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        mainLayout.addComponent(layout);
        return comboBox;
    }

    private HorizontalLayout addQuestionWithAnswerObjCombo(List<String> answerList, String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getAnwerObj(answerList));
        comboBox.setDescription(getAnswerDesc(answerList));
        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        return layout;
    }

    private void createQ1Layout(){
        Label emptyLabel = new Label("");
        emptyLabel.setSizeFull();
        Label ifYesLabel = new Label("ඔව් නම්, වාර ගණන");
        ifYesLabel.setSizeFull();
        Label increaseLabel = new Label("වෙහෙස වීමකදී උත්සන්න වේද?");
        increaseLabel.setSizeFull();
        Label treatmentLabel = new Label("ඒ සඳහා වෛද්\u200Dය උපදෙස් ලබාගත්තේද?");
        treatmentLabel.setSizeFull();
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        headerLayout.addComponents(emptyLabel,ifYesLabel,increaseLabel,treatmentLabel);
        headerLayout.setExpandRatio(emptyLabel,4);
        headerLayout.setExpandRatio(ifYesLabel,1);
        headerLayout.setExpandRatio(increaseLabel,1);
        headerLayout.setExpandRatio(treatmentLabel,1);
        q1Layout.addComponent(headerLayout);
        List<Answer> yesNoAnswer = getYesNoAnswer("SN");
        List<Answer> timesList = getAnwerObj(answerMap.get(1));
        for(int i=1;i<11;i++){
            HorizontalLayout layout = new HorizontalLayout();
            layout.setSizeFull();
            Label questionLabel = new Label(q1Map.get(i));
            questionLabel.setSizeFull();

            ComboBox yesNoCombo = new ComboBox();
            yesNoCombo.setSizeFull();
            yesNoCombo.setTextInputAllowed(false);
            yesNoCombo.setItems(yesNoAnswer);

            HorizontalLayout dependentLayout = new HorizontalLayout();
            dependentLayout.setSizeFull();
            dependentLayout.setEnabled(false);

            ComboBox comboBox = new ComboBox();
            comboBox.setSizeFull();
            comboBox.setTextInputAllowed(false);
            comboBox.setItems(timesList);
            comboBox.setDescription(getAnswerDesc(answerMap.get(1)));

            ComboBox increaseCombo = new ComboBox();
            increaseCombo.setSizeFull();
            increaseCombo.setTextInputAllowed(false);
            increaseCombo.setItems(yesNoAnswer);

            ComboBox medicalCombo = new ComboBox();
            medicalCombo.setSizeFull();
            medicalCombo.setTextInputAllowed(false);
            medicalCombo.setItems(yesNoAnswer);
            dependentLayout.addComponents(comboBox,increaseCombo,medicalCombo);
            layout.addComponents(questionLabel,yesNoCombo,dependentLayout);
            layout.setExpandRatio(questionLabel,3);
            layout.setExpandRatio(yesNoCombo,1);
            layout.setExpandRatio(dependentLayout,3);

            int finalI = i;
            yesNoCombo.addValueChangeListener(event -> {
                Answer answer = (Answer) event.getValue();
                if(answer != null && (answer.getId() == 1)){
                    dependentLayout.setEnabled(true);
                    if(finalI ==1)  q2Layout.setVisible(true);
                    else if(finalI == 3) q3Layout.setVisible(true);
                }
                else{
                    dependentLayout.setEnabled(false);
                    if(finalI ==1)  q2Layout.setVisible(false);
                    else if(finalI == 3) q3Layout.setVisible(false);
                }
            });

            q1Layout.addComponent(layout);
        }
    }

    public void clearFields() {
            ComboBox comboBox = (ComboBox)(q2Layout.getComponent(1));
            comboBox.clear();
            ComboBox comboBox1 = (ComboBox)(q3Layout.getComponent(1));
            comboBox1.clear();
        for(int i = 3;i<qLayout.getComponentCount();i++){
            Component component = qLayout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout) qLayout.getComponent(i);
                ComboBox comboBox2 = (ComboBox) layout.getComponent(1);
                comboBox2.clear();
            }
        }
        for(int i = 1;i<11;i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout)component;
                Label label = ( Label) layout.getComponent(0);
                ComboBox yesNoCombo = (ComboBox)layout.getComponent(1);
                HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
                ComboBox comboBox4 = (ComboBox) dependentLayout.getComponent(0);
                ComboBox increaseCombo = (ComboBox) dependentLayout.getComponent(1);
                ComboBox medicalCombo = (ComboBox) dependentLayout.getComponent(2);
                yesNoCombo.clear();
                comboBox4.clear();
                increaseCombo.clear();
                medicalCombo.clear();
            }
        }
    }
}
