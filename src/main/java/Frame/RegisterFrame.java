package Frame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class RegisterFrame {
    public Scene Frame() throws IOException {
        StackPane root = FXMLLoader.load(getClass().getResource("../fxml/RegisterFrame.fxml"));
        return new Scene(root);
    }
}
