package roguerino.entities;

import roguerino.entities.Entity;

/**
 * Geneerisen vihollisen luomisen tarjoava luokka.
 */
public class Enemy implements Entity {

    private String TYPE = "ENEMY";
    private boolean alive;
    private int x;
    private int y;

    /**
     * Vihollista luodessa halutaan pystyä asettamaan se tiettyyn paikkaan
     * kartassa, mutta sen pitää myös tietää oma positionsa, jotta liikkumis -ja
     * taistelulogiikka toimivat.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Enemy(int x, int y) {
        this.alive = true;
        this.x = Math.abs(x);
        this.y = Math.abs(y);

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
