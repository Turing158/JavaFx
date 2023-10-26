package Frame.controller;

import Frame.HomeFrame;
import Frame.RegisterFrame;
import Frame.StartFrame;
import com.sun.scenario.animation.SplineInterpolator;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.StudentService;
import util.EffectAnimation;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFrameController {
    private Timeline timeline;
    static Scene oldFrame;
    @FXML
    VBox oldFrameBox;
    @FXML
    VBox login;
    @FXML
    Text title;
    @FXML
    TextField user;
    @FXML
    TextField password;
    @FXML
    Button btnLogin;
    @FXML
    Button btnReg;
    @FXML
    VBox blur;
    @FXML
    Text tips;
    @FXML
    public void initialize() {
        EffectAnimation effect = new EffectAnimation();
        effect.switchPage(login,0.5,-500,0,oldFrame,oldFrameBox);
    }
    public void login() throws SQLException, IOException {
        boolean needTips = true;
        if(timeline != null){
            timeline.stop();
        }
        EffectAnimation effect = new EffectAnimation();
        timeline = effect.fadeEffect(tips,0.3,2);
        if(user.getText().isEmpty() || password.getText().isEmpty()){
            tips.setText("请输入用户名和密码");
        }
        else {
            StudentService studentService = new StudentService();
            String state = studentService.LoginVerify(user.getText(),password.getText());
            if(state.equals("userError")){
                tips.setText("用户不存在");
            }
            else if(state.equals("passwordError")){
                tips.setText("密码错误");
            }
            else if(state.equals("success")){
                needTips = false;
                Stage stage = (Stage) title.getScene().getWindow();
                HomeFrameController.oldFrame = stage.getScene();
                stage.setScene(new HomeFrame().Frame());
                stage.show();
            }
        }
        if(needTips){
            timeline.play();
        }
    }
    public void reg() throws IOException {
        Stage stage = (Stage) btnReg.getScene().getWindow();
        RegisterFrameController.oldFrame = stage.getScene();
        stage.setScene(new RegisterFrame().Frame());
        stage.show();
    }
}
