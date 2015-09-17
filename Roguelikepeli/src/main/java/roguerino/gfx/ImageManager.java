
package roguerino.gfx;

import java.awt.image.BufferedImage;

public class ImageManager {

    public BufferedImage player;
    public BufferedImage empty;
    public BufferedImage black;
    public BufferedImage floor;

    public ImageManager(SpriteSheet ss) {
        this.player = ss.crop(0, 0, 32, 32);
        this.empty=ss.crop(1, 0, 32, 32);
        this.floor=ss.crop(4,0,32,32);
        this.black=ss.crop(6, 0, 32, 32);

    }

}
