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
    private HashMap<String, NPC> aNPCList;
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
        this.aNPCList = new HashMap<String, NPC>();
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
        String vReturnString = "";
        if( this.aItems.isEmpty())
            vReturnString +=( "Vous êtes " + this.aDescription + ".\n" + this.getExitString())+"\n"+"---------------------------------------------------";
        else 
            vReturnString +=("Vous etes " + this.aDescription + ".\n" + this.getItemString() + ".\n" + this.getExitString())+"\n"+"---------------------------------------------------";
        if(!this.aNPCList.isEmpty())
        {
            vReturnString += ("\n" + this.getNPCString() );
        }
        return vReturnString;    
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

    /**
     * nous dis si une Room est sortie de la pièce courante
     * @param pR pièce a tester
     * @return true si oui, false si non
     */
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
     * @param pN nom de l'objet en question
     */
    public void removeItem(final String pN)
    {
        this.aItems.removeItem(pN);
    }

    /**
     * Ajoute un NPC dans la pièce
     * @param pNPC NPC à ajouter
     */
    public void addNPC(final NPC pNPC )
    {
        this.aNPCList.put(pNPC.getName(),pNPC);

    }

    /**
     * Enleve un NPC de la pièce
     * @param pName nom du NPC
     */
    public void removeNPC(final String pName)
    {
        this.aNPCList.remove(pName);
    }

    /**
     * @return  liste des NPC présents dans la pièce
     */
    public String getNPCString()
    {
        String vReturnString = "Les personnages présents sont:";
        Set<String> vKeys = this.aNPCList.keySet();
        for(String vNPC : vKeys)
        {
            vReturnString += ", " + vNPC;
        }

        return vReturnString;  

    }

    /**
     * @param pNPC nom du NPC
     * @return dialogue du NPC 
     */
    public String getNPCDialogue(final String pNPC)
    {     

        return this.aNPCList.get(pNPC).getDialogue();

    }

    /**
     * @return Hashmap des NPC
     */
    public HashMap<String, NPC> getNPCList()
    {
        return this.aNPCList;
    }

    /**
     * @param pN nom du NPC
     * @return NPC associé à ce nom dans la pièce
     */
    public NPC getNPC(final String pN)
    {
        return this.aNPCList.get(pN);
    }
} // Room
