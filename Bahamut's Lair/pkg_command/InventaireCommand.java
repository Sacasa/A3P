package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;
import pkg_mechanics.Arme;
import pkg_mechanics.Armor;

/**
 * Commande permettant d'afficher l'inventaire
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class InventaireCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe InventaireCommand
     * @param pCommandWords mot de commande associé
     */
    public InventaireCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet d'afficher l'inventaire
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {

        String vName = super.getSecondWord(); 
        ItemList vInventory = pGameEngine.getPlayer().getInventory();
        if (vInventory.isEmpty())
            pGameEngine.getGUI().println("Votre inventaire est vide"+ "\n" + pGameEngine.getPlayer().getEquipment());
        else
        {
            String vString = "Dans voter inventaire se trouvent : "+ vInventory.toString() + " pour un poids total de " + pGameEngine.getPlayer().getCurrentWeight()+ "\n" + pGameEngine.getPlayer().getEquipment();
            pGameEngine.getGUI().println(vString);
        }
    }//execute
}
