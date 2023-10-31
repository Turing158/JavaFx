package Frame.controller;

import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    HBox exit;
    @FXML
    Text exitText;


    public void openMenu(Node Head, Node Menu){
        EffectAnimation effect = new EffectAnimation();
        timeline = effect.set60fps(effect.moveX(Menu,0.3,-140,0));
        timeline.play();
        Transition headMove = effect.moveX(Head,0.15,5,10);
        headMove.setOnFinished(event -> {
            effect.moveX(Head,0.15,10,5).play();
        });
        effect.fadeEmergeVanish(name,0.5,true);
        effect.fadeEmergeVanish(id,0.5,true);
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
        effect.fadeEmergeVanish(name,0.1,false);
        effect.fadeEmergeVanish(id,0.1,false);
        headMove.play();
    }
}
