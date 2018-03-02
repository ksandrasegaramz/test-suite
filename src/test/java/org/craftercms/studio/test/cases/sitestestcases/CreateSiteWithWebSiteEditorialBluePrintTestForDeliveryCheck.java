package org.craftercms.studio.test.cases.sitestestcases;

import org.craftercms.studio.test.cases.StudioBaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

/**
 * 
 * 
 * @author luishernandez
 *
 */

//related to ticket on windows: https://github.com/craftercms/craftercms/issues/1905
public class CreateSiteWithWebSiteEditorialBluePrintTestForDeliveryCheck extends StudioBaseTest {

	private String userName;
	private String password;
	private String siteDropdownElementXPath;

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
	}

	@Test(priority = 0)
	public void createSiteWithWebSiteEditorialBluePrintTestForDeliveryCheck() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		driverManager.waitUntilLoginCloses();

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName("testsitefordeliverytest");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo
		// Select blueprint

		createSitePage.selectWebSiteEditorialBluePrintOption();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(siteDropdownElementXPath);

		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));

		// go to delivery folder and init site for test	
		int exitCode = this.driverManager.goToFolderAndExecuteInitSiteScriptThroughCommandLine(
				"testsitefordeliverytest");
		
		Assert.assertTrue(exitCode == 0,"Init site process failed");
	}
}
