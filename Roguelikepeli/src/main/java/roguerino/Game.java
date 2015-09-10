

package roguerino;

public class Game {
    
    private Logic logic;
    
    public void init() {
        this.logic = new Logic();
        this.logic.run();
        
        
    }
}
