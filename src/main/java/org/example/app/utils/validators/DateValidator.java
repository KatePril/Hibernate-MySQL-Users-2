package org.example.app.utils.validators;

import org.example.app.utils.Constants;

public final class DateValidator {
    public static boolean isDateValid(String date) {
        return date.isEmpty() || !date.matches(Constants.DATE_RGX);
    }
}
