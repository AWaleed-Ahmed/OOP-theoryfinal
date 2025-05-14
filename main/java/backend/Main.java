package backend;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main extends Application {
    //Configuration constants are fixed values that control application behavior.
    // MAX_USERS limits system capacity (50 users).
    // USER_FILE defines storage location (users.txt).
    // these are all static take baarbaar system run karein tu system ko yaad rahe number of users
    private static final int MAX_USERS = 50;
    private static final int DEFAULT_USER_COUNT = 5;
    private static final String USER_FILE = "users.txt";

    //constructor to call some passwords and accounts for testing
    public static final authenticator auth = new authenticator(
            new String[]{"hassan123@gmail.com","fozan456@gmail.com","abdullah789@gmail.com","syed987@gmail.com","ali654@gmail.com"},
            new int[]{123456789,456789123,789123456,987654321,654321987}
    );

    //this is loading fxml files (signin.fxml) to the main
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/frontend/SignIn.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle("Fitness App - Sign In");
            stage.show();
            auth.loadUsersFromFile();
        } catch(Exception e) {
            e.printStackTrace();
            // Consider showing an alert to the user here
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class authenticator {
        //definition class
        //defining all these variables ur seeing
        private final String[] username = new String[MAX_USERS];
        private final int[] password = new int[MAX_USERS];
        private int usercount = DEFAULT_USER_COUNT;
        private int nameindex = -1;
        private int passwordindex = -1;

        //contructor
        public authenticator(String[] names, int[] key) {
            //names  string array into username
            //key int array into password
            System.arraycopy(names, 0, username, 0, DEFAULT_USER_COUNT);
            System.arraycopy(key, 0, password, 0, DEFAULT_USER_COUNT);
        }

        public void signup(String newUsername, int newPassword) {
            if (usercount >= MAX_USERS) {
                System.out.println("Maximum user limit reached");
                return;
            }
            //function is seeing weather the max users is hit or not
            //function is also saving new usernames and passwords
            username[usercount] = newUsername;
            password[usercount] = newPassword;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
                writer.write(newUsername + "," + newPassword + "\n");
            } catch (IOException e) {
                System.out.println("Error saving user: " + e.getMessage());
            }
            usercount++;
        }

        public void loadUsersFromFile() {
            try (Scanner fileScanner = new Scanner(new File(USER_FILE))) {
                int i = DEFAULT_USER_COUNT;
                while (fileScanner.hasNextLine() && i < MAX_USERS) {
                    String[] userData = fileScanner.nextLine().split(",");
                    if (userData.length == 2) {
                        username[i] = userData[0];
                        password[i] = Integer.parseInt(userData[1]);
                        i++;
                    }
                }
                usercount = i;
            } catch (FileNotFoundException e) {
                System.out.println("User file not found, starting fresh.");
            } catch (Exception e) {
                System.out.println("Error loading users: " + e.getMessage());
            }
        }

        public void verifyusername(String name) {
            nameindex = -1;
            //checking the username at that usercount
            for (int i = 0; i < usercount; i++) {
                if (name.equals(username[i])) {
                    nameindex = i;
                    return;
                }
            }
            System.out.println("Username not found");
        }

        public void verifypassword(int key) {
            passwordindex = -1;
            //checking password at that usercount
            for (int i = 0; i < usercount; i++) {
                if (key == password[i]) {
                    passwordindex = i;
                    return;
                }
            }
            System.out.println("Invalid password");
        }

        public boolean verify() {
            return passwordindex != -1 && passwordindex == nameindex;
        }
    }
}