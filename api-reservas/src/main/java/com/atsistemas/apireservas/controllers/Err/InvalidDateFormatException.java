package com.atsistemas.apireservas.controllers.Err;

import java.time.format.DateTimeParseException;

public class InvalidDateFormatException extends DateTimeParseException {
    private static String defaultMessage = "Date '%s' could not be parsed because it´s format is incorrect";

    public InvalidDateFormatException(CharSequence parsedData, int errorIndex) {
        super(String.format(defaultMessage, parsedData), parsedData, errorIndex);
    }

}
