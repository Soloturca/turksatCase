package com.project.stepdefs;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import static com.saf.framework.MyTestNGBaseClass.allureReport;

public class CreateBill {

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

    public void connectServerAndMoveExistFile(String user, String host, String password, ArrayList<String> shCommand, String file, String dir) {
        allureReport("", "Connecting to " + host, false);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setPassword(password);
            session.connect();

            /*allureReport("", "Moving old xml file to backup", false);
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(shCommand.get(0));
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            channel.disconnect();

            allureReport("", "Remove old .xlog files in /d101/d01/invprint/data/output/cbu/undetails/", false);
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(shCommand.get(1));
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            input = channel.getInputStream();
            channel.connect();

            inputReader = new InputStreamReader(input);
            bufferedReader = new BufferedReader(inputReader);
            allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            channel.disconnect();

            allureReport("", "Copying new xml file to /d101/d01/invprint/data/xml_cbu/", false);
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.put(file, dir);
            channelSftp.exit();*/

            ChannelShell channel = (ChannelShell) session.openChannel("shell");
            channel.setOutputStream(System.out);
            PrintStream shellStream = new PrintStream(channel.getOutputStream());// printStream for convenience
            channel.connect();

            shellStream.println(shCommand.get(0));
            shellStream.flush();
            Thread.sleep(10000);

            InputStream input = channel.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            /*while ((bufferedReader.readLine()) != null) {
                allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            }*/
            channel.disconnect();

            channel = (ChannelShell) session.openChannel("shell");
            channel.setOutputStream(System.out);
            shellStream = new PrintStream(channel.getOutputStream());// printStream for convenience
            channel.connect();

            shellStream.println(shCommand.get(1));
            shellStream.flush();
            Thread.sleep(150000);
            input = channel.getInputStream();
            inputReader = new InputStreamReader(input);
            bufferedReader = new BufferedReader(inputReader);
            /*while ((bufferedReader.readLine()) != null) {
                allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            }*/
            channel.disconnect();

            session.disconnect();

        } catch (JSchException | IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveOldFilesToBackup(String user, String host, String password, String command) {
        allureReport("", "Moving old xml file to backup", false);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setPassword(password);
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            while ((bufferedReader.readLine()) != null) {
                allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            }

            channel.disconnect();
            session.disconnect();

        } catch (JSchException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeOldXlogFiles(String user, String host, String password, String command) {
        allureReport("", "Remove old .xlog files in /d101/d01/invprint/data/output/cbu/undetails/", false);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setPassword(password);
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            while ((bufferedReader.readLine()) != null) {
                allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            }

            channel.disconnect();
            session.disconnect();

        } catch (JSchException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void copyingXmlFileToServer(String user, String host, String password, String file, String dir) {
        allureReport("", "Copying new xml file to /d101/d01/invprint/data/xml_cbu/", false);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setPassword(password);
            session.connect();

            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.put(file, dir);
            channelSftp.exit();
        } catch (JSchException | SftpException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateBill runShellCommands(String user, String host, String password, String command, int sleep) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setPassword(password);
            session.connect();

            ChannelShell channel = (ChannelShell) session.openChannel("shell");
            channel.setOutputStream(System.out);
            PrintStream shellStream = new PrintStream(channel.getOutputStream());// printStream for convenience
            channel.connect();

            shellStream.println(command);
            shellStream.flush();
            Thread.sleep(sleep * 1000);

            InputStream input = channel.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            /*while ((bufferedReader.readLine()) != null) {
                allureReport("", "Terminal Log : " + bufferedReader.readLine(), false);
            }*/
            channel.disconnect();
            session.disconnect();

        } catch (JSchException | IOException | InterruptedException e) {
            //
            throw new RuntimeException(e);
        }
        return this;
    }

    public boolean checkXlogFile(String user, String host, String password) throws JSchException, IOException, InterruptedException {
        allureReport("", "Checking XLOG file is created", false);
        boolean isFind = true;
        String line = null;
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        session.setConfig(config);
        session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setPassword(password);
        session.connect();

        Channel channel = null;

        for (int i = 0; i < 20; i++) {
            Thread.sleep(10000);
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand("cd /d101/d01/invprint/data/output/cbu/undetails; ls");
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            line = bufferedReader.readLine();

            if (line != null)
                break;
        }

        if (line == null)
            isFind = false;
        channel.disconnect();
        return isFind;
    }
}
