package edu.gu.majem.mbclient.util;


import java.rmi.RemoteException;

import edu.gu.majem.mbcommon.IClient;
import edu.gu.majem.mbclient.core.ILocalClient;
import edu.gu.majem.mbclient.core.IObservable;
import edu.gu.majem.mbclient.core.impl.Client;

/**
 * A class returning services (interfaces)
 * to other other parts of application.
 * 
 * 
 * @author hajo
 *
 */
public final class ResourceLocator {

	public static IClient getClient() throws RemoteException {
		return (IClient) Client.getInstance();
	}
	
	public static ILocalClient getLocalClient() throws RemoteException {
		return (ILocalClient) Client.getInstance();
	}
	
	public static IObservable getClientAsObservable() throws RemoteException {
		return (IObservable) Client.getInstance();
	}
}
