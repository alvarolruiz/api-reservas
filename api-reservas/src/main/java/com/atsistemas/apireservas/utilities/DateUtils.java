package com.atsistemas.apireservas.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    static String defaultDatePattern = "dd/MM/yyyy";
    static  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(defaultDatePattern);

    public static LocalDate getLocalDateFromString(String stringDate){
        return LocalDate.parse(stringDate, formatter);
    }
}
