package practicePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteMulDateInExcel {

	
	public static void main(String[] args) throws Throwable {
		Scanner sc=new Scanner(System.in);
		System.out.println("start");
		setValuInExcel(sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
		System.out.println("done");
		
		
		
	}
	public  static void setValuInExcel(String sheet,int a,int b,String value) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testyantra.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheet);
	sh.createRow(a).createCell(b).setCellValue(value);
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testyantra.xlsx");
	book.write(fos);
	fos.flush();
	}
	
}
