package pkg_mechanics;


/**
 * Write a description of class Beamer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Beamer extends Item
{
    // instance variables - replace the example below with your own
    private Room aChargedRoom;

    /**
     * Constructor for objects of class Beamer
     */
    public Beamer()
    {
        super("beamer","Un beamer, objet antique permettant de se téléporter", 5,false);
 
    }
    
    public void charge()
    {
        this.aChargedRoom = this.getCurrentRoom();
        
        
    }
    
    public void fire()
    {
            super.getCarrier().changeRoom(aChargedRoom);
    }
    
    public Room getCurrentRoom()
    {
       return super.getCarrier().getCurrentRoom();
    }
    
    public Room getChargedRoom()
    {
        return this.aChargedRoom;
    }
}
