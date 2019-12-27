package EncorDashboard.GlobalLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//Test 

public class GenericFunction {

	
	public  FileInputStream ipstr = null;
	public  FileOutputStream opstr =null;
	private  HSSFWorkbook wb = null;
	private  HSSFSheet ws = null;
	HSSFRow excelRow =null;
	public int rowcount;
	public static String DIndicatorContentKey;
	public static String DRelevantYYYYMM;
	public static String DNumerator;
	public static String DDenominator;
	public static String Column1;
	public static String Column2;
	public static String Column3;
	public static String Column4;
	public static String Column5;
	public static String Column6;
	public static String Column7;
	public static String Column8;
	public static String Column9;
	public static String Column10;
	public static String Column11;
	public static String Column12;
	public static String Column13;
	public static String Column14;
	public static String Column15;
	public static String Column16;
	
	public static void SaveVariable(String Column1,String Column2,String Column3,String Column4,String Column5,String Column6,String Column7,String Column8,String Column9,String Column10,String Column11,String Column12,String Column13,String Column14,String Column15,String Column16)
    {
 	   GenericFunction.Column1 = Column1;
 	   GenericFunction.Column1 = Column2;
 	   GenericFunction.Column1 = Column3;
 	   GenericFunction.Column1 = Column4;
 	   GenericFunction.Column1 = Column5;
 	   GenericFunction.Column1 = Column6;
 	   GenericFunction.Column1 = Column7;
 	   GenericFunction.Column1 = Column8;
 	   GenericFunction.Column1 = Column9;
 	   GenericFunction.Column1 = Column10;
 	   GenericFunction.Column1 = Column11;
 	   GenericFunction.Column1 = Column12;
 	   GenericFunction.Column1 = Column13;
 	   GenericFunction.Column1 = Column14;
 	   GenericFunction.Column1 = Column15;
 	   GenericFunction.Column1 = Column16; 
 	   
 	   
 	  System.out.println(Column1+','+Column2+','+Column3+','+Column4+','+Column5+','+Column6+','+Column7+','+Column8+','+Column9+','+Column10+','+Column11+','+Column12+','+Column13+','+Column14+','+Column15+','+Column16);
 	  
    }
	public static void dbConnect()throws SQLException
	{
		try {
			
			    String dbURL = "jdbc:sqlserver://MS-DB-C;DatabaseName=EncorD092017";
	            String user = "MSSMS_User";
	            String pass = "M3d1s0lv!";
	            String Query = "select IndicatorContentKey,RelevantYYYYMM,Case DorN When 'N' Then Count(DorN) end as Numerator,Case DorN When 'D' Then Count(DorN)end as Denominator from AHRQ.IndicatorVisitResults where IndicatorContentKey = 515 and RelevantYYYYMM between  '201610' and '201805' GROUP BY RelevantYYYYMM,IndicatorContentKey,DorN;";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			 System.out.println("connected");
			    
	         GlobalVariables.conn  = DriverManager.getConnection(dbURL,user,pass);
	         
	         Statement stmt =  GlobalVariables.conn.createStatement();
	         
	       ResultSet rs =  stmt.executeQuery(Query);
	       
	         while(rs.next())
	         {
	        	  DIndicatorContentKey = rs.getString(1);								        
                  DRelevantYYYYMM = rs.getString(2);
                  DNumerator = rs.getString(3);								        
                  DDenominator = rs.getString(4);                 
                 System. out.println(DIndicatorContentKey+"  "+DRelevantYYYYMM+ " "+DNumerator+ " "+DDenominator); 
                 
                // if(DIndicatorContentKey==Column1 && DIndicatorContentKey==Column1 DIndicatorContentKey==Column1 && DIndicatorContentKey==Column1 DIndicatorContentKey==Column1 && DIndicatorContentKey==Column1 DIndicatorContentKey==Column1)
                 
	         }
	         	         
	         GlobalVariables.conn.close();	
	         
	         System.out.println("connected1");	                     
	        		
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		 
		}
		
	}
	
	
	public  static void getScreenShot()throws Exception
	{
      
    File scrFile = ((TakesScreenshot)GlobalVariables.oDriver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with name "screenshot.png"
       FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
	}
	
	
	public  void Read_XLS(String filelocation) {		
		
		try {
			int rowcount =1;
			ipstr = new FileInputStream(filelocation);
			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			excelRow= ws.createRow(rowcount);
			ipstr.close();
		}
		
		catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
		//To retrieve No Of Rows from .xls file's sheets.
		public int retrieveNoOfRows(String wsName){		
			int sheetIndex=wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return 0;
			else{
				ws = wb.getSheetAt(sheetIndex);
				
				int rowCount=ws.getLastRowNum()+1;		
				return rowCount;		
			}
		}
		
		//To retrieve No Of Columns from .cls file's sheets.
		public int retrieveNoOfCols(String wsName){
			int sheetIndex=wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return 0;
			else{
				ws = wb.getSheetAt(sheetIndex);
				int colCount=ws.getRow(0).getLastCellNum();			
				return colCount;
			}
		}
		
		//To retrieve test data from test case data sheets.
		public Object[][] retrieveTestData(String wsName){
			int sheetIndex=wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return null;
			else{
					int rowNum = retrieveNoOfRows(wsName);
					int colNum = retrieveNoOfCols(wsName);
			
					Object data[][] = new Object[rowNum-1][colNum];
			
					for (int i=0; i<rowNum-1; i++){
						
						
						HSSFRow row = ws.getRow(i+1);
						
						
						System.out.println(row.getCell(i+1));
						
						for(int j=0; j< colNum; j++){				
							if(row==null)
							{
								
								System.out.println("test");
								data[i][j] = "";
							}
							else{
								HSSFCell cell = row.getCell(j);	
								System.out.println(cell);
						
								if(cell==null){
									System.out.println("test1");
									data[i][j] = "";							
								}
								else{
									
									System.out.println("test2");
									cell.setCellType(Cell.CELL_TYPE_STRING);
									String value = cellToString(cell);									
									data[i][j] = value;						
								}
							}
						}				
					}			
					return data;		
			}
		
		}
		
		public static String cellToString(HSSFCell cell){
			int type;
			Object result;
			type = cell.getCellType();			
			switch (type){
				case 0 :
					result = cell.getNumericCellValue();
					break;
					
				case 1 : 
					result = cell.getStringCellValue();
					break;
					
				default :
					throw new RuntimeException("Unsupportd cell.");			
			}
			return result.toString();
		}
		
    public void SimpleExcelWrite(String field,int columnCount) throws IOException
    {
    	    	
    	Object fields = field;
    	   	     	     	  
    	  Cell cell = excelRow.createCell(columnCount);
    	  
    	  if (fields instanceof String) {
              cell.setCellValue((String) fields);
          } 
    	  else if (fields instanceof Integer) {
              cell.setCellValue((Integer) fields);
    	  }
    	      	  
    }
   		
    
       public void WriteFile() throws IOException
       {
    	   FileOutputStream outputStream = new FileOutputStream("/EncorD_MV/src/main/java/EncorDashboard/ExcelFile/DashboardData.xls"); 
           wb.write(outputStream);
           outputStream.close();
         }
       
       
       
    }
	 
	


