package fxml_files;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ForgotPageController implements Initializable {

    @FXML
    private Button SignUP;

    @FXML
    private TextField Username;

    @FXML
    private TextField Email;

    @FXML
    private Button ResetPass;

    @FXML
    private Button Cancel;

    @FXML
    private Button LOGIN;

    @FXML
    private PasswordField NewPassword;

    private Connection Con;
    private DatabaseHandler handler;

    @FXML
    void CancelAction(ActionEvent event) {
        LOGIN.getScene().getWindow().hide();
    }

    @FXML
    void LOGINAction1(ActionEvent event) {
        SignUP.getScene().getWindow().hide();
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

    @FXML
    void ResetAction(ActionEvent event) {
        int rs;
        ResultSet rs1;
        String q1 = "SELECT USERNAMES,EMAILIDS FROM USERS WHERE USERNAMES=?";
        String user = Username.getText();
        String mail = Email.getText();
        String b = "";
        try {
            PreparedStatement pst = Con.prepareStatement(q1);
            PreparedStatement pst1 = Con.prepareStatement(q1);
            pst.setString(1, user);
            pst1.setString(1, user);
            rs = pst.executeUpdate();
            if (rs == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("User id is wrong try again.");
                alert.show();
            }
            if (rs == 1) {
                rs1 = pst1.executeQuery();
                if (rs1.next()) {
                    b = rs1.getString(2);
                }

                if (mail.isEmpty() || mail.equals(b) == false) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Email does not match with user's database.");
                    alert.show();
                }
                if (mail.equals(b)) {
                    String newp = NewPassword.getText();
                    if (newp.length() < 8) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("Password should be 8 digits long.");
                        alert.show();
                    }
                    String c = "UPDATE USERS SET PASSWORDS=(?) WHERE USERNAMES=(?)";
                    PreparedStatement pst2 = Con.prepareStatement(c);
                    pst2.setString(1, newp);
                    pst2.setString(2, user);
                    int d = pst2.executeUpdate();
                    if (d == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("Something went wrong.");
                        alert.show();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("Password reset succcessfully redirecting to login page.");
                        alert.show();
                        Con.commit();
                        PauseTransition pt = new PauseTransition();
                        pt.setDuration(Duration.seconds(3));
                        pt.setOnFinished(e -> {
                            LOGINAction1(event);
                        });
                        pt.play();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SignUpAction2(ActionEvent event) {
        LOGIN.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SignUP Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        handler = new DatabaseHandler();
        Con = handler.getConnection();
    }

}