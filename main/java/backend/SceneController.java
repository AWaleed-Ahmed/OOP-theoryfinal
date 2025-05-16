package backend;

import backend.*;
import backend.models.calculation;
import backend.models.habit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Objects;

public class SceneController {
    private Main.authenticator auth = Main.auth;
    private habit userhabit = new habit();

    @FXML
    private TextField nameField, ageField, weightField, heightField;

    public String gender = "";  // Public gender variable

    @FXML
    private void handleMaleGender() {
        gender = "Male";  // Directly set public variable
        System.out.println("Gender set to: " + gender);
    }

    @FXML
    private void handleFemaleGender() {
        gender = "Female";  // Directly set public variable
        System.out.println("Gender set to: " + gender);
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/frontend/SignIn.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/frontend/SignUp.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//this where we click a button using actionevent object ie event and if it doesnt press
//this is gonna throw an exception
    public void switchToScene3(ActionEvent event) throws IOException {
        //node gets the ui properties and getsource gets the uh return button of the event
        Node source = (Node) event.getSource();
        // Get the parent container (jese AnchorPane) of the button
        Parent parent = source.getParent();
// ye passwordfield fx id se likhi hai woh aik childnode ki id hai
// same with textfield
        //lookup se hum child nodes ko dhondte hain jese yahan pe usernamefield waghera
        TextField usernameField = (TextField) parent.lookup("#usernameField");
        PasswordField passwordField = (PasswordField) parent.lookup("#passwordField");
        Label loginMessage = (Label) parent.lookup("#loginMessage");

        // Get the entered credentials from the childnodes
        String username = usernameField.getText();
        String passwordText = passwordField.getText();

        try {
            int password = Integer.parseInt(passwordText);

            // Verify credentials that we just caught using childnodes into verify functions
            auth.verifyusername(username);
            auth.verifypassword(password);

            if (auth.verify()) {
                // Successful login - proceed to user data scene agay chale ga
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/frontend/UserData(UI).fxml")));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                loginMessage.setText("Invalid username or password!");
            }
        } catch (NumberFormatException e) {
            loginMessage.setText("Password must be numeric!");
        }
    }
    public void switchToScene4(ActionEvent event) throws IOException {
        String name = nameField.getText();
        String ageText = ageField.getText();
        String weightText = weightField.getText();
        String heightText = heightField.getText();

        try {
            int age = Integer.parseInt(ageText);
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText);

            // Calculate BMI
            calculation calc = new calculation();
            calc.bmical(weight, height);
            double bmi = calc.index();

            // Store user data (if needed)
            userhabit.age = age;
            userhabit.gender = gender;
            userhabit.weigth = weight;
            userhabit.heigth = height;

            // Load the BMI.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/BMI.fxml"));
            Parent root = loader.load();

            String level = "";
            if (bmi < 18.5) {
                level = "Underweight";
            } else if (bmi < 24.9) {
                level = "Normal";
            } else if (bmi < 30) {
                level = "Overweight";
            } else {
                level = "Obese";
            }

            Label bmiLabel = (Label) root.lookup("#bmiLabel");
            Label levelLabel = (Label) root.lookup("#levelLabel");

            if (bmiLabel != null) {
                bmiLabel.setText(String.format(""+bmi));
            }
            if (levelLabel != null) {
                levelLabel.setText(level);
            }

            // Switch scene
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values for age, weight, and height.");
        }
    }

     public void switchToScene5(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/frontend/SignUp.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void handleSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/SignUp.fxml"));
        Node source = (Node) event.getSource();
        Parent parent = source.getParent();

        TextField usernameField = (TextField) parent.lookup("#usernameField");
        PasswordField passwordField = (PasswordField) parent.lookup("#passwordField");

        String username = usernameField.getText();
        String passwordText = passwordField.getText();

        try {
            int password = Integer.parseInt(passwordText);
            auth.signup(username, password);
            switchToScene1(event);
        } catch (NumberFormatException e) {
            System.out.println("Password must be numeric.");
        }
    }

}

