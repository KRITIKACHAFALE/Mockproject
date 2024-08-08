package Dws;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import Fileutility.ExcelUtility;
import Pom.xml.Facebook;
import Pom.xml.HomePage;
import baseclass.BaseClass_DWS;

public class FacebookDetailstask2 extends BaseClass_DWS{

	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void signUpSocialMedia() throws EncryptedDocumentException, IOException, InterruptedException
	{
		assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		HomePage hPage = new HomePage(driver);
		List<WebElement> links= hPage.socialLink();
		for(WebElement w:links)
		{
			if(w.getText().equalsIgnoreCase("Facebook")) {
				w.click();
			}
		}
		
		int row1 = 0, row2 = 0;
		String dwsID = null;
		 Set<String> ids = driver.getWindowHandles();
		 for (String s : ids) {
			driver.switchTo().window(s);
			
			if("https://demowebshop.tricentis.com/".equalsIgnoreCase(driver.getCurrentUrl())) {
				dwsID = s;
			}
			
			if("https://www.facebook.com/nopCommerce".equalsIgnoreCase(driver.getCurrentUrl()))
			{
				Facebook f = new Facebook(driver);
				
				f.createAccount();
				
				Set<String> id = driver.getWindowHandles();
				
				for (String i : id) {
					
					driver.switchTo().window(i);
					System.out.println(ExcelUtility.getData("DWS_F", 0, 0));
					
					if("https://www.facebook.com/reg/?next=%2FnopCommerce".equalsIgnoreCase(driver.getCurrentUrl())) {
						f.firstName(ExcelUtility.getData("DWS_F", row1++, 0));
						f.lastName(eUtil.getData("DWS_F", row1++, 0));
						f.email(ExcelUtility.getData("DWS_F", row1++, 0));
						f.password(ExcelUtility.getData("DWS_F", row1++, 0));
						f.day(String.valueOf((int)Double.parseDouble(ExcelUtility.getData("DWS_F", row1++, 0))));
						f.month(ExcelUtility.getData("DWS_F", row1++, 0));
						f.year(String.valueOf((int)Double.parseDouble(ExcelUtility.getData("DWS_F", row1++, 0))));
						f.gender();
					}
					
				}
			}
		}
		 Thread.sleep(2000);
		 driver.switchTo().window(dwsID);
	}
}
