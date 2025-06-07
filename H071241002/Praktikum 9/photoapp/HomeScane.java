package photoapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HomeScane {
    private static final List<Post> posts = new ArrayList<>();
    private static TilePane postGrid;

    public static void show(Stage stage) {
        User user = App.currentUser;

        ImageView profileView = new ImageView(user.profileImage);
        profileView.setFitHeight(100);
        profileView.setFitWidth(100);
        profileView.setPreserveRatio(false);
        Circle profileClip = new Circle(50, 50, 50); // centerX, centerY, radius
        profileView.setClip(profileClip);

        Label nick = new Label(user.nickName);
        nick.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Label full = new Label(user.fullName);
        full.setStyle("-fx-font-size: 14px;");

        Button addPost = new Button("Add Post");
        addPost.setStyle("-fx-background-color: #f06292; -fx-text-fill: white;");
        addPost.setOnAction(e -> UploadWindow.show(stage, HomeScane::addPost));

        HBox topBar = new HBox(20, profileView, new VBox(10, nick, full, addPost));
        topBar.setPadding(new Insets(20));

        postGrid = new TilePane();
        postGrid.setPadding(new Insets(10));
        postGrid.setHgap(10);
        postGrid.setVgap(10);
        postGrid.setPrefColumns(3);

        ScrollPane scrollPane = new ScrollPane(postGrid);
        scrollPane.setFitToWidth(true);

        VBox root = new VBox(topBar, new Separator(), scrollPane);
        root.setStyle("-fx-background-color:rgb(240, 146, 177);");

        stage.setScene(new Scene(root, 600, 700));
        stage.setTitle("MyMoment");
        stage.show();
    }

    public static void addPost(Post post) {
        posts.add(post);

        ImageView imgView = new ImageView(post.image);
        imgView.setFitWidth(180);
        imgView.setFitHeight(180);
        imgView.setPreserveRatio(true);

        Label captionOverlay = new Label(post.caption);
        captionOverlay.setStyle("""
                    -fx-background-color: rgba(234, 146, 176, 0.8);
                    -fx-text-fill: white;
                    -fx-alignment: center;
                    -fx-font-size: 14px;
                    -fx-padding: 5;
                """);
        captionOverlay.setMaxWidth(Double.MAX_VALUE);
        captionOverlay.setMaxHeight(Double.MAX_VALUE);
        captionOverlay.setVisible(false);

        StackPane imageContainer = new StackPane(imgView, captionOverlay);
        imageContainer.setStyle("-fx-background-color: white; -fx-cursor: hand;");
        imageContainer.setOnMouseEntered(e -> {
            captionOverlay.setVisible(true);
            imageContainer.setScaleX(1.05);
            imageContainer.setScaleY(1.05);
            imageContainer.setStyle("""
                        -fx-effect: dropshadow(gaussian, rgba(240,98,146,0.6), 12, 0.4, 0, 4);
                        -fx-background-color:rgb(176, 127, 143);
                    """);
        });
        imageContainer.setOnMouseExited(e -> {
            captionOverlay.setVisible(false);
            imageContainer.setScaleX(1.0);
            imageContainer.setScaleY(1.0);
            imageContainer.setStyle("-fx-effect: none; -fx-background-color: white;");
        });

        imageContainer.setOnMouseClicked(e -> {
            showImageDetail(post.image);
        });

        postGrid.getChildren().add(imageContainer);
    }

    private static void showImageDetail(Image image) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Photo Detail");

        ImageView largeImage = new ImageView(image);
        largeImage.setPreserveRatio(true);
        largeImage.setFitWidth(600);

        StackPane pane = new StackPane(largeImage);
        pane.setStyle("-fx-background-color: #2c2c2c;");
        pane.setPadding(new Insets(20));

        Scene scene = new Scene(pane, 700, 500);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
}
