package test;

import static org.junit.Assert.*;


import org.junit.*;

public class CacheRequestTest {
	String directory = ".\\co\\LRUProxy\\data\\";
	server.CacheRequest request = new server.CacheRequest(directory);

	@Test
	public void testRead(){
	    String expected = "www.google.com";
	    //assertEquals(expected, request.read());
	    
	}
}
