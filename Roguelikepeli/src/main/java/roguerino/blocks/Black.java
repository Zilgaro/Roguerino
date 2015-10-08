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
public class Black extends Blockerino{
    
    
    public Black() {
        this.walkable = false;
        this.player = null;
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
    public void setPlayer(Player player) {
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public boolean hasPlayer() {
        return this.player != null;
    }

    @Override
    public void setEnemy(Enemy enemy) {
    }

    @Override
    public boolean hasEnemy() {
        return false;
    }
    
    
}
