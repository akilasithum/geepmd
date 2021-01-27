package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.entity.FirstFollowUpQ1;
import com.geepmd.entity.FirstFollowUpQ125;
import com.geepmd.entity.FirstFollowUpQ126;
import com.geepmd.entity.FirstFollowUpQ13;
import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.addons.ComboBoxMultiselect;
import java.beans.PropertyDescriptor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static com.geepmd.utils.SurveyUtils.*;

public class FirstFollowUpTab1 extends VerticalLayout {

    Map<Integer,String> q11Map;
    Map<Integer,String> q13Map;
    Map<Integer,List<String>> answerMap;
    String language;
    FirstFollowUpSurvey survey;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    VerticalLayout q1Layout;
    VerticalLayout q2Layout;
    VerticalLayout q3Layout;
    VerticalLayout q25Layout;
    VerticalLayout q26Layout;
    List<Answer> q12AnswerList;
    List<Answer> q22AnswerList;
    List<Answer> q24AnswerList;
    DateField followUpDate;

    public FirstFollowUpTab1(String language, FirstFollowUpSurvey survey){
        this.language = language;
        if(language.equals("EN")){
            //questionMap = EnglishMap.getquestion1Map();

        }
        else{
            q11Map = SinhalaMap.getFirstFollowUpQ1();
            q13Map = SinhalaMap.getFirstFollowUpQ13Map();
            answerMap = SinhalaMap.getFirstFollowUpLongAAnswerList();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(){
        followUpDate = new DateField("Survey Date");
        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        addComponent(followUpDate);
        addComponent(q1Layout);
        q1Layout.setMargin(false);
        ComboBox q11Combo = getComboBoxForDependentLayout(null,q11Map.get(1),q1Layout);
        HorizontalLayout q12Layout = addHorizontalLayout(q11Map.get(2));
        q12Layout.setVisible(false);
        setDependentLayout(q11Combo,q12Layout,1);

        q12AnswerList = getAnwerObj(answerMap.get(12));
        q22AnswerList = getAnwerObj(answerMap.get(22));
        q24AnswerList = getAnwerObj(answerMap.get(24));
        q1Layout.addComponent(q12Layout);
        Label q13Label = new Label(q11Map.get(3));
        addComponent(q13Label);

        HorizontalLayout q13HeaderLayout = new HorizontalLayout();
        q13HeaderLayout.setSizeFull();
        addComponent(q13HeaderLayout);
        Label diseaseLabel = new Label("රෝගය");
        diseaseLabel.setStyleName("padHeader");
        Label isMedicalLabel = new Label("ප\u200D්\u200Dරතිකාර ලබාගත්තේද?");
        isMedicalLabel.setStyleName("padHeader");
        Label medicalTimes = new Label("වාර ගණන");
        medicalTimes.setStyleName("padHeader");
        diseaseLabel.setSizeFull();
        isMedicalLabel.setSizeFull();
        medicalTimes.setSizeFull();
        q13HeaderLayout.addComponents(diseaseLabel,isMedicalLabel,medicalTimes);
        q13HeaderLayout.setExpandRatio(diseaseLabel,8);
        q13HeaderLayout.setExpandRatio(isMedicalLabel,2);
        q13HeaderLayout.setExpandRatio(medicalTimes,2);

        q2Layout = new VerticalLayout();
        q2Layout.setSizeFull();
        addComponent(q2Layout);
        q2Layout.setMargin(leftMargin);

        for(int i = 0;i<q13Map.size();i++){
            q2Layout.addComponent(addQ13HorizontalLayout(q13Map.get(i+1)));
        }

        q3Layout = new VerticalLayout();
        q3Layout.setSizeFull();
        addComponent(q3Layout);
        q3Layout.setMargin(false);

        ComboBox q4Combo = getComboBoxForDependentLayout(null,q11Map.get(4),q3Layout);
        HorizontalLayout q5Layout = addHorizontalLayout(q11Map.get(5));
        q3Layout.addComponent(q5Layout);
        q5Layout.setVisible(false);
        setDependentLayout(q4Combo,q5Layout,1);
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,10,q11Map.get(6)));

        ComboBox q7Combo = getComboBoxForDependentLayout(null,q11Map.get(7),q3Layout);
        HorizontalLayout q8Layout = addQuestionWithAnswerObjCombo(answerMap.get(8),q11Map.get(8));
        q3Layout.addComponent(q8Layout);
        q8Layout.setVisible(false);
        setDependentLayout(q7Combo,q8Layout,1);

        q3Layout.addComponent(addHorizontalLayout(q11Map.get(9)));
        ComboBox q10Combo = getComboBoxForDependentLayout(null,q11Map.get(10),q3Layout);

        VerticalLayout q11VertLayout = new VerticalLayout();
        q11VertLayout.setSizeFull();
        TextField q11Text = new TextField();
        q11Text.setDescription("සඳහන් කරන්න.");
        q11Text.setWidth("250px");
        ComboBox q11ComboBox = getComboBoxForDependentLayout(answerMap.get(11),q11Map.get(11),q11VertLayout);
        q11Text.setVisible(false);
        setDependentLayout(q11ComboBox,q11Text,7);
        q11VertLayout.addComponents(q11Text);
        q11VertLayout.setComponentAlignment(q11Text,Alignment.MIDDLE_RIGHT);
        q3Layout.addComponent(q11VertLayout);
        q11VertLayout.setVisible(false);
        q11VertLayout.setMargin(false);
        setDependentLayout(q10Combo,q11VertLayout,2);


        ComboBoxMultiselect q12Combo = addMultiSelectComboWithLayout(answerMap.get(12),q11Map.get(12),q3Layout,q12AnswerList);

        VerticalLayout q13VertLayout = new VerticalLayout();
        q13VertLayout.setSizeFull();
        TextField q13Text = new TextField();
        q13Text.setDescription("සඳහන් කරන්න.");
        q13Text.setWidth("250px");
        ComboBox q12ComboBox = getComboBoxForDependentLayout(answerMap.get(13),q11Map.get(13),q13VertLayout);
        q13Text.setVisible(false);
        setDependentLayout(q12ComboBox,q13Text,5);
        q13VertLayout.addComponents(q13Text);
        q13VertLayout.setComponentAlignment(q13Text,Alignment.MIDDLE_RIGHT);
        q3Layout.addComponent(q13VertLayout);
        q13VertLayout.setVisible(false);
        q13VertLayout.setMargin(false);

        q12Combo.addValueChangeListener(event -> {
            if(event.getValue() != null){
                String str =  getStringFromSet(q12Combo.getValue());
                if(str.contains("2")){
                    q13VertLayout.setVisible(true);
                }
                else {
                    q13VertLayout.setVisible(false);
                }
            }
        });


        q3Layout.addComponent(addHorizontalLayout(q11Map.get(14)));
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,30,q11Map.get(15)));




        VerticalLayout q16VertLayout = new VerticalLayout();
        q16VertLayout.setSizeFull();
        TextField q16Text = new TextField("නම සහ ප්\u200Dරාමාණය ( උදා : නම 20ml)");
        q16Text.setDescription("නම සහ ප්\u200Dරාමාණය ( උදා : නම 20ml)");
        q16Text.setWidth("250px");
        ComboBox q16Combo = getComboBoxForDependentLayout(answerMap.get(16),q11Map.get(16),q16VertLayout);
        q16Text.setVisible(false);
        q16VertLayout.addComponents(q16Text);
        q16VertLayout.setComponentAlignment(q16Text,Alignment.MIDDLE_RIGHT);
        q3Layout.addComponent(q16VertLayout);
        q16VertLayout.setMargin(false);

        HorizontalLayout q17Layout = addQuestionWithNumberRangeCombo(0,30,q11Map.get(17));
        q3Layout.addComponent(q17Layout);
        HorizontalLayout q18Layout = addQuestionWithAnswerObjCombo(answerMap.get(18),q11Map.get(18));
        q3Layout.addComponent(q18Layout);
        q17Layout.setVisible(false);
        q18Layout.setVisible(false);
        q16Combo.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer != null && (answer.getId() == 2)){
                q17Layout.setVisible(true);
                q18Layout.setVisible(true);
            }
            else{
                q17Layout.setVisible(false);
                q18Layout.setVisible(false);
            }
            if(answer != null && answer.getId() == 4){
                q16Text.setVisible(true);
            }
            else{
                q16Text.setVisible(false);
            }
        });
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(19),q11Map.get(19)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(20),q11Map.get(20)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(21)));
        addMultiSelectComboWithLayout(answerMap.get(22),q11Map.get(22),q3Layout,q22AnswerList);
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,7,q11Map.get(23)));

        VerticalLayout q24VertLayout = new VerticalLayout();
        q24VertLayout.setSizeFull();
        TextField q24Text = new TextField();
        q24Text.setWidth("250px");
        q24Text.setVisible(false);
        q3Layout.addComponent(q24VertLayout);
        q24VertLayout.setMargin(false);
        ComboBoxMultiselect q24Combo =  addMultiSelectComboWithLayout(answerMap.get(24),q11Map.get(24),q24VertLayout,q24AnswerList);
        q24VertLayout.addComponents(q24Text);
        q24VertLayout.setComponentAlignment(q24Text,Alignment.MIDDLE_RIGHT);
        q24Combo.addValueChangeListener(event -> {
            if(event.getValue() != null){
                String str =  getStringFromSet(q24Combo.getValue());
                if(str.contains("6")){
                    q24Text.setVisible(true);
                }
                else {
                    q24Text.setVisible(false);
                }
            }
        });

        Label q25Header = new Label(q11Map.get(25));
        q25Header.setSizeFull();
        q3Layout.addComponent(q25Header);
        q25Layout = createQ25();
        q3Layout.addComponent(q25Layout);
        Label q26Header = new Label(q11Map.get(26));
        q26Header.setSizeFull();
        q3Layout.addComponent(q26Header);
        q26Layout = createQ26();
        q3Layout.addComponent(q26Layout);

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(1);
        });
        addComponent(nextBtn);
    }

    public FirstFollowUpQ1 getAnswers(int surveyId) {

        FirstFollowUpQ1 answer = new FirstFollowUpQ1();
        answer.setSurveyDate(getDateStr(followUpDate.getValue()));

        answer.setSurveyId(surveyId);
        for(int i = 0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                if(i == 0 && comboBox.getValue() != null){
                    answer.setM1(((Answer) comboBox.getValue()).getId());
                }
                else if( i == 1){
                    if(comboBox.getValue() != null) answer.setM2(((Answer) comboBox.getValue()).getId());
                    else if(!component.isVisible()) answer.setM2(8888);
                }
            }
        }
        for(int i=0;i<22;i++){
            Component component = q3Layout.getComponent(i);
            String prefix = (i+4)+"";
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout) q3Layout.getComponent(i);
                List<String> varcharList = Arrays.asList("11","12","13","16","22","24");
                if(!varcharList.contains(prefix) ){
                    ComboBox comboBox = (ComboBox) layout.getComponent(1);
                    if(comboBox.getValue() != null) {
                        Object comboVal = comboBox.getValue();
                        if(comboVal instanceof String || comboVal instanceof Integer){
                            callSetter(answer,"m"+prefix,Integer.parseInt(comboVal.toString()));
                        }
                        else {
                            callSetter(answer,"m"+prefix,getId((Answer)comboBox.getValue()));
                        }
                    }
                    else if(!layout.isVisible()) callSetter(answer,"m"+prefix,8888);
                }
                else{
                    if(prefix.equalsIgnoreCase("12") || prefix.equalsIgnoreCase("22")){
                        ComboBoxMultiselect comboBox = (ComboBoxMultiselect) layout.getComponent(1);
                        if(comboBox.getValue() != null && !comboBox.getValue().isEmpty()){
                            if(prefix.equals("12"))answer.setM12(getStringFromSet(comboBox.getValue()));
                            else if(prefix.equals("22"))answer.setM22(getStringFromSet(comboBox.getValue()));
                        }
                    }
                }
            }
            else if(component instanceof VerticalLayout){
                VerticalLayout layout = (VerticalLayout) q3Layout.getComponent(i);
                HorizontalLayout horizontalLayout = (HorizontalLayout)layout.getComponent(0);
                TextField textField = (TextField) layout.getComponent(1);
                String textFieldVal = textField.getValue() != null && !textField.getValue().isEmpty() ? textField.getValue() : "empty";
                if(prefix.equals("24")){
                    ComboBoxMultiselect multiCombo = (ComboBoxMultiselect) horizontalLayout.getComponent(1);
                    if(multiCombo.getValue() != null){
                        if(textField.isVisible()){
                            answer.setM24(getStringFromSet(multiCombo.getValue()) + "==" + textFieldVal);
                        }
                        else{
                            answer.setM24(getStringFromSet(multiCombo.getValue()));
                        }
                    }
                }
                else{
                    ComboBox comboBox = (ComboBox) horizontalLayout.getComponent(1);
                    if(comboBox.getValue() != null){
                        if(textField.isVisible()){
                            if(prefix.equals("11")) answer.setM11(((Answer)comboBox.getValue()).getId() + "==" + textFieldVal);
                            if(prefix.equals("13")) answer.setM13(((Answer)comboBox.getValue()).getId() + "==" + textFieldVal);
                            if(prefix.equals("16")) answer.setM16(((Answer)comboBox.getValue()).getId() + "==" + textFieldVal);
                        }
                        else{
                            if(prefix.equals("11"))answer.setM11(((Answer)comboBox.getValue()).getId()+"");
                            if(prefix.equals("13"))answer.setM13(((Answer)comboBox.getValue()).getId()+"");
                            if(prefix.equals("16"))answer.setM13(((Answer)comboBox.getValue()).getId()+"");
                        }
                    }
                }
            }
        }
        return answer;
    }

    public List<FirstFollowUpQ13> getQ13AnswerList(int surveyId){
        List<FirstFollowUpQ13> answerList = new ArrayList<>();
        for(int i = 0;i<q2Layout.getComponentCount();i++){

            Component component = q2Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout)component;
                Label label = ( Label) layout.getComponent(0);
                ComboBox comboBox = (ComboBox)layout.getComponent(1);
                ComboBox timesCombo = (ComboBox)layout.getComponent(2);
                FirstFollowUpQ13 answer = new FirstFollowUpQ13();
                String question = label.getValue().substring(0,1);
                answer.setSurveyId(surveyId);
                answer.setQuestion(question);
                if(comboBox.getValue() != null){
                    int medicalAnswer = getId((Answer) comboBox.getValue());
                    answer.setMedical(medicalAnswer);
                    if(medicalAnswer == 1) answer.setTimes(timesCombo.getValue() != null ? Integer.parseInt(timesCombo.getValue().toString()) : 0);
                    else answer.setTimes(8888);
                }
                answerList.add(answer);
            }
        }
        return answerList;
    }

    public List<FirstFollowUpQ125> getQ125List(int surveyId){
        List<FirstFollowUpQ125> answerList = new ArrayList<>();
        for(int i = 2;i<q25Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q25Layout.getComponent(i);
            FirstFollowUpQ125 answer = new FirstFollowUpQ125();
            if(i== 2) answer.setDateFld("yesterday");
            else answer.setDateFld("day before yesterday");
            TextField breakfastFld = (TextField) layout.getComponent(1);
            answer.setBreakfast(breakfastFld.getValue());
            TextField lunchFld = (TextField) layout.getComponent(2);
            answer.setLunch(lunchFld.getValue());
            TextField dinnerFld = (TextField) layout.getComponent(3);
            answer.setDinner(dinnerFld.getValue());
            answer.setSurveyId(surveyId);
            answerList.add(answer);
        }
        return answerList;
    }

    public FirstFollowUpQ126 getQ126Answer(int surveyId){
        FirstFollowUpQ126 answer = new FirstFollowUpQ126();
        for(int i = 0;i<q26Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q26Layout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            if(comboBox.getValue() != null) {
                if(i==0) answer.setMa(getId((Answer)comboBox.getValue()));
                if(i==1) answer.setMb(getId((Answer)comboBox.getValue()));
                if(i==2) answer.setMc(getId((Answer)comboBox.getValue()));
                if(i==3) answer.setMd(getId((Answer)comboBox.getValue()));
                if(i==4) answer.setMe(getId((Answer)comboBox.getValue()));
                if(i==5) answer.setMf(getId((Answer)comboBox.getValue()));
                if(i==6) answer.setMg(getId((Answer)comboBox.getValue()));
                if(i==7) answer.setMh(getId((Answer)comboBox.getValue()));
                if(i==8) answer.setMi(getId((Answer)comboBox.getValue()));
                if(i==9) answer.setMj(getId((Answer)comboBox.getValue()));
                if(i==10) answer.setMk(getId((Answer)comboBox.getValue()));
                if(i==11) answer.setMl(getId((Answer)comboBox.getValue()));
            }
        }
        answer.setSurveyId(surveyId);
        return answer;
    }

    public void clearFields() {
        for(int i = 0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                comboBox.clear();
            }
        }
        for(int i=0;i<22;i++){
            Component component = q3Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout) q3Layout.getComponent(i);
                Component comboComp = layout.getComponent(1);
                if(comboComp instanceof ComboBox){
                    ComboBox comboBox = (ComboBox) comboComp;
                    comboBox.clear();
                }
                else if(comboComp instanceof ComboBoxMultiselect){
                    ComboBoxMultiselect comboBox = (ComboBoxMultiselect) comboComp;
                    comboBox.clear();
                }
            }
            else if(component instanceof VerticalLayout){
                VerticalLayout layout = (VerticalLayout) q3Layout.getComponent(i);
                HorizontalLayout horizontalLayout = (HorizontalLayout)layout.getComponent(0);
                TextField textField = (TextField) layout.getComponent(1);
                textField.clear();
                Component comboComp = horizontalLayout.getComponent(1);
                if(comboComp instanceof ComboBox){
                    ComboBox comboBox = (ComboBox) comboComp;
                    comboBox.clear();
                }
                else if(comboComp instanceof ComboBoxMultiselect){
                    ComboBoxMultiselect comboBox = (ComboBoxMultiselect) comboComp;
                    comboBox.clear();
                }
            }
        }
        for(int i = 0;i<q2Layout.getComponentCount();i++){
            Component component = q2Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout)component;
                ComboBox comboBox = (ComboBox)layout.getComponent(1);
                ComboBox timesCombo = (ComboBox)layout.getComponent(2);
               comboBox.clear();
               timesCombo.clear();
            }
        }
        for(int i = 2;i<q25Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q25Layout.getComponent(i);
            TextField breakfastFld = (TextField) layout.getComponent(1);
            TextField lunchFld = (TextField) layout.getComponent(2);
            TextField dinnerFld = (TextField) layout.getComponent(3);
            breakfastFld.clear();
            lunchFld.clear();
            dinnerFld.clear();
        }
        for(int i = 0;i<q26Layout.getComponentCount();i++) {
            HorizontalLayout layout = (HorizontalLayout) q26Layout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            comboBox.clear();
        }
    }

    //set edit data

    public void setEditData(FirstFollowUpQ1 answer) {

        if(answer.getSurveyDate() != null && !answer.getSurveyDate().trim().isEmpty()) {
            Date surveyDate = getDateFromStr(answer.getSurveyDate());
            if (surveyDate != null) {
                LocalDate motherBday = surveyDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                followUpDate.setValue(motherBday);
            }
        }
        for(int i = 0;i<q1Layout.getComponentCount();i++){
            Component component = q1Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                ComboBox comboBox = (ComboBox) ((HorizontalLayout) component).getComponent(1);
                if(i == 0 && answer.getM1() != 0){
                    comboBox.setValue(getAnswerObj(answer.getM1(),Arrays.asList("1.ඔව්","2.නැත")));
                }
                else if( i == 1 && answer.getM1() != 0 && answer.getM1() != 8888){
                    comboBox.setValue(getAnswerObj(answer.getM2(),Arrays.asList("1.ඔව්","2.නැත")));
                }
            }
        }
        List<String> varcharList = Arrays.asList("11","12","13","16","22","24");
        for(int i=0;i<22;i++){
            Component component = q3Layout.getComponent(i);
            String prefix = (i+4)+"";
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout) q3Layout.getComponent(i);
                if(!varcharList.contains(prefix) ){
                    ComboBox comboBox = (ComboBox) layout.getComponent(1);

                    int val = callGetter(answer,"m"+prefix);
                    if(val == 0 && prefix.equals("6")){
                        if(prefix.equals("6")) comboBox.setValue(val);
                    }
                    if(val != 0 && val != 8888){
                        if(prefix.equals("4")) comboBox.setValue(getAnswerObj(answer.getM4(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("5")) comboBox.setValue(getAnswerObj(answer.getM5(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("6")) comboBox.setValue(val);
                        if(prefix.equals("7")) comboBox.setValue(getAnswerObj(answer.getM7(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("8")) comboBox.setValue(getAnswerObj(answer.getM8(),answerMap.get(8)));
                        if(prefix.equals("9")) comboBox.setValue(getAnswerObj(answer.getM9(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("10")) comboBox.setValue(getAnswerObj(answer.getM10(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("14")) comboBox.setValue(getAnswerObj(answer.getM14(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("15")) comboBox.setValue(val);
                        if(prefix.equals("17")) comboBox.setValue(val);
                        if(prefix.equals("18")) comboBox.setValue(getAnswerObj(answer.getM18(),answerMap.get(18)));
                        if(prefix.equals("19")) comboBox.setValue(getAnswerObj(answer.getM19(),answerMap.get(19)));
                        if(prefix.equals("20")) comboBox.setValue(getAnswerObj(answer.getM20(),answerMap.get(20)));
                        if(prefix.equals("21")) comboBox.setValue(getAnswerObj(answer.getM21(),Arrays.asList("1.ඔව්","2.නැත")));
                        if(prefix.equals("23")) comboBox.setValue(val);
                    }
                }
                else{
                    if(prefix.equalsIgnoreCase("12") || prefix.equalsIgnoreCase("22") || prefix.equals("24")){
                        ComboBoxMultiselect comboBox = (ComboBoxMultiselect) layout.getComponent(1);
                        if(prefix.equals("12"))comboBox.setValue(getMultipleAnswerSet(answer.getM12(), q12AnswerList));
                        else if(prefix.equals("22"))comboBox.setValue(getMultipleAnswerSet(answer.getM22(), q22AnswerList));
                        else if(prefix.equals("24")) comboBox.setValue(getMultipleAnswerSet(answer.getM24(),q24AnswerList));
                    }
                }
            }
            else if(component instanceof VerticalLayout){
                VerticalLayout layout = (VerticalLayout) q3Layout.getComponent(i);
                HorizontalLayout horizontalLayout = (HorizontalLayout)layout.getComponent(0);
                TextField textField = (TextField) layout.getComponent(1);

                ComboBox comboBox = null;
                String answerVal = "";
                if(!prefix.equals("24")){
                    comboBox = (ComboBox) horizontalLayout.getComponent(1);
                    if(prefix.equals("11")) answerVal = answer.getM11();
                    if(prefix.equals("13")) answerVal = answer.getM13();
                    if(prefix.equals("16")) answerVal = answer.getM16();
                    if(answerVal != null && !answerVal.isEmpty()){
                        if(answerVal.contains("==")){
                            String[] valArr = answerVal.split("==");
                            textField.setValue(valArr[1]);
                            int answerId = Integer.parseInt(valArr[0]);
                            if(prefix.equals("11"))comboBox.setValue(getAnswerObj(answerId,answerMap.get(11)));
                            if(prefix.equals("13"))comboBox.setValue(getAnswerObj(answerId,answerMap.get(13)));
                            if(prefix.equals("16"))comboBox.setValue(getAnswerObj(answerId,answerMap.get(16)));
                        }
                        else{
                            if(prefix.equals("11"))comboBox.setValue(getAnswerObj(Integer.parseInt(answer.getM11()),answerMap.get(11)));
                            if(prefix.equals("13"))comboBox.setValue(getAnswerObj(Integer.parseInt(answer.getM13()),answerMap.get(13)));
                            if(prefix.equals("16"))comboBox.setValue(getAnswerObj(Integer.parseInt(answer.getM16()),answerMap.get(16)));
                        }
                    }
                }
                else{
                    ComboBoxMultiselect multiComboBox = (ComboBoxMultiselect) horizontalLayout.getComponent(1);
                    answerVal = answer.getM24();
                    if(answerVal != null && !answerVal.isEmpty()){
                        if(answerVal.contains("==")){
                            String[] valArr = answerVal.split("==");
                            textField.setValue(valArr[1]);
                            multiComboBox.setValue(getMultipleAnswerSet(valArr[0], q24AnswerList));
                        }
                        else{
                            multiComboBox.setValue(getMultipleAnswerSet(answer.getM24(), q24AnswerList));
                        }
                    }
                }

            }
        }
    }

    public void setEditData13(List<FirstFollowUpQ13> answerList){
        Map<String,FirstFollowUpQ13> map = answerList.stream().collect(Collectors.toMap(x->x.getQuestion(),x->x));
        for(int i = 0;i<q2Layout.getComponentCount();i++){
            Component component = q2Layout.getComponent(i);
            if(component instanceof HorizontalLayout){
                HorizontalLayout layout = (HorizontalLayout)component;
                Label label = ( Label) layout.getComponent(0);
                ComboBox comboBox = (ComboBox)layout.getComponent(1);
                ComboBox timesCombo = (ComboBox)layout.getComponent(2);
                String question = label.getValue().substring(0,1);

                FirstFollowUpQ13 answer = map.get(question);
                if(answer != null){
                    int times = answer.getTimes();
                    if(times != 0 && times != 8888)timesCombo.setValue(map.get(question).getTimes());
                    comboBox.setValue(getAnswerObj(answer.getMedical(),Arrays.asList("1.ඔව්","2.නැත")));
                }
            }
        }
    }

    public void setEditData125(List<FirstFollowUpQ125> answerList){
        Map<String,FirstFollowUpQ125> map = answerList.stream().collect(Collectors.toMap(x->x.getDateFld(),x->x));
        for(int i = 2;i<q25Layout.getComponentCount();i++){
            HorizontalLayout layout = (HorizontalLayout) q25Layout.getComponent(i);
            TextField breakfastFld = (TextField) layout.getComponent(1);
            TextField lunchFld = (TextField) layout.getComponent(2);
            TextField dinnerFld = (TextField) layout.getComponent(3);
            FirstFollowUpQ125 answer;
            if(i==2){
                 answer = map.get("yesterday");
            }
            else {
                answer = map.get("day before yesterday");
            }
            if(answer != null){
                breakfastFld.setValue(answer.getBreakfast());
                lunchFld.setValue(answer.getLunch());
                dinnerFld.setValue(answer.getDinner());
            }
        }
    }

    public void setEditData126(FirstFollowUpQ126 answer){
        List<String> answerList = Arrays.asList("1. සතියකට කිහිපවරක්","2. මසකට කිහිපවරක්","3. කලාතුරකින්","4. කෙදිනකවත් නැත");
        for(int i = 0;i<q26Layout.getComponentCount();i++) {
            HorizontalLayout layout = (HorizontalLayout) q26Layout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            if (i == 0 && answer.getMa() != 0) comboBox.setValue(getAnswerObj(answer.getMa(),answerList));
            if (i == 1 && answer.getMb() != 0) comboBox.setValue(getAnswerObj(answer.getMb(),answerList));
            if (i == 2 && answer.getMc() != 0) comboBox.setValue(getAnswerObj(answer.getMc(),answerList));
            if (i == 3 && answer.getMd() != 0) comboBox.setValue(getAnswerObj(answer.getMd(),answerList));
            if (i == 4 && answer.getMe() != 0) comboBox.setValue(getAnswerObj(answer.getMe(),answerList));
            if (i == 5 && answer.getMf() != 0) comboBox.setValue(getAnswerObj(answer.getMf(),answerList));
            if (i == 6 && answer.getMg() != 0) comboBox.setValue(getAnswerObj(answer.getMg(),answerList));
            if (i == 7 && answer.getMh() != 0) comboBox.setValue(getAnswerObj(answer.getMh(),answerList));
            if (i == 8 && answer.getMi() != 0) comboBox.setValue(getAnswerObj(answer.getMi(),answerList));
            if (i == 9 && answer.getMj() != 0) comboBox.setValue(getAnswerObj(answer.getMj(),answerList));
            if (i == 10 && answer.getMk() != 0) comboBox.setValue(getAnswerObj(answer.getMk(),answerList));
            if (i == 11 && answer.getMl() != 0) comboBox.setValue(getAnswerObj(answer.getMl(),answerList));
        }
    }

    //end of set edit data

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

    private VerticalLayout createQ26(){
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(leftMargin);
        mainLayout.setSizeFull();
        List<String> q26List = answerMap.get(26);
        for(String question : q26List){
            mainLayout.addComponent(addQuestionWithAnswerObjCombo(Arrays.asList("1. සතියකට කිහිපවරක්","2. මසකට කිහිපවරක්","3. කලාතුරකින්","4. කෙදිනකවත් නැත")
                    ,question));
        }
        return mainLayout;
    }

    private void setDependentLayout(ComboBox comboBox,Component layout,int val){
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

    private VerticalLayout createQ25(){
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        HorizontalLayout mealCatLayout = new HorizontalLayout();
        mealCatLayout.setSizeFull();
        Label emptyLabel = new Label("");
        Label breakfastLabel = new Label("උදේ ආහාරය");
        Label lunchLabel = new Label("දිවා ආහාරය");
        Label dinnerLabel = new Label("රාතී\u200D්\u200Dර ආහාරය");
        emptyLabel.setSizeFull();
        breakfastLabel.setSizeFull();
        lunchLabel.setSizeFull();
        dinnerLabel.setSizeFull();
        mealCatLayout.addComponents(emptyLabel,breakfastLabel,lunchLabel,dinnerLabel);

        HorizontalLayout exampleLayout = new HorizontalLayout();
        exampleLayout.setSizeFull();
        Label exampleLabel = new Label("උදාහරණය");
        Label breakfastExampleLabel = new Label("මුං ඇට");
        Label lunchExampleLabel = new Label("බත්");
        Label dinnerExampleLabel = new Label("කිසිවක් නැත");
        exampleLabel.setSizeFull();
        breakfastExampleLabel.setSizeFull();
        lunchExampleLabel.setSizeFull();
        dinnerExampleLabel.setSizeFull();
        exampleLayout.addComponents(exampleLabel,breakfastExampleLabel,lunchExampleLabel,dinnerExampleLabel);

        HorizontalLayout yesterdayMealLayout = new HorizontalLayout();
        yesterdayMealLayout.setSizeFull();
        Label yesterdayLabel = new Label("a. ඊයේ");
        TextField breakfastYesterdayFld = new TextField();
        breakfastYesterdayFld.setSizeFull();
        TextField lunchYesterdayFld = new TextField();
        lunchYesterdayFld.setSizeFull();
        TextField dinnerYesterdayFld = new TextField();
        dinnerYesterdayFld.setSizeFull();
        yesterdayMealLayout.addComponents(yesterdayLabel,breakfastYesterdayFld,lunchYesterdayFld,dinnerYesterdayFld);

        HorizontalLayout dayBeforeYesterdayMealLayout = new HorizontalLayout();
        dayBeforeYesterdayMealLayout.setSizeFull();
        Label dayBeforeYesterdayLabel = new Label("b. පෙරේදා");
        TextField breakfastdayBeforeYesterdayFld = new TextField();
        breakfastdayBeforeYesterdayFld.setSizeFull();
        TextField lunchdayBeforeYesterdayFld = new TextField();
        lunchdayBeforeYesterdayFld.setSizeFull();
        TextField dinnerdayBeforeYesterdayFld = new TextField();
        dinnerdayBeforeYesterdayFld.setSizeFull();
        dayBeforeYesterdayMealLayout.addComponents(dayBeforeYesterdayLabel,breakfastdayBeforeYesterdayFld,lunchdayBeforeYesterdayFld,dinnerdayBeforeYesterdayFld);
        mainLayout.addComponents(mealCatLayout,exampleLayout,yesterdayMealLayout,dayBeforeYesterdayMealLayout);
        return mainLayout;
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

    private ComboBoxMultiselect addMultiSelectComboWithLayout(List<String> answerList,String question,VerticalLayout mainLayout,List<Answer> answerObjs){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBoxMultiselect<Answer> comboBox = new ComboBoxMultiselect();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(answerObjs);
        comboBox.setDescription(getAnswerDesc(answerList));
        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        mainLayout.addComponent(layout);
        return comboBox;
    }

    private ComboBox getComboBoxForDependentLayout(List<String> answerList,String question,VerticalLayout mainLayout){
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

    private HorizontalLayout addQuestionWithNumberRangeCombo(int start,int end, String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getStringList(start,end));
        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        return layout;
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

    private HorizontalLayout addQ13HorizontalLayout(String question){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getYesNoAnswer("SN"));
        ComboBox timesCombo = new ComboBox();
        timesCombo.setSizeFull();
        timesCombo.setItems(getStringList(1,10));
        timesCombo.setEnabled(false);
        timesCombo.setTextInputAllowed(false);
        layout.addComponents(label,comboBox,timesCombo);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        layout.setExpandRatio(timesCombo,2);
        comboBox.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer != null && (answer.getId() == 1)){
                timesCombo.setEnabled(true);
            }
            else {
                timesCombo.setEnabled(false);
           }
        });
        return layout;
    }

    private String getDateStr(LocalDate date){
        if(date == null){
            return null;
        }
        Date dateVal = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(dateVal);
    }

    private Date getDateFromStr(String str){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            return null;
        }
    }
}
