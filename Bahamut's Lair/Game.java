/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, call the method main.
 * 
 *  This main class creates the necessary implementation objects and starts the game off.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2.0 (Jan 2003)
 */
import pkg_core.GameEngine;
import pkg_core.UserInterface;


public class Game
{
    /**
     * Create the game and initialise its internal map.
     */
    public static void main(final String[] pArgs)
    {
		GameEngine vEngine = new GameEngine();
		UserInterface vGui = new UserInterface(vEngine);
		vEngine.setGUI(vGui);
    }//Game)
}//Game
