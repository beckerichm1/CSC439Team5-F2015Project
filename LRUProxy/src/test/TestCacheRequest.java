package java;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TestCacheRequest {
	@Test
	public void testConstructor() throws FileNotFoundException{
		CacheRequest c = new CacheRequest("C:\\Users\\Alan\\workspace\\");
		assertNotNull(c);
	}
	
	@Test
	public void testRead(){
		CacheRequest c = new CacheRequest("C:\\Users\\Alan\\Documents\\");
		StringBuffer sb = new StringBuffer("");
		sb.append("www.google.com");
		sb.append("www.yahoo.com");
		sb.append("www.wikipedia.com");
		sb.append("www.google.com");
		sb.append("www.yahoo.com");
		sb.append("www.ask.com");
		sb.append("www.apple.com");
		sb.append("www.google.com");
		sb.append("www.apple.com");
		sb.append("www.yahoo.com");
		sb.append("www.apple.com");
		sb.append("www.msn.com");
		sb.append("www.apple.com");
		sb.append("www.msn.com");
		sb.append("www.apple.com");
		sb.append("www.google.com");
		String test = "";
		test = test + c.read();
		assertEquals(test, sb);
	}
}
