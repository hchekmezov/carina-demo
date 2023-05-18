package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.DashboardPageBase;
import com.mfp.mobile.gui.pages.common.ExistingUserTutorialPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ExistingUserTutorialPageBase.class)
public class ExistingUserTutorialPage extends ExistingUserTutorialPageBase {

    public ExistingUserTutorialPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public DashboardPageBase clickCloseTutorialBoxButton() {
        throw new NotImplementedException();
    }
}
