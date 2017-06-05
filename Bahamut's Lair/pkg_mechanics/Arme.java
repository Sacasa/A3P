package pkg_mechanics;


/**
 * Write a description of class Arme here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arme extends Item
{
    private int aDegats;
    
    /**
     * Construteur de la classe Arme
     * @param pN    Nom de l'arme
     * @param pDesc Description de l'arme
     * @param pW    poids de l'arme
     * @param pDegats degats de l'arme 
     */
    public Arme(final String pN,final String pDesc, final int pW, final int pDegats)
    {
        super(pN,pDesc,pW,false);
        this.aDegats = pDegats;
    }
    
    /**
     * Constructeur par défaut de l'Arme
     */
    public Arme()
    {
        this("poings","vos poings", 0, 1);
    }

    /**
     * @return degats de l'arme
     */
    public int getDegats()
    {
        return this.aDegats;
    }
    
    /**
     * permet un affichage clair de l'arme
     * @return descirption claire de l'arme
     */
    @Override
    public String toString()
    {       
        return super.getDescription() + " qui a des degats de : " + this.aDegats;
    }
}
