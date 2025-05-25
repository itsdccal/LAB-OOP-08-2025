package gradle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    private Stage primaryStage;
    private User currentUser;
    private File selectedImageFile;
    private File profileImageFile;
    private FlowPane postContainer = new FlowPane(10, 10);
    private ArrayList<Post> posts = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showRegisterScene();
    }

    private void showRegisterScene() {
        Label title = new Label("Register");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label nickLabel = new Label("Nick Name:");
        TextField nickField = new TextField();

        Label fullLabel = new Label("Full Name:");
        TextField fullField = new TextField();

        Button uploadBtn = new Button("Upload Profile Image");
        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            profileImageFile = fileChooser.showOpenDialog(primaryStage);
        });

        Button registerBtn = new Button("Register");
        registerBtn.setOnAction(e -> {
            String nick = nickField.getText();
            String full = fullField.getText();
            if (!nick.isEmpty() && !full.isEmpty() && profileImageFile != null) {
                currentUser = new User(nick, full, new Image(profileImageFile.toURI().toString()));
                showHomeScene();
            } else {
                showAlert("Please fill all fields and upload a profile image.");
            }
        });

        VBox layout = new VBox(10, title, nickLabel, nickField, fullLabel, fullField, uploadBtn, registerBtn);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Register");
        primaryStage.show();
    }

    private void showHomeScene() {
        Label title = new Label("Welcome to MediaShare!");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ImageView profileView = new ImageView(currentUser.profileImage);
        profileView.setFitWidth(100);
        profileView.setFitHeight(100);

        Label nickLabel = new Label("Nickname: " + currentUser.nickName);
        Label fullLabel = new Label("Full Name: " + currentUser.fullName);

        Button addPostBtn = new Button("Add Post");
        addPostBtn.setOnAction(e -> showUploadPostScene());

        HBox profileBox = new HBox(20, profileView, new VBox(5, nickLabel, fullLabel, addPostBtn));
        profileBox.setAlignment(Pos.CENTER_LEFT);
        profileBox.setPadding(new Insets(10));

        postContainer.getChildren().clear();
        for (Post post : posts) {
            ImageView imageView = new ImageView(post.image);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
            Tooltip.install(imageView, new Tooltip(post.caption));
            postContainer.getChildren().add(imageView);
        }

        ScrollPane scrollPane = new ScrollPane(postContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(10));

        VBox layout = new VBox(10, title, profileBox, scrollPane);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 600, 500);
        primaryStage.setScene(scene);
    }

    private void showUploadPostScene() {
        Label captionLabel = new Label("Caption:");
        TextField captionField = new TextField();

        Button imageBtn = new Button("Upload Image");
        imageBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            selectedImageFile = fileChooser.showOpenDialog(primaryStage);
        });

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> {
            String caption = captionField.getText();
            if (selectedImageFile != null && !caption.isEmpty()) {
                Image image = new Image(selectedImageFile.toURI().toString());
                posts.add(new Post(image, caption));
                showHomeScene();
            } else {
                showAlert("Please select an image and enter a caption.");
            }
        });

        VBox layout = new VBox(10, captionLabel, captionField, imageBtn, submitBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.showAndWait();
    }

    class User {
        String nickName;
        String fullName;
        Image profileImage;

        User(String nickName, String fullName, Image profileImage) {
            this.nickName = nickName;
            this.fullName = fullName;
            this.profileImage = profileImage;
        }
    }

    class Post {
        Image image;
        String caption;

        Post(Image image, String caption) {
            this.image = image;
            this.caption = caption;
        }
    }
    
}
