package photoapp;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.function.Consumer;

public class UploadWindow {
    public static void show(Stage owner, Consumer<Post> onPostCreated) {
        Stage dialog = new Stage();
        dialog.initOwner(owner);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Upload Post");

        Button chooseBtn = new Button("Upload Image");
        ImageView imgView = new ImageView();
        imgView.setFitWidth(250);
        imgView.setFitHeight(180);
        imgView.setPreserveRatio(true);

        final Image[] selectedImg = new Image[1];
        chooseBtn.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(dialog);
            if (file != null) {
                selectedImg[0] = new Image(file.toURI().toString());
                imgView.setImage(selectedImg[0]);
            }
        });

        TextField captionField = new TextField();
        captionField.setPromptText("Caption");

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            if (selectedImg[0] != null && !captionField.getText().isEmpty()) {
                Post post = new Post(captionField.getText(), selectedImg[0]);
                onPostCreated.accept(post);
                dialog.close();
            }
        });

        VBox layout = new VBox(10,
                chooseBtn, imgView,
                captionField,
                submit);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #fce4ec;");
        chooseBtn.setStyle("-fx-background-color: #f06292; -fx-text-fill: white;");
        submit.setStyle("-fx-background-color: #f06292; -fx-text-fill: white;");

        dialog.setScene(new Scene(layout, 300, 400));
        dialog.showAndWait();
    }
}