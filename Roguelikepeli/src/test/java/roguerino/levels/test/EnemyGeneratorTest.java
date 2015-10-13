
package roguerino.levels.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.Game;
import roguerino.levels.Level;
import roguerino.logic.Logic;

public class EnemyGeneratorTest {
    
    private Game game;
    
    public EnemyGeneratorTest() {
        this.game = new Game();
        game.init();
    }
    @Test
    public void EnemyGeneratorShouldCreateEnemiesCorrectly() {
        Logic logic = game.getLogic();
        Level level = logic.getLevel();
        
        int monsterCount = 0;
        
        for (int i = 0; i < level.getWidth(); i++) {
            for (int j = 0; j < level.getHeight(); j++) {
                if (level.getBlock(i, j).hasEnemy()) {
                    monsterCount++;
                } 
            }
        }
        
        assertTrue(monsterCount == 20);
        
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
