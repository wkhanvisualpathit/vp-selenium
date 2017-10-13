package com.VisualPath;

/*import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;*/
//import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.util.Driver;

public class SignupWithOutInputDetails extends Driver{

		
	
	static Driver d = new Driver(driver);
    static WebElement Username,Email,Password,ConfirmPassword,SignupSubmit;
    static String title,username,email,password,confirmpassword,ErrorMessage,expectedhomepagetitle;
    
	
	public SignupWithOutInputDetails(ThreadLocal<WebDriver> driver) {
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
	public static void CreateAccountWithoutdata()
	{
	 PageElements();
		
	    if(title.equalsIgnoreCase("SIGN UP"))
	      {
		     System.out.println("Please Proceed with Signup");
		     
		     username = "satish3456";
		     email = "satish.m@kkk.com";
		     password = "12345678";
		     confirmpassword = "12345678";
		
				//Passing the Data//
				Username.sendKeys("");
				Email.sendKeys("");
				Password.sendKeys("");
				ConfirmPassword.sendKeys("");
				SignupSubmit.click();
				ErrorMessage = d.getDriver().findElement(By.cssSelector("span[id='username.errors']")).getText();
				
				
				
				if(ErrorMessage.contains("This field is required"))
				{
					System.out.println("Please enter the required data to finish the Creation");
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
