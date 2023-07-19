package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UnderArmourCommonPageBase extends AbstractPage {
    public UnderArmourCommonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BottomNavigationViewBase getBottomNavigationView();
}
