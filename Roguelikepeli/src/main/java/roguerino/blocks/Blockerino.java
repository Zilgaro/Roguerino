/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.blocks;

import roguerino.levels.Enemy;
import roguerino.levels.Player;

/**
 *
 * @author Zilgaro
 */
public abstract class Blockerino {
    boolean walkable;
    Player player;
    String TYPE;
    Enemy enemy;
    
    public abstract Player getPlayer();
    public abstract boolean hasPlayer();
    public abstract void setPlayer(Player player);
     public abstract void setEnemy(Enemy enemy);
    public abstract boolean hasEnemy();
    public abstract boolean isWalkable();
    public abstract String getType();
    

    
}
