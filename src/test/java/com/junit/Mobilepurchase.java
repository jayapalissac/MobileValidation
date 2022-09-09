package com.junit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Mobilepurchase  {
	
	static WebDriver driver;
	
	@BeforeClass
	public static  void beforeclass() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AR\\eclipse-workspace\\SeleniumTesting\\Driver\\chromedriver.exe");
		
	driver=new ChromeDriver();
		
		driver.navigate().to("https://www.flipkart.com");
		
		driver.manage().window().maximize();
		
		
	}
	
//	@AfterClass
//public static void afterclass(){
//		driver.quit();
//		
//	}
//	
//	
	@Before
	public void beforemethod() {
			
			System.out.println(java.time.LocalTime.now());
		}
	
	@After
	public void aftermethod() {
			
		System.out.println(java.time.LocalTime.now());
		}
		
	
	
	@Test
	public void method1() {
		
		WebElement log=driver.findElement(By.xpath("//button[text()='✕']"));
		
		log.click();
		
	}
	
	@Test
public void method2() throws Throwable {
		
		WebElement name=driver.findElement(By.xpath("//input[@name='q']"));
		name.sendKeys("Redmi",Keys.ENTER);
		
		Thread.sleep(2000);
		     
		List<WebElement> print = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		List<String> mob = new ArrayList<String>();
		
		System.out.println(print.size());
		
		for (int i=0;i<print.size();i++) {
			
			WebElement element =print.get(i);
			
			String text=element.getText();
			
			System.out.println(text);
			
			
		}
		
		
		File f = new File("C:\\Users\\AR\\eclipse-workspace\\com.junit\\src\\test\\resources\\Book1.xlsx");
		
		FileInputStream f1 = new FileInputStream(f);
		
	  Workbook w =new XSSFWorkbook();
		
		Sheet s= w.createSheet("MobileNames");
		
		for (int i=0;i<print.size();i++) {
			
			Row r =s.createRow(i);
			
		//	Sheet text1=r.getSheet();
			
			Cell c=r.createCell(0);
	
		   //  c.setCellType(i);
		     
		     c.setCellValue(mob.get(i));
		     
		     
			
	
		}
		
	FileOutputStream f2=new FileOutputStream(f);
	
	w.write(f2);
		
	}
	
	@Test
public void method3() throws Throwable {
		Thread.sleep(3000);
	
		WebElement mob=driver.findElement(By.xpath("(//div[@class='_1W9f5C'])[3]"));
		mob.click();
		
		
	}

	@Test
   public void method4() throws Throwable {
		
		Thread.sleep(3000);
		
	Set<String> child=driver.getWindowHandles();
		
		List<String> redmi = new ArrayList<>(child);
		
		driver.switchTo().window(redmi.get(1));
		
		WebElement mobname=driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		
	String text1=	mobname.getText();
	
	System.out.println(text1);
	
	
	
	
	
}

	@Test
public void method5() throws Throwable {
		
		
		WebElement down =driver.findElement(By.xpath("//div[text()='Specifications']"));
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView(true)", down);
		
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		File ip=tk.getScreenshotAs(OutputType.FILE);
		
		File out =new File("C:\\Users\\AR\\eclipse-workspace\\com.junit\\src\\test\\resources/Flipkart");
		
		FileUtils.copyFile(ip,out);
		
		
		
		
	}
	

}
