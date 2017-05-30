package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;

import java.util.ArrayList;
/**
 * Write a description of class AttackCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AttackCommand extends Command
{
    private CommandWords aCommandWords;

    public AttackCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {
        ArrayList<Room> vRoomList = pGameEngine.getRoomList();
        pGameEngine.getGUI().print("Vous attaquez");
        if(pGameEngine.getPlayer().getCurrentRoom() == vRoomList.get(6))
        {
            pGameEngine.getGUI().println(" le Bahamut, et d'une série d'estocade triomphez de la bête,\nVous avez gagné!");
            pGameEngine.getGUI().showImage("Images/Fin.jpg");
            pGameEngine.getGUI().enable(false);
        }
        else
            pGameEngine.getGUI().println(" le vide et vous fatiguez pour rien");
    }//execute
}
