package engine.render.texture;

import java.awt.image.BufferedImage;

public class Sprite {

    private final BufferedImage image;

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage Get() { return image; }
}