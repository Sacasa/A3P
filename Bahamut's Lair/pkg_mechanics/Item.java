package pkg_mechanics;


/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String aDescription;
    private int aWeight;
    private String aName;
    private boolean aEdible;
    private Player aCarrier;
    
    /**
     * Initialise les attributs d'un item
     * @param pD Description
     * @param pW Poids de l'objet
     * @param pE objet comestible ou non
     */
    public Item(final String pN,final String pD, final int pW, final boolean pE)
    {
        this.aDescription = pD;
        this.aWeight = pW;  
        this.aName = pN;
        this.aEdible = pE;
    }
    
    /**
     * Retourne la description de l'objet
     * @return description + poids
     */
    public String getItemInformation()
    {
        return this.aDescription + " qui a un poids de " + this.aWeight;
           
    }
    
    /**
     * Retourne le nom de l'objet
     * @return nom de l'objet
     */
    public String getName()
    {
        return this.aName;
    }
    
    /**
     * REtourne le poids de l'objet
     * @return poids de l'objet
     */
    public int getWeight()
    {
        return this.aWeight;
        
    }
    
    /**
     * retourne i l'objet est commestible
     * @return objet coemstible ou non
     */
    public boolean isEdible()
    {
        return this.aEdible;
    }
    
    
    public void setCarrier(final Player pP)
    {
        this.aCarrier = pP;        
    }
    
    public Player getCarrier()
    {
        return this.aCarrier;
    }
} // Item
