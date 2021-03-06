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
package org.craftercms.studio.test.cases.sitedropdowntestcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * 
 * 
 * @author Juan Camacho A
 *
 */
// Test Case Studio- Site Dropdown ID:3
public class VerifyTheSideBarDropdownOptionsUsingWebEditorialBlueprintWithAuthorUser extends StudioBaseTest {

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String menuSitesButton;
	private String dashboardLink;
	private String pagesTreeLink;
	private String componentsTreeLink;
	private String taxonomyTreeLink;
	private String staticAssetsTreeLink;
	private String templatesTreeLink;
	private String scriptsTreeLink;
	private LinkedList<String> siteDropdownItemsInExpectedOrder;
	private String siteDropdownItemsXpath;
	private String createSiteButton;
	private String newUserUserNameCreatedXpath;
	private String crafterLogo;
	private String expandPagesTree;
	private String adminConsole;
	private String siteconfigGroupsOption;
	private String addTouserIframe;
	private String editAuthorGroupOption;
	private String groupsAddNewMembersCheckbox;
	private String groupsAddNewMembersInput;
	private String groupsAddNewMembersAutocompleteOption1;
	private String groupsAddNewMembersButton;
	private String navigationSitebarNameId;
	private String userOptions;
	private String userOptionsLogout;
	private String siteDropdownListElementXPath;
	private static Logger logger = LogManager
			.getLogger(VerifyTheSideBarDropdownOptionsUsingWebEditorialBlueprintWithAuthorUser.class);

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownmenuinnerxpath");
		menuSitesButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.sites.menu.button");
		dashboardLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.dashboard_menu_option");
		pagesTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.expandpages");
		componentsTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_components_tree");
		taxonomyTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_taxonomy_tree");
		staticAssetsTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		templatesTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_templates_tree");
		scriptsTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_scripts_tree");
		siteDropdownItemsXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.sitebar.dropdown.items");
		createSiteButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.createsitebutton");
		newUserUserNameCreatedXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.authorusernamecreated");
		crafterLogo = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("users.crafterlogo");
		expandPagesTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		adminConsole = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.adminconsole");
		siteconfigGroupsOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.groups_option");
		addTouserIframe = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.adduser.iframe");
		editAuthorGroupOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.edit_author_group_option");
		groupsAddNewMembersCheckbox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_checkbox");
		groupsAddNewMembersInput = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_input");
		groupsAddNewMembersAutocompleteOption1 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_autocomplete_option1");
		groupsAddNewMembersButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("groups.add_new_members_button");
		navigationSitebarNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.navigation_sitebar_name_id");
		userOptions = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.user_options");
		userOptionsLogout = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");
		siteDropdownItemsInExpectedOrder = new LinkedList<String>();
		siteDropdownItemsInExpectedOrder.add(0, "Dashboard");
		siteDropdownItemsInExpectedOrder.add(1, "Pages");
		siteDropdownItemsInExpectedOrder.add(2, "Components");
		siteDropdownItemsInExpectedOrder.add(3, "Taxonomy");
		siteDropdownItemsInExpectedOrder.add(4, "Static Assets");
		siteDropdownItemsInExpectedOrder.add(5, "Templates");
		siteDropdownItemsInExpectedOrder.add(6, "Scripts");

	}

	public void deleteSite() {

		this.driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", menuSitesButton).click();

		// Click on Delete icon
		homePage.clickOnDeleteSiteIcon();

		// Click on YES to confirm the delete.
		homePage.clickOnYesToDeleteSite();

		// Refresh the page
		driverManager.getDriver().navigate().refresh();

	}

	private void goToSiteContentPagesStructure() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				createSiteButton);

		this.driverManager.waitForAnimation();
		homePage.goToPreviewPage();

		this.driverManager.waitForAnimation();
		if (this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
				.isDisplayed()) {
			if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
					.getAttribute("class").contains("site-dropdown-open")))
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
						.click();
		}else
				throw new NoSuchElementException(
						"Site creation process is taking too long time and the element was not found");

	}

	public void login(String user, String loginpassword) {

		// login to application

		loginPage.loginToCrafter(user, loginpassword);

		// Wait for login page to close

		driverManager.waitUntilLoginCloses();

	}

	public void addNewUser() {

		// click On Users option

		createSitePage.clickOnUsersOption();

		usersPage.addNewUser("author");

		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newUserUserNameCreatedXpath);

		Assert.assertTrue(newUserCreated.isDisplayed(), "ERROR: Recently created user is not displayed");

		// Switch to the form

		driverManager.getDriver().navigate().refresh();

		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.waitForAnimation();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				crafterLogo);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				crafterLogo).click();
	}

	public void addUserToAuthorGroup() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", adminConsole);

		WebElement siteConfigButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				adminConsole);

		siteConfigButton.click();

		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption).click();

		this.driverManager.waitForAnimation();
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.getDriver().switchTo()

				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", addTouserIframe));

		this.driverManager.isElementPresentAndClickableByXpath(addTouserIframe);

		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				editAuthorGroupOption);

		this.driverManager

				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", editAuthorGroupOption)

				.click();

		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.getDriver().switchTo()

				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", addTouserIframe));

		this.driverManager.isElementPresentAndClickableByXpath(addTouserIframe);

		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox)

				.click();

		this.driverManager

				.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersInput)

				.sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",

				groupsAddNewMembersAutocompleteOption1);

		this.driverManager

				.driverWaitUntilElementIsPresentAndDisplayed("xpath",

						groupsAddNewMembersAutocompleteOption1)

				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				groupsAddNewMembersButton);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",

				groupsAddNewMembersButton).click();

		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", navigationSitebarNameId);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", navigationSitebarNameId)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", adminConsole);

	}

	private void logoutFromCrafter() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout).click();

	}

	@Test(priority = 0)
	public void verifyTheSideBarDropdownOptionsUsingWebEditorialBlueprintWithAuthorUser() {

		this.login(userName, password);

		logger.info("Adding New User");

		this.addNewUser();

		logger.info("Go to Site Preview");

		this.goToSiteContentPagesStructure();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", expandPagesTree);

		this.driverManager.waitUntilSidebarOpens();

		logger.info("Add previous created user to Author Group");

		this.addUserToAuthorGroup();

		// logout from Crafter
		logger.info("logout from Crafter");
		this.logoutFromCrafter();

		// login to application with author user
		logger.info("login to application with author user");
		loginPage.loginToCrafter("author", "author");

		driverManager.waitUntilLoginCloses();

		logger.info("Go to Preview Page");
		this.homePage.goToPreviewPage();

		this.driverManager.waitForAnimation();

		// Expand the site bar
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath);

		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));

		// Check all the section are present;
		WebElement dashboardLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				dashboardLink);
		Assert.assertTrue(dashboardLinkElement.isDisplayed(), "ERROR: Dashboard link is not present");

		WebElement pagesTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				pagesTreeLink);
		Assert.assertTrue(pagesTreeLinkElement.isDisplayed(), "ERROR: Pages Tree link is not present");

		WebElement componentsTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				componentsTreeLink);
		Assert.assertTrue(componentsTreeLinkElement.isDisplayed(), "ERROR: Components Tree link is not present");

		WebElement taxonomyTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				taxonomyTreeLink);
		Assert.assertTrue(taxonomyTreeLinkElement.isDisplayed(), "ERROR: Taxonomy Tree link is not present");

		WebElement staticAssetsTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				staticAssetsTreeLink);
		Assert.assertTrue(staticAssetsTreeLinkElement.isDisplayed(), "ERROR: Static Assets Tree link is not present");

		WebElement templatesTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				templatesTreeLink);
		Assert.assertTrue(templatesTreeLinkElement.isDisplayed(), "ERROR: Templates Tree link is not present");

		WebElement scriptsTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				scriptsTreeLink);
		Assert.assertTrue(scriptsTreeLinkElement.isDisplayed(), "ERROR: Scripts Tree link is not present");

		List<WebElement> siteDropdownItems = this.driverManager.getDriver()
				.findElements(By.xpath(siteDropdownItemsXpath));
		int currentIndex = 0;
		for (WebElement element : siteDropdownItems) {
			this.driverManager.waitForAnimation();
			this.driverManager.waitUntilSidebarOpens();
			Assert.assertTrue(element.getText().equals(siteDropdownItemsInExpectedOrder.get(currentIndex)),
					"ERROR: Link Option: " + element.getText() + " is not in the correct order");
			currentIndex++;
		}
	}
}
