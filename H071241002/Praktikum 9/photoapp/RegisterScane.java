package photoapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.layout.*;
import java.io.File;
import javafx.scene.control.Alert;

public class RegisterScane {
    public static void show(Stage stage) {
        Label titleLabel = new Label("PINKSNAP");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #880e4f;");

        Label nickLabel = new Label("Nick Name");
        TextField nickField = new TextField();
        nickField.setPromptText("Enter your nickname");

        Label fullLabel = new Label("Full Name");
        TextField fullField = new TextField();
        fullField.setPromptText("Enter your full name");

        Label imgLabel = new Label("Upload Foto Profil");
        Button uploadButton = new Button("TOMBOL UPLOAD");
        uploadButton.setStyle("-fx-background-color: #f06292; -fx-text-fill: white;");

        ImageView imageView = new ImageView();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        imageView.setPreserveRatio(false);
        Circle clip = new Circle(60, 60, 60);
        imageView.setClip(clip);

        final Image[] selectedImage = new Image[1];
        uploadButton.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(stage);
            if (file != null) {
                selectedImage[0] = new Image(file.toURI().toString());
                imageView.setImage(selectedImage[0]);
            }
        });

        Button submitButton = new Button("SUBMIT");
        submitButton.setStyle("-fx-background-color: #f06292; -fx-text-fill: white;");

        submitButton.setOnAction(e -> {
            if (nickField.getText().isEmpty() || fullField.getText().isEmpty() || selectedImage[0] == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields and upload a profile picture.");
                alert.showAndWait();
            } else {
                App.currentUser = new User(nickField.getText(), fullField.getText(), selectedImage[0]);
                HomeScane.show(stage);
            }
        });

        VBox container = new VBox(10,
                titleLabel,
                new Label("Input User Account"),
                nickLabel, nickField,
                fullLabel, fullField,
                imgLabel, uploadButton,
                imageView,
                submitButton);
        container.setPadding(new Insets(20));
        container.setStyle("""
                    -fx-background-color: transparent;
                """);

        VBox root = new VBox(container);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #fce4ec;"); // Pink background utama

        stage.setTitle("MyMoment - Register");
        stage.setScene(new Scene(root, 450, 600));
        stage.show();
    }
}