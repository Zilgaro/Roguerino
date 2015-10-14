/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.logic;

import roguerino.entities.Entity;
import roguerino.levels.Level;
import roguerino.entities.Player;

/**
 * Luokka hoitaa liikkumisen käsittelyn.
 */
public class MovementLogic {

    private Level level;

    /**
     * Liikkumisella kahdeksan mahdollista suuntaa, jokaisen liikkumisen
     * yhteydessä tarkistetaan validBlock-metodilla, onko liikkuminen
     * mahdollista MouseManager hyödyntää tätä metodia.
     */
    public MovementLogic(Level level) {
        this.level = level;
    }

    public void movement(int movementKey, Entity entity) {

        int y = entity.getY();
        int x = entity.getX();

        if (movementKey == 1 && this.validBlock(x, y, movementKey)) {
            if (!attack(entity, x - 1, y - 1)) {
                entity.setX(x - 1);
                entity.setY(y - 1);
                level.getBlock(x, y).setEntity(null);
                level.getBlock(x - 1, y - 1).setEntity(entity);
            }

        }

        if (movementKey == 2 && this.validBlock(x, y - 1)) {
            if (!attack(entity, x, y - 1)) {
                entity.setY(y - 1);
                level.getBlock(x, y).setEntity(null);
                level.getBlock(x, y - 1).setEntity(entity);
            }

        }

        if (movementKey == 3 && this.validBlock(x, y, movementKey)) {
            if (!attack(entity, x + 1, y - 1)) {
                entity.setX(x + 1);
                entity.setY(y - 1);
                level.getBlock(x, y).setEntity(null);
                level.getBlock(x + 1, y - 1).setEntity(entity);
            }

        }

        if (movementKey == 4 && validBlock(x + 1, y)) {
            if (!attack(entity, x + 1, y)) {
                entity.setX(x + 1);
                level.getBlock(x, y).setEntity(null);
                level.getBlock(x + 1, y).setEntity(entity);
            }

        }

        if (movementKey == 5 && this.validBlock(x, y, movementKey)) {
            if (!attack(entity, x + 1, y + 1)) {
                entity.setX(x + 1);
                entity.setY(y + 1);
                level.getBlock(x, y).setEntity(null);
                level.getBlock(x + 1, y + 1).setEntity(entity);
            }
        }

        if (movementKey == 6 && this.validBlock(x, y + 1)) {
            if (!attack(entity, x, y + 1)) {
                entity.setY(y + 1);
                level.getBlock(x, y).setEntity(null);
                level.getBlock(x, y + 1).setEntity(entity);
            }

        }

        if (movementKey == 7 && this.validBlock(x, y, movementKey)) {
            if (!attack(entity, x - 1, y + 1)) {
                entity.setX(x - 1);
                entity.setY(y + 1);
                this.level.getBlock(x, y).setEntity(null);
                this.level.getBlock(x - 1, y + 1).setEntity(entity);
            }

        }

        if (movementKey == 8 && this.validBlock(x - 1, y)) {
            if (!attack(entity, x - 1, y)) {
                entity.setX(x - 1);
                this.level.getBlock(x, y).setEntity(null);
                this.level.getBlock(x - 1, y).setEntity(entity);
            }

        }
    }

    public boolean validBlock(int x, int y) {

        if (x < 0 || y < 0 || x > this.level.getWidth() - 1 || y > this.level.getHeight() - 1) { //ei voi mennä out of bounds;
            return false;
        } else if (!this.level.getBlock(x, y).isWalkable()) {
            return false;
        }
        return true;
    }

    //Tämä seuraavakin metodi on melko härski.
    public boolean validBlock(int x, int y, int movementKey) {

        if (this.level.getHeight() < x || this.level.getHeight() < y) {
            return false;
        }

        if (!this.level.getBlock(x, y).isWalkable() || movementKey > 8 || movementKey < 1) {
            return false;
        }

        if (movementKey == 1) {
            if (this.validBlock(x - 1, y) == false || this.validBlock(x, y - 1) == false || this.validBlock(x - 1, y - 1) == false) {
                return false;
            }
        }

        if (movementKey == 3) {
            if (this.validBlock(x + 1, y) == false || this.validBlock(x, y - 1) == false || this.validBlock(x + 1, y - 1) == false) {
                return false;
            }
        }

        if (movementKey == 5) {
            if (this.validBlock(x + 1, y) == false || this.validBlock(x, y + 1) == false || this.validBlock(x + 1, y + 1) == false) {
                return false;
            }
        }

        if (movementKey == 7) {
            if (this.validBlock(x - 1, y) == false || this.validBlock(x, y + 1) == false || this.validBlock(x - 1, y + 1) == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * Hyvin alkeellinen metodi, jonka avulla haluan havainnollistaa, kuinka
     * hyökkääminen käytännössä toimisi käyttäen sitä liikkumisen yhteydessä.
     * Hyökättävälle viholliselle laitetaan alive-muuttujan arvoksi false, joten
     * EnemyAi osaa poistaa sen elävien kirjoista. (heh)
     * 
     * Special case: Enemy koittaa liikkua blockiin, jossa on jo toinen enemy. 
     * Tällöin ei tehdä mitään, joten liikkumista ei tapahdu (Toiminnallisuus
     * päällekäisyyden estämiselle oli ennen validBlockilla, nyt sitä ei tarvita)
     *
     * @param entity Käytetään tarkistamaan onko hyökkääjä pelaaja vai vihollinen
     * @param x
     * @param y
     * @return Palauttaa true, mikäli hyökkäys on tehty.
     */
    public boolean attack(Entity entity, int x, int y) {
        if (entity.getType().equals("PLAYER")) {
            if (this.level.getBlock(x, y).hasEnemy()) {
                this.level.getBlock(x, y).getEnemy().kill();
                this.level.getBlock(x, y).setEntity(null);
                return true;
            }
        }
        
        if(entity.getType().equals("ENEMY")) {
            if(this.level.getBlock(x, y).hasEnemy()) {
                return true;
            }
        }
        return false;
    }

}
