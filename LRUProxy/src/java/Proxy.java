package server;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Proxy
 * @author Ken Cooney
 * @date 06/11/2011
 *
 * This is the class that can be executed.
 */
public class Proxy 
{	
	
	private static final int PORT = 3104;
	
	private static ServerSocket serversocket;

	public server.CacheLog cacheLog;
	public server.CacheRequest cacheRequest;
	public server.CacheList cacheList;
	public server.MiniHttp miniHttp;
	public server.CacheToFile cacheToFile;
	
	public String directory;
	private boolean isWindows;
	public int sleepSeconds;
	
	public Proxy(String inDirectory, int maxCacheSize, int sleepSeconds)
	{
		if (sleepSeconds<0)
		{
			sleepSeconds=0;
		}
		this.sleepSeconds=sleepSeconds;
		
		if (maxCacheSize<1)
		{
			maxCacheSize=1;
		}
		
		// Determine which way slashes go for directories.
		String os = System.getProperty("os.name").toLowerCase();
		isWindows=(os.indexOf( "win" ) >= 0); 

		this.directory=inDirectory;
		if (isWindows && ! directory.endsWith("\\"))
		{
			directory=directory+"\\";
		}
		if (! isWindows && ! directory.endsWith("/"))
		{
			directory=directory+"/";
		}
		
		if (isValidDirectory() && isInputFilePresent())
		{
			try
			{
			
				cacheLog = new server.CacheLog(directory);
				cacheRequest= new server.CacheRequest(directory);
				cacheList = new server.CacheList(directory, maxCacheSize);
				cacheToFile = new server.CacheToFile(directory);
				miniHttp=new server.MiniHttp();
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			if (! isValidDirectory())
			{
				System.out.println("ERROR: "+directory+" is not a valid directory.");
			}
			else
			{
				System.out.println("ERROR: input.txt file not found in specified directory.");
			}
		}
	}
	
	public void run()
	{
		// A normal proxy will remain running
		// and waiting for requests
		// However we are simulated a proxy that
		// reads a set number of requests and the
		// stops.  So, we'll loop through the
		// file and stop when we reach the end.
		String url="";
		try {
			serversocket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		do
		{
			// Step 1: read request from file.
			Socket socket = null;
			try {
				socket = serversocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HTTPGetter worker = new HTTPGetter(socket, this);
			new Thread(worker).start();
			
			
			
		  } while(true);

	}
	
	private boolean isValidDirectory()
	{
		boolean returnValue=false;
		File file = new File(directory);
		if (file.exists() && file.isDirectory())
		{
			returnValue=true;
		}
		return returnValue;
	}
	
	private boolean isInputFilePresent()
	{
		boolean returnValue=false;
		File inFile = new File(directory+"input.txt"); //input.txt
		if (inFile.exists())
		{
			returnValue=true;
		}
		return returnValue;
	}
	
	public static void main(String args[])
	{ 	

		if (args.length == 3)
		{
			try
			{
				String directory=args[0];
				String temp=args[1];
				int maxCacheSize=Integer.parseInt(temp);
				temp=args[2];
				int sleepSeconds=Integer.parseInt(temp);
				Proxy proxy=new Proxy(directory, maxCacheSize, sleepSeconds);
				proxy.run();
			}
			catch (Exception e)
			{
				System.out.println("ERROR: could not process parameters");
			}
		}
		else
		{
			System.out.println("Pass in the following parameters:");
			System.out.println("directory where input.txt resides");
			System.out.println("maximum number of cached web pages (integer, minimum is 1)");
			System.out.println("number of seconds to sleep between checking for requests (integer, minimum is 0)");
		}
	}
}

