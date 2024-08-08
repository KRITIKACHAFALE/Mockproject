package Pom.xml;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	public Home(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	private @FindBy(linkText = "Organizations")
	WebElement org;
	public WebElement getOrganizations()
	{
		return org;
	}
	public void organizations()
	{
		org.click();
	}
	
	private @FindBy(linkText = "Contacts")
	WebElement contact;
	public WebElement getContacts()
	{
		return contact;
	}
	public void contacts()
	{
		contact.click();
	}
	
	private @FindBy(xpath = "(//td[@class='small'])[2]/img")
	WebElement profile;
	public WebElement getProfile()
	{
		return profile;
	}
	
	private @FindBy(partialLinkText = "Sign Out")
	WebElement signOut;
	public WebElement getSignOut()
	{
		return signOut;
	}
	
	
	public void logout(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(getProfile()).perform();
		getSignOut().click();
	}
}

