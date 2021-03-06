/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.blocks;

import roguerino.entities.Enemy;
import roguerino.entities.Entity;
import roguerino.entities.Player;

/**
 * Ovi-blockin toiminnallisuus.
 */
public class Door extends Blockerino {

    public Door() {
        this.TYPE = "DOOR";
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
        if (entity == null) {
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
