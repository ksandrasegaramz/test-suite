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
import org.testng.annotations.AfterMethod;
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
//Test Case Studio- Site Dropdown ID:14
public class VerifyRightClickOptionsOfAnEditedPageUnderPageStructureUsingAdminUser
		extends StudioBaseTest {

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String menuSitesButton;
	private String pagesTreeLink;
	private String pagesTree;
	private String homeContent;
	private String createFormFrameElementCss;
	private String homePageEditedName;
	private String homePageEditedExpand;
	private String menStylesEditedPageName;
	private String menStylesForWinterEditedPageName;
	private String rightClickOptions;

	private String rightclickEditOption;
	private String rightclickViewOption;
	private String rightclickNewContentOption;
	private String rightclickNewFolderOption;
	private String rightclickDeleteOption;
	private String rightclickChangeTemplateOption;
	private String rightclickCutOption;
	private String rightclickCopyOption;
	private String rightclickApproveAndPublishOption;
	private String rightclickDependenciesOption;
	private String rightclickHistoryOption;
	private String styleLandingpage;
	private String rightclickDuplicateOption;
	private String rightclickRenameFolderOption;
	private String articlesFolder;
	private String articlesFolder2017;
	private String articlesFolder1;
	private String articlesFolderMenStylesForWinter;
	private LinkedList<String> rightClickOptionsListInHomePage;
	private LinkedList<String> rightClickOptionsListInCategoryLandingPage;
	private LinkedList<String> rightClickOptionsListInMenStylesForWinterPage;
	private String siteDropdownListElementXPath;
	private static Logger logger = LogManager.getLogger(
			VerifyRightClickOptionsOfAnEditedPageUnderPageStructureUsingAdminUser.class);

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownmenuinnerxpath");
		menuSitesButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.sites.menu.button");
		pagesTreeLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.expandpages");
		pagesTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		homeContent = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page");
		homePageEditedName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.new_home_Content_Page_name_edited");
		menStylesEditedPageName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pagestree.style.landingpage.edited");
		homePageEditedExpand = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.new_home_Content_Page_name_edited_expand");
		menStylesForWinterEditedPageName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pagestree.articlesfolder.menstylesforwinter.page.edited");
		rightclickEditOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.edit.option");
		rightclickViewOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.view.option");
		rightclickNewContentOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.new.Content.option");
		rightclickNewFolderOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.new.folder.option");
		rightclickDeleteOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.delete.option");
		rightclickChangeTemplateOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.change.template.option");
		rightclickCutOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.cut.option");
		rightclickCopyOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.copy.option");
		rightclickApproveAndPublishOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.approveandpublish.option");
		rightclickDependenciesOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.dependenciesoption");
		rightclickHistoryOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.history.option");
		styleLandingpage = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pagestree.style.landingpage");
		rightclickDuplicateOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.duplicate.option");
		rightclickRenameFolderOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.rename.folder.option");
		articlesFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		articlesFolder2017 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articles.folder.2017");
		articlesFolder1 = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articles.folder.2017.1");
		articlesFolderMenStylesForWinter = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articles.folder.2017.1.menstylesforwinter");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		rightClickOptions = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.list.all.options");
		siteDropdownListElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdownlielement");

	}

	public void deleteSite() {

		this.driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", menuSitesButton).click();

		this.homePage.deleteAllSites();
	}

	@AfterMethod
	public void afterTest() {
		deleteSite();
	}

	public void rightClickHomePage() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();

		this.driverManager.waitUntilFolderOpens("xpath", pagesTree);
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homePageEditedName);
		dashboardPage.getDriverManager().contextClick("xpath", homePageEditedName, false);

	}

	public void rightClickCategoryLandingPage() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", menStylesEditedPageName);
		dashboardPage.getDriverManager().contextClick("xpath", menStylesEditedPageName, false);
		this.driverManager.waitForAnimation();
	}

	public void rightClickArticlesFolderMenStylesForWinter() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				menStylesForWinterEditedPageName);
		dashboardPage.getDriverManager().contextClick("xpath", menStylesForWinterEditedPageName, false);
		this.driverManager.waitForAnimation();
	}

	public void verifyEditOptionIsPresent(String section) {
		WebElement rightclickEditOptionElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				rightclickEditOption);
		Assert.assertTrue(rightclickEditOptionElement.isDisplayed(),
				"ERROR: Right click Edit Option is not present on right click of " + section);
	}

	public void verifyViewOptionIsPresent(String section) {
		WebElement rightclickViewOptionElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				rightclickViewOption);
		Assert.assertTrue(rightclickViewOptionElement.isDisplayed(),
				"ERROR: Right click View Option is not present on right click of " + section);
	}

	public void verifyNewContentOptionIsPresent(String section) {
		WebElement rightclickNewContentOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickNewContentOption);
		Assert.assertTrue(rightclickNewContentOptionElement.isDisplayed(),
				"ERROR: Right click New Content Option is not present on right click of " + section);
	}

	public void verifyNewFolderOptionIsPresent(String section) {
		WebElement rightclickNewFolderOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickNewFolderOption);
		Assert.assertTrue(rightclickNewFolderOptionElement.isDisplayed(),
				"ERROR: Right click New Folder Option is not present on right click of " + section);
	}

	public void verifyDeleteOptionIsPresent(String section) {
		WebElement rightclickDeleteOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickDeleteOption);
		Assert.assertTrue(rightclickDeleteOptionElement.isDisplayed(),
				"ERROR: Right click Delete Option is not present on right click of " + section);
	}

	public void verifyChangeTemplateOptionIsPresent(String section) {
		WebElement rightclickChangeTemplateOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickChangeTemplateOption);
		Assert.assertTrue(rightclickChangeTemplateOptionElement.isDisplayed(),
				"ERROR: Right click Change Template Option is not present on right click of " + section);
	}

	public void verifyCutOptionIsPresent(String section) {
		WebElement rightclickCutOptionElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				rightclickCutOption);
		Assert.assertTrue(rightclickCutOptionElement.isDisplayed(),
				"ERROR: Right click Cut Option is not present on right click of " + section);
	}

	public void verifyCopyOptionIsPresent(String section) {
		WebElement rightclickCopyOptionElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				rightclickCopyOption);
		Assert.assertTrue(rightclickCopyOptionElement.isDisplayed(),
				"ERROR: Right click Copy Option is not present on right click of " + section);
	}

	public void verifyApproveAndPublishOptionIsPresent(String section) {
		WebElement rightclickApproveAndPublishOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickApproveAndPublishOption);
		Assert.assertTrue(rightclickApproveAndPublishOptionElement.isDisplayed(),
				"ERROR: Right click Approve and Publish Option is not present on right click of " + section);
	}

	public void verifyDependenciesOptionIsPresent(String section) {
		WebElement rightclickDependenciesOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickDependenciesOption);
		Assert.assertTrue(rightclickDependenciesOptionElement.isDisplayed(),
				"ERROR: Right click Dependencies Option is not present on right click of " + section);
	}

	public void verifyHistoryOptionIsPresent(String section) {
		WebElement rightclickHistoryOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickHistoryOption);
		Assert.assertTrue(rightclickHistoryOptionElement.isDisplayed(),
				"ERROR: Right click History Option is not present on right click of " + section);
	}

	public void verifyDuplicateOptionIsPresent(String section) {
		WebElement rightclickDuplicateOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickDuplicateOption);
		Assert.assertTrue(rightclickDuplicateOptionElement.isDisplayed(),
				"ERROR: Right click Duplicate Option is not present on right click of " + section);
	}

	public void verifyRenameFolderOptionIsPresent(String section) {
		WebElement rightclickRenameFolderOptionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", rightclickRenameFolderOption);
		Assert.assertTrue(rightclickRenameFolderOptionElement.isDisplayed(),
				"ERROR: Right click Rename Folder Option is not present on right click of " + section);
	}

	public void createWebEditorialSite() {

		// Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Filling the name of site
		createSitePage.fillSiteName();

		// Filling the description of the site
		createSitePage.fillDescription("Description");

		// Open blueprint combo
		// Select blueprint
		createSitePage.selectWebSiteEditorialBluePrintOption();

		// Click on Create button
		createSitePage.clickOnCreateSiteButton();
	}

	public void step4() {
		// Step 4 Right Right click on "Home" and verify options
		this.rightClickHomePage();

		driverManager.usingContextMenu(() -> {
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInHomePage = new LinkedList<String>();
			rightClickOptionsListInHomePage.add(0, "Edit");
			rightClickOptionsListInHomePage.add(1, "View");
			rightClickOptionsListInHomePage.add(2, "New Content");
			rightClickOptionsListInHomePage.add(3, "New Folder");
			rightClickOptionsListInHomePage.add(4, "Delete");
			rightClickOptionsListInHomePage.add(5, "Change Template");
			rightClickOptionsListInHomePage.add(6, "Cut");
			rightClickOptionsListInHomePage.add(7, "Copy");
			rightClickOptionsListInHomePage.add(8, "Approve & Publish");
			rightClickOptionsListInHomePage.add(9, "Dependencies");
			rightClickOptionsListInHomePage.add(10, "History");

			List<WebElement> rightClickOptionsList = this.driverManager.getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilSidebarOpens();
				Assert.assertTrue(element.getText().equals(rightClickOptionsListInHomePage.get(currentIndex)),
						"ERROR: Link Option: " + element.getText()
								+ " is not in the correct order in the HomePage, check that the correct options are listed");
				currentIndex++;
			}

			String section = "Step 4 Right Click on 'Home'";

			verifyEditOptionIsPresent(section);
			verifyViewOptionIsPresent(section);
			verifyNewContentOptionIsPresent(section);
			verifyNewFolderOptionIsPresent(section);
			verifyDeleteOptionIsPresent(section);
			verifyChangeTemplateOptionIsPresent(section);
			verifyCutOptionIsPresent(section);
			verifyCopyOptionIsPresent(section);
			verifyApproveAndPublishOptionIsPresent(section);
			verifyDependenciesOptionIsPresent(section);
			verifyHistoryOptionIsPresent(section);

			this.driverManager.getDriver().navigate().refresh();
			this.driverManager.waitForAnimation();
			this.driverManager.waitUntilSidebarOpens();
		},"Pages");
	}

	public void step6() {
		// Step 6 Right click on any Category Landing page and verify options
		this.rightClickCategoryLandingPage();
		
		driverManager.usingContextMenu(() -> {
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInCategoryLandingPage = new LinkedList<String>();
			rightClickOptionsListInCategoryLandingPage.add(0, "Edit");
			rightClickOptionsListInCategoryLandingPage.add(1, "View");
			rightClickOptionsListInCategoryLandingPage.add(2, "New Content");
			rightClickOptionsListInCategoryLandingPage.add(3, "New Folder");
			rightClickOptionsListInCategoryLandingPage.add(4, "Delete");
			rightClickOptionsListInCategoryLandingPage.add(5, "Change Template");
			rightClickOptionsListInCategoryLandingPage.add(6, "Cut");
			rightClickOptionsListInCategoryLandingPage.add(7, "Copy");
			rightClickOptionsListInCategoryLandingPage.add(8, "Duplicate");
			rightClickOptionsListInCategoryLandingPage.add(9, "Approve & Publish");
			rightClickOptionsListInCategoryLandingPage.add(10, "Dependencies");
			rightClickOptionsListInCategoryLandingPage.add(11, "History");

			List<WebElement> rightClickOptionsList = this.driverManager.getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilSidebarOpens();
				Assert.assertTrue(
						element.getText().equals(rightClickOptionsListInCategoryLandingPage.get(currentIndex)),
						"ERROR: Link Option: " + element.getText()
								+ " is not in the correct order in the selected category landing page, check that the correct options are listed");
				currentIndex++;
			}

			String section = "Step 6 Right click on a 'Category Landing' page";

			verifyEditOptionIsPresent(section);
			verifyViewOptionIsPresent(section);
			verifyNewContentOptionIsPresent(section);
			verifyNewFolderOptionIsPresent(section);
			verifyDeleteOptionIsPresent(section);
			verifyChangeTemplateOptionIsPresent(section);
			verifyCutOptionIsPresent(section);
			verifyCopyOptionIsPresent(section);
			verifyDuplicateOptionIsPresent(section);
			verifyApproveAndPublishOptionIsPresent(section);
			verifyDependenciesOptionIsPresent(section);
			verifyHistoryOptionIsPresent(section);

			this.driverManager.getDriver().navigate().refresh();
			this.driverManager.waitForAnimation();
		},"Pages");
	}

	public void step8() {
		// Step 8 Click on the + of folder 2017
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder2017);

		this.driverManager.waitUntilContentTooltipIsHidden();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder2017).click();
		this.driverManager.waitUntilFolderOpens("xpath", articlesFolder2017);
	}

	public void step10() {
		// Step 10 Right click on any of the article (Men Styles For Winter)
		this.driverManager.waitForAnimation();

		this.rightClickArticlesFolderMenStylesForWinter();

		driverManager.usingContextMenu(() -> {
			
			logger.info("Checking that only the expected options are listed");
			rightClickOptionsListInMenStylesForWinterPage = new LinkedList<String>();
			rightClickOptionsListInMenStylesForWinterPage.add(0, "Edit");
			rightClickOptionsListInMenStylesForWinterPage.add(1, "View");
			rightClickOptionsListInMenStylesForWinterPage.add(2, "New Content");
			rightClickOptionsListInMenStylesForWinterPage.add(3, "New Folder");
			rightClickOptionsListInMenStylesForWinterPage.add(4, "Delete");
			rightClickOptionsListInMenStylesForWinterPage.add(5, "Change Template");
			rightClickOptionsListInMenStylesForWinterPage.add(6, "Cut");
			rightClickOptionsListInMenStylesForWinterPage.add(7, "Copy");
			rightClickOptionsListInMenStylesForWinterPage.add(8, "Duplicate");
			rightClickOptionsListInMenStylesForWinterPage.add(9, "Approve & Publish");
			rightClickOptionsListInMenStylesForWinterPage.add(10, "Dependencies");
			rightClickOptionsListInMenStylesForWinterPage.add(11, "History");

			List<WebElement> rightClickOptionsList = this.driverManager.getDriver()
					.findElements(By.xpath(rightClickOptions));
			int currentIndex = 0;
			for (WebElement element : rightClickOptionsList) {
				this.driverManager.waitForAnimation();
				this.driverManager.waitUntilSidebarOpens();
				Assert.assertTrue(
						element.getText().equals(rightClickOptionsListInMenStylesForWinterPage.get(currentIndex)),
						"ERROR: Link Option: " + element.getText()
								+ " is not in the correct order in the Men Styles For Witner page, check that the correct options are listed");
				currentIndex++;
			}

			String section = "Step 11 Right click on folder articles -2017- 1- Men Styles For Winter;";

			verifyEditOptionIsPresent(section);
			verifyViewOptionIsPresent(section);
			verifyNewContentOptionIsPresent(section);
			verifyNewFolderOptionIsPresent(section);
			verifyDeleteOptionIsPresent(section);
			verifyChangeTemplateOptionIsPresent(section);
			verifyCutOptionIsPresent(section);
			verifyCopyOptionIsPresent(section);
			verifyDuplicateOptionIsPresent(section);
			verifyApproveAndPublishOptionIsPresent(section);
			verifyDependenciesOptionIsPresent(section);
			verifyHistoryOptionIsPresent(section);

			this.driverManager.getDriver().navigate().refresh();
			this.driverManager.waitForAnimation();
		},"Pages");

	}

	public void editHomePage() {
		// Step 3 Edit the Home Page and Save
this.driverManager.waitForAnimation();
		dashboardPage.rightClickEditOnAPresentPage(homeContent);

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "HomePageEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("Xpath", homePageEditedName);

	}

	public void editLandingPageStylePage() {

		dashboardPage.rightClickEditOnAPresentPage(styleLandingpage);

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "StylePageEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("Xpath", menStylesEditedPageName);

	}

	public void editMenStylesForWinterPage() {

		dashboardPage.rightClickEditOnAPresentPage(articlesFolderMenStylesForWinter);

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// creating random values for URL field and InternalName field

			String randomInternalName = "MenStylesForWinterEdited";

			// Set basics fields of the new content created

			dashboardPage.editInternalName(randomInternalName);
		});

		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("Xpath", menStylesForWinterEditedPageName);

	}

	public void expandHomeTree() {
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();

		// Verify if the home tree is already expanded
		if (!(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", homePageEditedName)
				.getAttribute("class").contains("open"))) {
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homePageEditedExpand)
					.click();
		}

	}

	@Test(priority = 0)
	public void verifyRightClickOptionsOfAnEditedPageUnderPageStructureUsingAdminUser() {

		logger.info("login to application");

		loginPage.loginToCrafter(userName, password);

		this.createWebEditorialSite();

		logger.info("Step 2 Expand the site bar");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath);
		if (this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
				.isDisplayed()) {
			if (!(this.driverManager.waitUntilElementIsPresent("xpath", siteDropdownListElementXPath)
					.getAttribute("class").contains("site-dropdown-open")))
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath)
						.click();
		}else
				throw new NoSuchElementException(
						"Site creation process is taking too long time and the element was not found");
		
		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));

		logger.info("Step 3 Click on Pages tree and Edit Home Page");
		WebElement pagesTreeLinkElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				pagesTreeLink);
		pagesTreeLinkElement.click();
		this.driverManager.waitUntilFolderOpens("xpath", pagesTreeLink);

		logger.info("Edit the home page");
		this.editHomePage();

		logger.info("Step 4 Right Right click on Home and verify options");
		this.step4();

		logger.info("Step 5 Click on the + of Home tree and Edit Home Page");
		this.expandHomeTree();

		logger.info("Step 6 Right click on any Category Landing page style and verify options");
		this.editLandingPageStylePage();

		this.step6();

		logger.info("Step 7 Click on the + of Articles tree");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);

		this.driverManager.waitUntilContentTooltipIsHidden();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder).click();
		this.driverManager.waitUntilFolderOpens("xpath", articlesFolder);

		logger.info("Step 8 Click on the + of folder 2017");
		this.step8();

		logger.info(
				"Step 9 Click on the + of folder 1 and Edit then article page Men Styles For Winter under articles/2017/1");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder1).click();
		this.driverManager.waitUntilFolderOpens("xpath", articlesFolder1);

		this.editMenStylesForWinterPage();

		logger.info("Step 10 Right click on any of the article Men Styles For Winter");
		this.step10();
	}
}
