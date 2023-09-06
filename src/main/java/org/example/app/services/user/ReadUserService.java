package org.example.app.services.user;

import org.example.app.entities.User;
import org.example.app.repositories.UserReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadUserService {

    UserReadRepository repository;

    public ReadUserService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUser() {
        List<User> list = repository.readUsers();

        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(1);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.getAndIncrement())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getUsername())
                                .append(", ")
                                .append(user.getFirstName())
                                .append(" ")
                                .append(user.getLastName())
                                .append(", ")
                                .append(user.getBirthDate())
                                .append(", ")
                                .append(user.getEmail())
                                .append(", ")
                                .append(user.getPhone())
                                .append("\n")
                );
                return "\n_______ USERS ________" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
