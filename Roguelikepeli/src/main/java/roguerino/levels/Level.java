

package roguerino.levels;

public class Level {
    
    private Block[][] blocks;
    private int height;
    private int width;

    public Level(int height, int width) {
        this.height = height;
        this.width = width;
        this.blocks = new Block[this.width][this.height];
        
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
             this.blocks[i][j]=new Block();
            }
        }
    }
    
    public void setBlock(int x, int y, Block block) {
        if (x <= this.width && y <= this.height) {
            this.blocks[x][y] = block;
        }
 
    }

    public Block getBlock(int x, int y) {
        if (this.height >= y && this.width >= x) {
            return this.blocks[x][y];
        }
        return null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
}
