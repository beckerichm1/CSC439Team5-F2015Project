package test;

import static org.junit.Assert.*;

import java.CacheRequest;

import org.junit.*;

public class CacheRequestTest {
	String directory = "./data/";
	CacheRequest request = new CacheRequest(directory);

	@Test
	public void testRead(){
	    String expected = "www.google.com";
	    assertEquals(expected, request.read());
	    
	}
}
