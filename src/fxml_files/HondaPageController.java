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

public class HondaPageController implements Initializable {

    @FXML
    private Button Amaze;

    @FXML
    private Button Elevate;

    @FXML
    private Button Jazz;

    @FXML
    private Button City;

    @FXML
    private Button HomeBtn;

    @FXML
    void ReturnHome(ActionEvent event) {
        Jazz.getScene().getWindow().hide();
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
    void SwitchToCity(ActionEvent event) {

        Elevate.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HondaCityPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Honda City Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToElevate(ActionEvent event) {

        Amaze.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HondaElevatePage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Elevate Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToJazz(ActionEvent event) {

        Elevate.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HondaJazzPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Jazz Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwithToAmaze(ActionEvent event) {

        Elevate.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HondaAmazePage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Amaze Page");
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
