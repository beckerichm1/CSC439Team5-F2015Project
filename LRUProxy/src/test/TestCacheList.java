package java;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.*;

public class TestCacheList {

	
	@Test
	public void testConstructor(){
		
		CacheList cl = new CacheList("testing", 10);
		
		assertEquals(10, cl.getCacheSize());
		cl = new CacheList("testing", -5);
		assertEquals(1, cl.getCacheSize());
	}
	
	
	@Test
	public void testGetHead(){
		CacheList cl = new CacheList("testing", 3);
		
		cl.addNewObject("google.com", false);
		assertEquals("google.com",cl.getHead());
		cl.addNewObject("google.com", true);
		assertEquals("google.com",cl.getHead());
		
		cl.addNewObject("facebook.com", false);
		assertEquals("facebook.com",cl.getHead());
		
		cl.addNewObject("reddit.com",false);
		assertEquals("reddit.com",cl.getHead());
		cl.addNewObject("http://nku.edu/~haow1/", false);
		assertEquals("http://nku.edu/~haow1/", cl.getHead());
		
	}
	@Test
	public void testAddition(){
		CacheList cl = new CacheList("testing", 3);
		cl.addNewObject("google.com", false);
		cl.addNewObject("facebook.com", false);
		cl.addNewObject("reddit.com",false);
		
		LinkedList<String> ll = cl.getCacheList();
		assertEquals("reddit.com",ll.get(0));
		assertEquals("facebook.com", ll.get(1));
		assertEquals("google.com", ll.get(2));
		
		cl.addNewObject("facebook.com", true);
		assertEquals("facebook.com",ll.get(0));
		assertEquals("reddit.com", ll.get(1));
		assertEquals("google.com", ll.get(2));
		
		cl.addNewObject("twitter.com", false);
		assertEquals("twitter.com",ll.get(0));
		assertEquals("facebook.com",ll.get(1));
		assertEquals("reddit.com", ll.get(2));
		
		
	}
	
	@Test
	public void testGetCacheSize(){
		CacheList cl = new CacheList("testing", -1);
		assertEquals(0,cl.getCacheSize());
		
		cl.addNewObject("twitter.com", false);
		assertEquals(1,cl.getCacheSize());
		
		cl.addNewObject("facebook.com", false);
		assertEquals(1,cl.getCacheSize());
		
		cl = new CacheList("testing", 3);
		
		cl.addNewObject("twitter.com", false);
		assertEquals(1,cl.getCacheSize());
		
		cl.addNewObject("facebook.com", false);
		assertEquals(2,cl.getCacheSize());
		
		
		cl.addNewObject("google.com", false);
		assertEquals(3,cl.getCacheSize());
		
		cl.addNewObject("reddit.com", false);
		assertEquals(3,cl.getCacheSize());
		
		
	}
}
