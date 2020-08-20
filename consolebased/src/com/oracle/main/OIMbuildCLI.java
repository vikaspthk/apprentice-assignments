package com.oracle.main;

/**
 *
 * @author vikpatha
 */
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.oracle.pojo.Commands;
import com.oracle.sshcon.GetCon;
import java.io.InputStream;

import com.oracle.result.Result;
import java.io.IOException;
import org.apache.commons.cli.*;

public class OIMbuildCLI {

    public static void main(String args[]) {
        Commands com = new Commands();

        String host, user, command;
        Options options = new Options();
        try {
            options.addOption("h", true, " for remote host name");
            options.addOption("u", true, "for username");
            options.addOption("c", true, "for ant command");
            CommandLineParser parser = new DefaultParser();
            CommandLine line = parser.parse(options, args);
            host = line.getOptionValue("h");
            user = line.getOptionValue("u");
            command = line.getOptionValue("c");
            GetCon.getInformation(host, user);
            if (line.hasOption('c')) {
                Result res = new Result();
                String path = "cd /scratch/" + GetCon.getUser() + "/view_storage/" + GetCon.getUser() + "_" + GetCon.getView() + "/iam/iam-build";
                com.setCommand(path + " && " + command);
                res.output(com.getCommand());

            }
        } catch (ParseException e) {
            HelpFormatter f = new HelpFormatter();
            f.printHelp("OptionsTip", options);
        }

    }
}
