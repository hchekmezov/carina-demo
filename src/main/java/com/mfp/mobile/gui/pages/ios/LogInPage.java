package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.DashboardPageBase;
import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeEmailAndPassword(String email, String password) {
        throw new NotImplementedException();
    }

    @Override
    public DashboardPageBase getDashboardPage() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLogInButtonEnabled() {
        throw new NotImplementedException();
    }
}
