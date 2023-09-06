package org.example.app.utils.validators;

import org.example.app.utils.Constants;

public class PhoneValidator {
    public static boolean isPhoneValid(String phone) {
        return phone.isEmpty() || !phone.matches(Constants.PHONE_RGX);
    }
}
