package roguerino.movement;

import java.util.ArrayList;
import java.util.Random;
import roguerino.entities.Enemy;
import roguerino.levels.Level;
import roguerino.logic.MovementLogic;

/**
 * "Tekoäly" vihollisten liikuttamiseen
 */
public class EnemyAi {

    private MovementLogic movLogic;
    private Level level;
    private final Random random;

    public EnemyAi(Level level) {
        this.random = new Random();
        this.level = level;
        this.movLogic = new MovementLogic(this.level);

    }

    /**
     * Liikuttaa kaikkia eläviä tason vihollisia satunnaiseen suuntaan.
     *
     * @param enemies EnemyGeneratorin createEnemies()-metodin luoma lista
     * kaikista tason vihollisista, jonka Logic-luokan run() -metodi ottaa
     * talteen sitä ajettaessa.
     *
     * @return True jos kaikki viholliset on merkitty tapetuiksi.
     */
    public boolean run(ArrayList<Enemy> enemies) {
        if (enemies == null) {
            return true;
        }

        int deadCount = 0;
        for (Enemy enemy : enemies) {

            if (!enemy.isAlive()) {
                deadCount++;
                continue;
            }
            int movementKey = random.nextInt(8);
            movLogic.movement(movementKey, enemy);
        }

        return deadCount == enemies.size();

    }
}
