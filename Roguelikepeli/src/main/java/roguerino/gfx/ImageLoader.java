
package roguerino.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    
    public BufferedImage load(String path){
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
            System.out.println("Couldn't read image resource file");
            System.exit(0);
        }
        return null;
    }
    
}
