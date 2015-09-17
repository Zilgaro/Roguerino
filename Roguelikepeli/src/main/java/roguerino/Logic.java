package roguerino;

import roguerino.levels.Player;
import roguerino.levels.Block;
import roguerino.levels.Level;
import roguerino.levels.LevelGenerator;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    private LevelGenerator generator;
    private Level level;
    private Player player;
    private Random random;

    public Logic() {
        this.generator = new LevelGenerator();
        this.level = generator.generateLevelEmpty(50, 50);
        this.player = new Player();
        this.random = new Random();
    }

    public Level getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public Block getBlock(int x, int y) {
        if (x < 0 || y < 0 || x > this.level.getWidth() - 1 || y > this.level.getHeight() - 1) {
            return new Block();
        } else {
            return this.level.getBlock(x, y);
        }

    }
    
    public void openGlSuperRender() {
        for (int i = 0; i < this.level.getHeight(); i++) {
            for (int j = 0; j < this.level.getWidth(); j++) {

                Block block = this.level.getBlock(j, i);

                if (block.hasPlayer()) {
                    System.out.print("@");
                } else if (block.isBlack()) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }
    
    /* HUOM HUOM! Liikkuminen näyttää tässä vaiheessa aivan karsealta. 
    * Tulen korjaaman asian keyEventeillä kunhan saan ruudun pystyyn.
    */

    public void movement(int movementKey) {

        int y = this.player.getY();
        int x = this.player.getX();

        if (movementKey == 1 && this.validBlock(x, y, movementKey)) {

            this.player.setX(x - 1);
            this.player.setY(y - 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x - 1, y - 1).setPlayer(this.player);

        }

        if (movementKey == 2 && this.validBlock(x, y - 1)) {

            this.player.setY(y - 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x, y - 1).setPlayer(this.player);

        }

        if (movementKey == 3 && this.validBlock(x, y, movementKey)) {

            this.player.setX(x + 1);
            this.player.setY(y - 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x + 1, y - 1).setPlayer(this.player);

        }

       
        if (movementKey == 4 && validBlock(x + 1, y)) {

            this.player.setX(x + 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x + 1, y).setPlayer(this.player);

        }

        if (movementKey == 5 && this.validBlock(x, y, movementKey)) {

            this.player.setX(x + 1);
            this.player.setY(y + 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x + 1, y + 1).setPlayer(this.player);

        }

        if (movementKey == 6 && this.validBlock(x, y + 1)) {

            this.player.setY(y + 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x, y + 1).setPlayer(this.player);

        }

        if (movementKey == 7 && this.validBlock(x, y, movementKey)) {

            this.player.setX(x - 1);
            this.player.setY(y + 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x - 1, y + 1).setPlayer(this.player);

        }

        if (movementKey == 8 && this.validBlock(x - 1, y)) {

            this.player.setX(x - 1);
            this.level.getBlock(x, y).setPlayer(null);
            this.level.getBlock(x - 1, y).setPlayer(this.player);

        }
    }

    public boolean validBlock(int x, int y) {

        if (x < 0 || y < 0 || x > this.level.getWidth() - 1 || y > this.level.getHeight() - 1) { //ei voi mennä out of bounds;
            return false;
        }

        if (this.level.getBlock(x, y).isBlack()) {
            return false;
        }
        return true;
    }
    
    //Tämä seuraavakin metodi on melko härski.

    public boolean validBlock(int x, int y, int movementKey) {
        
        if (this.level.getHeight() < x || this.level.getHeight() < y) {
            return false;
        }
        
        if (this.level.getBlock(x, y).isBlack() ||  movementKey > 8 || movementKey < 1) {
            return false;
        }

        if (movementKey == 1) {
            if (this.validBlock(x - 1, y) == false || this.validBlock(x, y - 1) == false || this.validBlock(x - 1, y - 1) == false) {
                return false;
            }
        }

        if (movementKey == 3) {
            if (this.validBlock(x + 1, y) == false || this.validBlock(x, y - 1) == false || this.validBlock(x + 1, y - 1) == false) {
                return false;
            }
        }

        if (movementKey == 5) {
            if (this.validBlock(x + 1, y) == false || this.validBlock(x, y + 1) == false || this.validBlock(x + 1, y + 1) == false) {
                return false;
            }
        }

        if (movementKey == 7) {
            if (this.validBlock(x - 1, y) == false || this.validBlock(x, y + 1) == false || this.validBlock(x - 1, y + 1) == false) {
                return false;
            }
        }

        return true;
    }

    public void run() {
        this.level.getBlock(25, 25).setPlayer(this.player);
        this.player.setX(25);
        this.player.setY(25);
        this.openGlSuperRender();
        int movementKey = 0;
        Scanner lukija = new Scanner(System.in);
        
        
    }

}
