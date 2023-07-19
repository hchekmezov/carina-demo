package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.underarmour.mobile.pages.common.BottomNavigationViewBase;
import com.underarmour.mobile.pages.common.UnderArmourCommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UnderArmourCommonPageBase.class)
public class UnderArmourCommonPage extends UnderArmourCommonPageBase {

    @FindBy(id = "com.ua.shop:id/bottom_nav_view")
    private BottomNavigationView bottomNavigationView;


    public UnderArmourCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BottomNavigationViewBase getBottomNavigationView() {
        return bottomNavigationView;
    }
}
