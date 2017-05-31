package pkg_command;
import pkg_core.GameEngine;

/**
 * Write a description of class HelpCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WaitCommand extends Command 
{
    private CommandWords aCommandWords;

    public WaitCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {
        if(super.hasSecondWord())
        {
            pGameEngine.getGUI().println("Wait whaaaaaaaaaaaaaaaaaaaat");            
        }
        else
        {        
            pGameEngine.getBahamut().move();
            pGameEngine.getPlayer().changeRoom(pGameEngine.getPlayer().getCurrentRoom());
            pGameEngine.isBahamutIn();
        }
        
    }//execute
}
