package practicePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilitys.IpathConstants;

public class DataProviderUseingExcel {

	
	
	@DataProvider
	public Object[][] detaa() throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("sheet6");
	int  lastrow=sh.getLastRowNum()+1;
	int  lastcell=sh.getRow(0).getLastCellNum();
	Object[][] obj=new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();

		}
	}
	return obj;

		
		
	}
	
	public HashMap<String, String> hashData() throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("sheet6");
		int  lastrow=sh.getLastRowNum()+1;
		int  lastcell=sh.getRow(0).getLastCellNum();
		HashMap<String, String> map=new HashMap<String,String>();
		  for(int i=0;i<=lastrow;i++)
		  {
			 String key= sh.getRow(i).getCell(0).getStringCellValue();
			  String value=sh.getRow(i).getCell(1).getStringCellValue();
			  map.put(key, value);
			  
		  }
		  return map;

		
	}
}
