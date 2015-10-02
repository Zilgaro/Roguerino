package roguerino.levels;

import java.util.Random;

public class EnemyGenerator {

    private Random random;

    public EnemyGenerator() {
        this.random = new Random();
    }

    
    //vähän tyhmä ratkaisu atm
    public void createEnemies(Level level) {
        int numberOfEnemies = 20;
        while (numberOfEnemies > 0) {
            Block block = level.getBlock(this.random.nextInt(level.getWidth()), this.random.nextInt(level.getHeight()));

            if (!block.isBlack() && !block.isWall() && !block.isDoor()) {
                if (block.isFloor()) {
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
