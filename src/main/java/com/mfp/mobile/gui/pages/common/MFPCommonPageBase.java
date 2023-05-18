package com.mfp.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MFPCommonPageBase extends AbstractPage {
    public MFPCommonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BottomNavigationBarBase getBottomNavigateBar();

    public abstract DashboardPageBase login(String email, String password);

    public abstract boolean waitUntilSpinnerRounding();
}
