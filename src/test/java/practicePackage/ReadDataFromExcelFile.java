package practicePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
public static void main(String[] args) throws Throwable {
	FileInputStream ifs=new FileInputStream(".\\src\\test\\resources\\testyantra.xlsx");
	 Workbook wp=WorkbookFactory.create(ifs);
	Sheet sh= wp.getSheet("sheet1");
	String ag=sh.getRow(1).getCell(0).getStringCellValue();
	System.out.println(ag);
	
	
	//write in excelSheet
//	FileInputStream fis=new FileInputStream("\\src\\test\\resources\\testyantra.xlsx");
//	Workbook bk=WorkbookFactory.create(fis);
	wp.getSheet("Sheet1").createRow(5).createCell(4).setCellValue("qspider");
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testyantra.xlsx");
	wp.write(fos);
	wp.close();
	
}
}
