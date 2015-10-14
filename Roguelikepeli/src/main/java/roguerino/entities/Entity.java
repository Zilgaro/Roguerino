package roguerino.entities;

/**
 * Rajapinta, jonka pelaaja ja viholliset toteuttavat, helpottaa muun muassa
 * liikkumistoiminnallisuuden käyttöä.
 */
public interface Entity {
    
    
    public String getType();
    public int getX();
    public int getY();
    public void setX(int x);
    public void setY(int y);
}
