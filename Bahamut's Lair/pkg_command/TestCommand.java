package pkg_command;
import pkg_core.GameEngine;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Commande permettant de tester avec un fichier texte
 *
 * @author Quentin GARRIDO
 * @version 1.0
 */
public class TestCommand extends Command
{
    private CommandWords aCommandWords;

    /**
     * Constructeur de la classe TestCommand
     * @param pCommandWords mot de commande associé
     */
    public TestCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }
    /** 
     * Permet d'éxécuter une série de commandes dans un fichier
     * @param pGameEngine GameEngine qui éxécutera la commande
     */
    @Override
    public void execute(final GameEngine pGameEngine)
    {
        Scanner vSc;
        if(super.getSecondWord() == null)
        {
            pGameEngine.getGUI().println("Merci d'entrer un nom valide");
        }
        else
        {
            try { // pour "essayer" les instructions suivantes
                vSc = new Scanner( new File( super.getSecondWord() ) );
                pGameEngine.setTestMode(true);
                while ( vSc.hasNextLine() ) {
                    String vLigne = vSc.nextLine();
                    pGameEngine.interpretCommand(pGameEngine.getParser().getCommand(vLigne));
                } // while
                pGameEngine.setTestMode(false);
            } // try
            catch ( final FileNotFoundException pFNFE ) {
                pGameEngine.getGUI().println("Aucun fichier correspondant n'a été trouvé");
            } // catch
        }
    }
}
