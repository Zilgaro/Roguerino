
package roguerino.levels.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.levels.Level;
import roguerino.logic.Logic;

public class EnemyGeneratorTest {
    
    private Logic test;
    
    public EnemyGeneratorTest() {
        this.test = new Logic();
    }

    @Test
    public void EnemyGeneratorShouldCreateEnemiesCorrectly() {
        test.run();
        Level level = test.getLevel();
        
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
