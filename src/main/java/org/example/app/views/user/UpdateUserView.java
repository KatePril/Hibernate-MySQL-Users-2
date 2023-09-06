package org.example.app.views.user;

import java.util.Scanner;

public class UpdateUserView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user's id: ");
        String id = scanner.nextLine().trim();

        System.out.println("Enter new email in format example@mail.com: ");
        String email = scanner.nextLine().trim();

        return new String[]{id, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
