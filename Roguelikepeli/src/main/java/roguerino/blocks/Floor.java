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
public class Floor extends Blockerino {

    public Floor() {
        this.TYPE = "FLOOR";
        this.player = null;
        this.walkable = true;
    }
    
    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public boolean hasPlayer() {
        return this.player != null;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean isWalkable() {
        return this.walkable;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
    
}
