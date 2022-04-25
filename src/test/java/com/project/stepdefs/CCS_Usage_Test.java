package com.project.stepdefs;

import com.jcraft.jsch.*;
import com.saf.framework.MyTestNGBaseClass;
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
import java.util.Objects;
import java.util.Properties;

public class CCS_Usage_Test {

    public static ArrayList<String> msisdnList = new ArrayList<>();
    public static ArrayList<String> messageList = new ArrayList<>();
    public static ArrayList<String> shcommandList = new ArrayList<>();

    public static ArrayList<String> omonList = new ArrayList<>();
    public static ArrayList<String> omonMsisdnList = new ArrayList<>();

    public static ArrayList<String> omgrList = new ArrayList<>();
    public static ArrayList<String> omgrMsisdnList = new ArrayList<>();

    public static ArrayList<String> odataList = new ArrayList<>();
    public static ArrayList<String> odataMsisdnList = new ArrayList<>();

    public static ArrayList<String> orecList = new ArrayList<>();
    public static ArrayList<String> orecMsisdnList = new ArrayList<>();

    public static ArrayList<String> osmsList = new ArrayList<>();
    public static ArrayList<String> osmsMsisdnList = new ArrayList<>();

    public static ArrayList<String> dataParadoxList = new ArrayList<>();
    public static ArrayList<String> dataParadoxMsisdnList = new ArrayList<>();

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

    public static ArrayList<String> roamDataList = new ArrayList<>();
    public static ArrayList<String> roamDataMsisdnList = new ArrayList<>();

    public static ArrayList<String> natRG1List = new ArrayList<>();
    public static ArrayList<String> natRG1MsisdnList = new ArrayList<>();

    public static ArrayList<String> natRG2List = new ArrayList<>();
    public static ArrayList<String> natRG2MsisdnList = new ArrayList<>();

    public static ArrayList<String> natRG3List = new ArrayList<>();
    public static ArrayList<String> natRG3MsisdnList = new ArrayList<>();

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

    public static ArrayList<String> natVoice100BundleList = new ArrayList<>();
    public static ArrayList<String> natVoice100BundleMsisdnList = new ArrayList<>();

    public static ArrayList<String> natData100BundleList = new ArrayList<>();
    public static ArrayList<String> natData100BundleMsisdnList = new ArrayList<>();

    public static ArrayList<String> natSms100BundleList = new ArrayList<>();
    public static ArrayList<String> natSms100BundleMsisdnList = new ArrayList<>();

    public static ArrayList<String> natVoiceOverusageList = new ArrayList<>();
    public static ArrayList<String> natVoiceOverusageMsisdnList = new ArrayList<>();

    public static ArrayList<String> natSmsOverusageList = new ArrayList<>();
    public static ArrayList<String> natSmsOverusageMsisdnList = new ArrayList<>();

    public static ArrayList<String> dataWalleList = new ArrayList<>();
    public static ArrayList<String> dataWalleMsisdnList = new ArrayList<>();

    static String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";
    static String natVoiceCalledMSISDN = " ";
    static String natDataRg = " ";

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

    static String natRatingGroup1Usage = " ";
    static String natRatingGroup1Rg = " ";

    static String natRatingGroup2Usage = " ";
    static String natRatingGroup2Rg = " ";

    static String natRatingGroup3Usage = " ";
    static String natRatingGroup3Rg = " ";

    static String natVoiceVodafoneCalledMSISDN = " ";
    static String natVoiceVodafoneUsage = " ";
    static String natVoiceFixedLineCalledMSISDN = " ";
    static String natVoiceFixedLineUsage = " ";
    static String wallEDataUsage = " ";

    static long natVoiceBundle = 0;
    static long natDataBundle = 0;
    static long natSmsBundle = 0;
    static long natRatingGroup1Bundle = 0;
    static long natRatingGroup2Bundle = 0;
    static long natRatingGroup3Bundle = 0;

    public static void main(String[] args) {
        File dirPath = new File(filePath);
        String selectedFile=findTemplateFile(dirPath);
        readTemplateExcel(filePath+selectedFile);
        createAndWriteToExcel(selectedFile);
        moveTemplateFile(selectedFile);
    }

    public static void openAndRun(String shType, String host, String user, String password, String msisdn, String offerKey) {
        String shCommand = "";
        switch (shType) {
            case "checkSMS":
                shCommand = "cd /home/gfep/fep/SMSC/; ./check_sms.sh " + msisdn;
                MyTestNGBaseClass.allureReport("","checkSMS sh'ına başlandı.",false);
                break;
            case "nat_voice_80_bundle":
                long natVoiceBundle80 = (long) (natVoiceBundle * 0.85);
                String strNatVoice80Bundle = String.valueOf(natVoiceBundle80);
                shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMSISDN(msisdn) + " " + natVoiceCalledMSISDN + " " + strNatVoice80Bundle;
                MyTestNGBaseClass.allureReport("","National Voice %80 sh'ına başlandı.",false);
                break;
            case "nat_data_80_bundle":
                long natDataBundle80 = (long) (natDataBundle * 0.85);
                String strNatData80Bundle = String.valueOf(natDataBundle80);
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " " + strNatData80Bundle + " " + natDataRg;
                MyTestNGBaseClass.allureReport("","National Data %80 sh'ına başlandı.",false);
                break;
            case "nat_sms_80_bundle":
                long natSmsBundle80 = (long) (natSmsBundle * 0.85);
                String strNatSms80Bundle = String.valueOf(natSmsBundle80);
                shCommand = "cd ismail/awk/script/send_v3/; ./sms.sh " + newMSISDN(msisdn) + " " + strNatSms80Bundle;
                if (smsUsageControl(strNatSms80Bundle,shCommand)) return;
                MyTestNGBaseClass.allureReport("","National Sms %80 sh'ına başlandı.",false);
                break;
            case "nat_voice_100_bundle":
                long natVoiceBundleYuz = (long) (((natVoiceBundle) - ((natVoiceBundle) * 0.85)));
                String strNatVoiceYuzBundle = String.valueOf(natVoiceBundleYuz);
                shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMSISDN(msisdn) + " " + natVoiceCalledMSISDN + " " + strNatVoiceYuzBundle;
                MyTestNGBaseClass.allureReport("","National Voice %100 sh'ına başlandı.",false);
                break;
            case "nat_data_100_bundle":
                long natDataBundle100 = (long) (((natDataBundle) - ((natDataBundle) * 0.85)));
                String strNatData100Bundle = String.valueOf(natDataBundle100);
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " " + strNatData100Bundle + " " + natDataRg;
                MyTestNGBaseClass.allureReport("","National Data %100 sh'ına başlandı.",false);
                break;
            case "nat_sms_100_bundle":
                long natSmsBundle100 = (long) (((natSmsBundle) - ((natSmsBundle) * 0.85)));
                String strNatSms100Bundle = String.valueOf(natSmsBundle100);
                shCommand = "cd ismail/awk/script/send_v3/; ./sms.sh " + newMSISDN(msisdn) + " " + strNatSms100Bundle;
                if (smsUsageControl(strNatSms100Bundle,shCommand)) return;
                MyTestNGBaseClass.allureReport("","National Sms %100 sh'ına başlandı.",false);
                break;
            case "nat_voice_overusage":
                shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMSISDN(msisdn) + " " + natVoiceCalledMSISDN + " 60";
                MyTestNGBaseClass.allureReport("","National Voice overusage sh'ına başlandı.",false);
                break;
            case "nat_sms_overusage":
                shCommand = "cd ismail/awk/script/send_v3/; ./sms.sh " + newMSISDN(msisdn) + " 1";
                MyTestNGBaseClass.allureReport("","National Sms overusage sh'ına başlandı.",false);
                break;
            case "nat_data_paradox":
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " 524288" + " " + natDataRg;
                MyTestNGBaseClass.allureReport("","National Data Paradox sh'ına başlandı.",false);
                break;
            case "nat_rg1":
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " " + natRatingGroup1Usage + " " + natRatingGroup1Rg;
                MyTestNGBaseClass.allureReport("","National Rating Group 1 sh'ına başlandı.",false);
                break;
            case "nat_rg2":
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " " + natRatingGroup2Usage + " " + natRatingGroup2Rg;
                MyTestNGBaseClass.allureReport("","National Rating Group 2 sh'ına başlandı.",false);
                break;
            case "nat_rg3":
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " " + natRatingGroup3Usage + " " + natRatingGroup3Rg;
                MyTestNGBaseClass.allureReport("","National Rating Group 3 sh'ına başlandı.",false);
                break;
            case "nat_voice_vodafone":
                shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMSISDN(msisdn) + " " + natVoiceVodafoneCalledMSISDN + " " + natVoiceVodafoneUsage;
                MyTestNGBaseClass.allureReport("","National Voice Vodafone içi sh'ına başlandı.",false);
                break;
            case "nat_voice_fixed_line":
                shCommand = "cd ismail/awk/script/send_v3/; ./calling.sh " + newMSISDN(msisdn) + " " + natVoiceFixedLineCalledMSISDN + " " + natVoiceFixedLineUsage;
                MyTestNGBaseClass.allureReport("","National Voice Sabit Hatlar sh'ına başlandı.",false);
                break;
            case "int_voice_data":
                shCommand = "cd ismail/awk/script/send_v3/; ./internationalcall.sh " + msisdn + " " + intVoiceCalledMSISDN + " " + intVoiceUsage;
                MyTestNGBaseClass.allureReport("","International Voice sh'ına başlandı.",false);
                break;
            case "int_sms":
                shCommand = "cd ismail/awk/script/send_v3/; ./international_sms.sh " + newMSISDN(msisdn) + " " + intSmsCalledMSISDN + " " + intSmsUsage;
                if (smsUsageControl(intSmsUsage,shCommand)) return;
                MyTestNGBaseClass.allureReport("","International Sms sh'ına başlandı.",false);
                break;
            case "int_mms":
                shCommand = "cd ismail/awk/script/send_v3/; ./international_mms.sh " + newMSISDN(msisdn) + " " + intMmsCalledMSISDN + " " + intMmsUsage;
                if (smsUsageControl(intMmsUsage,shCommand)) return;
                MyTestNGBaseClass.allureReport("","International Mms sh'ına başlandı.",false);
                break;
            case "roam_voice":
                shCommand = "cd ismail/awk/script/roaming/; ./call_hdpass.sh " + newMSISDN(msisdn) + " " + roamVoiceCalledMSISDN + " " + roamVoiceUsage + " " + roamVoiceOperator;
                MyTestNGBaseClass.allureReport("","Roaming Voice sh'ına başlandı.",false);
                break;
            case "roam_sms":
                shCommand = "cd ismail/awk/script/roaming/; ./sms_hdpass.sh " + roamSmsOperator + " 90 " + msisdn + " " + roamSmsCalledMSISDN + " " + roamSmsUsage;
                if (smsUsageControl(roamSmsUsage,shCommand)) return;
                MyTestNGBaseClass.allureReport("","Roaming Sms sh'ına başlandı.",false);
                break;
            case "roam_data":
                shCommand = "cd ismail/awk/script/roaming/; ./gprs_roaming_rtg.sh " + newMSISDN(msisdn) + " " + roamDataUsage + " " + roamDataOperator + " " + natDataRg;
                MyTestNGBaseClass.allureReport("","Roaming Data sh'ına başlandı.",false);
                break;
            case "nat_data_walle":
                shCommand = "cd ismail/awk/script/send_v3/; ./gprs_byte.sh " + newMSISDN(msisdn) + " " + wallEDataUsage + " " + natDataRg;
                MyTestNGBaseClass.allureReport("","National WallE sh'ına başlandı.",false);
                break;
            case "omon":
            case "omgr":
            case "odata":
            case "orec":
            case "osms":
                shCommand = "cd ismail/awk/script/filter/; ./filtered.sh " + newMSISDN(msisdn) + " " + offerKey + " " + shType;
                MyTestNGBaseClass.allureReport("",shType + " sh'ına başlandı.",false);
                break;
        }
        System.out.println(shCommand);
        shcommandList.add(shCommand);
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

            try {
                switch (shType) {
                    case "checkSMS": addArrayList(bufferedReader,msisdnList,messageList,msisdn);
                    case "nat_voice_80_bundle": addArrayList(bufferedReader,natVoiceBundleMsisdnList,natVoiceBundleList,msisdn);
                    case "nat_data_80_bundle":addArrayList(bufferedReader,natDataBundleMsisdnList,natDataBundleList,msisdn);
                    case "nat_sms_80_bundle":addArrayList(bufferedReader,natSmsBundleMsisdnList,natSmsBundleList,msisdn);
                    case "nat_voice_100_bundle": addArrayList(bufferedReader,natVoice100BundleMsisdnList,natVoice100BundleList,msisdn);
                    case "nat_data_100_bundle":addArrayList(bufferedReader,natData100BundleMsisdnList,natData100BundleList,msisdn);
                    case "nat_sms_100_bundle":addArrayList(bufferedReader,natSms100BundleMsisdnList,natSms100BundleList,msisdn);
                    case "nat_rg1": addArrayList(bufferedReader,natRG1MsisdnList,natRG1List,msisdn);
                    case "nat_rg2":addArrayList(bufferedReader,natRG2MsisdnList,natRG2List,msisdn);
                    case "nat_rg3": addArrayList(bufferedReader,natRG3MsisdnList,natRG3List,msisdn);
                    case "nat_voice_vodafone": addArrayList(bufferedReader,natVoiceVodafoneMsisdnList,natVoiceVodafoneList,msisdn);
                    case "nat_voice_fixed_line": addArrayList(bufferedReader,natVoiceFixedLineMsisdnList,natVoiceFixedLineList,msisdn);
                    case "nat_voice_overusage":addArrayList(bufferedReader,natVoiceOverusageMsisdnList,natVoiceOverusageList,msisdn);
                    case "nat_sms_overusage":addArrayList(bufferedReader,natSmsOverusageMsisdnList,natSmsOverusageList,msisdn);
                    case "nat_data_paradox": addArrayList(bufferedReader,dataParadoxMsisdnList,dataParadoxList,msisdn);
                    case "nat_data_walle": addArrayList(bufferedReader,dataWalleMsisdnList,dataWalleList,msisdn);
                    case "int_voice_data": addArrayList(bufferedReader,intVoiceDataMsisdnList,intVoiceDataList,msisdn);
                    case "int_sms": addArrayList(bufferedReader,intSmsMsisdnList,intSmsList,msisdn);
                    case "int_mms": addArrayList(bufferedReader,intMmsMsisdnList,intMmsList,msisdn);
                    case "roam_voice": addArrayList(bufferedReader,roamVoiceMsisdnList,roamVoiceList,msisdn);
                    case "roam_sms": addArrayList(bufferedReader,roamSmsMsisdnList,roamSmsList,msisdn);
                    case "roam_data": addArrayList(bufferedReader,roamDataMsisdnList,roamDataList,msisdn);
                }
                bufferedReader.close();
                inputReader.close();

                switch (shType) {
                    case "omon":
                        Thread.sleep(3 * 60 * 1000);
                        sftpsript(host, user, password, newMSISDN(msisdn), "omon");
                        break;
                    case "omgr":
                        Thread.sleep(3 * 60 * 1000);
                        sftpsript(host, user, password, newMSISDN(msisdn), "omgr");
                        break;
                    case "odata":
                        Thread.sleep(3 * 60 * 1000);
                        sftpsript(host, user, password, newMSISDN(msisdn), "odata");
                        break;
                    case "orec":
                        Thread.sleep(3 * 60 * 1000);
                        sftpsript(host, user, password, newMSISDN(msisdn), "orec");
                        break;
                    case "osms":
                        Thread.sleep(3 * 60 * 1000);
                        sftpsript(host, user, password, newMSISDN(msisdn), "osms");
                        break;
                }
                channel.disconnect();
                session.disconnect();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                MyTestNGBaseClass.allureReport("FAIL","Listelere eklenirken sorun yaşandı.",true);
            }
        } catch (JSchException | IOException ex) {
            ex.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL","Sh bağlantısı sağlanırken sorun yaşandı.",true);
        }
    }

    public static void readTemplateExcel(String path) {
        MyTestNGBaseClass.allureReport("","Excelden testler için gerekli değerler okunmaya başlandı.",false);
        boolean firstRow = true;
        String tmpOfferKey = null; //variable for storing the cell 3 value
        Workbook wbook = null; //initialize Workbook null
        String tmpMSISDN = null; //variable for storing the cell 0 value
        String host_cbp = "10.144.15.141";
        String user_cbp = "cbp";
        String password_cbp = "Cbp_0001";
        String host_gfep = "10.144.11.99";
        String user_gfep = "gfep";
        String password_gfep = "Huawei123";

        natVoiceCalledMSISDN = " ";
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(path);
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL","Excel açılamadı.",true);
        }
        System.out.println("readTemplateExcel started");
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index

        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            if (firstRow) {
                itr.next();
                firstRow = false;
            }
            Row rowitr = itr.next();
            Iterator<Cell> cellitr = rowitr.cellIterator();
            while(cellitr.hasNext()) {
                Cell celldata = cellitr.next();
                switch(celldata.getColumnIndex()) {
                    case 0             : //MSISDN
                        try
                        {
                            tmpMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            tmpMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
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
                    case 4            : //National Voice Bundle

                        natVoiceBundle=(long)celldata.getNumericCellValue()
                        ;
                        break;
                    case 5            : //National Data Bundle

                        natDataBundle=(long)(celldata.getNumericCellValue());

                        break;
                    case 6            : //National Sms Bundle

                        natSmsBundle=(long)celldata.getNumericCellValue();

                        break;
                    case 7            : //National Rating Group 1 Bundle

                        natRatingGroup1Bundle=(long)celldata.getNumericCellValue();

                        break;
                    case 8            : //National Rating Group 2 Bundle

                        natRatingGroup2Bundle=(long)celldata.getNumericCellValue();

                        break;

                    case 9            : //National Rating Group 3 Bundle

                        natRatingGroup3Bundle=(long)celldata.getNumericCellValue();

                        break;

                    case 10             : //National Voice Called MSISDN
                        try
                        {

                            natVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {

                            natVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 11             : //National Data Rg
                        try
                        {
                            natDataRg=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natDataRg=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 12            : //National Data Rating Group 1 Usage
                        try
                        {
                            natRatingGroup1Usage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroup1Usage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 13            : //National Data Rating Group 1 Rg
                        try
                        {
                            natRatingGroup1Rg=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroup1Rg=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 14            : //National Data Rating Group 2 Usage
                        try
                        {
                            natRatingGroup2Usage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroup2Usage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 15            : //National Data Rating Group 2 Rg
                        try
                        {
                            natRatingGroup2Rg=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroup2Rg=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 16            : //National Data Rating Group 3 Usage
                        try
                        {
                            natRatingGroup3Usage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroup3Usage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 17            : //National Data Rating Group 3 Rg
                        try
                        {
                            natRatingGroup3Rg=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natRatingGroup3Rg=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;


                    case 18            : //National Voice Vodafone Called MSISDN
                        try
                        {
                            natVoiceVodafoneCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceVodafoneCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 19            : //National Voice Vodafone Usage
                        try
                        {
                            natVoiceVodafoneUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceVodafoneUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 20            : //National Voice Fixed Lines Called MSISDN
                        try
                        {
                            natVoiceFixedLineCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceFixedLineCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 21            : //National Voice Fixed Lines Usage
                        try
                        {
                            natVoiceFixedLineUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            natVoiceFixedLineUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 22             : //International Voice Called MSISDN
                        try
                        {
                            intVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 23             : //International Voice Usage
                        try
                        {
                            intVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 24             : //International Sms Called MSISDN
                        try
                        {
                            intSmsCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intSmsCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 25             : //International Sms Usage
                        try
                        {
                            intSmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intSmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 26             : //International Mms Called MSISDN
                        try
                        {
                            intMmsCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intMmsCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 27            : //International Mms Usage
                        try
                        {
                            intMmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            intMmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 28            : //Roaming Voice Called MSISDN
                        try
                        {
                            roamVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 29            : //Roaming Voice Usage
                        try
                        {
                            roamVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 30            : //Roaming Voice Operator
                        try
                        {
                            roamVoiceOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamVoiceOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 31            : //Roaming Sms Operator
                        try
                        {
                            roamSmsOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamSmsOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 32            : //Roaming Sms Called MSISDN
                        try
                        {
                            roamSmsCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamSmsCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 33            : //Roaming Sms Usage
                        try
                        {
                            roamSmsUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamSmsUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 34            : //Roaming MT Voice Called MSISDN
                        try
                        {
                            roamMTVoiceCalledMSISDN=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamMTVoiceCalledMSISDN=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 35            : //Roaming MT Voice Usage
                        try
                        {
                            roamMTVoiceUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamMTVoiceUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 36            : //Roaming MT Voice Operator
                        try
                        {
                            roamMTVoiceOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamMTVoiceOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 37            : //Roaming Data Usage
                        try
                        {
                            roamDataUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamDataUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 38            : //Roaming Data Operator
                        try
                        {
                            roamDataOperator=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            roamDataOperator=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;

                    case 39            : //Wall-E Data Usage

                        try
                        {
                            wallEDataUsage=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            wallEDataUsage=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                }
            }
            String MSISDN=tmpMSISDN;
            String OfferKey=tmpOfferKey;
            if ((MSISDN == null) || MSISDN.equals(""))
            {
                break;
            }

            openAndRun("nat_voice_80_bundle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_data_80_bundle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_sms_80_bundle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_voice_100_bundle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_data_100_bundle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_sms_100_bundle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_voice_overusage", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_sms_overusage", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_data_paradox", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_rg1", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_rg2", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_rg3", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_voice_vodafone", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_voice_fixed_line", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("int_voice_data", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("int_sms", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("int_mms", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("roam_voice", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("roam_sms", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("roam_data", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("nat_data_walle", host_cbp, user_cbp, password_cbp, MSISDN,"0");
            openAndRun("omon", host_cbp, user_cbp, password_cbp, MSISDN,OfferKey);
            openAndRun("omgr", host_cbp, user_cbp, password_cbp, MSISDN,OfferKey);
            openAndRun("odata",host_cbp, user_cbp, password_cbp, MSISDN,OfferKey);
            openAndRun("orec", host_cbp, user_cbp, password_cbp, MSISDN,OfferKey);
            openAndRun("osms", host_cbp, user_cbp, password_cbp, MSISDN,OfferKey);
            openAndRun("checkSMS", host_gfep, user_gfep, password_gfep, MSISDN,"0");
        }

    }

    public static void createAndWriteToExcel(String newFileName) {
        try {
            newFileName = newFileName.replace("Test", "Testbook");
            String fileName = filePath + "TestBook\\" + newFileName;
            XSSFWorkbook workbook = new XSSFWorkbook();

            System.out.println("createAndWriteToExcel started");

            writetoExcelSheet(workbook,"shCommands","sh Commands"," ", " ", shcommandList, shcommandList);
            writetoExcelSheet(workbook,"Check_Sms","MSISDN","Message", " ", msisdnList,messageList);
            writetoExcelSheet(workbook,"omon_cdr","MSISDN","omon_cdr", "|",omonMsisdnList,omonList);
            writetoExcelSheet(workbook,"nat_voice_80_bundle_cdr","MSISDN","National Voice 80 Bundle CDR", "|",natVoiceBundleMsisdnList,natVoiceBundleList);
            writetoExcelSheet(workbook,"nat_data_80_bundle_cdr","MSISDN","National Data 80 Bundle CDR", "|",natDataBundleMsisdnList,natDataBundleList);
            writetoExcelSheet(workbook,"nat_sms_80_bundle_cdr","MSISDN","National Sms 80 Bundle CDR", "|",natSmsBundleMsisdnList,natSmsBundleList);
            writetoExcelSheet(workbook,"nat_voice_100_bundle_cdr","MSISDN","National Voice 100 Bundle CDR", "|",natVoice100BundleMsisdnList,natVoice100BundleList);
            writetoExcelSheet(workbook,"nat_data_100_bundle_cdr","MSISDN","National Data 100 Bundle CDR", "|",natData100BundleMsisdnList,natData100BundleList);
            writetoExcelSheet(workbook,"nat_sms_100_bundle_cdr","MSISDN","National Sms 100 Bundle CDR", "|",natSms100BundleMsisdnList,natSms100BundleList);
            writetoExcelSheet(workbook,"nat_voice_overusage_cdr","MSISDN","nat_voice_overusage_cdr", "|",natVoiceOverusageMsisdnList,natVoiceOverusageList);
            writetoExcelSheet(workbook,"nat_sms_overusage_cdr","MSISDN","nat_sms_overusage_cdr", "|",natSmsOverusageMsisdnList,natSmsOverusageList);
            writetoExcelSheet(workbook,"nat_data_paradox_cdr","MSISDN","nat_data_paradox_cdr", "|",dataParadoxMsisdnList,dataParadoxList);
            writetoExcelSheet(workbook,"nat_rg1_cdr","MSISDN","NAT_RG1_CDR", "|",natRG1MsisdnList,natRG1List);
            writetoExcelSheet(workbook,"nat_rg2_cdr","MSISDN","NAT_RG2_CDR", "|",natRG2MsisdnList,natRG2List);
            writetoExcelSheet(workbook,"nat_rg3_cdr","MSISDN","NAT_RG3_CDR", "|",natRG3MsisdnList,natRG3List);
            writetoExcelSheet(workbook,"nat_voice_vodafone_cdr","MSISDN","nat_voice_vodafone_CDR", "|",natVoiceVodafoneMsisdnList,natVoiceVodafoneList);
            writetoExcelSheet(workbook,"nat_voice_fixed_line_cdr","MSISDN","nat_voice_fixed_line_CDR", "|",natVoiceFixedLineMsisdnList,natVoiceFixedLineList);
            writetoExcelSheet(workbook,"int_voice_cdr","MSISDN","INT_VOICE_DATA_CDR", "|",intVoiceDataMsisdnList,intVoiceDataList);
            writetoExcelSheet(workbook,"int_sms_cdr","MSISDN","INT_SMS_CDR", "|",intSmsMsisdnList,intSmsList);
            writetoExcelSheet(workbook,"int_mms_cdr","MSISDN","INT_MMS_CDR", "|",intMmsMsisdnList,intMmsList);
            writetoExcelSheet(workbook,"roam_voice_cdr","MSISDN","ROAM_VOICE_CDR", "|",roamVoiceMsisdnList,roamVoiceList);
            writetoExcelSheet(workbook,"roam_sms_cdr","MSISDN","ROAM_SMS_CDR", "|",roamSmsMsisdnList,roamSmsList);
            writetoExcelSheet(workbook,"roam_data_cdr","MSISDN","ROAM_SMS_CDR", "|",roamSmsMsisdnList,roamSmsList);
            writetoExcelSheet(workbook,"walle_cdr","MSISDN","walle_cdr", "|",dataWalleMsisdnList,dataWalleList);
            writetoExcelSheet(workbook,"omgr_cdr","MSISDN","omgr_cdr", "|",omgrMsisdnList,omgrList);
            writetoExcelSheet(workbook,"odata_cdr","MSISDN","odata_cdr", "|",odataMsisdnList,odataList);
            writetoExcelSheet(workbook,"orec_cdr","MSISDN","orec_cdr", "|",orecMsisdnList,orecList);
            writetoExcelSheet(workbook,"osms_cdr","MSISDN","osms_cdr", "|",osmsMsisdnList,osmsList);

            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            MyTestNGBaseClass.allureReport("FAIL","Sonuçların excele yazıldığı esnada bir problem yaşandı.",true);
        }
    }

    public static String findTemplateFile(File dir) {
        MyTestNGBaseClass.allureReport("","Template dosyası açılıyor.",false);
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
        MyTestNGBaseClass.allureReport("","Template dosyası Done klasörüne taşınıyor.",false);
        File source = new File(filePath + file);
        File dest = new File(filePath + "Done\\");
        try {
            FileUtils.moveFileToDirectory(source, dest, false);
        } catch (IOException e) {
            e.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL","Template dosyası Done klasörüne taşınamadı.",true);
        }
    }

    public static String newMSISDN(String msisdn) {
        String tmp;
        if (msisdn.length() == 12) {
            tmp = msisdn.substring(2);
        } else if (msisdn.length() == 11) {
            tmp = msisdn.substring(1);
        } else {
            tmp = msisdn;
        }
        return tmp;
    }

    public static boolean smsUsageControl(String usage, String shCommand) {
        long longUsage = Long.parseLong(usage);
        if (longUsage > 1000) {
            System.out.println("Warning!!! sms usage > 1000: " + shCommand);
            return true;
        } else return false;
    }

    public static void writetoExcelSheet(XSSFWorkbook tmpworkbook, String cdrtype, String cellHeader1, String cellHeader2, String filterText,
                                         ArrayList<String> tmpArrayMSISDNList, ArrayList<String> tmpArrayList) {
        MyTestNGBaseClass.allureReport("",cdrtype + " excele yazılıyor.",false);
        XSSFSheet tmpSheet =  tmpworkbook.createSheet(cdrtype);
        int RowCount = 0;
        Row tmpSheetRow= tmpSheet.createRow(RowCount);
        Cell tmpSheetRowCell = tmpSheetRow.createCell(0);
        tmpSheetRowCell.setCellValue(cellHeader1);

        if (!Objects.equals(cellHeader2, " ")) {
            tmpSheetRowCell = tmpSheetRow.createCell(1);
            tmpSheetRowCell.setCellValue(cellHeader2);
        }

        String lineTemp = "";
        for (String line : tmpArrayList) {
            if (line.contains(filterText)) {
                tmpSheetRow = tmpSheet.createRow(++RowCount);
                tmpSheetRowCell = tmpSheetRow.createCell(0);
                if (!Objects.equals(cellHeader2, " ")) {
                    if (!(lineTemp.equalsIgnoreCase(tmpArrayMSISDNList.get(RowCount - 1)))) {
                        lineTemp = tmpArrayMSISDNList.get(RowCount - 1);
                        tmpSheetRowCell.setCellValue(lineTemp);
                    }
                    tmpSheetRowCell = tmpSheetRow.createCell(1);
                }
                tmpSheetRowCell.setCellValue(line.replaceAll("\u001B\\[[;\\d]*m\u001B\\[K", "*"));
            }
        }
    }

    public static void addArrayList(BufferedReader tmpbufferedReader, ArrayList<String> tmpArrayMSISDNList,ArrayList<String> tmpArrayList, String tmpMSISDN) throws IOException {
        String line = "";
        while ((line = tmpbufferedReader.readLine()) != null) {
            tmpArrayMSISDNList.add(tmpMSISDN);
            tmpArrayList.add(line);
            System.out.println(line);
        }
    }

    public static void sftpsript(String host, String user, String password, String msiSdn, String shtype) {
        MyTestNGBaseClass.allureReport("",shtype + " cdr sorgulanıyor.",false);
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            InputStream out= sftpChannel.get("/enip/enipapp/cbp/ismail/awk/script/filter/filtered_cdr.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(out));
            String line;
            while ((line = br.readLine()) != null)
            {
                switch (shtype) {
                    case "omon":
                        omonMsisdnList.add(msiSdn);
                        omonList.add(line);
                        break;
                    case "omgr":
                        omgrMsisdnList.add(msiSdn);
                        omgrList.add(line);
                        break;
                    case "odata":
                        odataMsisdnList.add(msiSdn);
                        odataList.add(line);
                        break;
                    case "orec":
                        orecMsisdnList.add(msiSdn);
                        orecList.add(line);
                        break;
                    case "osms":
                        osmsMsisdnList.add(msiSdn);
                        osmsList.add(line);
                        break;
                }
            }
            br.close();
            sftpChannel.disconnect();
            session.disconnect();


        } catch (Exception ex) {
            ex.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL",shtype + " sorgusu esnasında problem yaşandı.",true);
        }
    }

}
