package trello.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReader {
	
	@Test(dataProvider="getDatafromExcel")
	public void searchAndVerify(String searchstring, String expectedresult) throws InterruptedException {
		System.out.println(searchstring + " : "+expectedresult);
	}
	
	@DataProvider
	public Object[][] getDatafromExcel() throws IOException {
		// rows - number of time test has to be repeated
		// cols - number of parameters in test data
		
		//Please keep your Test Data excel file in the project base folder
		//Make sure that the excel file does not have any extra rows or columns. To ensure this,
		//select and remove / delete some blank columns on the right and some blank rows on 
		//the bottom. This will ensure that there is no unwanted data.
		
		//For some reason (bug in POI), it identifies 1 column less that what is required. 
		//So, I have added a blank column (with a header) to the right called Remarks
		String currentDirectory = System.getProperty("user.dir");
		String datafile = null;
		if(System.getProperty("os.name").toLowerCase().contains("mac")) {
			datafile =currentDirectory+ "/src/resources/trellodata.xlsx";
		}
		else {
			datafile =currentDirectory+ "/src/resources/trellodata.xlsx";
		}
		Object[][] data = readExcelData(datafile);
		
		return data;
	}

	@DataProvider
	public static Object[][] readExcelData(String fileName) throws IOException 
	{
		System.out.println("Starting Excel Reader");
		String sheetName = "Sheet1";
		
		File file =	new File(fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		
		System.out.println("abc");
		
		Workbook wb = null;
		
		//Workbook Workbook = new XSSFWorkbook(inputStream);
		if(fileName.endsWith(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}
		if(fileName.endsWith(".xlsx")) {
			wb = new XSSFWorkbook(inputStream);
		}
	
		System.out.println(wb.getActiveSheetIndex());
		//Read sheet inside the workbook by its name
		 Sheet  mySheet = wb.getSheet(sheetName);
		 int rowCount = mySheet.getLastRowNum();
		 int colCount = mySheet.getRow(0).getPhysicalNumberOfCells();
		 
		 colCount = colCount;
		 
		 System.out.println("No of rows: " + rowCount + ". No of cols: " + colCount);
         
		 Object[][] object = new Object[rowCount][colCount];
     	 
         for (int i = 0; i < rowCount; i++) {
    		//Loop over all the rows
     		System.out.println("Row :" + i);
    		Row row = mySheet.getRow(i+1);
    	
    		//Create a loop to print cell values in a row
    		for (int j = 0; j < colCount; j++) {
    			//Print excel data in console
    			object[i][j] = row.getCell(j).toString();
    			System.out.println(object[i][j]);
    		}
	
    	}
        wb.close();
		return object;
	}
}
