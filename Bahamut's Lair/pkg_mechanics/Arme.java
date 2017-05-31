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

    
    public int getDegats()
    {
        return this.aDegats;
    }
    
    @Override
    public String toString()
    {       
        return super.getDescription() + " qui a des degats de : " + this.aDegats;
    }
}
