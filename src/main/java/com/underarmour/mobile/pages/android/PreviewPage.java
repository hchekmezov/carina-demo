package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.PreviewPageBase;
import com.underarmour.mobile.pages.common.WhoDoYouFollowPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PreviewPageBase.class)
public class PreviewPage extends PreviewPageBase {

    @FindBy(id = "com.ua.shop:id/recycler_view")
    private ExtendedWebElement recyclerView;

    @FindBy(id = "com.ua.shop:id/skip")
    private ExtendedWebElement skipButton;


    public PreviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return recyclerView.isElementPresent() && skipButton.isElementPresent();
    }

    @Override
    public WhoDoYouFollowPageBase clickSkipButton() {
        skipButton.click();
        return initPage(driver, WhoDoYouFollowPageBase.class);
    }
}
