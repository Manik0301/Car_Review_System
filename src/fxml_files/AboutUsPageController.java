package fxml_files;

import java.io.IOException;
//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AboutUsPageController implements Initializable {

    @FXML
    private Button Homebtn2;

    @FXML
    private Label TEXT;

    @FXML
    private Button Contact_Us;

    @FXML
    void RtnHome(ActionEvent event) {

        TEXT.getScene().getWindow().hide();

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
    void SwitchToContact(ActionEvent event) {

        TEXT.getScene().getWindow().hide();

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

}
