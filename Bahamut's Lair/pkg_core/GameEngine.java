/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (Jan 2003)
 */


package pkg_core;
import pkg_mechanics.Player;
import pkg_mechanics.Parser;
import pkg_mechanics.Room;
import pkg_mechanics.TransporterRoom;
import pkg_mechanics.Beamer;
import pkg_mechanics.Item;
import pkg_command.Command;





import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameEngine
{
    private Parser aParser; 
    private UserInterface aGui;
    private ArrayList<Room> aRoomList;
    private Stack<Room> aRoomStack;
    private Player aPlayer;
    private int aNbMoves;
    private static final int MAX_MOVES = 20;
    private boolean aTestMode ;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aRoomList = new ArrayList<Room>(7);
        this.aRoomStack = new Stack<Room>();
        createRooms();
        this.aPlayer = new Player("Quentin",50,this.aRoomList.get(0));
        this.aTestMode = true;
    }//GameEngine

    /**
     * Définit le GUI
     * @param pUserInterface UserInterface
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui =  pUserInterface;
        this.aPlayer.setGui(aGui);
        printWelcome();
    }//setGui

    public UserInterface getGUI()
    {
        return this.aGui;
    }

    public Player getPlayer()
    {
        return this.aPlayer;

    }

    /** 
     * Afiche le lieu actuel ainsi que les différentes sorties
     * 
     */
    public void printLocation()
    {
        aGui.println(this.aPlayer.getCurrentRoom().getLongDescription()   );   
    }//printlocation

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        aGui.println("Bienvenue dans Bahamut's Lair !\n le Roi est très malade et dans " + this.MAX_MOVES + " déplacements il décedera!" +"\nTapez 'help' si vous avez besoin d'aide.\n\n"); 
        this.printLocation();
        aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }//printWelcome

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {

        //Montagne

        Room vEntreeH = new Room("face à l'entrée de l'antre du Bahamut","./Images/EntreeH.jpg"); 
        vEntreeH.addItem(new Item("lemba", "un lemba, pain magiue elfique", 1, true));
        vEntreeH.addItem(new Beamer());
        Room vSommetEst = new Room("sur le flanc est de la motagne","./Images/Montagne.jpg");
        vSommetEst.addItem(new Item("torche","une torche pour vous éclairer dans ce donjon",1, false));

        //Etage 1

        Room vEntreeB = new Room("dans l'entrée de l'antre, l'escalier pour sortir s'est refermé, vous ne pouvez plus partir désormais.","./Images/EntreeB.jpg");
        Room vRagnarok = new Room("dans la salle ou se trouve Ragnarok, la lance légendaire","./Images/Ragnarok.jpg");
        vRagnarok.addItem(new Item("ragnarok","Ragnarok, lance légendaire",5, false));
        vRagnarok.addItem(new Item("casque","Le casque ayant appartenu au derneir gardien de ces lieux", 1, false));
        Room vEscalierH = new Room("en haut de l'escalier principal de l'antre","./Images/Mine.jpg");

        //Etage 2

        Room vEscalierB = new Room("en bas de l'escalier principal de l'antre","./Images/Escalier.jpg");
        Room vBahamut = new Room("dans la salle du Bahamut, vous apercevez ses yeux dans l'obscurité","./Images/Bahamut.jpg");

        //Sorties

        vSommetEst.setExit("ouest", vEntreeH);
        vEntreeH.setExit("est", vSommetEst);
        vEntreeH.setExit("bas", vEntreeB);

        //Enlever la sortie vers le haut pour trapdoor
        //vEntreeB.setExit("haut", vEntreeH);
        vEntreeB.setExit("ouest",vRagnarok);
        vEntreeB.setExit("sud",vEscalierH);
        vRagnarok.setExit("est", vEntreeB);
        vEscalierH.setExit("bas", vEscalierB);
        vEscalierH.setExit("nord", vEntreeB);

        vEscalierB.setExit("haut", vEscalierH);
        vEscalierB.setExit("nord", vBahamut);
        vBahamut.setExit("sud", vEscalierB);

        //add Rooms to list

        aRoomList.add(vSommetEst);
        aRoomList.add(vEntreeH);
        aRoomList.add(vEntreeB);
        aRoomList.add(vRagnarok);
        aRoomList.add(vEscalierH);
        aRoomList.add(vEscalierB);
        aRoomList.add(vBahamut);

        Room vTransporter = new TransporterRoom("dans une salle où se trouve seulement un téléporteur, même pas de porte !","./Images/Transporter.jpg",this.aRoomList);
        aRoomList.add(vTransporter);
        vEscalierB.setExit("est",vTransporter);
        System.out.println(aRoomList.get(7).toString());

    }//createrooms
    /**
     * Permet de reafficher la description du lieu actuel
     */
    public void look()
    {
        this.printLocation();        
    }//look

    public void setTestMode(final boolean pB)
    {
        this.aTestMode = pB;
    }
    
    public boolean getTestMode()
    {
        return this.aTestMode;
    }
    
    public Parser getParser()
    {
        return this.aParser;        
    }

    /**
     * Permet d'attaquer l'ennemi dans la salle
     */
    public void attack()
    {
        aGui.print("Vous attaquez");
        if(this.aPlayer.getCurrentRoom() == aRoomList.get(6))
        {
            aGui.println(" le Bahamut, et d'une série d'estocade triomphez de la bête,\nVous avez gagné!");
            aGui.showImage("Images/Fin.jpg");
            aGui.enable(false);
        }
        else
            aGui.println(" le vide et vous fatiguez pour rien");
    }//attack

    /**
     * Permetde se suicider
     */
    private void harakiri()
    {
        aGui.println("En ayant marre de votre aventure,\nvous décidez de mourrir honorablement et de réaliser un HARAKIRI");
        this.mort();
    }//harakiri

    public Stack<Room> getRoomStack()
    {
        return this.aRoomStack;
    }

    public ArrayList<Room> getRoomList()
    {
        return this.aRoomList;
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param pCommandLine commande à interpréter
     */
    public void interpretCommand(final Command pCommand) 
    {
        /*CommandWord vCommandWord = pCommand.getCommandWord();*/
        if(pCommand == null)
        {
            this.aGui.println("Je ne comprends pas :/");
        }else{
            pCommand.execute(this);        
        }

        /*
        switch(vCommandWord)
        {
        case UNKNOWN:
        this.aGui.println("Je ne comprends pas !");
        break;
        case HELP:
        this.printHelp();
        break;
        case GO:
        this.goRoom(pCommand);
        break;
        case LOOK:
        this.look();
        break;
        case EAT:
        if(!pCommand.hasSecondWord())
        this.aGui.println("Que vouelz vous manger ?");
        else
        this.aPlayer.eat(pCommand.getSecondWord());
        break;
        case HARAKIRI:
        this.harakiri();
        break;
        case ATTACK:
        this.attack();
        break;
        case BACK:
        if(pCommand.hasSecondWord())
        aGui.println("Reculer de quoi ?");
        else if( this.aPlayer.getCurrentRoom() == this.aRoomStack.peek())
        aGui.println("Vous n'avez aucun lieu où aller en arrière ! ");
        else
        this.back();
        break;         
        case TEST:
        if(!pCommand.hasSecondWord())
        aGui.println("Tester quoi ?");
        else 
        this.test(pCommand.getSecondWord());
        break;
        case TAKE:
        if(!pCommand.hasSecondWord())
        aGui.println("Prendre quoi ?");
        else 
        this.aPlayer.take(pCommand.getSecondWord());
        break;
        case DROP:
        if(!pCommand.hasSecondWord())
        aGui.println("Jeter quoi ?");
        else 
        this.aPlayer.drop(pCommand.getSecondWord());
        break;
        case INVENTAIRE:
        if(pCommand.hasSecondWord())
        aGui.println("Inventaire de quoi ?");
        else
        this.aPlayer.inventory();
        break;
        case QUIT: 
        if(pCommand.hasSecondWord())
        aGui.println("Quitter quoi");
        else
        endGame();
        break;   
        case CHARGE:
        if(pCommand.hasSecondWord())
        aGui.println("Charger quoi?");
        else
        this.aPlayer.charge();
        break;
        case FIRE:
        if(pCommand.hasSecondWord())
        aGui.println("fire quoi ?");
        else
        {   
        this.aPlayer.fire();
        this.clearStack();
        }
        case ALEA:
        if(this.aTestMode){
        TransporterRoom vTemp = (TransporterRoom)this.aRoomList.get(7);
        if(pCommand.hasSecondWord())
        {
        try{
        Integer vN = Integer.parseInt(pCommand.getSecondWord());
        vTemp.setAlea(vN);
        this.aGui.println("L'aléatorie est réglé sur la pièce" + Integer.parseInt(pCommand.getSecondWord()));
        }
        catch(Exception pE)
        {
        this.aGui.println("Vous n'avez pas indiquez un nombre valide !");
        }
        }
        else
        {
        vTemp.setAlea(null); 
        this.aGui.println("La sélection de room est devenu aléatoire");
        }
        }
        else
        this.aGui.println("Il faut être en mode test pour utiliser cette commande");
        break;        
        default :
        this.aGui.println("ERROR");
        break;

        }*/
    }//interpretCommand

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        aGui.println("Vous êtes seul et perdu. \nVous vous trouvez dans la montagne sacrée du Bahamut.\n");
        aGui.println("Vos commandes sont: ");
        aGui.println(aParser.showCommands());
    }//printHelp

    public void clearStack()
    {
        while(!this.aRoomStack.isEmpty())     
        {
            this.aRoomStack.pop();
        }

    }


    public void oneMove(final Room pR)
    {
        if(this.aNbMoves + 1 >= this.MAX_MOVES)
        {
            this.mort();
            return;           
        }
        this.aRoomStack.push(pR);
        this.aNbMoves ++ ; 
    }

    /**
     * Nous fait revenir à la salle précédente
     */
    private void back()
    {
        this.aPlayer.changeRoom(this.aRoomStack.pop());
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if(this.aPlayer.getCurrentRoom().getImageName() != null)
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName()); 
    }

    /**
     * 
     * Methode à appeler en cas de mort
     */
    private void mort()
    {
        aGui.showImage("Images/Mort.jpg");
        aGui.enable(false);

    }//mort

    /**
     * MEthode de fin de jeu
     */
    private void endGame()
    {
        aGui.println("Merci d'avoir joué !");
        aGui.enable(false);
    }//endgame  
}
