package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;
import pkg_mechanics.Arme;
import pkg_mechanics.Armor;
/**
 * Write a description of class TakeCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EquipCommand extends Command
{
    private CommandWords aCommandWords;

    public EquipCommand(final CommandWords pCommandWords)
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
            pGameEngine.getGUI().println("Que voulez vous équiper ?");
        }
        else
        {
            if(vInventory.getItem(vName).getClass() == pGameEngine.getPlayer().getArme().getClass())
            {
                pGameEngine.getPlayer().setArme((Arme)vInventory.getItem(vName));
                pGameEngine.getGUI().println("Votre arme est désormais : " + pGameEngine.getPlayer().getArme().getName()); 
            }
            else if(vInventory.getItem(vName).getClass() == pGameEngine.getPlayer().getArmor().getClass())
            {
                pGameEngine.getPlayer().setArmor((Armor)vInventory.getItem(vName));
                pGameEngine.getGUI().println("Votre armure est désormais : " + pGameEngine.getPlayer().getArmor().getName()); 
            }
            else
            {
                pGameEngine.getGUI().println("Cet objet n'est pas équipable");
            }
        }
    }//execute
}
