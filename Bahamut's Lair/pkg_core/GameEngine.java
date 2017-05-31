
package pkg_core;
import pkg_mechanics.Player;
import pkg_mechanics.Parser;
import pkg_mechanics.Room;
import pkg_mechanics.TransporterRoom;
import pkg_mechanics.Beamer;
import pkg_mechanics.Item;
import pkg_command.Command;
import pkg_mechanics.NPC;
import pkg_mechanics.MovingNPC;
import pkg_mechanics.Arme;
import pkg_mechanics.Armor;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author  Quentin GARRIDO
 * @version 1.0 (June 2017)
 */
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
    private MovingNPC aBahamut;

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

    /**
     * retourne l'IHM
     * @return l'interface graphique
     */
    public UserInterface getGUI()
    {
        return this.aGui;
    }

    /**
     * retourne le player
     * @return le player
     */
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

        ArrayList<String> vDialogueNain = new ArrayList<String>();
        vDialogueNain.add("Bonjour aventurrrrrier !, qu'est ce qui vous amenes ici ?");
        vDialogueNain.add("Salopperrrrie de drrragon en bas !");
        vDialogueNain.add("Mais où est mon orrr");
        vDialogueNain.add("Beurrrrk encore un elfe");

        ArrayList<String> vDialogueKenny = new ArrayList<String>();
        vDialogueKenny.add("Mmmph mph mmmhp");
        vDialogueKenny.add("mmmmmmmphhhh mmm");
        vDialogueKenny.add("mmmmmmph mmmmmh");
        vDialogueKenny.add("hmmmmph hmmmmph mmm mm");

        ArrayList<String> vDialogueCartman = new ArrayList<String>();
        vDialogueCartman.add("Salut enculé de merde !");
        vDialogueCartman.add("C'est un dauphin-juif. Un juifin !");
        vDialogueCartman.add("Je suis pas gros. je suis jovial et épanoui !");
        vDialogueCartman.add("Toi, tu fais des mômes et tu fermes ta gueule");
        vDialogueCartman.add("Je vous emmerde etje rentre à ma maison");

        vEntreeH.addNPC(new NPC(vDialogueNain, "Gimli"));
        vEntreeH.addItem(new Item("lemba", "un lemba, pain magiue elfique", 1, true));
        vEntreeH.addItem(new Beamer());
        Room vSommetEst = new Room("sur le flanc est de la motagne","./Images/Montagne.jpg");
        vSommetEst.addItem(new Item("torche","une torche pour vous éclairer dans ce donjon",1, false));

        ArrayList<String> vDialogueBahamut = new ArrayList<String>();
        vDialogueBahamut.add("Que faites vous ici ! sortez de mon antre !");
        vDialogueBahamut.add("Je vous détruire!");
        vDialogueBahamut.add("Meurs Insecte !");
        vDialogueBahamut.add("Tuu ne fais pas le poids aventurier");
        //Etage 1

        Room vEntreeB = new Room("dans l'entrée de l'antre, l'escalier pour sortir s'est refermé, vous ne pouvez plus partir désormais.","./Images/EntreeB.jpg");
        Room vRagnarok = new Room("dans la salle ou se trouve Ragnarok, la lance légendaire","./Images/Ragnarok.jpg");
        vRagnarok.addItem(new Arme("ragnarok","Ragnarok, lance légendaire",5,10));
        vRagnarok.addItem(new Item("casque","Le casque ayant appartenu au derneir gardien de ces lieux", 1, false));
        Room vEscalierH = new Room("en haut de l'escalier principal de l'antre","./Images/Mine.jpg");
        //Etage 2

        Room vEscalierB = new Room("en bas de l'escalier principal de l'antre","./Images/Escalier.jpg");
        vEscalierB.addItem(new Armor("cotte", " une bienne belle cotte de maille", 5, 20));
        Room vBahamut1 = new Room("dans la salle centrale de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","./Images/Chambre.png");
        Room vBahamutG = new Room("dans la salle gauche de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","./Images/Chambre.png");
        Room vBahamutD = new Room("dans la salle droite de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","./Images/Chambre.png");
        Room vBahamutN = new Room("dans la salle au nord de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","./Images/Chambre.png");

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
        vEscalierB.setExit("nord", vBahamut1);
        vBahamut1.setExit("sud", vEscalierB);
        vBahamut1.setExit("nord", vBahamutN);
        vBahamut1.setExit("est", vBahamutD);
        vBahamut1.setExit("ouest", vBahamutG);

        vBahamutG.setExit("est", vBahamut1);
        vBahamutD.setExit("ouest", vBahamut1);
        vBahamutN.setExit("sud", vBahamut1);
        //add Rooms to list

        aRoomList.add(vSommetEst);
        aRoomList.add(vEntreeH);
        aRoomList.add(vEntreeB);
        aRoomList.add(vRagnarok);
        aRoomList.add(vEscalierH);
        aRoomList.add(vEscalierB);
        aRoomList.add(vBahamut1);
        aRoomList.add(vBahamutG);
        aRoomList.add(vBahamutD);
        aRoomList.add(vBahamutN);

        //Create RoomList for the boss
        ArrayList<Room> vBossRooms = new ArrayList();
        vBossRooms.add(vBahamut1 );
        vBossRooms.add(vBahamutG );
        vBossRooms.add(vBahamutD );
        vBossRooms.add(vBahamutN );

        this.aBahamut = new MovingNPC(vDialogueBahamut, "Bahamut", vBossRooms,vBahamut1);
        vBahamut1.addNPC(this.aBahamut);

        Room vTransporter = new TransporterRoom("dans une salle où se trouve seulement un téléporteur, même pas de porte !","./Images/Transporter.jpg",this.aRoomList);
        vTransporter.addNPC(new NPC(vDialogueKenny,"Kenny"));
        vTransporter.addNPC(new NPC(vDialogueCartman,"Cartman"));
        aRoomList.add(vTransporter);
        vEscalierB.setExit("est",vTransporter);

    }//createrooms
    /**
     * Permet de reafficher la description du lieu actuel
     */
    public void look()
    {
        this.printLocation();        
    }//look

    /**
     * Permet de changer le mode de Test
     * @param pB état futur du mode de test
     * 
     */
    public void setTestMode(final boolean pB)
    {
        this.aTestMode = pB;
    }

    /**
     * Permet de récupérer le mode de Test
     * @return mode de test
     * 
     */
    public boolean getTestMode()
    {
        return this.aTestMode;
    }

    /**
     * retourne le parser
     * @return le parser
     */
    public Parser getParser()
    {
        return this.aParser;        
    }

    /**
     * Permet de se suicider
     */
    private void harakiri()
    {
        aGui.println("En ayant marre de votre aventure,\nvous décidez de mourrir honorablement et de réaliser un HARAKIRI");
        this.mort();
    }//harakiri

    /**
     * retourne la pile de rooms
     * @return pile de rooms
     * 
     */
    public Stack<Room> getRoomStack()
    {
        return this.aRoomStack;
    }

    /**
     * REtourne la liste de room
     * @return Liste de rooms
     */
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

    /**
     * Vide la pile de Rooms
     * 
     */
    public void clearStack()
    {
        while(!this.aRoomStack.isEmpty())     
        {
            this.aRoomStack.pop();
        }

    }

    /**
     * Permet d'incrémenter le compteur de et de vérifier si i lfaut arrêter la jeu à un déplacement
     * @param pR pièce actuelle avant le déplacement
     * 
     */

    public void oneMove(final Room pR)
    {
        if(this.aNbMoves + 1 >= this.MAX_MOVES)
        {
            this.mort();
            return;           
        }
        this.aRoomStack.push(pR);
        this.aBahamut.move();
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

    /**
     * Methode pour récupérer le bahamut
     * @return Bahamut
     */
    public MovingNPC getBahamut()
    {
        return this.aBahamut;      
    }

    /**
     * Permet de savoir si le bahamut est dans la pièce du joueur
     * Si il y est, on affiche son image
     */
    public void isBahamutIn()
    {
        if(!(this.aPlayer.getCurrentRoom().getNPCList().get(this.aBahamut.getName()) == null))
        {
            this.aGui.showImage("./Images/Bahamut.jpg");
        }
    }
}

