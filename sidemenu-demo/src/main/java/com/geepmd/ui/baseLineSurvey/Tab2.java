package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ2;
import com.geepmd.entity.BaselineQ26;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.addons.ComboBoxMultiselect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab2 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    String language;
    Map<String,String> fields;
    ComboBox mesTypeCombo;
    ComboBox mensDaysCombo;
    ComboBox daysCombo23;
    ComboBox yesNoCombo24;
    ComboBox sanitaryCombo;
    ComboBox contraceptiveCombo;
    ComboBox diagnosedCombo;
    ComboBox yesNoCombo210;
    ComboBox yesNoCombo211;
    ComboBox q212Combo;
    ComboBox yesNoCombo213;
    HorizontalLayout padSmallLayout;
    HorizontalLayout padMediumLayout;
    HorizontalLayout padLargeLayout;
    Survey survey;

    public Tab2(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
        }
        else{
            answerMap = SinhalaMap.getQ2AnswerList();
            fields = SinhalaMap.getQ2Fields();
        }
        this.survey = survey;
        createLayout(language);
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(String language){
        Map<String,String> q2Map;
        if(language.equals("EN")){
            q2Map = EnglishMap.getquestion1Map();
        }
        else{
            q2Map = SinhalaMap.getQ2Map();
        }

        mesTypeCombo = new ComboBox();
        mesTypeCombo.setItems(getYesNoAnswer(language));
        addComponent(setTabData(q2Map.get("2.1"),mesTypeCombo));

        mensDaysCombo = new ComboBox();
        mensDaysCombo.setItems(getStringList(20,45));
        addComponent(setTabData(q2Map.get("2.2"),mensDaysCombo));

        daysCombo23 = new ComboBox();
        daysCombo23.setItems(getStringList(1,8));
        addComponent(setTabData(q2Map.get("2.3"), daysCombo23));

        yesNoCombo24 = new ComboBox();
        yesNoCombo24.setItems(getYesNoAnswer(language));
        addComponent(setTabData(q2Map.get("2.4"),yesNoCombo24));

        sanitaryCombo = new ComboBox();
        sanitaryCombo.setItems(getAnwerObj(answerMap.get("2.5")));
        addComponent(setTabData(q2Map.get("2.5"),sanitaryCombo));

        Label label26 = new Label(q2Map.get("2.6"));
        label26.setSizeFull();
        addComponent(label26);
        addComponent(setQ26Layout());

        contraceptiveCombo = new ComboBox();
        contraceptiveCombo.setItems(getYesNoAnswer(language));
        HorizontalLayout q27Layout = setTabData(q2Map.get("2.7"),contraceptiveCombo);
        addComponent(q27Layout);

        Label q28Label = new Label(q2Map.get("2.8"));
        q28Label.setSizeFull();
        VerticalLayout q28Layout = new VerticalLayout();
        q28Layout.setSizeFull();
        q28Layout.addComponent(get28Header());
        q28Layout.addComponent(addActivitiesTable("1"));
        q28Layout.addComponent(addActivitiesTable("2"));
        q28Layout.addComponent(addActivitiesTable("3"));
        q28Layout.addComponent(addActivitiesTable("4"));
        q28Layout.addComponent(addActivitiesTable("5"));

        contraceptiveCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {

            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                int layoutIndex = getComponentIndex(q27Layout);
                addComponent(q28Label,layoutIndex+1);
                addComponent(q28Layout,layoutIndex+2);
            }
            else if(answer != null && answer.getId() == 2){
                removeComponent(q28Label);
                removeComponent(q28Layout);
            }
            else{
                removeComponent(q28Label);
                removeComponent(q28Layout);
            }
        });

        diagnosedCombo = new ComboBox();
        diagnosedCombo.setItems(getYesNoAnswer(language));
        HorizontalLayout q29Layout = setTabData(q2Map.get("2.9"),diagnosedCombo);
        addComponent(q29Layout);

        HorizontalLayout q210Layout = new HorizontalLayout();
        q210Layout.setSizeFull();
        Label q210Label = new Label(q2Map.get("2.10"));
        q210Label.setSizeFull();
        yesNoCombo210 = new ComboBox();
        yesNoCombo210.setItems(getStringList(1,15));
        yesNoCombo210.setSizeFull();
        q210Layout.addComponents(q210Label, yesNoCombo210);
        q210Layout.setExpandRatio(q210Label,3);
        q210Layout.setExpandRatio(yesNoCombo210,1);

        HorizontalLayout q211Layout = new HorizontalLayout();
        q211Layout.setSizeFull();
        Label q211Label = new Label(q2Map.get("2.11"));
        q210Label.setSizeFull();
        yesNoCombo211 = new ComboBox();
        yesNoCombo211.setItems(getYesNoAnswer(language));
        yesNoCombo211.setSizeFull();
        q211Layout.addComponents(q211Label,yesNoCombo211);
        q211Layout.setExpandRatio(q211Label,3);
        q211Layout.setExpandRatio(yesNoCombo211,1);

        diagnosedCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                int index = getComponentIndex(q29Layout);
                addComponent(q210Layout,index+1);
                addComponent(q211Layout,index+2);
            }
            else{
                removeComponent(q210Layout);
                removeComponent(q211Layout);
            }
        });

        q212Combo = new ComboBox();
        q212Combo.setSizeFull();
        q212Combo.setItems(getYesNoAnswer(language));
        addComponent(setTabData(q2Map.get("2.12"),q212Combo));

        HorizontalLayout q213Layout = new HorizontalLayout();
        q213Layout.setSizeFull();
        Label q213Label = new Label(q2Map.get("2.13"));
        q213Label.setSizeFull();
        yesNoCombo213 = new ComboBox();
        yesNoCombo213.setItems(getYesNoAnswer(language));
        yesNoCombo213.setSizeFull();
        q213Layout.addComponents(q213Label,yesNoCombo213);
        q213Layout.setExpandRatio(q213Label,3);
        q213Layout.setExpandRatio(yesNoCombo213,1);
        addComponent(q213Layout);
        q213Layout.setVisible(false);

        q212Combo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if(answer != null && answer.getId() == 1){
                q213Layout.setVisible(true);
            }
            else{
                q213Layout.setVisible(false);
            }
        });

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(2);
        });
        addComponent(nextBtn);
    }

    private HorizontalLayout setQ26Layout(){
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label1 = new Label(fields.get("2.61"));
        label1.setSizeFull();
        label1.setStyleName("padSection");
        HorizontalLayout layout1 = new HorizontalLayout();
        layout1.setSizeFull();
        Label wetCountLabel = new Label(fields.get("2.62"));
        wetCountLabel.setSizeFull();
        VerticalLayout countLayout = new VerticalLayout();
        Label countLabel = new Label(fields.get("2.63"));
        countLabel.setStyleName("padHeader");
        countLabel.setSizeFull();
        HorizontalLayout daysLayout = new HorizontalLayout();
        daysLayout.setSizeFull();
        for(int i = 1;i<10;i++){
            String labelStr;
            if(i!= 9) labelStr = i +" "+ fields.get("2.64");
            else labelStr = fields.get("2.65");

            Label label = new Label(labelStr);
            label.setSizeFull();
            daysLayout.addComponent(label);
        }
        countLayout.addComponents(countLabel,daysLayout);
        layout1.addComponents(wetCountLabel,countLayout);
        countLayout.setMargin(false);
        layout1.setExpandRatio(wetCountLabel,1);
        layout1.setExpandRatio(countLayout,9);

        VerticalLayout padLayout = new VerticalLayout();
        padLayout.setSizeFull();
        padLayout.setMargin(false);
        padSmallLayout = new HorizontalLayout();
        padSmallLayout.setSizeFull();
        padSmallLayout = getPadLayout("images/small_pad.png");

        padMediumLayout = new HorizontalLayout();
        padMediumLayout.setSizeFull();
        padMediumLayout = getPadLayout("images/medium_pad.png");

        padLargeLayout = new HorizontalLayout();
        padLargeLayout.setSizeFull();
        padLargeLayout = getPadLayout("images/large_pad.png");

        padLayout.addComponents(layout1,padSmallLayout,padMediumLayout,padLargeLayout);
         mainLayout.addComponents(label1,padLayout);
        mainLayout.setExpandRatio(label1,1);
        mainLayout.setExpandRatio(padLayout,9);
        return mainLayout;
    }

    private HorizontalLayout getPadLayout(String imageName){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Image logo = new Image();
        logo.setSource(new ThemeResource(imageName));
        logo.setSizeFull();
        layout.addComponent(logo);
        HorizontalLayout fieldLayout = new HorizontalLayout();
        fieldLayout.setSizeFull();
        for(int i = 1;i<10;i++){
            TextField label = new TextField();
            label.setSizeFull();
            fieldLayout.addComponent(label);
        }
        layout.addComponent(fieldLayout);
        layout.setExpandRatio(logo,1);
        layout.setExpandRatio(fieldLayout,9);
        return layout;
    }

    private HorizontalLayout addActivitiesTable(String labelVal){
        ComboBox sideEffects = new ComboBox();
        sideEffects.setSizeFull();
        sideEffects.setItems(getAnwerObj(answerMap.get("2.8")));
        sideEffects.setDescription(getAnswerDesc(answerMap.get("2.8")));
        TextField method = new TextField();
        method.setSizeFull();
        TextField usedTime = new TextField();
        usedTime.setSizeFull();
        TextField recentToStop = new TextField();
        recentToStop.setSizeFull();
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(labelVal);
        label.setSizeFull();
        layout.addComponents(label,method,usedTime,sideEffects,recentToStop);
        layout.setExpandRatio(label,1);
        layout.setExpandRatio(method,15);
        layout.setExpandRatio(usedTime,10);
        layout.setExpandRatio(sideEffects,10);
        layout.setExpandRatio(recentToStop,10);
        //layout.setMargin(new MarginInfo(false,false,false,true));
        return layout;
    }

    private HorizontalLayout get28Header(){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label methodLabel = new Label(fields.get("2.8.1"));
        methodLabel.setSizeFull();
        methodLabel.setStyleName("padHeader");
        Label timeLabel = new Label(fields.get("2.8.2"));
        timeLabel.setSizeFull();
        timeLabel.setStyleName("padHeader");
        Label sideEffectLabel = new Label(fields.get("2.8.3"));
        sideEffectLabel.setSizeFull();
        sideEffectLabel.setStyleName("padHeader");
        Label reasonLabel = new Label(fields.get("2.8.4"));
        reasonLabel.setSizeFull();
        reasonLabel.setStyleName("padHeader");
        layout.addComponents(methodLabel,timeLabel,sideEffectLabel,reasonLabel);
        layout.setExpandRatio(methodLabel,8);
        layout.setExpandRatio(timeLabel,5);
        layout.setExpandRatio(sideEffectLabel,5);
        layout.setExpandRatio(reasonLabel,5);
        return layout;
    }

    private VerticalLayout set27Question(){
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLabel1 = new Label(" ");
        emptyLabel1.setSizeFull();
        Label emptyLabel2 = new Label("Yes/ No");
        emptyLabel2.setSizeFull();
        Label durationLabel = new Label("Used Duration (Years/Month)");
        durationLabel.setSizeFull();
        Label stopTime = new Label("When did you stop using it? (Year/Month)");
        stopTime.setSizeFull();
        Label sideEffectsLabel = new Label("Side Effects");
        sideEffectsLabel.setSizeFull();
        headerLayout.addComponents(emptyLabel1,emptyLabel2,durationLabel,stopTime,sideEffectsLabel);
        headerLayout.setExpandRatio(emptyLabel1,3);
        headerLayout.setExpandRatio(emptyLabel2,1);
        headerLayout.setExpandRatio(durationLabel,3);
        headerLayout.setExpandRatio(stopTime,3);
        headerLayout.setExpandRatio(sideEffectsLabel,3);
        mainLayout.addComponent(headerLayout);

        List<String> yesNoList = Arrays.asList("Yes","No");

        List<String> questionArray = Arrays.asList("Injectable (e.g.: Depo)","Oral contraceptive pills", "Implants (e.g: Jadelle)",
                "Condoms","Intrauterine contraceptive devices","Natural methods");
        for(String question : questionArray){

            HorizontalLayout questionLayout = new HorizontalLayout();
            questionLayout.setSizeFull();
            Label questionLabel = new Label(question);
            questionLabel.setSizeFull();
            ComboBox yesNoCombo = new ComboBox();
            yesNoCombo.setSizeFull();
            yesNoCombo.setWidth("80%");
            yesNoCombo.setItems(yesNoList);

            ComboBox yearsCombo = new ComboBox();
            yearsCombo.setSizeFull();
            yearsCombo.setItems(getStringList(0,15));
            ComboBox monthsCombo = new ComboBox();
            monthsCombo.setItems(getStringList(0,12));
            monthsCombo.setSizeFull();
            HorizontalLayout durationLayout = new HorizontalLayout();
            durationLayout.setSizeFull();
            durationLayout.setWidth("70%");
            durationLayout.addComponents(yearsCombo,monthsCombo);

            ComboBox yearsNumberCombo = new ComboBox();
            yearsNumberCombo.setSizeFull();
            yearsNumberCombo.setItems(2010,2019);
            ComboBox monthsNumberCombo = new ComboBox();
            monthsNumberCombo.setItems(getStringList(1,12));
            monthsNumberCombo.setSizeFull();
            HorizontalLayout stopTimeLayout = new HorizontalLayout();
            stopTimeLayout.setSizeFull();
            stopTimeLayout.setWidth("70%");
            stopTimeLayout.addComponents(yearsNumberCombo,monthsNumberCombo);
            ComboBoxMultiselect<String> dieasesCombo =new ComboBoxMultiselect();
            dieasesCombo.setItems(Arrays.asList("Menstrual periods heavier than usual","Menstrual cycle longer than usual",
                    "Menstrual periods lighter than usual","Menstrual cycle shorter than usual","Spotting frequently",
                    "Irregular menstrual cycles","Excessive weight gain"));
            dieasesCombo.setEnabled(false);
            durationLayout.setEnabled(false);
            stopTimeLayout.setEnabled(false);
            dieasesCombo.setSizeFull();
            questionLayout.addComponents(questionLabel,yesNoCombo,durationLayout,stopTimeLayout,dieasesCombo);
            questionLayout.setExpandRatio(questionLabel,3);
            questionLayout.setExpandRatio(yesNoCombo,1);
            questionLayout.setExpandRatio(durationLayout,3);
            questionLayout.setExpandRatio(stopTimeLayout,3);
            questionLayout.setExpandRatio(dieasesCombo,3);
            mainLayout.addComponent(questionLayout);

            yesNoCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {
                if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().equals("Yes")){
                    dieasesCombo.setEnabled(true);
                    durationLayout.setEnabled(true);
                    stopTimeLayout.setEnabled(true);
                }
            });
        }
        return mainLayout;
    }

    public BaselineQ2 getAnswers(int surveyId) {

        BaselineQ2 answer = new BaselineQ2();
        answer.setSurveyId(surveyId);
        if(mesTypeCombo.getValue() != null) answer.setM1(getId((Answer)mesTypeCombo.getValue()));
        if(mensDaysCombo.getValue() != null) answer.setM2(Integer.parseInt(mensDaysCombo.getValue().toString()));
        if(daysCombo23.getValue() != null) answer.setM3(Integer.parseInt(daysCombo23.getValue().toString()));
        if(yesNoCombo24.getValue() != null) answer.setM4(getId((Answer)yesNoCombo24.getValue()));
        if(sanitaryCombo.getValue() != null) answer.setM5(getId((Answer)sanitaryCombo.getValue()));
        if(contraceptiveCombo.getValue() != null) answer.setM7(getId((Answer)contraceptiveCombo.getValue()));
        if(diagnosedCombo.getValue() != null) answer.setM9(getId((Answer)diagnosedCombo.getValue()));
        if(yesNoCombo210.getValue() != null) answer.setM10(Integer.parseInt(yesNoCombo210.getValue().toString()));
        if(yesNoCombo211.getValue() != null) answer.setM11(getId((Answer)yesNoCombo211.getValue()));
        if(q212Combo.getValue() != null) answer.setM12(getId((Answer)q212Combo.getValue()));
        if(yesNoCombo213.getValue() != null) answer.setM13(getId((Answer)yesNoCombo213.getValue()));
        return answer;
    }

    public BaselineQ26 get26Answer(int surveyId){
        BaselineQ26 answer = new BaselineQ26();
        answer.setSurveyId(surveyId);
        HorizontalLayout smallPad = (HorizontalLayout)padSmallLayout.getComponent(1);
        HorizontalLayout mediumPad = (HorizontalLayout)padMediumLayout.getComponent(1);
        HorizontalLayout largePad = (HorizontalLayout)padLargeLayout.getComponent(1);
        for(int i = 0;i<9;i++){
            TextField field1 = (TextField)smallPad.getComponent(i);
            TextField field2 = (TextField)mediumPad.getComponent(i);
            TextField field3 = (TextField)largePad.getComponent(i);
            int number = 0;
            if(field3.getValue() != null && !field3.getValue().isEmpty()) number = 3;
            else if(field2.getValue() != null && !field2.getValue().isEmpty()) number = 2;
            else if(field1.getValue() != null && !field1.getValue().isEmpty()) number = 1;

            if(i==0) answer.setD1(number);
            if(i==1) answer.setD2(number);
            if(i==2) answer.setD3(number);
            if(i==3) answer.setD4(number);
            if(i==4) answer.setD5(number);
            if(i==5) answer.setD6(number);
            if(i==6) answer.setD7(number);
            if(i==7) answer.setD8(number);
            if(i==8) answer.setD9(number);

        }

        return answer;
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
