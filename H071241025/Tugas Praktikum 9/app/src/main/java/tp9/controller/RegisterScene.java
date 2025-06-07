package tp9.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tp9.model.User;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RegisterScene {
    private Image profileImage = null; 
    
    public Scene regist(Stage primaryStage, java.util.function.Consumer<User> onRegisterSuccess) { 
        Label title = new Label("Input User Account"); 
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Text textNickName = new Text("Nickname: ");
        TextField tfNickName = new TextField();
        HBox.setHgrow(tfNickName, Priority.ALWAYS);
        HBox nicknameBox = new HBox(15, textNickName, tfNickName);
        nicknameBox.setAlignment(Pos.CENTER_LEFT);

        Text textFullName = new Text("Fullname: ");
        TextField tfFullName = new TextField();
        HBox.setHgrow(tfFullName, Priority.ALWAYS);
        HBox fullnameBox  = new HBox(15, textFullName, tfFullName);
        fullnameBox.setAlignment(Pos.CENTER_LEFT);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        Button btUpolad = new Button("Set Profile Photo");
        btUpolad.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih foto");
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );
            File file = fileChooser.showOpenDialog(primaryStage); 
            if (file != null) {
                try {
                    profileImage = new Image(new FileInputStream(file));
                    imageView.setImage(profileImage);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(); 
                }
            }
        });

        Button btSubmit = new Button("Submit");
        btSubmit.setOnAction(e -> {
            String nick = tfNickName.getText().trim(); 
            String full = tfFullName.getText().trim();

            if (nick.isEmpty() || full.isEmpty() || profileImage == null){
                Alert alert = new Alert(Alert.AlertType.WARNING, "Mohon isi semua kolom dan upload foto");
                alert.show();
            } else {
                User newUser = new User(nick, full, profileImage);
                onRegisterSuccess.accept(newUser);
            }
        });

        VBox layout = new VBox(15, title, nicknameBox, fullnameBox, btUpolad, imageView, btSubmit);
        layout.setPadding(new Insets(20)); 
        layout.setAlignment(Pos.CENTER); 

        return new Scene(layout, 400, 500); 

    }
}