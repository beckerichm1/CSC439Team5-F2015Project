package java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * CacheLog
 * @author Ken Cooney
 * @date 06/10/2011
 * 
 * Writes to the output.log what is going on with the cache.
 * 
 * 
 * TESTED via CacheLogTestSuite.  All tests pass.
 */
public class CacheLog 
{

	private BufferedWriter out;
	private String filename;
	private SimpleDateFormat dateFormat;
	
	private String returnString;
	
	public CacheLog(String directory)
	{
		filename=directory+"output.log";
		returnString="\n";
		dateFormat =
            new SimpleDateFormat("EEE MMMM dd HH:mm:ss yyyy");

	}
	
	public BufferedWriter getOut() throws IOException{
		out = new BufferedWriter(new FileWriter(filename, true));
		return out;
		
	}
	
	public void openLogForAppend()
	{
		try
		{
			getOut();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public String removeString(String URL){
		Calendar cal = Calendar.getInstance();
		String dateString=dateFormat.format(cal.getTime());
		return dateString+" "+URL+" the cached page is evicted"+returnString;
	}
	
	public void logRemoval(String URL)
	{
		openLogForAppend();
		try
		{
			out.write(removeString(URL));
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public String hitString(String URL){
		Calendar cal = Calendar.getInstance();
		String dateString=dateFormat.format(cal.getTime());
		return dateString+" "+URL+" cache hit"+returnString;
	}
	
	public void logHit(String URL)
	{
		openLogForAppend();
		try
		{
			out.write(hitString(URL));
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String missString(String URL){
		Calendar cal = Calendar.getInstance();
		String dateString=dateFormat.format(cal.getTime());
		return dateString+" "+URL+" cache miss"+returnString;
	}
	
	public void logMiss(String URL)
	{
		openLogForAppend();
		try
		{
			out.write(missString(URL));
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
