import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage args) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_files/LoginPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Login Page");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setResizable(false);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
