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
    
    /**
     * Construteur de la classe Armor
     * @param pN    Nom de l'armure
     * @param pDesc Description de l'armure
     * @param pW    poids de l'armure
     * @param pRes resistance de l'armure 
     */
    public Armor(final String pN,final String pDesc, final int pW, final int pRes)
    {
        super(pN,pDesc,pW,false);
        this.aRes = pRes;
    }

    /**
     * Constructeur par défaut de l'Armure
     */
    public Armor()
    {
        this("vest"," une veste en lin", 1, 2);
    }

    /**
     * @return resistance de l'armure
     */
    public int getRes()
    {
        return this.aRes;
    }

    /**
     * permet d'afficher l'armure de manière claire
     * @return description de l'armure
     */
    @Override
    public String toString()
    {       
        return super.getDescription() + " qui offre une résistance de : " + this.aRes;
    }
}
