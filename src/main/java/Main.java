import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        primaryStage.setTitle("Expense");
        primaryStage.setScene(new Scene(root, 900, 650));
        //primaryStage.setScene(new Scene(root, 1100, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
