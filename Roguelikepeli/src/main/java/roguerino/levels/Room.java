
package roguerino.levels;

public class Room {
    private int width;
    private int height;
    private Block[][] blocks;
    
    
    public Room(int width, int height){
        this.width=width;
        this.height=height;
        this.blocks = new Block[width][height];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.blocks[j][i]= new Block();
            }
        }
    }
    
    public void setBlock(Block block, int x, int y){
        this.blocks[x][y]=block;
    }
    public Block getBlock(int x, int y){
        return this.blocks[x][y];
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    
}
