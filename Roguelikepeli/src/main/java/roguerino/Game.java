

package roguerino;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import roguerino.gfx.ImageLoader;
import roguerino.gfx.ImageManager;
import roguerino.gfx.SpriteSheet;
import roguerino.levels.Block;
import roguerino.movement.MouseManager;


public class Game extends Canvas implements Runnable {
    
    private Logic logic;
    public static final int WIDTH = 320, HEIGHT =320, SCALE = 2, FOV = 5;
    public static boolean running = false;
    public Thread gameThread;
    private BufferedImage spriteSheet;
    private ImageManager imageManager;
    private MouseManager mouseManager;
   

    public Logic getLogic() {
        return logic;
    }
    

    public void init() {
        this.logic = new Logic();
        this.logic.run();
        this.logic.openGlSuperRender();

        ImageLoader loader = new ImageLoader();
        spriteSheet = loader.load("src/my-resources/spritesheet.png");

        SpriteSheet ss = new SpriteSheet(spriteSheet);
        this.imageManager = new ImageManager(ss);

        this.mouseManager = new MouseManager(this.logic);
        this.addMouseListener(mouseManager);
    }
    
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60D;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                delta--;
            }
            render();
        }
        stop();
    }
    
    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }
    
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //RENDER HERE
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        for (int i = -FOV; i < FOV + 1; i++) {
            for (int j = -FOV; j < FOV + 1; j++) {
                int x = this.logic.getPlayer().getX() + j;
                int y = this.logic.getPlayer().getY() + i;

                Block block = this.logic.getBlock(x, y);
                if (block.isFloor()) {
                    g.drawImage(imageManager.floor, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                } else if (block.isBlack()) {
                    g.drawImage(imageManager.black, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                } else {
                    g.drawImage(imageManager.empty, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                }
            
                if (block.hasPlayer()) {
                    g.drawImage(imageManager.player, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                }

            }
        }
        //RENDER END
        g.dispose();
        bs.show();
    }
}
