package com.google.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String[][] getSheetIntoMultiDimStringArray(String fileDetail,String sheetName) throws IOException {

		FileInputStream file = new FileInputStream(fileDetail); // read and location

		XSSFWorkbook book = new XSSFWorkbook(file); // open
		XSSFSheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow rowCheck = sheet.getRow(0);
		int cellCount = rowCheck.getPhysicalNumberOfCells();
		DataFormatter format = new DataFormatter();
		
		String[][] main = new String[rowCount - 1][cellCount];
		// print each cell value
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				String value = format.formatCellValue(cell);
				// System.out.println(value);
				main[i - 1][j] = value;
			}
		}
		book.close();
		file.close();
		
		return main;
	}

}
