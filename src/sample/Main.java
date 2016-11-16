package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root=loader.load();
        primaryStage.setTitle("Automatic System");
        primaryStage.setScene(new Scene(root, 744, 592));
        primaryStage.setResizable(false);
        primaryStage.show();
        //Model model = new Model();
        //View view = new View();
        Controller controller=loader.getController();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
