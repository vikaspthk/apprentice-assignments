package com.oracle.result;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;
import com.oracle.sshcon.GetCon;
import java.io.DataOutputStream;
import java.io.InputStream;

/**
 *
 * @author vikpatha
 */
public class Result {

    Session session = GetCon.getSession();
    Channel channel = GetCon.getChannel();
    String adecon = GetCon.adecon();

    public void output(String command) {
        try {
            InputStream in = channel.getInputStream();
            DataOutputStream dataOut = new DataOutputStream(channel.getOutputStream());
            dataOut.writeBytes(command + " \r\n");
            dataOut.flush();
            // and print the response 
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    System.out.print(new String(tmp, 0, i));
                }
                
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }

                Thread.sleep(500);
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        channel.disconnect();
        session.disconnect();
        

    }

}
