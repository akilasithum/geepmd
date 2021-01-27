package com.geepmd.utils;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public class SurveyUtils {

    public static List<String> getStringList(int start, int count){
        List<String> intList = new ArrayList<>();
        for(int i = start;i <= count;i++){
            intList.add(i+"");
        }
        return intList;
    }

    public static List<String> getReverseStrList(int start,int end){
        List<String> intList = new ArrayList<>();
        for(int i = start;i >= end;i--){
            intList.add(i+"");
        }
        return intList;
    }

    public static HorizontalLayout setTabData(String question, Component comp1){
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setSizeFull();
        Label emptyLable = new Label(question);
        emptyLable.setSizeFull();
        comp1.setSizeFull();
        headerLayout.addComponents(emptyLable,comp1);
        headerLayout.setExpandRatio(emptyLable,3);
        headerLayout.setExpandRatio(comp1,1);
        return headerLayout;
    }

    public static List<Answer> getYesNoAnswer(String language){
        List<Answer> answerList = new ArrayList<>();
        if(language.equals("EN")){
            Answer yes = new Answer();
            yes.setId(1);
            yes.setDescription("1.Yes");
            Answer no = new Answer();
            no.setId(2);
            no.setDescription("2.No");
            answerList.addAll(Arrays.asList(yes,no));
        }
        else {
            Answer yes = new Answer();
            yes.setId(1);
            yes.setDescription("1.ඔව්");
            Answer no = new Answer();
            no.setId(2);
            no.setDescription("2.නැත");
            answerList.addAll(Arrays.asList(yes,no));
        }
        return answerList;
    }

    public static Answer getYesNoObject(String language,int option){
        if(option != 0 && option != 8888) {
            Answer answer = new Answer();
            if (language.equals("EN")) {
                if (option == 1) {
                    answer.setId(1);
                    answer.setDescription("1.Yes");
                } else {
                    answer.setId(2);
                    answer.setDescription("2.No");
                }
            } else {

                if (option == 1) {
                    answer.setId(1);
                    answer.setDescription("1.ඔව්");
                } else {
                    answer.setId(2);
                    answer.setDescription("2.නැත");
                }
            }
            return answer;
        }
        else{
            return null;
        }
    }

    public static List<Answer> getAnwerObj(List<String> answers){
        List<Answer> answerList = new ArrayList<>();
        int i = 1;
        for(String str : answers){
            Answer answer = new Answer();
            answer.setId(i);
            answer.setDescription(str);
            answerList.add(answer);
            i++;
        }
        return answerList;
    }

    public static Set<Answer> getAnwerObjSet(List<String> answers){
        Set<Answer> answerList = new HashSet<>();
        int i = 1;
        for(String str : answers){
            Answer answer = new Answer();
            answer.setId(i);
            answer.setDescription(str);
            answerList.add(answer);
            i++;
        }
        return answerList;
    }

    public static String getAnswerDesc(List<String> answers){
        String desc = "";
        for(String str : answers){
            desc += str + "\n";
        }
        return desc;
    }

    public static Map<Integer,String> getLetterIntMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        map.put(6,"f");
        map.put(7,"g");
        map.put(8,"h");
        map.put(9,"i");
        map.put(10,"j");
        map.put(11,"k");
        map.put(12,"l");
        map.put(13,"m");
        map.put(14,"n");
        map.put(15,"o");
        return map;
    }

    public static Answer getAnswerObj(int answer,List<String> qList){
        if(answer != 0 && answer != 8888) {
            try {
                Answer answerObj = new Answer();
                answerObj.setId(answer);
                answerObj.setDescription(qList.get(answer-1));
                return answerObj;
            }catch (Exception e){
                return null;
            }
        }
        else return null;
    }

    public static Set<Answer> getAnswerSetFromString(String str,List<String> answers){
        Set<Answer> anserSet = new HashSet<>();
        if(str != null && !str.isEmpty() && !str.trim().equals("") && !str.equals("8888")) {

            String[] arr = str.split(",");
            for(String answer : Arrays.asList(arr)){
                Answer answer1 = new Answer();
                int id = Integer.parseInt(answer);
                if(id != 0) {
                    answer1.setId(id);
                    answer1.setDescription(answers.get(id - 1));
                    anserSet.add(answer1);
                }
            }
            return anserSet;
        }
        else {
            return anserSet;
        }
    }

    public static String getDateStringFromDate(Date date){
        if(date != null)
            return new SimpleDateFormat("dd-MM-yyyy").format(date);
        else return null;
    }

    public static HorizontalLayout addQuestionWithAnswerObjCombo(List<String> answerList, String question){
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

    public static String getStringFromSet(Set<Answer> set) {
        String val = "";
        for (Answer answer : set) {
            val += answer.getId() + ",";
        }
        return val.isEmpty() ? "" : val.substring(0, val.length() - 1);
    }

    public static int callGetter(Object obj, String fieldName){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            Method getter = pd.getReadMethod();
            return Integer.parseInt(getter.invoke(obj).toString());

        } catch (Exception e) {
            return 0;
        }
    }

    public static String callGetterStr(Object obj, String fieldName){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            Method getter = pd.getReadMethod();
            return getter.invoke(obj).toString();

        } catch (Exception e) {
            return "";
        }
    }

    public static Answer getAnswerObj(List<String> qList, int answer){
        if(answer != 0 && answer != 8888) {
            try {
                Answer answerObj = new Answer();
                answerObj.setId(answer);
                answerObj.setDescription(qList.get(answer-1));
                return answerObj;
            }catch (Exception e){
                return null;
            }
        }
        else return null;
    }

    public static Set<Answer> getMultipleAnswerSet(String str,List<Answer> answerList){
        Set<Answer> selectedAnswers = new HashSet<>();
        if(str != null && !str.isEmpty() && !str.trim().equals("") && !str.equals("8888")){
            String[] arr = str.split(",");
            for(String ans : Arrays.asList(arr)){
                int id = Integer.parseInt(ans);
                if(id != 0) {
                    selectedAnswers.add(answerList.get(id-1));
                }
            }
        }
        return selectedAnswers;
    }

    public static HorizontalLayout getYesNoAnswerLayout(String question, MarginInfo marginInfo){
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
        layout.setMargin(marginInfo);
        return layout;
    }

    public static HorizontalLayout getYesNoAnswerLayout(String question, MarginInfo marginInfo,String language){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        ComboBox comboBox = new ComboBox();
        comboBox.setSizeFull();
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(getYesNoAnswer(language));
        layout.addComponents(label,comboBox);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(comboBox,2);
        layout.setMargin(marginInfo);
        return layout;
    }

    public static HorizontalLayout getTextBoxAnswerLayout(String question,MarginInfo marginInfo){
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        Label label = new Label(question);
        label.setSizeFull();
        TextField textField = new TextField();
        textField.setSizeFull();
        layout.addComponents(label,textField);
        layout.setExpandRatio(label,8);
        layout.setExpandRatio(textField,2);
        layout.setMargin(marginInfo);
        return layout;
    }

    public static ComboBox getComboBoxForDependentLayout(List<String> answerList,String question,VerticalLayout mainLayout){
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

    public static void setDependentLayout(ComboBox comboBox,Component layout,int val){
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

    public static void setDependentLayout(ComboBox comboBox,Component layout){
        comboBox.addValueChangeListener(event -> {
            Answer answer = (Answer) event.getValue();
            if(answer != null){
                layout.setVisible(true);
            }
            else{
                layout.setVisible(false);
            }
        });
    }
}
