
package roguerino.levels;

import roguerino.blocks.Blockerino;
import roguerino.blocks.Empty;

/** Room-luokka on toteutukseltaan hieman samanlainen, kuin Level-luokka. Sitä 
 * voikin pitää Ns. mini-levelinä kentän sisällä.
 */
public class Room {
    private int width;
    private int height;
    private Blockerino[][] blocks;
    
    
    //Tyhjä konstruktori eri tyyppejä varten
    public Room() {
    }
    
    
    public Room(int width, int height){
        this.width=width;
        this.height=height;
        this.blocks = new Blockerino[width][height];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.blocks[j][i]= new Empty();
            }
        }
    }  
    public void setBlock(Blockerino block, int x, int y){
        if (this.width > x && this.height > y ) {
            this.blocks[x][y]=block;
        }
    }
    
    
    public Blockerino getBlock(int x, int y){
        if (this.width > x  && this.height > y ) {
            return this.blocks[x][y];
        }
        return null;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    
    
    
}
