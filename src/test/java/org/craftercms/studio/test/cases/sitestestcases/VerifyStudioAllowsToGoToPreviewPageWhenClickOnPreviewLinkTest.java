/*
 * Copyright (C) 2007-2018 Crafter Software Corporation. All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.test.cases.sitestestcases;

import org.craftercms.studio.test.cases.StudioBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author luishernandez
 *
 */

// Test Case Studio- Sites ID:8
public class VerifyStudioAllowsToGoToPreviewPageWhenClickOnPreviewLinkTest extends StudioBaseTest {

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String testSiteID;

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");

		testSiteID = "websiteeditorialtest";
	}

	public void createSiteUsingWebSiteEditorialBluePrint() {
		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName(testSiteID);

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Select empty blueprint

		createSitePage.selectWebSiteEditorialBluePrintOption();

		// Click on Create button
		createSitePage.clickOnCreateSiteButton();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteDropdownElementXPath);

		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteDropdownElementXPath)
				.isDisplayed());

		dashboardPage.clickOnSitesOption();
	}

	public void setup() {
		// login to application
		loginPage.loginToCrafter(userName, password);

		driverManager.waitUntilLoginCloses();

		this.createSiteUsingWebSiteEditorialBluePrint();
	}

	public void step3() {
		this.homePage.goToPreviewPage();

		Assert.assertTrue(this.driverManager.getDriver().getCurrentUrl()
				.contains("/studio/preview/#/?page=/&site=" + testSiteID));
	}

	@Test(priority = 0)
	public void verifyStudioAllowsToGoToPreviewPageWhenClickOnPreviewLinkTest() {
		this.setup();

		this.step3();
	}
}
