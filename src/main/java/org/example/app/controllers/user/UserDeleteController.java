package org.example.app.controllers.user;

import org.example.app.services.user.DeleteUserService;
import org.example.app.utils.AppStarter;
import org.example.app.views.user.DeleteUserView;

public class UserDeleteController {

    DeleteUserView view;
    DeleteUserService service;

    public UserDeleteController(DeleteUserView view, DeleteUserService service) {
        this.view = view;
        this.service = service;
    }

    public void deleteUser() {
        view.getOutput(service.deleteUser(view.getData()));
        AppStarter.startApp();
    }
}
