package Data_Drivan_Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DD_guru99login {

	public static void main(String[] args) throws IOException
	{
		FileInputStream I= new FileInputStream("C:\\Users\\HP\\Desktop\\selenium jar\\Selenium.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(I);     // to open excel sheet
		
		XSSFSheet s=wb.getSheet("Demo_Tour");   //to open Excel sheet1
		
		//getrows(0)*getcell()
		
		String UN1=s.getRow(0).getCell(0).toString();
		System.out.println(UN1);
		
		String PWD1=s.getRow(0).getCell(1).toString();
		System.out.println(PWD1);
		
		
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\selenium jar\\chromedriver.exe");//launch browser
	      WebDriver w= new ChromeDriver();
	   
	      w.get("http://demo.guru99.com/test/newtours/index.php");//open URL
	    
	   w.findElement(By.name("userName")).sendKeys(UN1);//enter user name
	   
	   
	      
	      w.findElement(By.name("password")).sendKeys(PWD1);//enter PWD
	      
	      w.findElement(By.name("submit")).click();//CLICK Submit
	      	
		s.getRow(0).createCell(2).setCellValue("Submit Button is Working ");
		wb.write(new FileOutputStream("C:\\Users\\HP\\Desktop\\selenium jar\\Selenium.xlsx"));
	
	}

}
