package pkg_command;
import pkg_core.GameEngine;

/**
 * Commande permettant de regarder dans las pièce
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class LookCommand extends Command 
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe LookCommand
     * @param pCommandWords mot de commande associé
     */
    public LookCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet d'afficher la description de la pièce actuelle
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        pGameEngine.getGUI().println(pGameEngine.getPlayer().getCurrentRoom().getLongDescription());
    }//execute
}
