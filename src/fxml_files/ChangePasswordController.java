package fxml_files;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
import javafx.util.Duration;

public class ChangePasswordController implements Initializable {

    @FXML
    private Button LOGIN;

    @FXML
    private TextField Username;

    @FXML
    private Button ChangPass;

    @FXML
    private Button HomeBTn;

    @FXML
    private PasswordField Prevpassword;

    @FXML
    private PasswordField NewPassword;

    @FXML
    private PasswordField Confirm;

    private Connection con;
    private DatabaseHandler handle;
    private PreparedStatement pst;
    private PreparedStatement pst2;
    private PreparedStatement pst3;

    
    @FXML
    void ReturnToHome(ActionEvent event) {
        ChangPass.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Home Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }

    }

    @FXML
    void ChangePassAction(ActionEvent event) {
       int a1=0;
       int a2=0;
       int a3=0;
       String query1 = "SELECT USERNAMES,PASSWORDS FROM USERS WHERE USERNAMES=(?)";
       String query2 = "UPDATE USERS SET PASSWORDS=(?) WHERE USERNAMES=(?)";
       String oldp = Prevpassword.getText();
       String newp = NewPassword.getText();
       String Conf = Confirm.getText();
       try {
        pst = con.prepareStatement(query1);
        pst.setString(1, Username.getText());
        pst2 = con.prepareStatement(query1);
        pst2.setString(1, Username.getText());
        int rs= pst.executeUpdate();
        ResultSet rs1 = pst2.executeQuery();
        if (rs == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Username is wrong try again.");
            alert.show();
            a1 += 1;
        }
       
        if(newp.length() <8){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("new Password Should be 8 digits long.");
            alert.show();
            a2+=1;
        }
        String p2="";
        if(rs1.next()){
            p2 = rs1.getString(2);
        }
            if ( p2.equals(oldp) != true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Old Password is wrong try again.");
                alert.show();
                a2+=1;
            }
        if (newp.equals(Conf) != true){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("new Password and Confirmation does not match or old password is the same as new password try again .");
            alert.show();
            a3+=1;
       }
        if (a1==0 && a2==0 && a3==0){
            pst3 = con.prepareStatement(query2);
            pst3.setString(1, newp);
            pst3.setString(2, Username.getText());
            int a4 = pst3.executeUpdate();
            if( a4 == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Something went wrong try after some time.");
                alert.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Password changed successfully redirecting to login page.");
                alert.show();
                con.commit();
                PauseTransition pt =new PauseTransition();
                pt.setDuration(Duration.seconds(3));
                pt.setOnFinished( e -> {LOGINAction(event); });
                pt.play();
               
            }
           
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @FXML
    void LOGINAction(ActionEvent event) {
        ChangPass.getScene().getWindow().hide();
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        handle = new DatabaseHandler();
        con=handle.getConnection();
    }

}