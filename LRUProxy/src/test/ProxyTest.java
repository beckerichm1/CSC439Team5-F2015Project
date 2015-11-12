package test;

import static org.junit.Assert.*;

import org.junit.*;


public class ProxyTest {

/*	
	@Test
	public void inputPresent(){
		server.Proxy p = new server.Proxy("C:\\Users\\Matthew\\Desktop\\ServerTesting\\", 10,0);
		
		assertTrue(p.isInputFilePresent());
		//p = new server.Proxy("C:\\Users\\Matthew\\Desktop\\", 10,0);
		//assertFalse(p.isInputFilePresent());
		
	}
	*/
	
	/*
	@Test
	public void validDirectory(){
		server.Proxy p = new server.Proxy("C:\\Users\\Matthew\\Desktop\\ServerTesting\\", 10,0);
		
		assertTrue(p.isValidDirectory());
		
		p = new server.Proxy("C:\\Users\\Matthew\\Desktop\\ServerTestsakvabaksdbv\\", 10,0);
		assertFalse(p.isValidDirectory());
	}
	*/
	
	@Test
	public void constructorTest(){
		String dirname = ".\\data\\";
		server.Proxy p = new server.Proxy(dirname, -1,-1);
		assertEquals(p.directory, dirname);
		System.out.println(p.sleepSeconds);
		assertEquals(p.sleepSeconds, 0);
	}
}
