package com.project;

import com.saf.framework.MyTestNGBaseClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DonationAutomation {

    public static ArrayList<String> displayValue = new ArrayList<>();
    public static ArrayList<String> chargeAggrKey = new ArrayList<>();
    public static ArrayList<String> jnlLineId = new ArrayList<>();
    public static ArrayList<String> serviceId = new ArrayList<>();
    public static ArrayList<String> point = new ArrayList<>();
    public static ArrayList<String> pointId = new ArrayList<>();
    public static ArrayList<String> jurisdiction = new ArrayList<>();
    public static ArrayList<String> seqNum = new ArrayList<>();
    public static ArrayList<String> contentId = new ArrayList<>();
    public static List<Product> productList = new ArrayList<Product>();
    public static ArrayList<String> bagisArrayList = new ArrayList<>();


    public static File excelPath = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\");
    public static String excelFileName = " ";
    public static File folderpath = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\CBU_BAGIS_Kampanyasi_Kenan\\");
    public static void main(String[] args) throws Exception {
        excelFileName = findExcel(excelPath);
        infoGathering();
        excelList();
        createExcel(excelFileName);
        attendVariablesFromExcel("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Conf\\BAGIS-001_CBU_Donation_Kenan_Template.xlsx");
        findTemplateFile(folderpath);
    }

    public static void readExcel(String path) {
        MyTestNGBaseClass.allureReport("", "Excelden testler için gerekli değerler okunmaya başlandı.", false);
        boolean firstRow = true;
        String tmpProductName = null; //variable for storing the cell 0 value
        String tmpFiyat = null; //variable for storing the cell 1 value
        String tmpShortNumber = null; //variable for storing the cell 2 value
        String tmpSID = null; //variable for storing the cell 3 value
        String tmpCID = null; //variable for storing the cell 4 value
        String tmpCompanyId = null; //variable for storing the cell 5 value
        String tmpInvoiceDesc = null; //variable for storing the cell 6 value

        Workbook wbook = null; //initialize Workbook null

        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(path);
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL", "Excel açılamadı.", true);
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
            while (cellitr.hasNext()) {
                Cell celldata = cellitr.next();
                switch (celldata.getColumnIndex()) {
                    case 0: //Product Name
                        try {
                            tmpProductName = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpProductName = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        StringBuilder s = new StringBuilder(tmpProductName.length());
                        CharacterIterator it = new StringCharacterIterator(tmpProductName);
                        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
                            switch (ch) {
                                case 'Ç':
                                    s.append("C");
                                    break;
                                case 'ç':
                                    s.append("c");
                                    break;
                                case 'Ğ':
                                    s.append("G");
                                    break;
                                case 'ğ':
                                    s.append("g");
                                    break;
                                case 'İ':
                                    s.append("I");
                                    break;
                                case 'ı':
                                    s.append("i");
                                    break;
                                case 'Ş':
                                    s.append("S");
                                    break;
                                case 'ş':
                                    s.append("s");
                                    break;
                                case 'Ö':
                                    s.append("O");
                                    break;
                                case 'ö':
                                    s.append("o");
                                    break;
                                case 'Ü':
                                    s.append("U");
                                    break;
                                case 'ü':
                                    s.append("u");
                                    break;
                                default:
                                    s.append(ch);
                                    break;
                            }
                        }
                        tmpProductName = s.toString();
                        tmpProductName = tmpProductName.replaceAll("[0-9]","");
                        displayValue.add(tmpProductName);
                        break;
                    case 1: //Fiyat
                        try {
                            tmpFiyat = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpFiyat = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 2: //Short Number
                        try {
                            tmpShortNumber = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpShortNumber = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        point.add(tmpShortNumber);
                        break;
                    case 3: //SID
                        try {
                            tmpSID = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpSID = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        serviceId.add(tmpSID);
                        break;
                    case 4: //CID
                        try {
                            tmpCID = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpCID = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        contentId.add(tmpCID);
                        break;
                    case 5: //Company ID
                        try {
                            tmpCompanyId = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpCompanyId = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                    case 6: //Invoice Desc
                        try {
                            tmpInvoiceDesc = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpInvoiceDesc = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        break;
                }
            }

        }
        System.out.println("displayValue= " + displayValue);
        System.out.println("point= " + point);
        System.out.println("serviceId= " + serviceId);
        System.out.println("contentId= " + contentId);
    }

    public static void createExcel(String newFileName) throws IOException {
        String excelName = newFileName.replace(".xlsx", "");
        MyTestNGBaseClass.allureReport("", excelName + "_Template excel dosyası oluşturuluyor.", false);
        try {

            String templateName = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Conf\\" + excelName + "_Template.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Bagis_Kenan");
            //Needed element for the excel
            int rowCount = 0;
            int listElement = 0;
            String temp = "";

            Row row = sheet.createRow(rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue("DISPLAY_VALUE");
            cell = row.createCell(1);
            cell.setCellValue("CHARGE_AGGR_KEY");
            cell = row.createCell(2);
            cell.setCellValue("JNL_LINE_ID");
            cell = row.createCell(3);
            cell.setCellValue("SERVICE_ID");
            cell = row.createCell(4);
            cell.setCellValue("POINT");
            cell = row.createCell(5);
            cell.setCellValue("POINT_ID");
            cell = row.createCell(6);
            cell.setCellValue("JURISDICTION");
            cell = row.createCell(7);
            cell.setCellValue("SEQNUM");
            cell = row.createCell(8);
            cell.setCellValue("CONTENT_ID");
            Product p;

            for (int x = 0; x<displayValue.size(); x++) {
                row = sheet.createRow(++rowCount);
                int i = 0;
                p=productList.get(x);
                cell = row.createCell(i);
                cell.setCellValue(p.getDisplay_value());
                cell = row.createCell(++i);
                cell.setCellValue(p.getCharge_aggr_key());
                cell = row.createCell(++i);
                cell.setCellValue("IT-BASGS" + p.getJnl_line_id());
                cell = row.createCell(++i);
                cell.setCellValue(p.getService_id());
                cell = row.createCell(++i);
                cell.setCellValue(p.getPoint());
                cell = row.createCell(++i);
                cell.setCellValue(p.getPoint_id());
                cell = row.createCell(++i);
                cell.setCellValue(p.getJurisdiction());
                cell = row.createCell(++i);
                cell.setCellValue(p.getSeqnum());
                cell = row.createCell(++i);
                cell.setCellValue(p.getContent_id());
            }
            rowCount = 0;
            FileOutputStream outputStream = new FileOutputStream(templateName);
            workbook.write(outputStream);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MyTestNGBaseClass.allureReport("", excelName + "_Template excel dosyası oluşturuldu.", false);
    }

    public static List<Product> excelList() throws Exception  {

        for (int number = 0;number<chargeAggrKey.size();number++){
            Product person = new Product();
            person.setDisplay_value(displayValue.get(number));
            System.out.println("object display value=" + person.getDisplay_value());
            person.setCharge_aggr_key(chargeAggrKey.get(number));
            person.setJnl_line_id(jnlLineId.get(number));
            person.setService_id(serviceId.get(number));
            person.setPoint(point.get(number));
            System.out.println("object point value=" + person.getPoint());
            person.setPoint_id(pointId.get(number));
            person.setJurisdiction(jurisdiction.get(number));
            person.setSeqnum(seqNum.get(number));
            person.setContent_id(contentId.get(number));
            productList.add(person);
        }
        System.out.println(productList);
        return productList;
    }

    public static Connection dbConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL ="jdbc:oracle:thin:@172.31.70.4:1526:SBLBGFD";
        String username="VF_OTOAGILE";
        String password="VF_OTOAGILE";
        Connection connection = DriverManager.getConnection(dbURL , username, password);
        return connection;
    }

    public static ArrayList<String> infoFromDB(ArrayList<String> tmpArrayList, String field, String sql) throws Exception {
        try {
            int rowNum = displayValue.size();
            Connection connection = dbConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, rowNum);
            ResultSet resultset= statement.executeQuery();
            while (resultset.next()) {
                String field_= resultset.getString(field);
                tmpArrayList.add(field_);
            }
            System.out.println(field+ " = " + tmpArrayList);

            resultset.close();
            statement.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL", field + " bilgi alımı sırasında problem yaşandı.", true);
        }
        return tmpArrayList;
    }

    public static void infoGathering() throws Exception {
        infoFromDB(chargeAggrKey,"CHARGE_AGGR_KEY","SELECT ID CHARGE_AGGR_KEY FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='ALL' AND DOMAIN='KENAN' AND ID_TYPE='CHARGE_AGGR_KEY' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(jnlLineId,"JNL_LINE_ID","SELECT ID JNL_LINE_ID FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='JNL_LINE_ID' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(pointId,"POINT_ID","SELECT ID POINT_ID FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='POINT_ID' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(jurisdiction,"JURISDICTION","SELECT ID JURISDICTION FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='JURISDICTION' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(seqNum,"SEQNUM","SELECT ID SEQNUM FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='SEQNUM' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");

        updateSQL(jnlLineId,"JNL_LINE_ID");
        updateSQL(chargeAggrKey,"CHARGE_AGGR_KEY");
        updateSQL(pointId,"POINT_ID");
        updateSQL(jurisdiction,"JURISDICTION");
        updateSQL(seqNum,"SEQNUM");
    }

    public static void kenan(String filename) throws IOException {
        File filepath= new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\CBU_BAGIS_Kampanyasi_Kenan\\" + filename);
        File directory = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Conf\\" + excelFileName.replace("_CBU_Donation_Kenan.xlsx","") + "\\");
        if (!directory.exists()){
            directory.mkdirs();
        }
        try{
            FileReader fr = new FileReader(filepath);
            String s;
            String totalStr = "";
            FileWriter fw = new FileWriter(directory + "\\" + filename);
            try (BufferedReader br = new BufferedReader(fr)) {
                for (int x=0;x<displayValue.size();x++) {

                    while ((s = br.readLine()) != null) {
                        totalStr += s + "\n";
                    }

                    String tempTotalStr = totalStr;

                    totalStr = totalStr.replaceAll("\\$CHARGE_AGGR_KEY", chargeAggrKey.get(x));
                    totalStr = totalStr.replaceAll("\\$JURISDICTION", jurisdiction.get(x));
                    totalStr = totalStr.replaceAll("\\$JNL_LINE_ID", jnlLineId.get(x));
                    totalStr = totalStr.replaceAll("\\$SERVICE_ID", serviceId.get(x));
                    totalStr = totalStr.replaceAll("\\$DISPLAY_VALUE", displayValue.get(x));
                    totalStr = totalStr.replaceAll("\\$CONTENT_ID", contentId.get(x));
                    totalStr = totalStr.replaceAll("\\$SEQNUM", seqNum.get(x));
                    totalStr = totalStr.replaceAll("\\$POINT_ID", pointId.get(x));
                    totalStr = totalStr.replaceAll("\\$POINT",point.get(x));

                    fw.write(totalStr);

                    totalStr = tempTotalStr;

                }

                fw.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String findTemplateFile(File dir) throws IOException {
        MyTestNGBaseClass.allureReport("", "Template dosyası açılıyor.", false);
        String TemplateName = "";
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("DML_");
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i=0; i<children.length;i++) {
                TemplateName = children[i];
                System.out.println("Editing " + children[i]);
                kenan(children[i]);
            }
            File moveFile = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Conf\\" + excelFileName.replace("_CBU_Donation_Kenan.xlsx","") + "\\DML_BCA_ELIG_AGGR_REF_del_vftrbill_agl.sql");
            moveFixedFiles(moveFile);
        }
        return TemplateName;
    }

    public static String findExcel(File dir) {
        MyTestNGBaseClass.allureReport("", "Excel dosyası açılıyor.", false);
        String TemplateName = "";
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("CBU_Donation_Kenan.xlsx");
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i = 0; i < children.length; i++) {
                TemplateName = children[i];
                readExcel("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\" + TemplateName);
                break;
            }
        }
        return TemplateName;
    }

    public static void copyFile( File from, File to ) throws IOException {
        Files.copy( from.toPath(), to.toPath() );
    }

    public static void moveFixedFiles(File dirTo){
        System.out.println("Moving fixed files to Kenan Conf.");
        File dirFrom = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\CBU_BAGIS_Kampanyasi_Kenan\\CBU_BAGIS_KENAN_Otomasyonu_sabitDosyalar\\DML_BCA_ELIG_AGGR_REF_del_vftrbill_agl.sql");
        try {
            copyFile(dirFrom, dirTo);
        } catch (IOException ex) {
        }
    }

    public static void attendVariablesFromExcel(String templatePath){
        displayValue.clear();
        chargeAggrKey.clear();
        jnlLineId.clear();
        serviceId.clear();
        point.clear();
        pointId.clear();
        jurisdiction.clear();
        seqNum.clear();
        contentId.clear();
        System.out.println("cleared array" + displayValue);

        Workbook templateBook = null; //initialize Workbook null
        boolean firstRow = true;

        String tmpdisplayValue = null; //variable for storing the cell 0 value
        String tmpChargeAggrKey = null; //variable for storing the cell 1 value
        String tmpJnlLineId = null; //variable for storing the cell 2 value
        String tmpServiceId = null; //variable for storing the cell 3 value
        String tmpPoint = null; //variable for storing the cell 4 value
        String tmpPointId = null; //variable for storing the cell 5 value
        String tmpJurisdiction = null; //variable for storing the cell 6 value
        String tmpSeqNum = null; //variable for storing the cell 7 value
        String tmpContentId = null; //variable for storing the cell 8 value

        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream(templatePath);
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            templateBook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL", "Excel açılamadı.", true);
        }

        Sheet sheet = templateBook.getSheetAt(0);
        //getting the XSSFSheet object at given index

        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            if (firstRow) {
                itr.next();
                firstRow = false;
            }
            Row rowitr = itr.next();
            Iterator<Cell> cellitr = rowitr.cellIterator();
            while (cellitr.hasNext()) {
                Cell celldata = cellitr.next();
                switch (celldata.getColumnIndex()) {
                    case 0: //DISPLAY_VALUE
                        try {
                            tmpdisplayValue = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpdisplayValue = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        System.out.println("value=" + tmpdisplayValue);
                        displayValue.add(tmpdisplayValue);
                        System.out.println("excel value" + displayValue);
                        break;
                    case 1: //CHARGE_AGGR_KEY
                        try {
                            tmpChargeAggrKey = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpChargeAggrKey = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        chargeAggrKey.add(tmpChargeAggrKey);
                        break;
                    case 2: //JNL_LINE_ID
                        try {
                            tmpJnlLineId = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpJnlLineId = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        jnlLineId.add(tmpJnlLineId);
                        break;
                    case 3: //SERVICE_ID
                        try {
                            tmpServiceId = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpServiceId = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        serviceId.add(tmpServiceId);
                        break;
                    case 4: //POINT
                        try {
                            tmpPoint = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpPoint = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        point.add(tmpPoint);
                        break;
                    case 5: //POINT_ID
                        try {
                            tmpPointId = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpPointId = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        pointId.add(tmpPointId);
                        break;
                    case 6: //JURISDICTION
                        try {
                            tmpJurisdiction = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpJurisdiction = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        jurisdiction.add(tmpJurisdiction);
                        break;
                    case 7: //SEQNUM
                        try {
                            tmpSeqNum = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpSeqNum = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        seqNum.add(tmpSeqNum);
                        break;
                    case 8: //CONTENT_ID
                        try {
                            tmpContentId = celldata.getStringCellValue().trim();
                        } catch (Exception e1) {
                            tmpContentId = String.valueOf((int) (celldata.getNumericCellValue()));
                        }
                        contentId.add(tmpContentId);
                        break;
                }
            }
        }
    }

    public static void updateSQL(ArrayList<String> List, String type) throws Exception {
        String query = "";
        if (type == "CHARGE_AGGR_KEY"){
            query = "UPDATE SIEBEL.CX_OFFERUI_ID_X SET RESERVED = 'Y',UPD_USER='JENKINS',UPD_DATE=SYSDATE WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='ALL' AND DOMAIN='KENAN' AND ID_TYPE= ? AND RESERVED = 'N' AND ID= ?";

        } else {
            query = "UPDATE SIEBEL.CX_OFFERUI_ID_X SET RESERVED = 'Y',UPD_USER='JENKINS',UPD_DATE=SYSDATE WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE= ? AND RESERVED = 'N' AND ID= ?";
        }
        try {
            Connection connection = dbConnection();
            PreparedStatement statement = null;

            for(int i=0; i<displayValue.size();i++){
                System.out.println("display size" + displayValue.size());
                statement=connection.prepareStatement(query);
                statement.setString(1, type);
                statement.setString(2, List.get(i));
                System.out.println("i is = " + i);
                System.out.println("type is = " + type);
                System.out.println("List element is = " + List.get(i));
                System.out.println("Statement is = " + query);
                int affected = statement.executeUpdate();
                System.out.println("affected = " +affected);
                statement.close();
            }

            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
            MyTestNGBaseClass.allureReport("FAIL", type + " güncellemesi sırasında problem yaşandı.", true);
        }
    }

}