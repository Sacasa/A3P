package pkg_command;
import pkg_core.GameEngine;
import pkg_mechanics.ItemList;

/**
 * Write a description of class eatCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TalkCommand extends Command
{
    private CommandWords aCommandWords;
    /**
     * Constructeur de la classe TalkCommand
     * @param pCommandWords mot de commande associé
     */
    public TalkCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }//Constructeur()
    /** 
     * Permet de parler à un NPC si il est dans la pièce
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        if(super.hasSecondWord())
            if(pGameEngine.getPlayer().getCurrentRoom().getNPC(super.getSecondWord()) != null)
                pGameEngine.getGUI().println(  pGameEngine.getPlayer().getCurrentRoom().getNPCDialogue(super.getSecondWord()));
            else
                pGameEngine.getGUI().println("Ce personnage n'est pas dans la pièce !");
        else
            pGameEngine.getGUI().println("A qui voulez vous parler ?");
    }//execute
}
