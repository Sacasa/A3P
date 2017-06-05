
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
import pkg_mechanics.Food;

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
    private static final int MAX_MOVES = 50;
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
        //Dialogues
        ArrayList<String> vDialogueMsg = new ArrayList<String>();
        vDialogueMsg.add("Vous voici enfin Luneth ! \n Le Roi est mourrant et a besoin de votre aide.\n Seul le sang du Bahmaut peut le sauver et vous êtes notre seul espoir.\n La montagne est accessible en partant de la cour.\n Je suis désolé mais nous n'avons aucune armure ni arme pour vous, vous devrez vous équiper sur le chemin.");
        vDialogueMsg.add("Attention aux Gobelins sur la route !");
        vDialogueMsg.add("Vite ! Allez y, l'avenir du Roi est entre vos mains !");
        vDialogueMsg.add("Que faîtes vous encore ici ?!");        
        
        ArrayList<String> vDialogueRoi = new ArrayList<String>();
        vDialogueRoi.add("Arghhhh *tousse du sang* personne ici ne peut me soigner ?....");
        vDialogueRoi.add("Luneth, qu'avez vous à me dire ?");
        vDialogueRoi.add("Aidez moi *tousse* je vous en conjure *tousse* ");
        vDialogueRoi.add("je ne peut mourrir dans de telles circonstances *du sang sort de ses oreilles*");
        
        ArrayList<String> vDialogueNain = new ArrayList<String>();
        vDialogueNain.add("Bonjour aventurrrrrier !, qu'est ce qui vous amenes ici ?");
        vDialogueNain.add("Salopperrrrie de drrragon en bas !");
        vDialogueNain.add("Mais où est mon orrr.");
        vDialogueNain.add("Beurrrrk encore un elfe.");
        
        ArrayList<String> vDialogueBahamut = new ArrayList<String>();
        vDialogueBahamut.add("Que faites vous ici ! sortez de mon antre !");
        vDialogueBahamut.add("Je vous détruire!");
        vDialogueBahamut.add("Meurs Insecte !");
        vDialogueBahamut.add("Tuu ne fais pas le poids aventurier.");
        
        ArrayList<String> vDialogueCadavre = new ArrayList<String>();
        vDialogueCadavre.add("Le corps est inanimé, il ne peut vous répondre.");
        vDialogueCadavre.add("9a ne sert à rien de s'obstiner, il est mort.");

        ArrayList<String> vDialogueFenrir = new ArrayList<String>();
        vDialogueFenrir.add("Mortel, tu vas périr pour ton insolence !");
        vDialogueFenrir.add("Raaaaaaaawrrrrrrr");
        vDialogueFenrir.add("Huuum de la chair fraîche.");
        vDialogueFenrir.add("Pars avant que je ne te dévore.");
        
        //Chateau
        Room vTrone = new Room("dans la salle du trône, où le messager du Roi veut vous parler.","Images/trone.jpg");
        vTrone.addItem( new Food("potion"," potion(s) de vie ",2,3,5));
        vTrone.addNPC(new NPC(vDialogueMsg,"Messager",vTrone));
        Room vCour = new Room("dans la cour du Château.","Images/cour.jpg");
        Room vChambre = new Room("dans la chambre du Roi, il est dans son lit, mourrant","Images/roi.jpg");
        vChambre.addNPC(new NPC(vDialogueRoi,"Roi",vChambre));
        
        //Montagne

        Room vEntreeH = new Room("face à l'entrée de l'antre du Bahamut","Images/EntreeH.jpg"); 
        vEntreeH.addNPC(new NPC(vDialogueNain, "Gimli",vEntreeH));
        vEntreeH.addItem(new Item("lemba", "un lemba, pain magique elfique", 1, true));
        vEntreeH.addItem(new Beamer());
        Room vSommetEst = new Room("sur le flanc est de la montagne.","Images/Montagne.jpg");
        vSommetEst.addItem(new Item("torche","une torche pour vous éclairer dans ce donjon",1, false));

        //Etage 1

        Room vEntreeB = new Room("dans l'entrée de l'antre, l'escalier pour sortir s'est refermé, vous ne pouvez plus partir désormais.","Images/EntreeB.jpg");
        Room vRagnarok = new Room("dans la salle ou se trouve Ragnarok, la lance légendaire","Images/Ragnarok.jpg");
        vRagnarok.addItem(new Arme("Ragnarok","Ragnarok, lance légendaire",5,20));
        vRagnarok.addItem(new Item("casque","Le casque ayant appartenu au derneir gardien de ces lieux", 1, false));
        Room vEscalierH = new Room("en haut de l'escalier principal de l'antre","Images/Mine.jpg");
        //TransporterRoom ici
        
        //Etage 2
        
        Room vEscalierPrincipalBas= new Room("en bas de l'escalier princpial de l'antre.","Images/escalierpb.jpg");;
        Room vVide = new Room("dans une salle vide sans intérêt","Images/vide.jpg");
        vVide.addItem( new Food("elixir"," élixir(s) mystérieu(x) ",2,3,-10));
        Room vAventurier = new Room("dans une salle où gît un cadavre","Images/aventurier.jpg");
        vAventurier.addNPC(new NPC(vDialogueCadavre,"aventurier",vAventurier));
        Room vForge = new Room("dans une ancienne forge naine","Images/forge.jpg");
        vForge.addItem(new Arme("épée"," une épée rouillée",5,5));
        vForge.addItem(new Armor("cotte", " une cotte de maille en mithril", 5, 40));
        Room vEscalier2H = new Room("en haut de l'escalier menant au Bahamut","Images/escalier2h.jpg");      
        Room vFenrir = new Room("dans la pièce ou vous apercevez un loup au fond","Images/fenrir.jpg");
        NPC vFenrirNPC = new NPC(vDialogueFenrir, "Fenrir",50,10,10,true,new Arme("Excalibur", "Excalibur, la meilleur épée jamais forgée",20,70),vFenrir);
        vFenrir.addNPC(vFenrirNPC);
        
        //Etage 3
        
        Room vEscalier2B = new Room("en bas de l'escalier menant au bahamut","Images/Escalier.jpg");
        Room vBahamut1 = new Room("dans la salle centrale de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","Images/Chambre.png");
        Room vBahamutG = new Room("dans la salle gauche de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","Images/Chambre.png");
        Room vBahamutHG = new Room("dans la salle en haut à gauche de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","Images/Chambre.png");
        Room vBahamutHD = new Room("dans la salle en haut à droite de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","Images/Chambre.png");
        Room vBahamutD = new Room("dans la salle droite de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","Images/Chambre.png");
        Room vBahamutN = new Room("dans la salle au nord de la chambre du Bahamut, vous apercevez ses yeux dans l'obscurité","Images/Chambre.png");

        //Sorties
        vTrone.setExit("est",vCour);
        vCour.setExit("ouest",vTrone);
        vCour.setExit("sud",vSommetEst);
        vCour.setExit("est",vChambre);
        vChambre.setExit("ouest",vCour);
        
        vSommetEst.setExit("nord",vCour);
        vSommetEst.setExit("ouest", vEntreeH);
        vEntreeH.setExit("est", vSommetEst);
        vEntreeH.setExit("bas", vEntreeB);

        //Enlever la sortie vers le haut pour trapdoor
        //vEntreeB.setExit("haut", vEntreeH);
        vEntreeB.setExit("ouest",vRagnarok);
        vEntreeB.setExit("sud",vEscalierH);
        vRagnarok.setExit("est", vEntreeB);
        vEscalierH.setExit("bas", vEscalierPrincipalBas);
        vEscalierH.setExit("nord", vEntreeB);
        
        vEscalierPrincipalBas.setExit("haut",vEscalierH);
        vEscalierPrincipalBas.setExit("sud",vVide);
        vVide.setExit("nord",vEscalierPrincipalBas);
        vVide.setExit("sud",vEscalier2H);
        vVide.setExit("est",vForge);
        vVide.setExit("ouest",vAventurier);
        vForge.setExit("ouest",vVide);
        vAventurier.setExit("est",vVide);
        vEscalier2H.setExit("nord",vVide);
        vEscalier2H.setExit("est",vFenrir);
        vEscalier2H.setExit("bas",vEscalier2B);
        vFenrir.setExit("ouest",vEscalier2H);
        
        vEscalier2B.setExit("haut", vEscalier2H);
        vEscalier2B.setExit("nord", vBahamut1);
        vBahamut1.setExit("sud", vEscalier2B);
        vBahamut1.setExit("nord", vBahamutN);
        vBahamut1.setExit("est", vBahamutD);
        vBahamut1.setExit("ouest", vBahamutG);

        vBahamutG.setExit("est", vBahamut1);
        vBahamutG.setExit("nord",vBahamutHG);
        vBahamutD.setExit("ouest", vBahamut1);
        vBahamutD.setExit("nord",vBahamutHD);
        vBahamutN.setExit("sud", vBahamut1);
        vBahamutN.setExit("est", vBahamutHD);
        vBahamutN.setExit("ouest", vBahamutHG);
        vBahamutHG.setExit("est",vBahamutN);
        vBahamutHG.setExit("sud",vBahamutG);
        vBahamutHD.setExit("ouest",vBahamutN);
        vBahamutHD.setExit("sud",vBahamutD);
        
        
        //TransporterRoom
        Room vTransporter = new TransporterRoom("dans une salle où se trouve seulement un téléporteur, même pas de porte !","Images/Transporter.jpg",this.aRoomList);
        vEscalierH.setExit("est",vTransporter);
        
        
        //add Rooms to list
        aRoomList.add(vTrone);
        aRoomList.add(vCour);
        aRoomList.add(vChambre);
        aRoomList.add(vSommetEst);
        aRoomList.add(vEntreeH);
        aRoomList.add(vEntreeB);
        aRoomList.add(vRagnarok);
        aRoomList.add(vEscalierH);
        aRoomList.add(vTransporter);
        aRoomList.add(vEscalierPrincipalBas);
        aRoomList.add(vVide);
        aRoomList.add(vAventurier);
        aRoomList.add(vForge);
        aRoomList.add(vEscalier2H);
        aRoomList.add(vFenrir);
        aRoomList.add(vEscalier2B);
        aRoomList.add(vBahamut1);
        aRoomList.add(vBahamutD);
        aRoomList.add(vBahamutG);
        aRoomList.add(vBahamutHG);
        aRoomList.add(vBahamutN);
        aRoomList.add(vBahamutHD);

        //Create RoomList for the boss
        ArrayList<Room> vBossRooms = new ArrayList<Room>();
        vBossRooms.add(vBahamut1 );
        vBossRooms.add(vBahamutG );
        vBossRooms.add(vBahamutD );
        vBossRooms.add(vBahamutN );
        vBossRooms.add(vBahamutHG );
        vBossRooms.add(vBahamutHD );

        this.aBahamut = new MovingNPC(vDialogueBahamut, "Bahamut",50,10,10,true,new Item("fiole", "une fiole de sang du bahamut",1,false),vBahamut1,vBossRooms);
        vBahamut1.addNPC(this.aBahamut);



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
     * @param pCommand commande à interpréter
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
            this.aGui.showImage("Images/Bahamut.jpg");
        }
    }
}

