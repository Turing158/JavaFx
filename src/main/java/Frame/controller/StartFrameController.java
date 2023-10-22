package Frame.controller;

import Frame.LoginFrame;
import Frame.MainStage;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class StartFrameController {
    @FXML
    Text text1;
    @FXML
    Text text2;
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    Text text3;
    public void start() throws IOException {
        Stage stage = (Stage) text1.getScene().getWindow();
        stage.setScene(new LoginFrame().Frame());
        stage.show();
    }
    public void flower() {
        text3.setText("你点花干嘛");
    }
    public void bar(){
        text3.setText("喜欢动我火把？");
    }
}
