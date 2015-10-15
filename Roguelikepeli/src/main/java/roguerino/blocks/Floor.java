package roguerino.blocks;

import roguerino.entities.Enemy;
import roguerino.entities.Entity;
import roguerino.entities.Player;

/**
 * Huoneiden sisällä olevan lattian luokka.
 */
public class Floor extends Blockerino {

    public Floor() {
        this.TYPE = "FLOOR";
         this.entity = null;
        this.walkable = true;
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
    public boolean hasPlayer() {
        return this.getPlayer() != null;
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
    public boolean isWalkable() {
        return this.walkable;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
 
    @Override
    public boolean hasEnemy() {
        if ( entity == null) {
            return false;
        }
        
        return entity.getType().equals("ENEMY");
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
