package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.ActivitiesInterestsPageBase;
import com.underarmour.mobile.pages.common.WhoDoYouShopForPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WhoDoYouShopForPageBase.class)
public class WhoDoYouShopForPage extends WhoDoYouShopForPageBase {


    @FindBy(id = "com.ua.shop:id/skip")
    private ExtendedWebElement skipButton;

    @FindBy(id = "com.ua.shop:id/recycler_view")
    private ExtendedWebElement recyclerView;

    @FindBy(id = "com.ua.shop:id/header_text")
    private ExtendedWebElement headerText;


    public WhoDoYouShopForPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return skipButton.isElementPresent() && headerText.isElementPresent()
                && headerText.getText().equals("Who Do You Shop For?");
    }

    @Override
    public ActivitiesInterestsPageBase clickSkipButton() {
        skipButton.click();
        return initPage(driver, ActivitiesInterestsPageBase.class);
    }
}
