package pkg_mechanics;
import pkg_core.UserInterface;



import java.util.HashMap;
import java.util.Set;

/**
 * Décrivez votre classe Player ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aNom;
    private Room aCurrentRoom;
    private int aMaxWeight;
    private int aCurrentWeight;
    private UserInterface aGui;
    private ItemList aInventory;
    
    /**
     * Constructeur de Player
     * @param pN nom du player
     * @param pTW poids total du joueur
     */
    public Player(final String pN, final int pTW,final Room pR)
    {
        this.aNom = pN;
        this.aMaxWeight = pTW;
        this.aCurrentWeight = 0;
        this.aCurrentRoom = pR;
        this.aInventory = new ItemList();
    }//player
    
    public void addMaxWeight(final int pI)
    {
        this.aMaxWeight += pI;
        
    }
    
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }
    
    public ItemList getInventory()
    {
        return this.aInventory;
    }
    //Utile si player affiche des choses dans le GUI
    /**
     * définit le GUI ou on affichera les infos
     */
    public void setGui(final UserInterface pUserInterface)
    {
       this.aGui = pUserInterface; 
    }//setGui
    
    public void addCurrentWeight(final int pI)
    {
       this.aCurrentWeight += pI; 
    }
    
    public int getCurrentWeight()
    {
        return this.aCurrentWeight;
        
    }
     
    /**
     * Retourne la piece actuelle
     * @return piece actuelle
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
        
    }//getCurrentRoom
    
    /**
     * Déplace l'utilisateur dans la piece donnée
     * @param pRoom pièce où aller
     */
    public void changeRoom(final Room pRoom)
    {
       this.aCurrentRoom = pRoom; 
       this.aGui.println(this.aCurrentRoom.getLongDescription());
       if(this.aCurrentRoom.getImageName() != null)
            this.aGui.showImage(this.aCurrentRoom.getImageName());      
    }//ChangeRoom
    
    public void fire()
    {
        Beamer vbeamer;
        if(this.isCarried("beamer"))
        {
            vbeamer =(Beamer)this.aInventory.getItem("beamer");
            if(vbeamer.getChargedRoom() == null)
               this.aGui.println("Vous n'avez pas encore chargé le beamer !"); 
            else
            {
                vbeamer.fire();
                this.aGui.println("Vous utilisez le beamer et êtes téléporté");
            }
        } 
        else
            this.aGui.println("Vous ne portez pas le beamer !");
        
    }
   
    public void charge()
    {
        Beamer vbeamer;
        if(this.isCarried("beamer"))
        {
            vbeamer =(Beamer)this.aInventory.getItem("beamer");
            vbeamer.charge();
            this.aGui.println("Vous chargez le beamer dans cette salle");
        } 
        else
            this.aGui.println("Vous ne portez pas le beamer");
        
    }
    
    public boolean isCarried(final String pS)
    {
        if (this.aInventory.getItem(pS) != null)
            return true;
        else
            return false;
        
    }
}
