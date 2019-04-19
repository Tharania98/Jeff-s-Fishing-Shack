package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Controller implements Initializable {


    @FXML
    private Label lblwelcome;
    @FXML
    private ImageView imgsignin;
    @FXML
    private ImageView imguser;
    @FXML
    private ImageView imgpass;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btnstaff;
    @FXML
    private Button btnadmin;
    @FXML
    private Button btnregister;
    @FXML
    private TextField emailcus;
    @FXML
    private PasswordField password;


    public void initialize(URL url, ResourceBundle rb) {

    }


    @FXML
    //method load another window on button click
    private void register(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/register.fxml", "Register");
    }

    @FXML
    //method load another window on button click
    private void loginadmin(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/admin.fxml", "Admin");
    }

    @FXML
    //method load another window on button click
    private void loginstaff(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/staff.fxml", "Staff");
    }


    @FXML
//method to verify username and password
    private void loginCustomer(ActionEvent event) throws IOException {


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");//database connection
            String sql1 = "SELECT 'Email' from 'CUSTOMER';";//query to select email from database table
            String sql2 = "SELECT 'Password' from 'CUSTOMER';";//query to select pasword from database table
            String username = sql1;

            String password1 = sql2;


            //  pst = con.prepareStatement(sql);

            String email = emailcus.getText();
            String passwordx = password.getText();

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



}


    //method load another window
    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }

}
