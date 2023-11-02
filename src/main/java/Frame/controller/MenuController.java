package Frame.controller;

import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util.EffectAnimation;

public class MenuController {
    Timeline timeline;
    @FXML
    VBox menu;
    @FXML
    Text name;
    @FXML
    Text id;
    @FXML
    Button self;
    @FXML
    Button setting;
    @FXML
    Button exit;



    public void openMenu(Node Head, Node Menu){
        EffectAnimation effect = new EffectAnimation();
        timeline = effect.set60fps(effect.moveX(Menu,0.3,-140,0));
        timeline.play();
        Transition headMove = effect.moveX(Head,0.15,5,10);
        headMove.setOnFinished(event -> {
            effect.moveX(Head,0.15,10,5).play();
        });
        effect.fadeEmergeVanish(0.5,true,name,id,self,setting,exit);
        headMove.play();
    }
    public void closeMenu(Node Head, Node Menu){
        EffectAnimation effect = new EffectAnimation();
        timeline = effect.set60fps(effect.moveX(Menu,0.3,0,-140));
        timeline.play();
        Transition headMove = effect.moveX(Head,0.15,5,2);
        headMove.setOnFinished(event -> {
            effect.moveX(Head,0.15,2,5).play();
        });
        effect.fadeEmergeVanish(0.1,false,name,id,self,setting,exit);
        headMove.play();
    }
}
