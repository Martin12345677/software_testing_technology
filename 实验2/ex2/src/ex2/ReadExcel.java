package ex2;


import jxl.*;
import jxl.read.biff.BiffException;
import java.io.*;

public class ReadExcel {
	
	private String src;
	
	public ReadExcel(String src) {
		this.src = src;
	}
	
	public String[][] getData(int sh) throws BiffException, IOException {
		
		String[][] result;
		
		Workbook exl = Workbook.getWorkbook(new File(this.src));
		Sheet sheet = exl.getSheet(sh);
		
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		System.out.println("一共" + rows + "条数据");
		
		result = new String[rows][cols];
		
		for(int i = 0; i<rows;i++) {
			for(int j = 0; j < cols; j++) {
				result[i][j] = new String(sheet.getCell(j, i).getContents());
			}
		}
		
		return result;
	}
}
