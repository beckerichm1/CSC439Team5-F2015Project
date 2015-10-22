package test;

import static org.junit.Assert.*;


import org.junit.*;

public class CacheRequestTest {
	String directory = "./data/";
	java.CacheRequest request = new java.CacheRequest(directory);

	@Test
	public void testRead(){
	    String expected = "www.google.com";
	    assertEquals(expected, request.read());
	    
	}
}
