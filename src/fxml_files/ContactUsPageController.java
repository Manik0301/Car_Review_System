package fxml_files;

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

public class ContactUsPageController implements Initializable{
    
    
    @FXML
    private Button Homebtn;

    @FXML
    void HomeClicked(ActionEvent event) {
       
        Homebtn.getScene().getWindow().hide();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Home Page");
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
