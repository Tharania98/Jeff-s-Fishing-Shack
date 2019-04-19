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

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class staffDetails {

    public TextField staffUsername;
    public PasswordField staffpassword;
    public TextField staffFullname;


    public void enter(ActionEvent event) throws IOException, SQLException{


            try {

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");
                String txt20 = staffUsername.getText();
                String txt21 = staffpassword.getText();
                String txt22 = staffFullname.getText();



                PreparedStatement stmt = con.prepareStatement(" insert into Staff values(?,?,?)");
                stmt.setString(1, txt20);
                stmt.setString(2, txt21);
                stmt.setString(3, txt22);

                int i = stmt.executeUpdate();
                System.out.println("1 record inserted");



                con.close();


            } catch (Exception e) {
                System.out.println(e);
            }





        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("STAFF DETAILS ARE ENTERED INTO THE DATABASE!");
        alert.showAndWait();
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/adminMainPage.fxml", "adminMainPage");

    }
    public void backtomainpage(ActionEvent event) throws IOException{
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/adminMainPage.fxml", "adminMainPage");
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
