package com.saf.framework;//reading value of a particular cell
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel. * ;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils extends MyTestNGBaseClass {

    //method defined for reading a cell
    public String ReadCellData(int vRow, int vColumn) {
        String value = null; //variable for storing the cell value
        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("V:\\Test_Servis_Yonetimi_Mudurlugu_II\\FINCO \\Otomasyon.xlsx");
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
        Row row = sheet.getRow(vRow);
        //returns the logical row
        Cell cell = row.getCell(vColumn);
        //getting the cell representing the given column
        value = String.valueOf(cell.getNumericCellValue());
        //getting cell value
        return value;
        //returns the cell value
    }
    public String ReadCellDataString(int vRow, int vColumn) {
        String value = null; //variable for storing the cell value
        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("V:\\Test_Servis_Yonetimi_Mudurlugu_II\\FINCO \\Otomasyon.xlsx");
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
        Row row = sheet.getRow(vRow);
        //returns the logical row
        Cell cell = row.getCell(vColumn);
        //getting the cell representing the given column
        value = cell.getStringCellValue();
        //getting cell value
        return value;
        //returns the cell value
    }

}