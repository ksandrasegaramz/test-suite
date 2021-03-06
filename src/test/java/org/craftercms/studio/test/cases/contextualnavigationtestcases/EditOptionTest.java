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
package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditOptionTest extends StudioBaseTest {

	private static final Logger logger = LogManager.getLogger(EditOptionTest.class);

	private String userName;
	private String password;
	private String adminConsoleXpath;
	private String entryContentTypeBodyXpath;
	private String entryContentTypeBodyCheckCss;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElement;
	private String createFormExpandAll;
	private String createFormMainTitleElementXPath;
	private String testingContentItem;
	private String topNavEditOption;
	private String siteDropDownXpath;
	private String crafterLogoId;
	private String testingItemEditedXpath;

	private String siteDropdownListElementXPath;

	private String lastPropertiesElementCssSelector;
	
	
	@BeforeMethod
	public void beforeTest() {
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		adminConsoleXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElement = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormExpandAll= uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformexpandall");
		createFormMainTitleElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformMainTitle");
		testingContentItem = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.testingcontentitem");
		topNavEditOption= uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		siteDropDownXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		crafterLogoId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.studiologo");
		testingItemEditedXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.testingcontentitemedited.sitecontent");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");
		lastPropertiesElementCssSelector = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.propertiesdivlastelement");
	}

	public void bodyNotRequiered() {
		logger.info("Changing body to not required");
		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", adminConsoleXpath).click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.waitForAnimation();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", entryContentTypeBodyXpath).click();
		

		// Body not required
		this.driverManager.waitForAnimation();
		this.driverManager.focusAndScrollDownToBottomInASection("#properties-container",lastPropertiesElementCssSelector);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				entryContentTypeBodyCheckCss).click();

		// save
		siteConfigPage.saveDragAndDropProcess();


	}

	public void createNewContent() {
		logger.info("Creating new content");
		// right click to see the the menu
		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.usingCrafterForm("cssselector", createFormFrameElementCss, () -> {
			// Set basics fields of the new content created
			dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

			// Expand all fields
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", createFormExpandAll)
				.click();

			// Set the title of main content
			driverManager.sendText("xpath", createFormMainTitleElementXPath, "MainTitle");

			// save and close
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", createFormSaveAndCloseElement).click();

		});
	}

	public void editingContent() {
		logger.info("Editing existing content");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", testingContentItem)
				.click();

		// click edit option of the menu
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",topNavEditOption).click();

		this.driverManager.waitForAnimation();
		
		// Switch to the iframe
		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// edit internal title
			dashboardPage.editInternalName("EDITED");
		});
	}

	@Test(priority = 0)
	public void verifyTheEditionOfAPageUsingContextualNavigationEditOptionTest() {
		logger.info("Starting test case");
		// login to application

		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
				.getAttribute("class").contains("site-dropdown-open")))
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropDownXpath)
				.click();
		
		// Body Not requiered
		bodyNotRequiered();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", crafterLogoId).click();
		
		dashboardPage.expandPagesTree();

		// create a new content
		createNewContent();
		
		//reload page
        driverManager.getDriver().navigate().refresh();
		
		dashboardPage.expandHomeTree();

		// wait for element is clickeable
		editingContent();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// Assert find the new content created edited
		driverManager.waitUntilElementIsDisplayed("xpath", testingItemEditedXpath);
		 Assert.assertTrue(this.driverManager.isElementPresentByXpath(testingItemEditedXpath));

	}

}
