package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * CacheToFile
 * @author Ken Cooney
 * @date 06/11/2011
 *
 * This is a simple class that write the cached web object
 * (HTML) to file or reads it.  It also removes cached
 * objects.
 * 
 */
public class CacheToFile 
{
	PrintWriter out = null;
	private String directory;
	
	/**
	 * 
	 * @param directory - where to cache files
	 */
	public CacheToFile(String directory)
	{
		this.directory=directory;
	}
	
	/**
	 * This removes a cached file
	 * @param filename
	 */
	public void remove(String cachedURL)
	{
		String cachedFile=generateFilename(cachedURL);
		String filename=directory+cachedFile;
		System.out.println("Removing "+filename);
		File file = new File(filename);
		file.delete();
	}
	
	/**
	 * This reads the cached object that we retrieved
	 * and writes it to a file.
	 * @param url
	 * @param sb
	 */
	public void write(String url, StringBuffer sb)
	{
		try
		{
			String cachedFile=generateFilename(url);
			String filename=directory+cachedFile;
			BufferedWriter out = new BufferedWriter(new FileWriter(filename, false));
			// Needed for project
			// Description was to output cache to screen.
			System.out.println(sb.toString());
			out.write(sb.toString());
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Currently this reads the cached file
	 * And writes it to System.out.
	 * @param url
	 */
	public void read(String url , Socket s )
	{
		try
		{
			String cachedFile=generateFilename(url);
			String filename=directory+cachedFile;
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			// Where to send this?
			OutputStreamWriter ostream;
			ostream = new OutputStreamWriter(s.getOutputStream());
			
			String line=in.readLine();
			while(line!=null)
			{
				ostream.write(line);
				line=in.readLine();
			}
			
			ostream.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public String readString(String url)
	{
		String line = "";
		try
		{
			String cachedFile=generateFilename(url);
			String filename=directory+cachedFile;
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			// Where to send this?
			OutputStreamWriter ostream;
			ostream = new OutputStreamWriter(System.out);
			
			line=in.readLine();
			while(line!=null)
			{
				ostream.write(line);
				line=in.readLine();
			}
			
			ostream.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return line;
	}
	/**
	 * Used for testing
	 * @param cachedURL - URL to check
	 * @return true if this data is cached.
	 */
	public boolean isCached(String cachedURL)
	{
		String cachedFile=generateFilename(cachedURL);
		String filename=directory+cachedFile;
		File file = new File(filename);
		return file.exists();
	}
	
	/**
	 * This comes up with a filename, replacing any
	 * slashes with periods.
	 * @param url - URL to be cached
	 * @return filename for cached URL
	 */
	private String generateFilename(String url)
	{
		return url.replaceAll("/", "_");
	}
	
	public String getDirectory(){
		return directory;
	}
	
	public void setOut( Socket s )
	{
		try {
			out = new PrintWriter( s.getOutputStream(  ) , true );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}