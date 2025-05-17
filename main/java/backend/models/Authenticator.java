//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package backend.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Authenticator {
    String[] username = new String[50];
    int[] password = new int[50];
    int usercount = 0;
    int nameindex = 8;
    int passwordindex = -1;

    public void signup(String newUsername, int newPassword) {
        this.username[this.usercount] = newUsername;
        this.password[this.usercount] = newPassword;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(newUsername + "," + newPassword);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }

        ++this.usercount;
        System.out.println("Signup successful! Now please login.");
    }

    public void loadUsersFromFile() {
        try {
            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);

            int i;
            for(i = 0; fileScanner.hasNextLine() && i < 50; ++i) {
                String line = fileScanner.nextLine();
                String[] userData = line.split(",");
                this.username[i] = userData[0];
                this.password[i] = Integer.parseInt(userData[1]);
            }

            this.usercount = i;
        } catch (FileNotFoundException var6) {
            System.out.println("User file not found, starting fresh.");
        }

    }

    public void verifyusername(String name) {
        for(int i = 0; i < this.usercount; ++i) {
            if (this.username[i].equals(name)) {
                this.nameindex = i;
            }
        }

        if (this.nameindex == 8) {
            System.out.println("Invalid username ! not found in record");
        }

    }

    public void verifypassword(int key) {
        for(int i = 0; i < this.usercount; ++i) {
            if (this.password[i] == key) {
                this.passwordindex = i;
            }
        }

        if (this.passwordindex == -1) {
            System.out.println("invalid password!! Not found in record");
        }

    }

    public boolean verify() {
        if (this.passwordindex == this.nameindex) {
            System.out.println("Welcome \ud83d\ude18 NOW LETS GET STARTED GIVE ME SOME FOLLOWING CREDENTIALS ");
            return true;
        } else {
            System.out.println("your username donot match your password ");
            return false;
        }
    }
}
