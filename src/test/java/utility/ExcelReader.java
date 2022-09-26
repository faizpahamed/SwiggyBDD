package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelReader {
	
	
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String testData = "";
	// Import excel sheet.
	public File src = new File("/SwiggyBDD/testData/TestData.xlsx");
	public String GetCellValue(String testcaseTitle , int cellIndex) throws
	IOException
	{
	try
	{
	// Load the file.
	FileInputStream finput = new FileInputStream(src);
	// Load he workbook.
	workbook = new XSSFWorkbook(finput);
	// Load the sheet in which data is stored.
	sheet= workbook.getSheetAt(0);
	for(int i=1; i<= sheet.getLastRowNum(); i++)
	{
	//Get data for test cases base on Test Case Name
	cell = sheet.getRow(i).getCell(0);
	cell.setCellType(CellType.STRING);
	if(cell.getStringCellValue() == testcaseTitle)
	{
	XSSFCell cellData =
	sheet.getRow(i).getCell(cellIndex);
	cellData.setCellType(CellType.STRING);
	testData = cellData.getStringCellValue();
	}
	}
	return testData;
	}
	catch (Exception e){
	return testData;
	}
	}
	//Write result in excel sheet
	public void WriteResult(String testcaseTitle, Boolean result) throws InvalidFormatException, IOException
	{
	//FileOutputStream foutput=new FileOutputStream(src);
	// Load the workbook.
	workbook = new XSSFWorkbook(src);
	// Load the sheet in which data is stored.
	sheet = workbook.getSheetAt(0);
	for(int i=1; i<=sheet.getLastRowNum(); i++)
	{
	//Get data for test cases base on Test Case Name
	cell = sheet.getRow(i).getCell(0);
	cell.setCellType(CellType.STRING);
	if(cell.getStringCellValue() == testcaseTitle)
	{
	if(result == true)
	sheet.getRow(i).createCell(3).setCellValue("Pass");
	else
	sheet.getRow(i).createCell(3).setCellValue("Fail");
	}
	}
	}
	public String readCell(Sheet sheet, int column, int row)
	{
		XSSFCell cellData =	(XSSFCell) sheet.getRow(row).getCell(column);
		
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(cellData);
		//System.out.println(val);
		return val;
	}
	
	public int rowCount()
	{
	return sheet.getLastRowNum();
	}
	//Returns the Number of Columns
	public int columnCount()
	{		
		
	return sheet.getRow(0).getLastCellNum();
	}

	public Sheet getWorksheet(String WorkbookPath, String sheetname) throws IOException 
	{
		File src = new File(WorkbookPath);
		
	//Initialize the instance of workbook
	workbook =  new XSSFWorkbook(WorkbookPath);
	sheet = workbook.getSheet(sheetname);
	return sheet;
	}

}


