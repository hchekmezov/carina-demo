package com.qaprosoft.carina.demo.myMobile.android.sideMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.SideMenuPageBase;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.CommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommonPageBase.class)
public class CommonPage extends CommonPageBase {

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private ExtendedWebElement navigateButton;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isNavigateButtonPresent() {
        return navigateButton.isElementPresent();
    }

    @Override
    public SideMenuPageBase clickNavigateButton() {
        navigateButton.click();
        return initPage(getDriver(), SideMenuPageBase.class);
    }
}
