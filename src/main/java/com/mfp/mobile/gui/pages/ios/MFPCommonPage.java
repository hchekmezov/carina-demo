package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.DashboardPageBase;
import com.mfp.mobile.gui.pages.common.MFPCommonPageBase;
import com.mfp.mobile.gui.pages.common.BottomNavigationBarBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MFPCommonPageBase.class)
public class MFPCommonPage extends MFPCommonPageBase {

    public MFPCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BottomNavigationBarBase getBottomNavigateBar() {
        throw new NotImplementedException();
    }

    @Override
    public DashboardPageBase login(String email, String password) {
        throw new NotImplementedException();
    }

    @Override
    public boolean waitUntilSpinnerRounding() {
        throw new NotImplementedException();
    }
}
