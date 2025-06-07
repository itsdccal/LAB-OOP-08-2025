package photoapp;

import javafx.scene.image.Image;

public class Post {
    public String caption;
    public Image image;

    public Post(String caption, Image image) {
        this.caption = caption;
        this.image = image;
    }
}
