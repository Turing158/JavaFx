package Frame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainStage extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image("./img/starfall.png"));
        stage.setTitle("Starfall");
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setScene(new StartFrame().Frame());
        stage.setResizable(false);
        stage.show();
    }
}
