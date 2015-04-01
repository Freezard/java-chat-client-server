package edu.gu.majem.mbclient.core;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.gu.majem.mbcommon.IClient;
import edu.gu.majem.mbcommon.IServer;
import edu.gu.majem.mbcommon.MBFile;
import edu.gu.majem.mbclient.core.impl.Options;
import edu.gu.majem.mbclient.exception.ExceptionHandler;
import edu.gu.majem.mbclient.exception.MBClientException;


/**
 * O
 * @author hajo
 *
 */
public class ConnectedState implements IState {
	public IServer connect(IClient client) throws IllegalStateException{
		throw new IllegalStateException("IllegalStateException: Already connected.");
	}
	
	public void disconnect(IServer server, IClient client) throws IllegalStateException, RemoteException {
		server.removeClient(client);
		UnicastRemoteObject.unexportObject(client, false);
	}
}