package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class CacheLogTest{
	
	@Test
	public void testOpenLogForAppend() throws IOException{
		java.CacheLog c = new java.CacheLog("./data/");
		assertNotNull(c.getOut());
	}

	@Test
	public void testLogRemoval(){
		java.CacheLog c = new java.CacheLog("./data/");
		String test = c.removeString("http://nku.edu/~foxr");
		assertNotSame(c.removeString("http://nku.edu/~foxr"), test);
	}
	
	@Test
	public void testLogHit(){
		java.CacheLog c = new java.CacheLog("./data/");
		String test = c.hitString("http://nku.edu/~foxr");
		assertNotSame(c.hitString("http://nku.edu/~foxr"), test);
	}
	
	@Test
	public void testLogMiss(){
		java.CacheLog c = new java.CacheLog("./data/");
		String test = c.missString("http://nku.edu/~foxr");
		assertNotSame(c.missString("http://nku.edu/~foxr"), test);
	}
}
