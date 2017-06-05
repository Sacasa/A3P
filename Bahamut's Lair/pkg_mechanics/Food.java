package pkg_mechanics;

/**
 * Représente la nourriture provoquant de soins
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends Item
{
    private int aNombre;
    private double aHeal;

    /**
     * Initialise les attributs d'un objet Food
     * @param pN Nom de l'aliment
     * @param pD Description
     * @param pW Poids de l'objet
     * @param pNb nombre d'utilisations de l'objet
     * @param pHeal quantité de soin procuré par l'objet
     */
    public Food(final String pN,final String pD, final int pW,final int pNb, final int pHeal )
    {
        super(pN,pD,pW*pNb,true);
        this.aNombre = pNb;
        this.aHeal = pHeal;
    }

    /**
     * Retourne la description de l'objet
     * @return description + poids
     */
    @Override
    public String getItemInformation()
    {
        return  this.aNombre + super.getDescription() +", pour un poids total de " + super.getWeight() ;

    }

    /**
     * effet en mangeant un objet food
     */
    public String eat()
    {
        super.getCarrier().addHP(this.aHeal);
        super.getCarrier().addCurrentWeight(-super.getWeight()/this.aNombre);
        this.aNombre --;
        if(this.aNombre <= 0)
        {
            super.getCarrier().getInventory().removeItem(super.getName());
        }
        if(this.aHeal >0)
            return "Vous mangez un " + super.getName() +" et en avez désormais " + this.aNombre +", vous avez gagné " + this.aHeal + " pv"; 
        else
            return "Vous mangez un " + super.getName() +" et en avez désormais " + this.aNombre +", vous avez perdu " + this.aHeal + " pv"; 
    }

}
