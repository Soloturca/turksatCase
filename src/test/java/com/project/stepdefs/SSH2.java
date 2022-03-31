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
    static String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";

    public static void main(String[]args) throws IOException {
        File dirPath = new File(filePath);
        String selectedFile=findTemplateFile(dirPath);
        readCheckSms(filePath+selectedFile);
        createAndWriteToExcel(selectedFile);
        moveTemplateFile(selectedFile);
    }

    public static void openAndRun(String shType,String host, String user, String password,String msisdn, String offerKey){
        String shCommand;
        String newMsiSdn = null;
        if (shType == "checkSMS"){
            shCommand = "cd /home/gfep/fep/SMSC/; ./check_sms.sh " + msisdn;
        }
        else{
            if(msisdn.length()==12){
                newMsiSdn = msisdn.substring(2);
            }
            else if(msisdn.length()==11){
                newMsiSdn = msisdn.substring(1);
            }
            else{
                newMsiSdn = msisdn;
            }
            System.out.println(newMsiSdn);
            shCommand = "cd ismail/awk/script/filter/; ./filtered.sh " + newMsiSdn + " " + offerKey + " " + shType;
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
            ((ChannelExec)channel).setCommand(shCommand);

            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();
            channel.connect();
            try{
                if(shType.equals("checkSMS")){
                    InputStreamReader inputReader = new InputStreamReader(input);
                    BufferedReader bufferedReader = new BufferedReader(inputReader);
                    String line = null;

                    while((line = bufferedReader.readLine()) != null){
                        msisdnList.add(msisdn);
                        messageList.add(line);
                        SMS += line + "\n";
                    }
                    bufferedReader.close();
                    inputReader.close();
                }

                else if(shType.equals("omon")){
                    String omonCDRPath = "sshpass -p \"Cbp_0001\" scp" + " -r " + "cbp" + "@" +
                            "10.144.15.141" + ":" + "/enip/enipapp/cbp/ismail/awk/script/filter/filtered_cdr.txt " + "\"" + filePath + "TestBook\\omonCDR" + newMsiSdn + ".txt" + "\"";
                    omonCDRPath ="dir";
                    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", omonCDRPath);
                    builder.redirectErrorStream(true);
                    Process p = builder.start();
                    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line;
                    while ((line = r.readLine()) != null) {
                        line = r.readLine();
                        if (line == null) {break;}
                        System.out.println("line is " + line );
                        omonMsisdnList.add(newMsiSdn);
                        omonList.add(line);
                    }
                    r.close();
                }
                System.out.println("sessionlar bitti");
                channel.disconnect();
                session.disconnect();
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println(ex);
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
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(path);
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e1) {
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
                    case 0	: //MSISDN
                        tmpMsiSdn=celldata.getStringCellValue().trim();
                        break;
                    case 3	: //OfferKey
                        try
                        {
                            tmpOfferKey=celldata.getStringCellValue().trim();
                        }
                        catch (Exception e1)
                        {
                            tmpOfferKey=String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                }
                if (tmpMsiSdn == null || tmpMsiSdn == "")
                {
                    break;
                }
            }
            openAndRun("checkSMS", "10.144.11.99", "gfep", "Huawei123", tmpMsiSdn,"0");
            openAndRun("omon", "10.144.15.141", "cbp", "Cbp_0001", tmpMsiSdn,tmpOfferKey);
        }
    }

    public static void createAndWriteToExcel(String newFileName) throws IOException {
        try {
            newFileName=newFileName.replace("Test", "Testbook");
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

            String temp="";
            int template = 0;
            for (String message : messageList) {
                row = sheet.createRow(++rowCount);
                cell = row.createCell(0);
                if(!(temp.equalsIgnoreCase(msisdnList.get(rowCount-1)))){
                    temp=msisdnList.get(rowCount-1);
                    cell.setCellValue(msisdnList.get(rowCount-1));
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

            String omonTemp="";
            int omonTemplate = 0;
            for (String omon : omonList) {
                omonRow = omonSheet.createRow(++omonRowCount);
                omonCell = omonRow.createCell(0);
                if(!(omonTemp.equalsIgnoreCase(omonMsisdnList.get(omonRowCount-1)))){
                    omonTemp=omonMsisdnList.get(omonRowCount-1);
                    omonCell.setCellValue(omonMsisdnList.get(omonRowCount-1));
                }

                omonCell = omonRow.createCell(1);
                omonCell.setCellValue(omon);
            }
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String findTemplateFile(File dir) {
        String TemplateName="";
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.contains("CCS_Tariff_Usage_Test.xlsx");
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i = 0; i< children.length; i++) {
                TemplateName = children[i];
                break;
            }
        }
        return TemplateName;
    }

    public static void moveTemplateFile(String file){
        File source = new File(filePath + file);
        File dest = new File(filePath + "Done\\");
        try {
            FileUtils.moveFileToDirectory(source, dest, false );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}