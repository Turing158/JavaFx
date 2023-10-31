package Frame.controller;

import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import util.EffectAnimation;

import java.io.InputStream;

public class HomeFrameController {
    @FXML
    private MenuController menuController;
    static Scene oldFrame;
    Timeline timeline;
    boolean isOpenMenu = false;
    @FXML
    VBox oldFrameBox;
    @FXML
    VBox home;
    @FXML
    VBox main;
    @FXML
    VBox menu;
    @FXML
    ImageView head;

    @FXML
    public void initialize() {
        headInit();
        EffectAnimation effect = new EffectAnimation();
        effect.switchPage(home,0.5,-500,0,oldFrame,oldFrameBox);
    }
    public void headInit(){
        head.setClip(new Circle(head.getFitWidth()/2,head.getFitHeight()/2,25));
        InputStream stream = getClass().getResourceAsStream("/img/head.jpg");
        if(stream != null) {
            Image headImg = new Image(stream);
            head.setImage(headImg);
        }
        head.toFront();
    }
    public void headAction(){
        if(!isOpenMenu){
            isOpenMenu = true;
            menuController.openMenu(head,menu);
        }else{
            System.out.println("alreadyOpenMenu");
        }
    }
    public void closeMenu(){
        if(isOpenMenu){
            isOpenMenu = false;
            menuController.closeMenu(head,menu);
        }else{
            System.out.println("alreadyCloseMenu");
        }
    }

}
