package fxml_files;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfilePageController implements Initializable{

    
    @FXML
    private Button Save;

    
    @FXML
    private TextField UserN;

    @FXML
    void SwitchToAboutus(ActionEvent event) {
          
        Save.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutUsPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("About Us Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }


    }

    @FXML
    void SwitchToChangePass(ActionEvent event) {
        Save.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePasswordPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Change Password Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToContact(ActionEvent event) {
         
        Save.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContactUsPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Contact Us Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToLogin(ActionEvent event) {
        Save.getScene().getWindow().hide();

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

    public void setUsername(String User){
        this.UserN.setText(User);
     }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setUsername(LoginPageController.getInstance().Username1());
    }

    @FXML
    void SwitchToHome(ActionEvent event) {
          Save.getScene().getWindow().hide();

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

}
