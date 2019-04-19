package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Admin {


    //declaring and initialising variables
    private String username = "jeff4thara@gmail.com";
    private String password = "jeff12,.";


    static String uname = "";


    @FXML
    private TextField adminemail;
    @FXML
    private PasswordField adminpassword;

@FXML
//method to load necessary window on button click
public void adminback(ActionEvent event) throws IOException {
    ((Node) event.getSource()).getScene().getWindow().hide();
    loadWindow("/sample/welcome.fxml", "Welcome");
}


    @FXML
    //method to verify admin username and password
    private void adminlogin(ActionEvent event) throws IOException {
        String name = adminemail.getText();
        String passw = adminpassword.getText();
        if (name.isEmpty() || passw.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Fill all required fields!");
            alert.showAndWait();
        } else {

            if ((name.equals(username) && passw.equals(password))) {

                //Controller.uname = uname;

                uname = name;
                ((Node) event.getSource()).getScene().getWindow().hide();
                loadWindow("/sample/adminMainPage.fxml", "adminMainPage");

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Sorry! Please enter the right credentials");
                alert.showAndWait();

            }
        }
    }

//method to load window
            public void loadWindow (String location, String title) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource(location));
                Scene scene = new Scene(root);
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setScene(scene);
                stage.setTitle(title);
                stage.show();

            }

        }



