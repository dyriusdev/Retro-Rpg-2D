package engine.manager;

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
}
