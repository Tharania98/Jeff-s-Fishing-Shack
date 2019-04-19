package sample;


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

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Register{
public TextField email;
public PasswordField password;
public TextField firstname;
public TextField lastname;
public TextField id;

    @FXML
    public void signup(javafx.event.ActionEvent event) throws IOException {

        registerDetails();

            int length = 0;						// Stores the number characters in the password
            int numCount = 0;					// Variable used to store numbers in the password



            for (int x =0; x < password.getText().length(); x++) {
                if ((password.getText().charAt(x) >= 47 && password.getText().charAt(x) <= 58) || (password.getText().charAt(x) >= 64 && password.getText().charAt(x) <= 91) ||
                        (password.getText().charAt(x) >= 97 && password.getText().charAt(x) <= 122)) {
                    //Keep the Password
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("PASSWORD CONTAINS INVALID CHARACTERS!");
                    alert.showAndWait();

                    //Checks that password contains only letters and numbers
                }
                if ((password.getText().charAt(x) > 47 && password.getText().charAt(x) < 58)) {			// Counts the number of numbers
                    numCount ++;
                }
                length = (x + 1);								// Counts the passwords length
            } // Ends the for loop

            if (numCount < 2){									// Checks that password contains atleast two numbers
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("NOT ENOUGH NUMBERS IN PASSWORD!");
                alert.showAndWait();

                }



            if (length < 8){									// Checks that password is long enough
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("YOUR PASSWORD IS TOO SHORT. YOUR PASSWORD SHOULD CONTAIN MINIMUM 8 CHARACTERS!");
                alert.showAndWait();


            }

           if( (numCount < 2) && (length < 8)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("PASSWORD IS VALID!");
                alert.showAndWait();
               sendmailregister();
               ((Node) event.getSource()).getScene().getWindow().hide();
               loadWindow("/sample/customer.fxml", "Customer");


               }
               registerDetails();
            }


    public void registerDetails() {

        try {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");
        String txt1 = email.getText();
        String txt2 = password.getText();
        String txt3 = firstname.getText();
        String txt4 = lastname.getText();
        String txt5 = id.getText();


        PreparedStatement stmt = con.prepareStatement(" insert into customer values(?,?,?,?,?)");
            stmt.setString(1, txt1);
            stmt.setString(2, txt2);
            stmt.setString(3, txt3);
            stmt.setString(4, txt4);
            stmt.setString(5, txt5);
        int i = stmt.executeUpdate();
        System.out.println("1 record inserted");



        con.close();


        } catch (Exception e) {
        System.out.println(e);
        }



        }
    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }
    public void sendmailregister(){

        String host = "smtp.gmail.com";

//

        Properties props = new Properties();
        props.setProperty( "mail.smtp.ssl.enable", "true" );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", host );
        props.put( "mail.smtp.port", "465" );

        // Get the Session object.
        Session session = Session.getInstance( props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){

                        return new PasswordAuthentication( "jeff4thara@gmail.com", "jeff12,." );
                    }
                } );


        // Create a default MimeMessage object.
        Message message = new MimeMessage( session );

        // Set From: header field of the header.
        try {
            message.setFrom( new InternetAddress( "jeff4thara@gmail.com" ) );
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Set To: header field of the header.
        try {
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( email.getText()));
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Set Subject: header field
        try {
            message.setSubject( "Testing Subject" );
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Now set the actual message
        try {
            message.setText( ",\n\tYou have been succesfully registerd. You will be sent " +
                    "newsletter and your payment invoices.\n\tThank You. " );
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Send message
        try {
            Transport.send(message);
            System.out.println( "Sent message successfully...." );

        }catch (Exception e) {
            e.printStackTrace();
        }


    }



}

