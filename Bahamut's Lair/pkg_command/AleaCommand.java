package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;
import pkg_mechanics.TransporterRoom;

import java.util.ArrayList;
/**
 * Commande permettant de bloquer l'aléatoire ou non
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class AleaCommand extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe AleaCommand
     * @param pCommandWords mot de commande associé
     */
    public AleaCommand(final CommandWords superWords)
    {
        super(null);
        this.aCommandWords = superWords;
    }//Constructeur()
    /** 
     * permet de bloquer l'aléatoire des transporter room ou de le réactiver
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        ArrayList<Room> vRoomList = pGameEngine.getRoomList();
        if(pGameEngine.getTestMode()){
            TransporterRoom vTemp = (TransporterRoom)vRoomList.get(8);
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
