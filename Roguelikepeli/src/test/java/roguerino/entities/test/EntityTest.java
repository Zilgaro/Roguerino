/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.entities.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.entities.Enemy;
import roguerino.entities.Player;

/**
 *
 * @author Zilgaro
 */
public class EntityTest {

    @Test
    public void playerShouldNotBeAbleToSetNonPositiveValuesToXAndY() {
        Player player = new Player();
        player.setX(-10);
        player.setY(-10);

        if (player.getX() < 0 || player.getY() < 0) {
            fail("The player was set to negative space");
        }
    }

    @Test
    public void enemyShouldNotBeAbleToSetNonPositiveValuesToXAndYInConstruction() {
        Enemy enemy = new Enemy(-10, -10);

        if (enemy.getX() < 0 || enemy.getY() < 0) {
            fail("The enemy was created to negative space");
        }
    }

    @Test
    public void enemyShouldNotBeAbleToSetNonPositiveValuesToXAndY() {
        Enemy enemy = new Enemy(0, 0);
        enemy.setX(-10);
        enemy.setY(-10);

        if (enemy.getX() < 0 || enemy.getY() < 0) {
            fail("The enemy was set to negative space");
        }
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
