package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;
import pkg_mechanics.Arme;
import pkg_mechanics.Armor;
/**
 * Write a description of class DropCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DropCommand extends Command
{
    private CommandWords aCommandWords;

    public DropCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {

        String vName = super.getSecondWord(); 
        ItemList vInventory = pGameEngine.getPlayer().getInventory();
        if(vName == null)
        {
            pGameEngine.getGUI().println("Que voulez vous déposer ?");
        }
        else
        {
            if(vInventory.getItem(vName) != null)
            {
                pGameEngine.getGUI().println("Vous déposez " + vInventory.getItem(vName).getItemInformation());
                vInventory.getItem(vName).setCarrier(null);
                pGameEngine.getPlayer().getCurrentRoom().addItem(vInventory.getItem(vName));
                pGameEngine.getPlayer().addCurrentWeight( -vInventory.getItem(vName).getWeight());
                if(vInventory.getItem(vName).getClass() == pGameEngine.getPlayer().getArme().getClass() &&
                (Arme)vInventory.getItem(vName) == pGameEngine.getPlayer().getArme()    )
                {
                    pGameEngine.getPlayer().setArme(new Arme());
                    pGameEngine.getGUI().println("Votre arme est désormais : " + pGameEngine.getPlayer().getArme().getName()); 
                }
                else if(vInventory.getItem(vName).getClass() == pGameEngine.getPlayer().getArmor().getClass() &&
                (Armor)vInventory.getItem(vName) == pGameEngine.getPlayer().getArmor()    )
                {
                    pGameEngine.getPlayer().setArmor(new Armor());
                    pGameEngine.getGUI().println("Votre armure est désormais : " + pGameEngine.getPlayer().getArmor().getName()); 
                }
                vInventory.removeItem(vName);
            }
            else
                pGameEngine.getGUI().println("Cet objet n'est pas présent dans votre inventaire");  
        }
    }//execute
}
