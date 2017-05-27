import java.util.ArrayList;
/**
 * Write a description of class TransporterRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransporterRoom extends Room
{
    final RoomRandomizer aRandomizer;    
    
    
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(final String pD, final String pI, final ArrayList<Room> pR)
    {
        super(pD,pI);
        aRandomizer = new RoomRandomizer(pR);
        
    }
    
    /**
     * 
     * @p
     * 
     * 
     */    
    @Override
    public Room getExit(String pE)
    {
        return aRandomizer.getRandomRoom();
        
    }
    
}
