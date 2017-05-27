import java.util.Scanner;

/*
 * This class is part of "World of Zuul". "World of Zuul" is a simple, 
 * text based adventure game.
 *
 * This parser takes user input and tries to interpret it as a "Zuul"
 * command. Every time it is called it takes a line as a String and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes (DB edited)
 * @version 2.0 (Jan 2003)
 */

public class Parser 
{

    private CommandWords aCommandWords;  // holds all valid command words

    /**
     * Create a new Parser.
     */
    public Parser() 
    {
        this.aCommandWords = new CommandWords();
    } // Parser()

    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     * @param pInputLine Texte à analyser
     * @return retourne la ocmmande du texte recu en param
     */
    public Command getCommand( final String pInputLine ) 
    {
            
        String word1 = null;
        String word2 = null;

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(pInputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        return new Command(aCommandWords.getCommandWord(word1), word2);
    } // getCommand(.)

    /**
     * Returns a String with valid command words.
     * @return lise des commandes 
     */
    public String showCommands() // bad name for this method !
    {
        return this.aCommandWords.getCommandList();
    } // showCommands() // bad name for this method !

} // Parser
