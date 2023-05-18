package com.mfp.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ExistingUserTutorialPageBase extends AbstractPage {
    public ExistingUserTutorialPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract DashboardPageBase clickCloseTutorialBoxButton();
}
