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
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private Text Welcome;

    @FXML
    private MenuItem ContactUsbtn;

    @FXML
    private Button About_Us;

    @FXML
    private MenuItem ContactUsbtn1;

    @FXML
    private Button profile;

    @FXML
    private Button Maruti_Suzuki;

    @FXML
    private Button VlkWagen;

    @FXML
    private Button Toyota;

    @FXML
    private Button TATA;

    @FXML
    private Button Hyundai;

    @FXML
    private Button Honda;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setUsername(LoginPageController.getInstance().Username1());
    }

    @FXML
    void SwitchToContact(ActionEvent event) {

        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContactUsPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Contact Us Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    @FXML
    void SwitchToAboutus(ActionEvent event) {

        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutUsPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("About Us Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    @FXML
    void SwitchToLogin(ActionEvent event) {

        Maruti_Suzuki.getScene().getWindow().hide();

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
    void SwitchToChangePass(ActionEvent event) {
        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePasswordPage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Change Password Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void setUsername(String User) {
        this.Welcome.setText(User);
    }

    @FXML
    void SwitchToProfile(ActionEvent event) {
        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profileapage.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToSuzuki(ActionEvent event) {
        Hyundai.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Maruti_Suzuki.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Maruti Suzuki Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToToyota(ActionEvent event) {
        Hyundai.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TOYOTA_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("TOYOTA Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToHyundai(ActionEvent event) {
        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Hyundai_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Hyundai Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToVW(ActionEvent event) {
        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VolksWagen_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Hyundai Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToTaTa(ActionEvent event) {
        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TATA_motors_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("TATA Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    void SwitchToHonda(ActionEvent event) {
        Maruti_Suzuki.getScene().getWindow().hide();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Honda_Page.fxml"));
            Parent root = loader.load();
            loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Honda Page");
            stage.show();
            stage.setResizable(false);

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
