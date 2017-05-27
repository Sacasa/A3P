import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class ItemList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemList
{
    private Map<String,Item>aItemList;
    
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
    
    public boolean isEmpty()
    {
        return this.aItemList.isEmpty();
    }
    
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
