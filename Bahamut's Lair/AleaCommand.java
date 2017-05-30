import java.util.ArrayList;
/**
 * Write a description of class AleaCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AleaCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords aCommandWords;

    public AleaCommand(final CommandWords superWords)
    {
        super(null);
        this.aCommandWords = superWords;
    }//Constructeur()

    @Override
    public void execute(final GameEngine pGameEngine)
    {
        ArrayList<Room> vRoomList = pGameEngine.getRoomList();
        if(pGameEngine.getTestMode()){
            TransporterRoom vTemp = (TransporterRoom)vRoomList.get(7);
            if(super.hasSecondWord())
            {
                try{
                    Integer vN = Integer.parseInt(super.getSecondWord());
                    vTemp.setAlea(vN);
                    pGameEngine.getGUI().println("L'aléatorie est réglé sur la pièce" + Integer.parseInt(super.getSecondWord()));
                }
                catch(Exception pE)
                {
                    pGameEngine.getGUI().println("Vous n'avez pas indiquez un nombre valide !");
                }
            }
            else
            {
                vTemp.setAlea(null); 
                pGameEngine.getGUI().println("La sélection de room est devenu aléatoire");
            }
        }
        else
            pGameEngine.getGUI().println("Il faut être en mode test pour utiliser cette commande");
    }//execute
}
