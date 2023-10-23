package Frame.controller;

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
        TranslateTransition translate1 = effect.moveY(login,0.5,-500,0);
        translate1.setInterpolator(Interpolator.SPLINE(0.1,0.1,0.1,1));
        Transition transition = effect.switchPage(translate1,oldFrame,oldFrameBox);
        effect.set60fps(transition).play();
    }
    public void login() throws SQLException {
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
                tips.setText("登录成功");

            }
        }
    }
    public void reg() throws IOException {
        Stage stage = (Stage) btnReg.getScene().getWindow();
        RegisterFrameController.oldFrame = stage.getScene();
        stage.setScene(new RegisterFrame().Frame());
        stage.show();
    }
}
