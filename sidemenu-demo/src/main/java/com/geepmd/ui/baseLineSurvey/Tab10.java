package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ10;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab10 extends VerticalLayout {

    Map<String, List<String>> answerMap;
    Map<String, String> q10Map;
    Map<String, String> fields;
    String language;
    VerticalLayout questionLayout;
    Survey survey;
    TextField questionDBUniqueIdField;
    CheckBox noToAll;

    public Tab10(String language, Survey survey) {
        this.language = language;
        if (language.equals("EN")) {
            answerMap = EnglishMap.getq1AnswerList();
            q10Map = EnglishMap.getquestion1Map();

        } else {
            answerMap = SinhalaMap.getQ10AnswerList();
            q10Map = SinhalaMap.getQ10Map();
            fields = SinhalaMap.getQ10Fields();
        }
        this.survey = survey;
        createLayout();
        setSizeFull();
        setMargin(true);
    }

    private void createLayout() {
        questionDBUniqueIdField = new TextField();
        questionDBUniqueIdField.setVisible(false);
        addComponent(questionDBUniqueIdField);
        Label q1Label = new Label(q10Map.get("10.1"));
        q1Label.setSizeFull();
        addComponents(q1Label);
        noToAll = new CheckBox(fields.get("9.1"));
        addComponent(noToAll);
        noToAll.setStyleName("checkBoxMargin");
        noToAll.addValueChangeListener(event -> {
            setNoToAllCombo(event.getValue());
        });

        HorizontalLayout qHeaderLayout = new HorizontalLayout();
        qHeaderLayout.setSizeFull();
        Label tabletLabel = new Label(fields.get("a"));
        tabletLabel.setSizeFull();
        Label yesNoLabel = new Label(fields.get("b"));
        yesNoLabel.setSizeFull();
        Label startLabel = new Label(fields.get("c"));
        startLabel.setSizeFull();
        Label stopLabel = new Label(fields.get("d"));
        stopLabel.setSizeFull();
        Label documentLabel = new Label(fields.get("e"));
        documentLabel.setSizeFull();
        qHeaderLayout.addComponents(tabletLabel, yesNoLabel, startLabel, stopLabel, documentLabel);
        questionLayout = new VerticalLayout();
        questionLayout.setSizeFull();
        questionLayout.setMargin(new MarginInfo(false, false, false, true));
        addComponent(questionLayout);
        questionLayout.addComponent(qHeaderLayout);
        createTab8Questions(questionLayout, "Aspirin");
        createTab8Questions(questionLayout, "Statin");
        createTab8Questions(questionLayout, "Warfarin");
        createTab8Questions(questionLayout, "Enoxaparin");
        createTab8Questions(questionLayout, "Hormonal therapy");
        createTab8Questions(questionLayout, "Steroids");
        createTab8Questions(questionLayout, "Sodium valproate");
        createTab8Questions(questionLayout, "Amiodarone");
        createTab8Questions(questionLayout, "Tamoxifen");
        createTab8Questions(questionLayout, "Antipsychotics");
        createTab8Questions(questionLayout, "ACE Inhibitors");
        createTab8Questions(questionLayout, "Angiotensin receptor blockers");
        createTab8Questions(questionLayout, "Clomiphene Citrate");

        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(10);
        });
        addComponent(nextBtn);
    }

    private void createTab8Questions(VerticalLayout tab, String question) {

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label questionLabel = new Label(question);
        questionLabel.setSizeFull();
        ComboBox yesNoCombo = new ComboBox();
        yesNoCombo.setSizeFull();
        yesNoCombo.setTextInputAllowed(false);
        yesNoCombo.setItems(getYesNoAnswer(language));
        yesNoCombo.setWidth("90%");
        HorizontalLayout dependentQLayout = new HorizontalLayout();
        dependentQLayout.setSizeFull();
        ComboBox documentCombo = new ComboBox();
        documentCombo.setSizeFull();
        documentCombo.setItems(getAnwerObj(answerMap.get("9.1")));
        documentCombo.setDescription(getAnswerDesc(answerMap.get("9.1")));
        documentCombo.setTextInputAllowed(false);
        documentCombo.setWidth("90%");
        dependentQLayout.addComponents(documentCombo, getYearMonthComboLayout(), getYearMonthComboLayout());
        dependentQLayout.setEnabled(false);
        yesNoCombo.addValueChangeListener(valueChangeEvent -> {
            Answer answer = (Answer) valueChangeEvent.getValue();
            if (answer == null || answer.getId() == 2) {
                dependentQLayout.setEnabled(false);
            } else {
                dependentQLayout.setEnabled(true);
            }
        });
        layout.addComponents(questionLabel, yesNoCombo, dependentQLayout);
        layout.setExpandRatio(questionLabel, 1);
        layout.setExpandRatio(yesNoCombo, 1);
        layout.setExpandRatio(dependentQLayout, 4);
        tab.addComponent(layout);
    }

    private HorizontalLayout getYearMonthComboLayout() {
        HorizontalLayout yearMonthLayout = new HorizontalLayout();
        yearMonthLayout.setSizeFull();
        ComboBox yearCombo = new ComboBox();
        yearCombo.setSizeFull();
        yearCombo.setItems(getStringList(1990, 2019));
        ComboBox monthCombo = new ComboBox();
        monthCombo.setSizeFull();
        monthCombo.setItems(getStringList(1, 12));
        yearMonthLayout.addComponents(yearCombo, monthCombo);
        //yearMonthLayout.setMargin(new MarginInfo(false,false,false,true));
        yearMonthLayout.setWidth("90%");
        return yearMonthLayout;
    }

    private String getYearMonthComboValue(HorizontalLayout layout) {
        ComboBox hourCombo = (ComboBox) layout.getComponent(0);
        ComboBox minuteCombo = (ComboBox) layout.getComponent(1);
        String time = "";
        if (hourCombo.getValue() != null) time = String.valueOf(hourCombo.getValue()) + " ";
        time += minuteCombo.getValue() != null ? getMothFromIndex(Integer.parseInt(minuteCombo.getValue().toString())) : "";
        return time;
    }

    private void setNoToAllCombo(boolean isNo) {

        for (int i = 1; i < questionLayout.getComponentCount(); i++) {
            HorizontalLayout layout = (HorizontalLayout) questionLayout.getComponent(i);
            ComboBox comboBox = (ComboBox) layout.getComponent(1);
            Answer no = new Answer();
            no.setId(2);
            no.setDescription("2.නැත");
            if (isNo) {
                comboBox.setValue(no);
            } else {
                comboBox.clear();
            }
        }
    }

    public List<BaselineQ10> getAnswerQ10(int surveyId) {
        List<BaselineQ10> answerList = new ArrayList<>();
        for (int i = 1; i < questionLayout.getComponentCount(); i++) {
            HorizontalLayout layout = (HorizontalLayout) questionLayout.getComponent(i);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            BaselineQ10 answer = new BaselineQ10();
            answer.setM1(i);
            answer.setSurveyId(surveyId);
            if (yesNoCombo != null && yesNoCombo.getValue() != null) {
                int choice = getId((Answer) yesNoCombo.getValue());
                answer.setM2(choice);
                if (choice == 1) {
                    HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
                    ComboBox docCombo = (ComboBox) dependentLayout.getComponent(0);
                    String start = getYearMonthComboValue((HorizontalLayout) dependentLayout.getComponent(1));
                    String end = getYearMonthComboValue((HorizontalLayout) dependentLayout.getComponent(2));
                    if (docCombo.getValue() != null) answer.setM3(getId((Answer) docCombo.getValue()));
                    if (!start.isEmpty()) answer.setM4(start);
                    if (!end.isEmpty()) answer.setM5(end);
                } else {
                    answer.setM3(8888);
                    answer.setM4("8888");
                    answer.setM5("8888");
                }
            }
            answerList.add(answer);
        }
        return answerList;
    }

    public void setEditData(List<BaselineQ10> answer) {


        Map<Integer, BaselineQ10> map = answer.stream().collect(Collectors.toMap(x -> x.getM1(), x -> x));

        for (int i = 1; i <= answer.size(); i++) {
            HorizontalLayout layout = (HorizontalLayout) questionLayout.getComponent(i);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
            ComboBox currentCombo = (ComboBox) dependentLayout.getComponent(0);
            BaselineQ10 baselineQ62 = map.get(i);
            if (baselineQ62.getM2() != 0) {
                yesNoCombo.setValue(getYesNoObject("SN", baselineQ62.getM2()));
                if (baselineQ62.getM2() == 1) {
                    currentCombo.setValue(getAnswerObj(baselineQ62.getM3(), answerMap.get("9.1")));
                    HorizontalLayout startLayout = (HorizontalLayout) dependentLayout.getComponent(1);
                    HorizontalLayout stopLayout = (HorizontalLayout) dependentLayout.getComponent(2);
                    String startStr = baselineQ62.getM4();
                    String stopStr = baselineQ62.getM5();

                    ComboBox startYearCombo = (ComboBox) startLayout.getComponent(0);
                    ComboBox startMonthCombo = (ComboBox) startLayout.getComponent(1);
                    if (startStr != null && !startStr.isEmpty()) {
                        String[] arr = startStr.split(" ");
                        if (arr.length == 2) {
                            startYearCombo.setValue(arr[0]);
                            startMonthCombo.setValue(getIndexFromMonth(arr[1]));
                        }
                    }
                    ComboBox stopYearCombo = (ComboBox) stopLayout.getComponent(0);
                    ComboBox stopMonthCombo = (ComboBox) stopLayout.getComponent(1);
                    if (stopStr != null && !stopStr.isEmpty()) {
                        String[] arr = stopStr.split(" ");
                        if (arr.length == 2) {
                            stopYearCombo.setValue(arr[0]);
                            stopMonthCombo.setValue(getIndexFromMonth(arr[1]));
                        }
                    }
                }
            }
        }
    }

    public void clearFields() {
        noToAll.clear();
        for (int i = 1; i <= questionLayout.getComponentCount()-1; i++) {
            HorizontalLayout layout = (HorizontalLayout) questionLayout.getComponent(i);
            ComboBox yesNoCombo = (ComboBox) layout.getComponent(1);
            HorizontalLayout dependentLayout = (HorizontalLayout) layout.getComponent(2);
            ComboBox currentCombo = (ComboBox) dependentLayout.getComponent(0);
            yesNoCombo.clear();
            currentCombo.clear();
            HorizontalLayout startLayout = (HorizontalLayout) dependentLayout.getComponent(1);
            HorizontalLayout stopLayout = (HorizontalLayout) dependentLayout.getComponent(2);

            ComboBox startYearCombo = (ComboBox) startLayout.getComponent(0);
            ComboBox startMonthCombo = (ComboBox) startLayout.getComponent(1);

            startYearCombo.clear();
            startMonthCombo.clear();
            ComboBox stopYearCombo = (ComboBox) stopLayout.getComponent(0);
            ComboBox stopMonthCombo = (ComboBox) stopLayout.getComponent(1);

            stopYearCombo.clear();
            stopMonthCombo.clear();

        }
    }

    private int getId(Answer answer) {
        return answer.getId();
    }

    private String getMothFromIndex(int id) {
        return Month.of(id).name();
    }

    private int getIndexFromMonth(String month) {
        return Month.valueOf(month.toUpperCase()).getValue();
    }
}
