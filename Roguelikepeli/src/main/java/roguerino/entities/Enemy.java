
package roguerino.entities;

import roguerino.entities.Entity;


public class Enemy implements Entity{

    private String TYPE = "ENEMY";
    private boolean alive;
    private int x;
    private int y;
    
    public Enemy(int x, int y) {
        this.alive = true;
        this.x = x;
        this.y = y;
    }
    
    public void kill() {
        this.alive = false;
    }
    
    public boolean isAlive() {
        return this.alive;
    }
    

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
    
    
}
