package Frame.controller;

import Frame.LoginFrame;
import Frame.MainStage;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.EffectAnimation;

import java.io.IOException;


public class StartFrameController {
    private Timeline timeline;
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
    VBox tips;
    @FXML
    Text text3;

    public void start() throws IOException {
        Stage stage = (Stage) text1.getScene().getWindow();
        LoginFrameController.oldFrame = stage.getScene();
        stage.setScene(new LoginFrame().Frame());
        stage.show();
    }
    public void flower() {
        stopTimeLine();
        EffectAnimation effect = new EffectAnimation();
        text3.setText("你点花干嘛!");
        tips.setMaxWidth(110);
        timeline = effect.fadeEffect(tips,0.3,2);
        timeline.play();
    }
    public void bar(){
        stopTimeLine();
        EffectAnimation effect = new EffectAnimation();
        timeline = effect.fadeEffect(tips,0.3,2);
        text3.setText("喜欢动我火把?");
        tips.setMaxWidth(140);
        timeline.play();
    }
    public void stopTimeLine(){
        if(timeline != null){
            timeline.stop();
        }
    }
}
