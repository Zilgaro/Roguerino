package roguerino.blocks;

import roguerino.entities.Enemy;
import roguerino.entities.Entity;
import roguerino.entities.Player;

/**
 * Yläluokka jonka kaikki nykyiset ja tulevat blockit tulevat toteuttamaan.
 */
public abstract class Blockerino {

    boolean walkable;
    Entity entity;
    String TYPE;

    public abstract Player getPlayer();

    public abstract Enemy getEnemy();

    public abstract boolean hasPlayer();

    public abstract void setEntity(Entity entity);

    public abstract boolean hasEnemy();

    public abstract boolean isWalkable();

    public abstract String getType();

}
