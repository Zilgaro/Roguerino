package roguerino.levels;

import java.util.ArrayList;
import roguerino.entities.Enemy;
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
     * @param level Leveli, jolle viholliset generoidaan
     * @param howMany kuinka monta vihollista halutaan
     * @return Palautetaan ArrayList, jonka jäseninä juuri paikoilleen asetetut viholliset
     */
    
    public ArrayList<Enemy> createEnemies(Level level, int howMany) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        int numberOfEnemies = howMany;
        while (numberOfEnemies > 0) {
            int x = this.random.nextInt(level.getWidth());
            int y = this.random.nextInt(level.getHeight());
            Blockerino block = level.getBlock(x, y);

            if (block.isWalkable() && !block.getType().equals("DOOR")
                    &&!block.hasEnemy() &&!block.hasPlayer()) {
                if (block.getType().equals("FLOOR")) {
                    if (random.nextInt(100) > 80) {
                        Enemy newbie = new Enemy(x,y);
                        enemies.add(newbie);
                        block.setEntity(newbie);
                        numberOfEnemies--;
                    }
                } else {
                    if (random.nextInt(100) > 91) {
                        Enemy newbie = new Enemy(x,y);
                        enemies.add(newbie);
                        block.setEntity(newbie);
                        numberOfEnemies--;
                    }
                }
            }
        }
        return enemies;
    }
}
