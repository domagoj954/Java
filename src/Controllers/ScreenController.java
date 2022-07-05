package Controllers;
import Utilities.AppConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.event.ActionEvent;
import java.util.logging.Logger;


public class ScreenController {
    static Logger log = Logger.getLogger(AppConstants.LOGGER_STRING);
    private Parent root;
    private Stage stage;

    public void switchToSceneStart(ActionEvent event) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("/Views/StartMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1111, 560));
            stage.show();
            log.info("Change start menu scene successfully!");
        } catch (Exception e) {
            log.warning("Change scene error" + e.getMessage());
        }
    }

    public void switchToSceneLogin(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            log.info("Change login scene successfully!");
        } catch (Exception e) {
            log.warning("Change scene error! " + e.getMessage());
        }
    }
}


