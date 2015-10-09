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
public class Black extends Blockerino{
    
    
    public Black() {
        this.walkable = false;
        this.TYPE = "BLACK";
    }

    @Override
    public boolean isWalkable() {
        return this.walkable;
    }

    @Override
    public Player getPlayer() {
        return null;
    }
    
   
    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public boolean hasPlayer() {
        return false;
    }

    

    @Override
    public boolean hasEnemy() {
        return false;
    }

    @Override
    public void setEntity(Entity entity) {
    }
    
    
}
