/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.blocks;


import roguerino.levels.Entity;
import roguerino.levels.Player;


/**
 *
 * @author Zilgaro
 */
public abstract class Blockerino {
    boolean walkable;
    Entity entity;
    String TYPE;
    
    
    public abstract Player getPlayer();
    public abstract boolean hasPlayer();
    public abstract void setEntity(Entity entity);
    public abstract boolean hasEnemy();
    public abstract boolean isWalkable();
    public abstract String getType();
    

    
}
