package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class inquire {

//generalising and initialising variables
    public TextField inuser;
    public TextField messageinquire;

    public void send(ActionEvent actionEvent) {

        sendmailinquire();
    }//method to send email inquiry by customer to owner
        public void sendmailinquire(){

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
                message.setFrom( new InternetAddress(inuser.getText() ) );
            } catch (javax.mail.MessagingException e1) {
                e1.printStackTrace();
            }

            // Set To: header field of the header.
            try {
                message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( "jeff4thara@gmail.com"));
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
                message.setText( ",\n\t Dear Sir, " +messageinquire.getText()+" Thank you");
            } catch (javax.mail.MessagingException e1) {
                e1.printStackTrace();
            }

            // Send message
            try {
                Transport.send(message);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("A mail will be sent to your mail confirming your mail");
                alert.showAndWait();
            }catch (Exception ex) {
                ex.printStackTrace();
            }


        }



    //method load another window on button click
    public void inback(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/customer.fxml", "Customer");

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
