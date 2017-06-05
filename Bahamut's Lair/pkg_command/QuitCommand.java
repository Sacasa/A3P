package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;

/**
 * Commande permettant de quitter le jeu.
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class QuitCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe QuitCommand
     * @param pCommandWords mot de commande associé
     */
    public QuitCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * Permet de quitter le jeu
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        pGameEngine.getGUI().enable(false);
        pGameEngine.getGUI().println("Merci d'avoir joué!");
    }//execute
}
