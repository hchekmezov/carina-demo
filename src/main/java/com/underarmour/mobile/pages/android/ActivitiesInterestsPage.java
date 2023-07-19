package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.ActivitiesInterestsPageBase;
import com.underarmour.mobile.pages.common.ForYouPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ActivitiesInterestsPageBase.class)
public class ActivitiesInterestsPage extends ActivitiesInterestsPageBase {

    @FindBy(id = "com.ua.shop:id/skip")
    private ExtendedWebElement skipButton;

    @FindBy(id = "com.ua.shop:id/header_text")
    private ExtendedWebElement headerText;


    public ActivitiesInterestsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return skipButton.isElementPresent() && headerText.isElementPresent()
                && headerText.getText().equals("What Sports & Activities Interest You?");
    }

    @Override
    public ForYouPageBase clickSkipButton() {
        skipButton.click();
        return initPage(driver, ForYouPageBase.class);
    }
}
