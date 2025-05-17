package backend;

import backend.models.authenticator;
import backend.models.calculation;
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
import java.net.URL;
import java.util.Objects;
import backend.models.*;
import backend.models.UserData;

public class SceneController {
    authenticator auth;
    public SceneController() {
        this.auth = Main.auth;
    }

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
    Node source = (Node)event.getSource();
    Parent parent = source.getParent();
    TextField usernameField = (TextField)parent.lookup("#usernameField");
    PasswordField passwordField = (PasswordField)parent.lookup("#passwordField");
    Label loginMessage = (Label)parent.lookup("#loginMessage");
    String username = usernameField.getText();
    String passwordText = passwordField.getText();

    try {
        int password = Integer.parseInt(passwordText);
        this.auth.verifyusername(username);
        this.auth.verifypassword(password);
        if (this.auth.verify()) {
            Parent root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource("/frontend/UserData(UI).fxml")));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            loginMessage.setText("Invalid username or password!");
        }
    } catch (NumberFormatException var13) {
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

            // Use UserData to store values
            backend.models.UserData userData = new backend.models.UserData();
            userData.setAge(age);
            userData.setGender(gender);
            userData.setWeigth(weight);
            userData.setHeigth(height);

            // Calculate BMI
            calculation calc = new calculation();
            calc.bmical(weight, height);
            double bmi = calc.index();
            String tips = calc.getTips();


            // Load BMI.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/BMI.fxml"));
            Parent root = loader.load();

            // Set BMI and level
            String level;
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
                bmiLabel.setText(String.format("%.2f", bmi));
            }
            if (levelLabel != null) {
                levelLabel.setText(level);
            }

            // Switch to next scene
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
    // ye kia hy?
    public void switchToScene10(ActionEvent event) throws IOException {          // Scene 5: FitnessGoals
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/FitnessGoals.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene6(ActionEvent event) throws IOException {          // Scene 6 : CalorieCounter
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/CalorieCounter.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene7(ActionEvent event) throws IOException {          // Scene 7 : CalorieCalculator2
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/CalorieCalculator2.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene8(ActionEvent event) throws IOException {          // Scene 8 : RankCalculator
        Parent root = FXMLLoader.load((getClass().getResource("/frontend/RankCalculator.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene9(ActionEvent event) throws IOException {          // Scene 9 : Rank+Suggestions
        Parent root = FXMLLoader.load((getClass().getResource("/frontend/Rank+Suggestions.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

