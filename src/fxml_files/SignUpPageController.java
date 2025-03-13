package fxml_files;

import java.net.URL;
import java.sql.*;
import javafx.util.Duration;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SignUpPageController implements Initializable {

    @FXML
    private Button LOGIN;

    @FXML
    private TextField CUsername;

    @FXML
    private PasswordField Cpassword;

    @FXML
    private TextField MobileNumber;

    @FXML
    private TextField Email;

    @FXML
    private Button SignUP;

    @FXML
    private Button Cancel;

    @FXML
    private ImageView Progress;

    private Connection connection;
    private DatabaseHandler handler;
    private PreparedStatement pst;
    private PreparedStatement pst2;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Progress.setVisible(false);
        handler = new DatabaseHandler();
    }

    @FXML
    public void SignUpAction(ActionEvent event) {
        Progress.setVisible(true);
        PauseTransition pt1 = new PauseTransition();
        pt1.setDuration(Duration.seconds(2));
        pt1.setOnFinished(e -> {
           // System.out.println("SignUp Successful!");
        });
        pt1.play();

        //validating and saving data into database

        String  insert = "INSERT INTO USERS(USERNAMES, PASSWORDS, MOBILE_NUMBERS, EMAILIDS) VALUES (?,?,?,?)";
        String q1 = "SELECT USERNAMES from users where USERNAMES=?";
        connection = handler.getConnection();

        try {
            pst = connection.prepareStatement(insert);
            pst2 = connection.prepareStatement(q1);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
        
           // pst.setString(1, CUsername.getText());
            pst2.setString(1, CUsername.getText());
            int rs =  pst2.executeUpdate();
            if(rs != 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Username is already taken try another name");
                alert.show();
                Progress.setVisible(false);
            }else{
                pst.setString(1, CUsername.getText());
            }



            String p = Cpassword.getText();
            if(p.length() < 8){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Password Should be 8 digits long");
                alert.show();
                Progress.setVisible(false);
            }else{
                pst.setString(2, Cpassword.getText());
            }


            String temp = MobileNumber.getText();
            if(isValidMobile(temp)){
                pst.setString(3, temp);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Enter a Valid Mobile(Indian) Number");
                alert.show();
                Progress.setVisible(false);
            }

    
            String EmailText = null;
            EmailText = Email.getText();
            if(isValid(EmailText)){
                pst.setString(4, EmailText);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Enter a valid Email Address");
                alert.show();
                Progress.setVisible(false);
            }

            pst.executeUpdate();
            connection.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            Progress.setVisible(false);
        }
    }

    private boolean isValidMobile(String temp2) {
        String MobileRegex = "[6-9][0-9]{9}";
        Pattern pat2 = Pattern.compile(MobileRegex);
        if (temp2 == null){
            return false;
        }
        return pat2.matcher(temp2).matches();
    }

    private boolean isValid(String emailText2) {
          String EmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
          Pattern pat = Pattern.compile(EmailRegex);
          if(emailText2 == null){
            return false;
          }

        return pat.matcher(emailText2).matches();
    }

    @FXML
    void LOGINAction(ActionEvent event) {
        SignUP.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
            stage.show();
            stage.setResizable(false);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void CancelAction(ActionEvent event) {
       SignUP.getScene().getWindow().hide();
    }


}
