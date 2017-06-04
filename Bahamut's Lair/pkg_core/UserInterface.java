package pkg_core;
import pkg_mechanics.Parser;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;


/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Quentin GARRIDO
 * @version 1.0 (June 217)
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private Parser     aParser;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton    aButtonHarakiri;
    private JButton    aButtonEat;
    private JButton    aButtonLook;
    private JButton    aButtonAttack;
    private JButton    aButtonNorth;
    private JButton    aButtonSouth;
    private JButton    aButtonEast;
    private JButton    aButtonWest;
    private JButton    aButtonUp;
    private JButton    aButtonDown;
    
    private ArrayList<JButton> aButtonList;


    

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        //Ordre important
        this.aButtonList = new ArrayList<JButton>(10);
        this.createGUI();
        this.aParser = new Parser();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     * @param pText texte à afficher
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * @param pText texte à afficher
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     * @param pImageName "Lien" de l'image
     */
    public void showImage( final String pImageName )
    {
        URL vImageURL = this.getClass().getClassLoader().getResource( pImageName );
        if ( vImageURL == null )
            System.out.println( "image not found" );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     * @param pOnOff bolléen pour activer ou non
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff );
        
        for(JButton vB : this.aButtonList)
            vB.setEnabled(pOnOff);
        if ( ! pOnOff )
            this.aEntryField.getCaret().setBlinkRate( 0 );
 
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        
        this.aMyFrame = new JFrame( "Bahamut's Lair" );
        this.aEntryField = new JTextField( 34 );

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        

        vPanel.setLayout( new BorderLayout() );
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );
        
        //Creation bouttons d'action
        
        this.aButtonHarakiri = new JButton("back");
        this.aButtonEat = new JButton("wait");
        this.aButtonLook = new JButton("look");
        this.aButtonAttack = new JButton("help");
        
        
        JPanel vPanelButton = new JPanel();
        vPanelButton.add(this.aButtonHarakiri, BorderLayout.EAST);
        vPanelButton.add(this.aButtonEat, BorderLayout.WEST);
        vPanelButton.add(this.aButtonLook, BorderLayout.CENTER);
        vPanelButton.add(this.aButtonAttack, BorderLayout.NORTH);
        
        this.aMyFrame.getContentPane().add(vPanelButton, BorderLayout.SOUTH);
        
        //Panel des Dierctions Cardianles
        
        this.aButtonNorth = new JButton("go nord");
        //this.aButtonNorth.setPreferredSize( new Dimension(100,66));
        this.aButtonSouth = new JButton("go sud");
        this.aButtonEast = new JButton("go est");
        this.aButtonWest = new JButton("go ouest");
        this.aButtonUp = new JButton("go haut");
        this.aButtonDown = new JButton("go bas");
        
        JPanel vPanelGoCardinal = new JPanel();
        vPanelGoCardinal.setLayout( new BorderLayout());
        vPanelGoCardinal.add(this.aButtonNorth, BorderLayout.NORTH);
        vPanelGoCardinal.add(this.aButtonSouth, BorderLayout.CENTER);
        vPanelGoCardinal.add(this.aButtonEast, BorderLayout.EAST);
        vPanelGoCardinal.add(this.aButtonWest, BorderLayout.WEST);
        
        vPanel.add( vPanelGoCardinal, BorderLayout.EAST);
        
        //Panel des directions haut/bas
        
        JPanel vPanelGoZ = new JPanel();
        
        vPanelGoZ.add(this.aButtonDown, BorderLayout.WEST);
        vPanelGoZ.add(this.aButtonUp, BorderLayout.EAST);
        
        vPanelGoCardinal.add( vPanelGoZ, BorderLayout.SOUTH);
        
        //ajout des bouttons dans la liste des bouttons
        this.aButtonList.add(this.aButtonHarakiri);
        this.aButtonList.add(this.aButtonEat);
        this.aButtonList.add(this.aButtonLook);
        this.aButtonList.add(this.aButtonAttack);
        this.aButtonList.add(this.aButtonNorth);
        this.aButtonList.add(this.aButtonSouth);
        this.aButtonList.add(this.aButtonEast);
        this.aButtonList.add(this.aButtonWest);
        this.aButtonList.add(this.aButtonUp);
        this.aButtonList.add(this.aButtonDown);
        
        // add some event listeners to some components
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aEntryField.addActionListener( this );
        for(JButton vB : this.aButtonList)
            vB.addActionListener( this);

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     * @param pE Action récupérée par les listener
     */
    public void actionPerformed( final ActionEvent pE ) 
    {   
        
        //Remplacable en vrifiant que la classe d'éntrée est un bouton et e nrécupérant ce texte pour la commande.
        
        if(pE.getSource().getClass() == this.aButtonHarakiri.getClass())
            this.aEngine.interpretCommand(this.aParser.getCommand(pE.getActionCommand()));
        else
            this.processCommand();
        
        
        
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( this.aParser.getCommand(vInput) );
    } // processCommand()
} // UserInterface 
