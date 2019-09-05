package com.geepmd.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinhalaMap {

    static List<String> yesNoList = Arrays.asList("ඔව්","නැත");

    public static Map<String,String> getTabHeaderMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1. සමාජීය ජනගහණ තොරතුරු");
        map.put("2","2. නාරිවේදී ඉතිහාසය");
        map.put("3","3. ගර්භණී ඉතිහාසය");
        map.put("4","4. වර්තමාන ගර්භණී තත්වය පිළිබද තොරතුරු");
        map.put("5","5. ගර්භණී සමයේ රෝග ලක්ෂණ");
        map.put("6","6. කායික රෝග ඉතිහාසය");
        map.put("7","7. පවුලේ රෝග ඉතිහාසය");
        map.put("8","8. පවුලේ තොරතුරු");
        map.put("9","9. සෞඛ්\u200Dය පහසුකම් සදහා ප්\u200Dරවේශවීමේ හැකියාව");
        map.put("10","10. ඇමුණුම 1");
        map.put("11","11. Physical Assessment");
        map.put("12","12. Screening checklist");
        return map;
    }
    //answers
    public static Map<String,List<String>> getQ1AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("1.2",Arrays.asList("1.සිංහල","2.දමිළ","3.මූර්","4.මැලේ","5.බර්ගර්","6.වෙනත්"));
        map.put("1.3",Arrays.asList("1.ඔව්, ලිඛිත හා වාචික යන දෙඅංශයෙන්ම","2.ඔව්, වාචික අංශයෙන් පමණි","3.නැත"));
        map.put("1.4",Arrays.asList("1.බෞද්ධ","2.කතොලික/ක්‍රිස්තියානි","3.හින්දු","4.ඉස්ලාම්","5.වෙනත්"));
        map.put("1.6",Arrays.asList("1.සහතිකපත්‍/ පාඨමාලා","2.උපාධි","3.පාසල් අද්‍යාපනයෙන් පසු වැඩිදුර අද්‍යාපනය හදාරා නොමැත"));
        map.put("1.7",yesNoList);
        map.put("1.8",yesNoList);
        return map;
    }

    public static Map<String,List<String>> getQ2AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("2.5",Arrays.asList("1.සනීපාරක්ෂක තුවා","2.රෙදි","3.වෙනත්"));
        map.put("2.8",Arrays.asList("1. මාසික ශුද්ධි\u200Dය සාමානය ප්\u200Dරමාණයට වඩා වැඩිය",
                "2. මාසික ශුද්ධි\u200D කාලය වෙනදාට වඩා වැඩිය","3. මාසික ශුද්ධි\u200Dය සාමානය ප්\u200Dරමාණයට වඩා අඩුය",
                "4. මාසික ශුද්ධි\u200D කාලය  අඩුය","5. නිතර නිතර මද වශයෙන් රුධිරය වහනය වේ","6. ඔසප් චක්\u200Dරය අක්\u200Dරමවත් වීම",
                "7. මාස ශුද්ධි\u200Dය සිදු නොවීම","8. අධික ලෙස බර වැඩිවීම"));
        return map;
    }
    public static Map<String,List<String>> getQ3AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("3.3",Arrays.asList("1.ඔව් මේ වනවිටත් මවුකිරි ලබා දෙමින් සිට්.","2.මේ වනවිටත් මවුකිරි ලබානොදේ.","3.කිසිදින නැත"));
        map.put("3.6",Arrays.asList("1.ක්\u200Dරමවත් ලෙස යකඩ පෙති ලබා ගත්තෙමි.","2.වරින්වර යකඩ පෙති ලබා ගත්තෙමි.","3.නැත," +
                "ප්\u200Dරසූතියෙන් පසු යකඩ පෙති ලබා නොගත්තෙමි"));
        map.put("3.22",Arrays.asList("1.Live birth (After 37 weeks)","2.Intrauterine death (after 24 weeks)",
                "3.Fresh Stillbirth (Intrapartum death)","4.Pre-term birth (live birth between 24 and 37 weeks)",
                "5.Miscarriage(pregnancy loss <24 weeks)"));
        map.put("3.23",Arrays.asList("1.Gestational diabetes mellitus (GDM)","2.Pregnancy induced hypertension (PIH)",
                "3.Preeclampsia","4.Eclampsia","5.Heart diseases","6.Acute fatty liver","7.Hepatitis","8.Anemia","9.Other complications",
                "10.No complications"));
        map.put("3.25",Arrays.asList("1.Vaginal delivery","2.Forceps delivery","3.Vacuum delivery","4.Emergency cesarean section ",
                "5.Elective cesarean section","6.Not applicable","7.spontaneous expulsion","8.tablets inserted","9.surgery done"));
        map.put("3.27",Arrays.asList("1.Heart disease","2.Respiratory diseases","3.Congenital anomaly",
                "4.Admitted to a specialized unit (reason unknown)","5.Neonatal death","6.Other complications",
                "7.No complications"));
        map.put("3.28",Arrays.asList("1.Any hospital admission within first 42 days postpartum due to a cause related to pregnancy.",
                "2.PPH","3.Sepsis","4.Heart Disease","5.Post-partum depression","6.Breast conditions","7.No complications"));
        return map;
    }

    public static Map<String,List<String>> getQ4AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("4.2",Arrays.asList("1.ඔව් සැමියා සමග","2.සැමියා නොමැතිව","3.සහභාගී වූයේ නැත","4.සැසි පිළිබද නොදනී"));
        map.put("4.6",Arrays.asList("1.ක්\u200Dරමවත්ව","2.අක්\u200Dරමවත්ව","3.වෙනත්"));
        map.put("4.8",Arrays.asList("1.මුත්\u200Dරා සාම්පල","2.එච්.සි.ජි පටියක් මගින්","3.ස්කැන් පරීලක්ෂාවකින්","4.තහවුුරු කර නැත"));
        map.put("4.9",Arrays.asList("1.සාමාන්\u200Dය දරු උපතක්","2.සිසේරියන් සැත්කමක්","3.තවම තීරණය කර නොමැත"));
        map.put("4.10",Arrays.asList("1.THA","2.BHT","3.රජයේ  රෝහල","4.පුද්ගලික රෝහලක්","5.නිවස",
                "6.තීරණය කර නොමැත"));
        return map;
    }

    public static Map<String,List<String>> getQ5AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("5.1",Arrays.asList("1.මසකට වරක්  ","2.මසකට 2-4 වතාවක්","3.මසකට වැඩි වාර ගනනක්","4.දිනපතාම"));
        map.put("5.2",Arrays.asList("a. සාමාන්\u200Dය කායික ක්\u200Dරියාකාරකම් වලදි (ඇවිදිම, පඩි නැගීම) වෙහෙසක් , හුස්ම ගැනීමේ අපහසුතාවක් පපුවේ " +
                        "ගැස්මක් ඇති නොවේ", "b. පපුවේ වෙහෙස නිසා සාමාන්\u200Dය කායික ක්\u200Dරියාකාරකම් මදක් සීමා වී ඇත. " +
                        "(ඇවිදිම, පඩි නැගීම, කැමෙන් අනතුරුව ඇවිදිම, පඩි නැගීම, හැගීම්බර අවස්තාවකදි, නින්දෙන වාවදි වී පළ්මු පැය කීපයේදි)",
                "c.සාමාන්\u200Dය  ක්\u200Dරියාකාරකම් පපුවේ වෙහෙස නිසා සැලකිය යුතු ලෙස සීමාවී ඇත",
                "d.විවේකීව සිටින විට පපුවේ වෙහෙස පවති"));
        map.put("5.3",Arrays.asList("a. මාගේ සාමාන්\u200Dය  ක්\u200Dරියාකාරකම් වලට හුස්ම ගැනීමේ අපහසුව බාදාවක් නොවේ",
                "b. විවේකීව සිටින විට පහසුය, නමුත් සාමාන්\u200Dය  ක්\u200Dරියාකාරකම් වලදි පපුවේ ගැස්මක් ඇති වේ",
                "c.ඉතා සුලු කායික ක්\u200Dරියාකාරකම් පවා කර ගැනීමය අපහසුය","d. විවේකීව සිටින විටද හුස්ම ගැනීමට අපහසුය"));
        return map;
    }

    public static Map<String,List<String>>getQ6AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("6.2",Arrays.asList("1.රාජය අංශය","2.පුද්ගලික අංශය","3.ස්වයං ඖෂධ ප්\u200Dරතිකාර",
                "4.ආයූර්වේද , දේශීය ප්\u200Dරතිකාර","5.ප්\u200Dරතිකාර නොගනී"));
        map.put("6.3",Arrays.asList("1.නැත","2.ඔව්, මීට පෙර ගර්භණී අවස්ථා වලදි","3.ඔව්, පෙර දරු ප්\u200Dරසුතියෙන්/ ගබ්සාවෙන් පසුව",
                "4.ඔව්,නමුත් ගර්භණී අවස්ථා වලදිහෝ පසු ප්\u200Dරසව කාලයන්හීදි නොවේ"));
        map.put("6.4",Arrays.asList("1.යකඩ බහුල ආහාර හා ආහාර රටාවේ වෙනස්කම්","2.යකඩ පෙති","3.වෙනත් විටමින් අතිරේක",
                "4.යකඩ එන්නත් කිරම","5.රුධිර පාරවිලයනය"));
        map.put("6.9",Arrays.asList("1.නැත","2.ඔව් (කොළ් පැහැති පතිරිකාවක්- තැලිසීමියාව නැත)","" +
                        "3.ඔව් (රෝස පැහැති පතිරිකාවක්- තැලිසීමියා වාහක)","4.ඔව් (තැලිසීමියා ඉන්ටරමීඩියා රෝගය / Intermedia))",
                "5.ඔව් (තැලිසීමියා මේජර් රෝගය / major)"));
        return map;
    }

    public static Map<String,List<String>> getQ7AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("7.2",Arrays.asList("1.කලාතුරකින්","2.ඇතැම්විට","3.බොහොවිට","4.දිනපතා"));
        return map;
    }

    public static Map<String,List<String>> getQ8AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("8.3",Arrays.asList("1.රාජ්‍යය", "2.පුද්ගලික", "3.දේශීය / ආයුර්වේද", "4.වෙනත්"));
        map.put("8.5.4",Arrays.asList("1.නළ ජලය", "2.විවDත ළිද", "3.සනීපාරක්ෂිත ලිද / නළ ලිං", "4.ගංගා/ඇල/වැව්/උල්පත/පීල්ල/", "5.වැසි ජලය",
                "6.බවුසර්", "7.බෝතල් කළ ජලය", "8.පිරිපහදු කරන ලද (ෆිල්ටර් ජලය)", "9.වෙනත්" ));
        map.put("8.5.5",Arrays.asList("1.විදුලිය", "2.LPG / ස්වභාවික ගෑස්", "3.ජීව වායු", "4.භුමි තෙල්", "5.ගල් අඟුරු", "6.දර"
                , "7.ගොම", "8.වෙනත්" ));
        map.put("8.5.6",Arrays.asList("1.ජල මුද්‍රිත", "2.වළ වැසිකිලිය", "3.වැසිකිලි භාවිතා නොකරන", "4.වෙනත්" ));
        map.put("8.5.7",Arrays.asList("1.මැටි ගඩොල්", "2.සිමෙන්ති ගල්", "3.ගල්", "4.දැව / උණ පතුරු", "5.යකඩ තහඩු/ටකරන්", "6.වෙනත්" ));
        map.put("8.5.8",Arrays.asList("1.උළු", "2.ඇස්බැස්ටෝස්","3.කොන්ක්‍රීට්", "4.යකඩ තහඩු", "5.දැව / උණ පතුර", "6.මැටි ගඩොල්",
                "7.පිදුරු", "8.වෙනත්" ));
        map.put("8.5.9",Arrays.asList("1.සිමෙන්ති","2.පස් / වැලි/ මැටි", "3.ගොම මැටි", "4.දැව පොතු", "5.ඔපදැමූ දැව", "6.පිගන් ගඩොල්",
                "7.කොන්ක්‍රීට්", "8.වෙනත්" ));
        map.put("8.5.10",Arrays.asList("1.විදුලිය", "2.ලන්තෑරුම/පැට්ට්රෝමැක්ස් ලාම්පු/චිමිනි ලාම්පු", "3.ඉටිපන්දම්", "4.ගෑස් ලාම්පු",
                "5.කුප්පි ලාම්පු", "6.වෙනත්" ));
        return map;
    }

    public static Map<String,List<String>> getQ9AnswerList() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("9.5.1",Arrays.asList("5.ඉතාමත් තෘප්තිමත්", "4.තෘප්තිමත්", "3.සාමාන්‍යයි", "2.තෘප්තිමත් නොවේ",   "1.කොහෙත්ම තෘප්තිමත් නොවේ"));
        return map;
    }

    public static Map<String,List<String>> getQ10AnswerList(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("9.1",Arrays.asList("1.දැනට භාවිතා කරයි","2.දැනට භාවිතා නොකරයි"));
        return map;
    }

    //questions
    public static Map<String,String> getquestion1Map(){
        Map<String,String> map = new HashMap<>();
        map.put("1.1","1.1 ඔබගේ උපන් දිනය කවදාද?");
        map.put("1.2","1.2 ඔබ අයත් වන්නෙ කිනම් ජන වර්ගයටද?");
        map.put("1.3","1.3 සිංහල භාෂාවෙන් ඇති සෞඛ්‍ය පණිවිඩ තේරුම් ගැනීමට ඔබ සමත්ද?");
        map.put("1.4","1.4 ඔබ අදහන ආගම කුමක්ද?");
        map.put("1.5","1.5 ඔබ පාසල් අධයාපනය සම්පූර්ණ කළේ කිනම් ශ්\u200Dරේණියක් දක්වාද?");
        map.put("1.6","1.6 පාසල් අද්\u200Dයාපනය සම්පූර්ණ කිරිමෙන් පසු ඔබ ලබාගත් ඉහළම සුදුසුකම කුමක්ද?");
        map.put("1.7","1.7 පාසල හෝ වෙනත් අද්\u200Dයාපන ආයතනයකින් ලිංගික හා ප්\u200Dරජනන සෞඛ්\u200Dය ගැන ප්\u200Dරමාණවත් " +
                "අද්\u200Dයාපනයක් ලැබුණි යැයි ඔබට හැගෙන්නෙද?");
        map.put("1.8","1.8 ඔබ නීතියෙන් විවාහකද?");
        map.put("1.9","1.9 විවාහක නම් විවාහ වී කොපමණ කාලයක්ද?");
        return map;
    }

    public static Map<String,String> getQ2Map(){
        Map<String,String> map = new HashMap<>();
        map.put("2.1","2.1 ඔබගේ මාසික ශුද්ධවීම සාමාන්\u200Dයයෙන් ක්\u200Dරමවත්ද?");
        map.put("2.2","2.2 මාසික ශුද්ධවීම් දෙකක් අතර කාල පරතරය දළ වශයෙන් කොපමණද?");
        map.put("2.3","2.3 සාමාන්\u200Dය වශයෙන් මාසික ශුද්ධ වීම කොපමණ දින ගණනක් පවතීද?");
        map.put("2.4","2.4 සාමාන්\u200Dය මාසික ශුද්ධ වීමේදී රුධිර කැටි වහනය වීමක් සිදුවේද?");
        map.put("2.5","2.5 සාමාන්\u200Dය වශයෙන් ඔබ භාවිතා කළ සනීපාරක්ෂක පැළදුම කුමක්ද?");
        map.put("2.6","2.6 සාමාන්\u200Dය මාසික ශුද්ධ වීමේදී ඒ ඒ දිනයේදී භාවිතා කළ සනීපාරක්ෂක පැළදුම් ගණන ඒවායේ තෙත්වූ ප්\u200Dරමාණය " +
                "අනුව පහත වගුවේ සටහන් කරන්න.");
        map.put("2.7","2.7 ඔබ කෙදිනක හෝ  උපත් පාලන ක්\u200Dරමයක්    භාවිතා කලේද?");
        map.put("2.8","2.8 උපත් පාලන ක්\u200Dරම  භාවිතා කලේනම් පහත සදහන් තොරතුරු සපයන්න.");
        map.put("2.9","2.9 ඔබට මද සරුභාවයක් තිබුනාද?");
        map.put("2.10","2.10 මද සරුභාවයක් තිබුනානම් ඒ කොපමණ කාලයක්ද?");
        map.put("2.11","2.11 ඒ කාල්\u200Dය තුල දරුවෙකු බලාපොරොත්තුවෙන් අනාරක්ෂිත ලිංගික සංසර්ගයේ යෙදුනාද?");
        map.put("2.12","2.12 ඔබ කවදාක හෝ බර වැඩිවීම, අධික ලෙස මුහුනේ රෝම පැමිණීම, ගෙල පිටුපස කලු පැහැවීම, මාසික ඔසප් චක්\u200Dරය " +
                "අක්\u200Dරමවත් වීම, ආදී රෝග ලක්ශණ සහිත ඩිම්බ කෝෂ සම්බන්ද රෝගයකට / රෝග විනිශ්චයකට ලක්ව ඇතිද?");
        map.put("2.13","2.13 පිළිතුර ඔව් නම් ඔබ සතුව ලිඛිත සාක්ෂි/ වාර්තා ඇතිද?");
        return map;
    }

    public static Map<String,String> getQ3Map(){
        Map<String,String> map = new HashMap<>();
        map.put("3.1","3.1 මෙවර ගැබ්ගැනීමත් සමග සම්පූර්ණ ගර්භණිභාවයන් (පිළිසිද ගැනීම් ) කොපමණද?");
        map.put("3.2","3.2 මේ ඔබගේ පලමු ගර්භණිභාවය නොවේ නම් පසුගිය ගැබ්ගැනීම් පිළිබද විස්තර පහත සදහන් කරන්න");
        map.put("3.3","3.3 ඔබගේ ලාබාලතම දරුවාට ඔබ විසින් මවුකිරි ලබා දුන්නේද?");
        map.put("3.4","3.4 මවුකිරි නවතා දැනට කොපමණ කල්ද?");
        map.put("3.5","3.5 ඔබගේ අවසන් ගර්භණි සමයේදි ක්\u200Dරමවත්ව යකඩ පෙති ලබා ගත්තේද?");
        map.put("3.6","3.6 අවසන් ගර්භණිභාවයට පසුව යකඩ පෙති ලබා ගත්තේද?");
        map.put("3.7","3.7 ඔව්නම් ප්\u200Dරසූතියෙන් පසු කොපමණ කලක් යකඩ පෙති ලබා ගත්තෙද?");
        return map;
    }

    public static Map<String,String> getQ4Map(){
        Map<String,String> map = new HashMap<>();
        map.put("4.1","4.1 මෙවර ගැබ්ගැනීම සැලසුම් කළ එකක්ද?");
        map.put("4.2","4.2 ඔබ දරුවෙකු පිලිසිද ගැනීමට පෙර පවත්වන පූර්ව ගර්භණි සැසි සදහා සහභාගි වුනේද?");
        map.put("4.3","4.3 පූරව ගර්භණ සැසියේදි ඔබව රක්තහීනතාවය සදහා පරීක්ෂා කළාද?");
        map.put("4.4","4.4 පූරව ගර්භණ සැසියේදි හදවත් රෝග සදහා ඔබව  පරීක්ෂා කළාද?");
        map.put("4.5","4.5 ඔබ මෙම පිළිසිද ගැනීමට පෙර ෆෝලික් අම්ල පෙති ලබා ගත්තේද?");
        map.put("4.6","4.6 ඔව් නම් පිළිසිද ගැනීමට පෙර අවසාන මාස තුන ඇතුලත ෆෝලික් අම්ල පෙති ලබා ගත්තේද?");
        map.put("4.7","4.7 අවසන් වරට ඔසප් වූ  දිනය කවදාද?");
        map.put("4.8","4.8 මෙවර ගර්භණි තත්වය තහවුරු කර ගත්තෙ කෙසේද?");
        map.put("4.9","4.9 දරු ප්\u200Dරසූතිය සදහා ඔබ වඩාත් කැමති ක්\u200Dරමය කුමක්ද?");
        map.put("4.10","4.10 දරු ප්\u200Dරසූතිය සදහා ඔබ කැමති ස්ථානය කුමක්ද?");
        map.put("4.11","4.11 ඔබ දැනට ෆෝලික් අම්ල පෙති භාවිතා කරන්නේද?");
        map.put("4.12","4.12 ගර්භණිබව දැන ගැනීමෙන පසු කොපමණ සති ගනනක් ෆෝලික් අම්ල පෙති භාවිතා කරාද?");
        return map;
    }

    public static Map<String,String> getQ5Map(){
        Map<String,String> map = new HashMap<>();
        map.put("5.1","5.1 ගර්භණි සමයේ ඔබ පහත රෝග අත්වින්දේද?");
        map.put("5.2","5.2 පපුවේ වේදනාවක් තිබේනම් එය පහත කිනම් ප්\u200Dරකාශයෙන් වඩා හොදින් විස්තර වේද?");
        map.put("5.3","5.3 ඔබට හුස්ම ගැනීමේ අපහසුතාවක් ඇතිනම් පහත කවර විස්තරයකින් ඔබගේ වර්තමාන ක්\u200Dරියාකාරීත්වය වඩා හොදින් විස්තර කරයිද?");
        return map;
    }

    public static Map<String,String> getQ6Map(){
        Map<String,String> map = new HashMap<>();
        map.put("6.1","6.1 ඔබට කිනම් අවස්ථාවකදි පහත තත්වයන් පෙන්නුම් ක\u200Dර තිබේද?");
        map.put("6.2","6.2 ඔබගේ කායික රෝග ඉතිහාසය පිළිබද විස්තර සදහන් කරන්න");
        map.put("6.3","6.3 මීට පෙර යම් අවස්ථාවකදි රක්තහීනතාවය ඇති බවට රෝග විනිශ්චය කර ඇතිද?");
        map.put("6.4","6.4 මීට පෙර රක්තහීනතව තිබුණි නම් ල්බා ගත් ප්\u200Dරතිකාර මොනවාද?");
        map.put("6.5","6.5 ඔබට යකඩ අඩංගු ප්\u200Dරතිකාර ක්\u200Dරම ලබා දී ඇත්නම් කොපමණ කලක් එම ප්\u200Dරතිකාර ලබා ගත්තාද?");
        map.put("6.6","6.6 ඔබට රුධිර පාරවිලයනය ඇත්නම් අවසන් වරට පාරවිලයනය කලේ කොපමණ කලකට පෙරද?");
        map.put("6.7","6.7 ඔබට රක්තහීනතාව සුවවු බවට පරීක්ශණ වාර්තා කිසිවක් තිබේද?");
        map.put("6.8","6.8 ඔබව තැලිසීමියාව සදහා පරීක්ෂා කර තිබේද?");
        map.put("6.9","6.9 එසේ නම් ප්\u200Dරතිපල මොනවාද?");
        map.put("6.10","6.10 පසුගිය මාස 6 කාලය තුල මළපහ සමග රුධිරය පිටවීමක් නිරීක්ෂණය කලේද?");
        map.put("6.11","6.11 පසුගිය මාස 6 කාලය තුල තාර පැහැයෙන් මළපහ පිටවීමක් නිරීක්ෂණය කලේද?");
        map.put("6.12","6.12පසුගිය මාස 6 කාලය තුල පණු බෙහෙත් ලබා ගත්තේද?");
        return map;
    }

    /*public static Map<String,String> getQ7Map(){
        Map<String,String> map = new HashMap<>();
        map.put("7.1","7.1 ඔබ ඔබේ මානසික සුවටතා වර්ධනය කරන කටයුතුවල නියෙලෙනවාද?");
        map.put("7.2","7.2 ඔබ නිරත වන මානසික සුවටතා වර්ධනය කරන කටයුතුවල විස්තර සදහන් කරන්න.");
        map.put("7.3","7.3 ඔබගේ ගර්භණීබව නිසා ඔබ කෙදිනක හෝ මොන යම් ආකාරයේ වෙනස්කමකට / විවේචනයකට ලක් වී ඇතිද?");
        return map;
    }*/

    public static Map<String,String> getQ7Map(){
        Map<String,String> map = new HashMap<>();
        map.put("7.1","7.1 ඔබගේ මව පියා සහෝදර සහෝදරියන් පහත රෝග වලින් පෙලෙන්නේද?");
        return map;
    }

    public static Map<String,String> getQ8Map(){
        Map<String,String> map = new HashMap<>();
        map.put("8.1","8.1 නිවසේ පදිංචි සාමාජිකයන් ගණන");
        map.put("8.2","8.2 පවුලේ ගෘහමුලිකයා කවුද? (ඔබට ඇති නෑකම සඳහන් කරන්න)");
        map.put("8.3","8.3 ඔබ සෞඛ්\u200Dය සේවා ලබා ගැනීම සඳහා වඩාත්ම කැමති මින් කුමකටද?");
        map.put("8.4","8.4 නිවසේ සාමාජිකයන්ගේ තොරතුරු");
        map.put("8.5","8.5 නිවාස සහ වත්කම් පිළිබඳ අයිතිය");
        return map;
    }

    public static Map<String,String> getQ9Map(){
        Map<String,String> map = new HashMap<>();
        map.put("9.1","9.1 ආසන්නතම නගරයට ලඟා වීමට");
        map.put("9.2","9.2 ආසන්නතම රජයේ රෝහලට ලඟා වීමට");
        map.put("9.3","9.3 ආසන්නතම පෞද්ගලික වෛද්\u200Dය මධ්\u200Dයස්ථානයට ලඟා වීමට ");
        map.put("9.4","9.4 ක්ෂේත්\u200Dර කාර්යාලයට (පවුල් සෞඛ්\u200Dය නිලධාරී)");
        map.put("9.5","9.5 ප්\u200Dරවාහන පහසුකම්වල තත්වය");
        map.put("9.5.1","9.5.1 ඔබ පොදු ප්\u200Dරවාහන සේවා භාවිතා කරන්නේද?");
        map.put("9.5.2","9.5.2 CTB බස්");
        map.put("9.5.3","9.5.3 පෞද්ගලික බස්");
        map.put("9.5.4","9.5.4 කුලී ත්\u200Dරීරෝද රථ");
        return map;
    }

    public static Map<String,String> getQ10Map(){
        Map<String,String> map = new HashMap<>();
        map.put("10.1","1 ඖෂධ ඉතිහාසය පිලිබද තොරතුරු");
        return map;
    }

    public static Map<String,String> getQ11Map(){
        Map<String,String> map = new HashMap<>();
        map.put("11.1","11.1 Examination");
        map.put("11.2","11.2 Precordial Examination  ");
        map.put("11.3","11.3 Auscultation");
        return map;
    }

    public static Map<String,String> getQ12Map(){
        Map<String,String> map = new HashMap<>();
        map.put("12","කිසිවක් නැත");
        map.put("12.1","12.1 Chest pain suggestive of sinister cardiac pathology (Ischemia, Pulmonary Embolism, Aortic" +
                " dissection or valve related pathology) ");
        map.put("12.2","12.2 Difficulty in breathing even at rest/mild exertion (non-asthmatic)");
        map.put("12.3","12.3 Palpitation");
        map.put("12.4","12.4 Syncope/pre-syncope");
        map.put("12.5","12.5 Orthopnoea");
        map.put("12.6","12.6 Paroxysmal nocturnal dyspnoea");
        map.put("12.7","12.7 Suspected congenital cardiac anomaly of previous newborn");
        map.put("12.8","12.8 Hypertension chronic/ hypertensive disorders in pregnancy");
        map.put("12.9","12.9 Dyslipidemia");
        map.put("12.10","12.10 Rheumatic fever");
        map.put("12.11","12.11 Any heart disease");
        map.put("12.12","12.12 Anaemia");
        map.put("12.13","12.13 Stroke");
        map.put("12.14","12.14 DM");
        return map;
    }

    //Other fields

    public static Map<String,String> getQ1Fields(){
        Map<String,String> map = new HashMap<>();
        map.put("1","මව");
        map.put("2","පියා");
        return map;
    }

    public static Map<String,String> getQ2Fields(){
        Map<String,String> map = new HashMap<>();
        map.put("2.61","අදාල කාණ්ඩයට   අනුව සනීපාරක්ෂක   පැළදුම් ගණන");
        map.put("2.62","සනීපාරක්ෂක පැළදුමේ  තෙත්වූ ප්\u200Dරමාණය ");
        map.put("2.63","පැළදුම් ගණන");
        map.put("2.64","දිනය");
        map.put("2.65","දින 8කට  වැඩ්");
        map.put("2.8.1","ක්\u200Dරමය");
        map.put("2.8.2","භාවිතා කළ කාලය අවු/ මාස");
        map.put("2.8.3","අතුරු  ආබාධය");
        map.put("2.8.4","නැවැත්වීමට හේතු");
        return map;
    }

    public static Map<String,String> getQ32Fields(){
        Map<String,String> map = new HashMap<>();
        map.put("3.21","ගර්භණිභාවය");
        map.put("3.22","ගැබ්ගන්නාවිට වයස");
        map.put("3.23","ගර්භණි ප්\u200Dරතිපලය");
        map.put("3.24","ගර්භණි සංකූලතා");
        map.put("3.25","ප්\u200Dරසූතිය සිදුකරන විට හෝ ගර්භය ඉවත් කරනවිට සති කීයද?");
        map.put("3.26","ප්\u200Dරසූතිය සිදුවූ ආකාරය");
        map.put("3.27","සජීවී දරු උපතක් නම් බර");
        map.put("3.28","ළදරුවාගේ සංකූලතා තිබුනේනම්");
        map.put("3.29","පසු ප්\u200Dරසව සංකූලතා තිබුනේනම් ඒ මොනවාද?");
        return map;
    }
    public static Map<String,String> getQ5Fields(){
        Map<String,String> map = new HashMap<>();
        map.put("5.1","කිසිවක් නැත");
        map.put("5.11","දරුවා පිළිසිද ගැනිමට මාස 03 පෙර");
        map.put("5.12","ඔව්/නැත");
        map.put("5.13","වාර ගණන");
        map.put("5.14","වෙහෙස වීමකදි උත්සන්න වේද?");
        map.put("5.15","ඒ සදහා උපදෙස් ලබා ගත්තෙද?");
        map.put("5.16","පිලිසිද ගැනිමෙන පසු");
        map.put("a","a.ඔක්කාරය සහ වමනය");
        map.put("b","b.(පපුවේ වේදනාව/ කැක්කුම අත දිගේ බෙල්ල වෙත ඇදෙන, දහඩිය දැමීමක් සිදුවන)");
        map.put("c","c.පපුවේ වේදනාව");
        map.put("d","d.හුස්ම ගැනීමේ අපහසුතාවය");
        map.put("e","e.හතිය");
        map.put("f","f.පපුවේ ගැස්ම");
        map.put("g","g.ක්ලාන්ත ගතිය");
        map.put("h","h විවේකීව සිටීමේදී වෙහෙසක් දැනීම");
        map.put("i","i.වලලුකර ආසන්නයේ කකුල ඉදිමීම");
        map.put("j","j.හාන්සිව සිටිනවිට හුස්ම ගැනීමේ අපහසුකම");
        map.put("k","k.හුස්ම ගැනීමේ අපහසුකම නිසා නින්දෙන් අවදි වීම");
        return map;
    }

    public static Map<String,String> getQ6Fields(){
        Map<String,String> map = new HashMap<>();
        map.put("6.1","කිසිවක් නැත");
        map.put("6.11","a. රුධිර පීඩනය ඉහල යාම");
        map.put("6.12","b. රුධිර කොලෙස්ටරෝල් ප්\u200Dරමාණය  ඉහල යාම");
        map.put("6.13","c. රුධිර සීනි මට්ටම ඉහල යාම");
        map.put("6.14","d. තයිරඔක්සීන් මට්ටම අඩු වීම");
        map.put("a","a.\tදියවැඩියාව");
        map.put("b","b.\tඅධිරුධිර පීඩනය");
        map.put("c","c.\tDyslipidemia");
        map.put("d","d.\tතයිරොයිඩ් ග්\u200Dරන්තය ආශිත රෝග");
        map.put("e","e.\tඅක්මාව ආශිත රෝග");
        map.put("f","f.\tවකුගඩු රෝග");
        map.put("g","g.\tඇදුම/ හතිය");
        map.put("h","h.\tස්වයං ප්\u200Dරතිශක්තිකරණ රෝග තත්වයන්");
        map.put("i","i.\tපරිවුර්තිය රෝග තත්වයන්( Metabolic syndrome)");
        map.put("j","j.\tරුමැටික් උණ");
        map.put("k","k.\tරුමැටික් හදවත් රෝග");
        map.put("l","l.\tG6PD deficiency");
        map.put("m","m.\tහෘද ආබාධ");
        map.put("n","n.\tමොලයේ රුධිර කැටියක් සිරවීම");
        map.put("o","o.\tසංජජනන හදවත් රෝග");
        map.put("p","p.\tහෘද ස්පන්ධනයේ වෙනස්කම් ");
        map.put("q","q.\tඅනෙකුත් හෘද රෝග");
        map.put("r","r.\tවිශාදය");
        map.put("s","s.\tඅනෙකුත් මානසික රෝග");
        map.put("t","t.\tPCOD");
        map.put("u","u.\tවෙනත් රෝගී තත්වයන්");
        map.put("6.21","ඔබට මෙම රෝගී තත්වය ඇති බවට තහවුරු කර ඇතිද?");
        map.put("6.22","එම රෝග විනිශ්චය සම්බන්ධව කිනම් හෝ ලිකිත වාර්තා තිබේද?");
        map.put("6.23","රෝග විනිශ්චය සිදු කළ කාලය");
        map.put("6.24","මෙම රෝග සදහා දැනට ප්\u200Dරතිකාර ලබා ගන්නේද?");
        map.put("6.25","රෝගය සදහා ඔබ් අප්\u200Dරතිකාර ගන්නේ කුමන අංශයකින්ද?");
        map.put("years","අවුරුදු");
        map.put("month","මාස");
        return map;
    }

    public static Map<String,String> getQ11Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("11.1","කිසිවක් නැත");
        map.put("7.11","ක්\u200Dරියාකාරකම");
        map.put("7.31","ස්ථානය");
        map.put("7.32","a.නිවසේදී");
        map.put("7.33","b.සමාජයේදි");
        map.put("7.34","c.සේවා ස්ථානය තුළ");
        return map;
    }

    public static Map<String,String> getQ7Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("7.1","කිසිවක් නැත");
        map.put("a","a. දියවැඩියාව");
        map.put("b","b. ආගාතය / අංශ භාගය");
        map.put("c","c. අධිරුධිර පීඩනය");
        map.put("d","d. අක්මාව ආශිත රෝග");
        map.put("e","e. කොලෙස්ටරෝල්");
        map.put("f","f. අනෙකුත් හදවත් රෝග තත්වයන්");
        map.put("g","g. \tහෘද ආබාධ");
        map.put("h","h. මානසික රෝග තත්වයන්");
        map.put("i","i. වකුගඩු ආශ්\u200Dරිත රෝග");
        return map;
    }

    public static Map<String,String> getQ8Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("8.4.1","සාමාජිකයා");
        map.put("8.4.2","ඔබට ඇති සම්බන්දතාවය");
        map.put("8.4.3","වයස");
        map.put("8.5.1","8.5.1 ඔබ වාසයකරන  නිවස ඉහත වගුවේ කවරකුට හෝ අයිති නිවසක්ද?");
        map.put("8.5.2","8.5.2 ඔබ නිවසේ කාමර කොපමණ සංඛ්\u200Dයාවක්  තිබේද (නාන කාමර හා කුස්සිය හැර)");
        map.put("8.5.3","8.5.3 ඔබ නිදන කාමරය තව කී දෙනෙක් භාවිතා කරනවද?");
        map.put("8.5.4","8.5.4 ඔබ නිවැසියන් පානය සඳහා ජලය ලබා ගන්නා ජල මුලාශ්\u200Dරය කුමක්ද?");
        map.put("8.5.5","8.5.5 ඔබ නිවැසියන් ආහාර පිසීමට භාවිතා කරනු ලබන ප්\u200Dරධාන ඉන්ධන වර්ගය කුමක්ද?");
        map.put("8.5.6","8.5.6 ඔබ භාවිතයට ගන්නා වැසිකිලිය කුමන ආකාරයක ද?");
        map.put("8.5.7","8.5.7 ඔබ නිවසේ බිත්ති ඉදිකිරීමට යොදා ගත් ප්\u200Dරධාන අමුද්\u200Dරව්\u200Dය ?");
        map.put("8.5.8","8.5.8 වහල සෙවිලි කිරීමට යොදාගත් ද්\u200Dරව්\u200Dය?");
        map.put("8.5.9","8.5.9 නිවසේ පොළව සැකසීමට යොදාගත්  අමුද්\u200Dරව්\u200Dය?");
        map.put("8.5.10","8.5.10 ඔබ නිවසේ භාවිතා කරන ප්\u200Dරධාන ආලෝක ප්\u200Dරභවය?");
        map.put("8.5.11","8.5.11 ජංගම දුරකථන");
        map.put("8.5.12","8.5.12 ස්ථාවර දුරකථනය");
        map.put("8.5.13","8.5.13 මෝටර් කාරය");
        map.put("8.5.14","8.5.14 වෑන්");
        map.put("8.5.15","8.5.15 ත්\u200Dරී වීල් රථය");
        map.put("8.5.16","8.5.16 මෝටර් බයික්");
        map.put("8.5.17","8.5.17 වෙනත් vehicles");
        map.put("8.5.middle","ඔබ නිවසේ මෙහි සඳහන් උපකරණ තිබේද?");
        return map;
    }

    public static Map<String,String> getQ9Fields(){
        Map<String,String> map = new HashMap<>();
        map.put("9","කාලය  (පැය/විනාඩි)");
        return map;
    }

    public static Map<String,String> getQ10Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("a","පෙති කරල්");
        map.put("b","ඔව්/නැත");
        map.put("c","දැනට භාවිතා කරයිද?");
        map.put("d","ඖෂධ  භාවිතය ආරම්භ කල දිනය (අවුරුදු/මාස)");
        map.put("e","ඖෂධ  භාවිතය අවසන් කල දිනය (අවුරුදු/මාස)");
        map.put("9.1","කිසිවක් නැත");
        return map;
    }

    public static Map<String,String> getQ111Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("a","a. General");
        map.put("b","b. Icterus");
        map.put("c","c. Pallor");
        map.put("d","d. Plethora");
        map.put("e","e. Central cyanosis");
        map.put("f","f. Xanthomata / Xanthalesma");
        map.put("g","g. Angular stomatitis ");
        map.put("h","h. Glossitis");
        map.put("i","i .Evidence of dysmorphism");
        map.put("j","j. Clubbing");
        map.put("k","k. Ankle oedema");
        map.put("l","l. Acanthosis nigricans ");
        return map;
    }

    public static Map<String,String> getQ112Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("a","a. Neck vein engorgement ");
        map.put("b","b. Apex deviated");
        map.put("c","c. Left para sternal heave");
        map.put("d","d. Thrills");
        map.put("e","e. Carotid bruit");
        map.put("f","f. Pulse :- Rate");
        map.put("g","g. Irregular rhythm");
        map.put("h","h. Blood pressure (in mmHg)");
        return map;
    }

    public static Map<String,String> getQ113Fields() {
        Map<String, String> map = new HashMap<>();
        map.put("a","a. Murmur");
        map.put("b","b. Loud P2");
        map.put("c","c. Lung bases fine crepts+");
        map.put("middleHeader","Anthropometric measurements");
        map.put("d","d. Height (in centimeters)");
        map.put("e","e. Weight (in Kilograms)");
        map.put("f","f. Waist circumference");
        map.put("g","g. Hip circumference");
        return map;
    }

    public static Map<String,String> getMotherData(){
        Map<String, String> map = new HashMap<>();
        map.put("0","පසුබිම් දත්ත");
        map.put("1","මවගෙ නම");
        map.put("2","වයස");
        map.put("3","දිනය");
        map.put("5","ජා. හැ. පත් අංකය");
        map.put("4","සමීක්ෂකවරයගේ අංකය");
        map.put("6","ගර්භණී මවුවරුන්ගේ ලේඛනයේ ලියපදිංචි අංකය");
        map.put("7","ආරම්භක වේලාව");
        map.put("8","සෞ . වෛ.නි කොට්ඨාශය");
        map.put("9","ප.සෞ.සේ.නි කොට්ඨාශය");
        map.put("10",".ග්\u200Dරා.සේ.වසම");
        map.put("11","පූර්ව ප්\u200Dරසව සායනය");
        map.put("12","ප්\u200Dරා.ලේ කොට්ඨාශය");
        map.put("13","මවගෙ අනු අංකය");
        return map;
    }
}
