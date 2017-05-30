
/**
 * Write a description of class FireCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FireCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords aCommandWords;

    public FireCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {
        Beamer vbeamer;
        if(pGameEngine.getPlayer().isCarried("beamer"))
        {
            vbeamer =(Beamer)pGameEngine.getPlayer().getInventory().getItem("beamer");
            if(vbeamer.getChargedRoom() == null)
                pGameEngine.getGUI().println("Vous n'avez pas encore chargé le beamer !"); 
            else
            {
                vbeamer.fire();
                pGameEngine.getGUI().println("Vous utilisez le beamer et êtes téléporté");
            }
        } 
        else
            pGameEngine.getGUI().println("Vous ne portez pas le beamer !");
    }//execute
}