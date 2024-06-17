package engine.gfx.texture;

import engine.util.Vector2D;

import java.awt.image.BufferedImage;

public class Sprite implements Comparable<Sprite> {

    private final BufferedImage image;
    private final Vector2D offset;

    public Sprite(BufferedImage image) {
        this.image = image;
        offset = new Vector2D(image.getWidth(), image.getHeight());
    }

    public BufferedImage Get() { return image; }

    @Override
    public int compareTo(Sprite o) {
        int row = Double.compare(offset.y, o.offset.y);
        if (row == 0) { return Double.compare(offset.x, o.offset.x); }
        return row;
    }
}