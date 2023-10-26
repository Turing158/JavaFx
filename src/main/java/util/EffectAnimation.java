package util;

import com.sun.scenario.animation.SplineInterpolator;
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
    public void fadeEmergeVanish(Node node,double seconds,boolean emerge){
        FadeTransition fade = new FadeTransition(Duration.seconds(seconds),node);
        if(emerge){
            fade.setFromValue(0);
            fade.setToValue(1);
        }
        else{
            fade.setFromValue(1);
            fade.setToValue(0);
        }
        set60fps(fade).play();
    }
//    用于元素的横向移动
    public TranslateTransition moveX(Node node,double seconds,double from,double to){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(seconds),node);
        translate.setFromX(from);
        translate.setToX(to);
        translate.setInterpolator(new SplineInterpolator(0.1,0.1,0.1,1));
        return translate;
    }
//    用于元素的纵向移动
    public TranslateTransition moveY(Node node,double seconds,double from,double to){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(seconds),node);
        translate.setFromY(from);
        translate.setToY(to);
        translate.setInterpolator(new SplineInterpolator(0.1,0.1,0.1,1));
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
    public void switchPage(Node node,double seconds,double from,double to,Scene oldFrame, VBox oldFrameBox){
        TranslateTransition translate = moveY(node,seconds,from,to);
        translate.setInterpolator(new SplineInterpolator(0.1,0.1,0.1,1));
        oldFrameBox.getChildren().add(oldFrame.getRoot());
        translate.setOnFinished(event -> {
            oldFrameBox.getChildren().remove(oldFrame.getRoot());
        });
        set60fps(translate).play();
    }
    public Transition rotate(Node node,double seconds,double from,double to){
        RotateTransition rotate = new RotateTransition(Duration.seconds(seconds),node);
        rotate.setFromAngle(from);
        rotate.setToAngle(to);
        rotate.setInterpolator(new SplineInterpolator(0.1,0.1,0.1,1));
        return rotate;
    }
//    用于停止动画
    public void stopAnimation(Transition transition){
        transition.stop();
    }
}
