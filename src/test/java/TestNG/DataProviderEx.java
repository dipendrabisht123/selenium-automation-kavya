package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	
	
  @Test(dataProvider = "dataProviderExcel")
  public void testMethod(String sUserName, String sPWD) {
	  
	  System.out.println("sUserName: "+ sUserName);
	  System.out.println("sPWD: "+ sPWD);
//	  System.out.println("Second param: "+ s);
  }
  
  

  @DataProvider
  public Object[][] dataProvider() {
    /*return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };*/
    
    return new String[][] {
        { "1" },
        
      };
  }
  
 /* @DataProvider
  public Object[][] dataProviderExcel() {
	  
	  String[][] credArray= new String [2][2]; 
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("./Data/Credentials.xlsx")));
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> itSheet = sheet.rowIterator();
			
			int iRow = 0;
			
			while (itSheet.hasNext()){
				Row row = itSheet.next();
				
					int iCol = 0;
					
					Iterator<Cell> itRow = row.cellIterator(); 
					
					while (itRow.hasNext()){
						Cell cell = itRow.next();
						String cellVal = cell.getStringCellValue();
						credArray[iRow][iCol] = cellVal;
						iCol++;
					}
				
				iRow++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return credArray;
	
  }*/

}


