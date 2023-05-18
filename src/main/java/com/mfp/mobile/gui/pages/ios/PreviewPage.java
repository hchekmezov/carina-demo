package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.LogInPageBase;
import com.mfp.mobile.gui.pages.common.PreviewPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PreviewPageBase.class)
public class PreviewPage extends PreviewPageBase {

    public PreviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public LogInPageBase clickLogInButton() {
        throw new NotImplementedException();
    }
}
