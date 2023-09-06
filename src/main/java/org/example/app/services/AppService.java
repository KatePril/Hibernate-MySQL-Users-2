package org.example.app.services;

import org.example.app.controllers.user.UserCreateController;
import org.example.app.controllers.user.UserDeleteController;
import org.example.app.controllers.user.UserReadController;
import org.example.app.controllers.user.UserUpdateController;
import org.example.app.exceptions.OptionException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.repositories.UserDeleteRepository;
import org.example.app.repositories.UserReadRepository;
import org.example.app.repositories.UserUpdateRepository;
import org.example.app.services.user.CreateUserService;
import org.example.app.services.user.DeleteUserService;
import org.example.app.services.user.ReadUserService;
import org.example.app.services.user.UpdateUserService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.user.CreateUserView;
import org.example.app.views.user.DeleteUserView;
import org.example.app.views.user.ReadUserView;
import org.example.app.views.user.UpdateUserView;

public class AppService {

    public void createUser() {
        UserCreateRepository repository = new UserCreateRepository();
        CreateUserService service = new CreateUserService(repository);
        CreateUserView view = new CreateUserView();
        UserCreateController controller = new UserCreateController(view, service);
        controller.createUser();
    }

    public void readUsers() {
        UserReadRepository repository = new UserReadRepository();
        ReadUserService service = new ReadUserService(repository);
        ReadUserView view = new ReadUserView();
        UserReadController controller = new UserReadController(view, service);
        controller.readUsers();
    }

    public void updateUser() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UpdateUserService service = new UpdateUserService(repository);
        UpdateUserView view = new UpdateUserView();
        UserUpdateController controller = new UserUpdateController(view, service);
        controller.updateUser();
    }

    public void deleteUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        DeleteUserService service = new DeleteUserService(repository);
        DeleteUserView view = new DeleteUserView();
        UserDeleteController controller = new UserDeleteController(view, service);
        controller.deleteUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        for (int i : options) {
            if (i == value) {
                return true;
            }
        }

        return false;
    }

}
