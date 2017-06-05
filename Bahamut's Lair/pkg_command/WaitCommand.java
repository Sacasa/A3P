package pkg_command;
import pkg_core.GameEngine;
import java.util.ArrayList;
import pkg_mechanics.Room;

/**
 * Commande permettant d'attendre ( surtout pour le bahamut)
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class WaitCommand extends Command 
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe WaitCommand
     * @param pCommandWords mot de commande associé
     */
    public WaitCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet de faire passer un "tour", ce qui sert à faire bouger les pnj sans rien faire d'autre majoritairement
     * Mais mettra aussi le bahamut dans la salle 16(cf plan)
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        ArrayList<Room> vRoomList = pGameEngine.getRoomList();
        if(super.hasSecondWord())
        {
            pGameEngine.getGUI().println("Attendre quoi ?");            
        }
        else
        {        
            pGameEngine.getBahamut().setCurrentRoom(vRoomList.get(16));
            vRoomList.get(16).getNPCList().put(pGameEngine.getBahamut().getName(),pGameEngine.getBahamut() );
            pGameEngine.getPlayer().changeRoom(pGameEngine.getPlayer().getCurrentRoom());
            pGameEngine.isBahamutIn();
        }
        
    }//execute
}
