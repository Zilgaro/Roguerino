
package roguerino.levels;

import roguerino.blocks.Blockerino;
import roguerino.blocks.Door;
import roguerino.blocks.Empty;
import roguerino.blocks.Floor;
import roguerino.blocks.Wall;

/** 
 * Konstruktoi pienen huoneen generaattorin käyttöön.
 */

public class RoomSmall extends Room{
    
    public final int width = 4;
    public final int height = 3;
    public final Blockerino[][] rakenne;

    public RoomSmall() {
        rakenne = new Blockerino[this.width][this.height];
        Wall wall = new Wall();
        
        
        //menee vähän hassusti mutta menköön
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                if (i == 1 && j == 1) { 
                } else if ( i == 1 && j == 2) {
                } else {
                    rakenne[j][i] = wall;
                }     
            }    
            }   
        
        Blockerino doorBlock = new Door();
        rakenne[1][1] = doorBlock;

        
        Blockerino floorBlock = new Floor();

        
        rakenne[2][1] = floorBlock;

        
        for (int i = 0; i < 3; i++) {
            Blockerino nothingHere = new Empty();
            rakenne[0][i] = nothingHere;
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public Blockerino getBlock(int x, int y) {
        return this.rakenne[x][y];
    }
    
    
    
    
    
}
