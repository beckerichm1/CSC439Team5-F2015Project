package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.*;


public class CacheToFileTest {

	
	
	@Test
	public void testCacheToFileConstructor(){
		String dirName = ".\\data\\";
		server.CacheToFile ctf = new server.CacheToFile(dirName);
		
		assertEquals(dirName, ctf.getDirectory());
		
		dirName = ".\\data\\";
		ctf = new server.CacheToFile(dirName);
		assertEquals(dirName, ctf.getDirectory());
		
		dirName = ".\\";
		ctf = new server.CacheToFile(dirName);
		assertEquals(dirName, ctf.getDirectory());
		
		dirName = "an invalid path";
		ctf = new server.CacheToFile(dirName);
		assertEquals(dirName, ctf.getDirectory());
		
		testCTFwrite();
	}
	
	
	
	public void testCTFwrite(){
		String dirName = ".\\data\\";
		server.CacheToFile ctf = new server.CacheToFile(dirName);
		
		ctf.write("I/Made/This/File.html", new StringBuffer("SUCCESS"));
		ctf.write("google.html", new StringBuffer("As if this is actually google"));
		
		File test = new File(dirName + "I_Made_This_File.html");
		assertTrue(test.exists());
		
		test = new File(dirName + "google.html");
		assertTrue(test.exists());
		
		test = new File(dirName + "doesntExist.dat");
		assertTrue( !test.exists() );
		
		test = new File(dirName + "I_Made_This_File.html");
		Scanner in = null;
		try {
			in = new Scanner(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(in.nextLine().equals("SUCCESS"));
		testExists();
	}
	
	
	public void testRemove(){
		
		String dirName = ".\\data\\";
		server.CacheToFile ctf = new server.CacheToFile(dirName);
		
		
		File temp = new File(dirName + "I_Made_This_File.html");
		assertTrue(temp.exists());
		ctf.remove("I_Made_This_File.html");
		temp = new File(dirName + "I_Made_This_File.html");
		assertTrue(!temp.exists());
		
		temp = new File(dirName + "google.html");
		assertTrue(temp.exists());
		ctf.remove("google.html");
		temp = new File(dirName + "google.html");
		assertTrue(!temp.exists());
		
		temp = new File(dirName + "dne.html");
		assertTrue(!temp.exists());
		ctf.remove("dne.html");
		temp = new File(dirName + "dne.html");
		assertTrue(!temp.exists());
		testRead();
	}
	
	
	public void testExists(){
		String dirName = ".\\data\\";
		server.CacheToFile ctf = new server.CacheToFile(dirName);
		
		assertTrue(ctf.isCached("I_Made_This_File.html"));
		assertTrue(ctf.isCached("google.html"));
		assertFalse(ctf.isCached("dne.dat"));
		testRead();
	}
	
	
	public void testRead(){
		
		String dirName = ".\\data\\";
		server.CacheToFile ctf = new server.CacheToFile(dirName);
		
		String valueRead = ctf.readString("I_Made_This_File.html");
		assertEquals("SUCCESS",valueRead);
		
		valueRead = ctf.readString("google.html");
		assertEquals("As if this is actually google", valueRead);
		
	}
	
}
