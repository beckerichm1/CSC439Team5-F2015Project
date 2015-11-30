package test;

import static org.junit.Assert.*;

import org.junit.*;


public class ProxyTest {

/*	
	@Test
	public void inputPresent(){
		server.Proxy p = new server.Proxy(".\\co\\LRUProxy\\data\\", 10,0);
		
		assertTrue(p.isInputFilePresent());

		
	}
	*/
	
	/*
	@Test
	public void validDirectory(){
		server.Proxy p = new server.Proxy(".\\co\\LRUProxy\\data\\", 10,0);
		
		assertTrue(p.isValidDirectory());
		
		p = new server.Proxy(".\\co\\LRUProxy\\datadoesnotexist\\", 10,0);
		assertFalse(p.isValidDirectory());
	}
	*/
	
	@Test
	public void constructorTest(){
		String dirname = ".\\co\\LRUProxy\\data\\";
		server.Proxy p = new server.Proxy(dirname, -1,-1);
		assertEquals(p.directory, dirname);
		
		assertEquals(p.sleepSeconds, 0);
	}
}
