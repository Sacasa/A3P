package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;

import java.util.ArrayList;
/**
 * Commande permettant de changer de salles
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class GoCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe GoCommad
     * @param pCommandWords mot de commande associé
     */
    public GoCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * Permet d'aller dans une salel adjacente à l'actuelle
     * @param pGameEngine GameEngine qui éxécutera la commande
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
            if(vTempRoomList.get(4) == pGameEngine.getPlayer().getCurrentRoom() && vTempRoomList.get(5) == vNextRoom)
                pGameEngine.clearStack();
                
            pGameEngine.getPlayer().changeRoom(vNextRoom);   
            pGameEngine.isBahamutIn();
        }
    }//execute
}
