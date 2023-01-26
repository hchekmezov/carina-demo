package com.qaprosoft.carina.demo.myMobileTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.myMobile.common.EnablePageBase;
import com.qaprosoft.carina.demo.myMobile.common.HomePageBase;
import com.qaprosoft.carina.demo.myMobile.common.ProductPageBase;
import com.qaprosoft.carina.demo.myMobile.common.StoriesPageBase;
import com.qaprosoft.carina.demo.myMobile.enums.DiscountPercent;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyMobileTest implements IMobileUtils, IAbstractTest {

    @Test()
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
        Assert.assertTrue(homePage.isBottomSheetIndicatorPresent(),
                "[Home Page] Bottom Sheet Indicator is not present while it should be!");
        homePage.clickBottomSheetIndicator();
//        Assert.assertFalse(homePage.isBottomSheetIndicatorPresent(),
//                "[Home Page] Bottom Sheet Indicator is present while it should not be!");
        Assert.assertTrue(homePage.isProductBoxPresent(DiscountPercent.SIXTY_PERCENT),
                String.format("[Home Page] There is no any product box with discount %s on Home Page",
                        DiscountPercent.SIXTY_PERCENT));
        ProductPageBase productPage = homePage.clickProductPageBox(DiscountPercent.SIXTY_PERCENT);
        Assert.assertTrue(productPage.isOpened(),
                "[Product Page] Product page is not opened!");
        //Thread.sleep(20000);
    }
}
