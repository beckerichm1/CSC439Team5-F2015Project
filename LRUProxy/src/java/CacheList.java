package server;
import java.util.LinkedList;

/**
 * CacheList
 * @author Ken Cooney
 * @date 06/09/2011
 * 
 * The most recently requested object is the first entry in
 * the linked list.  MaxSize is variable (assigned in the 
 * constructor)
 * 
 * 
 * Cost associated with scenarios:
 * 1) adding a new cache entry, cached objects < maxSize
 *    cost: 3 (check for cached file, add to start of list, cache file)
 *    
 * 2) adding a new cache entry, cached objects = maxSize
 *    cost: 4 (check for cached file, remove last object in linked list, add to start of list, remove cached file)
 *
 * 3) finding entry in cache
 *    average cost: 2+ceiling(maxSize/2) (check for cached file, remove object in linked list, add to start of list)
 *    worst case cost: 2+maxSize (check for cached file, remove object in linked list, add to start of list)
 *    
 * TESTED via CachListTestSuite.  All tests pass.
 * 
 */
public class CacheList 
{
	//Edited by Matthew Beckerich
	private CacheLog log; // not used yet
	private LinkedList<String> cacheList;
	private int maxSize;

	/**
	 * Constructor.  The minimum cache size is 1.
	 * @param directory - cache log directory for logging 
	 *                    objects removed from cache
	 * @param maxsize - maximum number of objects to cache
	 */
	public CacheList(String directory, int maxsize)
	{
		log = new CacheLog(directory);
		cacheList=new LinkedList<String>();
		if (maxsize<1)
		{
			this.maxSize=1;
		}
		else
		{
			this.maxSize=maxsize;
		}
	}
	
	/**
	 * addNewObject
	 * This puts the object in the front of he queue.
	 * It removes any repeated object and trims the
	 * list if the length exceeds maxSize.
	 * 
	 * @param URL - URL that was just requested
	 * @param hit - true if it was already cached.
	 * @return - object removed, if any.  We'll need
	 *           to remove this from the hash.
	 */
	public String addNewObject(String URL, boolean hit)
	{
		String removedURL="";
		
		if (hit)
		{
			cacheList.remove(URL);
		}
		
		
		// If size is MAXSIZE, remove last link
		if (cacheList.size()>=maxSize)
		{
			removedURL=(String)cacheList.getLast();
			log.logRemoval(removedURL);
			cacheList.removeLast();
		}

		// Newest is always the first.
		cacheList.addFirst(URL);
		
		//System.out.println("Added "+URL);
		
		//traverseTest();
		
		return removedURL;
	}
	
	/**
	 * getCacheSize
	 * Used by CacheListSizeThreeTests
	 * @return the number of objects cached
	 */
	public int getCacheSize()
	{
		return cacheList.size();
	}
	
	/**
	 * getHead
	 * Used by CacheListSizeThreeTests
	 * @return URL at this location or empty string if 
	 *         linkedlist is empty.
	 */
	public String getHead()
	{
		String returnedURL="";
		if (cacheList.size()>0)
		{
			returnedURL=cacheList.getFirst().toString();
		}
		return returnedURL;
	}

	/**
	 * get
	 * Used by CacheListSizeThreeTests
	 * @param i - index into the linklist.
	 * @return URL at this location or empty string if 
	 *         param exceeds the size of linked list
	 */
	public String get(int i)
	{
		String returnedURL="";
		if (i<cacheList.size())
		{
			returnedURL=cacheList.get(i).toString();
		}
		return returnedURL;
	}

	/**
	 * traverseList
	 * For testing purposes only.  This displays the 
	 * linklist of URLs.
	 */
	public void traverseTest()
	{
		for (int i=0; i<cacheList.size();i++)
		{
			System.out.print(cacheList.get(i)+" => ");
		}
		System.out.println("NULL");
	}
	
	
	public int getMaxSize(){
		return maxSize;
	}
	
	public LinkedList<String> getCacheList(){
		return cacheList;
	}
	
	public CacheLog getCacheLog(){
		return log;
	}
}
