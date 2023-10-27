package it.talentform.bank.model;

public class EnumUtils {
    public static Sex stringToSex(String source){
        switch (source.toUpperCase()) {
            case "F":
                return Sex.FEMALE;
            case "M":
                return Sex.MALE;
            case "N":
                return Sex.NON_BINARY;
            default:
                throw new IllegalArgumentException("il sesso deve essere M,F,N");
        }
    }
    public static String sexToString(Sex source){
        switch (source){
            case FEMALE:
                return "F";
            case MALE:
                return "M";
            case NON_BINARY:
                return  "N";
            default:
                throw new IllegalArgumentException("valore non previsto");
        }
    }
}//come esercizio spostare queste Enums nelle classi del enum Sex
