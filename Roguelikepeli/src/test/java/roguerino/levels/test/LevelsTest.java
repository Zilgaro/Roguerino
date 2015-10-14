
package roguerino.levels.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import roguerino.blocks.Blockerino;
import roguerino.blocks.Wall;
import roguerino.logic.Logic;
import roguerino.levels.Level;
import roguerino.entities.Player;


public class LevelsTest {
    private Logic test;
    
    public LevelsTest() {
        this.test = new Logic();
    }
    
    @Test
    public void levelGetBlockFromOutOfBounds() {
        Level testLevel = this.test.getLevel();
        
        try {
            testLevel.getBlock(213123, 213123);
        } catch (Exception e) {
            fail("You tried to get a block from some galaxy far far away, didn't work so well");
        }
    }
    
    @Test
    public void levelBlockSetPlayerToWallOrBlack() {
        Level testLevel = this.test.getLevel();
        Blockerino block = new Wall();
        testLevel.setBlock(0, 0, block);
        Player player = new Player();
        testLevel.getBlock(0, 0).setEntity(player);
        
        assertFalse("A block that is a wall and/or black can't have a player", testLevel.getBlock(0, 0).hasPlayer());
        
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
