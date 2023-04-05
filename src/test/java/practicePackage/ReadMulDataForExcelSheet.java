package practicePackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMulDataForExcelSheet {
public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testyantra.xlsx");
	Workbook wp=WorkbookFactory.create(fis);
	Sheet count=wp.getSheet("sheet1");
	int ag=count.getLastRowNum();
				for(int i=0;i<=ag;i++){
		String a=count.getRow(i).getCell(0).getStringCellValue();
		String b=count.getRow(i).getCell(1).getStringCellValue();
		System.out.println(a+"  "+b);
	}
	
}
}
