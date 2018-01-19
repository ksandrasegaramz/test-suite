package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro
 */

public class CreateSiteAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private String siteId="siteTestCreateSiteAPITest";

	public CreateSiteAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		
	}

	@Test(priority = 1,groups={"createSite"})
	public void testCreateSite() {
		siteManagementAPI.testCreateSite(siteId);
	}

	@Test(priority = 2,groups={"createSite"})
	public void testCreateSiteInvalidParameters() {
		siteManagementAPI.testCreateSiteInvalidParameters();
	}

	@Test(priority = 3,groups={"createSite"})
	public void testSiteAlreadyExists() {
		siteManagementAPI.testCreateSiteSiteAlreadyExists();
	}

	@AfterGroups(groups={"createSite"})
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}

	@Test(dependsOnGroups={"createSite"})
	public void testCreateSiteUnauthorized(){
		
		siteManagementAPI.testCreateSiteUnauthorized(siteId);
	}
}
