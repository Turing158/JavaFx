package Frame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class LoginFrame {
    public Scene Frame() throws IOException {
        StackPane root = FXMLLoader.load(getClass().getResource("../fxml/LoginFrame.fxml"));
        return new Scene(root);
    }
}
