package com.project.stepdefs;

import com.jcraft.jsch.*;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Properties;

import static com.project.stepdefs.CCS_Usage_Test.filePath;
import static com.saf.framework.MyTestNGBaseClass.allureReport;
import static java.lang.Thread.sleep;

public class CreateBill {

    String xLogName = null;

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
            sleep(3000);
        } catch (JSchException | SftpException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateBill runShellCommands(String user, String host, String password, String command, int sleep) {
        allureReport("", "Running Command : " + command, false);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");

            session.setConfig(config);
            session.setPassword(password);
            session.connect();

            ChannelShell channel = (ChannelShell) session.openChannel("shell");
            channel.setOutputStream(System.out, true);

            PrintStream shellStream = new PrintStream(channel.getOutputStream());
            Thread.sleep(1000);
            channel.connect();
            Thread.sleep(1000);
            shellStream.println("#!/bin/sh");
            shellStream.println(command);
            shellStream.flush();
            Thread.sleep(sleep * 1000);

            channel.disconnect();
            session.disconnect();

        } catch (JSchException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public boolean checkXlogFile(String user, String host, String password) throws JSchException, IOException, InterruptedException {
        allureReport("", "Checking XLOG file is created", false);
        boolean isFind = true;
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
            sleep(10000);
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand("cd /d101/d01/invprint/data/output/cbu/undetails; ls");
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream input = channel.getInputStream();
            channel.connect();

            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            xLogName = bufferedReader.readLine();

            if (xLogName != null)
                break;
        }

        if (xLogName == null)
            isFind = false;
        channel.disconnect();
        return isFind;
    }

    public CreateBill moveXMLDone(String fileName) {
        allureReport("", "Move XML to Done File", false);
        File source = new File(filePath + fileName);
        File dest = new File(filePath + "Done\\");
        try {
            FileUtils.moveFileToDirectory(source, dest, false);
        } catch (IOException e) {
            e.printStackTrace();
            allureReport("FAIL", "XML File could not move to Done File", true);
        }
        return this;
    }

    public void moveXLogFile(String user, String host, String password, String dir) {
        allureReport("", "Copying created XLog file", false);
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
            channelSftp.get("/d101/d01/invprint/data/output/cbu/undetails/" + xLogName, dir);
            channelSftp.exit();
        } catch (JSchException | SftpException e) {
            throw new RuntimeException(e);
        }
    }
}
