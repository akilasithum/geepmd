package com.geepmd.ui.firstFollowupSurvey;

import com.geepmd.ui.FirstFollowUpSurvey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.getAnswerDesc;
import static com.geepmd.utils.SurveyUtils.getAnwerObj;
import static com.geepmd.utils.SurveyUtils.getYesNoAnswer;

public class FirstFollowUpTab2 extends VerticalLayout {

    Map<Integer,String> questionMap;
    Map<Integer,String> q1Map;
    Map<Integer, List<String>> answerMap;
    String language;
    FirstFollowUpSurvey survey;
    MarginInfo leftMargin = new MarginInfo(false,false,false,true);
    VerticalLayout q1Layout;
    VerticalLayout qLayout;

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
        qLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(2),questionMap.get(2)));
        qLayout.addComponent(addQuestionWithAnswerObjCombo(answerMap.get(3),questionMap.get(3)));

        Label pregnancyHeader = new Label("පහත ප\u200D්\u200Dරශ්න මෙම ගර්භණී කාලය සඳහා පමණි.");
        pregnancyHeader.setStyleName("padHeader");
        qLayout.addComponent(pregnancyHeader);

        qLayout.addComponent(addHorizontalLayout(questionMap.get(4)));
        qLayout.addComponent(addHorizontalLayout(questionMap.get(5)));
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
        Label ifYesLabel = new Label("");
        ifYesLabel.setSizeFull();
        Label increaseLabel = new Label("");
        increaseLabel.setSizeFull();
        Label treatmentLabel = new Label("");
        treatmentLabel.setSizeFull();
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        headerLayout.addComponents(emptyLabel,ifYesLabel,increaseLabel,treatmentLabel);
        headerLayout.setExpandRatio(emptyLabel,4);
        headerLayout.setExpandRatio(ifYesLabel,1);
        headerLayout.setExpandRatio(increaseLabel,1);
        headerLayout.setExpandRatio(treatmentLabel,1);
        q1Layout.addComponent(headerLayout);
        q1Layout.setMargin(leftMargin);
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
            q1Layout.addComponent(layout);

        }
    }
}
