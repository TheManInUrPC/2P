/**
 * EMTApp.java -- CS416 P2 
 * 
 * A Swing application based on the pattern described in Chapter 7,
 * Sanders and van Dam, Object-Oriented Programming in Java.
 * 
 * All the application-specific code is in the DrawPanel class
 * 
 * @author rdb
 * Last editted: 01/04/14 Format
 */

import javax.swing.*;

public class EMTApp extends JFrame
{
    //-------------------- class variables -------------------------
    //---- These are actually "application" parameters, specified
    //---- on the command line and available to any class
    //
    static int  highSpeed    = 30;
    static int  normalSpeed  = 10;
    static int  numHospitals = 3; 
    
    //------------------ constructor ---------------------------------
    /**
     * Construct a JFrame for the application and put a JPanel in it.
     * 
     * @param  title  String  window title string
     * @param  args   String[]   args
     */
    public EMTApp( String title, String[] args )
    {
        super( title );            // specify window title
        this.setSize( 700, 500 );  // define window size
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        // All application specific code is in DrawPanel constructor.
        // DrawPanel extends JPanel. 
        
        highSpeed    = getArg( args, 0, 30 ); // arg 0 is high speed
        normalSpeed  = getArg( args, 1, 10 ); // arg 1 is normal speed
        numHospitals = getArg( args, 2, 3 );  // arg 2 is # hospitals
        
        EMTPanel panel = new EMTPanel( this ); // Put graphics in JPanel
        this.add( panel );                     // add it to the frame
        
        this.setVisible( true );
    }
    
    //------------- class methods ---------------------------------
    /**
     * This is a utility method for accessing one of the command line
     * string arguments and converting it to an int. It accepts the 
     * entire array of arguments in String form, an integer indicating 
     * which is to be converted to an int and a default value to be 
     * returned if this argument was not on the command line, or if 
     * the specified String is not a valid integer representation.
     * 
     * @param args  String[]  argument array
     * @param which int       identifies which argument to extract
     * @param defVal int      default value if none specified, or err
     * @return int            integer value of String or default
     */
    private static int getArg( String[ ] args, int which, int defVal )
    {
        try
        {
            // Integer class has a class method that converts a String
            //   to an int -- if it's a valid representation of an int. 
            return Integer.parseInt( args[ which ] );
        }
        catch ( ArrayIndexOutOfBoundsException oob )
        {
            // If no args[ which ] element, Java "throws" this
            // exception. Code "catches" the exception and handles it.
            // In this case, it is not an error. The param is optional
            // and there is a specified default value that is returned.
        }
        catch ( NumberFormatException nfe )
        {
            // If string is not a valid representation of an integer,
            // Integer.parseInt throws a NumberFormatException
            // This code catches the exception. In this case it gives 
            // an error message and uses a default value.
            
            System.err.println( "Error: bad command line argument " 
                             + which + " = " + args[ which ] 
                             + ".  Should be integer; using default: "
                             + defVal );
        }  
        return defVal;
    }
    //------------------------ main -----------------------------------
    /**
     * Startup.
     * 
     * @param args  String[]  command line arguments
     */
    public static void main( String[] args )
    {
        EMTApp app = new EMTApp( "Drawing in AWT/Swing", args );
    }
}
