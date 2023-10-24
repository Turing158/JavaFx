package Frame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeFrame {
    public Scene Frame() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../fxml/HomeFrame.fxml"));
        return new Scene(root);
    }
}
