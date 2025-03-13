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
import javafx.scene.image.ImageView;

public class VWCarsController implements Initializable {

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    
    @FXML
    private Button RtnBtn;

    @FXML
    private ImageView img1;
    
    @FXML
    private Button ReviewBtn;

    @FXML
    void RtnHome(ActionEvent event) {
        img1.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VolksWagen_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("VolksWagen Cars Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }

    }

    
    @FXML
    void SwitchToReview(ActionEvent event) {
        img1.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("review.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Review Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
           e1.getStackTrace();
        }
    }
}
