package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;


/**
 * Write a description of class eatCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TalkCommand extends Command
{
    private CommandWords aCommandWords;

    public TalkCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {
        if(super.hasSecondWord())
             pGameEngine.getGUI().println(  pGameEngine.getPlayer().getCurrentRoom().getNPCDialogue(super.getSecondWord()));
        else
            pGameEngine.getGUI().println("A qui voulez vous parler ?");
    }//execute
}
