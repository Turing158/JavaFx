package util;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class EffectAnimation {
    public void fadeEffect(Node node,double seconds,double waitTime){
        FadeTransition fadeFirst = new FadeTransition(Duration.seconds(seconds),node);
        fadeFirst.setFromValue(0);
        fadeFirst.setToValue(1);
        FadeTransition fadeFinish = new FadeTransition(Duration.seconds(seconds),node);
        fadeFinish.setFromValue(1);
        fadeFinish.setToValue(0);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),e-> {
                    node.setVisible(true);
                    node.setOpacity(0);
                    fadeFirst.play();
                }),
                new KeyFrame(Duration.seconds(waitTime),e-> {
                    fadeFinish.play();
                })
        );
        timeline.play();
    }
}
