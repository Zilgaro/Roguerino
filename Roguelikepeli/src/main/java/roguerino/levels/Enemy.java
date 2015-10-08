
package roguerino.levels;


public class Enemy {

    private boolean alive;
    
    public Enemy() {
        this.alive = true;
    }
    
    public void kill() {
        this.alive = false;
    }
    
    
}
