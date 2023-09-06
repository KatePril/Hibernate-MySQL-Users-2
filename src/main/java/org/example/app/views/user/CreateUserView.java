package org.example.app.views.user;

import java.util.Scanner;

public class CreateUserView {
    public String[] getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine().trim();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.println("Enter birth date in format YYYY-MM-DD: ");
        String birthDate = scanner.nextLine().trim();

        System.out.println("Enter email in format example@mail.com: ");
        String email = scanner.nextLine().trim();

        System.out.println("Enter phone number in format xxx xxx-xxxx: ");
        String phone = scanner.nextLine().trim();

        return new String[]{username, firstName, lastName, birthDate, email, phone};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
