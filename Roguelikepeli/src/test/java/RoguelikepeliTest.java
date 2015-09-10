

import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import roguerino.Game;
import roguerino.Logic;
import roguerino.levels.Block;
import roguerino.levels.Level;
import roguerino.levels.Player;


public class RoguelikepeliTest {
    
    private Game test;
    public RoguelikepeliTest() {
        this.test = new Game();
    }
    
    @Test
    public void badInputFromUser() {
        Logic tester = new Logic();
        ByteArrayInputStream in = new ByteArrayInputStream("lolcat".getBytes());
        try {
            System.setIn(in);
            tester.run();
        } catch(Exception e) {
            fail("You let bad input pass. Subsequently, you fail.");
        }
    }
    
    @Test
    public void creatingBlocksOutOfBounds() {
        Block block = new Block();
        Level level = new Level(10,10);
        
        try {
            level.setBlock(11, 11, block);
        } catch (Exception e){
            fail("You let someone put tiles outside your magical world. For shame.");
        }
    }
    
    @Test
    public void movingOutOfBounds() {
        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream("4".getBytes());
        
        try {
            for (int i = 0; i < test.getLogic().getLevel().getHeight(); i++) {
                System.setIn(in);
            }
            
            for (int i = 0; i < test.getLogic().getLevel().getWidth(); i++) {
                System.setIn(in2);
            }
            
            test.init();
        } catch(Exception e) {
            fail("You let the player get out of the level, now what are you going to do?");
        }
    }
    
    @Test
    public void logicGetBlockFromOutOfBounds() {
        try {
            Block block = test.getLogic().getBlock(1231, 123049);
        } catch (Exception e) {
            fail("Where did you go digging, I wonder?");
        }
    }
    
    @Test
    public void logicValidTestFromOutOfBounds() {        
        assertFalse("Validblock from out of bounds must be false", test.getLogic().validBlock(2323, 23123));
    }
    
    @Test
    public void logicValidTestWithBadMovementKey() {
        assertFalse("Validblock call with bad movementKey must be false", test.getLogic().validBlock(9, 9, 9));
    }
    
    @Test
    public void blockSimultaneoslyBlackAndFloor() {
        Block block = new Block();
        block.setFloor(true);
        assertFalse("Block can't be black and floor at the same time", block.isBlack());
    }
    
    @Test
    public void blockBlackAndHasPlayer() {
        Block block = new Block();
        Player player = new Player();
        block.setPlayer(player);
        
        assertFalse("Block can't be black and have a player", block.hasPlayer());
    }
    
    @Test
    public void levelGetBlockFromOutOfBounds() {
        Level testLevel = this.test.getLogic().getLevel();
        
        try {
            testLevel.getBlock(213123, 213123);
        } catch (Exception e) {
            fail("You tried to get a block from some galaxy far far away, didn't work so well");
        }
    }
    
    @Test
    public void logicValidBlockWithOutOfBoundsCoordinatesAndValidMovement() {
        Logic testLogic = test.getLogic();
        
        assertFalse("Block can't be valid if it is out of bounds", testLogic.validBlock(23423423, 324234234, 5));
    
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
