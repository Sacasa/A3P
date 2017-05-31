package pkg_mechanics;


/**
 * Write a description of class Arme here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Armor extends Item
{
    private int aRes;

    public Armor(final String pN,final String pDesc, final int pW, final int pDegats)
    {
        super(pN,pDesc,pW,false);
        this.aRes = pDegats;
    }
    
    /**
     * Constructeur par défaut de l'Armure
     */
    public Armor()
    {
        this("vest"," une veste en lin", 1, 2);
    }

    
    public int getRes()
    {
        return this.aRes;
    }
    
    @Override
    public String toString()
    {       
        return super.getDescription() + " qui offre une résistance de : " + this.aRes;
    }
}
