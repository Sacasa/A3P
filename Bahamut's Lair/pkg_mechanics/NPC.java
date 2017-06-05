package pkg_mechanics;

import java.util.ArrayList;
/**
 * Personnages non joueurs
 * 
 * @author Quentin Garrido
 * @version 1.0
 */
public class NPC
{
    private ArrayList<String> aDialogue;
    private boolean aTextRandom;
    private String aName;
    private double aHP;
    private int aDegats;
    private int aArmure;
    private boolean aMortal;
    private Item aLoot;
    private Room aCurrentRoom;

    /**
     * Constructeur de pnj "actif", qui peuvent attaquer le joueur
     * @param pD Dialogues du personnage
     * @param pN nom du personnage
     * @param pHP vie du personnage
     * @param pDegats degats du personnage
     * @param pArmure armure du personnage
     * @param pK capacité de tuer ce personnage
     * @param pLoot objet que fait tomber le personnage à sa mort
     * @param pCR pièce du personnage
     */
    public NPC(final ArrayList<String> pD, final String pN,final double pHP, final int pDegats, final int pArmure, final boolean pK, final Item pLoot, final Room pCR)
    {
        this.aDialogue = pD;
        this.aName = pN;
        this.aTextRandom = false;
        this.aMortal = true;
        this.aDegats = pDegats;
        this.aArmure = pArmure;
        this.aMortal = pK;
        this.aHP = pHP;
        this.aLoot = pLoot;
        this.aCurrentRoom = pCR;
    }

    /**
     * Constructor for unkillable/passive NPC
     * @param pD Dialogues du personnage
     * @param pN nom du personnage
     */
    public NPC(final ArrayList<String> pD, final String pN, final Room pCR)
    {
        this(pD,pN,1,0,0,false,null, pCR);
    }

    /**
     *Retourne le nom du pnj
     *@return nom du pnj
     */
    public String getName()
    {
        return this.aName;
    }

    /**
     * retourne le dialogue du pnj, soit le message de bienvenue ( la premiere fois) soit un message aléatoire
     * @return dialogue
     */
    public String getDialogue()
    {
        int vIndex;
        if(!this.aTextRandom)
        {
            vIndex = 0;
            this.aTextRandom = true;
        }
        else
        {
            vIndex = 1 + (int)(Math.random() * (( this.aDialogue.size()- 1)));

        }
        return this.aName + " : " + this.aDialogue.get(vIndex);
    }

    /**
     * récupère le fait que le texte soit aléatorie ou non
     * @return Texte aléatoire ou non 
     */
    public boolean getTextRandom()
    {
        return this.aTextRandom   ;     
    }

    /**
     * ajoute/enleve de la vie au personnage
     * @param pD montant de vie
     */
    public void addHP(final double pD)
    {
        this.aHP += pD;
    }

    /**
     * @return vi du personnage
     */
    public double getHP()
    {
        return this.aHP;
    }

    /**
     * @return pièce courante du personnage
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;

    }

    /**
     * Définit la pièce actuelle du personnage
     * @param pR pièce du personnage
     */
    public void setCurrentRoom(final Room pR)
    {
        this.aCurrentRoom = pR;
    }

    /**
     * @return mortalité du personnage
     */
    public boolean getKillable()
    {
        return this.aMortal;
    }

    /**
     *@return objet porté par le personnage
     */
    public Item getLoot()
    {
        return this.aLoot;
    }

    /**
     * @return statut du personnage/sa mort potentielle
     */
    public String status()
    {
        if(this.aHP > 0.0)
            return this.getName() + " a désormais une vie de : " + this.aHP +".";
        else
        {
            this.aCurrentRoom.addItem(aLoot);
            this.aCurrentRoom.removeNPC(this.aName);

            return this.getName() +" est mort , vous apercevez sur le sol " + this.aLoot.getDescription();    
        }
    }

    /**
     * @return degats du personnage
     */
    public int getDegats()
    {
        return this.aDegats;
    }

    /**
     * @return armure du personnage
     */
    public int getArmure()
    {
        return this.aArmure;
    }
}
