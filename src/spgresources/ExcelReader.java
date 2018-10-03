package spgresources;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class ExcelReader {
    public static final String SAMPLE_XLS_FILE_PATH = "D://KIETMIS.xls";
    public static final String SAMPLE_XLSX_FILE_PATH = "D://KIETMIS.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
getList();

    }
    public static List<String> getList() throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        
        int n=workbook.getNumberOfSheets();
      
      //  System.out.println("Workbook has " + n + " Sheets : ");

       
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
       // System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
           String ss=sheet.getSheetName();
          //  System.out.println("=> " + ss);
           
        }

     
       List<String> list = new ArrayList<String>();
        
        for (int i=0;i<n;i++)
        {
        Sheet sheet = workbook.getSheetAt(i);
//System.out.println("going to print the sheet name "+sheet);
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
      //  System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
         
            
             
            Iterator<Cell> cellIterator = row.cellIterator();
           
           // while (cellIterator.hasNext()) {
            	Cell cell1 = row.getCell(1);
                Cell cell = cellIterator.next();
               
                String cellValue = dataFormatter.formatCellValue(cell1);
               
               
               // System.out.print(cellValue + "\t");
               
               list.add(cellValue);
          //  }
    		
            System.out.println();
        }

        }
        int sx=list.size();
        return list;
        
	   }
   
     
}

