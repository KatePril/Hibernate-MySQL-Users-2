package org.example.app.controllers.user;

import org.example.app.services.user.CreateUserService;
import org.example.app.utils.AppStarter;
import org.example.app.views.user.CreateUserView;

public class UserCreateController {
    CreateUserView view;
    CreateUserService service;

    public UserCreateController(CreateUserView view, CreateUserService service) {
        this.view = view;
        this.service = service;
    }

    public void createUser() {
        view.getOutput(service.createUser(view.getData()));
        AppStarter.startApp();
    }
}
