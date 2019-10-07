package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        q1Layout = new VerticalLayout();
        q1Layout.setSizeFull();
        addComponent(q1Layout);
        q1Layout.setMargin(false);
        q1Layout.addComponent(addHorizontalLayout(q11Map.get(1)));
        q1Layout.addComponent(addHorizontalLayout(q11Map.get(2)));
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

        q3Layout.addComponent(addHorizontalLayout(q11Map.get(4)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(5)));
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,10,q11Map.get(6)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(7)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(8),q11Map.get(8)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(9)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(10)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(11),q11Map.get(11)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(12),q11Map.get(12)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(13),q11Map.get(13)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(14)));
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,30,q11Map.get(15)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(16),q11Map.get(16)));
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,30,q11Map.get(17)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(18),q11Map.get(18)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(19),q11Map.get(19)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(20),q11Map.get(20)));
        q3Layout.addComponent(addHorizontalLayout(q11Map.get(21)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(22),q11Map.get(22)));
        q3Layout.addComponent(addQuestionWithNumberRangeCombo(0,7,q11Map.get(23)));
        q3Layout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(24),q11Map.get(24)));
        Label q25Header = new Label(q11Map.get(25));
        q25Header.setSizeFull();
        q3Layout.addComponent(q25Header);
        q3Layout.addComponent(createQ25());
        Label q26Header = new Label(q11Map.get(26));
        q26Header.setSizeFull();
        q3Layout.addComponent(q26Header);
        q3Layout.addComponent(createQ26());
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
        layout.addComponents(label,comboBox,timesCombo);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        layout.setExpandRatio(timesCombo,2);
        comboBox.addValueChangeListener(event -> {
           if (event.getValue() != null && !event.getValue().equals("1")){
                timesCombo.setEnabled(true);
            }
        });
        return layout;
    }
}
