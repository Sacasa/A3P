package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;
import java.util.ArrayList;

/**
 * Commande permettant d'utiliser un objet
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class UseCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe WaitCommand
     * @param pCommandWords mot de commande associé
     */
    public UseCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet d'utiliser un objet pour par exemple terminer le jeu
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        String vName = super.getSecondWord(); 
        ArrayList vRoomList = pGameEngine.getRoomList();
        ItemList vInventory = pGameEngine.getPlayer().getInventory();
        if(vName == null)
        {
            pGameEngine.getGUI().println("Utiliser quoi ?");
        }
        else if(vInventory.getItem(vName) == null)
        {
            pGameEngine.getGUI().println("Vous ne portez pas cet objet !");
        }
        else if(vName.equals("fiole") && pGameEngine.getPlayer().getCurrentRoom() == vRoomList.get(2))
        {
            //Victoire
            pGameEngine.getGUI().println("Vous apercevez le Roi se sentir mieux, comme par magie. Il vous remercie mille fois de l'avoir sauvé.\nVous partez célébrer son rétablissementautour d'un festin digne des rois !");
            pGameEngine.getGUI().println("Bravo à vous ! Vous avez triomphé de Bahamut's Lair!!!");
            pGameEngine.getGUI().showImage("Images/victoire.jpg");
            pGameEngine.getGUI().enable(false);

        }
        else
        {
            pGameEngine.getGUI().println("Vous utilisez " + vName + " mais rien ne se passe.");
        }

    }//execute
}
