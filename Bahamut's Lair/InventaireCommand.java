
/**
 * Write a description of class InventaireCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InventaireCommand extends Command
{
    private CommandWords aCommandWords;

    public InventaireCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {

        String vName = super.getSecondWord(); 
        ItemList vInventory = pGameEngine.getPlayer().getInventory();
        if (vInventory.isEmpty())
            pGameEngine.getGUI().println("Votre inventaire est vide");
        else
        {
            String vString = "Dans voter inventaire se trouvent : "+ vInventory.toString() + " pour un poids total de " + pGameEngine.getPlayer().getCurrentWeight();
            pGameEngine.getGUI().println(vString);
        }
    }//execute
}
