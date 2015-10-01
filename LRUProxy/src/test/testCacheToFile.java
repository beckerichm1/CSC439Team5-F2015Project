package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class testCacheToFile{
	
	@Test
	public void testRemove(){
		
	}
	
	@Test
	public void testWrite(){
		
	}
	
	@Test
	public void testRead(){
		
	}
	
	@Test
	public void testIsCached(){
		
	}
	
	//Tests should not have a main
	public static void main(String[] args){
		List<String> sites = new ArrayList<String>();
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(fileScanner.hasNext()){
		java.CacheToFile cache = new java.CacheToFile("");
		
		}
	}
}
