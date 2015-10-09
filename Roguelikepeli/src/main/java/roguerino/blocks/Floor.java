/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.blocks;

import roguerino.levels.Enemy;
import roguerino.levels.Entity;
import roguerino.levels.Player;

/**
 *
 * @author Zilgaro
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
        this.entity = entity;
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
}
