package com.geepmd.ui;

import com.vaadin.data.HasValue;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.addons.ComboBoxMultiselect;

import java.util.*;

public class Survey extends VerticalLayout implements View {

    List<String> yesNoList = Arrays.asList("Yes","No");
    MarginInfo leftMargin = new MarginInfo(false,true,false,true);
    public Survey(){
        createLayout();
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Object userName = UI.getCurrent().getSession().getAttribute("userName");
        if (userName == null || userName.toString().isEmpty()) {
            getUI().getNavigator().navigateTo("Login");
        }
    }

    private void createLayout(){

        Label header = new Label("New Survey");
        header.setStyleName(ValoTheme.LABEL_H1);
        addComponent(header);

        ComboBox motherNameComboBox = new ComboBox("Select Mother Name");
        List<String> names = new ArrayList<>();
        names.add("Test1");
        names.add("ටෙස්ටින්ග් වන්ටෙස්ටින්ග් වන්");
        names.add("Sithum");
        motherNameComboBox.setItems(names);
        addComponent(motherNameComboBox);


        TabSheet tabsheet = new TabSheet();
        addComponent(tabsheet);
        tabsheet.setSizeFull();

        VerticalLayout tab1 = new VerticalLayout();
        tab1.setSizeFull();
        VerticalLayout tab2 = new VerticalLayout();
        tab2.setSizeFull();
        VerticalLayout tab3 = new VerticalLayout();
        tab3.setSizeFull();
        VerticalLayout tab4 = new VerticalLayout();
        tab4.setSizeFull();
        VerticalLayout tab5 = new VerticalLayout();
        tab5.setSizeFull();
        VerticalLayout tab6 = new VerticalLayout();
        tab6.setSizeFull();
        VerticalLayout tab7 = new VerticalLayout();
        tab7.setSizeFull();
        VerticalLayout tab8 = new VerticalLayout();
        tab8.setSizeFull();

        tabsheet.addTab(tab1,"1.SOCIO – DEMOGRAPHIC DATA");
        tabsheet.addTab(tab2,"2. GYNECOLOGICAL HISTORY");
        tabsheet.addTab(tab3,"3. OBSTETRIC HISTORY");
        tabsheet.addTab(tab4,"4. CURRENT PREGNANCY");
        tabsheet.addTab(tab5,"5. SYMPTOMS");
        tabsheet.addTab(tab6,"6. PAST MEDICAL HISTORY");
        tabsheet.addTab(tab7,"7. FAMILY HISTORY");
        tabsheet.addTab(tab8,"8. ANNEX");

        setTab1Data(tab1);
        setTab2Data(tab2);
        setTab3Data(tab3);
        setTab4Data(tab4);
        setTab5Data(tab5);
        setTab6Data(tab6);
        setTab7Data(tab7);
        setTab8Data(tab8);
    }

    private void setTab1Data(VerticalLayout tab1){

        Label motherLabel = new Label("Mother");
        motherLabel.setSizeFull();
        Label fatherLabel = new Label("Father");
        fatherLabel.setSizeFull();

        setTabData(tab1," ",motherLabel,fatherLabel);
        setTabData(tab1,"1.1 What is your birthday?",new DateField(),new DateField());
        List<String> ethnicityList = new ArrayList<>();
        ethnicityList.add("Sinhala");
        ethnicityList.add("Tamil");
        ethnicityList.add("Moor");
        ethnicityList.add("Malay");
        ethnicityList.add("Burger");
        ethnicityList.add("Other");
        ComboBox ethnicityComboBoxMother = new ComboBox();
        ComboBox ethnicityComboBoxFather = new ComboBox();
        ethnicityComboBoxMother.setItems(ethnicityList);
        ethnicityComboBoxFather.setItems(ethnicityList);
        setTabData(tab1,"1.2 What is your ethnicity?",ethnicityComboBoxMother,ethnicityComboBoxFather);
        List<String> understandingLevel = new ArrayList<>();
        understandingLevel.add("Yes both written and speech");
        understandingLevel.add("Yes only speech");
        understandingLevel.add("No");
        ComboBox understandingLevelComboMother = new ComboBox();
        ComboBox understandingLevelComboFather = new ComboBox();
        understandingLevelComboMother.setItems(understandingLevel);
        understandingLevelComboFather.setItems(understandingLevel);
        setTabData(tab1,"  Are you confident in understanding health related messages in Sinhala? ",
                understandingLevelComboMother,understandingLevelComboFather);
        List<String> religionList = new ArrayList<>();
        religionList.add("Buddhist");
        religionList.add("Catholic/ Christian");
        religionList.add("Hindu");
        religionList.add("Islam");
        religionList.add("Other");
        ComboBox religionMotherCombo = new ComboBox();
        ComboBox religionFatherCombo = new ComboBox();
        religionMotherCombo.setItems(religionList);
        religionFatherCombo.setItems(religionList);
        setTabData(tab1,"1.3 What is your religion?",religionMotherCombo,religionFatherCombo);
        ComboBox schoolGradeMother = new ComboBox();
        ComboBox schoolGradeFather = new ComboBox();
        schoolGradeMother.setItems(getStringList(0,13));
        schoolGradeFather.setItems(getStringList(0,13));
        setTabData(tab1,"1.4 What is the last grade that you completed at school?",schoolGradeMother,schoolGradeFather);
        ComboBox highestEduMother = new ComboBox();
        ComboBox highestEdueFather = new ComboBox();
        highestEduMother.setItems(getStringList(5,30));
        highestEdueFather.setItems(getStringList(5,30));
        setTabData(tab1,"1.5 What is your age when left highest education? (in years)",highestEduMother,highestEdueFather);
        List<String> afterAL = new ArrayList<>();
        afterAL.add("Certificate/ Diploma");
        afterAL.add("Degree");
        afterAL.add("not passed A/L");
        afterAL.add("No Education after A/L");
        ComboBox afterALMother = new ComboBox();
        ComboBox afterALFather = new ComboBox();
        afterALMother.setItems(afterAL);
        afterALFather.setItems(afterAL);
        setTabData(tab1,"1.6 If you passed A/L, what is the education level obtained after A/L s?",afterALMother,afterALFather);

        List<String> yesNoList = new ArrayList<>();
        yesNoList.addAll(Arrays.asList("Yes","No"));
        ComboBox sexualEduLMother = new ComboBox();
        ComboBox sexualEduFather = new ComboBox();
        sexualEduLMother.setItems(yesNoList);
        sexualEduFather.setItems(yesNoList);
        setTabData(tab1,"1.7 Do you feel that you have been given adequate education on sexual and reproductive" +
                " health by school or an institute?  ",sexualEduLMother,sexualEduFather);
        List<String> maritualStatus = Arrays.asList("Married","Unmarried", "Divorced","Other");
        ComboBox maritualStatusCombo = new ComboBox();
        maritualStatusCombo.setItems(maritualStatus);
        setTabData(tab1,"1.8 What is your marital status?",maritualStatusCombo,null);

        ComboBox marriedYearCombo = new ComboBox("Years");
        marriedYearCombo.setSizeFull();
        marriedYearCombo.setItems(getStringList(0,30));
        ComboBox marriedMonthCombo = new ComboBox("Months");
        marriedMonthCombo.setSizeFull();
        marriedMonthCombo.setItems(getStringList(1,12));
        Label label = new Label("1.9 If married, how long have you been married? ");
        label.setSizeFull();
        HorizontalLayout marriedAgeLayout = new HorizontalLayout();
        marriedAgeLayout.setSizeFull();
        marriedAgeLayout.addComponents(label,marriedYearCombo,marriedMonthCombo);
        marriedAgeLayout.setExpandRatio(label,3);
        marriedAgeLayout.setExpandRatio(marriedYearCombo,1);
        marriedAgeLayout.setExpandRatio(marriedMonthCombo,1);
        maritualStatusCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {
            if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().equals("Married")){
                tab1.addComponent(marriedAgeLayout);
            }
            else{
                tab1.removeComponent(marriedAgeLayout);
            }
        });
    }

    private void setTab2Data(VerticalLayout tab){

        List<String> menstrualPeriodList = Arrays.asList("less than 21 days","between 21-35 days","more than 35 days");
        ComboBox mensGapCombo = new ComboBox();
        mensGapCombo.setItems(menstrualPeriodList);
        setTabData(tab,"2.1 What is the approximate time gap between your menstrual periods?",mensGapCombo);
        ComboBox mensDaysCombo = new ComboBox();
        mensDaysCombo.setItems(getStringList(1,8));
        setTabData(tab,"2.2 Generally for how many days do you have menstrual bleeding?",mensDaysCombo);
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setItems(Arrays.asList("Yes","No"));
        setTabData(tab,"2.3 Do you pass clots during a usual menstrual period? ",yesNoCombo);
        ComboBox sanitaryCombo = new ComboBox();
        sanitaryCombo.setItems(Arrays.asList("Pads","Cloths","Other"));
        setTabData(tab,"2.4 What sanitary ware did you use usually?",sanitaryCombo);

        ComboBox contraceptiveCombo = new ComboBox();
        contraceptiveCombo.setItems(Arrays.asList("Yes","No"));
        setTabData(tab,"2.6 Have you ever used any contraceptive method?",contraceptiveCombo);

        Label q27Label = new Label("2.7 If you have used contraceptive methods, please provide the details of contraceptive use");
        q27Label.setSizeFull();
        VerticalLayout q27Layout = set27Question();

        HorizontalLayout q28Layout = new HorizontalLayout();
        q28Layout.setSizeFull();
        Label q28Label = new Label("2.8 Have you ever failed to conceive after 12months or more of regular unprotected sexual intercourse?");
        q28Label.setSizeFull();
        ComboBox yesNoCombo28 = new ComboBox();
        yesNoCombo28.setItems(Arrays.asList("Yes","No"));
        yesNoCombo28.setSizeFull();
        q28Layout.addComponents(q28Label,yesNoCombo28);
        q28Layout.setExpandRatio(q28Label,3);
        q28Layout.setExpandRatio(yesNoCombo28,1);

        contraceptiveCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {

            if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().equals("Yes")){
                tab.addComponent(q27Label,5);
                tab.addComponent(q27Layout,6);
                tab.removeComponent(q28Layout);
            }
            else if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().equals("No")){
                tab.addComponent(q28Layout,5);
                tab.removeComponent(q27Label);
                tab.removeComponent(q27Layout);
            }
            else{
                tab.removeComponent(q27Label);
                tab.removeComponent(q27Layout);
                tab.removeComponent(q28Layout);
            }
        });

        ComboBox diagnosedCombo = new ComboBox();
        diagnosedCombo.setItems(Arrays.asList("Yes","No"));
        setTabData(tab,"2.9 Have you ever been diagnosed with a disease related to ovaries which is associated with symptoms " +
                        "such as weight gain, excessive facial hair, acne, velvety skin darkening at back of neck or underarms and " +
                        "menstrual irregularities?"
                ,diagnosedCombo);

        HorizontalLayout q29Layout = new HorizontalLayout();
        q29Layout.setSizeFull();
        Label q29Label = new Label("2.10 If yes, do you have any documentary evidence?");
        q29Label.setSizeFull();
        ComboBox yesNoCombo29 = new ComboBox();
        yesNoCombo29.setItems(Arrays.asList("Yes","No"));
        yesNoCombo29.setSizeFull();
        q29Layout.addComponents(q29Label,yesNoCombo29);
        q29Layout.setExpandRatio(q29Label,3);
        q29Layout.setExpandRatio(yesNoCombo29,1);


        diagnosedCombo.addValueChangeListener((HasValue.ValueChangeListener) valueChangeEvent -> {

            if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().equals("Yes")){
                tab.addComponent(q29Layout);
            }
            else{
                tab.removeComponent(q29Layout);
            }
        });
    }

    private void setTab3Data(VerticalLayout tab){

        ComboBox conceivedTimeCombo = new ComboBox();
        conceivedTimeCombo.setItems(getStringList(1,10));
        setTabData(tab,"3.1 How many times have you conceived including this time??",conceivedTimeCombo);

        VerticalLayout tab3MainDetails = new VerticalLayout();
        tab3MainDetails.setSizeFull();
        tab3MainDetails.setMargin(false);

        tab3MainDetails.addComponent(new Label("3.2 provide the details of previous conceptions "));
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        tab3MainDetails.addComponent(headerLayout);
        Label gravidaLabel = new Label("Gravida");
        gravidaLabel.setSizeFull();
        Label ageLabel = new Label("Your age in years when conceived?");
        ageLabel.setSizeFull();
        Label outcomeLabel = new Label("Pregnancy outcome");
        outcomeLabel.setSizeFull();
        Label complicationLabel = new Label("Pregnancy complications");
        complicationLabel.setSizeFull();
        Label poaLabel = new Label("What was your POA at the time of outcome?");
        poaLabel.setSizeFull();
        Label deliveryLabel = new Label("What was the mode of delivery?");
        deliveryLabel.setSizeFull();
        Label birthWeightLabel = new Label("If live birth, what is the birth weight of the child?");
        birthWeightLabel.setSizeFull();
        Label neonatalLabel = new Label("What were the neonatal complications, if any?");
        neonatalLabel.setSizeFull();
        Label postpartumLabel = new Label("What were the postpartum maternal complications, if any?");
        postpartumLabel.setSizeFull();
        headerLayout.addComponents(gravidaLabel,ageLabel,outcomeLabel,
                complicationLabel,poaLabel,deliveryLabel,birthWeightLabel,neonatalLabel,postpartumLabel);

        conceivedTimeCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() != null && !valueChangeEvent.getValue().equals("1")){
                tab.addComponent(tab3MainDetails);
                for(int i = 1;i<Integer.parseInt(valueChangeEvent.getValue().toString());i++){
                    HorizontalLayout layout = new HorizontalLayout();
                    layout.setSizeFull();
                    tab3MainDetails.addComponent(layout);
                    layout.addComponent(new Label("G"+i));
                    ComboBox ageCombo = new ComboBox();
                    ageCombo.setItems(getStringList(15,45));
                    ageCombo.setSizeFull();
                    layout.addComponent(ageCombo);

                    ComboBox outcomeCombo = new ComboBox();
                    outcomeCombo.setSizeFull();
                    outcomeCombo.setItems(Arrays.asList("Live birth (After 37 weeks)","Intrauterine death (after 24 weeks)",
                            "Fresh Stillbirth (Intrapartum death)","Pre-term birth (live birth between 24 and 37 weeks)",
                            "Miscarriage(pregnancy loss <24 weeks)"));
                    layout.addComponent(outcomeCombo);

                    ComboBoxMultiselect<String> complicationsCombo =new ComboBoxMultiselect();
                    complicationsCombo.setSizeFull();
                    complicationsCombo.setItems(Arrays.asList("Gestational diabetes mellitus (GDM)","Pregnancy induced hypertension (PIH)",
                            "Preeclampsia","Eclampsia","Heart diseases","Acute fatty liver","Hepatitis","Anemia","Other complications",
                            "No complications"));
                    layout.addComponent(complicationsCombo);

                    ComboBox poaCombo = new ComboBox();
                    poaCombo.setSizeFull();
                    poaCombo.setItems(getStringList(0,20));
                    layout.addComponent(poaCombo);

                    ComboBox deliveryCombo = new ComboBox();
                    deliveryCombo.setSizeFull();
                    deliveryCombo.setItems(Arrays.asList("Vaginal delivery","Forceps delivery","Vacuum delivery","Emergency cesarean section ",
                            "Elective cesarean section","Not applicable"));
                    layout.addComponent(deliveryCombo);

                    TextField weightFld = new TextField();
                    weightFld.setSizeFull();
                    layout.addComponent(weightFld);

                    ComboBoxMultiselect<String> neonatalCombo =new ComboBoxMultiselect();
                    neonatalCombo.setSizeFull();
                    neonatalCombo.setItems(Arrays.asList("Heart disease","Respiratory diseases","Congenital anomaly",
                            "Admitted to a specialized unit (reason unknown)","Neonatal death","Other complications",
                            "No complications"));
                    layout.addComponent(neonatalCombo);

                    ComboBoxMultiselect<String> postpartumCombo =new ComboBoxMultiselect();
                    postpartumCombo.setSizeFull();
                    postpartumCombo.setItems(Arrays.asList("Any hospital admission within first 42 days postpartum due to a cause related to pregnancy.",
                            "PPH","Sepsis","Heart Disease","Post-partum depression","Breast conditions  "));
                    layout.addComponent(postpartumCombo);
                }

                ComboBox breastFeedCombo = new ComboBox();
                breastFeedCombo.setSizeFull();
                breastFeedCombo.setItems(Arrays.asList("Yes, I’m breast feeding currently","Yes, but not now","No, never"));
                setTabData(tab3MainDetails,"3.3 Did you breast feed your youngest child?",breastFeedCombo);

                TextField breastFeedStopMonths = new TextField();
                breastFeedStopMonths.setSizeFull();
                Label q34Label = new Label("3.4 For how long have you stopped breast feeding? (In months)");
                q34Label.setSizeFull();
                HorizontalLayout q34Layout = new HorizontalLayout();
                q34Layout.setSizeFull();
                q34Layout.addComponents(q34Label,breastFeedStopMonths);
                q34Layout.setExpandRatio(q34Label,3);
                q34Layout.setExpandRatio(breastFeedStopMonths,1);
                tab3MainDetails.addComponent(q34Layout);
                q34Layout.setVisible(false);

                breastFeedCombo.addValueChangeListener(valueChangeEvent1 -> {
                    if(valueChangeEvent1.getValue() != null && valueChangeEvent1.getValue().equals("Yes, but not now")){
                        q34Layout.setVisible(true);
                    }
                    else{
                        q34Layout.setVisible(false);
                    }
                });

                ComboBox supplementsCombo = new ComboBox();
                supplementsCombo.setSizeFull();
                supplementsCombo.setItems(Arrays.asList("Yes","No"));
                setTabData(tab3MainDetails,"3.5 Did you take regular iron supplements during your last pregnancy?",supplementsCombo);

                ComboBox supplementsAfterCombo = new ComboBox();
                supplementsAfterCombo.setSizeFull();
                supplementsAfterCombo.setItems(Arrays.asList("Yes, I took supplements regularly","Yes, I took supplements time to time",
                        "No, I did not take supplements after giving birth"));
                setTabData(tab3MainDetails,"3.6 Did you take iron supplements after the last pregnancy?",supplementsAfterCombo);

                HorizontalLayout q37Layout = new HorizontalLayout();
                q37Layout.setSizeFull();
                Label q37Label = new Label("If yes, for how long did you take iron supplements after delivery?");
                q37Label.setSizeFull();
                TextField ironUsedMonths = new TextField();
                ironUsedMonths.setSizeFull();
                q37Layout.addComponents(q37Label,ironUsedMonths);
                q37Layout.setExpandRatio(q37Label,3);
                q37Layout.setExpandRatio(ironUsedMonths,1);
                tab3MainDetails.addComponent(q37Layout);
                q37Layout.setVisible(false);

                supplementsAfterCombo.addValueChangeListener(valueChangeEvent1 -> {
                    if(valueChangeEvent1.getValue() == null || valueChangeEvent1.getValue().
                            equals("No, I did not take supplements after giving birth")) {
                        q37Layout.setVisible(false);
                    }
                    else{
                        q37Layout.setVisible(true);
                    }
                });


            }
            else{
                tab.removeComponent(tab3MainDetails);
            }
        });
    }

    private void setTab4Data(VerticalLayout tab){

        ComboBox preConceptionCombo = new ComboBox();
        preConceptionCombo.setItems(Arrays.asList("Yes with husband","Yes without husband","No"));
        setTabData(tab,"4.1 Have you participated in Pre-conceptional sessions? ",preConceptionCombo);

        HorizontalLayout screenLayout = new HorizontalLayout();
        screenLayout.setSizeFull();
        Label q42Label = new Label("4.2 If participated, whether screened for anaemia?");
        q42Label.setSizeFull();
        ComboBox screenCombo = new ComboBox();
        screenCombo.setItems(Arrays.asList("Yes","No"));
        screenCombo.setSizeFull();
        screenLayout.addComponents(q42Label,screenCombo);
        screenLayout.setExpandRatio(q42Label,3);
        screenLayout.setExpandRatio(screenCombo,1);
        tab.addComponent(screenLayout);
        screenLayout.setVisible(false);
        preConceptionCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().toString().contains("Yes")){
                screenLayout.setVisible(true);
            }
            else{
                screenLayout.setVisible(false);
            }
        });

        ComboBox pregnancyPlannedCombo = new ComboBox();
        pregnancyPlannedCombo.setItems(Arrays.asList("Yes","No"));
        setTabData(tab,"4.3 Is this pregnancy a planned pregnancy?",pregnancyPlannedCombo);

        ComboBox lmpCombo = new ComboBox();
        lmpCombo.setItems(getStringList(1,10));
        setTabData(tab,"4.4 What is your last menstrual period (LMP)?",lmpCombo);

        ComboBox pregConfirmCombo = new ComboBox();
        pregConfirmCombo.setItems(Arrays.asList("Urine HCG strips","USS by","not confirmed"));
        setTabData(tab,"4.5 How was this pregnancy confirmed?",pregConfirmCombo);

        ComboBox deliveryPreferCombo = new ComboBox();
        deliveryPreferCombo.setItems(Arrays.asList("Vaginal delivery","Cesarean section","not yet decided"));
        setTabData(tab,"4.6 What is your preferred mode of delivery for this pregnancy?",deliveryPreferCombo);

        ComboBox delPlaceCombo = new ComboBox();
        delPlaceCombo.setItems(Arrays.asList("nearest government hospital","tertiary hospital","private hospital",
                "home","not yet decided"));
        setTabData(tab,"4.7 What is the preferred place of delivery for this pregnancy?",delPlaceCombo);

        ComboBox folicAcidCombo = new ComboBox();
        folicAcidCombo.setItems(Arrays.asList("Yes","No"));
        setTabData(tab,"4.8 Did you take folic acid supplements before this pregnancy? ",folicAcidCombo);

        ComboBox folicAcidMonthCombo = new ComboBox();
        folicAcidMonthCombo.setItems(getStringList(1,10));
        dependentLayoutAdd(tab,folicAcidCombo,folicAcidMonthCombo,"4.9 for how many months did you take folic acid before conception?");

        ComboBox folicAcidNowCombo = new ComboBox();
        folicAcidNowCombo.setItems(Arrays.asList("Yes","No"));
        setTabData(tab,"4.10 Do you take folic acid now?",folicAcidNowCombo);

        ComboBox folicWeekCombo = new ComboBox();
        folicWeekCombo.setItems(getStringList(1,30));
        dependentLayoutAdd(tab,folicAcidNowCombo,folicWeekCombo,"4.11 for how many weeks have you been taking folic acid during this pregnancy?");

    }

    private void setTab5Data(VerticalLayout tab){
        Label firstQLabel = new Label("5.1 Have you experienced any of these symptoms");
        firstQLabel.setSizeFull();
        tab.addComponent(firstQLabel);

        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLabel = new Label(" ");
        emptyLabel.setSizeFull();
        Label priorConception = new Label("3 months prior to conception");
        priorConception.setSizeFull();
        Label afterConception = new Label("After conception");
        afterConception.setSizeFull();
        headerLayout.addComponents(emptyLabel,priorConception,afterConception);
        tab.addComponent(headerLayout);

        Label emptyLabel1 = new Label(" ");
        emptyLabel1.setSizeFull();

        HorizontalLayout priorConceptionLayout = new HorizontalLayout();
        priorConceptionLayout.setSizeFull();
        Label yesNoLabel = new Label("Yes/No");
        yesNoLabel.setSizeFull();
        Label frequencyLabel = new Label("frequency");
        frequencyLabel.setSizeFull();
        Label worsenLabel = new Label("Does it worsen with exertion? ");
        worsenLabel.setSizeFull();
        Label adviceLabel = new Label("Did you seek medical advice from a doctor?");
        adviceLabel.setSizeFull();
        priorConceptionLayout.addComponents(yesNoLabel,frequencyLabel,worsenLabel,adviceLabel);

        HorizontalLayout afterConceptionLayout = new HorizontalLayout();
        afterConceptionLayout.setSizeFull();
        Label yesNoLabelAfter = new Label("Yes/No");
        yesNoLabelAfter.setSizeFull();
        Label frequencyLabelAfter = new Label("frequency");
        frequencyLabelAfter.setSizeFull();
        Label worsenLabelAfter = new Label("Does it worsen with exertion? ");
        worsenLabelAfter.setSizeFull();
        Label adviceLabelAfter = new Label("Did you seek medical advice from a doctor?");
        adviceLabelAfter.setSizeFull();
        afterConceptionLayout.addComponents(yesNoLabelAfter,frequencyLabelAfter,worsenLabelAfter,adviceLabelAfter);

        HorizontalLayout headerTextLayout = new HorizontalLayout();
        headerTextLayout.setSizeFull();
        headerTextLayout.addComponents(emptyLabel1,priorConceptionLayout,afterConceptionLayout);
        headerTextLayout.setExpandRatio(emptyLabel1,1);
        headerTextLayout.setExpandRatio(priorConceptionLayout,1);
        headerTextLayout.setExpandRatio(afterConceptionLayout,1);
        tab.addComponent(headerTextLayout);
        addQ5Questions("a. Nausea and vomiting",tab);
        addQ5Questions("b. tChest pain that may spread to arm, neck, jaw or back and association with sweating, SOB or heart burn",tab);
        addQ5Questions("c. Chest pain without above symptoms",tab);
        addQ5Questions("d. Breathlessness",tab);
        addQ5Questions("e. Wheezing",tab);
        addQ5Questions("f. Palpitations",tab);
        addQ5Questions("g. Faintishness ",tab);
        addQ5Questions("h. Tiredness at rest",tab);
        addQ5Questions("i. Ankle edema",tab);
        addQ5Questions("j. Difficulty in breathing in lying down position",tab);
        addQ5Questions("k. Difficulty of breathing while sleeping which makes you awake from sleep",tab);

        CheckBoxGroup<String> q52CheckBox = new CheckBoxGroup<>();
        q52CheckBox.setItems(Arrays.asList("a. No limitation. Normal physical exercise does not cause fatigue, dyspnea or palpitations.",
                "b. Mild limitation. Comfortable at rest but normal physical activity produce fatigue, dyspnea or palpitations.",
                "c.Marked limitation. Comfortable at rest but even small physical activity produce fatigue, dyspnea or palpitations.",
                "d. Fatigue, dyspnoea or palpitation occurs at the rest and exacerbate by any physical activity."));
        tab.addComponent(addQ52and3Questions(q52CheckBox,"5.2 Which of the following statement clearly describe your current status of physical activity?"));

        CheckBoxGroup<String> q53CheckBox = new CheckBoxGroup<>();
        q53CheckBox.setItems(Arrays.asList("a. Ordinary physical activity does not cause angina, such as walking and climbing stairs. Angina with" +
                        " strenuous or rapid or prolonged exertion at work or recreation. ," +
                        "b. Slight limitation of ordinary activity due to angina. Walking or climbing stairs rapidly, walking uphill, " +
                        "walking or stair climbing after meals, or in cold, or in wind, or under emotional stress, or only during the few hours after awakening.",
                "c.\tMarked limitation of ordinary physical activity due to angina. Walking one or two blocks on the level and climbing one " +
                        "flight of stairs in normal conditions and at normal pace.",
                "d. Inability to carry on any physical activity without discomfort, anginal syndrome may be present at rest. "));
        tab.addComponent(addQ52and3Questions(q53CheckBox,"5.3  If you have chest pain as indicated in 5.1b, which of the following " +
                "statements correctly mention your current status?"));
    }

    private void setTab6Data(VerticalLayout tab){
        Label firstQ = new Label("6.1 Have you ever been tested positive for following conditions?");
        firstQ.setSizeFull();
        tab.addComponent(firstQ);
        VerticalLayout firstQAnswerLayout = new VerticalLayout();
        firstQAnswerLayout.setSizeFull();
        firstQAnswerLayout.setMargin(new MarginInfo(false,true));
        firstQAnswerLayout.addComponents(getQ61Questions("a. Raised blood pressure"),getQ61Questions("b. Raised blood cholesterol"),
                getQ61Questions("c Raised blood sugar"),getQ61Questions("d. Reduced thyroxin level"));
        tab.addComponent(firstQAnswerLayout);

        Label secondQ = new Label("6.2 Please provide the details about your past disease conditions");
        tab.addComponent(secondQ);

        setQ62Header(tab);
        VerticalLayout secondQAnswerLayout = new VerticalLayout();
        secondQAnswerLayout.setSizeFull();
        secondQAnswerLayout.setMargin(new MarginInfo(false,true));
        tab.addComponent(secondQAnswerLayout);
        secondQAnswerLayout.addComponent(setQ62("a.\tDiabetes mellitus"));
        secondQAnswerLayout.addComponent(setQ62("b.\tHypertension"));
        secondQAnswerLayout.addComponent(setQ62("c.\tDyslipidemia"));
        secondQAnswerLayout.addComponent(setQ62("d.\tThyroid gland related diseases"));
        secondQAnswerLayout.addComponent(setQ62("e.\tLiver diseases"));
        secondQAnswerLayout.addComponent( setQ62("f.\tKidney disease"));
        secondQAnswerLayout.addComponent(setQ62("g.\tAsthma/ wheezing"));
        secondQAnswerLayout.addComponent(setQ62("h.\tAutoimmune diseases"));
        secondQAnswerLayout.addComponent(setQ62("i.\tMetabolic syndrome"));
        secondQAnswerLayout.addComponent(setQ62("j.\tRheumatic fever"));
        secondQAnswerLayout.addComponent(setQ62("k.\tRheumatic heart disease"));
        secondQAnswerLayout.addComponent(setQ62("l.\tG6PD deficiency"));
        secondQAnswerLayout.addComponent(setQ62("m.\tHeart attack/ IHD"));
        secondQAnswerLayout.addComponent(setQ62("n.\tStroke"));
        secondQAnswerLayout.addComponent(setQ62("o.\tCongenital heart diseases"));
        secondQAnswerLayout.addComponent(setQ62("p.\tArrhythmias "));
        secondQAnswerLayout.addComponent(setQ62("q.\tOther heart diseases"));
        secondQAnswerLayout.addComponent(setQ62("r.\tDepression"));
        secondQAnswerLayout.addComponent(setQ62("s.\tOther mental health disorders"));

        HorizontalLayout q63Layout = new HorizontalLayout();
        q63Layout.setSizeFull();
        Label q63Label = new Label("6.3 Have you been diagnosed as having anemia earlier?");
        q63Label.setSizeFull();
        ComboBox q63Combo = new ComboBox();
        q63Combo.setSizeFull();
        q63Combo.setItems("No","Yes, during a previous pregnancy","Yes, after giving birth during a previous pregnancy/ miscarriage",
                "Yes, but not during pregnancy or postpartum period of a previous pregnancy");
        q63Layout.addComponents(q63Label,q63Combo);
        q63Layout.setExpandRatio(q63Label,3);
        q63Layout.setExpandRatio(q63Combo,1);
        tab.addComponent(q63Layout);

        VerticalLayout dependentLayout = new VerticalLayout();
        dependentLayout.setSizeFull();
        tab.addComponent(dependentLayout);
        dependentLayout.setMargin(false);
        ComboBoxMultiselect<String> anemiaCombo =new ComboBoxMultiselect();
        anemiaCombo.setItems(Arrays.asList("Dietary modifications to include iron rich foods","Iron tablets/ syrup supplements",
                "Other vitamin supplements","Intravenous iron treatments","Blood transfusion"));
        setTabData(dependentLayout,"6.4 If you ever had anemia previously, what were the treatments/ remedies you had? ",anemiaCombo);
        dependentLayout.setVisible(false);
        q63Combo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() == null || String.valueOf(valueChangeEvent.getValue()).isEmpty() || valueChangeEvent.getValue().equals("No") ){
                dependentLayout.setVisible(false);
            }
            else{
                dependentLayout.setVisible(true);
            }
        });

        ComboBox monthsCombo = new ComboBox();
        monthsCombo.setSizeFull();
        monthsCombo.setItems(getStringList(0,24));
        setTabData(dependentLayout,"6.5 If you were given iron treatments for how long did you take it? ",monthsCombo);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        ComboBox yearCombo = new ComboBox("Years");
        yearCombo.setSizeFull();
        yearCombo.setItems(getStringList(0,20));
        ComboBox monthCombo = new ComboBox("Months");
        monthCombo.setItems(getStringList(0,12));
        monthCombo.setSizeFull();
        layout.addComponents(yearCombo,monthCombo);
        setTabData(dependentLayout,"6.6 If you received any blood transfusions, how many months/years ago did you receive the last transfusion?",layout);

        ComboBox investigationCombo = new ComboBox();
        investigationCombo.setSizeFull();
        investigationCombo.setItems(yesNoList);
        setTabData(dependentLayout,"6.7 Did you have any investigations to confirm anemia was cured?",investigationCombo);

        HorizontalLayout thalassemiaLayout = new HorizontalLayout();
        thalassemiaLayout.setSizeFull();
        Label thalLabel = new Label("6.8 Have you been screened for thalassemia?");
        thalLabel.setSizeFull();
        ComboBox thalassemiaCombo = new ComboBox();
        thalassemiaCombo.setSizeFull();
        thalassemiaCombo.setItems(yesNoList);
        thalassemiaLayout.addComponents(thalLabel,thalassemiaCombo);
        thalassemiaLayout.setExpandRatio(thalLabel,3);
        thalassemiaLayout.setExpandRatio(thalassemiaCombo,1);
        tab.addComponent(thalassemiaLayout);

        VerticalLayout thalDependLayout = new VerticalLayout();
        thalDependLayout.setSizeFull();
        tab.addComponent(thalDependLayout);
        thalDependLayout.setMargin(false);
        thalDependLayout.setVisible(false);
        thalassemiaCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() == null  || valueChangeEvent.getValue().equals("No") || String.valueOf(valueChangeEvent.getValue()).isEmpty()){
                thalDependLayout.setVisible(false);
            }
            else {
                thalDependLayout.setVisible(true);
            }
        });

        ComboBox thalassemiaYesCombo = new ComboBox();
        thalassemiaYesCombo.setSizeFull();
        thalassemiaYesCombo.setItems(Arrays.asList("No","Yes, I got a green color card (no thalassemia)","Yes, I got a pink color card ( thalassemia trait)",
                "Yes, I have thalassemia intermedia","Yes, I have thalassemia major"));
        setTabData(thalDependLayout,"6.9 If so what is the result?",thalassemiaYesCombo);

        ComboBox bleedingCombo = new ComboBox();
        bleedingCombo.setSizeFull();
        bleedingCombo.setItems(yesNoList);
        setTabData(tab,"6.10 Within last six months did notice bleeding while passing stools?",bleedingCombo);

        ComboBox blackCombo = new ComboBox();
        blackCombo.setSizeFull();
        blackCombo.setItems(yesNoList);
        setTabData(tab,"6.11 Within the last six months did you pass black colored tar like stools?",blackCombo);

        ComboBox wormCombo = new ComboBox();
        wormCombo.setSizeFull();
        wormCombo.setItems(yesNoList);
        setTabData(tab,"6.12 Have you taken worm treatment in last six months? ",wormCombo);
    }

    private void setTab7Data(VerticalLayout tab){

        Label q1Header = new Label("7.1 Is your mother, father or a sibling diagnosed to have following conditions?");
        q1Header.setSizeFull();
        tab.addComponent(q1Header);

        VerticalLayout questionLayout = new VerticalLayout();
        questionLayout.setSizeFull();
        questionLayout.setMargin(true);
        tab.addComponent(questionLayout);
        questionLayout.setWidth("60%");
        setYesNoQuestions(questionLayout,"a.\tDiabetes mellitus");
        setYesNoQuestions(questionLayout,"b.\tStroke");
        setYesNoQuestions(questionLayout,"c.\tHypertension");
        setYesNoQuestions(questionLayout,"d.\tLiver diseases");
        setYesNoQuestions(questionLayout,"e.\tDyslipidemia");
        setYesNoQuestions(questionLayout,"f.\tOther Cardiac disease conditions");
        setYesNoQuestions(questionLayout,"g.\tHeart attack/ IHD");
        setYesNoQuestions(questionLayout,"h.\tMental disorders ");
        setYesNoQuestions(questionLayout,"i.\tCKD/ Renal Impairment");
    }

    private void setTab8Data(VerticalLayout tab){

        Label q1Label = new Label("1. Drug History checklist");
        q1Label.setSizeFull();
        Label q1Label1 = new Label("1.1 Are you on/have you used any of the following medications?");
        q1Label1.setSizeFull();
        tab.addComponents(q1Label,q1Label1);

        HorizontalLayout qHeaderLayout = new HorizontalLayout();
        qHeaderLayout.setSizeFull();
        Label tabletLabel = new Label("Tablet/Capsule");
        tabletLabel.setSizeFull();
        Label yesNoLabel = new Label("Yes/No");
        yesNoLabel.setSizeFull();
        Label startLabel = new Label("When did you start using it?");
        startLabel.setSizeFull();
        Label stopLabel = new Label("If stopped, when?");
        stopLabel.setSizeFull();
        Label documentLabel = new Label("Documents available or not?");
        documentLabel.setSizeFull();
        qHeaderLayout.addComponents(tabletLabel,yesNoLabel,startLabel,stopLabel,documentLabel);
        VerticalLayout questionLayout = new VerticalLayout();
        questionLayout.setSizeFull();
        questionLayout.setMargin(leftMargin);
        tab.addComponent(questionLayout);
        questionLayout.addComponent(qHeaderLayout);
        createTab8Questions(questionLayout,"Aspirin");
        createTab8Questions(questionLayout,"Statin");
        createTab8Questions(questionLayout,"Warfarin");
        createTab8Questions(questionLayout,"Enoxaparin");
        createTab8Questions(questionLayout,"Hormonal therapy");
        createTab8Questions(questionLayout,"Steroids");
        createTab8Questions(questionLayout,"Sodium valproate");
        createTab8Questions(questionLayout,"Amiodarone");
        createTab8Questions(questionLayout,"Tamoxifen");
        createTab8Questions(questionLayout,"Antipsychotics");
        createTab8Questions(questionLayout,"ACE Inhibitors");
        createTab8Questions(questionLayout,"Angiotensin receptor blockers");
        createTab8Questions(questionLayout,"Clomiphene Citrate");
    }

    private void createTab8Questions(VerticalLayout tab,String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo =new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(yesNoList);
        yesNoCombo.setWidth("70%");
        HorizontalLayout dependentQLayout = new HorizontalLayout();
        dependentQLayout.setSizeFull();
        ComboBox documentCombo = new ComboBox();
        documentCombo.setSizeFull();
        documentCombo.setItems(yesNoList);
        documentCombo.setWidth("70%");
        dependentQLayout.addComponents(getYearMonthComboLayout(),getYearMonthComboLayout(),documentCombo);
        dependentQLayout.setEnabled(false);
        yesNoCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() == null || valueChangeEvent.getValue().toString().isEmpty() ||
                    valueChangeEvent.getValue().equals("No")){
                dependentQLayout.setEnabled(false);
            }
            else{
                dependentQLayout.setEnabled(true);
            }
        });
        layout.addComponents(questionLabel,yesNoCombo,dependentQLayout);
        layout.setExpandRatio(questionLabel,1);
        layout.setExpandRatio(yesNoCombo,1);
        layout.setExpandRatio(dependentQLayout,3);
        tab.addComponent(layout);
    }

    private HorizontalLayout getYearMonthComboLayout(){
        HorizontalLayout yearMonthLayout = new HorizontalLayout();
        yearMonthLayout.setSizeFull();
        ComboBox yearCombo = new ComboBox();
        yearCombo.setSizeFull();
        yearCombo.setItems(getStringList(1990,2019));
        ComboBox monthCombo = new ComboBox();
        monthCombo.setSizeFull();
        monthCombo.setItems(getStringList(1,12));
        yearMonthLayout.addComponents(yearCombo,monthCombo);
        return yearMonthLayout;
    }

    private void setYesNoQuestions(VerticalLayout layout,String question){

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        layout.addComponent(horizontalLayout);
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(yesNoList);
        horizontalLayout.addComponents(questionLabel,yesNoCombo);
    }

    private void setQ62Header(VerticalLayout tab){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();

        Label label = new Label("Are you diagnosed with this disease");
        label.setSizeFull();
        Label label1 = new Label("Do you have any documentary evidence of diagnosis?");
        label1.setSizeFull();
        Label label2 = new Label("When was the disease diagnosed? (Year)");
        label2.setSizeFull();
        Label label3 = new Label("Do you take medications for this disease? ");
        label3.setSizeFull();
        Label label4 = new Label("Where are you being followed up?");
        label4.setSizeFull();
        Label label5 = new Label(" ");
        label5.setSizeFull();
        layout.addComponents(label5,label,label1,label2,label3,label4);
        layout.setExpandRatio(label5,2);
        layout.setExpandRatio(label,1);
        layout.setExpandRatio(label1,1);
        layout.setExpandRatio(label2,1);
        layout.setExpandRatio(label3,1);
        layout.setExpandRatio(label4,1);
        tab.addComponent(layout);
    }

    private HorizontalLayout setQ62(String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();

        List<String> yesNoList = Arrays.asList("Yes","No");
        ComboBox diagnosedCombo = new ComboBox();
        diagnosedCombo.setItems(yesNoList);
        diagnosedCombo.setSizeFull();

        ComboBox documentaryCombo = new ComboBox();
        documentaryCombo.setItems(yesNoList);
        documentaryCombo.setSizeFull();

        ComboBox yearCombo = new ComboBox();
        yearCombo.setItems(getStringList(2000,2019));
        yearCombo.setSizeFull();

        ComboBox medicationsCombo = new ComboBox();
        medicationsCombo.setItems(yesNoList);
        medicationsCombo.setSizeFull();

        ComboBox placeCombo = new ComboBox();
        placeCombo.setItems(Arrays.asList("Government sector","Private sector","Self-medicate","Ayurveda/ Indigenous","No follow up"));
        placeCombo.setSizeFull();

        HorizontalLayout dependentLayout = new HorizontalLayout();
        dependentLayout.setSizeFull();
        dependentLayout.addComponents(documentaryCombo,yearCombo,medicationsCombo,placeCombo);
        dependentLayout.setEnabled(false);
        diagnosedCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() == null || !valueChangeEvent.getValue().equals("Yes")){
                dependentLayout.setEnabled(false);
            }
            else{
                dependentLayout.setEnabled(true);
            }
        });

        layout.addComponents(label,diagnosedCombo,dependentLayout);
        layout.setExpandRatio(label,2);
        layout.setExpandRatio(diagnosedCombo,1);
        layout.setExpandRatio(dependentLayout,4);
        return  layout;
    }

    private HorizontalLayout getQ61Questions(String question){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(Arrays.asList("Yes","No"));
        layout.addComponents(label,yesNoCombo);
        layout.setExpandRatio(label,2);
        layout.setExpandRatio(yesNoCombo,1);
        return layout;
    }

    private HorizontalLayout addQ52and3Questions(CheckBoxGroup<String> multi,String questionStr){
        HorizontalLayout q52Layout = new HorizontalLayout();
        q52Layout.setSizeFull();

        Label question = new Label(questionStr);
        question.setSizeFull();

        multi.setSizeFull();
        q52Layout.addComponents(question,multi);
        q52Layout.setExpandRatio(question,1);
        q52Layout.setExpandRatio(multi,2);
        return q52Layout;
    }

    private void addQ5Questions(String question,VerticalLayout tab){

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        layout.addComponents(questionLabel,getSymptomsLayouts(),getSymptomsLayouts());
        tab.addComponent(layout);
    }

    private HorizontalLayout getSymptomsLayouts(){
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setItems(Arrays.asList("Yes","No"));

        ComboBox frequencyCombo = new ComboBox();
        frequencyCombo.setSizeFull();
        frequencyCombo.setItems(Arrays.asList("Once a month","2-4 times per month","Several times per month","Almost daily"));

        ComboBox worsenYesNoCombo = new ComboBox();
        worsenYesNoCombo.setSizeFull();
        worsenYesNoCombo.setItems(Arrays.asList("Yes","No"));

        ComboBox adviceCombo = new ComboBox();
        adviceCombo.setSizeFull();
        adviceCombo.setItems(Arrays.asList("Yes","No"));

        HorizontalLayout dependentLayout = new HorizontalLayout();
        dependentLayout.setSizeFull();
        dependentLayout.addComponents(frequencyCombo,worsenYesNoCombo,adviceCombo);
        dependentLayout.setEnabled(false);

        yesNoCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() == null || !valueChangeEvent.getValue().equals("Yes")){
                dependentLayout.setEnabled(false);
            }
            else{
                dependentLayout.setEnabled(true);
            }
        });

        HorizontalLayout beforeConceptionLayout = new HorizontalLayout();
        beforeConceptionLayout.setSizeFull();
        beforeConceptionLayout.addComponents(yesNoCombo,dependentLayout);
        beforeConceptionLayout.setExpandRatio(yesNoCombo,1);
        beforeConceptionLayout.setExpandRatio(dependentLayout,3);
        return beforeConceptionLayout;
    }


    private void dependentLayoutAdd(VerticalLayout tab,ComboBox mainComb,ComboBox dependentCombo,String labelVal){
        HorizontalLayout screenLayout = new HorizontalLayout();
        screenLayout.setSizeFull();
        Label q42Label = new Label(labelVal);
        q42Label.setSizeFull();
        dependentCombo.setSizeFull();
        screenLayout.addComponents(q42Label,dependentCombo);
        screenLayout.setExpandRatio(q42Label,3);
        screenLayout.setExpandRatio(dependentCombo,1);
        tab.addComponent(screenLayout);
        screenLayout.setVisible(false);
        mainComb.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() != null && valueChangeEvent.getValue().equals("Yes")){
                screenLayout.setVisible(true);
            }
            else{
                screenLayout.setVisible(false);
            }
        });
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

    private List<String> getStringList(int start,int count){
        List<String> intList = new ArrayList<>();
        for(int i = start;i <= count;i++){
            intList.add(i+"");
        }
        return intList;
    }

    private void setTabData(VerticalLayout tab, String question, Component comp1){
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLable = new Label(question);
        emptyLable.setSizeFull();
        comp1.setSizeFull();
        headerLayout.addComponents(emptyLable,comp1);
        headerLayout.setExpandRatio(emptyLable,3);
        headerLayout.setExpandRatio(comp1,1);
        tab.addComponent(headerLayout);
    }

    private void setTabData(VerticalLayout tab, String question, Component comp1,Component comp2){
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLable = new Label(question);
        emptyLable.setSizeFull();
        comp1.setSizeFull();

        if(comp2 != null){
            comp2.setSizeFull();
            headerLayout.addComponents(emptyLable,comp1,comp2);
            headerLayout.setExpandRatio(emptyLable,3);
            headerLayout.setExpandRatio(comp1,1);
            headerLayout.setExpandRatio(comp2,1);
        }
        else{
            headerLayout.addComponents(emptyLable,comp1);
            headerLayout.setExpandRatio(emptyLable,3);
            headerLayout.setExpandRatio(comp1,2);
        }
        tab.addComponent(headerLayout);
    }
}