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

    public static Map<Integer,List<String>> getFirstFollowUpLongAAnswerList(){
        Map<Integer,List<String>> map = new HashMap<>();
        map.put(8,Arrays.asList("1.ලූපය(IUCD)","2.උපත් පාලන පෙති","3.Depo එන්නත්","4.කරල් දැමීම (Jadelle)","5.වන්ධ්\u200Dයාකරණය(LRT)","6.උපත් පාලන කොපු(Condom"));
        map.put(11,Arrays.asList("1. මම යකඩ අඩංගු ප\u200D්\u200Dරතිකාර භාවිතා කිරීමේ අවශ්\u200Dයතාවය පිළිබඳව දැන සිටියේ නැත.",
                "2. මට යකඩ ප\u200D්\u200Dරතිකාර ලබාදී හෝ ගැනීමට යැයි කියා නැත.","3. මා හට යකඩ අඩංගු ප\u200D්\u200Dරතිකාර අවශ්\u200Dය යැයි කියා මා සිතන්නේ නැත."
        ,"4. යකඩ පෙති බොනවිට මා හට පීඩාකාරි අතුරු ආබාධ ඇතිවේ.","5. මා හට යකඩ අඩංගු ප\u200D්\u200Dරතිකාර පිටතින් මිලදී ගැනීමට සිදුවී ඇති අතර ඒ සඳහා ප\u200D්\u200Dරමාණවත් මුදල් " +
                        "මා හට නොමැත.","6. යකඩ අඩංගු ප\u200D්\u200Dරතිකාර ගැනීමට අමතක වුණි.","7. වෙනත්.(සඳහන් කරන්න.)"));
        map.put(12,Arrays.asList("1. සායනයෙන් / Midwife මිස්ගෙන් / MOH කාර්යාලයෙන්" ,"2. ෆාමසියෙන් මිලදී ගනී."));
        map.put(13,Arrays.asList("1. Midwife මිස්ගෙන් හෝ සායනයෙන් නොලැබුණු නිසා" ,
                "2. සායනයෙන් ලැබුණු පෙති පාවිච්චි කිරීමේද’, පීඩාකාරී අතුරු ආබාධ ඇති වූ නිසා." , "3. මට යකඩ පෙති පිටතින් ලබාගැනීමට ලියාදී තිබු නිසා." ,
                "4. සායනයෙන් දෙන පෙති වලට වඩා පිටතින් මිලදීගන්නා පෙති ප\u200D්\u200Dරතිඵලදායක බව මට සිතෙන නිසා." , "5. වෙනත් (සඳහන් කරන්න.)"));
        map.put(16,Arrays.asList("1. පෙති එකයි." ,"2. පෙති දෙකයි." ,"3. පෙති තුනයි." ,"4. සිරප්"));
        map.put(18,Arrays.asList("1. දෙකම එකවර","2. පෙති දෙක වෙන වෙනම අවස්ථාවන් දෙකකදී","3. ඊයේ දිනයේදී දෙකම හෝ එකක් හෝ ලබාගත්තේ නැත."));
        map.put(19,Arrays.asList("01. කෑමෙන් පැය 02 ක් ඇතුළත","02. කෑමට පැය 02 කට පෙර / කෑමෙන් පැය 02 කට පසු","03. ඊයේ දිනයේදී යකඩ පෙති බිවුවේ නැත."));
        map.put(20,Arrays.asList("01. යකඩ පෙති සමග", "02. යකඩ පෙති ලබානොගන්නා වේලාවක (පැයකට පෙර හෝ පැයකට පසුව)", "03. කැල්සියම් / යකඩ පෙති බිව්වේ නැත."));
        map.put(22,Arrays.asList("1. අඳුරු කළ බෝතලයක " , "2. විනිවිද පෙනෙන බෝතලයක ", "3. කොළයක හෝ කවරයක ඔතා ", "4. තදින් වැසෙන මුඩියක් ඇත. ", "5. තදින් වැසෙන මුඩියක් නැත", "6. වෙනත්"));
        map.put(24,Arrays.asList("1. වමනය / ඔක්කාරය" ,"2. මලබද්ධය", "3. හිසරදය", "4. බඬේ කැක්කුම / බඩදැවිල්ල / පපුව දැවිල්ල", "5. කටට අමුතු රසයක් දැනීම", "6. වෙනත්"));
        map.put(26,Arrays.asList("a. බිත්තර", "b. කුකුල් මස්", "c. හරක් මස් / ඌරු මස් / වෙනත් මස් වර්ග", "d. මාළු (වැව්මාළු / මුහුදු මාළු)", "e. කරවල", "f. හාල්මැස්සෝ",
                "g. ටින්කල මාළු", "h. කිරි (මෝල්ට් අඩංගු නැති)", "i. බටර්", "j. යෝගට් / මුදවපු කිරි", "k. සෝයාමීට්", "l. පලා වර්ග"));
        return map;
    }

    public static Map<Integer,List<String>> getFirstFollowUpTab2LongAAnswerList() {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1,Arrays.asList("1 මසකට වරක්", "2 මසකට 2-4 වරක්", "3 සතියකට කිහිපවතාවක්", "4 දිනපතාම"));
        map.put(2,Arrays.asList("a. සාමාන්\u200Dය කායික කි\u200D්\u200Dරයාකාරකම් වලදී (ඇවිදීම, පඩිනැගීම* වෙහෙසක්, හුස්ම ගැනීමේ අපහසුතාවයක් හෝ පපුවේ ගැස්මක් ඇති නොවේ.",
                "b. පපුවේ වෙහෙස නිසා සාමාන්\u200Dය කායික කි\u200D්\u200Dරයාකාරකම් මදක් සීමාවී ඇත. (වේගයෙන් ඇවිදීම, පඩි නැගීම, කෑමෙන් අනතුරුව ඇවීදීම හෝ පඩිනැගීම, හැ`ගීම්බර අවස්ථාවකදී, සීත කාලගුණයකදී හෝ සුළං කාලවලදී, නින්දෙන් අවදිවී පළමු පැය කිහිපයේදී)",
                "c. සාමාන්\u200Dය කි\u200D්\u200Dරයාකාරකම් පපුවේ වෙහෙස නිසා සැලකිය යුතු ලෙස සීමාවී ඇත. (පියවර 02 ක් ඇවිදීම, පඩියක් ඉහල නැගීම.)",
                "d. විවේකීව සිටින විට පපුවේ වෙහෙස පවතී."));
        map.put(3,Arrays.asList("a. මාගේ සාමාන්\u200Dය දෛනික කි\u200D්\u200Dරයාකාරකම් වලට හුස්මගැනීමේ අපහසුව බාධාවක් නොවේ.",
                "b. විවේකීව සිටින විට පහසුය, නමුත් සාමාන්\u200Dය කායික කි\u200D්\u200Dරයාකාරකම් කරගැනීමේදී අපහසුවක් හෝ පපුවේ ගැස්මක් ඇතිවේ.",
                "c. ඉතා සුළු කායික කි\u200D්\u200Dරයාකාරකම් පවා කරගැනීමට නොහැක.",
                "d. විවේකීව සිටින විටදී ද හුස්මගැනීමට අපහසුය."));
        map.put(6,Arrays.asList("1. නැත ","2. ඔව්, කලාතුරකින්", "3. ඔව්, බොහෝවිට", "4. ඔව්, සෑමවිටම"));
        map.put(7,Arrays.asList("1. නැත ","2. ඔව්, කලාතුරකින්", "3. ඔව්, බොහෝවිට", "4. ඔව්, සෑමවිටම"));
        map.put(8,Arrays.asList("1. නැත ","2. ඔව්, කලාතුරකින්", "3. ඔව්, බොහෝවිට", "4. ඔව්, සෑමවිටම"));
        map.put(9,Arrays.asList("1. නැත"," 2. ඔව්, එකවතාවක්", "3. ඔව්, කිහිපවතාවක්"));
        return map;
    }

    public static Map<Integer,List<String>> getFirstFollowUpTab4LongAAnswerList() {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1,Arrays.asList("1 Activities not limited – grade 1", "2 Mild limitation of physical activities – grade 2",
                "3 Moderate limitation of physical activities – grade 3", "Symptoms + at rest – grade 4"));
        map.put(2,Arrays.asList("1 No SOB at rest –  grade 1","2 No SOB at rest,  but occurs with moderate activities – grade 2 ",
                "3 SOB with simple daily activities – grade 3","4 SOB at rest – grade 4"));
        map.put(3,Arrays.asList("1. Dietary control","2. Oral hypoglycemic","3. Insulin","4. both oral and insulin"));
        map.put(4,Arrays.asList("1. Viral hepatitis/drug induced/dengue/leptospirosis","2. obstetric cholestasis",
                "3. diagnosed platelet disorders/bleeding disorders","4. other "));
        return map;
    }

    public static Map<String,List<String>> getSocialCapitalAAnswerList() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1.1", Arrays.asList("1. දිනපතාම","2. සතියට දෙතුන් වරක්", "3. සතියකට වරක්", "4. මසකට වරක්", "5. මාස කිහිපයකට වරක්","6. ස්වාමියා මා සමග වාසය නොකරයි"));
        map.put("1.2",Arrays.asList("1. සැම විටම","2. බොහෝ විට","3. සමහර විට","4. කලාතුරකින්","5. කිසිසේත්ම නැත","6. තනිව සිටින නිසා අදාළ නැත"));
        map.put("2.5",Arrays.asList("1. දැඩි උද්යෝගයක් දක්වයි","2. උද්යෝගයක් දක්වයි","3. සුළු උද්යෝගයක් දක්වයි","4. අවධානයක් නොදක්වයි","5. ඔවුන්ට එය කරදරයක්/ බාධාවක් ලෙස සිතයි","6. තනිව සිටින නිසා අදාළ නැත"));
        map.put("3",Arrays.asList("1. සෑම විටම","2. බොහෝවිට","3. සමහර විට","4. කලාතුරකින්","5. කිසිදා නැත"));
        return map;
    }

    public static Map<String,List<String>> getSocialCapitalBAnswerList() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1.1", Arrays.asList("1. දිනපතාම-සතියකට කිහිප වරක්","2. සතියකට වතාවක්","3. මසකට වතාවක්","4. ඉතා කලාතුරකින්","5. කිසිසේත්ම නැත"));
        map.put("3",Arrays.asList("1. සෑම විටම","2. බොහෝවිට","3. සමහර විට","4. කලාතුරකින්","5. කිසිදා නැත"));
        map.put("6",Arrays.asList("1. දැඩි විශ්වාසයකි", "2. සාමාන්‍ය තරමේ විශ්වාසයකි", "3. සුළු විශ්වාසයකි", "4. කිසිසේත් විශ්වාස නැත", "5. නිශ්චිතව කිව නොහැක"));
        map.put("7",Arrays.asList("1. ඔව්", "2. නැත", "3. එකකට වැඩි"));
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

    public static Map<Integer,String> getFirstFollowUpQ1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"1.1 මෙම ගර්භණී කාලය තුළ ඔබ කිසියම් කායික හෝ ගර්භණී බව ආශ\u200D්\u200Dරිත රෝගී තත්ත්වයක් සඳහා රෝහල් බාහිර රෝගී අංශයෙන් හෝ පුද්ගලික අංශයෙන් වෛද්\u200Dය උපදෙස් ලබාගත්තේද?");
        map.put(2,"1.2 ඔව් නම් ඒ බව තහවුරු කරන වෛද්\u200Dය වාර්තා හෝ ලිඛිත සාක්ෂි තිබේද?");
        map.put(3,"1.3 මෙම පිළිසිඳ ගැනීමෙන් පසු ඔබ පහත කිනම් රෝගී තත්ත්ව සඳහා වෛද්\u200Dයවරයෙකු හමුවී ප\u200D්\u200Dරතිකාර ලබාගත්තේද? ඒ සඳහා වෛද්\u200Dයවරයෙකු හමු වු වාර ගණන කොපමණද?");
        map.put(4,"1.4 මෙම ගර්භණී කාලය තුළ ඔබ කෙදිනක හෝ රෝහල්ගත වී තිබේද?");
        map.put(5,"1.5 ඔව් නම් ඒ බව තහවුරු කරන වෛද්\u200Dය වාර්තා / ලිඛිත සාක්ෂි තිබේද?");
        map.put(6,"1.6 මෙම ගර්භණී කාලය තුළ ඔබේ ගර්භය ආශ\u200D්\u200Dරිත ස්කෑන් පරීක්ෂණ සිදුකල වාර ගණන කීයද?");
        map.put(7,"1.7 ඔබ මෙවර පිළිසිඳ ගත්තේ කිසියම් (නූතන) උපත් පාලන ක\u200D්\u200Dරමයක් අනුගමනය කරමින් සිටින අතරතුර දී ද?");
        map.put(8,"1.8 ඔව් නම්, එම උපත් පාලන ක\u200D්\u200Dරමය කුමක්ද?");
        map.put(9,"1.9 ඔබ දන්නා පරිදි ඔබට මෙම ගර්භණී කාලය තුළ රක්තහීනතාවය (හිමොග්ලොබින් අඩු බව හෝ ලේ මදිකම) තිබෙනවාද?");
        map.put(10,"1.10 ඔබ දැනට යකඩ පෙති හෝ වෙනත් යකඩ අඩංගු ප\u200D්\u200Dරතිකාර කිසිවක් පාවිච්චි කරනවාද?");
        map.put(11,"1.11 නැතිනම්, ඔබ යකඩ අඩංගු ප\u200D්\u200Dරතිකාර ලබානොගන්නේ ඇයි? (කරුණාකර අදාළ කේතය සඳහන් කරන්න.)");
        map.put(12,"1.12 ඔබ සාමාන්\u200Dයයෙන් යකඩ අඩංගු ප\u200D්\u200Dරතිකාර ලබාගන්නේ කොහෙන්ද? (පිළිතුරු එකකට වඩා ලකුණු කිරීමට විය හැක.)");
        map.put(13,"1.13 ඔබ යකඩ අඩංගු ප\u200D්\u200Dරතිකාර පිටතින් මිලදී ගන්නේ ඇයි?");
        map.put(14,"1.14 ඔබට දැනට පවතින කිසියම් රෝගී තත්ත්වයක් උදෙසා ලබාගන්නා ප\u200D්\u200Dරතිකාර සහ සායනයෙන් ලබාදෙන විටමින් හා පෝෂක අතිරේක වලට අමතරව වෙනත් කිසියම් විටමින් හෝ පෝෂක අතිරේක ඔබ ලබාගන්නේ ද?");
        map.put(15,"1.15 ඔබ යකඩ පෙති පාවිච්චි කිරීමට පටන් ගත්තේ ගර්භයට සති කීයක් වනවිට ද?");
        map.put(16,"1.16 ඔබ දිනකට යකඩ අඩංගු ප\u200D්\u200Dරතිකාර මාත\u200D්\u200Dරා කීයක් භාවිතා කරන්නේ ද?");
        map.put(17,"1.17 ඔබ යකඩ පෙති දෙකක් ලබාගන්නේ නම් එසේ කරන ලෙස උපදෙස් ලැබුණේ ගර්භයට සති කීයක් වන විටද?");
        map.put(18,"1.18 ඔබ පෙති 02 ක්/ මාත\u200D්\u200Dරා 02 ක් ලබාගන්නා අයෙක් නම්, ඊයේ දිනයේදී ඒවා ලබාගත්තේ කෙසේද?");
        map.put(19,"1.19 ඔබ ඊයේ දිනයේදී යකඩ පෙති පාවිච්චි කළාද? ඔව් නම්, ඊයේ දිනයේදී යකඩ පෙති පාවිච්චි කළේ කෙසේද?");
        map.put(20,"1.20 ඔබ ඊයේ දිනයේදී කැල්සියම් පෙති බිව්වාද? ඔව් නම්, ඔබ ඊයේ කැල්සියම් පෙති පාවිච්චි කළේ කෙසේද?");
        map.put(21,"1.21 ඊයේ දිනයේදී ඔබගේ පෝෂණ අතිරේක හා ආහාර වේල් ලබාගත්තේ ඔබ වෙනදා ගන්නා සුපුරුදු ආකාරයටම ද?");
        map.put(22,"1.22 ඔබ යකඩ පෙති ගබඩා කර තබන්නේ කෙසේද? (අදාළ සියල්ල තෝරන්න)");
        map.put(23,"1.23 පසුගිය සතිය තුළ ඔබට යකඩ අඩංගු ප\u200D්\u200Dරතිකාර ලබාගැනීමට අමතක වු හෝ නොහැකි වු දවස් ගණන දළ වශයෙන් කීයද?");
        map.put(24,"1.24 ඔබ යකඩ අඩංගු ප\u200D්\u200Dරතිකාර ලබාගන්නා විට පහත සඳහන් පීඩාකාරී අතුරු ආබාධ අත්විඳීමට සිදු වුවාද?");
        map.put(25,"1.25 ඔබ පසුගිය දින දෙක තුළ මෙම වේල් සඳහා ලබාගත් ප\u200D්\u200Dරධාන ආහාරය කුමක්ද? (කරුණාකර උදාහරණ බලන්න.)");
        map.put(26,"1.26 ඔබ දැනට කොපමණ වාර ගණනක් පහත ආහාර අනුභව කරන්නේද?");
        return map;
    }

    public static Map<String,String> getFirstFollowUpQ4() {
        Map<String, String> map = new HashMap<>();
        map.put("4.1.1.1" ,"4.1.1.1. Pulse rate");
        map.put("4.1.1.2" ,"4.1.1.2. More than 110 bpm");
        map.put("4.1.1.3" ,"4.1.1.3. Irregular rhythm");
        map.put("4.1.2.1" ,"4.1.2.1. Right Systolic");
        map.put("4.1.2.2" ,"4.1.2.2. Right Diastolic");
        map.put("4.1.2.3" ,"4.1.2.3. Left Systolic");
        map.put("4.1.2.4" ,"4.1.2.4. Left Diastolic");
        map.put("4.1.2.5" ,"4.1.2.5. BP >140/90");
        map.put("4.2.1" ,"4.2.1. Neck vein engorgement");
        map.put("4.2.2" ,"4.2.2. Apex deviated");
        map.put("4.2.3" ,"4.2.3. Left para sternal heave");
        map.put("4.2.4" ,"4.2.4. Thrills");
        map.put("4.2.5" ,"4.2.5. Carotid bruit");
        map.put("4.3.1" ,"4.3.1. Murmur");
        map.put("4.3.2" ,"4.3.2. Loud P2");
        map.put("4.3.3" ,"4.3.3. Lung bases fine crepts+");
        map.put("4.4.1" ,"4.4.1. Weight (in Kilograms)");
        map.put("4.5.1" ,"4.5.1. Chest pain suggestive of sinister cardiac pathology (Ischemia, Pulmonary Embolism, Aortic dissection or valve related pathology) ");
        map.put("4.5.2" ,"4.5.2. If yes,");
        map.put("4.5.3" ,"4.5.3. Difficulty in breathing even at rest/mild exertion (non-asthmatic)");
        map.put("4.5.4" ,"4.5.4. If yes,");
        map.put("4.5.5" ,"4.5.5. Palpitation");
        map.put("4.5.6" ,"4.5.6. Syncope/pre-syncope");
        map.put("4.5.7" ,"4.5.7. Class 1+2 SOB with syncope/pre-syncope and Paroxysmal nocturnal dyspnoea");
        map.put("4.5.8" ,"4.5.8. Orthopnoea + Paroxysmal nocturnal dyspnoea + dyspnoea");
        map.put("4.5.9" ,"4.5.9. Complicated Hypertensive disorder (Uncontrolled BP despite of Medical Management, evidence of eclampsia, HF, ACS, AKI)");
        map.put("4.5.10" ,"4.5.10. Stroke");
        map.put("4.6.1" ,"4.6.1. Gestational Diabetes (GDM");
        map.put("4.6.1.1" ,"4.6.1.1. POA at the time of diagnosis");
        map.put("4.6.1.2" ,"4.6.1.2. FBS value");
        map.put("4.6.1.3" ,"4.6.1.3. 1 Hour value");
        map.put("4.6.1.4" ,"4.6.1.4. 2 Hour value");
        map.put("4.6.1.5" ,"4.6.1.5. Management");
        map.put("4.6.2" ,"4.6.2. Pregnancy induced hypertension (PIH)");
        map.put("4.6.2.1" ,"4.6.2.1. POA at the time of diagnosis");
        map.put("4.6.2.2" ,"4.6.2.2. BP value");
        map.put("4.6.2.2.1" ,"4.6.2.2.1. On admission");
        map.put("4.6.2.2.2" ,"4.6.2.2.2. At discharge");
        map.put("4.6.2.3" ,"4.6.2.3. Management");
        map.put("4.6.3" ,"4.6.3. Preeclampsia(PE)");
        map.put("4.6.3.1" ,"4.6.3.1. POA at the time of diagnosis");
        map.put("4.6.3.2" ,"4.6.3.2. BP value");
        map.put("4.6.3.2.1" ,"4.6.3.2.1. On admission");
        map.put("4.6.3.2.2" ,"4.6.3.2.2. At discharge");
        map.put("4.6.3.3" ,"4.6.3.3. Protein uria value");
        map.put("4.6.3.3.1" ,"4.6.3.3.1. On admission");
        map.put("4.6.3.3.2" ,"4.6.3.3.2. At discharge");
        map.put("4.6.3.4" ,"4.6.3.4. Investigations");
        map.put("4.6.3.4.1" ,"4.6.3.4.1. Platelet count");
        map.put("4.6.3.4.2" ,"4.6.3.4.2. AST (SGOT) value");
        map.put("4.6.3.4.3" ,"4.6.3.4.3. ALT(SGPT) value");
        map.put("4.6.3.5" ,"4.6.3.5. Management");

        map.put("4.6.4" ,"4.6.4. Liver related disease");
        map.put("4.6.4.1" ,"4.6.4.1. POA at the time of diagnosis");
        map.put("4.6.4.2" ,"4.6.4.2. AST value/values( or 1st and last value)");
        map.put("4.6.4.3" ,"4.6.4.3. Gamma GT value( or 1st and last value)");
        map.put("4.6.4.4" ,"4.6.4.4. ALT value/values( or 1st and last value");
        map.put("4.6.4.5" ,"4.6.4.5. Platelet count/s( or 1st and last value");
        map.put("4.6.4.6" ,"4.6.4.6. USS liver results(if available)");
        map.put("4.6.4.7" ,"4.6.4.7. Management and follow up plan");
        map.put("4.6.5" ,"4.6.5. Threatened miscarriage");
        map.put("4.6.5.1" ,"4.6.5.1. At what POA");
        map.put("4.6.6" ,"4.6.6. Increased liquor (Scan proven)");
        map.put("4.6.7" ,"4.6.7. Decreased liquor (Scan proven)");
        map.put("4.6.8" ,"4.6.8. Anemia");
        map.put("4.6.8.1" ,"4.6.8.1. Was HPLC done?");
        map.put("4.6.8.2" ,"4.6.8.2. If yes, what is the result?");
        map.put("4.6.8.3" ,"4.6.8.3. Was she transfused during this pregnancy?");
        map.put("4.6.9" ,"4.6.9. Dating US scan done?");
        map.put("4.6.9.1" ,"4.6.9.1. At what POA");
        map.put("4.6.9.2" ,"4.6.9.2. When was it done?(Date)");
        map.put("4.6.10" ,"4.6.10. Blood group of the mother");
        return map;
    }

    public static Map<Integer,String> getFirstFollowUpQ2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"2.1 ගර්භණී කාලය තුළ ඔබ පහත රෝග ලක්ෂණ අත්වින්දේද?");
        map.put(2,"2.2 2.1.a හිදී සඳහන් කළ පපුවේ වේදනාවක්/ කැක්කුමක් තිබේනම් එය පහත සඳහන් කිනම් ප\u200D්\u200Dරකාශනයෙන් වඩා හොඳින් විස්තර කෙරේද?");
        map.put(3,"2.3 2.1.c හිදී සඳහන් කළ පරිදි ඔබට හුස්මගැනීමේ අපහසුතාවය පහත සඳහන් කවර විස්තරයකින් ඔබගේ වර්තමාන කායික කි\u200D්\u200Dරයාකාරිත්වය වඩාත් හොඳින් විස්තර කරයි ද?");
        map.put(4,"2.4 මෙම ගර්භණී කාලය තුළ ඔබට උණ රෝගය වැළඳුනා ද?");
        map.put(5,"2.5 ඔව් නම්, ඒ සඳහා ඔබ රෝහල් ගත වුවාද?");
        map.put(6,"2.6 ඔබ ගැබ් නොගෙන සිටිය යුතුව තිබු බව ඔබට කවදා හෝ සිත’ තිබෙනවාද ?");
        map.put(7,"2.7 ඔබේ ජීවිතයේ වටිනාකමක් නැත යැයි ඔබට කවදා හෝ සිත’ තිබෙනවාද?");
        map.put(8,"2.8 ඔබට කෙදිනක හෝ ඔබටම ශාරිරික හානි සිදුකරගත යුතුයැයි යන සිතුවිල්ල ඇතිවී තිබෙනවාද?");
        map.put(9,"2.9 ඔබ කෙදිනක හෝ ඔබටම ශාරිරික හානි සිදුකර ගැනීමට උත්සාහ කර තිබෙනවාද?");
        map.put(10,"2.10 මෙම ගර්භණී සමය තුළ ඔබ සිතා මතා ඔබට ශාරිරික හානි සිදුකරගෙන තිබෙනවාද?");
        map.put(11,"2.11 මෙම ගර්භණී සමයේදී ඔබට සියදිවි නසා ගැනීමට සිතී තිබෙනවාද?");
        map.put(12,"2.12 ගර්භණී කාලයේදී ඔබ සියදිවි නසා ගැනීමට තැත් කර තිබෙනවාද?");
        map.put(13,"2.13 ඔබට කෙදිනක හෝ ඩෙංගු උණ රෝගය වැළඳී තිබෙනවාද?");
        map.put(14,"2.14 ඔබට කෙදිනක හෝ මී උණ රෝගය වැළඳී තිබෙනවාද?");
        return map;
    }

    public static Map<Integer,String> getFirstFollowUpQ3() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"1. මෙය ආදර සම්බන්ධතාවයකින් ඇති වු විවාහයක් ද?");
        map.put(2,"2. මෙය ඔබගේ පළවෙනි විවාහය ද?");
        map.put(3,"3. මෙය ලේ ඥාතීන් අතර සිදුවුණ විවාහයක් ද?");
        return map;
    }

    public static Map<String,String> getSocialCapitalQ1() {
        Map<String, String> map = new HashMap<>();
        map.put("1","1. ඔබත් ඔබගේ ස්වාමිපුරුෂයත් අතර පවත්නා සම්බන්ධතාවය දැක්වෙන පහත ප\u200D්\u200Dරශ්න වලට පිළිතුරු සපයන්න. (ඔබගේ ස්වාමි පුරුෂයා ජීවතුන් අතර නැත්තම් 1.1 අදාළ නොවේ. එසේ නම් 1.2 කොටසට යන්න)");
        map.put("1.1","1.1. ඔබගේ ස්වාමිපුරුෂයා ඔබ සමඟ කොයිතරම් දුරට නිවසේ රැුදී සිටින්නේද?");
        map.put("1.2","1.2. මාගේ ස්වාමිපුරුෂයා මා සමඟ නිවසේ රැුදී සිටීම මට මහත් සතුටක් ගෙනදේ.");
        map.put("1.3","1.3. මාගේ ස්වාමිපුරුෂයාගේ ආදරය හා රැකවරණය නොඅඩුව ලැබෙන බව මට හැගේ");
        map.put("1.4","1.4. මාත් මාගේ ස්වාමිපුරුෂයාත් අතර මත ගැටුම් හා රණ්ඩු සරුවල් ඇතිවේ");
        map.put("1.5","1.5. ගැටළුවක් ඇතිවු අවස්ථාවකදී මාගේ ස්වාමි පුරුෂයා සම`ග සාකච්ඡුා කිරීමට මට ඉඩ ප\u200D්\u200Dරස්ථාව ඇත.");
        map.put("2","2. ඔබ හා ඔබේ නිවැසියන් අතර පවතින සම්බන්ධතා පිළිබදව පහත ප\u200D්\u200Dරශ්න වලට පිළිතුරු සපයන්න.");
        map.put("2.1","2.1. මම මාගේ නිවැසියන් හා එක්ව සතුටු සාමීචියේ නිරත වන්නෙමි (පැහැදිලි කරන්න)");
        map.put("2.2","2.2. මාගේ නිවැසියන් හා එක්ව කටයුතු කිරීම ( උදාඃ- ඉවුම් පිහුම්,පිරිසිදු කිරීම් ආදිය) මට සතුටක් ගෙනදේ. (පැහැදිලි කරන්න)");
        map.put("2.3","2.3. මාගේ පවුලේ අය සමග එක්ව අපගේ අධ්\u200Dයාත්මික හෝ මානසික සුවය උදෙසා කටයුතු කිරිම මට මහත් අස්වැසිල්ලකි. (පැහැදිලි කරන්න)");
        map.put("2.4","2.4. මාගේ නිවැසියන්/පවුලේ අය මට විශ්වාස කටයුතුය");
        map.put("2.5","2.5. මා හා මාගේ පවුලේ අය/නිවැසියන් අතර අ`ඩදබර ඇති වේ");
        map.put("2.6","2.6. මාගේ දරුවාගේ උපත පිළිබ`දව මාගේ පවුලේ අය/නිවසියන්,");
        map.put("3","3. මෙම වටපිටාවේ අය මට තමන්ගේම කෙනෙකු ලෙස සලකයි.");
        map.put("4.1","4.1. මෙම වටපිටාවේ පුද්ගලයන්ගේ ආදරය හා රැකවරණය මා හට ලැබෙන බව මට හැගෙ");
        map.put("4.2","4.2. මෙම වටපිටාවේ අය සමඟ එක්ව කාලය ගත කිරීම මට ඉමහත් සතුටකි");
        map.put("4.3","4.3. මෙම වටපිටාවේ ජීවත්වීම මට පාළුව හා තනිකම ගෙනදේ");
        map.put("4.4","4.4. මෙම වටපිටාවේ අයගෙන් මට කරදර හිරිහැර සිදුවේ");
        map.put("5","5. මමත් මාගේ වටපිටාවේ අයත් ඔවුනොවුන්ගේ අවශ්\u200Dයතා වලදී එකිනෙකාට උදවු උපකාර කරගනී.");
        map.put("6","6. පොදුවේ ගත් කල මාගේ වටපිටාවේ පුද්ගලයින් මට විශ්වාස කටයුතුයි");
        map.put("7.1","7.1. ගේ දොර වැඩ කටයුතු වලදී කවුරුන් හෝ මට සහය දේ");
        map.put("7.2","7.2. හදිසි මුදල් අවශතාවකදී මා හට ආධාර කිරීමට කව්රුන් හෝ සිටියි.");
        map.put("7.3","7.3. මට අසනීපයක් වූ අවස්ථාවක මා රැුකබලා ගැනීමට කවුරුන් හෝ සිටියි.");
        map.put("7.4","7.4. අවශ්\u200Dයතාවක් ඇතිවුවහොත් මා සමඟ නගරයට යාමට කවුරුන් හෝ සිටීයි.");
        map.put("7.5","7.5. යම් කරදරයක්/දුක්ඛ දායක තත්වයකදී සිතට සහනයක් ලැබෙන අයුරින් මා සමඟ කථාබස් කිරීමට කව්රුන් හෝ සිටියි");
        map.put("7.6","7.6. මා හට යම් කාරනාවක් සම්බන්ධව උපදෙස් හා දැනුම ලබා ගැනීමට අවශ්\u200Dය වූ විට ඒ සදහා කිසිවකු සිටියි");
        return map;
    }

    public static Map<String,String> getSocialCapitalQ2() {
        Map<String, String> map = new HashMap<>();
        map.put("1","1. පහත සඳහන කි\u200D්\u200Dරයාකාරකම් වල ඔබ කෙතරම් දුරට නියලෙන්නේදැයි සදහන් කරන්න.");
        map.put("1.1","1.1 මෙම වටපිටාවේ නෑදෑ/ හිතමිතුරන් හා අසල්වාසීන් සමඟ සම්බන්ධකම් පැවැත්වීම.(පැහැදිලි කරන්න)");
        map.put("1.2","1.2 මෙම වටපිටාවෙන් බැහැරව සිටින්නා වූ නෑදෑ/හිත මිතුරුන් හෝ වෙනත් අය හා දුරකථන ඇමතුම් මගින් කථාබස් කිරීම.");
        map.put("2.2","2.2 සංස්කෘතික හෝ වෙනත් උත්සව හෝ විනෝද ගමන් ආදියට සහභාගී වීම.");
        map.put("2.3","2.3 නගරයට හෝ පොළට යෑම.");
        map.put("3","3. මෙම වටපිටාවේ පොදු ගැටලුවක් පැන නැගුණු අවස්ථාවකදී අසල්වාසීන් සමඟ මමද එක්ව කි\u200D්\u200Dරයාකරමි.(පැහැදිලි කරන්න)");
        map.put("4","4. ඔබ පහත කටයුතුවල නියළිම මගින් කොයිතරම් දුරට සමාජීය දාායකත්වයක් ලබා දෙන්නේද? මෙහිදී ගර්භණි සමය ගැන පමණක් අවධානය යොමුකරන්න.");
        map.put("4.1","4.1. රැකියාවක හෝ ස්වයං රැුකියාවක නියැලීම.");
        map.put("4.2","4.2. ගෙදර දොර වගකීම් දැරීම.");
        map.put("4.3","4.3. වටපිටාවේ ප\u200D්\u200Dරජා කටයුතුවල වගකීම් දැරීම.");
        map.put("4.4","4.4. කුඩා දරුවන්ට ඉගැන්වීම.");
        map.put("4.5","4.5. වටපිටාවේ අසරණ පවුලකට උදව් කිරීම.");
        map.put("4.6","4.6. අන් අයගේ දරුවන් රැුක බලා ගැනීම.");
        map.put("4.7","4.7. වෙනත්");
        map.put("6","6. ඔබ වටපිටාවේ පවතින සේවා පහසුකම් පිළිබද ඔබට ඇත්තේ කෙබදු විශ්වාසයක්ද?");
        map.put("6.1.1","6.1.1 පවුල් සෞඛ්\u200Dය නිළධාරිණිය.");
        map.put("6.1.2","6.1.2 මාතෘ ප\u200D්\u200Dරජා සායන.");
        map.put("6.1.3","6.1.3 සෞඛ්\u200Dය වෛද්\u200Dය නිළධාරී/ලියාපදිංවි වෛද්\u200Dය නිළධාරී වෛද්\u200Dය නිළධාරී සේවාව.");
        map.put("6.1.4.1","6.1.4.1 ශික්ෂණ රෝහල්.");
        map.put("6.1.4.2","6.1.4.2 ග\u200D්\u200Dරාමීය ප\u200D්\u200Dරාදේශීය රෝහල්");
        map.put("6.1.5","6.1.5 විශේඥ වෛද්\u200Dය සේවාව.");
        map.put("7","7. ඔබ ජීවත් වන වටපිටාවේ කිසියම් කණ්ඩායමකල සංවිධානයක හෝ සංගමයක සාමාජිකයෙක් වශයෙන් ඔබ කටයුතු කරයිද?");
        map.put("7.8","7.8. මරණාධාර සමිති.");
        map.put("7.10","7.10. ණය දෙන සමිති.");
        map.put("7.11","7.11. වෙනත්");
        return map;
    }

    public static Map<Integer,String> getBioChemicalQ1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "HB");
        map.put(2, "FBS");
        map.put(3, "OGTT 2nd hr");
        map.put(4, "PPBS");
        map.put(5, "AST");
        map.put(6, "ALT");
        map.put(7, "gamma GT");
        map.put(8, "TG");
        map.put(9, "HDL");
        map.put(10, "T Chol");
        map.put(11, "LDL");
        map.put(12, "VLDL");
        map.put(13, "BU");
        map.put(14, "SCR");
        return map;
    }

    public static Map<Integer,String> getBioChemicalQ2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "HB");
        map.put(2, "FBS");
        map.put(3, "OGTT 2nd hr");
        map.put(4, "Serum Cortisol");
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
        map.put("14","EDD (USS)(ගර්භණී පතෙහි සඳහන් පරිදි)");
        return map;
    }

    public static Map<Integer,String> getFirstFollowUpQ13Map(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a. ස්වසන පද්ධතිය ආශ\u200D්\u200Dරිත රෝග. (කැස්ස, සෙම්ප\u200D්\u200Dරතිශ්\u200Dයාව, හුස්මගැනීමේ අපහසුතාව)");
        map.put(2,"b. මුත\u200D්\u200Dරා මාර්ගය ආශි\u200D්\u200Dරත රෝග (මුත\u200D්\u200Dරා දැවිල්ල, මුත\u200D්\u200Dරා පිටවීම අඩුවීම, යටිබඬේ කැක්කුම)");
        map.put(3,"c. ඔක්කාරය, වමනය, උගුරට ඒම, බඬේ දැවිල්ල");
        map.put(4,"d. මස්පිඩු පෙරළිම, කකුල් ඉදීමිම, නහර ගැටගැසීම.");
        map.put(5,"e. හිසරදය, ක්ලාන්ත ගතිය.");
        map.put(6,"f. යෝනි මාර්ගයෙන් රුධිරය වහනය.");
        map.put(7,"g. දරුණු බඬේ කැක්කුම");
        map.put(8,"h. යෝනි මාර්ගයෙන් ශ\u200D්\u200Dරාවයන් පිටවීම හා කැසීම.");
        map.put(9,"i. මල බද්ධය");
        map.put(10,"j. එදිනෙදා වැඩකටයුතු කිරීමට අපහසු දරුණු කොන්දේ කැක්කුම.");
        map.put(11,"k. වෙනත්");
        return map;
    }

    public static Map<Integer,String> getFirstFollowTab2UpQ1Map(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a. පපුවේ වේදනාව / කැක්කුම (අත දිගේ, බෙල්ල වෙත ඇදෙන, දහඩිය දැමීමක් සිදුවන)");
        map.put(2,"b. පපුවේ වේදනාව (ඉහත රෝග ලක්ෂණ රහිතව)");
        map.put(3,"c. හුස්මගැනීමේ අපහසුතාවය");
        map.put(4,"d. හතිය");
        map.put(5,"e. පපුවේ ගැස්ම");
        map.put(6,"f. ක්ලාන්ත ගතිය");
        map.put(7,"g. විවේකීව සිටිමේදී වෙහෙසක් දැනීම");
        map.put(8,"h. වළලූකර ආශ\u200D්\u200Dරිත කකුළේ ඉදීමිම");
        map.put(9,"i. හාන්සිව සිටින විට හුස්ම ගැනීමේ අපහසුතාවය");
        map.put(10,"j. හුස්මගැනීමේ අපහසුතාවය නිසා නින්දෙන් අවදීවීම");
        return map;
    }

    public static Map<String,String> getSocialCapitalTab1Map() {
        Map<String, String> map = new HashMap<>();
        map.put("1","ගෘහස්ත සම්බන්ධතා - ස්වාමි පුරුෂයා සමග.");
        map.put("2","ගෘහස්ථ සම්බන්ධතා - පවුලේ සාමාජිකයින් සමඟ");
        map.put("3","ඔබගේ වටපිටාව පිළිබදව පහත ප\u200D්\u200Dරශ්න වලට පිළිතුරු සපයන්න");
        map.put("4","සමාජීය සත්කාර");
        return map;
    }

    public static Map<Integer,String> getSBioChemicalTab1UnitMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "g/dL");
        map.put(2, "mg/dL");
        map.put(3, "mg/dL");
        map.put(4, "mg/dL");
        map.put(5, "u/L");
        map.put(6, "u/L");
        map.put(7, "u/L");
        map.put(8, "mg/dL");
        map.put(9, "mg/dL");
        map.put(10, "mg/dL");
        map.put(11, "mg/dL");
        map.put(12, "mg/dL");
        map.put(13, "mmol/L");
        map.put(14, "μmol/dL");
        return map;
    }

    public static Map<Integer,String> getSBioChemicalTab2UnitMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "g/dL");
        map.put(2, "mg/dL");
        map.put(3, "mg/dL");
        map.put(4, "mg/dL");
        return map;
    }
}
