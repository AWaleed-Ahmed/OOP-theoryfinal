package backend;

import backend.*;
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/frontend/BMI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

