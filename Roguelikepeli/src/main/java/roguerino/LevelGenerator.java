package roguerino;

import java.util.Random;

public class LevelGenerator {

    private Random random;

    public LevelGenerator() {
        this.random = new Random();
    }

    public Level generateLevel() { //oletuskenttä
        Level level = new Level(30, 30);

        return level;
    }

    public Level generateLevelEmpty(int width, int height) { //luo tyhjää täynnä olevan kentän
        Level level = new Level(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Block block = new Block();
                block.setBlack(false);
                level.setBlock(i, j, block);
            }
        }
        return level;
    }
}


