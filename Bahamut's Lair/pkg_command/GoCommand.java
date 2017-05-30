package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;

import java.util.ArrayList;
/**
 * Write a description of class GoCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords aCommandWords;

    public GoCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param pCommand Commande de changementde piece 
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        if(!super.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            pGameEngine.getGUI().println("Aller où ?");
            return;
        }

        String vDirection = super.getSecondWord();
        // Try to leave current room.
        Room vNextRoom = pGameEngine.getPlayer().getCurrentRoom().getExit(vDirection);

        if (vNextRoom == null)
        {
            pGameEngine.getGUI().println("Il n'y à rien dans cette direction ;)");
        }
        else {
            ArrayList<Room> vTempRoomList = pGameEngine.getRoomList();
            /*pGameEngine.getGUI().println(pGameEngine.getPlayer().getCurrentRoom().toString() + " | " + vTempRoomList.get(1).toString());
            pGameEngine.getGUI().println(vNextRoom + " | " + vTempRoomList.get(2));*/
            pGameEngine.oneMove(pGameEngine.getPlayer().getCurrentRoom());
            if(vTempRoomList.get(1) == pGameEngine.getPlayer().getCurrentRoom() && vTempRoomList.get(2) == vNextRoom)
                pGameEngine.clearStack();
                
            pGameEngine.getPlayer().changeRoom(vNextRoom);           
        }
    }//execute
}
