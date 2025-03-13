package fxml_files;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginPageController implements Initializable {

  @FXML
  private TextField Username;

  @FXML
  private PasswordField Password;

  @FXML
  private Button SignUP;

  @FXML
  private Button Login;

  @FXML
  private Button Cancel;

  @FXML
  private Button Forgot;

  @FXML
  private ImageView Progress1;

  private static LoginPageController instance;

  private DatabaseHandler handler;
  private Connection connection;

  public LoginPageController() {
    instance = this;
  }

  public static LoginPageController getInstance() {
    return instance;
  }

  public String Username1() {
    return Username.getText();
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    Progress1.setVisible(false);
    handler = new DatabaseHandler();
  }

  @FXML
  public void LoginAction(ActionEvent event) {
    Progress1.setVisible(true);
    PauseTransition pt = new PauseTransition();
    pt.setDuration(Duration.seconds(4));
    pt.setOnFinished(e -> {

      // retrieving data from database
      connection = handler.getConnection();
      String user = Username.getText();
      String pass = Password.getText();
      String pass2 = " ";
      PreparedStatement pst1;
      PreparedStatement pst2;
      int a;
      ResultSet rs;
      String q1 = "SELECT USERNAMES,PASSWORDS FROM USERS WHERE USERNAMES=?";
      try {
        pst1 = connection.prepareStatement(q1);
        pst1.setString(1, user);
        pst2 = connection.prepareStatement(q1);
        pst2.setString(1, user);
        a = pst1.executeUpdate();

        if (a == 0) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setHeaderText(null);
          alert.setContentText("User does not exist SignUp first.");
          alert.show();
          Progress1.setVisible(false);
        }
        if (a == 1) {
          rs = pst2.executeQuery();
          if (rs.next()) {
            pass2 = rs.getString(2);
          }
          if (pass2.equals(pass) == false || pass2.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Password is wrong try again.");
            alert.show();
            Progress1.setVisible(false);
          }
          if (pass2.equals(pass)) {
            SignUP.getScene().getWindow().hide();

            try {

              FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
              Parent root = loader.load();
              loader.getController();
              Stage stage = new Stage();
              stage.setScene(new Scene(root));
              stage.setTitle("Home Page");
              stage.show();
              stage.setResizable(false);

            } catch (Exception e1) {
              e1.printStackTrace();
            }
          }
        }

      } catch (SQLException e1) {
        e1.printStackTrace();
      }

    });

    pt.play();

  }

  @FXML
  public void SignUpAction(ActionEvent event) throws IOException {
    Login.getScene().getWindow().hide();

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

  @FXML
  void CancelAction(ActionEvent event) {
    Login.getScene().getWindow().hide();
  }

  @FXML
  void SwitchToForgot(ActionEvent event) {
    SignUP.getScene().getWindow().hide();

    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotPasswordPage.fxml"));
      Parent root = loader.load();
      loader.getController();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.setTitle("Forgot Password Page");
      stage.show();
      stage.setResizable(false);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
