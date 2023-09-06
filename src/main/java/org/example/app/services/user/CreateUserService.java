package org.example.app.services.user;

import org.example.app.entities.User;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.validators.DateValidator;
import org.example.app.utils.validators.EmailValidator;
import org.example.app.utils.validators.PhoneValidator;

import java.util.HashMap;
import java.util.Map;

public class CreateUserService {

    UserCreateRepository repository;

    public CreateUserService(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createUser(String[] data) {
         Map<String, String> errors = validateData(data);

         if(!errors.isEmpty()) {
             try {
                 throw new CreateException("Check inputs", errors);
             } catch (CreateException ce) {
                 return ce.getErrors(errors);
             }
         }

         return repository.createUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("username", Constants.INPUT_REQ_MSG);
        if (data[1].isEmpty())
            errors.put("first_name", Constants.INPUT_REQ_MSG);
        if (data[2].isEmpty())
            errors.put("last_name", Constants.INPUT_REQ_MSG);
        if (DateValidator.isDateValid(data[3]))
            errors.put("birth_date", Constants.INPUT_REQ_MSG);
        if (EmailValidator.isEmailValid(data[4]))
            errors.put("email", Constants.INPUT_REQ_MSG);
        if (PhoneValidator.isPhoneValid(data[5]))
            errors.put("phone", Constants.INPUT_REQ_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setUsername(data[0]);
        user.setFirstName(data[1]);
        user.setLastName(data[2]);
        user.setBirthDate(data[3]);
        user.setEmail(data[4]);
        user.setPhone(data[5]);
        return user;
    }
}
