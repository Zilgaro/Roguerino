

package roguerino.entities;

import roguerino.entities.Entity;

/**
 * Simppeli luokka pelaaja-entiteetin luomiseen.
 */
public class Player implements Entity {
    
    private int x, y;
    private final String TYPE = "PLAYER";

    public Player() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    

    @Override
    public void setX(int x) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

    @Override
    public void setY(int y) {
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    
    
}
