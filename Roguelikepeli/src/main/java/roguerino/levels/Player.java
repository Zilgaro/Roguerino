

package roguerino.levels;

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
