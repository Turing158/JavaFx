import Frame.MainStage;
import dao.StudentDaoImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainStage mainStage = new MainStage();
        mainStage.start(primaryStage);
        StudentDaoImpl studentDao = new StudentDaoImpl();
    }
}
