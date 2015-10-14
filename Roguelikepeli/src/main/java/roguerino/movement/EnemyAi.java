
package roguerino.movement;

import java.util.ArrayList;
import java.util.Random;
import roguerino.entities.Enemy;
import roguerino.levels.Level;
import roguerino.logic.MovementLogic;


public  class EnemyAi {
    
    private MovementLogic movLogic;
    private Level level;
    private final Random random;
    
    public EnemyAi(Level level) {
        this.random = new Random();
        this.level = level;
        this.movLogic = new MovementLogic(this.level);
    
    }
    
    public void run(ArrayList<Enemy> enemies) {
        
            
            for (Enemy enemy : enemies) {
                if (!enemy.isAlive()) {
                    continue;
                }
                int movementKey = random.nextInt(8);
                movLogic.movement(movementKey, enemy);
            }
        
    }
}
