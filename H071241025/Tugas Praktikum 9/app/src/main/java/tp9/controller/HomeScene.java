package tp9.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tp9.model.Post;
import tp9.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeScene {
    private final List<Post> posts = new ArrayList<>(); 
    private GridPane postGrid;

    public Scene createHomeScene(Stage stage, User user) {
        Text nickName = new Text(user.getNickName());
        nickName.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        Text fullName = new Text(user.getFullName());

        Circle clip = new Circle(50, 50, 50);
        ImageView profileImageView = new ImageView(user.getProfileImage());
        profileImageView.setFitWidth(100);
        profileImageView.setFitHeight(100);
        profileImageView.setClip(clip);

        VBox profileBox = new VBox(10, profileImageView, nickName, fullName);
        profileBox.setAlignment(Pos.CENTER);
        profileBox.setPadding(new Insets(10));

        Button btAddPost = new Button("Add Post");

        TextArea captionArea = new TextArea();
        captionArea.setPromptText("Tulis caption di sini...");
        captionArea.setMaxHeight(50); 

        Button btUploadImage = new Button("Upload Gambar");
        final Image[] selectedImage = {null}; 

        ImageView previewImageView = new ImageView();
        previewImageView.setFitWidth(200);
        previewImageView.setFitHeight(200);
        previewImageView.setPreserveRatio(true);
        previewImageView.setVisible(false); 
        
        btUploadImage.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih gambar untuk postingan");
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
                );
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    try {
                        selectedImage[0] = new Image(new FileInputStream(file));
                        previewImageView.setImage(selectedImage[0]);
                        previewImageView.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            
        Button btSubmit = new Button("Submit Post");
        btSubmit.setOnAction(e -> {
            String caption = captionArea.getText().trim();
            if (selectedImage[0] == null || caption.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Lengkapi gambar dan caption!").show();
            } else {
                Post newPost = new Post(caption, selectedImage[0]);
                posts.add(newPost);
                updatePostGrid(); 
                captionArea.clear();
                selectedImage[0] = null;
                previewImageView.setImage(null);
                previewImageView.setVisible(false);
            }
        });

        VBox postInputBox = new VBox(10, captionArea, btUploadImage, previewImageView, btSubmit);
        postInputBox.setPadding(new Insets(10));
        postInputBox.setVisible(false); 

        btAddPost.setOnAction(e -> postInputBox.setVisible(!postInputBox.isVisible()));

        postGrid = new GridPane();
        postGrid.setHgap(10);
        postGrid.setVgap(10);
        postGrid.setPadding(new Insets(10));
        postGrid.setAlignment(Pos.CENTER_LEFT);

        ScrollPane scrollPostGrid = new ScrollPane(postGrid);
        scrollPostGrid.setFitToWidth(true);
        scrollPostGrid.setPrefHeight(300);

        VBox contentBox = new VBox(20, profileBox, btAddPost, postInputBox, new Separator(), scrollPostGrid);
        contentBox.setPadding(new Insets(20));
        contentBox.setAlignment(Pos.TOP_CENTER);

        ScrollPane mainScroll = new ScrollPane(contentBox);
        mainScroll.setFitToWidth(true);

        return new Scene(mainScroll, 400, 500);
    }

    private void updatePostGrid() {
        postGrid.getChildren().clear();
        int col = 0;
        int row = 0;

        for (Post post : posts) {
            ImageView thumb = new ImageView(post.getPostImage());
            thumb.setFitWidth(100);
            thumb.setFitHeight(100);
            thumb.setPreserveRatio(false);

            thumb.setOnMouseEntered(e -> thumb.setOpacity(0.7));
            thumb.setOnMouseExited(e -> thumb.setOpacity(1.0));

            thumb.setOnMouseClicked(e -> showPostPopup(post));

            postGrid.add(thumb, col, row);
            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
    }

    private void showPostPopup(Post post) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Postingan");

        ImageView fullImage = new ImageView(post.getPostImage());
        fullImage.setPreserveRatio(true);
        fullImage.setFitWidth(400);

        Label caption = new Label(post.getCaption());
        caption.setWrapText(true);
        caption.setStyle("-fx-font-size: 14px;");

        VBox box = new VBox(10, fullImage, caption);
        box.setPadding(new Insets(20));
        box.setAlignment(Pos.CENTER);

        popup.setScene(new Scene(box, 400, 500));
        popup.showAndWait();
    }
}
