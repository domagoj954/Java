package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;


public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label info;

    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {
        if(username.getText().equalsIgnoreCase("admin") && password.getText().equalsIgnoreCase("12345")){
            ScreenController sc = new ScreenController();
            try {
                sc.switchToSceneStart(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            info.setText("Wrong input, wrong username or password");
        }

    }

}
