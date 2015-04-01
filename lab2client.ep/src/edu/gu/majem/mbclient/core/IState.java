package edu.gu.majem.mbclient.core;

import java.rmi.RemoteException;

import edu.gu.majem.mbcommon.IClient;
import edu.gu.majem.mbcommon.IServer;


/**
 * The contract for the different states
 * @author hajo
 *
 */
public interface IState {
	public IServer connect(IClient client) throws IllegalStateException;
	public void disconnect(IServer server, IClient client) throws IllegalStateException, RemoteException;
}
