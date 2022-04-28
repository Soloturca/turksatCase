package com.project.stepdefs;

import com.jcraft.jsch.*;
import com.saf.framework.MyTestNGBaseClass;

import java.io.*;
import java.util.Properties;

import static com.saf.framework.MyTestNGBaseClass.allureReport;

public class CreateBill {

    public void connectServer(String user, String host, String password, String shCommand) {
        allureReport("", "Connecting to " + host, false);
        System.out.println(shCommand);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setPassword(password);
            session.connect();
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(shCommand);

            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            System.out.println(bufferedReader.readLine());

        } catch (JSchException | IOException ex) {
            allureReport("FAIL", "Sh bağlantısı sağlanırken sorun yaşandı.", true);
        }
    }

    public void runCommand(Session session, String command) {
        try {
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            bufferedReader.close();
            inputReader.close();
            channel.disconnect();
        } catch (JSchException | IOException ex) {
            allureReport("FAIL", "Sh command could not run. Check Command Below:\n" + command, false);
        }
    }

    public void disconnectServer(Session session) {
        try {
            session.disconnect();
        } catch (Exception e) {
            allureReport("FAIL", "Could not disconnect from the server", false);
        }

    }

    public void moveFile() {

    }

    public String checkFileExist(File dir, boolean ssFlag) {
        allureReport("", "Checking file is exist or not.", false);
        String fileName = "";
        FilenameFilter filter = (dir1, name) -> name.startsWith("ip");
        String[] children = dir.list(filter);

        if (children.length == 0 && ssFlag)
            allureReport("FAIL", "Xml file could not find at below directory : \n" + dir + "", false);
        else {
            for (String child : children) {
                fileName = child;
                break;
            }
        }

        allureReport("", "File Name : " + fileName, false);
        return fileName;
    }
}
