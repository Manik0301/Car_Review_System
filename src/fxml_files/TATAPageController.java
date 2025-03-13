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

public class TATAPageController implements Initializable {

    @FXML
    private Button Altroz;

    @FXML
    private Button Tiago;

    @FXML
    private Button Stardust;

    @FXML
    private Button Nexon;

    @FXML
    private Button Homebtn;

    @FXML
    void ReturnHome(ActionEvent event) {
        Nexon.getScene().getWindow().hide();
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
    void SwitchToAltroz(ActionEvent event) {

        Tiago.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ALtrozXZPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Altroz Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToNexon(ActionEvent event) {

        Tiago.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TATANexonPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Nexon Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }


    }

    @FXML
    void SwitchToStardust(ActionEvent event) {

        Tiago.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TATASafari.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Safari Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }


    }

    @FXML
    void SwitchToTiago(ActionEvent event) {

        Stardust.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TiagoPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Tiago Page");
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
