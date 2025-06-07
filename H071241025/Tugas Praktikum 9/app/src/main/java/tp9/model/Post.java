package tp9.model;

import javafx.scene.image.*;

public class Post {
    String caption;
    Image postImage;

    public Post(String caption, Image postImage) {
        this.caption = caption;
        this.postImage = postImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Image getPostImage() {
        return postImage;
    }

    public void setPostImage(Image postImage) {
        this.postImage = postImage;
    }
}