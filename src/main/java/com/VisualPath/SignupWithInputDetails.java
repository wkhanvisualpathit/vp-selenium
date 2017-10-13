package com.VisualPath;

/*import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;*/
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

//import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.util.Driver;

public class SignupWithInputDetails extends Driver{

		
	
	static Driver d = new Driver(driver);
    static WebElement Username,Email,Password,ConfirmPassword,SignupSubmit;
    static String title,username,email,password,confirmpassword,homepagetitle,expectedhomepagetitle;
    
	
	public SignupWithInputDetails(ThreadLocal<WebDriver> driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
	}
	
	public static void PageElements()
	{
        d.getDriver().get("http://52.15.72.181:8080/vpath/login");
		
		d.getDriver().findElement(By.xpath("/html/body/div[2]/form/div/h4/a")).click();
		
		 title = 	d.getDriver().findElement(By.xpath("//*[@id='userForm']/h2")).getText();
		//Loading the Page Elements//
		 Username = d.getDriver().findElement(By.id("username"));
		 Email = d.getDriver().findElement(By.id("userEmail"));
		 Password = d.getDriver().findElement(By.id("password"));
		 ConfirmPassword = d.getDriver().findElement(By.id("passwordConfirm"));
		 SignupSubmit = d.getDriver().findElement(By.cssSelector("button[type='submit']"));
	}
	

	@Test
	public static void CreateAccount() throws BiffException, IOException
	{
	 PageElements();
		
	    if(title.equalsIgnoreCase("SIGN UP"))
	      {
		     System.out.println("Please Proceed with Signup");
		     
		     /*FileInputStream f1 = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\TestData\\Excel_TestData.xlsx");*/
		     
		     FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\Testdata\\SignUP_TestData.xls");
		     Workbook w = Workbook.getWorkbook(file);
		     Sheet s = w.getSheet("Sheet1");
		     
		     username = s.getCell(0, 0).getContents();
		     email = s.getCell(1, 0).getContents();
		     password = s.getCell(2, 0).getContents();
		     confirmpassword = s.getCell(3, 0).getContents();
		
				//Passing the Data//
				Username.sendKeys(username);
				Email.sendKeys(email);
				Password.sendKeys(password);
				ConfirmPassword.sendKeys(confirmpassword);
				SignupSubmit.click();
				homepagetitle = d.getDriver().findElement(By.cssSelector("span[class='user-name']")).getText();
				
				System.out.println("title of the home screen  :"+homepagetitle);
				
				if(homepagetitle.equalsIgnoreCase(username))
				{
					System.out.println("User Created Successfully");
				}
				else
				{
					System.out.println("User Creation Failed");
				}
						
	       }
			else
			{
				System.out.println("You are not in Signup Page");
			}
	   teardown();
	}
	
	public static  void teardown()
	 {
		 d.getDriver().close();
	 }



	
	
}
