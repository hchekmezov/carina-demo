package com.mfp.mobile.gui.pages.ios.diary.customDashboard;

import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardItem;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardPageBase;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CustomDashboardPageBase.class)
public class CustomDashboardPage extends CustomDashboardPageBase {
    public CustomDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCustomDashboardItemPresent(CustomDashboardItem item) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage clickCustomDashboardItem(CustomDashboardItem item) {
        throw new NotImplementedException();
    }
}
