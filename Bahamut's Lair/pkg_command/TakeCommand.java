package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;
import pkg_mechanics.Arme;
/**
 * Commande permettant de prendre un objet de la salle
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class TakeCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe TakeCommand
     * @param pCommandWords mot de commande associé
     */
    public TakeCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet de prendre un objet présent dans la salle
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {

        String vName = super.getSecondWord(); 
        ItemList vInventory = pGameEngine.getPlayer().getInventory();
        if(vName == null)
        {
            pGameEngine.getGUI().println("Que voulez vous rammaser ?");
        }
        else
        {
            if(pGameEngine.getPlayer().getCurrentRoom().getItem(vName) != null)
            {
                if(pGameEngine.getPlayer().getCurrentWeight() +pGameEngine.getPlayer().getCurrentRoom().getItem(vName).getWeight() > pGameEngine.getPlayer().getMaxWeight())
                    pGameEngine.getGUI().println("Cet objet est trop lourd pour vous !");
                else
                {
                    vInventory.addItem(pGameEngine.getPlayer().getCurrentRoom().getItem(vName));
                    pGameEngine.getPlayer().getCurrentRoom().getItem(vName).setCarrier(pGameEngine.getPlayer());
                    pGameEngine.getPlayer().getCurrentRoom().removeItem(vName);
                    pGameEngine.getGUI().println("Vous récupérez " + vInventory.getItem(vName).getItemInformation());
                    pGameEngine.getPlayer().addCurrentWeight(vInventory.getItem(vName).getWeight());
                }
            }
            else
                pGameEngine.getGUI().println("Cet objet n'est pas présent dans la salle");
        }
    }//execute
}
