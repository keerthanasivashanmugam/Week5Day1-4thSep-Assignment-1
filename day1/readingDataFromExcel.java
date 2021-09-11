package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingDataFromExcel {

	public static String[][] readExcel(String fileName) throws IOException {
		
		
		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		XSSFRow rows = ws.getRow(0);
		int lastRowNum = ws.getLastRowNum();
		
		 short lastCellNum = rows.getLastCellNum();
		
		String[][] details = new String[lastRowNum][lastCellNum];
		
		for (int i=1;i<=lastRowNum;i++) {
			
			for(int j=0;j<lastCellNum;j++) {
			
				String txt = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.print(txt+"	");
				details[i-1][j]= txt;
			}
			System.out.println();
		}
		return details;
		
		
	}
}
