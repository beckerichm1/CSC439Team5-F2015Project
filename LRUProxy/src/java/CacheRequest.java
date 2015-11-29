package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * CacheRequest
 * @author Ken Cooney
 * @date 06/10/2011
 * 
 * This reads the file that has the cache requests.
 * 
 * 
 * TESTED via CacheRequestTestSuite.  All tests pass.
 */
public class CacheRequest 
{

	BufferedReader in;
	public CacheRequest(String directorys)
	{
		String filename=directory+"input.txt";	//input.txt
		try
		{
			in = new BufferedReader(new FileReader(filename));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * read
	 * @return next request or empty string if no request.
	 */
	public String read( Socket s )
	{
		String line="";
		in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
		
		try
		{
			line=in.readLine();
			if (line == null)
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		String [] pieces = line.split(\\s+);
		if(!pieces[0].equalsIgnoreCase("GET")){
			return null;
		}
		String url = pieces[1];
		return url;
	}
}
