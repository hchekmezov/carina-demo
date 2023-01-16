package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    private final String name = "Welcome Page";

    @FindBy(id = "com.solvd.carinademoapplication:id/next_button")
    private ExtendedWebElement nextButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/carina_logo")
    private ExtendedWebElement carinaLogo;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return nextButton.isElementPresent() && carinaLogo.isElementPresent();
    }

    @Override
    public LoginPageBase clickNextButton() {
        nextButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public String getName() {
        return name;
    }
}
