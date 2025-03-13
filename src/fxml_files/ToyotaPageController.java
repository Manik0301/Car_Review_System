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

public class ToyotaPageController implements Initializable {

    @FXML
    private Button Etios;

    @FXML
    private Button Fortuner;

    @FXML
    private Button Innova;

    @FXML
    private Button Cruiser;

    @FXML
    private Button HomeBtn;

    @FXML
    void ReturnHome(ActionEvent event) {
        Cruiser.getScene().getWindow().hide();
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
    void SwitchToCruiser(ActionEvent event) {

        Etios.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToyotaUrbanCPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Urban Cruiser Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }


    }

    @FXML
    void SwitchToEtios(ActionEvent event) {

        
        Fortuner.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToyotaEtiosPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Etios Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToFortuner(ActionEvent event) {

        
        Etios.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToyotaFortunerPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Fortuner Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToInnova(ActionEvent event) {

        
        Etios.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToyotaInnova.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Innova Page");
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