
package roguerino.gfx;

import java.awt.image.BufferedImage;

public class ImageManager {

    public BufferedImage player;
    public BufferedImage empty;
    public BufferedImage black;
    public BufferedImage floor;
    public BufferedImage enemy;
    public BufferedImage wall;
    public BufferedImage door;

    public ImageManager(SpriteSheet ss) {
        this.player = ss.crop(0, 0, 32, 32);
        this.empty= ss.crop(1, 0, 32, 32);
        this.wall = ss.crop(2, 0, 32, 32);
        this.door = ss.crop(3, 0, 32, 32);
        this.floor= ss.crop(4, 0, 32, 32);
        this.enemy = ss.crop(5, 0, 32, 32);
        this.black= ss.crop(6, 0, 32, 32);
        

    }

}
