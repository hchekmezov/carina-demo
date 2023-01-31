package com.qaprosoft.carina.demo.myMobileTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.myMobile.common.*;
import com.qaprosoft.carina.demo.myMobile.enums.BottomBarButton;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyMobileTest implements IMobileUtils, IAbstractTest {

    private static final String PRODUCT = "Apple 13\" MacBook Air";

    @BeforeMethod
    public void openHomePage() {
        StoriesPageBase storiesPage = initPage(getDriver(), StoriesPageBase.class);
        Assert.assertTrue(storiesPage.isOpened(),
                "[Stories Page] Stories Page is not opened!");
        Assert.assertTrue(storiesPage.isCloseButtonPresent(),
                "[Stories Page] Stories Page is not present!");
        storiesPage.clickCloseButton();
        EnablePageBase enablePage = initPage(getDriver(), EnablePageBase.class);
        Assert.assertTrue(enablePage.isOpened(),
                "[Enable Page] Enable Page is not opened!");
        enablePage.clickEnableButton();
        Assert.assertTrue(enablePage.isDontAllowButtonPresent(),
                "[Enable Page] Dont Allow Button is not present after clicking Enable Button!");
        enablePage.clickDontAllowButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(),
                "[Home Page] Home Page is not opened!");
        homePage.clickBestButton();
//      Assert.assertTrue(homePage.isBottomSheetIndicatorPresent(),
//                "[Home Page] Bottom Sheet Indicator is not present while it should be!");
        //homePage.clickBottomSheetIndicator();
    }
    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void homePageTest() throws InterruptedException {
        StoriesPageBase storiesPage = initPage(getDriver(), StoriesPageBase.class);
        Assert.assertTrue(storiesPage.isOpened(),
                "[Stories Page] Stories Page is not opened!");
        Assert.assertTrue(storiesPage.isCloseButtonPresent(),
                "[Stories Page] Stories Page is not present!");
        storiesPage.clickCloseButton();
        EnablePageBase enablePage = initPage(getDriver(), EnablePageBase.class);
        Assert.assertTrue(enablePage.isOpened(),
                "[Enable Page] Enable Page is not opened!");
        enablePage.clickEnableButton();
        Assert.assertTrue(enablePage.isDontAllowButtonPresent(),
                "[Enable Page] Dont Allow Button is not present after clicking Enable Button!");
        enablePage.clickDontAllowButton();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(),
                "[Home Page] Home Page is not opened!");
        homePage.clickBestButton();
//        Assert.assertTrue(homePage.isBottomSheetIndicatorPresent(),
//                "[Home Page] Bottom Sheet Indicator is not present while it should be!");
//        homePage.clickBottomSheetIndicator();
    }
    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void productPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(),
                "[Home Page] Home Page is not opened after initialization!");
        Assert.assertTrue(homePage.isProductBoxPresent(DiscountPercent.SIXTY_PERCENT),
                String.format("[Home Page] There is no any product box with discount %s on Home Page",
                        DiscountPercent.SIXTY_PERCENT.getDiscountPercentStringValue()));
        ProductPageBase productPage = homePage.clickProductBox();
        Assert.assertTrue(productPage.isOpened(),
                "[Product Page] Product page is not opened!");
        Assert.assertTrue(productPage.isSimilarProductsContainerPresent(),
                "[Product Page] Similar Products Container is not present while it should be!");
        Assert.assertTrue(productPage.isSimilarProductBoxPresent(DiscountPercent.SIXTY_PERCENT),
                String.format("[Product Page] Similar Products Container has no any Product Box with %s discount",
                        DiscountPercent.SIXTY_PERCENT.getDiscountPercentStringValue()));
    }

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void findProductTest() throws InterruptedException {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(),
                "[Home Page] Home Page is not opened after initialization!");
        SearchPageBase searchPage = homePage.clickSearchBar();
        Assert.assertTrue(searchPage.isOpened(), "[Search Page] Search Page is not opened!");
        searchPage.clickSearchBar();
        Assert.assertTrue(searchPage.isSearchFieldPresent(),
                "[Search Page] Search Field for typing is not present after clicking on Search Bar!");
        searchPage.typeToSearchField(PRODUCT);
        Assert.assertFalse(searchPage.getBottomBar().isClickable(BottomBarButton.SEARCH),
                "[Bottom Bar] Search Button is clickable while it should not be!");
        ProductPageBase productPage = searchPage.openProductPage();
        Assert.assertTrue(productPage.isOpened(),
                "[Product Page] Product Page is not opened!");
    }

    @Test(enabled = true)
    @MethodOwner(owner = "hchekmezov")
    public void addToFavoritesTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(),
                "[Home Page] Home Page is not opened after initialization!");
        Assert.assertTrue(homePage.isProductBoxPresent(DiscountPercent.SEVENTY_PERCENT),
                String.format("[Home Page] Product Box with %s discount is not present!",
                        DiscountPercent.SEVENTY_PERCENT));
        homePage.clickAddToFavorites();
        Assert.assertTrue(homePage.isAddToFavoritesClicked(),
                "[Home Page] Add To Favorites Button is not clicked!");

    }

}
