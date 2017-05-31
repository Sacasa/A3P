package pkg_mechanics;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * Permet d'utiliser des listes d'objets
 * 
 * @author Quentin Garrido
 * @version 1.0
 */
public class ItemList
{
    private Map<String,Item>aItemList;
    /**
     * Cosntructeur de la classe ItemList
     */
    public ItemList()
    {
        this.aItemList = new HashMap<String,Item>();   

    }

    /**
     * retourne l'objet associé à un nom
     * @param pName nom de l'objet
     * @return objet en question ( peut etre nul)
     */
    public Item getItem(final String pName)
    {
        Item vItem = this.aItemList.get(pName);
        return vItem;        
    }

    /**
     * Ajoute un objet dans la pièce
     * @param pI objet en question
     */
    public void addItem(final Item pI)
    {
        this.aItemList.put(pI.getName(), pI);
    }

    /**
     * Enleve un objet dans la pièce
     * @param pI objet en question
     */
    public void removeItem(final String pN)
    {
        this.aItemList.remove(pN);
    }

    /**
     * Nous dis si la Hashmap est vide
     * @return true si vide, false si remplie
     */
    public boolean isEmpty()
    {
        return this.aItemList.isEmpty();
    }

    /**
     * retourne la liste des rooms sous forme d'une chaine de caracteres
     * @return chaine de rooms
     */
    @Override
    public String toString()
    {
        if (this.aItemList.isEmpty())
            return "";
        else
        {
            String vString = "";
            Set<String> vKeys = this.aItemList.keySet();
            for(String vKey : vKeys)
            {
                vString += " " + vKey;
            }
            return vString;
        }        

    }

    /**
     *retourne la liste des rooms sous forme d'une chaine de caracteres avec leurs descriptions
     * @return chaine de rooms 
     */
    public String toStringDetail()
    {
        if (this.aItemList.isEmpty())
            return "";
        else
        {
            String vString = "";
            Set<String> vKeys = this.aItemList.keySet();
            for(String vKey : vKeys)
            {
                vString += "\n" + this.aItemList.get(vKey).getItemInformation();
            }
            return vString;
        }        

    }
}
