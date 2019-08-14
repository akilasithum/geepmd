package com.geepmd.utils;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

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
}
