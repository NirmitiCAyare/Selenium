package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public String getDataFromExcel(String Sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException, IOException
	{
		//Step1:Create obj of FileInputStream class and in FileInputStream Constructor and enter the path of file
		FileInputStream fis=new FileInputStream("src\\test\\resources\\Organizations.xlsx");
	
		//Step2:Call WorkbookFactory class from apache poi and call create(InputStream)
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step3:Call getsheet(String name) & enter sheet name
		Sheet sh=wb.getSheet("Organizations");
	
		//Step4:Call getrow(int rownum) and Enter the row number
		Row rw=sh.getRow(Rownum);
	
		//Step5:Call getCell(int cell)
		Cell c1=rw.getCell(Cellnum);
		
		//Step6:
		String value=c1.getStringCellValue();
		return value;
}
}
