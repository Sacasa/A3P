import java.util.ArrayList;
/**
 * Write a description of class TransporterRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransporterRoom extends Room
{
    private RoomRandomizer aRandomizer;  
    private Integer aAleaNb;

    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(final String pD, final String pI, final ArrayList<Room> pR)
    {
        super(pD,pI);
        aRandomizer = new RoomRandomizer(pR);

    }

    public void setAlea(final Integer pI)
    {
        this.aAleaNb = pI;
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
        System.out.println("Aleatoire :" + aAleaNb);
        if((Integer)this.aAleaNb != null && aAleaNb < this.aRandomizer.getRandomRoomList().size()-1)
            return this.aRandomizer.getRoom(this.aAleaNb);

        //En cas d'erreur ou de comportement aléatoire :
        return aRandomizer.getRandomRoom();

    }


}
