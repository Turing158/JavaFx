package Frame.controller;

import com.sun.scenario.animation.SplineInterpolator;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.util.Duration;
import service.StudentService;

import java.sql.SQLException;

public class LoginFrameController {
    @FXML
    VBox home;
    @FXML
    VBox login;
    @FXML
    Text text1;
    @FXML
    Text text2;
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
    public void initialize(){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.4),login);
        translate.setFromY(-500);
        translate.setToY(0);
        translate.setInterpolator(Interpolator.EASE_OUT);
        translate.play();
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
    public void reg(){
        System.out.println("Reg");
    }
}
