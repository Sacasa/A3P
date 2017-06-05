package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;
import java.util.Stack;
/**
 * Commande permettant de revenir une salle en arrière
 *
 * @author Quentin GARRIDO
 * @version 1.0
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
