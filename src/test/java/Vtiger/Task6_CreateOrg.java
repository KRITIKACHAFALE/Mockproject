package Vtiger;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Fileutility.ExcelUtility;
import JavaUtility.JavaUtil;
import Pom.xml.Home;
import Pom.xml.Organizations;
import baseclass.BaseClass_Vtiger;



public class Task6_CreateOrg extends BaseClass_Vtiger{

	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		Home h = new Home(driver);
		h.organizations();
		
		int row = 0;
		Organizations org = new Organizations(driver);
		org.plusIcon();
		String orgName= eUtil.getData("Org", row++, 0);
		org.organizationName(orgName+JavaUtil.generateRandomNumber(1000));
		org.group();
		org.assignedto(eUtil.getData("Org", row++, 0));
		org.saveBtn();
		
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
	}
}
