package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.DashboardPageBase;
import com.mfp.mobile.gui.pages.common.ExistingUserTutorialPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ExistingUserTutorialPageBase.class)
public class ExistingUserTutorialPage extends ExistingUserTutorialPageBase {
    public ExistingUserTutorialPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.View [@resource-id='buttonExistingUserTutorial']/android.widget.Button")
    private ExtendedWebElement closeTutorialBoxButton;

    @FindBy(xpath = "//android.view.View[@resource-id='buttonSeeTutorial']")
    private ExtendedWebElement buttonSeeTutorial;

    @Override
    public boolean isOpened() {
        return closeTutorialBoxButton.isElementPresent(20)
                && buttonSeeTutorial.isElementPresent();
    }

    @Override
    public DashboardPageBase clickCloseTutorialBoxButton() {
        closeTutorialBoxButton.click();
        return initPage(getDriver(), DashboardPageBase.class);
    }
}
