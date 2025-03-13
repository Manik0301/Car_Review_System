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

public class VWPageController implements Initializable {

    @FXML
    private Button Jetta;

    @FXML
    private Button POLO;

    @FXML
    private Button Virtus;

    @FXML
    private Button Vento;

    @FXML
    private Button HomeBtn;

    @FXML
    void ReturnHome(ActionEvent event) {
        Vento.getScene().getWindow().hide();
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
    void SwitchToJetta(ActionEvent event) {

        Vento.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VWJettaPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Jetta Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToPolo(ActionEvent event) {

        Vento.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VWPoloPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Polo Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToVento(ActionEvent event) {

        POLO.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VWVentoPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Vento Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void SwitchToVirtus(ActionEvent event) {

        Vento.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VWVirtusPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Virtus Page");
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
