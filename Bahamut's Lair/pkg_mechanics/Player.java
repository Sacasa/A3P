package pkg_mechanics;
import pkg_core.UserInterface;


import java.util.HashMap;
import java.util.Set;

/**
 * CLasse définissant le(s) joueur(s) du jeu
 *
 * @author Quentin Garrido
 * @version 1.0
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final double aMAX_HP;
    private String aNom;
    private Room aCurrentRoom;
    private int aMaxWeight;
    private int aCurrentWeight;
    private UserInterface aGui;
    private ItemList aInventory;
    private double aHP;
    private Arme aArme;
    private Armor aArmor;

    /**
     * Constructeur de Player
     * @param pN nom du player
     * @param pTW poids total du joueur
     * @param pR pièce initiale du joueur
     */
    public Player(final String pN, final int pTW,final Room pR)
    {
        this.aNom = pN;
        this.aMaxWeight = pTW;
        this.aCurrentWeight = 0;
        this.aCurrentRoom = pR;
        this.aInventory = new ItemList();
        this.aArme = new Arme();
        this.aArmor = new Armor();
        this.aHP = 20.0;
        this.aMAX_HP = 20.0;
    }//player
    
    /**
     * @return vie max du player
     */
    public double getMaxHP()
    {
        return this.aMAX_HP;
    }
    
    /**
     * ajoute du poids au maximum du joueur
     * @param pI poids à ajouter(ou enlever)
     */
    public void addMaxWeight(final int pI)
    {
        this.aMaxWeight += pI;

    }

    /**
     * récupère le poids maximumu du joueur
     * @return poids max
     */
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }
    
    /**
     * permet d'ajouter/enlever de la vie au joueur
     * @param pHP quantité a ajouter/enlever
     */
    public void addHP(final double pHP)
    {
        if(this.aHP + pHP > this.aMAX_HP)
            this.aHP = aMAX_HP;
        else 
            this.aHP += pHP;
    }
    
    /**
     * retourne l'inventaire du joueur
     * @return inventaire du joueur
     */
    public ItemList getInventory()
    {
        return this.aInventory;
    }
    //Utile si player affiche des choses dans le GUI
    /**
     * définit le GUI ou on affichera les infos
     * @param pUserInterface futur gui
     */
    public void setGui(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface; 
    }//setGui
    /**
     * Ajoute/enleve du poids actuel au joueur
     * @param pI poids à ajouter/enlever
     */
    public void addCurrentWeight(final int pI)
    {
        this.aCurrentWeight += pI; 
    }

    /**
     * Récupère le poids actuel du joueur
     * @return poids du joueur
     */
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

    /**
     * permet de savoir si un objet est porté ou non
     * @param pS nom de l'objet
     */
    public boolean isCarried(final String pS)
    {
        if (this.aInventory.getItem(pS) != null)
            return true;
        else
            return false;

    }
    /**
     * @return arme actuelle du joueur
     */
    public Arme getArme()
    {
        return this.aArme;
    }
    /**
     * Définit l'arme du joueur
     * @param pArme arme a donner au joueur
     */
    public void setArme(final Arme pArme)
    {
        this.aArme = pArme;
    }
    
    /**
     * @return degats de l'arme du joueur
     */
    public int getDegats()
    {
        return this.aArme.getDegats();
    }
    /**
     * @return l'armure du joueur
     */
    public Armor getArmor()
    {
        return this.aArmor;
    }
    /**
     * Définit l'armure du jouer
     * @param pArmor armure
     */
    public void setArmor(final Armor pArmor)
    {
        this.aArmor = pArmor;
    }
    /**
     * @return statistique d'armure du joueur
     */
    public int getRes()
    {
        return this.aArmor.getRes();
    }
    /**
     * @return arme et armure du joueur sous forme de texte
     */
    public String getEquipment()
    {
        return "Votre arme est : " + this.aArme.toString() + "\n" + "Votre armure est : " + this.aArmor.toString() ;
    }
    /**
     * Calcule et affiche la vie du joueur, ainsi que sa mort potentielle
     */
    public void status()
    {
        if(this.aHP > 0.0)
           this.aGui.println("Vous avez " + this.aHP +" pv.");
        else
            {
            this.aGui.println("Vous êtes mort.");  
            this.aGui.showImage("./Images/Mort.jpg");
            this.aGui.enable(false);
            }
        
    }
    /**
     * @return vie du joueur
     */
    public double getHP()
    {
        return this.aHP;
    }
}
