package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.BottomNavigationBarItem;
import com.mfp.mobile.gui.pages.common.DashboardPageBase;
import com.mfp.mobile.gui.pages.common.MFPCommonPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPage extends DashboardPageBase {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"User avatar\"]")
    private ExtendedWebElement userAvatar;

    @Override
    public boolean isOpened() {

        return userAvatar.isElementPresent()
                && !(initPage(getDriver(), MFPCommonPageBase.class))
                .getBottomNavigateBar()
                .isBottomNavBarButtonClickable(BottomNavigationBarItem.DASHBOARD_BUTTON);
    }


}
