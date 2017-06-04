package pkg_mechanics;

import java.util.ArrayList;
/**
 * Sert a créer des NPC se déplaçant
 *
 * @author Quentin Garrido
 * @version 1.0
 */
public class MovingNPC extends NPC
{
    // instance variables - replace the example below with your own
    
    private RoomRandomizer aRoomRandomizer;

    /**
     * Constructor for objects of class MovingNPC
     * @param pD liste des dialogues du personnage
     * @param pN Nom du personnage
     * @param pAR Liste de salles où se déplacer
     * @param pR Piece initiale(non aléatoire)
     */
    public MovingNPC(final ArrayList<String> pD, final String pN,final double pHP, final int pDegats, final int pArmure, final boolean pK, final Item pLoot, final Room pCR, final ArrayList<Room> pAR)
    {
        super(pD,pN,pHP,pDegats,pArmure,pK,pLoot,pCR);
        this.aRoomRandomizer = new RoomRandomizer(pAR);

    }//MovingNPC

    /**
    *déplace le personnage dans une nouvelle pièce aléatoire
    */
    public void move()
    {   
        super.getCurrentRoom().getNPCList().remove(super.getName());
        super.setCurrentRoom(this.aRoomRandomizer.getRandomRoom());    
        super.getCurrentRoom().getNPCList().put(super.getName(), this);
    }//move

}
