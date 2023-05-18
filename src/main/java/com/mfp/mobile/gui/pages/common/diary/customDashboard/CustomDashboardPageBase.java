package com.mfp.mobile.gui.pages.common.diary.customDashboard;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CustomDashboardPageBase extends AbstractPage {
    public CustomDashboardPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isCustomDashboardItemPresent(CustomDashboardItem item);

    public abstract AbstractPage clickCustomDashboardItem(CustomDashboardItem item);

}
