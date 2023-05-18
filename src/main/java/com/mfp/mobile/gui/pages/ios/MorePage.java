package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.MorePageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MorePageBase.class)
public class MorePage extends MorePageBase {

    public MorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }
}
