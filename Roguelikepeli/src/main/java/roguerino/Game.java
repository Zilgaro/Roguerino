

package roguerino;

import roguerino.logic.Logic;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import roguerino.blocks.Blockerino;
import roguerino.gfx.ImageLoader;
import roguerino.gfx.ImageManager;
import roguerino.gfx.SpriteSheet;
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

        ImageLoader loader = new ImageLoader();
        spriteSheet = loader.load("my-resources/spritesheet.png");

        SpriteSheet ss = new SpriteSheet(spriteSheet);
        this.imageManager = new ImageManager(ss);

        this.mouseManager = new MouseManager(this.logic);
        this.addMouseListener(mouseManager);
    }
    
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 1D;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                logic.getEnemyAi().run(logic.getEnemies());
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
        JOptionPane.showMessageDialog (null, "Peliä ohjataan hiirellä, olet musta mötikkä, punaiset"
                + " rinkulat ovat vihuja. Tapa kaikki.", "Hau tu plei", JOptionPane.INFORMATION_MESSAGE);
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

                Blockerino block = this.logic.getBlock(x, y);
                if (block.getType().equals("FLOOR")) {
                    g.drawImage(imageManager.floor, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                } else if (block.getType().equals("DOOR")) {
                    g.drawImage(imageManager.door, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                } else if (block.getType().equals("BLACK")) {
                    g.drawImage(imageManager.black, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                } else if (block.getType().equals("WALL")) {
                    g.drawImage(imageManager.wall, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                } else {
                    g.drawImage(imageManager.empty, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                }
            
                if (block.hasPlayer()) {
                    g.drawImage(imageManager.player, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                }
                
                if (block.hasEnemy()) {
                    g.drawImage(imageManager.enemy,(j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                }

            }
        }
        //RENDER END
        g.dispose();
        bs.show();
    }
}
