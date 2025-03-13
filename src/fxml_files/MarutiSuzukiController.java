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
import javafx.stage.Stage;

public class MarutiSuzukiController implements Initializable {

    @FXML
    private Button ALTO;

    @FXML
    private Button Baleno;

    @FXML
    private Button Brezza;

    @FXML
    private Button Swift;

    @FXML
    private Button Homebtn;

    @FXML
    void ReturnHome(ActionEvent event) {
        Swift.getScene().getWindow().hide();
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
    void SwitchToAlto(ActionEvent event) {
        Swift.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ALTO800Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Alto 800 Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }


    }

    @FXML
    void SwitchToBaleno(ActionEvent event) {

        Swift.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BalenoPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Baleno Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }


    }

    @FXML
    void SwitchToBrezza(ActionEvent event) {

        Swift.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BrezzaPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Brezza Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToSwift(ActionEvent event) {

        Brezza.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Swift_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Swift Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }


    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}