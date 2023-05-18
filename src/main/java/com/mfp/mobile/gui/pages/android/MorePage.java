package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.BottomNavigationBarItem;
import com.mfp.mobile.gui.pages.common.MFPCommonPageBase;
import com.mfp.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MorePageBase.class)
public class MorePage extends MorePageBase {

    public MorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.myfitnesspal.android:id/image")
    private ExtendedWebElement profileImage;

    @Override
    public boolean isOpened() {
        return profileImage.isElementPresent()
                && !(initPage(getDriver(), MFPCommonPageBase.class))
                .getBottomNavigateBar()
                .isBottomNavBarButtonClickable(BottomNavigationBarItem.MORE_BUTTON);

    }
}
