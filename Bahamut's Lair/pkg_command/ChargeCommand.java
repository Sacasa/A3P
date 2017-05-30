package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Beamer;


/**
 * Write a description of class ChargeCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChargeCommand extends Command
{
    private CommandWords aCommandWords;

    public ChargeCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {
        Beamer vbeamer;
        if(pGameEngine.getPlayer().isCarried("beamer"))
        {
            vbeamer =(Beamer)pGameEngine.getPlayer().getInventory().getItem("beamer");
            vbeamer.charge();
            pGameEngine.getGUI().println("Vous chargez le beamer dans cette salle");
        } 
        else
            pGameEngine.getGUI().println("Vous ne portez pas le beamer");
    }//execute
}
