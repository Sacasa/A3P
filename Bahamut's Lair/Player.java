

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
    
    //Utile si player affiche des choses dans le GUI
    /**
     * définit le GUI ou on affichera les infos
     */
    public void setGui(final UserInterface pUserInterface)
    {
       this.aGui = pUserInterface; 
    }//setGui
     
    /**
     * Permet de manger pour rassasier le personnage
     * @param pName nom de l'objet à manger
     */
    public void eat(final String pName)
    {
       if(this.aInventory.getItem(pName) == null || !this.aInventory.getItem(pName).isEdible())
           this.aGui.println("Vous n'avez pas d'ojet commestible de ce nom sur vous");
       else
        {
            if(pName.equals("lemba"))
                {
                    this.aMaxWeight += 5;
                    this.aGui.println("Après avoir mangé le Lemba, votre poids total est devenu " + this.aMaxWeight);           
                    this.aCurrentWeight -= this.aInventory.getItem(pName).getWeight();
                    this.aInventory.removeItem(pName);
                }
            
        }
    }//eat
   
    /**
     * Prend un objet dans la salle
     * @param pName nom de l'objet
     */  
    public void take(final String pName)
    {

        if(this.aCurrentRoom.getItem(pName) != null)
        {
            if(this.aCurrentWeight +this.aCurrentRoom.getItem(pName).getWeight() > this.aMaxWeight)
                this.aGui.println("Cet objet est trop lourd pour vous !");
            else
            {
                this.aInventory.addItem(this.aCurrentRoom.getItem(pName));
                this.aCurrentRoom.getItem(pName).setCarrier(this);
                this.aCurrentRoom.removeItem(pName);
                this.aGui.println("Vous récupérez " + this.aInventory.getItem(pName).getItemInformation());
                this.aCurrentWeight += this.aInventory.getItem(pName).getWeight();
            }
        }
        else
            aGui.println("Cet objet n'est pas présent dans la salle");
            
    }//Take
    
    /**
     * Dépose un objet dans la salle
     * @param pName nom de l'objet à déposer
     */
    public void drop(final String pName)
    {
        if(this.aInventory.getItem(pName) != null)
        {
            this.aGui.println("Vous déposez " + this.aInventory.getItem(pName).getItemInformation());
            this.aInventory.getItem(pName).setCarrier(null);
            this.aCurrentRoom.addItem(this.aInventory.getItem(pName));
            this.aCurrentWeight -= this.aInventory.getItem(pName).getWeight();
            this.aInventory.removeItem(pName);
        }
        else
            aGui.println("Cet objet n'est pas présent dans votre inventaire");  
    
    }//drop
    
    /**
     * affiche l'état de l'inventaire
     */
    public void inventory()
    {
        if (this.aInventory.isEmpty())
            this.aGui.println("Votre inventaire est vide");
        else
        {
            String vString = "Dans voter inventaire se trouvent : "+ this.aInventory.toString() + " pour un poids total de " + this.aCurrentWeight;
            this.aGui.println(vString);
        }
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
       System.out.println(pRoom.toString());
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
