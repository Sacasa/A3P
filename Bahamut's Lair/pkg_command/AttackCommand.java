package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.Room;
import pkg_mechanics.NPC;

import java.util.ArrayList;
/**
 * Write a description of class AttackCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AttackCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe AttackCommand
     * @param pCommandWords mot de commande associé
     */
    public AttackCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * permet d'attaquer un NPC si il est dans la pièce 
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        if(!super.hasSecondWord())
            pGameEngine.getGUI().println("Qui voulez vous attaquer");
        else if(pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord()) == null)
        {
            pGameEngine.getGUI().println("Ce personnage n'est pas dans la pièce actuelle") ;        
        }
        else if((!pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord()).getKillable()))
        {
            pGameEngine.getGUI().println(pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord()).getName() +" esquive votre attaque.");

        }
        else
        {
            NPC vNPC = pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord());
            System.out.println(vNPC.getHP() + " "+pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord()).getHP());
            double vPDegats = pGameEngine.getPlayer().getDegats() * (100-vNPC.getArmure())/100.0;
            vPDegats = Math.round(vPDegats*100)/100;
            double vNPCDegats = vNPC.getDegats() * (100 - pGameEngine.getPlayer().getRes())/100.0;
            vNPCDegats = Math.round(vNPCDegats*100)/100;;

            pGameEngine.getGUI().println("Vous attaquez " + vNPC.getName() + " et lui infligez " +
                vPDegats +" points de degat");  
            vNPC.addHP(-vPDegats);
            System.out.println(vNPC.getHP() + " "+pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord()).getHP());
            String vNPCString = vNPC.status();
            pGameEngine.getGUI().println(vNPCString);
            if(vNPC.getHP() < 0)
            {
                pGameEngine.getGUI().showImage(pGameEngine.getPlayer().getCurrentRoom().getImageName());                    
            }
            else
            {
                pGameEngine.getGUI().println(vNPC.getName() + " vous attaque et vous inflige " +
                    vNPCDegats +" points de degat");  
                pGameEngine.getPlayer().addHP(-vNPCDegats);

                pGameEngine.getPlayer().status();
            }
        }
    }//execute
}
