package roguerino.logic;

import roguerino.levels.Player;
import roguerino.levels.Level;
import roguerino.levels.LevelGenerator;
import java.util.Random;
import roguerino.blocks.Black;
import roguerino.blocks.Blockerino;
import roguerino.levels.EnemyGenerator;
import roguerino.levels.Room;
import roguerino.levels.RoomGenerator;

/**
 * Tällä hetkellä logiikka hoitaa huoneiden generoinni kutsun, liikkumisen, vihollisten
 * generoinnin kutsun sekä hoitaa, että huoneet osuvat tyhjiin paikkoihin levelin sisällä.
 */
public class Logic {

    private LevelGenerator generator;
    private Level level;
    private Player player;
    private Random random;
    private RoomGenerator roomGenerator;
    private EnemyGenerator enemyGenerator;

    public Logic() {
        this.generator = new LevelGenerator();
        this.level = generator.generateLevelEmpty(30, 30);
        this.player = new Player();
        this.random = new Random();
        this.roomGenerator = new RoomGenerator();
        this.enemyGenerator = new EnemyGenerator();
    }

    public Level getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public Blockerino getBlock(int x, int y) {
        if (x < 0 || y < 0 || x > this.level.getWidth() - 1 || y > this.level.getHeight() - 1) {
            return new Black();
        } else {
            return this.level.getBlock(x, y);
        }

    }
    
    
    /**
     * Liikkumisella kahdeksan mahdollista suuntaa, jokaisen liikkumisen yhteydessä
     * tarkistetaan validBlock-metodilla, onko liikkuminen mahdollista
     * MouseManager hyödyntää tätä metodia.
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
        } else if (!this.level.getBlock(x, y).isWalkable() || this.level.getBlock(x, y).hasEnemy()) {
            return false;
        }
        return true;
    }
    
    //Tämä seuraavakin metodi on melko härski.

    public boolean validBlock(int x, int y, int movementKey) {
        
        if (this.level.getHeight() < x || this.level.getHeight() < y) {
            return false;
        }
        
        if (!this.level.getBlock(x, y).isWalkable() ||  movementKey > 8 || movementKey < 1) {
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
    
    private void createRooms(int i) {
        while (i > 0) {
            Room room = this.roomGenerator.generateRandomRoom();
            if (placeRoom(room)) {
                i--;
            }
        }
    }

    private boolean placeRoom(Room room) {
        int x = random.nextInt(this.level.getWidth() - room.getWidth());
        int y = random.nextInt(this.level.getHeight() - room.getHeight());
        if (checkIfAreaIsEmpty(x, y, room.getWidth(), room.getHeight())) {
            for (int j = 0; j < room.getHeight(); j++) {
                for (int k = 0; k < room.getWidth(); k++) {
                    this.level.setBlock(x + k, y + j, room.getBlock(k, j));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIfAreaIsEmpty(int x, int y, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Blockerino block = this.level.getBlock(x + i, y + j);
                if ( !block.isWalkable() || block.hasPlayer() ) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        this.level.getBlock(25, 25).setPlayer(this.player);
        this.player.setX(25);
        this.player.setY(25);
        createRooms(25);
        enemyGenerator.createEnemies(this.level);      
    }

}
