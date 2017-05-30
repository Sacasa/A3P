package pkg_mechanics;


import java.util.ArrayList;
/**
 * Write a description of class RoomRandomizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomRandomizer
{
    private ArrayList<Room> aRoomList;
    
    
    public RoomRandomizer(final ArrayList<Room> pA)
    {
        this.aRoomList = pA;
    }
    
    
    public Room getRandomRoom()
    {
        int vIndex = (int)(Math.random() * (aRoomList.size()-1));
        return aRoomList.get(vIndex);
    }
    
    public ArrayList<Room> getRandomRoomList()
    {
        return this.aRoomList;
    }
    
    public Room getRoom(final int pI)
    {
        return this.aRoomList.get(pI);       
        
    }  
}
