package roguerino.blocks;

import roguerino.entities.Enemy;
import roguerino.entities.Entity;
import roguerino.entities.Player;

/**
 * 'Mustan' blockin luokka. Loppujenlopuksi tätä luokkaa ei tarvittu
 * toteutuksessa, mutta se on hyvä testaustarkoituksiin, sekä mikäli haluaisi
 * luoda asymmetrisiä kenttiä, tulisi tälle todennäköisesti käyttöä.
 */
public class Black extends Blockerino {

    public Black() {
        this.walkable = false;
        this.TYPE = "BLACK";
        this.entity = null;
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
    public String getType() {
        return this.TYPE;
    }

    @Override
    public boolean hasPlayer() {
        return false;
    }

    @Override
    public boolean hasEnemy() {
        return false;
    }

    @Override
    public void setEntity(Entity entity) {
    }

    @Override
    public Enemy getEnemy() {
        return null;
    }

}
