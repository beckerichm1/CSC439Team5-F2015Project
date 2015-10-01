package test;
import static org.junit.Assert.*;

import java.CacheRequest;

import org.junit.*;

public class testCacheRequest {
	String directory = "C:\\Users\\catfa_000\\workspace\\LRUProxy(1)\\LRUProxy\\src\\java\\";
	CacheRequest request = new CacheRequest(directory);

	@Test
	public void testRead(){
	    String expected = "www.google.com";
	    assertEquals(expected, request.read());
	    
	}
}
