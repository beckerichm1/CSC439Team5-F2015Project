package test;


import static org.junit.Assert.*;


import org.junit.*;

import java.net.Socket;

public class HTTPGetterTest {
	
	//Test that the constructor is capable of assigning the Proxy and Socket objects
	@Test
	public void testConstructor(){
		server.HTTPGetter test = new server.HTTPGetter(null,null);
		assertNull(test.manager);
		assertNull(test.client);
		
		Socket s = new Socket();
		test = new server.HTTPGetter(s, null);
		assertEquals(test.client, s);
		
	}
	
	

}
