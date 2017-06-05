package pkg_command;

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
    private HashMap<CommandWord, Command> aCommandes;

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
        this.aCommandes = new HashMap<CommandWord, Command>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                aValidCommands.put(command.toString(), command);
            }
        }
        
        
        this.aCommandes.put(CommandWord.HELP, new HelpCommand(this));
        this.aCommandes.put(CommandWord.LOOK, new LookCommand(this));
        this.aCommandes.put(CommandWord.GO, new GoCommand(this));
        this.aCommandes.put(CommandWord.BACK, new BackCommand(this));
        this.aCommandes.put(CommandWord.EAT, new EatCommand(this));
        this.aCommandes.put(CommandWord.TEST, new TestCommand(this));
        this.aCommandes.put(CommandWord.TAKE, new TakeCommand(this));
        this.aCommandes.put(CommandWord.DROP, new DropCommand(this));
        this.aCommandes.put(CommandWord.INVENTAIRE, new InventaireCommand(this));
        this.aCommandes.put(CommandWord.ATTACK, new AttackCommand(this));
        this.aCommandes.put(CommandWord.CHARGE, new ChargeCommand(this));
        this.aCommandes.put(CommandWord.FIRE, new FireCommand(this));
        this.aCommandes.put(CommandWord.ALEA, new AleaCommand(this));
        this.aCommandes.put(CommandWord.TALK, new TalkCommand(this));
        this.aCommandes.put(CommandWord.WAIT, new WaitCommand(this));
        this.aCommandes.put(CommandWord.EQUIP, new EquipCommand(this));
        this.aCommandes.put(CommandWord.USE, new UseCommand(this));
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
    /**
     * Permet de récupérer la commande associé a une chaine de caracteres
     * @param pString chaine de caracters
     * @return commande associée
     */
        public Command getCommand(final String pString)
    {
        for(CommandWord vC : CommandWord.values())
        {
            if(vC.toString().equals(pString))
                return this.aCommandes.get(vC);
        }
        return null;
    }//getCommand()
} // CommandWords
