package mediaPanel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MediaPanelText 
{
	public static void main( String args[] )
	{
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog( null );
		
		if ( result == JFileChooser.APPROVE_OPTION )
		{
			URL mediaURL= null;
			
			try
			{
				mediaURL = fileChooser.getSelectedFile().toURI().toURL();
			}
			catch(MalformedURLException malformedURLException)
			{
				System.err.println( "Could not create URL for the file" );
			}
			if ( mediaURL != null ) // only display if there is a valid URL
			{
				JFrame mediaTest = new JFrame( "Media Tester" );
				mediaTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				MediaPanel mediaPanel = new MediaPanel( mediaURL );
				mediaTest.add( mediaPanel );
				mediaTest.setVisible( true );
			}
		}	
	}

}
