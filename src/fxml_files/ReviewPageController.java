package fxml_files;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ReviewPageController implements Initializable {

    @FXML
    private Button BackBtn;

    @FXML
    private TextArea Que1;

    @FXML
    private TextArea Que2;

    @FXML
    private TextArea Que3;

    @FXML
    private TextArea Que4;

    @FXML
    private TextArea Que5;

    @FXML
    private TextArea Que6;

    @FXML
    private Button Submit;

    @FXML
    private Button Cancel;

    private DatabaseHandler handler;
    private Connection connection;

    @FXML
    void BackAction(ActionEvent event) {
        Cancel.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TOYOTA_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Toyota Page");
            stage.show();
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.getStackTrace();
        }

    }

    @FXML
    void CancelAction(ActionEvent event) {
        Submit.getScene().getWindow().hide();
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
    void SubmitAction(ActionEvent event) {
        String user = LoginPageController.getInstance().Username1();
        String q1 = Que1.getText();
        String q2 = Que2.getText();
        String q3 = Que3.getText();
        String q4 = Que4.getText();
        String q5 = Que5.getText();
        String q6 = Que6.getText();
        String Query = "insert into Reviews_Table values(?,?,?,?,?,?,?)";
        int rs;

        try {
            PreparedStatement pst1 = connection.prepareStatement(Query);
            pst1.setString(1, user);
            pst1.setString(2, q1);
            pst1.setString(3, q2);
            pst1.setString(4, q3);
            pst1.setString(5, q4);
            pst1.setString(6, q5);
            pst1.setString(7, q6);
            rs = pst1.executeUpdate();
            if (rs == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Some error occurred and review not submitted.");
                alert.show();
            }
            if (rs == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("your review submitted successfully redirecting to home page.");
                alert.show();
                PauseTransition pt = new PauseTransition();
                pt.setDuration(Duration.seconds(3));
                pt.setOnFinished(e -> {
                    Submit.getScene().getWindow().hide();
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
                });
                pt.play();
            }

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        handler = new DatabaseHandler();
        connection = handler.getConnection();
    }

}
