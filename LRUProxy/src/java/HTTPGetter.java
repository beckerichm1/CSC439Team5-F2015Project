package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HTTPGetter implements  Runnable{
	public Proxy manager;
	public Socket client;
	
	
	
	public HTTPGetter(Socket s, Proxy p){
		manager = p;
		client = s;
	}
	

	@Override
	public void run() {
		String url="";
		url = manager.cacheRequest.read( client );
		if (url != null && url.trim().length()>0)
		{
			// Step 2: Check to see if URL is cached
			//         Log this in the cache log.
			boolean hit = manager.cacheToFile.isCached(url);
			if (hit)
			{
				manager.cacheLog.logHit(url);
			}
			else
			{
				manager.cacheLog.logMiss(url);
			}

			// Step 3: Based on hit/miss, add to LRU
			// cache list.  This logs a message if 
			// an old cached object is deleted 				
			String removedURL = manager.cacheList.addNewObject(url, hit);
			if (removedURL.trim().length()>0)
			{
				//webCache.removeCache(removedURL);
				// physically removed the cached file
				manager.cacheToFile.remove(removedURL);
			}

			// Step 4: If hit, send data to output
			//         If miss, pull data and save it
			manager.cacheToFile.setOut( client );
			if (hit)
			{
				// display cached file to System.out
				manager.cacheToFile.read(url, client);
			}
			else
			{
				StringBuffer data = manager.miniHttp.fetch(url);
				manager.cacheToFile.write(url, data);
				OutputStream ostream = null;
				try {
					ostream = client.getOutputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					ostream.write(data.toString().getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				try {
					ostream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
