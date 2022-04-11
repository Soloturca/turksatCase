package com.project.stepdefs;

import com.jcraft.jsch.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class SSH2 {

    public static ArrayList<String> msisdnList = new ArrayList<>();
    public static ArrayList<String> messageList = new ArrayList<>();

    public static ArrayList<String> omonList = new ArrayList<>();
    public static ArrayList<String> omonMsisdnList = new ArrayList<>();

    public static ArrayList<String> voiceList = new ArrayList<>();
    public static ArrayList<String> voiceMsisdnList = new ArrayList<>();

    public static ArrayList<String> dataList = new ArrayList<>();
    public static ArrayList<String> dataMsisdnList = new ArrayList<>();

    public static ArrayList<String> smsList = new ArrayList<>();
    public static ArrayList<String> smsMsisdnList = new ArrayList<>();

    public static ArrayList<String> intVoiceDataList = new ArrayList<>();
    public static ArrayList<String> intVoiceDataMsisdnList = new ArrayList<>();

    public static ArrayList<String> intSmsList = new ArrayList<>();
    public static ArrayList<String> intSmsMsisdnList = new ArrayList<>();

    public static ArrayList<String> intMmsList = new ArrayList<>();
    public static ArrayList<String> intMmsMsisdnList = new ArrayList<>();

    public static ArrayList<String> roamVoiceList = new ArrayList<>();
    public static ArrayList<String> roamVoiceMsisdnList = new ArrayList<>();

    public static ArrayList<String> roamSmsList = new ArrayList<>();
    public static ArrayList<String> roamSmsMsisdnList = new ArrayList<>();

    public static ArrayList<String> roamMTVoiceList = new ArrayList<>();
    public static ArrayList<String> roamMTVoiceMsisdnList = new ArrayList<>();

    public static ArrayList<String> roamDataList = new ArrayList<>();
    public static ArrayList<String> roamDataMsisdnList = new ArrayList<>();

    public static ArrayList<String> natRGList = new ArrayList<>();
    public static ArrayList<String> natRGMsisdnList = new ArrayList<>();

    public static ArrayList<String> natVoiceVodafoneList = new ArrayList<>();
    public static ArrayList<String> natVoiceVodafoneMsisdnList = new ArrayList<>();

    public static ArrayList<String> natVoiceFixedLineList = new ArrayList<>();
    public static ArrayList<String> natVoiceFixedLineMsisdnList = new ArrayList<>();

    public static ArrayList<String> natVoiceBundleList = new ArrayList<>();
    public static ArrayList<String> natVoiceBundleMsisdnList = new ArrayList<>();

    public static ArrayList<String> natDataBundleList = new ArrayList<>();
    public static ArrayList<String> natDataBundleMsisdnList = new ArrayList<>();

    public static ArrayList<String> natSmsBundleList = new ArrayList<>();
    public static ArrayList<String> natSmsBundleMsisdnList = new ArrayList<>();

    public static ArrayList<String> natRGBundleList = new ArrayList<>();
    public static ArrayList<String> natRGBundleMsisdnList = new ArrayList<>();

    static String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";
    static String natVoiceCalledMSISDN = " ";
    static String natVoiceUsage = " ";
    static String natDataUsage = " ";
    static String natDataRg = " ";
    static String natSmsUsage = " ";

    static String intVoiceCalledMSISDN = " ";
    static String intVoiceUsage = " ";
    static String intSmsCalledMSISDN = " ";
    static String intSmsUsage = " ";
    static String intMmsCalledMSISDN = " ";
    static String intMmsUsage = " ";

    static String roamVoiceCalledMSISDN = " ";
    static String roamVoiceUsage = " ";
    static String roamVoiceOperator = " ";
    static String roamSmsCalledMSISDN = " ";
    static String roamSmsUsage = " ";
    static String roamSmsOperator = " ";
    static String roamMTVoiceCalledMSISDN = " ";
    static String roamMTVoiceUsage = " ";
    static String roamMTVoiceOperator = " ";
    static String roamDataUsage = " ";
    static String roamDataOperator = " ";

    static String natRatingGroupUsage = " ";
    static String natRatingGroupRg = " ";

    static String natVoiceVodafoneCalledMSISDN = " ";
    static String natVoiceVodafoneUsage = " ";
    static String natVoiceFixedLineCalledMSISDN = " ";
    static String natVoiceFixedLineUsage = " ";

    static double natVoiceBundle = 0;
    static String natDataBundle = null;
    static double natSmsBundle = 0;
    static double natRatingGroupBundle = 0;

    public static void main(String[] args) throws IOException {
        File dirPath = new File(filePath);
        String selectedFile=findTemplateFile(dirPath);
        readCheckSms(filePath+selectedFile);
        createAndWriteToExcel(selectedFile);
        moveTemplateFile(selectedFile);

    }

    public static void openAndRun(String shType, String host, String user, String password, String msisdn, String offerKey) {
        String shCommand = null;
        String newMsiSdn = null;
        if (shType == "checkSMS") {
            shCommand = "cd /home/gfep/fep/SMSC/; ./check_sms.sh " + msisdn;
        } else if (shType == "omon"){
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/filter/; ./filtered.sh " + newMsiSdn + " " + offerKey + " " + shType;
        } else if(shType == "nat_voice") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMsiSdn + " " + natVoiceCalledMSISDN + " " + natVoiceUsage;
        } else if(shType == "nat_data") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMsiSdn + " " + natDataUsage + " " + natDataRg;
        } else if(shType == "nat_sms") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./sms.sh " + newMsiSdn + " " + natSmsUsage;
        } else if(shType == "int_voice_data") {
            shCommand = "cd ismail/awk/script/send_v3/; ./internationalcall.sh " + msisdn + " " + intVoiceCalledMSISDN + " " + intVoiceUsage;
        } else if(shType == "int_sms") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./international_sms.sh " + newMsiSdn + " " + intSmsCalledMSISDN + " " + intSmsUsage;
        } else if(shType == "int_mms") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./international_mms.sh " + newMsiSdn + " " + intMmsCalledMSISDN + " " + intMmsUsage;
            System.out.println("INT MMS SH = " + shCommand);
        } else if(shType == "roam_voice") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/roaming/; ./call_roaming.sh " + newMsiSdn + " " + roamVoiceCalledMSISDN + " " + roamVoiceUsage + " " + roamVoiceOperator;
        } else if(shType == "roam_sms") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/roaming/; ./sms_roaming.sh " + roamSmsOperator + " 90 " + msisdn + " " + roamSmsCalledMSISDN + " " + roamSmsUsage;
        } else if(shType == "roam_mt_voice") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/roaming/; ./call_mt_roaming.sh " + newMsiSdn + " " + roamMTVoiceCalledMSISDN + " " + roamMTVoiceUsage + " " + roamMTVoiceOperator;
            System.out.println("ROAM MT VOICE SH = " + shCommand);
        } else if(shType == "roam_data") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/roaming/; ./gprs_roaming.sh " + newMsiSdn + " " + roamDataUsage + " " + roamDataOperator + " 0";
        } else if(shType == "nat_rg") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMsiSdn + " " + natRatingGroupUsage + " " + natRatingGroupRg;
        } else if(shType == "nat_voice_vodafone") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMsiSdn + " " + natVoiceVodafoneCalledMSISDN + " " + natVoiceVodafoneUsage;
        } else if(shType == "nat_voice_fixed_line") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMsiSdn + " " + natVoiceFixedLineCalledMSISDN + " " + natVoiceFixedLineUsage;
        } else if(shType == "nat_voice_bundle") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMsiSdn + " " + natVoiceCalledMSISDN + " " + (natVoiceBundle * 0.85);
        } else if(shType == "nat_data_bundle") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            int dataBundleTemplate = Integer.parseInt(natDataBundle);
            String natData80Bundle = Double.toString(dataBundleTemplate * 0.85);
            System.out.println("DATA BUNDLE IS " + natDataBundle);
            System.out.println("NAT DATA BUNDLE IS " + natData80Bundle + " NAT DATA RG IS " + natDataRg);
            shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMsiSdn + " " + natData80Bundle + " " + natDataRg;
        } else if(shType == "nat_sms_bundle") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            String natSms80Bundle = Double.toString(natSmsBundle * 0.85);
            System.out.println("NAT SMS BUNDLE IS " + natSms80Bundle);
            shCommand = "cd ismail/awk/script/send_v3/; ./sms.sh " + newMsiSdn + " " + natSms80Bundle;
        } else if(shType == "nat_rg_bundle") {
            if (msisdn.length() == 12) {
                newMsiSdn = msisdn.substring(2);
            } else if (msisdn.length() == 11) {
                newMsiSdn = msisdn.substring(1);
            } else {
                newMsiSdn = msisdn;
            }
            System.out.println("NAT RG BUNDLE IS " + natRatingGroupBundle + " NAT RG RG IS " + natRatingGroupRg);
            shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMsiSdn + " " + natRatingGroupBundle + " " + natRatingGroupRg;
        }

        String SMS = "";
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
            try {
                if (shType.equals("checkSMS")) {
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        msisdnList.add(msisdn);
                        messageList.add(line);
                        SMS += line + "\n";
                    }
                    bufferedReader.close();
                    inputReader.close();
                } else if (shType.equals("omon")) {
                    Thread.sleep(3 * 60 * 1000);
                    sftpsript(newMsiSdn);
                } else if (shType.equals("nat_voice")) {

                    String VOICE = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        voiceMsisdnList.add(msisdn);
                        voiceList.add(line);
                        VOICE += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_data")) {

                    String DATA = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        dataMsisdnList.add(msisdn);
                        dataList.add(line);
                        DATA += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_sms")) {

                    String natSms = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        smsMsisdnList.add(msisdn);
                        smsList.add(line);
                        natSms += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("int_voice_data")) {

                    String intVoiceData = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        intVoiceDataMsisdnList.add(msisdn);
                        intVoiceDataList.add(line);
                        intVoiceData += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("int_sms")) {

                    String intSMS = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        intSmsMsisdnList.add(msisdn);
                        intSmsList.add(line);
                        intSMS += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("int_mms")) {

                    String intMMS = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        intMmsMsisdnList.add(msisdn);
                        intMmsList.add(line);
                        intMMS += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("roam_voice")) {

                    String intMMS = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        roamVoiceMsisdnList.add(msisdn);
                        roamVoiceList.add(line);
                        intMMS += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("roam_sms")) {

                    String roamSMS = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        roamSmsMsisdnList.add(msisdn);
                        roamSmsList.add(line);
                        roamSMS += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("roam_mt_voice")) {

                    String roamSMS = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        roamMTVoiceMsisdnList.add(msisdn);
                        roamMTVoiceList.add(line);
                        roamSMS += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("roam_data")) {

                    String roamData = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        roamDataMsisdnList.add(msisdn);
                        roamDataList.add(line);
                        roamData += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_rg")) {

                    String natRG = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natRGMsisdnList.add(msisdn);
                        natRGList.add(line);
                        natRG += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_voice_vodafone")) {

                    String VOICE = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natVoiceVodafoneMsisdnList.add(msisdn);
                        natVoiceVodafoneList.add(line);
                        VOICE += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_voice_fixed_line")) {

                    String VOICE = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natVoiceFixedLineMsisdnList.add(msisdn);
                        natVoiceFixedLineList.add(line);
                        VOICE += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_voice_bundle")) {

                    String VOICE = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natVoiceBundleMsisdnList.add(msisdn);
                        natVoiceBundleList.add(line);
                        VOICE += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_data_bundle")) {

                    String DATA = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natDataBundleMsisdnList.add(msisdn);
                        natDataBundleList.add(line);
                        DATA += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_sms_bundle")) {

                    String natSms = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natSmsBundleMsisdnList.add(msisdn);
                        natSmsBundleList.add(line);
                        natSms += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                } else if (shType.equals("nat_rg_bundle")) {

                    String natRG = "";
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        natRGBundleMsisdnList.add(msisdn);
                        natRGBundleList.add(line);
                        natRG += line + "\n";
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    inputReader.close();

                }

                channel.disconnect();
                session.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (JSchException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static void readCheckSms(String path) {
        boolean firstRow = true;
        String tmpMsiSdn = null; //variable for storing the cell 0 value
        String tmpOfferKey = null; //variable for storing the cell 3 value
        Workbook wbook = null; //initialize Workbook null
        String tmpMSISDN = null; //variable for storing the cell 0 value
        natVoiceCalledMSISDN = " ";
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(path);
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index

        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            if (firstRow) {
                itr.next();
                firstRow = false;
            }
            Row rowitr = (Row) itr.next();
            Iterator<Cell> cellitr = rowitr.cellIterator();
            while(cellitr.hasNext()) {
                Cell celldata = (Cell) cellitr.next();
                switch(celldata.getColumnIndex()) {
                    case 0             : //MSISDN
                        tmpMSISDN=celldata.getStringCellValue().trim();
                        break;
                    case 3             : //OfferKey
                        try
                        {
                            tmpOfferKey=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            tmpOfferKey=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 4             : //National Voice Called MSISDN
                        try
                        {

                            natVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {

                            natVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 5             : //National Voice Usage
                        try
                        {
                            natVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 6             : //National Data Usage
                        try
                        {
                            natDataUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natDataUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 7             : //National Data Rg
                        try
                        {
                            natDataRg=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natDataRg=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 8             : //National Sms Usage
                        try
                        {
                            natSmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natSmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 9             : //International Voice Called MSISDN
                        try
                        {
                            intVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 10             : //International Voice Usage
                        try
                        {
                            intVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 11             : //International Sms Called MSISDN
                        try
                        {
                            intSmsCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intSmsCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 12             : //International Sms Usage
                        try
                        {
                            intSmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intSmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 13             : //International Mms Called MSISDN
                        try
                        {
                            intMmsCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intMmsCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 14            : //International Mms Usage
                        try
                        {
                            intMmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intMmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 15            : //Roaming Voice Called MSISDN
                        try
                        {
                            roamVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 16            : //Roaming Voice Usage
                        try
                        {
                            roamVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 17            : //Roaming Voice Operator
                        try
                        {
                            roamVoiceOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamVoiceOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 18            : //Roaming Sms Operator
                        try
                        {
                            roamSmsOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamSmsOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 19            : //Roaming Sms Called MSISDN
                        try
                        {
                            roamSmsCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamSmsCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 20            : //Roaming Sms Usage
                        try
                        {
                            roamSmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamSmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 21            : //Roaming MT Voice Called MSISDN
                        try
                        {
                            roamMTVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamMTVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 22            : //Roaming MT Voice Usage
                        try
                        {
                            roamMTVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamMTVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 23            : //Roaming MT Voice Operator
                        try
                        {
                            roamMTVoiceOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamMTVoiceOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 24            : //Roaming Data Usage
                        try
                        {
                            roamDataUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamDataUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 25            : //Roaming Data Operator
                        try
                        {
                            roamDataOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamDataOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 26            : //National Data Rating Group Usage
                        try
                        {
                            natRatingGroupUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroupUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 27            : //National Data Rating Group Rg
                        try
                        {
                            natRatingGroupRg=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroupRg=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 28            : //National Voice Vodafone Called MSISDN
                        try
                        {
                            natVoiceVodafoneCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceVodafoneCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 29            : //National Voice Vodafone Usage
                        try
                        {
                            natVoiceVodafoneUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceVodafoneUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 30            : //National Voice Fixed Lines Called MSISDN
                        try
                        {
                            natVoiceFixedLineCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceFixedLineCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 31            : //National Voice Fixed Lines Usage
                        try
                        {
                            natVoiceFixedLineUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceFixedLineUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 32            : //National Voice Bundle

                            natVoiceBundle=celldata.getNumericCellValue()
                            ;
                        break;
                    case 33            : //National Data Bundle

                        try
                        {
                            natDataBundle=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natDataBundle=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 34            : //National Sms Bundle

                            natSmsBundle=celldata.getNumericCellValue();

                        break;
                    case 35            : //National Rating Group Bundle

                            natRatingGroupBundle=celldata.getNumericCellValue();

                        break;
                }
            }
            String MSISDN=tmpMSISDN;
            String OfferKey=tmpOfferKey;
            if (MSISDN == null || MSISDN == "")
            {
                break;
            }
             openAndRun("checkSMS", "10.144.11.99", "gfep", "Huawei123", MSISDN,"0");
            //openAndRun("omon", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,OfferKey);
            openAndRun("nat_voice", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("nat_data", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("nat_sms", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("int_voice_data", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("int_sms", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("int_mms", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("roam_voice", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("roam_sms", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("roam_mt_voice", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("roam_data", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("nat_rg", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("nat_voice_vodafone", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            openAndRun("nat_voice_fixed_line", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            /*
            System.out.println("VOICE BUNDLE");
            openAndRun("nat_voice_bundle", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            System.out.println("DATA BUNDLE");
            openAndRun("nat_data_bundle", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            System.out.println("SMS BUNDLE");
            openAndRun("nat_sms_bundle", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");
            System.out.println("RG BUNDLE");
            openAndRun("nat_rg_bundle", "10.144.15.141", "cbp", "Cbp_0001", MSISDN,"0");    */

        }

    }

    public static void createAndWriteToExcel(String newFileName) throws IOException {
        try {
            newFileName = newFileName.replace("Test", "Testbook");
            String fileName = filePath + "TestBook\\" + newFileName;
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Check_Sms");

            int rowCount = 0;
            int listElement = 0;
            Row row = sheet.createRow(rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue("MSISDN");
            cell = row.createCell(1);
            cell.setCellValue("Message");

            String temp = "";
            int template = 0;
            for (String message : messageList) {
                row = sheet.createRow(++rowCount);
                cell = row.createCell(0);
                if (!(temp.equalsIgnoreCase(msisdnList.get(rowCount - 1)))) {
                    temp = msisdnList.get(rowCount - 1);
                    cell.setCellValue(msisdnList.get(rowCount - 1));
                }

                cell = row.createCell(1);
                cell.setCellValue(message);
            }

            //Omon sheet aktarımı
            XSSFSheet omonSheet = workbook.createSheet("omon_cdr");

            int omonRowCount = 0;
            int omonListElement = 0;
            Row omonRow = omonSheet.createRow(omonRowCount);
            Cell omonCell = omonRow.createCell(0);
            omonCell.setCellValue("MSISDN");
            omonCell = omonRow.createCell(1);
            omonCell.setCellValue("CDR");

            String omonTemp = "";
            int omonTemplate = 0;
            for (String omon : omonList) {
                omonRow = omonSheet.createRow(++omonRowCount);
                omonCell = omonRow.createCell(0);
                if (!(omonTemp.equalsIgnoreCase(omonMsisdnList.get(omonRowCount - 1)))) {
                    omonTemp = omonMsisdnList.get(omonRowCount - 1);
                    omonCell.setCellValue(omonTemp);
                }

                omonCell = omonRow.createCell(1);
                omonCell.setCellValue(omon);
            }

            //Voice sheet aktarımı
            XSSFSheet voiceSheet = workbook.createSheet("nat_voice_cdr");
            int voiceRowCount = 0;
            int voiceListElement = 0;
            Row voiceRow = voiceSheet.createRow(voiceRowCount);
            Cell voiceCell = voiceRow.createCell(0);
            voiceCell.setCellValue("MSISDN");
            voiceCell = voiceRow.createCell(1);
            voiceCell.setCellValue("nat_voice_CDR");

            String voiceTemp = "";
            int voiceTemplate = 0;
            for (String voice : voiceList) {
                if (voice.contains("/enip/")){
                    voiceRow = voiceSheet.createRow(++voiceRowCount);
                    voiceCell = voiceRow.createCell(0);
                    if (!(voiceTemp.equalsIgnoreCase(voiceMsisdnList.get(voiceRowCount - 1)))) {
                        voiceTemp = voiceMsisdnList.get(voiceRowCount - 1);
                        voiceCell.setCellValue(voiceTemp);
                    }
                    voiceCell = voiceRow.createCell(1);
                    voiceCell.setCellValue(voice);
                }

            }

            //Data sheet aktarımı
            XSSFSheet dataSheet = workbook.createSheet("nat_data_cdr");
            int dataRowCount = 0;
            int dataListElement = 0;
            Row dataRow = dataSheet.createRow(dataRowCount);
            Cell dataCell = dataRow.createCell(0);
            dataCell.setCellValue("MSISDN");
            dataCell = dataRow.createCell(1);
            dataCell.setCellValue("nat_data_CDR");

            String dataTemp = "";
            int dataTemplate = 0;
            for (String data : dataList) {
                if (data.contains("/enip/")){
                    dataRow = dataSheet.createRow(++dataRowCount);
                    dataCell = dataRow.createCell(0);
                    if (!(dataTemp.equalsIgnoreCase(dataMsisdnList.get(dataRowCount - 1)))) {
                        dataTemp = dataMsisdnList.get(dataRowCount - 1);
                        dataCell.setCellValue(dataTemp);
                    }
                    dataCell = dataRow.createCell(1);
                    dataCell.setCellValue(data);
                }

            }

            //sms sheet aktarımı
            XSSFSheet smsSheet = workbook.createSheet("nat_sms_cdr");
            int smsRowCount = 0;
            int smsListElement = 0;
            Row smsRow = smsSheet.createRow(smsRowCount);
            Cell smsCell = smsRow.createCell(0);
            smsCell.setCellValue("MSISDN");
            smsCell = smsRow.createCell(1);
            smsCell.setCellValue("nat_sms_CDR");

            String smsTemp = "";
            int smsTemplate = 0;
            for (String sms : smsList) {
                if (sms.contains("/enip/")){
                    smsRow = smsSheet.createRow(++smsRowCount);
                    smsCell = smsRow.createCell(0);
                    if (!(smsTemp.equalsIgnoreCase(smsMsisdnList.get(smsRowCount - 1)))) {
                        smsTemp = smsMsisdnList.get(smsRowCount - 1);
                        smsCell.setCellValue(smsTemp);
                    }
                    smsCell = smsRow.createCell(1);
                    smsCell.setCellValue(sms);
                }

            }

            //intVoiceData sheet aktarımı
            XSSFSheet intVoiceDataSheet = workbook.createSheet("int_voice_cdr");
            int intVoiceDataRowCount = 0;
            int intVoiceDataListElement = 0;
            Row intVoiceDataRow = intVoiceDataSheet.createRow(intVoiceDataRowCount);
            Cell intVoiceDataCell = intVoiceDataRow.createCell(0);
            intVoiceDataCell.setCellValue("MSISDN");
            intVoiceDataCell = intVoiceDataRow.createCell(1);
            intVoiceDataCell.setCellValue("INT_VOICE_DATA_CDR");

            String intVoiceDataTemp = "";
            int intVoiceDataTemplate = 0;
            for (String intVoiceData : intVoiceDataList) {
                if (intVoiceData.contains("/enip/")){
                    intVoiceDataRow = intVoiceDataSheet.createRow(++intVoiceDataRowCount);
                    intVoiceDataCell = intVoiceDataRow.createCell(0);
                    if (!(intVoiceDataTemp.equalsIgnoreCase(intVoiceDataMsisdnList.get(intVoiceDataRowCount - 1)))) {
                        intVoiceDataTemp = intVoiceDataMsisdnList.get(intVoiceDataRowCount - 1);
                        intVoiceDataCell.setCellValue(intVoiceDataTemp);
                    }
                    intVoiceDataCell = intVoiceDataRow.createCell(1);
                    intVoiceDataCell.setCellValue(intVoiceData);
                }

            }

            //intSms sheet aktarımı
            XSSFSheet intSmsSheet = workbook.createSheet("int_sms_cdr");
            int intSmsRowCount = 0;
            int intSmsListElement = 0;
            Row intSmsRow = intSmsSheet.createRow(intSmsRowCount);
            Cell intSmsCell = intSmsRow.createCell(0);
            intSmsCell.setCellValue("MSISDN");
            intSmsCell = intSmsRow.createCell(1);
            intSmsCell.setCellValue("INT_SMS_CDR");

            String intSmsTemp = "";
            int intSmsTemplate = 0;
            for (String intSms : intSmsList) {
                if (intSms.contains("/enip/")){
                    intSmsRow = intSmsSheet.createRow(++intSmsRowCount);
                    intSmsCell = intSmsRow.createCell(0);
                    if (!(intSmsTemp.equalsIgnoreCase(intSmsMsisdnList.get(intSmsRowCount - 1)))) {
                        intSmsTemp = intSmsMsisdnList.get(intSmsRowCount - 1);
                        intSmsCell.setCellValue(intSmsTemp);
                    }
                    intSmsCell = intSmsRow.createCell(1);
                    intSmsCell.setCellValue(intSms);
                }

            }

            //intMms sheet aktarımı
            XSSFSheet intMmsSheet = workbook.createSheet("int_mms_cdr");
            int intMmsRowCount = 0;
            int intMmsListElement = 0;
            Row intMmsRow = intMmsSheet.createRow(intMmsRowCount);
            Cell intMmsCell = intMmsRow.createCell(0);
            intMmsCell.setCellValue("MSISDN");
            intMmsCell = intMmsRow.createCell(1);
            intMmsCell.setCellValue("INT_MMS_CDR");

            String intMmsTemp = "";
            int intMmsTemplate = 0;
            for (String intMms : intMmsList) {
                if (intMms.contains("/enip/") || intMms.contains("|")){
                    intMmsRow = intMmsSheet.createRow(++intMmsRowCount);
                    intMmsCell = intMmsRow.createCell(0);
                    if (!(intMmsTemp.equalsIgnoreCase(intMmsMsisdnList.get(intMmsRowCount - 1)))) {
                        intMmsTemp = intMmsMsisdnList.get(intMmsRowCount - 1);
                        intMmsCell.setCellValue(intMmsTemp);
                    }
                    intMmsCell = intMmsRow.createCell(1);
                    intMmsCell.setCellValue(intMms);
                }

            }

            //roamVoice sheet aktarımı
            XSSFSheet roamVoiceSheet = workbook.createSheet("roam_voice_cdr");
            int roamVoiceRowCount = 0;
            int roamVoiceListElement = 0;
            Row roamVoiceRow = roamVoiceSheet.createRow(roamVoiceRowCount);
            Cell roamVoiceCell = roamVoiceRow.createCell(0);
            roamVoiceCell.setCellValue("MSISDN");
            roamVoiceCell = roamVoiceRow.createCell(1);
            roamVoiceCell.setCellValue("ROAM_VOICE_CDR");

            String roamVoiceTemp = "";
            int roamVoiceTemplate = 0;
            for (String roamVoice : roamVoiceList) {
                if (roamVoice.contains("/enip/")){
                    roamVoiceRow = roamVoiceSheet.createRow(++roamVoiceRowCount);
                    roamVoiceCell = roamVoiceRow.createCell(0);
                    if (!(roamVoiceTemp.equalsIgnoreCase(roamVoiceMsisdnList.get(roamVoiceRowCount - 1)))) {
                        roamVoiceTemp = roamVoiceMsisdnList.get(roamVoiceRowCount - 1);
                        roamVoiceCell.setCellValue(roamVoiceTemp);
                    }
                    roamVoiceCell = roamVoiceRow.createCell(1);
                    roamVoiceCell.setCellValue(roamVoice);
                }

            }

            //roamSms sheet aktarımı
            XSSFSheet roamSmsSheet = workbook.createSheet("roam_sms_cdr");
            int roamSmsRowCount = 0;
            int roamSmsListElement = 0;
            Row roamSmsRow = roamSmsSheet.createRow(roamSmsRowCount);
            Cell roamSmsCell = roamSmsRow.createCell(0);
            roamSmsCell.setCellValue("MSISDN");
            roamSmsCell = roamSmsRow.createCell(1);
            roamSmsCell.setCellValue("ROAM_SMS_CDR");

            String roamSmsTemp = "";
            int roamSmsTemplate = 0;
            for (String roamSms : roamSmsList) {
                if (roamSms.contains("/enip/")){
                    roamSmsRow = roamSmsSheet.createRow(++roamSmsRowCount);
                    roamSmsCell = roamSmsRow.createCell(0);
                    if (!(roamSmsTemp.equalsIgnoreCase(roamSmsMsisdnList.get(roamSmsRowCount - 1)))) {
                        roamSmsTemp = roamSmsMsisdnList.get(roamSmsRowCount - 1);
                        roamSmsCell.setCellValue(roamSmsTemp);
                    }
                    roamSmsCell = roamSmsRow.createCell(1);
                    roamSmsCell.setCellValue(roamSms);
                }

            }

            //roamMTVoice sheet aktarımı
            XSSFSheet roamMTVoiceSheet = workbook.createSheet("roam_mt_voice_cdr");
            int roamMTVoiceRowCount = 0;
            int roamMTVoiceListElement = 0;
            Row roamMTVoiceRow = roamMTVoiceSheet.createRow(roamMTVoiceRowCount);
            Cell roamMTVoiceCell = roamMTVoiceRow.createCell(0);
            roamMTVoiceCell.setCellValue("MSISDN");
            roamMTVoiceCell = roamMTVoiceRow.createCell(1);
            roamMTVoiceCell.setCellValue("ROAM_MT_VOICE_CDR");

            String roamMTVoiceTemp = "";
            int roamMTVoiceTemplate = 0;
            for (String roamMTVoice : roamMTVoiceList) {
                if (roamMTVoice.contains("enip/")){
                    roamMTVoiceRow = roamMTVoiceSheet.createRow(++roamMTVoiceRowCount);
                    roamMTVoiceCell = roamMTVoiceRow.createCell(0);
                    if (!(roamMTVoiceTemp.equalsIgnoreCase(roamMTVoiceMsisdnList.get(roamMTVoiceRowCount - 1)))) {
                        roamMTVoiceTemp = roamMTVoiceMsisdnList.get(roamMTVoiceRowCount - 1);
                        roamMTVoiceCell.setCellValue(roamMTVoiceTemp);
                    }
                    roamMTVoiceCell = roamMTVoiceRow.createCell(1);
                    roamMTVoiceCell.setCellValue(roamMTVoice);
                }

            }

            //roamData sheet aktarımı
            XSSFSheet roamDataSheet = workbook.createSheet("roam_data_cdr");
            int roamDataRowCount = 0;
            int roamDataListElement = 0;
            Row roamDataRow = roamDataSheet.createRow(roamDataRowCount);
            Cell roamDataCell = roamDataRow.createCell(0);
            roamDataCell.setCellValue("MSISDN");
            roamDataCell = roamDataRow.createCell(1);
            roamDataCell.setCellValue("ROAM_DATA_CDR");

            String roamDataTemp = "";
            int roamDataTemplate = 0;
            for (String roamData : roamDataList) {
                if (roamData.contains("/enip/")){
                    roamDataRow = roamDataSheet.createRow(++roamDataRowCount);
                    roamDataCell = roamDataRow.createCell(0);
                    if (!(roamDataTemp.equalsIgnoreCase(roamDataMsisdnList.get(roamDataRowCount - 1)))) {
                        roamDataTemp = roamDataMsisdnList.get(roamDataRowCount - 1);
                        roamDataCell.setCellValue(roamDataTemp);
                    }
                    roamDataCell = roamDataRow.createCell(1);
                    roamDataCell.setCellValue(roamData);
                }

            }

            //natRG sheet aktarımı
            XSSFSheet natRGSheet = workbook.createSheet("nat_rg_cdr");
            int natRGRowCount = 0;
            int natRGListElement = 0;
            Row natRGRow = natRGSheet.createRow(natRGRowCount);
            Cell natRGCell = natRGRow.createCell(0);
            natRGCell.setCellValue("MSISDN");
            natRGCell = natRGRow.createCell(1);
            natRGCell.setCellValue("NAT_RG_CDR");

            String natRGTemp = "";
            int natRGTemplate = 0;
            for (String natRG : natRGList) {
                if (natRG.contains("/enip/")){
                    natRGRow = natRGSheet.createRow(++natRGRowCount);
                    natRGCell = natRGRow.createCell(0);
                    if (!(natRGTemp.equalsIgnoreCase(natRGMsisdnList.get(natRGRowCount - 1)))) {
                        natRGTemp = natRGMsisdnList.get(natRGRowCount - 1);
                        natRGCell.setCellValue(natRGTemp);
                    }
                    natRGCell = natRGRow.createCell(1);
                    natRGCell.setCellValue(natRG);
                }

            }

            //natVoiceVodafone sheet aktarımı
            XSSFSheet natVoiceVodafoneSheet = workbook.createSheet("nat_voice_vodafone_cdr");
            int natVoiceVodafoneRowCount = 0;
            int natVoiceVodafoneListElement = 0;
            Row natVoiceVodafoneRow = natVoiceVodafoneSheet.createRow(natVoiceVodafoneRowCount);
            Cell natVoiceVodafoneCell = natVoiceVodafoneRow.createCell(0);
            natVoiceVodafoneCell.setCellValue("MSISDN");
            natVoiceVodafoneCell = natVoiceVodafoneRow.createCell(1);
            natVoiceVodafoneCell.setCellValue("nat_voice_vodafone_CDR");

            String natVoiceVodafoneTemp = "";
            int natVoiceVodafoneTemplate = 0;
            for (String natVoiceVodafone : natVoiceVodafoneList) {
                if (natVoiceVodafone.contains("/enip/")){
                    natVoiceVodafoneRow = natVoiceVodafoneSheet.createRow(++natVoiceVodafoneRowCount);
                    natVoiceVodafoneCell = natVoiceVodafoneRow.createCell(0);
                    if (!(natVoiceVodafoneTemp.equalsIgnoreCase(natVoiceVodafoneMsisdnList.get(natVoiceVodafoneRowCount - 1)))) {
                        natVoiceVodafoneTemp = natVoiceVodafoneMsisdnList.get(natVoiceVodafoneRowCount - 1);
                        natVoiceVodafoneCell.setCellValue(natVoiceVodafoneTemp);
                    }
                    natVoiceVodafoneCell = natVoiceVodafoneRow.createCell(1);
                    natVoiceVodafoneCell.setCellValue(natVoiceVodafone);
                }

            }

            //natVoiceFixedLine sheet aktarımı
            XSSFSheet natVoiceFixedLineSheet = workbook.createSheet("nat_voice_fixed_line_cdr");
            int natVoiceFixedLineRowCount = 0;
            int natVoiceFixedLineListElement = 0;
            Row natVoiceFixedLineRow = natVoiceFixedLineSheet.createRow(natVoiceFixedLineRowCount);
            Cell natVoiceFixedLineCell = natVoiceFixedLineRow.createCell(0);
            natVoiceFixedLineCell.setCellValue("MSISDN");
            natVoiceFixedLineCell = natVoiceFixedLineRow.createCell(1);
            natVoiceFixedLineCell.setCellValue("nat_voice_fixed_line_CDR");

            String natVoiceFixedLineTemp = "";
            int natVoiceFixedLineTemplate = 0;
            for (String natVoiceFixedLine : natVoiceFixedLineList) {
                if (natVoiceFixedLine.contains("/enip/")){
                    natVoiceFixedLineRow = natVoiceFixedLineSheet.createRow(++natVoiceFixedLineRowCount);
                    natVoiceFixedLineCell = natVoiceFixedLineRow.createCell(0);
                    if (!(natVoiceFixedLineTemp.equalsIgnoreCase(natVoiceFixedLineMsisdnList.get(natVoiceFixedLineRowCount - 1)))) {
                        natVoiceFixedLineTemp = natVoiceFixedLineMsisdnList.get(natVoiceFixedLineRowCount - 1);
                        natVoiceFixedLineCell.setCellValue(natVoiceFixedLineTemp);
                    }
                    natVoiceFixedLineCell = natVoiceFixedLineRow.createCell(1);
                    natVoiceFixedLineCell.setCellValue(natVoiceFixedLine);
                }

            }

            //natVoiceBundle sheet aktarımı
            XSSFSheet natVoiceBundleSheet = workbook.createSheet("nat_voice_bundle_cdr");
            int natVoiceBundleRowCount = 0;
            int natVoiceBundleListElement = 0;
            Row natVoiceBundleRow = natVoiceBundleSheet.createRow(natVoiceBundleRowCount);
            Cell natVoiceBundleCell = natVoiceBundleRow.createCell(0);
            natVoiceBundleCell.setCellValue("MSISDN");
            natVoiceBundleCell = natVoiceBundleRow.createCell(1);
            natVoiceBundleCell.setCellValue("National Voice Bundle CDR");

            String natVoiceBundleTemp = "";
            int natVoiceBundleTemplate = 0;
            for (String natVoiceBundle : natVoiceBundleList) {
                if (natVoiceBundle.contains("/enip/")){
                    natVoiceBundleRow = natVoiceBundleSheet.createRow(++natVoiceBundleRowCount);
                    natVoiceBundleCell = natVoiceBundleRow.createCell(0);
                    if (!(natVoiceBundleTemp.equalsIgnoreCase(natVoiceBundleMsisdnList.get(natVoiceBundleRowCount - 1)))) {
                        natVoiceBundleTemp = natVoiceBundleMsisdnList.get(natVoiceBundleRowCount - 1);
                        natVoiceBundleCell.setCellValue(natVoiceBundleTemp);
                    }
                    natVoiceBundleCell = natVoiceBundleRow.createCell(1);
                    natVoiceBundleCell.setCellValue(natVoiceBundle);
                }

            }

            //natDataBundle sheet aktarımı
            XSSFSheet natDataBundleSheet = workbook.createSheet("nat_data_bundle_cdr");
            int natDataBundleRowCount = 0;
            int natDataBundleListElement = 0;
            Row natDataBundleRow = natDataBundleSheet.createRow(natDataBundleRowCount);
            Cell natDataBundleCell = natDataBundleRow.createCell(0);
            natDataBundleCell.setCellValue("MSISDN");
            natDataBundleCell = natDataBundleRow.createCell(1);
            natDataBundleCell.setCellValue("National Data Bundle CDR");

            String natDataBundleTemp = "";
            int natDataBundleTemplate = 0;
            for (String natDataBundle : natDataBundleList) {
                if (natDataBundle.contains("/enip/")){
                    natDataBundleRow = natDataBundleSheet.createRow(++natDataBundleRowCount);
                    natDataBundleCell = natDataBundleRow.createCell(0);
                    if (!(natDataBundleTemp.equalsIgnoreCase(natDataBundleMsisdnList.get(natDataBundleRowCount - 1)))) {
                        natDataBundleTemp = natDataBundleMsisdnList.get(natDataBundleRowCount - 1);
                        natDataBundleCell.setCellValue(natDataBundleTemp);
                    }
                    natDataBundleCell = natDataBundleRow.createCell(1);
                    natDataBundleCell.setCellValue(natDataBundle);
                }

            }

            //natSmsBundle sheet aktarımı
            XSSFSheet natSmsBundleSheet = workbook.createSheet("nat_sms_bundle_cdr");
            int natSmsBundleRowCount = 0;
            int natSmsBundleListElement = 0;
            Row natSmsBundleRow = natSmsBundleSheet.createRow(natSmsBundleRowCount);
            Cell natSmsBundleCell = natSmsBundleRow.createCell(0);
            natSmsBundleCell.setCellValue("MSISDN");
            natSmsBundleCell = natSmsBundleRow.createCell(1);
            natSmsBundleCell.setCellValue("National Sms Bundle CDR");

            String natSmsBundleTemp = "";
            int natSmsBundleTemplate = 0;
            for (String natSmsBundle : natSmsBundleList) {
                if (natSmsBundle.contains("/enip/")){
                    natSmsBundleRow = natSmsBundleSheet.createRow(++natSmsBundleRowCount);
                    natSmsBundleCell = natSmsBundleRow.createCell(0);
                    if (!(natSmsBundleTemp.equalsIgnoreCase(natSmsBundleMsisdnList.get(natSmsBundleRowCount - 1)))) {
                        natSmsBundleTemp = natSmsBundleMsisdnList.get(natSmsBundleRowCount - 1);
                        natSmsBundleCell.setCellValue(natSmsBundleTemp);
                    }
                    natSmsBundleCell = natSmsBundleRow.createCell(1);
                    natSmsBundleCell.setCellValue(natSmsBundle);
                }

            }

            //natRGBundle sheet aktarımı
            XSSFSheet natRGBundleSheet = workbook.createSheet("nat_rg_bundle_cdr");
            int natRGBundleRowCount = 0;
            int natRGBundleListElement = 0;
            Row natRGBundleRow = natRGBundleSheet.createRow(natRGBundleRowCount);
            Cell natRGBundleCell = natRGBundleRow.createCell(0);
            natRGBundleCell.setCellValue("MSISDN");
            natRGBundleCell = natRGBundleRow.createCell(1);
            natRGBundleCell.setCellValue("National Rating Group Bundle CDR");

            String natRGBundleTemp = "";
            int natRGBundleTemplate = 0;
            for (String natRGBundle : natRGBundleList) {
                if (natRGBundle.contains("/enip/")){
                    natRGBundleRow = natRGBundleSheet.createRow(++natRGBundleRowCount);
                    natRGBundleCell = natRGBundleRow.createCell(0);
                    if (!(natRGBundleTemp.equalsIgnoreCase(natRGBundleMsisdnList.get(natRGBundleRowCount - 1)))) {
                        natRGBundleTemp = natRGBundleMsisdnList.get(natRGBundleRowCount - 1);
                        natRGBundleCell.setCellValue(natRGBundleTemp);
                    }
                    natRGBundleCell = natRGBundleRow.createCell(1);
                    natRGBundleCell.setCellValue(natRGBundle);
                }

            }

            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String findTemplateFile(File dir) {
        String TemplateName = "";
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("CCS_Tariff_Usage_Test.xlsx");
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i = 0; i < children.length; i++) {
                TemplateName = children[i];
                break;
            }
        }
        return TemplateName;
    }

    public static void moveTemplateFile(String file) {
        File source = new File(filePath + file);
        File dest = new File(filePath + "Done\\");
        try {
            FileUtils.moveFileToDirectory(source, dest, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sftpsript(String msiSdn) {
        try {
            String user = "cbp";
            String password = "Cbp_0001";

            String host = "10.144.15.141";

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            InputStream out= null;
            out= sftpChannel.get("/enip/enipapp/cbp/ismail/awk/script/filter/filtered_cdr.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(out));
            String line;
            while ((line = br.readLine()) != null)
            {
                omonMsisdnList.add(msiSdn);
                omonList.add(line);
            }
            br.close();
            sftpChannel.disconnect();
            session.disconnect();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}