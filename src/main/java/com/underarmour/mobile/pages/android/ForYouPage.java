package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.BottomNavigationViewItem;
import com.underarmour.mobile.pages.common.ForYouPageBase;
import com.underarmour.mobile.pages.common.UnderArmourCommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ForYouPageBase.class)
public class ForYouPage extends ForYouPageBase {

    @FindBy(id = "com.ua.shop:id/for_you_particle_effects")
    private ExtendedWebElement particleEffects;

    public ForYouPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return !initPage(driver, UnderArmourCommonPageBase.class)
                .getBottomNavigationView()
                .isItemClickable(BottomNavigationViewItem.FOR_YOU)
                && particleEffects.isElementPresent();
    }
}
