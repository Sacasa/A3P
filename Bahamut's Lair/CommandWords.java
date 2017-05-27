 import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    private HashMap<String, CommandWord> aValidCommands;

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        aValidCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                aValidCommands.put(command.toString(), command);
            }
        }
    } // CommandWords()
    
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = this.aValidCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return this.aValidCommands.containsKey(aString);
    }
    
    /**
     * Permet d'afficher toutes les commandes
     * @return liste des commandes
     */
    public String getCommandList()
    {
        String vString = new String("");
        for(String vCommand : this.aValidCommands.keySet())
            vString += vCommand + " ";
        return vString;
        
    }//getCommandList
} // CommandWords
