package Frame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class StartFrame {
    public static Text text1;

    public Scene Frame() throws IOException {
        StackPane root = FXMLLoader.load(getClass().getResource("../fxml/StartFrame.fxml"));
        return new Scene(root);
    }
}
