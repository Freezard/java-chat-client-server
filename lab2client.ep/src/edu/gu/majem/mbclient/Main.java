package edu.gu.majem.mbclient;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import edu.gu.majem.mbcommon.User;
import edu.gu.majem.mbclient.core.impl.Connection;
import edu.gu.majem.mbclient.core.impl.Options;
import edu.gu.majem.mbclient.util.Logger;
import edu.gu.majem.mbclient.view.MainFrame;

/**
 * Client application entry
 * 
 * NOTE: Application needs a policy file in
 * project directory, see security.policy
 *
 * @author hajo
 * 
 */

//DON'T TOUCH BELOW THIS -----------------------------------

public class Main {

    private static final int N_ARGS = 5;

    public static void main(String[] args) {
        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
        } catch (Exception e) {
            Logger.handle(e);
            JOptionPane.showMessageDialog(null, "Security problems");
        }
        if (args.length == N_ARGS) {
            Options.note(new User(args[0], args[1]));
            int registryPort = 0;
            int myPort = 0;
            try {
                registryPort = Integer.valueOf(args[3]);
                myPort = Integer.valueOf(args[4]);
            } catch (NumberFormatException e) {
                // Handled by finally
            } finally {
                Options.note(new Connection(args[2], registryPort, myPort));
            }
        } else {
            Options.note(new User("default", "default"));
            Options.note(new Connection("127.0.0.1", 6666, 7890));
        }

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
