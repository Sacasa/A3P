package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;
import java.util.Stack;
/**
 * Write a description of class BackCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BackCommand extends Command
{
    private CommandWords aCommandWords;

    /**
     * Constructor for objects of class BackCommand
     * @param pCommandWords mot de commande associé
     */
    public BackCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    /** 
     * Retourne en arrière si cela est possible, sinon affiche un message d'erreur
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        Stack<Room> vTempRoomStack = pGameEngine.getRoomStack();
        if(vTempRoomStack.isEmpty())
            pGameEngine.getGUI().println("Vous ne pouvez pas revenir en arrière ! ");
        else
            pGameEngine.getPlayer().changeRoom(vTempRoomStack.pop());

    }//execute
}
