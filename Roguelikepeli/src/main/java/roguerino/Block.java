

package roguerino;


public class Block {
    
    private Player player;
    private boolean black; //black tarkoittaa tyhjää johon ei voi astua
    private boolean floor; //floor taas astuttava

    public Block() {
        this.player = null;
        this.black = true;
        this.floor = false;
    }

    public Block(Player player, boolean black, boolean floor) {
        this.player = player;
        this.black = black;
        this.floor = floor;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public boolean isBlack() {
        return black;
    }

    public void setPlayer(Player player) { //null = ei pelaajaa
        this.player = player;
    }

    public boolean hasPlayer() { //Tarkistetaan, onko pelaaja blockin päällä
        if (player == null)
            return false;
        return true;
    }

    public void setFloor(boolean floor) {
        this.floor = floor;
    }

    public boolean isFloor() {
        return floor;
    }
    
    
    
    
    
    
    
    
    
}
