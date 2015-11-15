package test;

import static org.junit.Assert.*;


import java.util.LinkedList;
import java.util.Scanner;
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
		
		assertNull(mh.in);
	}
	
	
	@Test
	public void fetch()
	{
		
		server.MiniHttp mh = new server.MiniHttp();
		
		//assertNotEquals( (long)0 , (long)mh.fetch("http://nku.edu/~foxr/home").length() );
		if(mh.fetch("http://nku.edu/~foxr/home").length() != 0){
			assertTrue(true);
		}
		else{
			assertTrue(false);
		}
		
		
		
	}
	
}