
package roguerino.levels.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.blocks.Empty;
import roguerino.levels.Room;


public class RoomTest {
    
    @Test
    public void ShouldNotBeAbleToPutBlocksOutsideOfRoomBoundaries() {
        Room room = new Room(4,3);
        
        room.setBlock(new Empty(), 5, 5);
        
        assertTrue(room.getBlock(5, 5) == null);             
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
