package roguerino.levels;

import java.util.Random;
import roguerino.blocks.Blockerino;

public class EnemyGenerator {

    private Random random;

    public EnemyGenerator() {
        this.random = new Random();
    }

    
    //vähän tyhmä ratkaisu atm
    public void createEnemies(Level level) {
        int numberOfEnemies = 20;
        while (numberOfEnemies > 0) {
            Blockerino block = level.getBlock(this.random.nextInt(level.getWidth()), this.random.nextInt(level.getHeight()));

            if (block.isWalkable() && !block.getType().equals("DOOR")) {
                if (block.getType().equals("FLOOR")) {
                    if (random.nextInt(100) > 80) {
                        block.setEnemy(new Enemy());
                        numberOfEnemies--;
                    }
                } else {
                    if (random.nextInt(100) > 91) {
                        block.setEnemy(new Enemy());
                        numberOfEnemies--;
                    }
                }
            }
        }
    }
}
