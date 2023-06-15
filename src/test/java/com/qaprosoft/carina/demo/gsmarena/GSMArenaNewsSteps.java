package com.qaprosoft.carina.demo.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class GSMArenaNewsSteps implements IDriverPool {

    @Given("^I am on main page$")
    public boolean iAmOnMainPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        return !homePage.isPageOpened();
    }

    @When("I open 'News' page")
    public NewsPage iOpenNewsPage() {
        HomePage homePage = new HomePage(getDriver());
        return homePage.getFooterMenu().openNewsPage();
    }
    @Then("page 'News' should be open")
    public boolean pageShouldBeOpen() {
        return (new NewsPage(getDriver()).isPageOpened());
    }
    @And("page 'News' should contains all items")
    public void pageShouldContainsAllItems() {
        final String searchQ = "iphone";
        NewsPage newsPage = new NewsPage(getDriver());
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        SoftAssert softAssert = new SoftAssert();
        for(NewsItem n : news) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();

    }
}

