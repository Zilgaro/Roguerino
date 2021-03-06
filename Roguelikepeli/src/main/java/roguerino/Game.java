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

/**
 * Tämä käyttöliittymäluokka tarjoaa toiminnallisuuden renderöinnille, sekä
 * pyörittää pelin keskeistä looppia jossa tapahtuu ruudunpäivitys ja
 * ohjelmasäikeen aloitus sekä lopetus.
 */
public class Game extends Canvas implements Runnable {

    private Logic logic;
    public static final int WIDTH = 320, HEIGHT = 320, SCALE = 2, FOV = 5;
    public static boolean running = false;
    public Thread gameThread;
    private BufferedImage spriteSheet;
    private ImageManager imageManager;
    private MouseManager mouseManager;

    public Logic getLogic() {
        return logic;
    }

    /**
     * Käytännössä tämä metodi on public vain testauksen helpottamisen takia.
     * Metodissa alustetaan yksityinen Logic, luokan BufferedImage ilmentymä
     * spriteSheet ImageLoaderin lataamasta kuvasta ja ImageManager (jolla
     * spriteSheetistä saadaan pilkottua yksittäiset spritet renderöinnin
     * käyttöön).
     */
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

    /**
     * Tämä metodi on pelin 'moottori'. Alussa alustetaan init() metodia
     * käyttäen käytettävä logiikka, ladataan renderin käyttämä SpriteSheet,
     * sekä MouseManager kuuntelemaan käyttäjän inputtia.
     */
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 2D;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                if (logic.getEnemyAi().run(logic.getEnemies())) {
                    JOptionPane.showMessageDialog(null, "I hope you're happy now.", "You are a monster", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                delta--;
            }
            render();

        }
        stop();
    }

    private synchronized void stop() {
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

    /**
     * Käynnistää pelisäikeen ja promptaa käyttäjää lyhyellä hassunhauskalla
     * ohjeistuksella.
     */
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
        JOptionPane.showMessageDialog(null, "Peliä ohjataan hiirellä, olet musta mötikkä, punaiset"
                + " rinkulat ovat vihuja. "
                + "Voit 'tappaa' vihollisia menemällä niiden viereen ja klikkaamalla",
                "Hau tu plei", JOptionPane.INFORMATION_MESSAGE);
    }

    private void render() {
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
                    g.drawImage(imageManager.enemy, (j + FOV) * 32 * SCALE, (i + FOV) * 32 * SCALE, 32 * SCALE, 32 * SCALE, null);
                }

            }
        }
        //RENDER END
        g.dispose();
        bs.show();
    }
}
