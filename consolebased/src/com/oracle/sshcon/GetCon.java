package com.oracle.sshcon;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.Console;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 *
 * @author vikpatha
 */
public class GetCon {

    static Session session;
    static Channel channel;
    static String host, user, password, view;
    static char[] pass;

    /**
     * method to get the information of remote machine
     */
    public static void getInformation(String host, String user) {
        Console c = System.console();
        GetCon.host = host;
        //System.out.println("Enter your username: ");
        //user = c.readLine();
        GetCon.user=user;
        System.out.println("Enter your password: ");
        pass = c.readPassword();
        password = String.valueOf(pass);
        System.out.println("Enter View Name: ");
        view = c.readLine();
    }

    /**
     * Method to handshake with the remote machine
     *
     * @return session
     */
    public static Session getSession() {
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return session;

    }

    public static String getView() {
        return view;
    }

    public static String getUser() {
        return user;
    }

    public static Channel getChannel() {
        try {
            channel = session.openChannel("shell");
            channel.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return channel;
    }

    public static String adecon() {
        try {
            String adecon = "ade useview " + view;
            DataOutputStream dataOut = new DataOutputStream(channel.getOutputStream());
            dataOut.writeBytes(adecon + " \r\n");
            dataOut.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "connected to view";
    }

}
