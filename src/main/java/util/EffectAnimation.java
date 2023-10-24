package util;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class EffectAnimation {
//    用于元素的淡入淡出
    public Timeline fadeEffect(Node node,double seconds,double waitTime){
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
        return timeline;
    }
//    用于元素的横向移动
    public TranslateTransition moveX(Node node,double seconds,double from,double to){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(seconds),node);
        translate.setFromX(from);
        translate.setToX(to);
        return translate;
    }
//    用于元素的纵向移动
    public TranslateTransition moveY(Node node,double seconds,double from,double to){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(seconds),node);
        translate.setFromY(from);
        translate.setToY(to);
        return translate;
    }
//    用于元素动画设置成60帧
    public Timeline set60fps(Transition transition){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(8),e->{
            transition.play();
        }));
        return timeline;
    }
//    用于页面切换
    public Transition switchPage(Transition transition, Scene oldFrame, VBox oldFrameBox){
        oldFrameBox.getChildren().add(oldFrame.getRoot());
        transition.setOnFinished(event -> {
            oldFrameBox.getChildren().remove(oldFrame.getRoot());
        });
        return transition;
    }
    public void stopAnimation(Transition transition){
        transition.stop();
    }
}
