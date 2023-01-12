package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/next_button")
    protected ExtendedWebElement nextBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/carina_logo")
    protected ExtendedWebElement carinaLogo;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return nextBtn.isElementPresent();
    }

    @Override
    public LoginPageBase openLoginPageByClickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}
