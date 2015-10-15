
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
    
    public boolean run(ArrayList<Enemy> enemies) {
        
            int deadCount = 0;
            for (Enemy enemy : enemies) {
                
                if (!enemy.isAlive()) {
                    deadCount++;
                    continue;
                }
                int movementKey = random.nextInt(8);
                movLogic.movement(movementKey, enemy);
            }
            
            return deadCount == enemies.size();
        
    }
}
