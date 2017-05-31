package pkg_mechanics;

import java.util.ArrayList;
/**
 * Room nous téléportant aléatoirement à sa sortie.
 * 
 * @author Quentin Garrido
 * @version 1.0
 */
public class TransporterRoom extends Room
{
    private RoomRandomizer aRandomizer;  
    private Integer aAleaNb;

    /**
     * Constructor for objects of class TransporterRoom
     * @param pD Description de la pièce
     * @param pI image de la pièce
     * @pR Liste de pièces aléatoires dans lesquelles choisir
     */
    public TransporterRoom(final String pD, final String pI, final ArrayList<Room> pR)
    {
        super(pD,pI);
        aRandomizer = new RoomRandomizer(pR);

    }
    
    /**
     * définit la valeur de la pièce ou aller(blocage aléatoire)
     * @param pI
     */
    public void setAlea(final Integer pI)
    {
        this.aAleaNb = pI;
    }

    /**
     * Récupère la sortie de la pièce 
     * @param pE direction de la sortie(ici inutile)
     * @return pièce où aller 
     */    
    @Override
    public Room getExit(String pE)
    {
        if((Integer)this.aAleaNb != null && aAleaNb < this.aRandomizer.getRandomRoomList().size()-1)
            return this.aRandomizer.getRoom(this.aAleaNb);

        //En cas d'erreur ou de comportement aléatoire :
        return aRandomizer.getRandomRoom();

    }


}
