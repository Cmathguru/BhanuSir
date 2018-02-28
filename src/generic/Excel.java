package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public  static String getData(String s,String p,int r,int c) {
		String v=" ";
		 try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(p));
			v=wb.getSheet(s).getRow(r).getCell(c).toString();
		 }catch(Exception e) {}
		 return v;
	}
	public static int getRowCount(String p,String s) {
		int rc=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(p));
			rc=wb.getSheet(s).getLastRowNum();
		   }catch(Exception e) {}
		   return rc;
	}
	public static int getColumnCount(String p,String s) {
		int cc = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(p));
			//wb.getSheet(s).
		}catch(Exception e) {}
		return cc;
	}

}
