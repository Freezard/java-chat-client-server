package edu.gu.majem.mbclient.core;

import java.beans.PropertyChangeSupport;
import java.util.List;

import edu.gu.majem.mbcommon.IMessage;
import edu.gu.majem.mbcommon.IServer;
import edu.gu.majem.mbcommon.User;

/**
 * Contract for client (from GUI view)
 *
 * @author hajo
 *
 */
public interface ILocalClient {
	public void setServer(IServer server);
	public void connect();
	public void disconnect();
	public void updateMessage(IMessage msg);
	public void setUser(User user);
	public PropertyChangeSupport getObservers();
}
