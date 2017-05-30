import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class TestCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCommand extends Command
{
    private CommandWords aCommandWords;

    /**
     * Constructor for objects of class TestCommand
     */
    public TestCommand(final CommandWords pCommandWords)
    {
        super(null);
        this.aCommandWords = pCommandWords;
    }

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
