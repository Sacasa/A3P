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

    /**
     * Constructor for objects of class NPC
     * @param pD Dialogues du personnage
     * @param pN nom du personnage
     */
    public NPC(final ArrayList<String> pD, final String pN)
    {
        this.aDialogue = pD;
        this.aName = pN;
        this.aTextRandom = false;
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
}
