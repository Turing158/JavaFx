package Frame.controller;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import util.EffectAnimation;

import java.io.InputStream;

public class HomeFrameController {
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
    ImageView head;
    @FXML
    VBox menu;
    @FXML
    Text name;
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
            EffectAnimation effect = new EffectAnimation();
            timeline = effect.set60fps(effect.moveX(menu,0.3,-140,0));
            timeline.play();
            Transition headMove = effect.moveX(head,0.15,5,10);
            headMove.setOnFinished(event -> {
                effect.moveX(head,0.15,10,5).play();
            });
            effect.fadeEmergeVanish(name,0.5,true);
            headMove.play();
        }else{
            System.out.println("alreadyOpenMenu");
        }
    }
    public void closeMenu(){
        if(isOpenMenu){
            isOpenMenu = false;
            EffectAnimation effect = new EffectAnimation();
            timeline = effect.set60fps(effect.moveX(menu,0.3,0,-140));
            timeline.play();
            Transition headMove = effect.moveX(head,0.15,5,2);
            headMove.setOnFinished(event -> {
                effect.moveX(head,0.15,2,5).play();
            });
            effect.fadeEmergeVanish(name,0.1,false);
            headMove.play();
        }else{
            System.out.println("alreadyCloseMenu");
        }
    }
}
