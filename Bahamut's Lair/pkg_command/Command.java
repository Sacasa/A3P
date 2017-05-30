package pkg_command;
import pkg_core.GameEngine;


public abstract class Command
{
    private String aSecondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command(final String pSW)
    {
        this.aSecondWord = pSW;
    }

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }

    /**
     * Check whether a second word was entered for this 
     * command.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }

    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String secondWord)
    {
        this.aSecondWord = secondWord;
    }

    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract void execute(final GameEngine pG);
} // Command
