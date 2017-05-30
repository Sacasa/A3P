package pkg_mechanics;

 import java.util.HashMap; 
import java.util.Set;
public class Room
{
    //Définition des attibuts

    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private ItemList aItems;
    //Constructeurs
    /**
     * Constructeur de la piece
     * @param pD Description du lieu
     * @param pI lien de l'image
     */
    public Room(final String pD,final String pI)
    {
        this.aDescription = pD;  
        this.aExits = new HashMap<String, Room>();
        this.aItems = new ItemList();
        this.aImageName = pI;
    }//room      
    //Accesseurs
    /**
     * Retourne la description du lieu
     * @return Description
     */
    public String getDescription(){ return this.aDescription ; }//GetDescription
    
    /**
     * Retourne la desctiption longue du lieu actuel, contenant la description du lieu et les sorties 
     * @return Description longue
     */
    public String getLongDescription()
    {
        if( this.aItems.isEmpty())
            return "Vous êtes " + this.aDescription + ".\n" + this.getExitString();
        else 
            return "Vous etes " + this.aDescription + ".\n" + this.getItemString() + ".\n" + this.getExitString(); 
    }
    
    /**
     * Return a string describing the room's image name
     * @return No mdel'image
     */
    public String getImageName(){return aImageName;}
        
    /**
     * retourne la sortie correspondante
     * @param pD Donne la piece dans la direction de ce parametre
     * @return sortie dans la direction
     */
    public Room getExit(final String pD  )
    {

        return this.aExits.get(pD);

    }//GetExit
    
    public boolean isExit(final Room pR)
    {
        for(String vKey : this.aExits.keySet())
        {
            if(this.aExits.get(vKey) == pR)
                return true;
            else
                return false;
            
        }
        return true;
    }
    
    
    
    /**
     * retourne les différentes sorties de la piece actuelle
     * @return Les sorties
     */
    public String getExitString()
    {
        String vReturnString = "Les sorties sont:";
        Set<String> vKeys = this.aExits.keySet();
        for(String vExit : vKeys)
        {
            vReturnString += ", " + vExit;
        }

        return vReturnString;

    }//getexitstring
    
    /**
     * Récupere tous les objets dans la pièce
     * @return Chaine de caractères avec tous les objets dedans
     */
    public String getItemString()
    {
       return "Les objets sont :" + this.aItems.toStringDetail();

    }
    //Mutateurs
    /**
     * Définit la sortie de la piece atuelle
     * @param pD direction relative
     * @param pV piece voisine dans cette direction
     */
    public void setExit(final String pD, final Room pV)
    {
        this.aExits.put(pD, pV);

    }//setExit
    //Methodes
    /**
     * retourne l'objet associé à un nom
     * @param pName nom de l'objet
     * @return objet en question ( peut etre nul)
     */
    public Item getItem(final String pName)
    {
        Item vItem = this.aItems.getItem(pName);
        return vItem;        
    }
    
    /**
     * Ajoute un objet dans la pièce
     * @param pI objet en question
     */
    public void addItem(final Item pI)
    {
        this.aItems.addItem(pI);
    }
    
    /**
     * Enleve un objet dans la pièce
     * @param pI objet en question
     */
    public void removeItem(final String pN)
    {
        this.aItems.removeItem(pN);
    }
} // Room
