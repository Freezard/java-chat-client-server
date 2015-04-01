package edu.gu.majem.mbclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.gu.majem.mbcommon.Constants;
import edu.gu.majem.mbcommon.IClient;
import edu.gu.majem.mbcommon.IMessage;
import edu.gu.majem.mbcommon.IServer;
import edu.gu.majem.mbcommon.Message;
import edu.gu.majem.mbcommon.User;
import edu.gu.majem.mbclient.core.impl.Client;
import edu.gu.majem.mbclient.core.impl.Connection;
import edu.gu.majem.mbclient.core.impl.Options;

/**
 * To run this for the first time you need to do a "clean"
 * of both projects (to build them)
 * 
 * NOTE : This test has a Run Configuration
 * (Mark file > Run As ... > Run Configuration > 
 *  x = Arguments > VM Arguments) 
 * 
 * The following line parameters must be passed as VM Arguments;
 * 
 * -Djava.security.policy=security.policy	
 *
 * 
 * To turn off logging for Server, see runserver.sh (in Server project)
 * 
 * @author hajo
 *
 */
public class TestServer {

	static IServer s;
	
	// Run once before all tests
	@BeforeClass
	public static void setUp() throws RemoteException, NotBoundException {
		// Downloaded code is a security risk, need a Security Manager 
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6666);
		      s = (IServer) registry.lookup(Constants.MB_SERVER_NAME);
	            Options.note(new User("default", "default"));
	            Options.note(new Connection("127.0.0.1", 6666, 7890));
	}

	@Test
	public void testPing() throws RemoteException {
	//	String msg = s.ping();
	//	Assert.assertTrue( msg != null);
	}
	
	@Test
	public void testPrintMessage() throws RemoteException {
	    User u = new User("adam", "nothing");
	    IMessage m = new Message(u, "Hej!");
	    s.printMessage(m);
	}
	
	@Test
	public void testRegisterClient() throws RemoteException{
		IClient c = Client.getInstance();		
		//boolean a = s.registerClient(c);
		//boolean b = s.registerClient(c);
		
		//Assert.assertTrue(a == true);
		//Assert.assertTrue(b == false);
	}
	
	@Test
	public void testRemoveClient() throws RemoteException{
		IClient c = Client.getInstance();		
		//boolean a = s.removeClient(c);
		//boolean b = s.removeClient(c);
		
		//Assert.assertTrue(a == true);
		//Assert.assertTrue(b == false);
	}
}
