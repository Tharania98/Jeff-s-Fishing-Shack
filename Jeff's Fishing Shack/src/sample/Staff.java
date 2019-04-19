package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Staff {


    public Button btnstafflogin;
    public PasswordField staffpassword;
    public TextField staffemail;

@FXML
    private void stafflogin(ActionEvent event)throws IOException {



            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");
                String sql1 = "SELECT 'Staff user name' from 'staff';";
                String sql2 = "SELECT 'Staff Password' from 'staff';";
                String username = sql1;

                String password1 = sql2;


                //  pst = con.prepareStatement(sql);

                String email = staffemail.getText();
                String passwordx = staffpassword.getText();

                if ((email.equals(username)) && (passwordx.equals(password1))) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("LOGIN FAILED!");
                    alert.showAndWait();


                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("LOGIN SUCCESS!");
                    alert.showAndWait();
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    loadWindow("/sample/customer.fxml", "Customer");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }









        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/staffMainPage.fxml", "staffMainPage");


    }
    public void staffback(ActionEvent event)throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/welcome.fxml", "Welcome");


    }
    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }


}
