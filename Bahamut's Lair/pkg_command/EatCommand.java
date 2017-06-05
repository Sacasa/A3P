package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;

/**
 * Commande permettant de manger
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class EatCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe EatCommand
     * @param pCommandWords mot de commande associé
     */
    public EatCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * Permet de manger et d'effectuer l'action appropriée
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {

        String vName = super.getSecondWord(); 
        ItemList vInventory = pGameEngine.getPlayer().getInventory();
        if(vName == null)
        {
            pGameEngine.getGUI().println("Que voulez vous manger ?");
        }
        else
        {
            if(vInventory.getItem(vName) == null || !vInventory.getItem(vName).isEdible())
                pGameEngine.getGUI().println("Vous n'avez pas d'ojet commestible de ce nom sur vous");
            else
            {
                if(vName.equals("lemba"))
                {
                    pGameEngine.getPlayer().addMaxWeight(5);
                    pGameEngine.getGUI().println("Après avoir mangé le Lemba, votre poids total est devenu " + pGameEngine.getPlayer().getMaxWeight());           
                    pGameEngine.getPlayer().addCurrentWeight( -vInventory.getItem(vName).getWeight());
                    vInventory.removeItem(vName);
                }

            }
        }
    }//execute
}
