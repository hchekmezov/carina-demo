package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.ForYouPageBase;
import com.underarmour.mobile.pages.common.WhoDoYouFollowPageBase;
import com.underarmour.mobile.pages.common.WhoDoYouShopForPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WhoDoYouFollowPageBase.class)
public class WhoDoYouFollowPage extends WhoDoYouFollowPageBase {

    @FindBy(id = "com.ua.shop:id/skip")
    private ExtendedWebElement skipButton;

    @FindBy(id = "com.ua.shop:id/header_text")
    private ExtendedWebElement headerText;


    public WhoDoYouFollowPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return skipButton.isElementPresent() && headerText.isElementPresent()
                && headerText.getText().equals("Who Do You Follow?");
    }

    @Override
    public WhoDoYouShopForPageBase clickSkipButton() {
        skipButton.click();
        return initPage(driver, WhoDoYouShopForPageBase.class);
    }


//    @Override
//    public ForYouPageBase clickSkipButton() {
//        skipButton.click();
//        return initPage(driver, ForYouPageBase.class);
//    }
}
