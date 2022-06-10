package com.project;

import com.saf.framework.MyTestNGBaseClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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


    static String path = "C:\\Users\\amdocsuakgun\\Desktop\\01.06.2022.xlsx";

    public static void main(String[] args) throws Exception {
        readTemplateExcel(path);
        infoGathering();
        excelList();
        createExcel("1111");
    }

    public static void readTemplateExcel(String path) {
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
        MyTestNGBaseClass.allureReport("", "CBU_BAGIS_Kenan_AGILE-" + newFileName + ".xlsx excel dosyası oluşturuluyor.", false);
        try {
            String fileName = "C:\\Users\\amdocsuakgun\\Desktop\\" + "CBU_BAGIS_Kenan_AGILE-" + newFileName + ".xlsx";
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

            for (int x = 0; x<chargeAggrKey.size(); x++) {
                row = sheet.createRow(++rowCount);
                int i = 0;
                p=productList.get(x);
                cell = row.createCell(i);
                cell.setCellValue(p.getDisplay_value());
                cell = row.createCell(++i);
                cell.setCellValue(p.getCharge_aggr_key());
                cell = row.createCell(++i);
                cell.setCellValue(p.getJnl_line_id());
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
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            int rowNum = displayValue.size()-1;
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
        infoFromDB(chargeAggrKey,"CHARGE_AGGR_KEY","SELECT ID CHARGE_AGGR_KEY FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='CHARGE_AGGR_KEY' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(jnlLineId,"JNL_LINE_ID","SELECT ID JNL_LINE_ID FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='JNL_LINE_ID' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(pointId,"POINT_ID","SELECT ID POINT_ID FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='POINT_ID' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(jurisdiction,"JURISDICTION","SELECT ID JURISDICTION FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='JURISDICTION' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
        infoFromDB(seqNum,"SEQNUM","SELECT ID SEQNUM FROM (SELECT * FROM SIEBEL.CX_OFFERUI_ID_X WHERE CUSTOMER_TYPE='CBU' AND PRODUCT_TYPE='DONATION' AND DOMAIN='KENAN' AND ID_TYPE='SEQNUM' AND RESERVED = 'N' ORDER BY ID) WHERE ROWNUM <= ?");
    }
}