package com.bymatAutomation.modulename.playground;

import com.bymatautomation.seleniumtraining.ExcelReader;

public class ExcelReadingAndWriting {

	public static void main(String[] args) {
		
		ExcelReader excel = new ExcelReader("D:\\BYMAT_Automation\\WorkSpace\\WorkSpace_Photon\\SeleniumTraining_B13_MVN\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		//D:\BYMAT_Automation\WorkSpace\WorkSpace_Photon\SeleniumTraining_B13_MVN\src\test\resources\testData\Master_Sheet.xlsx
		
		// excel.addSheet("NewSheet");
		
		
	//addColumn("NewSheet", "Name");
	
	// excel.addColumn("Test_Cases", "NewColumn");
	
	System.out.println(excel.getCellData("Test_Cases", "TestCaseName", 5));
	
	System.out.println(excel.getRowCount("Test_Cases"));
	
	System.out.println(excel.getCellData("Test_Data", 3, 5));
	
	System.out.println(excel.getCellData("Test_Data", 3, 9));
	
	}

}
