package org.example.app.controllers.user;

import org.example.app.services.AppService;
import org.example.app.services.user.ReadUserService;
import org.example.app.utils.AppStarter;
import org.example.app.views.user.ReadUserView;

public class UserReadController {
    ReadUserView view;
    ReadUserService service;

    public UserReadController(ReadUserView view, ReadUserService service) {
        this.view = view;
        this.service = service;
    }

    public void readUsers() {
        view.getOutput(service.readUser());
        AppStarter.startApp();
    }
}
