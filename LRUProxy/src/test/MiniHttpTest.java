package test;

import static org.junit.Assert.*;


import java.util.LinkedList;

import org.junit.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

public class MiniHttpTest {

	
	@Test
	public void testConstructor(){
		
		server.MiniHttp mh = new server.MiniHttp();
		
		assertEquals( new DefaultHttpClient(), mh.httpclient );
		
	}
	
	
	@Test
	public void fetch()
	{
		
		server.MiniHttp mh = new server.MiniHttp();
    
		/*StringBuffer sb = new StringBuffer("");
		sb.append( "http://nku.edu/~foxr/home" );
		sb.append( "<html><head>" );
		sb.append( "<title>Home for Richard Fox</title>" );
		sb.append( "</head>" );
		sb.append( "" );
		sb.append( "<body>" );
		sb.append( "<h2><center>" );
		sb.append( "" );
		sb.append( "Northern Kentucky University" );
		sb.append( "" );
		sb.append( "<br>" );
		sb.append( "Department Computer Science<br>" );
		sb.append( "Home Page for Richard Fox<p>" );
		sb.append( "<img src=\"IMAGES/nkufade.gif\">" );
		sb.append( "</center>" );
		sb.append( "</h2>" );
		sb.append( "<p>" );
		sb.append( "<center><img src=\"IMAGES/barmove.gif\" height=12></center><br><p>\"" );
		sb.append( "<p><hr><p>" );
		sb.append( "<center>" );
		sb.append( "<img src=\"IMAGES/rams2.gif\"><img src=\"IMAGES/bengals2.gif\" height=140 width=170>" );
		sb.append( "</center>" );
		sb.append( "<p><hr><p>" );
		sb.append( "" );
		sb.append( "<center><a href=\"mailto:foxr@nku.edu\"><img src=\"IMAGES/email.gif\" height=\"10%\"></a></center>" );
		sb.append( "<p><hr><p>" );
		sb.append( "</body>" );
		sb.append( "</html>" );*/
		
		System.out.println(mh.fetch("http://nku.edu/~foxr/home") );
		assertEquals( sb , mh.fetch("http://nku.edu/~foxr/home") );
		
		
		
	}
	
}