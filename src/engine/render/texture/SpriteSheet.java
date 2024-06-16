package engine.render.texture;

import engine.Globals;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private final int width, height;
    private final BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public Sprite GetSprite(int x, int y) {
        return new Sprite(image.getSubimage(x, y, Globals.ORIGINAL_TILE_SIZE, Globals.ORIGINAL_TILE_SIZE));
    }

    public int GetWidth() { return width; }

    public int GetHeight() { return height; }
}