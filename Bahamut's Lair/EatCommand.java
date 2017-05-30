
/**
 * Write a description of class eatCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EatCommand extends Command
{
    private CommandWords aCommandWords;

    public EatCommand(final CommandWords pCommandWords)
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
