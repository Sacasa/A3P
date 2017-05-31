package pkg_mechanics;

import java.util.ArrayList;
/**
 * Write a description of class MovingNPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovingNPC extends NPC
{
    // instance variables - replace the example below with your own
    private Room aCurrentRoom;
    private RoomRandomizer aRoomRandomizer;

    /**
     * Constructor for objects of class MovingNPC
     * @param pD liste des dialogues du personnage
     * @param pN Nom du personnage
     * @param pAR Liste de salles où se déplacer
     * @param pR Piece initiale(non aléatoire)
     */
    public MovingNPC(final ArrayList<String> pD, final String pN, final ArrayList<Room> pAR, final Room pR)
    {
        super(pD,pN);
        this.aRoomRandomizer = new RoomRandomizer(pAR);
        this.aCurrentRoom = pR;
    }//MovingNPC

    public void move()
    {   
        this.aCurrentRoom.getNPCList().remove(super.getName());
        this.aCurrentRoom = this.aRoomRandomizer.getRandomRoom();    
        this.aCurrentRoom.getNPCList().put(super.getName(), this);
    }//move

    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }   

}
