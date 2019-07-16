package com.geepmd.ui.baseLineSurvey;

import com.geepmd.entity.BaselineQ3;
import com.geepmd.entity.BaselineQ32;
import com.geepmd.ui.Survey;
import com.geepmd.utils.Answer;
import com.geepmd.utils.EnglishMap;
import com.geepmd.utils.SinhalaMap;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import org.vaadin.addons.ComboBoxMultiselect;

import java.util.*;

import static com.geepmd.utils.SurveyUtils.*;

public class Tab3 extends VerticalLayout {

    Map<String,List<String>> answerMap;
    Map<String,String> q3Map;
    Map<String,String> q32FiledMap;
    String language;
    ComboBox conceivedTimeCombo;
    ComboBox breastFeedCombo;
    ComboBox supplementsCombo;
    ComboBox supplementsAfterCombo;
    TextField ironUsedMonths;
    TextField breastFeedStopMonths;
    VerticalLayout tab3MainDetails;
    VerticalLayout q32MainLayout;
    Survey survey;

    public Tab3(String language,Survey survey){
        this.language = language;
        if(language.equals("EN")){
            answerMap = EnglishMap.getq1AnswerList();
            q3Map = EnglishMap.getquestion1Map();

        }
        else{
            answerMap = SinhalaMap.getQ3AnswerList();
            q3Map = SinhalaMap.getQ3Map();
            q32FiledMap = SinhalaMap.getQ32Fields();
        }
        this.survey = survey;
        createLayout(language);
        setSizeFull();
        setMargin(true);
    }

    private void createLayout(String language){
        conceivedTimeCombo = new ComboBox();
        conceivedTimeCombo.setItems(getStringList(1,10));
        addComponent(setTabData(q3Map.get("3.1"),conceivedTimeCombo));

        tab3MainDetails = new VerticalLayout();
        tab3MainDetails.setSizeFull();
        tab3MainDetails.setMargin(false);


        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label gravidaLabel = new Label(q32FiledMap.get("3.21"));
        gravidaLabel.setSizeFull();
        Label ageLabel = new Label(q32FiledMap.get("3.22"));
        ageLabel.setSizeFull();
        Label outcomeLabel = new Label(q32FiledMap.get("3.23"));
        outcomeLabel.setSizeFull();
        Label complicationLabel = new Label(q32FiledMap.get("3.24"));
        complicationLabel.setSizeFull();
        Label poaLabel = new Label(q32FiledMap.get("3.25"));
        poaLabel.setSizeFull();
        Label deliveryLabel = new Label(q32FiledMap.get("3.26"));
        deliveryLabel.setSizeFull();
        Label birthWeightLabel = new Label(q32FiledMap.get("3.27"));
        birthWeightLabel.setSizeFull();
        Label neonatalLabel = new Label(q32FiledMap.get("3.28"));
        neonatalLabel.setSizeFull();
        Label postpartumLabel = new Label(q32FiledMap.get("3.29"));
        postpartumLabel.setSizeFull();
        headerLayout.addComponents(gravidaLabel,ageLabel,outcomeLabel,
                complicationLabel,poaLabel,deliveryLabel,birthWeightLabel,neonatalLabel,postpartumLabel);

        q32MainLayout = new VerticalLayout();
        q32MainLayout.setSizeFull();
        q32MainLayout.setMargin(false);
        addComponent(tab3MainDetails);
        tab3MainDetails.setVisible(false);

        conceivedTimeCombo.addValueChangeListener(valueChangeEvent -> {
            if(valueChangeEvent.getValue() != null && !valueChangeEvent.getValue().equals("1")){
                tab3MainDetails.removeAllComponents();
                q32MainLayout.removeAllComponents();
                tab3MainDetails.setVisible(true);
                tab3MainDetails.addComponent(new Label(q3Map.get("3.2")));
                tab3MainDetails.addComponent(headerLayout);
                tab3MainDetails.addComponent(q32MainLayout);
                for(int i = 1;i<Integer.parseInt(valueChangeEvent.getValue().toString());i++){
                    HorizontalLayout layout = new HorizontalLayout();
                    layout.setSizeFull();
                    q32MainLayout.addComponent(layout);
                    layout.addComponent(new Label("G"+i));
                    ComboBox ageCombo = new ComboBox();
                    ageCombo.setItems(getStringList(13,45));
                    ageCombo.setSizeFull();
                    layout.addComponent(ageCombo);

                    ComboBox outcomeCombo = new ComboBox();
                    outcomeCombo.setSizeFull();
                    outcomeCombo.setItems(getAnwerObj(answerMap.get("3.22")));
                    outcomeCombo.setDescription(getAnswerDesc(answerMap.get("3.22")));
                    layout.addComponent(outcomeCombo);

                    ComboBoxMultiselect<Answer> complicationsCombo =new ComboBoxMultiselect();
                    complicationsCombo.setSizeFull();
                    complicationsCombo.setItems(getAnwerObj(answerMap.get("3.23")));
                    complicationsCombo.setDescription(getAnswerDesc(answerMap.get("3.23")));
                    layout.addComponent(complicationsCombo);

                    ComboBox poaCombo = new ComboBox();
                    poaCombo.setSizeFull();
                    poaCombo.setItems(getReverseStrList(41,0));
                    layout.addComponent(poaCombo);

                    ComboBox deliveryCombo = new ComboBox();
                    deliveryCombo.setSizeFull();
                    deliveryCombo.setItems(getAnwerObj(answerMap.get("3.25")));
                    deliveryCombo.setDescription(getAnswerDesc(answerMap.get("3.25")));
                    layout.addComponent(deliveryCombo);

                    TextField weightFld = new TextField();
                    weightFld.setSizeFull();
                    layout.addComponent(weightFld);
                    weightFld.addValueChangeListener(event -> {
                        if(event.getValue() != null && !weightLimit(event.getValue())){
                            weightFld.clear();
                            Notification.show("Weight should be in between 1.5Kg and 6kg", Notification.Type.WARNING_MESSAGE);
                        }
                    });

                    ComboBoxMultiselect<Answer> neonatalCombo =new ComboBoxMultiselect();
                    neonatalCombo.setSizeFull();
                    neonatalCombo.setItems(getAnwerObj(answerMap.get("3.27")));
                    neonatalCombo.setDescription(getAnswerDesc(answerMap.get("3.27")));
                    layout.addComponent(neonatalCombo);

                    ComboBoxMultiselect<Answer> postpartumCombo =new ComboBoxMultiselect();
                    postpartumCombo.setSizeFull();
                    postpartumCombo.setItems(getAnwerObj(answerMap.get("3.28")));
                    postpartumCombo.setDescription(getAnswerDesc(answerMap.get("3.28")));
                    layout.addComponent(postpartumCombo);
                }

                breastFeedCombo = new ComboBox();
                breastFeedCombo.setSizeFull();
                breastFeedCombo.setItems( getAnwerObj(answerMap.get("3.3")));
                breastFeedCombo.setDescription(getAnswerDesc(answerMap.get("3.3")));
                tab3MainDetails.addComponent(setTabData(q3Map.get("3.3"),breastFeedCombo));

                breastFeedStopMonths = new TextField();
                breastFeedStopMonths.setSizeFull();
                Label q34Label = new Label(q3Map.get("3.4"));
                q34Label.setSizeFull();
                HorizontalLayout q34Layout = new HorizontalLayout();
                q34Layout.setSizeFull();
                q34Layout.addComponents(q34Label,breastFeedStopMonths);
                q34Layout.setExpandRatio(q34Label,3);
                q34Layout.setExpandRatio(breastFeedStopMonths,1);
                tab3MainDetails.addComponent(q34Layout);
                q34Layout.setVisible(false);

                breastFeedCombo.addValueChangeListener(valueChangeEvent1 -> {
                    Answer answer = (Answer) valueChangeEvent1.getValue();
                    if(answer != null && answer.getId() == 2){
                        q34Layout.setVisible(true);
                    }
                    else{
                        q34Layout.setVisible(false);
                    }
                });

                supplementsCombo = new ComboBox();
                supplementsCombo.setSizeFull();
                supplementsCombo.setItems(getYesNoAnswer(language));
                tab3MainDetails.addComponent(setTabData(q3Map.get("3.5"),supplementsCombo));

                supplementsAfterCombo = new ComboBox();
                supplementsAfterCombo.setSizeFull();
                supplementsAfterCombo.setItems(getAnwerObj(answerMap.get("3.6")));
                supplementsAfterCombo.setDescription(getAnswerDesc(answerMap.get("3.6")));
                tab3MainDetails.addComponent(setTabData(q3Map.get("3.6"),
                        supplementsAfterCombo));

                HorizontalLayout q37Layout = new HorizontalLayout();
                q37Layout.setSizeFull();
                Label q37Label = new Label(q3Map.get("3.7"));
                q37Label.setSizeFull();
                ironUsedMonths = new TextField();
                ironUsedMonths.setSizeFull();
                q37Layout.addComponents(q37Label,ironUsedMonths);
                q37Layout.setExpandRatio(q37Label,3);
                q37Layout.setExpandRatio(ironUsedMonths,1);
                tab3MainDetails.addComponent(q37Layout);
                q37Layout.setVisible(false);

                supplementsAfterCombo.addValueChangeListener(valueChangeEvent1 -> {
                    Answer answer = (Answer) valueChangeEvent1.getValue();
                    if(answer == null || answer.getId() == 3) {
                        q37Layout.setVisible(false);
                    }
                    else{
                        q37Layout.setVisible(true);
                    }
                });
            }
            else{
                tab3MainDetails.removeAllComponents();
                removeComponent(tab3MainDetails);
            }
        });
        Button nextBtn = new Button("Next");
        nextBtn.setIcon(VaadinIcons.ARROW_FORWARD);
        nextBtn.setStyleName("bottomBackBtn");
        nextBtn.addClickListener(event -> {
            survey.SelectTab(3);
        });
        addComponent(nextBtn);
    }

    private boolean weightLimit(String value){
        try{
            float val = Float.parseFloat(value);
            if(value.length() == 1){
                return val >= 1 || val <= 6;
            }
            else if(value.length() == 2 && value.contains(".")){
                return true;
            }
            else
            return val >= 1.5 && val < 6.0;
        }
        catch (Exception e){
                return false;
        }
    }

    public List<BaselineQ32> getQ32Answers(int motherId){
        List<BaselineQ32> list = new ArrayList<>();

        for(int i = 0;i<q32MainLayout.getComponentCount();i++){
            BaselineQ32 answer = new BaselineQ32();
            HorizontalLayout layout = (HorizontalLayout) q32MainLayout.getComponent(i);
            ComboBox m1 = (ComboBox)layout.getComponent(1);
            ComboBox m2 = (ComboBox)layout.getComponent(2);
            ComboBoxMultiselect m3 = (ComboBoxMultiselect)layout.getComponent(3);
            ComboBox m4 = (ComboBox)layout.getComponent(4);
            ComboBox m5 = (ComboBox)layout.getComponent(5);
            TextField m6 = (TextField)layout.getComponent(6);
            ComboBoxMultiselect m7 = (ComboBoxMultiselect)layout.getComponent(7);
            ComboBoxMultiselect m8 = (ComboBoxMultiselect)layout.getComponent(8);
            answer.setMotherId(motherId);

            if(m1.getValue() != null) answer.setM1(Integer.parseInt(m1.getValue().toString()));
            if(m2.getValue() != null) answer.setM2(getId((Answer)m2.getValue()));
            if(m3.getValue() != null && m3.getValue().size() != 0) answer.setM3(getStringFromSet(m3.getValue()));
            if(m4.getValue() != null) answer.setM4(Integer.parseInt(m4.getValue().toString()));
            if(m5.getValue() != null) answer.setM5(getId((Answer)m5.getValue()));
            if(m6.getValue() != null) answer.setM6(m6.getValue());
            if(m7.getValue() != null && m7.getValue().size() != 0) answer.setM7(getStringFromSet(m7.getValue()));
            if(m8.getValue() != null && m8.getValue().size() != 0) answer.setM8(getStringFromSet(m8.getValue()));

            list.add(answer);
        }

        return list;
    }

    private String getStringFromSet(Set<Answer> set){
        String  val = "";
        for(Answer answer : set){
            val += answer.getId() +",";
        }
        return val.substring(0,val.length()-1);
    }

    public BaselineQ3 getAnswer(int motherId){
        BaselineQ3 answer = new BaselineQ3();

        answer.setMotherId(motherId);
        if(conceivedTimeCombo.getValue() != null) answer.setM1(Integer.parseInt(conceivedTimeCombo.getValue().toString()));
        if(breastFeedCombo != null && breastFeedCombo.getValue() != null) answer.setM3(getId((Answer)breastFeedCombo.getValue()));
        if(breastFeedStopMonths != null && breastFeedStopMonths.getValue() != null) answer.setM4(breastFeedStopMonths.getValue());
        if(supplementsCombo != null && supplementsCombo.getValue() != null) answer.setM5(getId((Answer)supplementsCombo.getValue()));
        if(supplementsAfterCombo != null && supplementsAfterCombo.getValue() != null) answer.setM6(getId((Answer)supplementsAfterCombo.getValue()));
        if(ironUsedMonths != null && ironUsedMonths.getValue() != null) answer.setM7(ironUsedMonths.getValue());
        return answer;
    }

    private int getId(Answer answer){
        return answer.getId();
    }
}
