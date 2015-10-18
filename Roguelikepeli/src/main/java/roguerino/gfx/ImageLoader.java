package roguerino.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageLoader {

    public BufferedImage load(String path) {
        try {
            URL url = new URL("https://github.com/Zilgaro/Roguerino/blob/master/Roguelikepeli/src/my-resources/spritesheet.png?raw=true");
            return ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("Couldn't read image resource file");
            System.exit(0);
        }
        return null;
    }

}
