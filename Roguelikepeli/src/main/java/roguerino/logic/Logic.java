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
                if ( !block.getType().equals("EMPTY") || block.hasPlayer() || block.hasEnemy() ) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        this.level.getBlock(25, 25).setEntity(this.player);
        this.player.setX(25);
        this.player.setY(25);
        createRooms(25);
        enemyGenerator.createEnemies(this.level);      
    }

}
