package roguerino.levels;

import java.util.Random;
import roguerino.blocks.Blockerino;

/**
 * Luo leveliin satunnaisiin kohtiin vihollisia.
 */
public class EnemyGenerator {

    private Random random;

    public EnemyGenerator() {
        this.random = new Random();
    }

    
    /**
     * Metodin ideana on luoda satunnaisiin paikkoihin vihollisia, huoneiden
     * sisällä olevat viholliset ovat melko harvinaisia.
     */
    
    public void createEnemies(Level level, int howMany) {
        int numberOfEnemies = howMany;
        while (numberOfEnemies > 0) {
            int x = this.random.nextInt(level.getWidth());
            int y = this.random.nextInt(level.getHeight());
            Blockerino block = level.getBlock(x, y);

            if (block.isWalkable() && !block.getType().equals("DOOR")) {
                if (block.getType().equals("FLOOR")) {
                    if (random.nextInt(100) > 80) {
                        block.setEntity(new Enemy(x,y));
                        numberOfEnemies--;
                    }
                } else {
                    if (random.nextInt(100) > 91) {
                        block.setEntity(new Enemy(x,y));
                        numberOfEnemies--;
                    }
                }
            }
        }
    }
}
