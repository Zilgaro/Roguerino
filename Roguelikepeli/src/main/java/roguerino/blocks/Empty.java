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
        this.entity = entity;
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
    
}
