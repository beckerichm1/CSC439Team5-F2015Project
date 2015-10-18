package java;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestCacheLog{
	
	@Test
	public void testOpenLogForAppend() throws IOException{
		CacheLog c = new CacheLog("C:\\Users\\Alan\\workspace\\");
		assertNotNull(c.getOut());
	}

	@Test
	public void testLogRemoval(){
		CacheLog c = new CacheLog("C:\\Users\\Alan\\workspace\\");
		String test = c.removeString("http://nku.edu/~foxr");
		assertNotSame(c.removeString("http://nku.edu/~foxr"), test);
	}
	
	@Test
	public void testLogHit(){
		CacheLog c = new CacheLog("C:\\Users\\Alan\\workspace\\");
		String test = c.hitString("http://nku.edu/~foxr");
		assertNotSame(c.hitString("http://nku.edu/~foxr"), test);
	}
	
	@Test
	public void testLogMiss(){
		CacheLog c = new CacheLog("C:\\Users\\Alan\\workspace\\");
		String test = c.missString("http://nku.edu/~foxr");
		assertNotSame(c.missString("http://nku.edu/~foxr"), test);
	}
}
