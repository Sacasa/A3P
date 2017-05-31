package pkg_command;
import pkg_core.GameEngine;

/**
 * Classe abstraite servant à la création de commandes
 * 
 * @author Quentin Garrido
 * @version 1.0
 */
public abstract class Command
{
    private String aSecondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     * @param pSW Second mot de la commande
     */
    public Command(final String pSW)
    {
        this.aSecondWord = pSW;
    }

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     * @return second mot de la commande
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }

    /**
     * Check whether a second word was entered for this 
     * command.
     * @return true si la commande contient un second mot
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }

    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     * @param secondWord deuxième mot de la commande
     */
    public void setSecondWord(final String secondWord)
    {
        this.aSecondWord = secondWord;
    }

    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     *@param pG GameEngine associé
     */
    public abstract void execute(final GameEngine pG);
} // Command
