package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.mfp.mobile.gui.pages.common.PreviewPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PreviewPageBase.class)
public class PreviewPage extends PreviewPageBase {
    public PreviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.myfitnesspal.android:id/imageLogo")
    private ExtendedWebElement logo;

    @FindBy(id = "com.myfitnesspal.android:id/buttonSignUp")
    private ExtendedWebElement buttonSignUp;

    @FindBy(id = "com.myfitnesspal.android:id/buttonLogIn")
    private ExtendedWebElement buttonLogIn;

    @Override
    public boolean isOpened() {
        return logo.isElementPresent()
                && buttonSignUp.isElementPresent()
                && buttonLogIn.isElementPresent();
    }

    @Override
    public LogInPageBase clickLogInButton() {
        buttonLogIn.click();
        return initPage(getDriver(), LogInPageBase.class);
    }
}
