package pkg_mechanics;


import java.util.ArrayList;
/**
 * Permet d'obtenir une room aléatoire
 * 
 * @author quentin Garrido
 * @version 1.0
 */
public class RoomRandomizer
{
    private ArrayList<Room> aRoomList;
    
    /**
     * Constructor du Randomizer
     * @param pA ArrayList de room
     */
    public RoomRandomizer(final ArrayList<Room> pA)
    {
        this.aRoomList = pA;
    }
    
    /**
     * Retourne une pièce aléatoire
     * @return pièce aléatoire
     */
    public Room getRandomRoom()
    {
        int vIndex = (int)(Math.random() * (aRoomList.size()-1));
        return aRoomList.get(vIndex);
    }
    
    /**
     * retourne la liste des room
     * @return ArrayList des Rooms
     */
    public ArrayList<Room> getRandomRoomList()
    {
        return this.aRoomList;
    }
    
    /**
     * Récupère une pièce de la liste
     * @param pI indice de la pièce dans la liste
     * @return pièce en question
     */
    public Room getRoom(final int pI)
    {
        return this.aRoomList.get(pI);       
        
    }  
}
