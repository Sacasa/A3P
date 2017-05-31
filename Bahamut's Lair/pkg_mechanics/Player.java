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
    private String aNom;
    private Room aCurrentRoom;
    private int aMaxWeight;
    private int aCurrentWeight;
    private UserInterface aGui;
    private ItemList aInventory;
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
    }//player

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
    
    public Arme getArme()
    {
        return this.aArme;
    }
    public void setArme(final Arme pArme)
    {
        this.aArme = pArme;
    }
    public int getDegats()
    {
        return this.aArme.getDegats();
    }
    
        public Armor getArmor()
    {
        return this.aArmor;
    }
    public void setArmor(final Armor pArmor)
    {
        this.aArmor = pArmor;
    }
    public int getRes()
    {
        return this.aArmor.getRes();
    }
    
    public String getEquipment()
    {
        return "Votre arme est : " + this.aArme.toString() + "\n" + "Votre armure est : " + this.aArmor.toString() ;
    }
}
