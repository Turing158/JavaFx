package Frame.controller;

import Frame.LoginFrame;
import entity.Student;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.StudentService;
import util.EffectAnimation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

public class RegisterFrameController {
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
    TextField name;
    @FXML
    Button btnLogin;
    @FXML
    Button btnReg;
    @FXML
    ComboBox<String> gender;
    @FXML
    ComboBox<String> classname;
    @FXML
    VBox blur;
    @FXML
    Text tips;
    @FXML
    public void initialize(){
        gender.setItems(FXCollections.observableArrayList("男","女"));
        classname.setItems(FXCollections.observableArrayList("class_1","class_2","class_3","class_4","class_5","class_6","class_7","class_8"));
        EffectAnimation effect = new EffectAnimation();
        TranslateTransition translate1 = effect.moveY(reg,0.5,-500,0);
        translate1.setInterpolator(Interpolator.SPLINE(0.1,0.1,0.1,1));
        Transition transition = effect.switchPage(translate1,oldFrame,oldFrameBox);
        effect.set60fps(transition).play();
    }
    public void reg() throws SQLException {
        Student student = new Student(Integer.parseInt(user.getText()),name.getText(),password.getText(),classname.getValue(),gender.getValue(),0,"");
        StudentService studentService = new StudentService();
        String state = studentService.RegOperate(student);
    }
    public void login() throws IOException {
        Stage stage = (Stage) title.getScene().getWindow();
        LoginFrameController.oldFrame = stage.getScene();
        stage.setScene(new LoginFrame().Frame());
        stage.show();
    }
}
