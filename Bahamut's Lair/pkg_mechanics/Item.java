package pkg_mechanics;

/**
 * Réprésente tous les objets du jeu
 * 
 * @author Quentin Garrido 
 * @version 1.0
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

    /**
     * définit le porteur de l'objet
     * @param pP porteur
     */
    public void setCarrier(final Player pP)
    {
        this.aCarrier = pP;        
    }

    /**
     * retourne le porteur de l'objet
     * @return porteur 
     */
    public Player getCarrier()
    {
        return this.aCarrier;
    }
} // Item
