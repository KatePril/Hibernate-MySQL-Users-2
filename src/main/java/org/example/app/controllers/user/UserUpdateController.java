package org.example.app.controllers.user;

import org.example.app.services.user.UpdateUserService;
import org.example.app.utils.AppStarter;
import org.example.app.views.user.UpdateUserView;

public class UserUpdateController {

    UpdateUserView view;
    UpdateUserService service;

    public UserUpdateController(UpdateUserView view, UpdateUserService service) {
        this.view = view;
        this.service = service;
    }

    public void updateUser() {
        view.getOutput(service.updateUser(view.getData()));
        AppStarter.startApp();
    }
}
