package roguerino.blocks;

import roguerino.entities.Enemy;
import roguerino.entities.Entity;
import roguerino.entities.Player;

/**
 *
 * @author Zilgaro
 */
public class Empty extends Blockerino {

    public Empty() {
        this.entity = null;
        this.walkable = true;
        this.TYPE = "EMPTY";
    }
    
    

    @Override
    public boolean isWalkable() {
        return walkable;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
    
    @Override
    public boolean hasPlayer() {
        if (this.entity == null) {
            return false;
        }
        
        if (this.entity.getType().equals("PLAYER")) {
            return true;
        }
        
        return false;
    }

    

    @Override
    public boolean hasEnemy() {
        
        if (this.entity == null) {
            return false;
        }
        
        if (this.entity.getType().equals("ENEMY")) {
            return true;
        }
        return false;
    }


    @Override
    public void setEntity(Entity entity) {
        if (this.entity == null) {
            this.entity = entity;
          //Selvennys: halutaan, että nulliksi laittaminen (liikkuminen) on mahdollista.
        } else if (entity == null) {
            this.entity = null;
        }
    }

    @Override
    public Player getPlayer() {
        
        if (this.entity == null) {
            return null;
        }
        
        if (this.entity.getType().equals("PLAYER")) {
            return (Player) entity;
        }
        return null;
    }
    
    @Override
    public Enemy getEnemy() {
        if (this.entity != null) {

            if (this.entity.getType().equals("ENEMY")) {
                return (Enemy) this.entity;
            }
        }
        return null;
    }
}
