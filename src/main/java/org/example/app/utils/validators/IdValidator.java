package org.example.app.utils.validators;

import org.example.app.utils.Constants;

public final class IdValidator {
    public static boolean isIdValid(String id) {
        return id.isEmpty() || !id.matches(Constants.ID_RGX);
    }
}
