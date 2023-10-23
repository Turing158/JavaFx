package Frame.controller;

import Frame.LoginFrame;
import Frame.MainStage;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.EffectAnimation;

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
        EffectAnimation effect = new EffectAnimation();
        text3.setText("你点花干嘛");
        effect.fadeEffect(text3,0.3,2);
    }
    public void bar(){
        EffectAnimation effect = new EffectAnimation();
        text3.setText("喜欢动我火把？");
        effect.fadeEffect(text3,0.3,2);
    }
}
