package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.PlansPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansPageBase.class)
public class PlansPage extends PlansPageBase {

    public PlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }
}
