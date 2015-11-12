package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class CacheLogTest{
	
	@Test
	public void testOpenLogForAppend() throws IOException{
		server.CacheLog c = new server.CacheLog("./data/");
		assertNotNull(c.getOut());
	}

	@Test
	public void testLogRemoval(){
		server.CacheLog c = new server.CacheLog("./data/");
		String test = c.removeString("http://nku.edu/~foxr");
		assertNotSame(c.removeString("http://nku.edu/~foxr"), test);
	}
	
	@Test
	public void testLogHit(){
		server.CacheLog c = new server.CacheLog("./data/");
		String test = c.hitString("http://nku.edu/~foxr");
		assertNotSame(c.hitString("http://nku.edu/~foxr"), test);
	}
	
	@Test
	public void testLogMiss(){
		server.CacheLog c = new server.CacheLog("./data/");
		String test = c.missString("http://nku.edu/~foxr");
		assertNotSame(c.missString("http://nku.edu/~foxr"), test);
	}
}
