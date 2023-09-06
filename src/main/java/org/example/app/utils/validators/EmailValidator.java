package org.example.app.utils.validators;

import org.example.app.utils.Constants;

public final class EmailValidator {
    public static boolean isEmailValid(String email) {
        return email.isEmpty() || !email.matches(Constants.EMAIL_RGX);
    }
}
