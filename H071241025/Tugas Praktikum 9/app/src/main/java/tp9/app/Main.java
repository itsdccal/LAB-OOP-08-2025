package tp9.app;

import tp9.controller.RegisterScene;
import tp9.controller.HomeScene;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        RegisterScene registerScene = new RegisterScene();

        Scene scene = registerScene.regist(primaryStage, user -> {
            HomeScene homeScene = new HomeScene();
            Scene home = homeScene.createHomeScene(primaryStage, user);
            primaryStage.setScene(home);
        });
    
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyMoment");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 