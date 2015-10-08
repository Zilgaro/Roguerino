/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.blocks;

import roguerino.levels.Player;

/**
 *
 * @author Zilgaro
 */
public class Empty extends Blockerino {

    public Empty() {
        this.player = null;
        this.walkable = true;
        this.TYPE = "EMPTY";
    }
    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
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
        return this.player != null;
    }
    
}
