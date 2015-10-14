package roguerino.blocks;

import roguerino.entities.Enemy;
import roguerino.entities.Entity;
import roguerino.entities.Player;

/**
 *
 * @author Zilgaro
 */
public class Wall extends Blockerino {
    
    public Wall() {
        this.TYPE = "WALL";
        this.walkable = false;
        this.entity = null;
        
    }
    @Override
    public Player getPlayer() {    
        return null;
    }

    @Override
    public boolean hasPlayer() {
        return false;
    }

    @Override
    public void setEntity(Entity entity) {
    }

    @Override
    public boolean isWalkable() {
        return this.walkable;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
 
    @Override
    public boolean hasEnemy() {
        return false;
    }
    
    @Override
    public Enemy getEnemy() {
        return null;
    }
}
