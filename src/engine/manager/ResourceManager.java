package engine.manager;

import engine.render.texture.SpriteSheet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceManager {

    /*
    This method receive the path of an image file that will be used to create a BufferedImage instance with the image data
    */
    public static BufferedImage LoadImage(String path) {
        BufferedImage image = null;
        try { image = ImageIO.read(new File(path)); }
        catch (IOException e) { System.err.println(e.getMessage()); }
        return image;
    }

    /*
    This method is similar to LoadImage, but here we call the LoadImage and after this create a SpriteSheet instance if the image is not null
    */
    public static SpriteSheet LoadSpriteSheet(String path) {
        BufferedImage image = LoadImage(path);
        if (image == null) { return null; }
        return new SpriteSheet(image);
    }
}