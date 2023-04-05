package com.GenericUtilitys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	private static final String[][] Object = null;

	/**
	 * @author Suresh Biswal
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheet,int row,int cell) throws Throwable
	{
		Workbook wb=WorkBook();
	 Sheet sh = wb.getSheet(sheet);
	 String data=sh.getRow(row).getCell(cell).getStringCellValue();
	 return data;
	
	}
	
	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int  getLastRowNo(String sheet) throws Throwable
	{
		Workbook wb=WorkBook();
		 Sheet sh = wb.getSheet(sheet);
		 int LastRow=sh.getLastRowNum();
		 return LastRow;
	}
	
	
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 * @throws Throwable
	 */
	public void writeDataInExcel(String sheet,int row,int cell,String value) throws Throwable, Throwable
	{
		Workbook wb=WorkBook();
		  Sheet sh = wb.getSheet(sheet);
		  sh.createRow(row).createCell(cell).setCellValue(value);
		  FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
		  wb.write(fos);
		  
	}
	
	
	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String > readMultipleDataInExcel(String sheet) throws Throwable
	{
		  Workbook wb=WorkBook();
		  Sheet sh = wb.getSheet(sheet);
		  int count=sh.getLastRowNum();
		  HashMap<String, String> map=new HashMap<String, String>();
		  for(int i=0;i<=count;i++)
		  {
			 String key= sh.getRow(i).getCell(0).getStringCellValue();
			  String value=sh.getRow(i).getCell(1).getStringCellValue();
			  map.put(key, value);
			  
		  }
		  return map;
	}
	public void closeExcel(Workbook bk) throws Throwable
	{
	    bk.close();
	}
	public static  Workbook WorkBook() throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		  Workbook wb=WorkbookFactory.create(fis);
		  return wb;

	}
	
public Object[][] readMultipleSetUpData() throws Throwable
	{
		FileInputStream  fis=new FileInputStream(IpathConstants.ExcelPath);
Workbook book=		WorkbookFactory.create(fis);
Sheet sh = book.getSheet("Sheet6");
int lastRow = sh.getLastRowNum()+1;
int lastCell=sh.getRow(0).getLastCellNum();
Object[][] obj=new Object[lastRow][lastCell];
for(int i=0;i<lastRow;i++)
{
	for(int j=0;j<lastCell;j++)
	{
		obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	}
}


return obj;
	}
	
}
