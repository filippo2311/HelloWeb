package it.talentform.bank.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static LocalDate dateFromString(String source){

        return LocalDate.parse(source, formatter);

    }
    public static String stringFromDate (LocalDate source){
        return source.format(formatter);
    }
}
