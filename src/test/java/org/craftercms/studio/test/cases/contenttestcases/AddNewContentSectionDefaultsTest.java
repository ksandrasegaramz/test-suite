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
package org.craftercms.studio.test.cases.contenttestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class AddNewContentSectionDefaultsTest extends StudioBaseTest {

	private String userName;
	private String password;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElement;
	private String siteDropDownXpath;
	private String sectionDefaultsXpath;
	private String siteDropdownListElementXPath;
	private static Logger logger = LogManager.getLogger(AddNewContentSectionDefaultsTest.class);
	

	@BeforeMethod
	public void beforeTest() {
			
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElement = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		siteDropDownXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		sectionDefaultsXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.sectiondefaults");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");
	}

	public void createLevelDescriptorContent() {
		
		// right click to see the the menu
		dashboardPage.rightClickToSeeMenu();
		
		// create a content with level descriptor content type
		// right click to see the the menu
		dashboardPage.selectLDCT(); 

		// Select Entry Content Type
		dashboardPage.clickLevelDescriptorCT();

		// Confirm the Content Type selected
		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", createFormFrameElementCss));

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", createFormSaveAndCloseElement).click();

	
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		// reload page
		driverManager.getDriver().navigate().refresh();
	}

	@Test(priority = 0)
	public void addLevelDescriptorItemUsingContextualClickOptionsTest() {

		// login to application
		logger.info("Login into Crafter");
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page closes
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
				.getAttribute("class").contains("site-dropdown-open")))
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", siteDropDownXpath)
				.click();

		// expand pages folder
		logger.info("Expanding pages folder");
		dashboardPage.expandPagesTree();
		
		// Expand Home Tree
		logger.info("Expanding Home Tree");
		this.driverManager.waitForAnimation();
		dashboardPage.expandHomeTree();

		// Create level descriptor content
		logger.info("Creating level Descriptor content");
		createLevelDescriptorContent();

		// Assert of the test case is fine
		String levelDescriptor = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", sectionDefaultsXpath).getText();

		logger.info("Verify Level Descriptor was created");
		Assert.assertTrue(levelDescriptor.contains("Section Defaults"),
				"Level descriptors are not the same, check if the level descriptor was succesfully created");

	}

}