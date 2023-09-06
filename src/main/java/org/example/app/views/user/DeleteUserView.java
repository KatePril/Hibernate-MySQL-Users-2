package org.example.app.views.user;

import java.util.Scanner;

public class DeleteUserView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user's id: ");
        String id = scanner.nextLine().trim();
        return new String[]{id};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
