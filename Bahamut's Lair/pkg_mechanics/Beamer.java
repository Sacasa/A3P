package pkg_mechanics;

/**
 * LE beamer est un objet permettant de se téléporter entre les salles
 *
 * @author Quentin Garrido
 * @version 1.0
 */
public class Beamer extends Item
{
    private Room aChargedRoom;

    /**
     * Constructor for objects of class Beamer
     */
    public Beamer()
    {
        super("beamer","Un beamer, objet antique permettant de se téléporter", 5,false);

    }

    /**
     * permet de charger la pièce dans la pièce courante
     */
    public void charge()
    {
        this.aChargedRoom = this.getCurrentRoom();

    }

    /**
     * permet de se téléporter dans la pièce en mémoire
     */
    public void fire()
    {
        super.getCarrier().changeRoom(aChargedRoom);
    }

    /**
     * récupère la pièce actuelle du porteur
     * @return pièce actuelle
     */
    public Room getCurrentRoom()
    {
        return super.getCarrier().getCurrentRoom();
    }

    /**
     * récupère la pièce en mémoire
     * @return pièce en mémoire
     */
    public Room getChargedRoom()
    {
        return this.aChargedRoom;
    }
}
