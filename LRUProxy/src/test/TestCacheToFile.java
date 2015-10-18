package java;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.*;


public class TestCacheToFile {

	
	
	@Test
	public void testCacheToFileConstructor(){
		String dirName = "C:/Users/Matthew/Desktop/ServerTesting/";
		CacheToFile ctf = new CacheToFile(dirName);
		
		assertEquals(dirName, ctf.getDirectory());
		
		dirName = "C:\\Users\\Matthew\\Desktop\\ServerTesting\\";
		ctf = new CacheToFile(dirName);
		assertEquals(dirName, ctf.getDirectory());
		
		dirName = "/usr/seed/Desktop/tempLoc/";
		ctf = new CacheToFile(dirName);
		assertEquals(dirName, ctf.getDirectory());
		
		dirName = "an invalid path";
		ctf = new CacheToFile(dirName);
		assertEquals(dirName, ctf.getDirectory());
	}
	
	
	@Test 
	public void testCTFwrite(){
		String dirName = "C:\\Users\\Matthew\\Desktop\\ServerTesting\\";
		CacheToFile ctf = new CacheToFile(dirName);
		
		ctf.write("I/Made/This/File.html", new StringBuffer("LALILULELO"));
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
		
		assertTrue(in.nextLine().equals("LALILULELO"));
		
	}
	
	@Test
	public void testRemove(){
		
		String dirName = "C:\\Users\\Matthew\\Desktop\\ServerTesting\\";
		CacheToFile ctf = new CacheToFile(dirName);
		
		
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
	}
	
	@Test
	public void testExists(){
		String dirName = "C:\\Users\\Matthew\\Desktop\\ServerTesting\\";
		CacheToFile ctf = new CacheToFile(dirName);
		
		assertTrue(ctf.isCached("I_Made_This_File.html"));
		assertTrue(ctf.isCached("google.html"));
		assertFalse(ctf.isCached("dne.dat"));
		
	}
	
	@Test
	public void testRead(){
		
		String dirName = "C:\\Users\\Matthew\\Desktop\\ServerTesting\\";
		CacheToFile ctf = new CacheToFile(dirName);
		
		String valueRead = ctf.read("I_Made_This_File.html").toString();
		assertEquals("LALILULELO",valueRead);
		
		valueRead = ctf.read("google.html").toString();
		assertEquals("As if this is actually google", valueRead);
		
	}
	
}
