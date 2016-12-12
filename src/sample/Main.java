package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.entity.controllers.CpuController;
import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root=loader.load();
        primaryStage.setTitle("Automatic System");
        primaryStage.setScene(new Scene(root, 744, 592));
        primaryStage.setResizable(false);
        primaryStage.show();*/
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/cpu.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("CPU");
        primaryStage.setScene(new Scene(root,725,413));
        primaryStage.setResizable(false);
        primaryStage.show();
        Model model = new Model();
        View view = new View();
        CpuController controller=loader.getController();
        controller.setModelAndView(model,view);
        controller.process();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
