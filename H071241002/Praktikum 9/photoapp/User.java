package photoapp;

import javafx.scene.image.Image;

public class User {
    public String nickName;
    public String fullName;
    public Image profileImage;

    public User(String nickName, String fullName, Image profileImage) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImage = profileImage;
    }
}