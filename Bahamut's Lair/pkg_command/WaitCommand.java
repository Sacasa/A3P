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
    /**
     * Constructeur de la classe WaitCommand
     * @param pCommandWords mot de commande associé
     */
    public WaitCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet de faire passer un "tour", ce qui sert à faire bouger les pnj sans rien faire d'autre majoritairement
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        if(super.hasSecondWord())
        {
            pGameEngine.getGUI().println("Attendre quoi ?");            
        }
        else
        {        
            pGameEngine.getBahamut().move();
            pGameEngine.getPlayer().changeRoom(pGameEngine.getPlayer().getCurrentRoom());
            pGameEngine.isBahamutIn();
        }
        
    }//execute
}
