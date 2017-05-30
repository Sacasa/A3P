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
     */
    public BackCommand(final CommandWords pCommandWords)
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
        Stack<Room> vTempRoomStack = pGameEngine.getRoomStack();
        if(vTempRoomStack.isEmpty())
            pGameEngine.getGUI().println("Vous ne pouvez pas revenir en arrière ! ");
        else
            pGameEngine.getPlayer().changeRoom(vTempRoomStack.pop());

    }//execute
}
