package Frame.controller;

import Frame.LoginFrame;
import entity.Student;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.StudentService;
import util.EffectAnimation;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Observable;

public class RegisterFrameController {
    private Timeline timeline;
    static Scene oldFrame;
    @FXML
    VBox oldFrameBox;
    @FXML
    VBox reg;
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
    ComboBox<String> gender;
    @FXML
    ComboBox<String> classname;
    @FXML
    ComboBox<Integer> year;
    @FXML
    ComboBox<Integer> month;
    @FXML
    ComboBox<Integer> day;
    @FXML
    VBox blur;
    @FXML
    Text tips;
    @FXML
    public void initialize(){
        for(int i = 1;i <= 31;i++){
            day.getItems().add(i);
        }
        for(int i = 1;i <= 12;i++){
            month.getItems().add(i);
        }
        for(int i = 1970;i <= 2023;i++){
            year.getItems().add(i);
        }
        gender.setItems(FXCollections.observableArrayList("男","女"));
        classname.setItems(FXCollections.observableArrayList("class_1","class_2","class_3","class_4","class_5","class_6","class_7","class_8"));
        EffectAnimation effect = new EffectAnimation();
        TranslateTransition translate1 = effect.moveY(reg,0.5,-500,0);
        translate1.setInterpolator(Interpolator.SPLINE(0.1,0.1,0.1,1));
        Transition transition = effect.switchPage(translate1,oldFrame,oldFrameBox);
        effect.set60fps(transition).play();
    }
    public void reg() throws SQLException {
        if(timeline != null){
            timeline.stop();
        }
        EffectAnimation effect = new EffectAnimation();
        timeline = effect.fadeEffect(tips,0.3,2);
        if(user.getText().isEmpty()){
            tips.setText("用户名不能为空");
        }
        else if (password.getText().isEmpty()){
            tips.setText("密码不能为空");
        }
        else if(password.getText().length() < 6){
            tips.setText("密码不能小于6位");
        }
        else if(gender.getValue() == null){
            tips.setText("请选择性别");
        }
        else if(classname.getValue() == null){
            tips.setText("请选择班级");
        }
        else if(year.getValue() == null || month.getValue() == null || day.getValue() == null){
            tips.setText("请填写完整的出生日期");
        }
        else {
            LocalDate date = LocalDate.of(year.getValue(),month.getValue(),day.getValue());
            Student student = new Student(Integer.parseInt(user.getText()),"**同学",password.getText(),classname.getValue(),gender.getValue(),0,date.toString());
            StudentService studentService = new StudentService();
            String state = studentService.RegOperate(student);
            if(state.equals("userError")){
                tips.setText("该用户已存在");
            }
            else{
                tips.setText("注册成功");
            }
        }
        timeline.play();
    }
    public void login() throws IOException {
        Stage stage = (Stage) title.getScene().getWindow();
        LoginFrameController.oldFrame = stage.getScene();
        stage.setScene(new LoginFrame().Frame());
        stage.show();
    }
}
