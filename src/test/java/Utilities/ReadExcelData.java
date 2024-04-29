package Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelData{
	public static String[][] readExcelData(String fileName, String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);
//		System.out.println("Row-" + sheet.getLastRowNum());
		String[][] s = new String[sheet.getLastRowNum()][row.getLastCellNum()];
		for(int i = 1; i <= sheet.getLastRowNum(); i++){
			for(int j = 0; j < row.getLastCellNum(); j++){
//				System.out.println("CellDat-" + sheet.getRow(i).getCell(j));
				s[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return s;
	}
}