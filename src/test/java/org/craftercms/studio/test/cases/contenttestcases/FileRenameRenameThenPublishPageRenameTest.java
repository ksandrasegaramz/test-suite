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

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.StudioBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author luishernandez
 *
 */
// Test Case Studio- Site Content ID:43
public class FileRenameRenameThenPublishPageRenameTest extends StudioBaseTest {

	private String userName;
	private String password;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElement;
	private String dashboardLink;
	private String editRecentlyContentCreated;
	private String recentActivityContentURL;
	private String recentActivityContentName;
	private String fooContentXpath;
	private String editURLButton;
	private String warningTitle;
	private String warningOkButton;
	private String filenameInput;
	private String selectAllSegmentsCheckBox;
	private String selectEntertaimentCategoryCheckBox;
	private String articlesFolder;
	private String folder2016Locator;
	private String publishOptionXpath;
	private String topNavStatusIcon;
	private String recentlyActivitySelectAll;
	private String recentlyActivityTable;
	private String recentlyActivityItemName;
	private String recentlyActivityItemIcon;
	private String recentlyActivityItemURL;
	private String recentlyActivityItemConfigurationEditedIcon;
	private String recentlyPublishedContentName;
	private String recentlyPublishedContentURL;
	private String recentlyPublishedSelectAll;
	private int numberOfAttemptsForElementsDisplayed;
	private static Logger logger = LogManager.getLogger(FileRenameRenameThenPublishPageRenameTest.class);

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElement = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		dashboardLink = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.dashboard.dashboardlink");
		editRecentlyContentCreated = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.edit.option");
		recentActivityContentURL = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.contenturl");
		recentActivityContentName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.contentname");
		recentlyPublishedContentName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentlypublished.contentname");
		recentlyPublishedContentURL = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentlypublished.contenturl");
		fooContentXpath = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.foocontent");
		editURLButton = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.editurlbutton");
		warningTitle = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame1.warning.warningtitle");
		warningOkButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame1.warning.okbutton");
		filenameInput = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.filenameinput");
		selectAllSegmentsCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_select_all_segments_checkbox");
		selectEntertaimentCategoryCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.select_entertaiment_Category_CheckBox");
		articlesFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		folder2016Locator = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.articles.2016folder");
		fooContentXpath = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.foocontent");
		publishOptionXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("rightclick.approveandpublish.option");
		topNavStatusIcon = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.statustopbaricon");
		recentlyActivitySelectAll = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.selectall");
		recentlyPublishedSelectAll = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentlypublished.selectall");
		recentlyActivityTable = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.tablebody");
		recentlyActivityItemName = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.itemname");
		recentlyActivityItemIcon = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.itemicon");
		recentlyActivityItemURL = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.itemurl");
		recentlyActivityItemConfigurationEditedIcon = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivity.itemconfigurationeditedicon");
		this.numberOfAttemptsForElementsDisplayed = Integer.parseInt(constantsPropertiesManager
				.getSharedExecutionConstants().getProperty("crafter.numberofattemptsforelementdisplayed"));
	}

	public void changeBodyToNotRequiredOnEntryContent() {
		previewPage.changeBodyOfEntryContentPageToNotRequired();
		previewPage.changeDateOfArticlePageToNotRequired();
	}

	public void createNewPageArticle(String folderLocation) {
		logger.info("Create Article Content");
		this.driverManager.waitForAnimation();
		previewPage.createPageArticleContentUsingUploadedImage("foo", "foo", "foo", folderLocation,
				selectEntertaimentCategoryCheckBox, selectAllSegmentsCheckBox, "foo", "foo", "foo");

		this.driverManager.waitUntilSidebarOpens();
	}

	public void changeBodyToNotRequiredOnPageArticleContent() {
		previewPage.changeBodyOfArticlePageToNotRequired();
	}

	public void setup() {
		// login to application
		loginPage.loginToCrafter(userName, password);

		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();

		// body not required
		this.changeBodyToNotRequiredOnPageArticleContent();

		this.driverManager.waitUntilSidebarOpens();
		// expand pages folder
		dashboardPage.expandPagesTree();

		// Expand Home Tree
		this.driverManager.waitForAnimation();
		dashboardPage.expandHomeTree();

		// expand Articles folder
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articlesFolder);
		dashboardPage.expandParentFolder(articlesFolder);

		this.driverManager.waitForAnimation();
		dashboardPage.expandParentFolder(folder2016Locator);

		this.driverManager.waitForAnimation();
		dashboardPage.expandParentFolder(
				folder2016Locator + "/../../../../../div[@class='ygtvchildren']//span[text()='12']");
		this.createNewPageArticle(folder2016Locator + "/../../../../../div[@class='ygtvchildren']//span[text()='12']");

		// reload page
		driverManager.getDriver().navigate().refresh();
		driverManager.waitUntilHomeIsOpened();
		Assert.assertTrue(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath).isDisplayed());

		this.driverManager.contextClick("xpath", fooContentXpath, false);
		driverManager.usingContextMenu(() -> {
			WebElement publishOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					publishOptionXpath);
			publishOption.click();
		}, "Pages");

		// submit
		previewPage.clickOnSubmitButtonOfApprovePublish();
		this.driverManager.waitForAnimation();

		for (int i = 0; i < numberOfAttemptsForElementsDisplayed; i++) {
			try {
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath)
						.click();
				this.driverManager.waitUntilAttributeContains("xpath", topNavStatusIcon, "class", "undefined live");
				break;
			} catch (TimeoutException e) {
				this.driverManager.takeScreenshot("PageNotPublishedOnTopNavBar");
				logger.warn("Content page is not published yet, checking again if it has published icon on top bar");
				driverManager.getDriver().navigate().refresh();
			}
		}

		String elementClassValue = this.driverManager.getDriver().findElement(By.xpath(topNavStatusIcon))
				.getAttribute("class");
		Assert.assertTrue(elementClassValue.contains("undefined live"));

		this.goToDashboardAndCheck();
	}

	public void goToDashboardAndCheck() {
		// click on dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink).click();

		this.driverManager.waitUntilDashboardWidgetsAreLoaded();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", recentlyActivitySelectAll);
		Select categoriesDropDown = new Select(
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyActivitySelectAll));

		categoriesDropDown.selectByValue("all");

		// check items on My Recent Activity widget
		this.driverManager.waitUntilDashboardLoadingAnimationIsNotDisplayedOnRecentActivity();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentActivityContentName);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentActivityContentURL);

		this.driverManager.waitForFullExpansionOfTree();
		List<WebElement> recentActivityItems = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyActivityTable)
				.findElements(By.tagName("tr"));

		for (WebElement webElement : recentActivityItems) {
			this.checkRecentActivityItems(webElement);
		}

	}

	public void checkRecentActivityItems(WebElement element) {
		this.driverManager.waitForAnimation();
		String itemName = element.findElement(By.xpath(recentlyActivityItemName)).getText();
		String itemIconClass = element.findElement(By.xpath(recentlyActivityItemIcon)).getAttribute("class");
		String itemURL = element.findElement(By.xpath(recentlyActivityItemURL)).getText();

		switch (itemName) {
		case "foo":
			boolean itemIconPassAssert = false;
			if (itemIconClass.contains("fa-file-o")) {
				itemIconPassAssert = true;
				Assert.assertTrue(itemURL.equalsIgnoreCase("/articles/2016/12/foo"));
			} else if (itemIconClass.contains("fa-folder-o")) {
				itemIconPassAssert = true;
				Assert.assertTrue(itemURL.equalsIgnoreCase("/site/website/articles/2016/12/foo"));
			}
			Assert.assertTrue(itemIconPassAssert);
			break;
		case "images":
			Assert.assertTrue(itemIconClass.contains("fa-folder-o"));
			Assert.assertTrue(itemURL.equalsIgnoreCase("/static-assets/item/images"));
			break;
		case "item":
			Assert.assertTrue(itemIconClass.contains("fa-folder-o"));
			Assert.assertTrue(itemURL.equalsIgnoreCase("/static-assets/item"));
			break;
		case "testimage.jpg":
			Assert.assertTrue(itemIconClass.contains("fa-file-image-o"));
			Assert.assertTrue(itemURL.contains("/static-assets/item/images/"));
			Assert.assertTrue(itemURL.contains("/testimage.jpg"));
			break;
		case "config.xml":
			itemIconClass = element.findElement(By.xpath(recentlyActivityItemConfigurationEditedIcon))
					.getAttribute("class");
			Assert.assertTrue(itemIconClass.contains("fa-pencil"));
			Assert.assertTrue(itemURL.equalsIgnoreCase("/config/studio/content-types/page/article/config.xml"));
			break;
		case "form-definition.xml":
			itemIconClass = element.findElement(By.xpath(recentlyActivityItemConfigurationEditedIcon))
					.getAttribute("class");
			Assert.assertTrue(itemIconClass.contains("fa-pencil"));
			Assert.assertTrue(
					itemURL.equalsIgnoreCase("/config/studio/content-types/page/article/form-definition.xml"));
			break;
		default:
            this.validateItemNameForStaticAssetsFolders(itemName, itemIconClass, itemURL);
			break;
		}
	}

	public void validateItemNameForStaticAssetsFolders(String itemName, String itemIconClass, String itemURL) {
		String year = this.driverManager.getCurrentYear();
		String month = this.driverManager.getCurrentMonth();
		String day = this.driverManager.getCurrentDay();

		if (itemURL.equalsIgnoreCase("/static-assets/item/images/"+year)){
			Assert.assertTrue(itemIconClass.contains("fa-folder-o"));
			Assert.assertTrue(itemName.equalsIgnoreCase(year));
		}	else if (itemURL.equalsIgnoreCase("/static-assets/item/images/"+year+"/"+month)){
			Assert.assertTrue(itemIconClass.contains("fa-folder-o"));
			Assert.assertTrue(itemName.equalsIgnoreCase(month));
		}
		else if (itemURL.equalsIgnoreCase("/static-assets/item/images/"+year+"/"+month+"/"+day)){
			Assert.assertTrue(itemIconClass.contains("fa-folder-o"));
			Assert.assertTrue(itemName.equalsIgnoreCase(day));
		}
		else {
			Assert.assertTrue(false, "The Item URL is not the correct for the item: "+itemName);
		}
	}

	public void step3() {
		// expand pages folder
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitForAnimation();
		dashboardPage.expandPagesTree();

		// reload page
		driverManager.getDriver().navigate().refresh();
		this.driverManager.waitUntilHomeIsOpened();

		dashboardPage.expandParentFolder(folder2016Locator);

		dashboardPage.expandParentFolder(
				folder2016Locator + "/../../../../../div[@class='ygtvchildren']//span[text()='12']");
	}

	public void step10() {
		// click on dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink).click();
		this.driverManager.waitForAnimation();

		this.dashboardPage.validateItemsOnRecentActivity(true);

	}

	public void step20() {
		// checking if the content was published
		for (int i = 0; i < numberOfAttemptsForElementsDisplayed; i++) {
			try {
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath)
						.click();
				this.driverManager.waitUntilAttributeContains("xpath", topNavStatusIcon, "class", "undefined live");
				break;
			} catch (TimeoutException e) {
				this.driverManager.takeScreenshot("PageNotPublishedOnTopNavBar");
				logger.warn("Content page is not published yet, checking again if it has published icon on top bar");
				driverManager.getDriver().navigate().refresh();
			}
		}

		String elementClassValue = this.driverManager.getDriver().findElement(By.xpath(topNavStatusIcon))
				.getAttribute("class");
		Assert.assertTrue(elementClassValue.contains("undefined live"));

		// click on dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink).click();

		this.driverManager.waitUntilDashboardLoadingAnimationIsNotDisplayedOnRecentlyPublished();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", recentlyPublishedSelectAll);
		Select categoriesDropDown = new Select(
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyPublishedSelectAll));

		categoriesDropDown.selectByValue("all");

		// check items on Recently Published widget
		this.driverManager.waitUntilDashboardLoadingAnimationIsNotDisplayedOnRecentlyPublished();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyPublishedContentName);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyPublishedContentURL);

		Assert.assertTrue(
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyPublishedContentName)
						.getText().contains("foo"));
		Assert.assertTrue(
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", recentlyPublishedContentURL)
						.getText().contains("/articles/2016/12/baz"));
	}

	public void step18() {
		this.driverManager.contextClick("xpath", fooContentXpath, false);
		driverManager.usingContextMenu(() -> {
			WebElement publishOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					publishOptionXpath);
			publishOption.click();
		}, "Pages");
	}

	public void step19() {
		// submit
		previewPage.clickOnSubmitButtonOfApprovePublish();
		this.driverManager.waitForAnimation();
	}

	public void step13() {
		for (int i = 0; i < numberOfAttemptsForElementsDisplayed; i++) {
			try {
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath)
						.click();
				this.driverManager.waitUntilAttributeContains("xpath", topNavStatusIcon, "class", "undefined live");
				break;
			} catch (TimeoutException e) {
				this.driverManager.takeScreenshot("PageNotPublishedOnTopNavBar");
				logger.warn("Content page is not published yet, checking again if it has published icon on top bar");
				driverManager.getDriver().navigate().refresh();
			}
		}

		String elementClassValue = this.driverManager.getDriver().findElement(By.xpath(topNavStatusIcon))
				.getAttribute("class");
		Assert.assertTrue(elementClassValue.contains("undefined live"));
	}

	public void step11() {
		// steps 11, , 12, 13 and 14
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath);
		this.driverManager.contextClick("xpath", fooContentXpath, false);
		driverManager.usingContextMenu(() -> {
			WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					editRecentlyContentCreated);
			editOption.click();
		}, "Pages");

		this.driverManager.waitForAnimation();
		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// check that the edit form was opened
			// step 4
			Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//h1/span")
					.getText().equalsIgnoreCase("foo"));

			// step 5
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", editURLButton).click();

			this.driverManager.getDriver().switchTo().activeElement();
			Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", warningTitle)
					.getText().equalsIgnoreCase("Warning"));

			// step 6
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", warningOkButton)
					.click();

			// step 7
			this.driverManager.waitForAnimation();
			this.driverManager.getDriver().switchTo().activeElement();
			this.driverManager.sendText("xpath", filenameInput, "baz");
			this.driverManager.waitForAnimation();

			// save and close
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", createFormSaveAndCloseElement)
					.click();

		});
		// Step 8 Expected Output
		Assert.assertTrue(this.driverManager.getDriver().getCurrentUrl().contains("/studio/site-dashboard"));

	}

	public void step16() {
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath).click();
		this.driverManager.waitForAnimation();
		Assert.assertTrue(this.driverManager.getDriver().getCurrentUrl().contains("page=/articles/2016/12/baz"));
	}

	public void step17() {
		// click on dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dashboardLink).click();
	}

	@Test(priority = 0)
	public void fileRenamePageRenameRenameAndPublishTest() {
		this.setup();

		this.step3();

		// steps 4, 5, 6, 7 and 8
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath);
		this.driverManager.contextClick("xpath", fooContentXpath, false);
		driverManager.usingContextMenu(() -> {
			WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					editRecentlyContentCreated);
			editOption.click();
		}, "Pages");

		this.driverManager.waitForAnimation();
		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// check that the edit form was opened
			// step 4
			Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//h1/span")
					.getText().equalsIgnoreCase("foo"));

			// step 5
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", editURLButton).click();

			this.driverManager.getDriver().switchTo().activeElement();
			Assert.assertTrue(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", warningTitle)
					.getText().equalsIgnoreCase("Warning"));

			// step 6
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", warningOkButton)
					.click();

			// step 7
			this.driverManager.waitForAnimation();
			this.driverManager.getDriver().switchTo().activeElement();
			this.driverManager.sendText("xpath", filenameInput, "bar");
			this.driverManager.waitForAnimation();

			// save and close
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", createFormSaveAndCloseElement)
					.click();

		});

		// Step 8 Expected Output
		Assert.assertTrue(this.driverManager.getDriver().getCurrentUrl().contains("/studio/site-dashboard"));

		// Step 9
		this.driverManager.waitForFullExpansionOfTree();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", fooContentXpath).click();
		this.driverManager.waitForAnimation();
		Assert.assertTrue(this.driverManager.getDriver().getCurrentUrl().contains("page=/articles/2016/12/bar"));

		// Step 10
		this.step10();
		// Step 11, 12, 13, 14 and 15
		this.step11();
		// Step 16
		this.step16();
		// Step 17
		this.step17();
		// Step 18
		this.step18();
		// Step 19
		this.step19();
		// Step 20
		this.step20();

	}

}
