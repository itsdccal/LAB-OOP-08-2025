package photoapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static User currentUser;

    @Override
    public void start(Stage primaryStage) {
        RegisterScane.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
